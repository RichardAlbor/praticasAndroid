package com.ifpemoveis.pratica01.ui.main

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.ifpemoveis.pratica01.model.City
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class MainViewModel : ViewModel() {

//    private val _cities = getCities().toMutableStateList()
//    val cities
//        get() = _cities.toList()
//    fun remove(city: City) {
//        _cities.remove(city)
//    }

//    fun add(name: String) {
//        _cities.add(City(name = name))
//    }


    private val _cities = MutableStateFlow(getCities())
    val cities = _cities.asStateFlow()



    fun add(name: String) {
        val currentList = _cities.value.toMutableList()
        currentList.add(City(name = name, weather = "Desconhecido")) // Adicione um valor padrão para weather
        _cities.value = currentList.toList()
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

private fun generateInitialCities(): List<City> { // Mudei para privada interna na VM
    return List(20) { i ->
        City(name = "Cidade ${i + 1}") // Exemplo de clima inicial
    }
}

