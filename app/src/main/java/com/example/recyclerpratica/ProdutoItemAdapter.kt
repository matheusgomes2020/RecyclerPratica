package com.example.recyclerpratica

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerpratica.databinding.ProdutoItemBinding

class ProdutoItemAdapter(
    private val listaProdutos: List<ProdutoItem>,
    private val clickListener: ProdutoItemClickListener
): RecyclerView.Adapter<ProdutoItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoItemViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = ProdutoItemBinding.inflate(from, parent, false)
        return ProdutoItemViewHolder(parent.context, binding, clickListener)
    }

    override fun onBindViewHolder(holder: ProdutoItemViewHolder, position: Int) {
        holder.bindProdutoItem(listaProdutos[position])
    }

    override fun getItemCount(): Int = listaProdutos.size
}