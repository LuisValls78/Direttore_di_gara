package com.luisvalls.direttoredigara.data

data class Marcador(
    val latitude: Double,
    var longitude: Double,
    var name: String,
    var description: String

) {
    constructor() : this(0.0,0.0,"","")
}

