package de.tornaxo7.pikado.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.tornaxo7.pikado.R
import de.tornaxo7.pikado.ui.task.card.TaskCardComponent
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
    padding: PaddingValues,
    tasks: List<TaskPreviewData>,
) {
    LazyColumn(
        modifier = Modifier
            .padding(padding)
    ) {
        items(tasks) {
            TaskCardComponent(
                title = it.title,
                projectName = it.project,
                dueDate = it.dueDate,
                onCardClick = { },
                onCheckboxClick = { },
                modifier = Modifier
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
            project = "Ooof"
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
            topBar = { HomeComponentTopBar() }
        ) {
            HomeContent(
                padding = it,
                tasks = tasks,
            )
        }
    }
}