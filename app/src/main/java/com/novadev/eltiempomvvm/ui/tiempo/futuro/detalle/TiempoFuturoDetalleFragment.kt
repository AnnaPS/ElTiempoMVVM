package com.novadev.eltiempomvvm.ui.tiempo.futuro.detalle

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.novadev.eltiempomvvm.R

class TiempoFuturoDetalleFragment : Fragment() {

    companion object {
        fun newInstance() = TiempoFuturoDetalleFragment()
    }

    private lateinit var viewModel: TiempoFuturoDetalleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tiempo_futuro_detalle_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TiempoFuturoDetalleViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
