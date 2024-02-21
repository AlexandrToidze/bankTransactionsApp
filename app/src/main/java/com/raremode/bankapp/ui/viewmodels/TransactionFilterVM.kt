package com.raremode.bankapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.raremode.bankapp.models.TransactionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TransactionFilterVM : ViewModel() {

    data class SelectedFilterTypesState(
        val selectedFilterTypes: List<Pair<TransactionType, Boolean>> = emptyList()
    )

    private val _state = MutableStateFlow(
        SelectedFilterTypesState(
            selectedFilterTypes = listOf<Pair<TransactionType, Boolean>>().initFilterList()
        )
    )

    val state: StateFlow<SelectedFilterTypesState> = _state.asStateFlow()

    fun updateFilterByThisType(findingType: TransactionType) {
        val result = state.value.selectedFilterTypes.toMutableList()
        state.value.selectedFilterTypes.forEachIndexed { index, it ->
            if (it.first == findingType) {
                result[index] = Pair(it.first, !it.second)
            }
        }
        _state.tryEmit(
            _state.value.copy(
                selectedFilterTypes = result
            )
        )
    }

    private fun List<Pair<TransactionType, Boolean>>.initFilterList(): List<Pair<TransactionType, Boolean>> {
        val result = mutableListOf<Pair<TransactionType, Boolean>>()
        TransactionType.values().forEach {
            result.add(Pair(it, false))
        }
        return result
    }

}