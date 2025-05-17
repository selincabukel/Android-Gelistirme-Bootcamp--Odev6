package com.example.getiruygulamas.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.getiruygulamas.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
            binding = FragmentProfileBinding.inflate(inflater, container, false)

            binding.tvName.text = "Ahmet Yılmaz"
            binding.tvEmail.text = "ahmet@example.com"
            binding.tvAddress.text = "İstanbul, Türkiye"

        return binding.root
        }
    }
