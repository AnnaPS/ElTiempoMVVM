package com.novadev.eltiempomvvm.ui.tiempo.actual

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.novadev.eltiempomvvm.R
import com.novadev.eltiempomvvm.datos.ApixuWeatherApiService
import kotlinx.android.synthetic.main.tiempo_actual_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class TiempoActualFragment : Fragment() {

    companion object {
        fun newInstance() = TiempoActualFragment()
    }

    private lateinit var viewModel: TiempoActualViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tiempo_actual_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TiempoActualViewModel::class.java)
        // TODO: Use the ViewModel

        val apiService = ApixuWeatherApiService()

        GlobalScope.launch(Dispatchers.Main){
            val tiempoActualResponse = apiService.getTiempoActual("Madrid").await()
            textView.text = tiempoActualResponse.toString()
        }
    }

}
