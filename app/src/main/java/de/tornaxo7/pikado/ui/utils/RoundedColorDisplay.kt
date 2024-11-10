package de.tornaxo7.pikado.ui.utils

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.tornaxo7.pikado.ui.theme.PikadoTheme

@Composable
fun RoundedColorDisplay(color: Color, modifier: Modifier = Modifier) {
    Card(
        shape = CircleShape,
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(25.dp)
                .background(color)
        ) {}
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun ColorDisplayPreview() {
    PikadoTheme {
        RoundedColorDisplay(color = Color.Green)
    }
}