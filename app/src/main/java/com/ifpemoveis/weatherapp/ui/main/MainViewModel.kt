package com.ifpemoveis.weatherapp.ui.main

import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import com.ifpemoveis.weatherapp.model.City
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class MainViewModel : ViewModel() {




    private val _cities = MutableStateFlow(getCities())
    val cities = _cities.asStateFlow()



    fun add(name: String, location: LatLng? = null) {
        val currentList = _cities.value.toMutableList()
        currentList.add(City(name = name, location = location))
        _cities.value = currentList
    }



    fun remove(city: City) {
        // Crie uma nova lista para atualizar o StateFlow, garantindo que o Compose veja a mudança de referência
        val currentList = _cities.value.toMutableList()
        currentList.remove(city)
        _cities.value = currentList.toList() // Emita a nova lista para o StateFlow
    }



}

// Função interna para gerar a lista inicial de cidades
private fun getCities(): List<City> {
    return List(20) { i ->
        City(name = "Cidade ${i + 1}")
    }
}


