package com.example.recyclerpratica

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.UUID

class ProdutoViewModel: ViewModel() {

    var produtoItens = MutableLiveData<MutableList<ProdutoItem>>()

    init {
        produtoItens.value = mutableListOf()
    }

    fun adicionarProduto(novoProdruto: ProdutoItem){

        val list = produtoItens.value
        list!!.add(novoProdruto)
        produtoItens.postValue( list )

    }

    fun atualizarProduto( id: UUID, nome: String, desc: String, preco: String ) {

        val list = produtoItens.value
        val produto = list!!.find { it.id == id }!!
        produto.name = nome
        produto.desc = desc
        produto.preco = preco
        produtoItens.postValue( list )

    }

}