package com.example.snackbar.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.snackbar.R
import com.example.snackbar.`interface`.ContractMainActivity
import com.example.snackbar.domain.Usuario
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_entrada.*
import kotlinx.android.synthetic.main.tab_gastos.*
import kotlinx.android.synthetic.main.tab_home.*


class MainActivity : AppCompatActivity(), ContractMainActivity {

    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Referênciando os fragments
        val fragHome = HomeFragment.newInstance()
        val fragEntrada = EntradaFragment.newInstance()
        val fragGasto = GastosFragment.newInstance()

        //inicia com fragment entrada ativo
        supportFragmentManager.beginTransaction().apply {
            add(R.id.flFragment, fragEntrada)
            commit()
        }

        //Evento click tab Home
        tabHame.setOnClickListener{
            //Seleciona a tab home
            alterColorEntrada(R.color.colorWhite)
            alterColorHome(R.color.colorSelected)
            alterColorGasto(R.color.colorWhite)

            //coloca o fragment home na pilha
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, fragHome)
                commit()
            }
        }

        //Evento click tab Entrada
        tabEntrada.setOnClickListener{
            //Seleciona a tab entrada
            alterColorEntrada(R.color.colorSelected)
            alterColorHome(R.color.colorWhite)
            alterColorGasto(R.color.colorWhite)

            //coloca o fragment entrada na pilha
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, fragEntrada)
                commit()
            }
        }

        //Evento click tab Gastos
        tabGastos.setOnClickListener{
            //Seleciona a tab gastos
            alterColorEntrada(R.color.colorWhite)
            alterColorHome(R.color.colorWhite)
            alterColorGasto(R.color.colorSelected)

            //coloca o fragment gastos na pilha
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, fragGasto)
                commit()
            }
        }

        var usuario = intent.getSerializableExtra("key") as? Usuario
        showToast("Bem Vindo ${usuario!!.userName}")
        Log.i(TAG, usuario.toString())

        alterColorEntrada(R.color.colorSelected)
    }

    fun alterColorHome(idCor: Int){
        llLinhaTabHome.setBackgroundColor(ContextCompat.getColor(this, idCor));
        tvTabHome.setTextColor(ContextCompat.getColor(this, idCor));
        icTabHome.setColorFilter(ContextCompat.getColor(this, idCor));
    }

    fun alterColorEntrada(idCor: Int){
        llLinhaTabEntrada.setBackgroundColor(ContextCompat.getColor(this, idCor));
        tvTabEntrada.setTextColor(ContextCompat.getColor(this, idCor));
        icTabEntrada.setColorFilter(ContextCompat.getColor(this, idCor));
    }

    fun alterColorGasto(idCor: Int){
        llLinhaTabGasto.setBackgroundColor(ContextCompat.getColor(this, idCor));
        tvTabGasto.setTextColor(ContextCompat.getColor(this, idCor));
        icTabGasto.setColorFilter(ContextCompat.getColor(this, idCor));
    }

    fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun callDetailGastos(){
        val fragDetailGastos = DetailGastosFragment.newInstance("Lista De Gastos")
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragDetailGastos)
            commit()
        }
    }

}