package com.aiweapps.bbank.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.aiweapps.bbank.models.TransactionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TransactionFilterViewModel : ViewModel() {

    data class SelectedFilterTypesState(
        val selectedFilterTypes: List<Pair<TransactionType, Boolean>> = listOf()
    )

    private val _state = MutableStateFlow(
        SelectedFilterTypesState(
            selectedFilterTypes = initFilterList()
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

    fun clearAllFilters() {
        val result = state.value.selectedFilterTypes.toMutableList()
        state.value.selectedFilterTypes.forEachIndexed { index, pair ->
            result[index] = Pair(pair.first, false)
        }

        _state.tryEmit(
            _state.value.copy(
                selectedFilterTypes = result
            )
        )
    }

    private fun initFilterList(): List<Pair<TransactionType, Boolean>> {
        val result = mutableListOf<Pair<TransactionType, Boolean>>()
        TransactionType.values().forEach {
            result.add(Pair(it, false))
        }
        return result
    }

}