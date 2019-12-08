package com.example.myapplicationcustomfab

class Lista(titulo: String, descripcion: String, rating: Double, foto: Int) {
    var titulo: String
    var descripcion: String
    var rating: Double
    var foto: Int

    init {
        this.titulo = titulo
        this.descripcion = descripcion
        this.rating = rating
        this.foto = foto
    }
}