package com.example.recyclerpratica

import java.util.UUID

data class ProdutoItem(
    var name: String,
    var desc: String,
    var preco: String,
    var id: UUID = UUID.randomUUID()
)


