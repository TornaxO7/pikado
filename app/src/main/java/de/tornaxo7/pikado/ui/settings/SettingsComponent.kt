package de.tornaxo7.pikado.ui.settings

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.tornaxo7.pikado.R
import de.tornaxo7.pikado.ui.theme.PikadoTheme

@Composable
fun SettingsComponent() {

}

@Composable
private fun SettingsContent(
    profileData: ProfileData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        imageVector = Icons.Default.Person,
                        contentDescription = stringResource(id = R.string.settings_profile_picture),
                        modifier = Modifier
                            .size(110.dp)
                            .padding(5.dp)
                    )

                    Column {
                        Column(
                            modifier = Modifier
                                .padding(5.dp)
                        ) {
                            Row {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = stringResource(
                                        id = R.string.settings_username
                                    ),
                                    modifier = Modifier.padding(end = 5.dp)
                                )
                                Text(text = profileData.username, maxLines = 16)
                            }
                            Row {
                                Icon(
                                    painter = painterResource(id = R.drawable.server),
                                    contentDescription = stringResource(id = R.string.settings_server_url),
                                    modifier = Modifier.padding(end = 5.dp)
                                )
                                Text(text = profileData.serverUrl, maxLines = 1)
                            }
                        }
                    }
                }

                Row {
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .weight(0.1f)
                            .padding(5.dp)
                    ) {
                        Text(text = stringResource(id = R.string.settings_switch_user))
                    }

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .weight(0.1f)
                            .padding(5.dp)
                    ) {
                        Text(text = stringResource(id = R.string.settings_logout))
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsTopBar() {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = R.string.settings_title)) }
    )
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun SettingsContentPreview() {
    val profileData = ProfileData(
        username = "tornax",
        serverUrl = "http://localhost"
    )

    PikadoTheme {
        Scaffold(
            topBar = { SettingsTopBar() }
        ) {
            SettingsContent(
                profileData = profileData,
                modifier = Modifier.padding(it)
            )
        }
    }
}