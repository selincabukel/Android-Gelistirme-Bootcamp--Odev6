package com.example.getiruygulamas.ui.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.getiruygulamas.data.Urun
import com.example.getiruygulamas.databinding.CardUrunBinding

class UrunAdapter(
    private val context: Context,
    private val urunListesi: List<Urun>,
    private val sepetEkleClickListener: (Urun) -> Unit,
    private val urunClickListener: (Urun) -> Unit
) : RecyclerView.Adapter<UrunAdapter.UrunViewHolder>() {

    inner class UrunViewHolder(val binding: CardUrunBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(urun: Urun) {
            binding.textViewUrunAd.text = urun.ad
            binding.textViewUrunFiyat.text = "${urun.fiyat} ₺"
            val resId = context.resources.getIdentifier(urun.resim, "drawable", context.packageName)
            binding.imageViewUrun.setImageResource(resId)

            // Sepete ekle butonu tıklaması
            binding.buttonSepetEkle.setOnClickListener {
                sepetEkleClickListener(urun)
            }

            // Ürüne tıklama (detay için)
            binding.root.setOnClickListener {
                urunClickListener(urun)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UrunViewHolder {
        val binding = CardUrunBinding.inflate(LayoutInflater.from(context), parent, false)
        return UrunViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UrunViewHolder, position: Int) {
        holder.bind(urunListesi[position])
    }

    override fun getItemCount() = urunListesi.size
}
