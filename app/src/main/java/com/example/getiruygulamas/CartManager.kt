package com.example.getiruygulamas

import com.example.getiruygulamas.data.CartItem
import com.example.getiruygulamas.data.Urun

class CartManager {
    private val cartItems = mutableListOf<CartItem>()

    fun addToCart(urun: Urun) {
        val existingItem = cartItems.find { it.urun.id == urun.id }
        if (existingItem != null) {
            existingItem.miktar++
        } else {
            cartItems.add(CartItem(urun, 1))
        }
    }

    fun removeFromCart(urun: Urun) {
        val existingItem = cartItems.find { it.urun.id == urun.id }
        if (existingItem != null) {
            existingItem.miktar--
            if (existingItem.miktar <= 0) {
                cartItems.remove(existingItem)
            }
        }
    }

    fun getTotalPrice(): Int {
        return cartItems.sumOf { it.urun.fiyat * it.miktar }
    }

    fun clearCart() {
        cartItems.clear()
    }

    fun getCartItems(): List<CartItem> = cartItems
}
