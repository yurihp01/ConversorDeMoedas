package br.edu.ifsp.scl.conversordemoedas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import br.edu.ifsp.scl.conversordemoedas.R
import br.edu.ifsp.scl.conversordemoedas.model.AvailableCurrencies
import br.edu.ifsp.scl.conversordemoedas.viewmodel.CurrencyConverterViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Observer

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: CurrencyConverterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = CurrencyConverterViewModel(this)

        val spinner: Spinner = findViewById(R.id.spinnerOrigem)
        val spinnerDestino: Spinner = findViewById(R.id.spinnerDestino)

        viewModel.carregaSpinnerOrigem().observe(this,
            androidx.lifecycle.Observer<AvailableCurrencies> {
                ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                    arrayListOf(it.currencies.AED, it.currencies.ALL, it.currencies.AMD, it.currencies.ANG, it.currencies.ARS, it.currencies.AUD, it.currencies.BRL, it.currencies.EUR)
                ).also { adapter ->
                    // Specify the layout to use when the list of choices appears
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    // Apply the adapter to the spinner
                    spinner.adapter = adapter
                }
             })

        viewModel.carregaSpinnerDestino().observe(this,
            androidx.lifecycle.Observer<AvailableCurrencies> {
                ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                    arrayListOf(it.currencies.AED, it.currencies.ALL, it.currencies.AMD, it.currencies.ANG, it.currencies.ARS, it.currencies.AUD, it.currencies.BRL, it.currencies.EUR)
                ).also { adapter ->
                    // Specify the layout to use when the list of choices appears
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    // Apply the adapter to the spinner
                    spinnerDestino.adapter = adapter
                }
            })

        spinnerDestino.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                TODO("Not yet implemented")
            }

        }
    }

    //metodo de lista
}
