package com.example.recyclerpratica

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerpratica.databinding.ProdutoItemBinding

class ProdutoItemViewHolder(
    private val context: Context,
    private val binding: ProdutoItemBinding,
    private val clickListener: ProdutoItemClickListener

): RecyclerView.ViewHolder( binding.root ) {

    fun bindProdutoItem( produtoItem: ProdutoItem ) {

        binding.nome.text = produtoItem.name
        binding.descricao.text = produtoItem.desc
        binding.preco.text = produtoItem.preco

        binding.taskCellContainer.setOnClickListener {
            clickListener.editProdutoItem( produtoItem )
        }



    }

}