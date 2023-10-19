package com.lukita.algorithms.binarytree.utils

import com.lukita.algorithms.binarytree.model.Node

fun <T> ArrayDeque<Node<T>>.push(element: Node<T>?) = element?.let { addLast(it) }

fun <T> ArrayDeque<Node<T>>.pop() = removeLastOrNull()

fun <T> printTree(tag: String, elements: List<Node<T>>) {
    val resultList: MutableList<String> = emptyList<String>().toMutableList()
    elements.forEach { node: Node<T> ->
        resultList.add(node.value.toString())
    }
    println(tag + resultList)
}
