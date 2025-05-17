package com.example.getiruygulamas.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getiruygulamas.data.Urun
import com.example.getiruygulamas.databinding.FragmentUrunListesiBinding
import com.example.getiruygulamas.ui.adapter.UrunAdapter

class UrunListesiFragment : Fragment() {

    private lateinit var binding: FragmentUrunListesiBinding
    private val args: UrunListesiFragmentArgs by navArgs()
    private lateinit var urunListesi: ArrayList<Urun>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentUrunListesiBinding.inflate(inflater, container, false)

        binding.toolbarUrunListesi.title = args.kategori.ad

        // Örnek ürün listesi (gerçek uygulamada veriyi DB veya API'den alırsın)
        urunListesi = arrayListOf(
            Urun(1, args.kategori.id, "Elma", 5, "elma"),
            Urun(2, args.kategori.id, "Armut", 6, "armut"),
            Urun(3, args.kategori.id, "Muz", 7, "muz")
        )

        val adapter = UrunAdapter(requireContext(), urunListesi,
            sepetEkleClickListener = { urun ->
                Toast.makeText(requireContext(), "${urun.ad} sepete eklendi", Toast.LENGTH_SHORT).show()
                // Buraya sepet ekleme işlemi eklenebilir
            },
            urunClickListener = { urun ->
                val action = UrunListesiFragmentDirections.actionUrunListesiToUrunDetay(urun)
                findNavController().navigate(action)
            }
        )

        binding.recyclerUrunListesi.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerUrunListesi.adapter = adapter

        return binding.root
    }
}
