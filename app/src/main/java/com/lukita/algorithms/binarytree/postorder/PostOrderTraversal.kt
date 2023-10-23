package com.lukita.algorithms.binarytree.postorder

import com.lukita.algorithms.binarytree.model.Node

class PostOrderTraversal {
    fun <T> order(root: Node<T>?): List<Node<T>> {
        val result = mutableListOf<Node<T>>()
        extractNodesPostOrderHelper(root, result)
        return result
    }

    private fun <T> extractNodesPostOrderHelper(node: Node<T>?, result: MutableList<Node<T>>) {
        if (node != null) {
            extractNodesPostOrderHelper(node.left, result)
            extractNodesPostOrderHelper(node.right, result)
            result.add(node)
        }
    }
}