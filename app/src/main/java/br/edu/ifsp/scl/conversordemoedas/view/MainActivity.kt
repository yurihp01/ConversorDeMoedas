package br.edu.ifsp.scl.conversordemoedas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import br.edu.ifsp.scl.conversordemoedas.R
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

        ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            arrayListOf(viewModel.carregaSpinnerOrigem().value)
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

    }

    //metodo de lista
}
