package de.tornaxo7.pikado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import de.tornaxo7.pikado.ui.main.PikadoComponent
import de.tornaxo7.pikado.ui.theme.PikadoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PikadoTheme {
                PikadoComponent()
            }
        }
    }
}