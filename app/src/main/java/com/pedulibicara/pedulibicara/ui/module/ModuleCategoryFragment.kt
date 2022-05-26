package com.pedulibicara.pedulibicara.ui.module

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedulibicara.pedulibicara.R

class ModuleCategoryFragment : Fragment() {

    companion object {
        fun newInstance() = ModuleCategoryFragment()
    }

    private lateinit var viewModel: ModuleCategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_module_category, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ModuleCategoryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}