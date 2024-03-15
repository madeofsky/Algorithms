package com.lukita.algorithms

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.lukita.algorithms.binarytree.BinaryTree
import com.lukita.algorithms.databinding.ActivityMainBinding
import com.lukita.algorithms.lrucache.LRUCacheSimplifiedKotlin

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.N)
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

        binding.buttonLruCache.setOnClickListener {
            val lruObject = LRUCacheSimplifiedKotlin(2)
            lruObject.put(1,1)
            lruObject.put(2,2)
            lruObject.get(1)
            lruObject.put(3,3)
        }
    }
}