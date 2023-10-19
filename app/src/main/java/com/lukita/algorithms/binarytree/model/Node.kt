package com.lukita.algorithms.binarytree.model

data class Node<T>(
    var variable: T,
    var left: Node<T>? = null,
    var right: Node<T>? = null
)