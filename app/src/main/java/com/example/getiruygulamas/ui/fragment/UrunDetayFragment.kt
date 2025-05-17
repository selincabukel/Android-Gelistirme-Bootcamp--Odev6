package com.example.getiruygulamas.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.getiruygulamas.databinding.FragmentUrunDetayBinding
import com.example.getiruygulamas.data.Urun

class UrunDetayFragment : Fragment() {

    private lateinit var binding: FragmentUrunDetayBinding
    private val args: UrunDetayFragmentArgs by navArgs() // Navigation component arg kullanımı

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUrunDetayBinding.inflate(inflater, container, false)

        val urun: Urun = args.urun

        // Ürün bilgilerini view'a atadım
        binding.toolbarUrunDetay.title = urun.ad
        binding.ivUrunResim.setImageResource(
            resources.getIdentifier(urun.resim, "drawable", requireContext().packageName)
        )
        binding.tvUrunFiyat.text = "${urun.fiyat} ₺"

        binding.btnSepeteEkle.setOnClickListener {
            // Sepete ekleme işlemi için buraya kod yazabilirsin
            // Örneğin Snackbar veya ViewModel üzerinden ekleme gibi
        }

        return binding.root
    }
}

