package com.example.labwork4.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.labwork4.component.ItemOfRecyclerView

class NumberViewDialog ( private val component: ItemOfRecyclerView
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Num")
            .setMessage("You have chosen number: ${component.numericValue}")
            .setPositiveButton("Ok", null)
            .create()
    }

}