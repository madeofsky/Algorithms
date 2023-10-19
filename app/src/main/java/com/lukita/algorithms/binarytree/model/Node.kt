package com.lukita.algorithms.binarytree.model

data class Node<T>(
    var value: T,
    var left: Node<T>? = null,
    var right: Node<T>? = null
)