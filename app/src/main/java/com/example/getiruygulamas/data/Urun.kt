package com.example.getiruygulamas.data

import java.io.Serializable

data class Urun(
    var id: Int,
    var kategoriId: Int,
    var ad: String,
    var fiyat: Int,
    var resim: String
) : Serializable
