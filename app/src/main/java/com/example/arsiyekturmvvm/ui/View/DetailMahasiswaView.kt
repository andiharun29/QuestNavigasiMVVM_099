package com.example.arsiyekturmvvm.ui.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.arsiyekturmvvm.model.DataMahasiswa

@Composable
fun DetailMahasiswaView(
    modifier: Modifier = Modifier,
    uiStateMahasiswa: DataMahasiswa,
    onBackButton: () -> Unit
){
    val listDataMhs = listOf(
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("Gender", uiStateMahasiswa.gender),
        Pair("email", uiStateMahasiswa.email),
        Pair("Alamat", uiStateMahasiswa.alamat),
        Pair("no HP", uiStateMahasiswa.noHP),
        Pair("NIM", uiStateMahasiswa.NIM),
    )
    Column (){
        listDataMhs.forEach { items ->
            CardSection(
                judulParam = items.first,
                isiparam = items.second
            )
        }

    }


}

@Composable
fun CardSection(judulParam:String, isiparam:String) {
    Column(horizontalAlignment = Alignment.Start) {

        Spacer(Modifier.padding(5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp)
                .padding(start = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = judulParam,
                modifier = Modifier.weight(0.9f)
            )
            Text(
                text = ":",
                modifier = Modifier.weight(0.2f)
            )
            Text(
                text = "$isiparam",
                modifier = Modifier.weight(2f)
            )
        }
    }
}