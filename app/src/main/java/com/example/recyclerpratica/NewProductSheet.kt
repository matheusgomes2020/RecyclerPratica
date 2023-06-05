package com.example.recyclerpratica

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerpratica.databinding.FragmentNewProductSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewProductSheet( var produtoItem: ProdutoItem? ) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewProductSheetBinding
    private lateinit var produtoViewModel: ProdutoViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if ( produtoItem != null ) {

            binding.taskTitle.text = "Editar Produto"
            binding.botaoCadastrar.text = "Editar"
            val editable = Editable.Factory.getInstance()
            binding.nome.text = editable.newEditable( produtoItem!!.name )
            binding.descricao.text = editable.newEditable( produtoItem!!.desc )
            binding.preco.text = editable.newEditable( produtoItem!!.preco )

        } else {

            binding.taskTitle.text = "Cadastrar Produto"

        }

        produtoViewModel = ViewModelProvider(activity).get(ProdutoViewModel::class.java)
        binding.botaoCadastrar.setOnClickListener {

            salvarOuAtualizarProduto()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNewProductSheetBinding.inflate( inflater, container, false )
        return binding.root
    }

    private fun salvarOuAtualizarProduto() {

        val nome = binding.nome.text.toString()
        val descricao = binding.descricao.text.toString()
        val preco = binding.preco.text.toString()

        if ( produtoItem == null ) {

            val novoProduto = ProdutoItem( nome, descricao, preco )
            produtoViewModel.adicionarProduto( novoProduto )

        } else {

            produtoViewModel.atualizarProduto( produtoItem!!.id, nome, descricao, preco )

        }

        binding.nome.setText("")
        binding.descricao.setText("")
        binding.preco.setText("")
        dismiss()

    }

}