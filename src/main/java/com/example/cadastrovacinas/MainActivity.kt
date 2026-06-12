package com.example.cadastrovacinas // ATENÇÃO: Deixe aqui o "package" original que já veio no seu arquivo!

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                TelaCadastroVacinas()
            }
        }
    }
}

@Composable
fun TelaCadastroVacinas() {
    var nomeVacina by remember { mutableStateOf("") }
    var loteVacina by remember { mutableStateOf("") }
    var dataVacina by remember { mutableStateOf("") }

    val listaVacinas = remember { mutableStateListOf<Vacina>() }
    var contadorId by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = nomeVacina,
            onValueChange = { nomeVacina = it },
            label = { Text("Nome da Vacina") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = loteVacina,
            onValueChange = { loteVacina = it },
            label = { Text("Lote") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = dataVacina,
            onValueChange = { dataVacina = it },
            label = { Text("Data da Aplicação (DD/MM/AAAA)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (nomeVacina.isNotBlank() && loteVacina.isNotBlank() && dataVacina.isNotBlank()) {
                    val novaVacina = Vacina(contadorId++, nomeVacina, loteVacina, dataVacina)
                    listaVacinas.add(novaVacina)
                    nomeVacina = ""
                    loteVacina = ""
                    dataVacina = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cadastrar Vacina")
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Vacinas Registradas:", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(listaVacinas) { vacina ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(text = "Vacina: ${vacina.nome}", style = MaterialTheme.typography.bodyLarge)
                        Text(text = "Lote: ${vacina.lote} | Data: ${vacina.data}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}

// Modelo de dados estruturado no final do arquivo
data class Vacina(
    val id: Int,
    val nome: String,
    val lote: String,
    val data: String
)