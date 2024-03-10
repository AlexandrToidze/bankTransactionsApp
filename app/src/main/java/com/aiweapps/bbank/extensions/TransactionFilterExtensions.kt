package com.aiweapps.bbank.extensions

import android.util.Log
import com.aiweapps.bbank.models.TransactionType

fun List<Pair<TransactionType, Boolean>>.isFilterByThisType(findingType: TransactionType): Boolean {
    var isFoundThisType = false
    this.forEach {
        if (it.first == findingType) {
            isFoundThisType = it.second
            return@forEach
        }
    }
    return isFoundThisType
}

fun List<Pair<TransactionType, Boolean>>.updateFilterByThisType(findingType: TransactionType): List<Pair<TransactionType, Boolean>> {
    val result = this.toMutableList()
    this.forEachIndexed { index, it ->
        if (it.first == findingType) {
            result[index] = Pair(it.first, !it.second)
            Log.d("SelectedFilterTypes", "founded ${it.first} and changed value to ${result[index].second}")
        }
    }
    return result
}

fun List<Pair<TransactionType, Boolean>>.initFilterList(): List<Pair<TransactionType, Boolean>> {
    val result = mutableListOf<Pair<TransactionType, Boolean>>()
    TransactionType.values().forEach {
        result.add(Pair(it, false))
    }
    return result
}