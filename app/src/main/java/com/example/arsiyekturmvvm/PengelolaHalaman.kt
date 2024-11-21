package com.example.arsiyekturmvvm

import android.provider.ContactsContract.Data
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.arsiyekturmvvm.model.DataMahasiswa
import com.example.arsiyekturmvvm.model.JenisKelamin
import com.example.arsiyekturmvvm.ui.View.DetailMahasiswaView
import com.example.arsiyekturmvvm.ui.View.FormMahasiswaView
import com.example.arsiyekturmvvm.ui.Viewmodel.MAhasiswaViewMOdel


enum class Halaman {
    Formulir,
    Detail,
}

@Composable
fun Navigasi(
    modifier: Modifier = Modifier,
    NavController: NavHostController = rememberNavController(),
    viewModel: MAhasiswaViewMOdel = viewModel()
) {
    Scaffold { isipadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            modifier = modifier.padding(isipadding),
            navController = NavController, startDestination = Halaman.Formulir.name
        ) {
            composable(route = Halaman.Formulir.name) {
                val konteks = LocalContext.current
                FormMahasiswaView(
                    listJK = JenisKelamin.listJK.map { isi ->
                        konteks.resources.getString(isi)
                    },
                    onSubmitClicked = {
                        viewModel.saveDataMahasiswa(it)
                        NavController.navigate(Halaman.Detail.name)
                    }
                )
            }
            composable(route = Halaman.Detail.name) {
                DetailMahasiswaView(modifier = Modifier,
                    uiStateMahasiswa = uiState,
                    onBackButton = {
                        NavController.popBackStack()
                    }
                )
            }
        }
    }
}