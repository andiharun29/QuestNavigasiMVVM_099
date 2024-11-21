package com.example.arsiyekturmvvm.ui.Viewmodel

import androidx.lifecycle.ViewModel
import com.example.arsiyekturmvvm.model.DataMahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MAhasiswaViewMOdel : ViewModel() {
    //request
    private val _uiState = MutableStateFlow(DataMahasiswa())
    val uiState: StateFlow<DataMahasiswa> = _uiState.asStateFlow()

    fun saveDataMahasiswa(listDM: List<String>){
        _uiState.update { dataMhs ->
            dataMhs.copy(
                nama = listDM[0],
                gender = listDM[1],
                email = listDM[2],
                alamat = listDM[3],
                noHP = listDM[4],
                NIM = listDM[5],
                )
        }

    }
}