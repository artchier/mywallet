package com.example.snackbar.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.snackbar.R
import com.example.snackbar.`interface`.ContractMainActivity
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var cma: ContractMainActivity

    //btnEntradas
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_home, container, false)

        view.btnEntradas.setOnClickListener {
            cma.callDetailGastos()
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is ContractMainActivity) cma = context
    }

    companion object{
        fun newInstance() = HomeFragment()
    }
}