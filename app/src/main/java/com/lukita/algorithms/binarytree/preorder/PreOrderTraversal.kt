package com.lukita.algorithms.binarytree.preorder

import com.lukita.algorithms.binarytree.model.Node
import com.lukita.algorithms.binarytree.utils.pop
import com.lukita.algorithms.binarytree.utils.push

class PreOrderTraversal {
    // Reads the Tree from left to right, going all the way to the depth of the left tree before moving laterally.
    // We create a stack to read all the values. In a stack, the last to be pushed in the stack will be the first to be popped from it,
    // That is why we first push the right node to the stack and then the left node. This way, we guarantee that all left node values
    // will be popped first, and then, the right node values.
    // If done recursively, we don't need to create a stack, as the system already does it
    // This Algorithm complexity is O(n)
    fun <T> order(root: Node<T>?): List<Node<T>> {
        val result = mutableListOf<Node<T>>()
        val stack: ArrayDeque<Node<T>> = ArrayDeque()

        if (root != null) {
            stack.push(root)
        }

        while (stack.isNotEmpty()) {
            val node = stack.pop()

            if (node != null) {
                result.add(node)
                stack.push(node.right) // Push the right child first. First to enter on the stack. Will be executed last
                stack.push(node.left)  // Push the left child second. Last to enter on the stack. Will be executed first until all elements on left node are read
            }
        }

        return result
    }

    // Recursive approach. Not needed to create a stack manually as the system handles it.
    fun <T> orderRecursive(root: Node<T>?): List<Node<T>> {
        if (root == null) return emptyList()

        val leftValues = orderRecursive(root.left) // [b, d, e]
        val rightValues = orderRecursive(root.right) // [c, f]

        return listOf(root) + leftValues + rightValues // [a, b, d, e, c, f]
    }
}