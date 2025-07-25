package com.ifpemoveis.weatherapp.ui

import android.Manifest
import android.content.pm.PackageManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat


import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

import androidx.compose.runtime.mutableStateOf
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings


import com.ifpemoveis.weatherapp.ui.main.MainViewModel


@Preview(showBackground = true)
@Composable
fun MapPage(viewModel : MainViewModel = MainViewModel()) {
    val modifier = Modifier
    val cityList = viewModel.cities
    val recife = LatLng(-8.05, -34.9)
    val caruaru = LatLng(-8.27, -35.98)
    val joaopessoa = LatLng(-7.12, -34.84)
    val camPosState = rememberCameraPositionState ()



    Column(
        modifier = Modifier.fillMaxSize().background(Color.Gray)
            .wrapContentSize(Alignment.Center)

    ) {
        Text(
            text = "Mapa",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )


        val context = LocalContext.current
        val hasLocationPermission by remember {
            mutableStateOf(
                ContextCompat.checkSelfPermission(context,
                    Manifest.permission.ACCESS_FINE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED
            )
        }
        GoogleMap(modifier = modifier.fillMaxSize(), onMapClick = {
            viewModel.add("Cidade@${it.latitude}:${it.longitude}", location = it) },
            cameraPositionState = camPosState,
            properties = MapProperties(isMyLocationEnabled = hasLocationPermission),
            uiSettings = MapUiSettings(myLocationButtonEnabled = true)

        ) {

            val cityList by viewModel.cities.collectAsState()
            cityList.forEach {
                if (it.location != null) {
                    Marker( state = MarkerState(position = it.location),
                        title = it.name, snippet = "${it.location}")
                }
            }


            Marker(
                state = MarkerState(position = recife),
                title = "Recife",
                snippet = "Marcador em Recife",
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)
            )
            Marker(
                state = MarkerState(position = caruaru),
                title = "Recife",
                snippet = "Marcador em Recife",
                icon = BitmapDescriptorFactory.defaultMarker(
                    BitmapDescriptorFactory.HUE_BLUE)
            )
            Marker(
                state = MarkerState(position = joaopessoa),
                title = "Recife",
                snippet = "Marcador em Recife",
                icon = BitmapDescriptorFactory.defaultMarker(
                    BitmapDescriptorFactory.HUE_BLUE)
            )


        }
}
}




