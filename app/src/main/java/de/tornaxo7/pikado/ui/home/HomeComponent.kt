package de.tornaxo7.pikado.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeComponent(
    padding: PaddingValues
) {

}

@Composable
fun HomeComponentTopBar() {

}

@Composable
private fun HomeContent(
    padding: PaddingValues
) {

}

@Preview(showBackground = true)
@Composable
private fun HomeContentPreview() {
    Scaffold(
        topBar = { HomeComponentTopBar()}
    ){
        HomeContent(it)
    }
}