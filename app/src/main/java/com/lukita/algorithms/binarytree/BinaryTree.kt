package com.lukita.algorithms.binarytree

import com.lukita.algorithms.binarytree.inorder.InOrderTraversal
import com.lukita.algorithms.binarytree.model.Node
import com.lukita.algorithms.binarytree.postorder.PostOrderTraversal
import com.lukita.algorithms.binarytree.preorder.PreOrderTraversal
import com.lukita.algorithms.binarytree.utils.printTree

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
           /   \            postOrder: D, E, B, F, C, A
          b     c           preOrder: A, B, D, E, C, F
        /   \    \
       d     e    f

     */

    fun <T>create(elementsList: List<T>? = null) {
        val balancedTree = createBalancedBinaryTree(elementsList)

        println(TREE_ELEMENTS + elementsList)

        printTree(IN_ORDER_ELEMENTS, InOrderTraversal().order(balancedTree))

        printTree(POST_ORDER_ELEMENTS, PostOrderTraversal().order(balancedTree))

        printTree(PRE_ORDER_ELEMENTS, PreOrderTraversal().order(balancedTree))

        invertBinaryTree(balancedTree)
        println(INVERTED_TREE + balancedTree)
    }

    private fun <T>createBalancedBinaryTree(sortedList: List<T>?) : Node<T>? {
        if (sortedList == null) return null

        val startIndex = 0
        val endIndex = sortedList.size - 1
        if (startIndex > endIndex) return null

        val midIndex = (startIndex + endIndex) / 2
        val treeRoot = Node(sortedList[midIndex]) // Setting the root of the tree the middle of a given list to make it balanced. This list has to be sorted

        val leftElements = sortedList.subList(0, midIndex)
        val rightElements = sortedList.subList(midIndex + 1, sortedList.size)

        treeRoot.left = createBalancedBinaryTree(leftElements)
        treeRoot.right = createBalancedBinaryTree(rightElements)

        return treeRoot
    }

    private fun <T>invertBinaryTree(root: Node<T>?) {
        if (root == null) return

        val temp = root.left
        root.left = root.right
        root.right = temp

        invertBinaryTree(root.left)
        invertBinaryTree(root.right)
    }

    companion object {
        private const val TREE_ELEMENTS = "Tree Elements - "
        private const val PRE_ORDER_ELEMENTS = "Pre Order values - "
        private const val PRE_ORDER_RECURSIVE_ELEMENTS = "Pre Order recursive values - "
        private const val IN_ORDER_ELEMENTS = "In Order values - "
        private const val POST_ORDER_ELEMENTS = "Post Order values - "
        private const val INVERTED_TREE = "Inverted Tree - "
    }
}