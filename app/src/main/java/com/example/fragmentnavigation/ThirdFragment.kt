package com.example.fragmentnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class ThirdFragment : Fragment(R.layout.fragment_third) {
    private val defaultFirst = "lukaku"
    private val defaultLast = "chanukkvadze"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        if (arguments != null) {
            val firstName = arguments?.getString("firstName", defaultFirst)
            val lastName = arguments?.getString("lastName", defaultLast)

            updateLabel(view, firstName!!, lastName!!)
        } else {
            updateLabel(view, defaultFirst, defaultLast)
        }

        view?.findViewById<Button>(R.id.btnThird)?.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
        }

        return view
    }

    private fun updateLabel(view: View?, firstName: String, lastName: String) {
        val label = "User: %s %s".format(firstName, lastName)
        view?.findViewById<TextView>(R.id.titlee)?.text = label
    }
}
