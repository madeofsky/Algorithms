package com.lukita.algorithms.lrucache

import android.os.Build
import androidx.annotation.RequiresApi

class LRUCacheSimplifiedKotlin(private val capacity: Int) {

    private val cache = LinkedHashMap<Int, Int>(capacity, 1f, true)

    @RequiresApi(Build.VERSION_CODES.N)
    fun get(key: Int): Int {
        return cache.getOrDefault(key, -1)
    }

    fun put(key: Int, value: Int) {
        cache[key] = value
        if (cache.size > capacity) {
            cache.entries.iterator().next().apply {
                cache.remove(this.key)
            }
        }
    }
}

class LRUCacheKotlin(private val capacity: Int) {

    private val cache: MutableMap<Int, Int> = HashMap(capacity)
    private val accessOrder: MutableList<Int> = ArrayList()

    fun get(key: Int): Int {
        val value = cache[key]

        return if (value != null) {
            updateAccessOrder(key)
            value
        } else {
            -1
        }
    }

    fun put(key: Int, value: Int) {
        //If the key is on cache already, then we just update the order
        if (cache.contains(key)) {
            updateAccessOrder(key)
        } else {
            if (cache.size >= capacity) {
                //Removing the index 0 of the list. As we always update the order sending the most recent to the end of the list,
                //then, the least recent will be on the start of the list
                val leastRecentlyUsed = accessOrder.removeAt(0)
                cache.remove(leastRecentlyUsed)
            }
            accessOrder.add(key)
        }
        //It will always put a value, not matter what. We gotta find room to it
        cache[key] = value
    }

    //To guarantee access order, we remove it from the list and add it again, so it will be on the end of the list
    private fun updateAccessOrder(key: Int) {
        // Remove the key-value pair from the access order
        accessOrder.remove(key)
        // Add the key-value pair to the end of the access order
        accessOrder.add(key)
    }
}

class LRUCacheWithPairKotlin(private val capacity: Int) {

    private val cache: MutableMap<Int, Int> = HashMap(capacity)
    private val accessOrder: MutableList<Pair<Int, Int>> = ArrayList()

    fun get(key: Int): Int {
        val value = cache[key]

        return if (value != null) {
            updateAccessOrder(key, value)
            value
        } else {
            -1
        }
    }

    fun put(key: Int, value: Int) {
        //If the key is on cache already, then we just update the order
        if (cache.contains(key)) {
            updateAccessOrder(key, value)
        } else {
            if (cache.size >= capacity) {
                //Removing the index 0 of the list. As we always update the order sending the most recent to the end of the list,
                //then, the least recent will be on the start of the list
                val leastRecentlyUsed = accessOrder.removeAt(0)
                cache.remove(leastRecentlyUsed.first)
            }
            accessOrder.add(key to value)
        }
        //It will always put a value, not matter what. We gotta find room to it
        cache[key] = value
    }

    //To guarantee access order, we remove it from the list and add it again, so it will be on the end of the list
    private fun updateAccessOrder(key: Int, value: Int) {
        // Remove the key-value pair from the access order
        accessOrder.removeAll { it.first == key }
        // Add the key-value pair to the end of the access order
        accessOrder.add(key to value)
    }
}