package de.tornaxo7.pikado.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import de.tornaxo7.pikado.R
import de.tornaxo7.pikado.ui.task.card.TaskCardComponent
import de.tornaxo7.pikado.ui.theme.PikadoTheme
import kotlinx.serialization.Serializable

@Serializable
object HomePage

@Composable
fun HomeComponent(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory),
) {
    val uiState by viewModel.uiState.collectAsState()

    HomeContent(
        tasks = uiState.tasks,
        modifier = modifier
    )
}

@Composable
fun HomeFloatingActionButton() {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeComponentTopBar(
    onSearchClick: () -> Unit,
    onFilterClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.home_title),
                fontSize = with(LocalDensity.current) {
                    dimensionResource(id = R.dimen.screen_title).toSp()
                }
            )
        },
        actions = {
            IconButton(
                onClick = onSearchClick
            ) {
                Icon(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.icon_size)),
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.home_search)
                )
            }

            IconButton(
                onClick = onFilterClick
            ) {
                Icon(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.icon_size)),
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
    tasks: List<TaskPreviewData>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(tasks) {
            TaskCardComponent(
                title = it.title,
                projectName = it.project,
                dueDate = it.dueDate,
                onCardClick = it.onCardClick,
                onCheckboxClick = it.onCheckboxClick,
                modifier = Modifier
                    .height(100.dp)
                    .padding(10.dp)
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun HomeContentPreview() {
    val tasks = listOf(
        TaskPreviewData(
            title = "Task 1",
            dueDate = "Tomorrow",
            project = "Ooof",
        ),
        TaskPreviewData(
            title = "Task 2",
            dueDate = "Tue 29",
            project = "Project Sus"
        ),
        TaskPreviewData(
            title = "Task 3",
            dueDate = "Wed",
            project = "Sus"
        ),
        TaskPreviewData(
            title = "Task 4",
            dueDate = "Amongus",
            project = "Project Sus"
        )
    )

    PikadoTheme {
        Scaffold(
            topBar = {
                HomeComponentTopBar(
                    onFilterClick = {},
                    onSearchClick = {}
                )
            }
        ) {
            HomeContent(
                tasks = tasks,
                modifier = Modifier.padding(it)
            )
        }
    }
}