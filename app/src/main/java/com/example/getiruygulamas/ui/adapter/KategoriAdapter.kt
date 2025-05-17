package com.example.getiruygulamas.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.getiruygulamas.data.Kategori
import com.example.getiruygulamas.databinding.CardKategoriBinding

class KategoriAdapter(
    private val context: Context,
    private val kategoriListesi: List<Kategori>,
    private val itemClickListener: (Kategori, android.view.View) -> Unit
) : RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder>() {

    inner class KategoriViewHolder(val binding: CardKategoriBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(kategori: Kategori) {
            val resId = context.resources.getIdentifier(kategori.resim, "drawable", context.packageName)
            binding.imageViewKategori.setImageResource(resId)
            binding.root.setOnClickListener {
                itemClickListener(kategori, it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriViewHolder {
        val binding = CardKategoriBinding.inflate(LayoutInflater.from(context), parent, false)
        return KategoriViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KategoriViewHolder, position: Int) {
        holder.bind(kategoriListesi[position])
    }

    override fun getItemCount() = kategoriListesi.size
}
