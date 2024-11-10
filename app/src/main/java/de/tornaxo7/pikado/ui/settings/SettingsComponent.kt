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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.tornaxo7.pikado.R
import de.tornaxo7.pikado.ui.theme.PikadoTheme

@Composable
fun SettingsComponent() {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsTopBar() {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = R.string.settings_title)) }
    )
}

@Composable
private fun SettingsContent(
    profileData: ProfileData,
    modifier: Modifier = Modifier,
    projectList: List<String>,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        UserProfileComponent(profileData = profileData)
        GeneralSettings(projectList)
    }
}

@Composable
private fun UserProfileComponent(
    profileData: ProfileData
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
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

@Composable
private fun GeneralSettings(
    projectList: List<String>,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Column {
            SelectHomeProjectComponent(
                projectList = projectList
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SelectHomeProjectComponent(
    projectList: List<String>,
) {
    var selectedProject by remember { mutableStateOf(projectList.first()) }
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = stringResource(id = R.string.settings_set_home_project),
            modifier = Modifier
                .padding(5.dp)
        )
        Text(
            text = stringResource(id = R.string.settings_set_home_project),
            modifier = Modifier
                .padding(5.dp)
        )

        ExposedDropdownMenuBox(
            expanded = true,
            onExpandedChange = {
                expanded = !expanded
            },
            modifier = Modifier.padding(5.dp)
        ) {
            TextField(
                value = selectedProject,
                onValueChange = { },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                readOnly = true,
                modifier = Modifier.menuAnchor(MenuAnchorType.PrimaryEditable, true)
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                projectList.forEach {
                    DropdownMenuItem(
                        text = { Text(text = it) },
                        onClick = {
                            selectedProject = it
                        }
                    )
                }
            }
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun SettingsContentPreview() {
    val profileData = ProfileData(
        username = "tornax",
        serverUrl = "http://localhost"
    )

    val projects = listOf("Project 1", "Project 2", "Project 3")

    PikadoTheme {
        Scaffold(
            topBar = { SettingsTopBar() }
        ) {
            SettingsContent(
                profileData = profileData,
                modifier = Modifier.padding(it),
                projects
            )
        }
    }
}