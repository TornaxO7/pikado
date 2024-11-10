package de.tornaxo7.pikado.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import de.tornaxo7.pikado.R
import de.tornaxo7.pikado.ui.theme.PikadoTheme

@Composable
fun HomeComponent(
    padding: PaddingValues
) {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeComponentTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.home_title),
            )
        },
        actions = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.home_search)
                )
            }

            IconButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = stringResource(
                        id = R.string.home_filter
                    )
                )
            }
        },
    )
}

@Composable
private fun HomeContent(
    padding: PaddingValues
) {

}

@Preview(showBackground = true)
@Composable
private fun HomeContentPreview() {
    PikadoTheme {
        Scaffold(
            topBar = { HomeComponentTopBar() }
        ) {
            HomeContent(it)
        }
    }
}