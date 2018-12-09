package com.novadev.eltiempomvvm.ui.tiempo.futuro.lista

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.novadev.eltiempomvvm.R

class ListaTiempoFuturoFragment : Fragment() {

    companion object {
        fun newInstance() = ListaTiempoFuturoFragment()
    }

    private lateinit var viewModel: ListaTiempoFuturoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lista_tiempo_futuro_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListaTiempoFuturoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
