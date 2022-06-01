package com.pedulibicara.pedulibicara.ui.module

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedulibicara.pedulibicara.data.local.Data
import com.pedulibicara.pedulibicara.data.model.ModuleCategory
import com.pedulibicara.pedulibicara.databinding.FragmentModuleCategoryBinding
import com.pedulibicara.pedulibicara.ui.adapter.ModuleCategoryAdapter

@Suppress("RedundantNullableReturnType")
class ModuleCategoryFragment : Fragment() {

    companion object {
        fun newInstance() = ModuleCategoryFragment()
    }

    private lateinit var viewModel: ModuleCategoryViewModel

    private var _binding: FragmentModuleCategoryBinding? = null
    private val binding get() = _binding!!

    private val listCategory = Data.getModuleCategory()

    @Suppress("RedundantNullableReturnType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentModuleCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[ModuleCategoryViewModel::class.java]
        // TODO: Use the ViewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val mAdapter = ModuleCategoryAdapter(listCategory)

        mAdapter.setOnItemClickCallback(object : ModuleCategoryAdapter.OnItemClickCallback{
            override fun onItemClicked(moduleCategory: ModuleCategory) {

                val destination = ModuleCategoryFragmentDirections.actionModuleCategoryFragmentToModuleItemFragment()
                destination.categoryKey = moduleCategory.key
                findNavController().navigate(destination)

            }
        })

        binding.rvListCategory.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = mAdapter
        }
    }

}