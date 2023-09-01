package com.example.maravilhas_mundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.maravilhas_mundo.data.Datasource
import com.example.maravilhas_mundo.model.Dados
import com.example.maravilhas_mundo.ui.theme.Maravilhas_MundoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Maravilhas_MundoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DadosApp()
                }
            }
        }
    }
}
@Composable
fun DadosApp() {
    DadosLista(dadosLista = Datasource().loandDatas())
}

@Composable
fun DadosLista(dadosLista: List<Dados>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(dadosLista) { lista ->
            DadosCard(dados = lista)
            modifier.padding(8.dp)
        }
    }
}

@Composable
fun DadosCard(dados: Dados, modifier: Modifier = Modifier) {

    Card(modifier = Modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = dados.drawableImages),
                contentDescription = stringResource(id = dados.stringNames),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = dados.stringNames),
                modifier = Modifier
                    .padding(16.dp),
                style = MaterialTheme.typography.headlineSmall,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DadosCardPreview() {
    DadosCard(Dados(R.string.dados_1, R.drawable.cristo_redentor))
}