package com.lukita.algorithms.binarytree

import com.lukita.algorithms.binarytree.model.Node

class BinaryTree {
    /**
                                                BINARY TREE SKELETON

    - Inorder Traversal (Left-Root-Right):
    In an inorder traversal, you visit the left subtree first, then the current node, and finally the right subtree.
    For a binary search tree, an inorder traversal will visit the nodes in ascending order.

    - Preorder Traversal (Root-Left-Right):
    In a preorder traversal, you visit the current node first, then the left subtree, and finally the right subtree.

    - Postorder Traversal (Left-Right-Root):
    In a postorder traversal, you visit the left subtree first, then the right subtree, and finally the current node.

             a              inOrder: D, B, E, A, C, F
           /   \            preOrder: A, B, D, E, C, F
          b     c           postOrder: D, E, B, F, C, A
        /   \    \
       d     e    f

     */

    fun <T>createBinaryTreeGivenList(elementsList: List<T>? = null) {
        val binaryTree = createBinaryTree(elementsList)
        val nodes = inOrder(binaryTree)

        printTree(IN_ORDER_ELEMENTS, nodes)
    }

    fun createStaticABCBinaryTree() {
        a.left = b
        a.right = c
        b.left = d
        b.right = e
        c.right = f

        val binaryTreeElementsList = listOf(a, b, c, d, e, f)

        // Binary Tree Elements
        printTree(BINARY_TREE_ELEMENTS, binaryTreeElementsList)

        // Binary Tree Elements read inOrder, from left to root to right
        printTree(IN_ORDER_ELEMENTS, inOrder(binaryTreeElementsList.first()))

        // Binary Tree Elements read from the Depth left child from root
        printTree(PRE_ORDER_ELEMENTS, preOrder(binaryTreeElementsList))

        // Binary Tree Elements read recursively from the Depth left child from root
        printTree(PRE_ORDER_RECURSIVE_ELEMENTS, preOrderRecursive(binaryTreeElementsList.first()))
    }

    // Reads the Tree from left to right, going all the way to the depth of the left tree before moving laterally.
    // We create a stack to read all the values. In a stack, the last to be pushed in the stack will be the first to be popped from it,
    // That is why we first push the right node to the stack and then the left node. This way, we guarantee that all left node values
    // will be popped first, and then, the right node values.
    // If done recursively, we don't need to create a stack, as the system already does it
    // This Algorithm complexity is O(n)
    private fun <T> preOrder(values: List<Node<T>>?): List<Node<T>> {
        if (values == null) return emptyList()

        val result = mutableListOf<Node<T>>()
        val root = values.first()
        val stack: ArrayDeque<Node<T>> = ArrayDeque(1)
        stack.push(root)

        while (stack.isNotEmpty()) { // If stack is empty, then we passed through all the values
            val currentValue = stack.pop() // Remove the value from the stack and return it
            currentValue?.let { node: Node<T> ->
                result.add(node) // Adds the value from the stack to the final result list
            }

            if (currentValue?.right != null) stack.push(currentValue.right) // First to enter on the stack. Will be executed last
            if (currentValue?.left != null) stack.push(currentValue.left) // Last to enter on the stack. Will be executed first until all elements on left node are read
        }

        return result
    }

    private fun <T>createBinaryTree(sortedList: List<T>?) : Node<T>? {
        if (sortedList == null) return null

        val startIndex = 0
        val endIndex = sortedList.size - 1
        if (startIndex > endIndex) return null

        val midIndex = (startIndex + endIndex) / 2
        val treeRoot = Node(sortedList[midIndex]) // Setting the root of the tree the middle of a given list to make it balanced. This list has to be sorted

        val leftElements = sortedList.subList(0, midIndex)
        val rightElements = sortedList.subList(midIndex + 1, sortedList.size)

        treeRoot.left = createBinaryTree(leftElements)
        treeRoot.right = createBinaryTree(rightElements)

        return treeRoot
    }

    private fun <T> inOrder(root: Node<T>?): List<Node<T>> {
        val result = mutableListOf<Node<T>>()
        extractNodesInOrderHelper(root, result)
        return result
    }

    private fun <T> extractNodesInOrderHelper(node: Node<T>?, result: MutableList<Node<T>>) {
        if (node != null) {
            extractNodesInOrderHelper(node.left, result)
            result.add(node)
            extractNodesInOrderHelper(node.right, result)
        }
    }

    // Recursive approach. Not needed to create a stack manually as the system handles it.
    private fun <T> preOrderRecursive(root: Node<T>?): List<Node<T>> {
        if (root == null) return emptyList()

        val leftValues = preOrderRecursive(root.left) // [b, d, e]
        val rightValues = preOrderRecursive(root.right) // [c, f]

        return listOf(root) + leftValues + rightValues // [a, b, d, e, c, f]
    }

    private fun <T> ArrayDeque<Node<T>>.push(element: Node<T>?) = element?.let { addLast(it) }

    private fun <T> ArrayDeque<Node<T>>.pop() = removeLastOrNull()

    private fun <T> printTree(tag: String, elements: List<Node<T>>) {
        val resultList: MutableList<String> = emptyList<String>().toMutableList()
        elements.forEach { node: Node<T> ->
            resultList.add(node.variable.toString())
        }
        println(tag + resultList)
    }

    companion object {
        private const val BINARY_TREE_ELEMENTS = "Binary Tree Elements - "
        private const val PRE_ORDER_ELEMENTS = "Pre Order values - "
        private const val PRE_ORDER_RECURSIVE_ELEMENTS = "Pre Order recursive values - "

        private const val IN_ORDER_ELEMENTS = "In Order values - "

        private val a = Node(variable = "a")
        private val b = Node(variable = "b")
        private val c = Node(variable = "c")
        private val d = Node(variable = "d")
        private val e = Node(variable = "e")
        private val f = Node(variable = "f")
    }
}