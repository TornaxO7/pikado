package de.tornaxo7.pikado.ui.main

import android.content.res.Configuration
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.tornaxo7.pikado.R
import de.tornaxo7.pikado.ui.home.HomeComponent
import de.tornaxo7.pikado.ui.home.HomeComponentTopBar
import de.tornaxo7.pikado.ui.home.HomeFloatingActionButton
import de.tornaxo7.pikado.ui.home.HomePage
import de.tornaxo7.pikado.ui.projects.ProjectsComponent
import de.tornaxo7.pikado.ui.projects.ProjectsFloatingActionButton
import de.tornaxo7.pikado.ui.projects.ProjectsPage
import de.tornaxo7.pikado.ui.projects.ProjectsTopAppBar
import de.tornaxo7.pikado.ui.settings.SettingsComponent
import de.tornaxo7.pikado.ui.settings.SettingsFloatingActionButton
import de.tornaxo7.pikado.ui.settings.SettingsPage
import de.tornaxo7.pikado.ui.settings.SettingsTopAppBar

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PikadoComponent(
    navController: NavHostController = rememberNavController(),
    viewModel: PikadoViewModel = viewModel(factory = PikadoViewModel.Factory)
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            when (uiState.selectedScreen) {
                PikadoScreen.Home -> HomeComponentTopBar(
                    onSearchClick = {},
                    onFilterClick = {},
                )

                PikadoScreen.Projects -> ProjectsTopAppBar()
                PikadoScreen.Settings -> SettingsTopAppBar()
            }
        },
        floatingActionButton = {
            when (uiState.selectedScreen) {
                PikadoScreen.Home -> HomeFloatingActionButton()
                PikadoScreen.Projects -> ProjectsFloatingActionButton(
                    onClick = {},
                )

                PikadoScreen.Settings -> SettingsFloatingActionButton()
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(100.dp)
            ) {
                NavigationBarItem(
                    selected = uiState.selectedScreen == PikadoScreen.Home,
                    label = {
                        Text(text = stringResource(id = R.string.home_title))
                    },
                    onClick = {
                        navController.navigate(HomePage)
                        viewModel.setScreen(PikadoScreen.Home)
                    },
                    icon = {
                        Icon(
                            modifier = Modifier
                                .size(dimensionResource(id = R.dimen.icon_size)),
                            imageVector = Icons.Default.Home, contentDescription = stringResource(
                                id = R.string.home_title
                            )
                        )
                    }
                )
                NavigationBarItem(
                    selected = uiState.selectedScreen == PikadoScreen.Projects,
                    label = {
                        Text(text = stringResource(id = R.string.projects_title))
                    },
                    onClick = {
                        navController.navigate(ProjectsPage)
                        viewModel.setScreen(PikadoScreen.Projects)
                    },
                    icon = {
                        Icon(
                            modifier = Modifier
                                .size(dimensionResource(id = R.dimen.icon_size)),
                            painter = painterResource(id = R.drawable.folder),
                            contentDescription = stringResource(
                                id = R.string.projects_title
                            )
                        )
                    }
                )
                NavigationBarItem(
                    selected = uiState.selectedScreen == PikadoScreen.Settings,
                    label = {
                        Text(text = stringResource(id = R.string.settings_title))
                    },
                    onClick = {
                        navController.navigate(SettingsPage)
                        viewModel.setScreen(PikadoScreen.Settings)
                    },
                    icon = {
                        Icon(
                            modifier = Modifier
                                .size(dimensionResource(id = R.dimen.icon_size)),
                            imageVector = Icons.Default.Settings,
                            contentDescription = stringResource(
                                id = R.string.settings_title
                            )
                        )
                    }
                )
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = HomePage,
            modifier = Modifier.padding(padding)
        ) {
            composable<HomePage> {
                HomeComponent(
                    modifier = Modifier
                        .padding(padding)
                )
            }

            composable<ProjectsPage> {
                ProjectsComponent()
            }

            composable<SettingsPage> {
                SettingsComponent()
            }
        }
    }
}