package com.example.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

object FakeRepository {
    private val fruitNames: List<String> =
        listOf("Apple", "Banana", "Date", "Strawberry", "Grapes", "Kiwi", "Orange")

    private val _currentRandomFruitName = MutableLiveData<String>()
    val currentRandomFruitName : LiveData<String>
    get() = _currentRandomFruitName

    init {
        _currentRandomFruitName.value = fruitNames.first()
    }

    fun getRandomFruitNames(): String{
        val random = Random()
        return fruitNames[random.nextInt(fruitNames.size)]
    }

    fun changeCurrentRandomFruitName(){
        _currentRandomFruitName.value = getRandomFruitNames()
    }
}