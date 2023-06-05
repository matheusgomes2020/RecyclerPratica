package com.example.recyclerpratica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerpratica.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ProdutoItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var produtoViewModel: ProdutoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        produtoViewModel = ViewModelProvider(this).get(ProdutoViewModel::class.java)

        binding.botaoAdicionar.setOnClickListener {
            NewProductSheet(null).show(supportFragmentManager, "novoProdutoTag")
        }

        setRecyclerView()

    }

    private fun setRecyclerView() {

        val mainActivity = this
        produtoViewModel.produtoItens.observe( this ) {

            binding.recyclerPrincipal.apply {

                layoutManager = LinearLayoutManager( applicationContext )
                adapter = ProdutoItemAdapter( it, mainActivity )

            }

        }

    }

    override fun editProdutoItem(produtoItem: ProdutoItem) {

        NewProductSheet( produtoItem ).show( supportFragmentManager,  "novoProdutoTag")

    }

    override fun completeProdutoItem(produtoItem: ProdutoItem) {
        TODO("Not yet implemented")
    }

}