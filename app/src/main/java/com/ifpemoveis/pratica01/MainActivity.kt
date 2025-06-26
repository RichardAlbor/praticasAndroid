package com.ifpemoveis.pratica01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.ifpemoveis.pratica01.ui.theme.Pratica01_Theme


import com.ifpemoveis.pratica01.ui.HomePage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pratica01_Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomePage()
                }
            }
        }
    }
}


