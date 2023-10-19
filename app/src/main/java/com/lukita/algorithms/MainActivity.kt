package com.lukita.algorithms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lukita.algorithms.binarytree.BinaryTree
import com.lukita.algorithms.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBinaryTreeWithIntegers.setOnClickListener {
            val intTreeElements = listOf(30, 32, 1, 2, 6, 9, 15, 22).sorted()
            BinaryTree().create(intTreeElements)
        }

        binding.buttonBinaryTreeWithString.setOnClickListener {
            val stringTreeElements = listOf("d", "e", "b", "f", "a", "c").sorted()
            BinaryTree().create(stringTreeElements)
        }
    }
}