package com.example.getiruygulamas.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.getiruygulamas.data.Kategori
import com.example.getiruygulamas.databinding.FragmentKategoriBinding
import com.example.getiruygulamas.ui.adapter.KategoriAdapter

class KategoriFragment : Fragment() {

    private lateinit var binding: FragmentKategoriBinding
    private lateinit var kategoriListesi: ArrayList<Kategori>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentKategoriBinding.inflate(inflater, container, false)

        kategoriListesi = ArrayList()
        kategoriListesi.add(Kategori(1, "Meyve & Sebze", "meyve_sebze"))
        kategoriListesi.add(Kategori(2, "Süt Ürünleri", "sut_urunleri"))
        kategoriListesi.add(Kategori(3, "İçecekler", "icecekler"))
        // ... diğer kategoriler

        val adapter = KategoriAdapter(requireContext(), kategoriListesi) { kategori, view ->
            // Navigation Component geçişi
            val action = KategoriFragmentDirections.actionKategoriFragmentToUrunListesiFragment(kategori)
            Navigation.findNavController(view).navigate(action)
        }

        binding.recyclerKategori.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerKategori.adapter = adapter

        return binding.root
    }
}

