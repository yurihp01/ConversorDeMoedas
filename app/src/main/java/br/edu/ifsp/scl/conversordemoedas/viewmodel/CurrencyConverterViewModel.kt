package br.edu.ifsp.scl.conversordemoedas.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.ifsp.scl.conversordemoedas.model.AvailableCurrencies
import br.edu.ifsp.scl.conversordemoedas.model.CurrencyConverterService

class CurrencyConverterViewModel (context: Context): ViewModel() {
    private val model = CurrencyConverterService(context)

    fun carregaSpinnerOrigem(): MutableLiveData<AvailableCurrencies> {
        return model.listaMoeda()
    }

    fun carregaSpinnerDestino(): MutableLiveData<AvailableCurrencies> {
        return model.listaMoeda()
    }
}