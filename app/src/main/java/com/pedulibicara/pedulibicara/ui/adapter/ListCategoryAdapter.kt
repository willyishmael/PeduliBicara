package com.pedulibicara.pedulibicara.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pedulibicara.pedulibicara.data.model.Category
import com.pedulibicara.pedulibicara.databinding.ModuleCardViewBinding

class ListCategoryAdapter(
    private val listCategory: List<Category>
) : RecyclerView.Adapter<ListCategoryAdapter.ViewHolder>() {

    class ViewHolder(
        var binding: ModuleCardViewBinding
        ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ModuleCardViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = listCategory[position]

        holder.binding.apply {
            Glide.with(holder.itemView.context)
                .load(category.thumbnail)
                .apply(RequestOptions().override(100, 100))
                .into(ivModuleImage)
            tvModuleTitle.text = category.title
            tvModuleDescription.text = category.description
        }
    }

    override fun getItemCount(): Int = listCategory.count()
}