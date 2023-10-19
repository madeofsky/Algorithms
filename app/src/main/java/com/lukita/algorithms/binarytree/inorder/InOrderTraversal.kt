package com.lukita.algorithms.binarytree.inorder

import com.lukita.algorithms.binarytree.model.Node

class InOrderTraversal {
    fun <T> order(root: Node<T>?): List<Node<T>> {
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
}