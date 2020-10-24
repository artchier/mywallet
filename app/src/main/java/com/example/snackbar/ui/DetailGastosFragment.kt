package com.example.snackbar.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.snackbar.R
import com.example.snackbar.`interface`.ContractMainActivity

class DetailGastosFragment : Fragment() {

    private lateinit var cma: ContractMainActivity

    private var msg = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_detail_gastos, container, false)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ContractMainActivity) cma = context

        arguments?.getString("key")?.let{
            msg = it
        }
    }

    companion object{
        fun newInstance(msg: String) = DetailGastosFragment().apply {
            arguments = Bundle().apply {
                putString("key", msg)
            }
        }
    }

}