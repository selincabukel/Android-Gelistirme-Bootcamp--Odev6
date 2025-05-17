package com.example.getiruygulamas.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.getiruygulamas.databinding.FragmentSepetBinding

class SepetFragment : Fragment() {

    private lateinit var binding: FragmentSepetBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSepetBinding.inflate(inflater, container, false)

        // Sepete eklenen ürünler burada gösterilir (örnek olması için boş bırakıldı)
        binding.textViewSepetBos.text = "Sepetiniz şu an boş."

        return binding.root
    }
}
