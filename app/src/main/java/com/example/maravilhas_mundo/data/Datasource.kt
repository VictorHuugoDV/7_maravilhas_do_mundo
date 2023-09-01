package com.example.maravilhas_mundo.data

import com.example.maravilhas_mundo.R
import com.example.maravilhas_mundo.model.Dados

class Datasource {
    fun loandDatas():List<Dados>{
        return listOf<Dados>(
            Dados(R.string.dados_1,R.drawable.cristo_redentor),
            Dados(R.string.dados_2,R.drawable.grande_muralha_china),
            Dados(R.string.dados_3,R.drawable.cidade_petra),
            Dados(R.string.dados_4,R.drawable.coliseu),
            Dados(R.string.dados_5,R.drawable.chichen_itza),
            Dados(R.string.dados_6,R.drawable.machu_picchu),
            Dados(R.string.dados_7,R.drawable.__taj_mahal)
        )
    }
}