package com.example.arsiyekturmvvm.ui.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.arsiyekturmvvm.model.DataMahasiswa


@Composable
fun FormMahasiswaView(
    modifier: Modifier = Modifier,
    listJK: List<String>,
    onSubmitClicked: (MutableList<String>)-> Unit
){
    var nama by rememberSaveable { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHP by remember { mutableStateOf("") }
    var SelectedGender by remember { mutableStateOf("") }
    var NIM by remember { mutableStateOf("") }


    val dataMahasiswa: MutableList<String> = mutableListOf(nama, SelectedGender, alamat, email, noHP, NIM)


    Column (modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        OutlinedTextField(
            value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("masukkan nama")
            }, label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        Row () {
            listJK.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = SelectedGender == item,
                        onClick = {
                            SelectedGender = item
                        })
                    Text(item)
                }
            }
        }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = {
                Text("masukkan email")
            }, label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = { alamat = it },
            placeholder = {
                Text("masukkan alamat")
            }, label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = noHP,
            onValueChange = { noHP = it },
            placeholder = {
                Text("masukkan no HP")
            }, label = { Text("no HP") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = NIM,
            onValueChange = { NIM = it },
            placeholder = {
                Text("masukkan NIM")
            }, label = { Text("NIM") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Button(onClick = { onSubmitClicked(dataMahasiswa) })
        {
            Text("simpan")
        }
    }
}


