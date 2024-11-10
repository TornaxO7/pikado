package de.tornaxo7.pikado.ui.projects

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.tornaxo7.pikado.R
import de.tornaxo7.pikado.ui.theme.PikadoTheme
import de.tornaxo7.pikado.ui.utils.ProjectCard

@Composable
fun ProjectsComponent() {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectsTopAppBar(
    title: String,
) {
    CenterAlignedTopAppBar(
        title = { Text(text = title, fontSize = 30.sp) },
    )
}

@Composable
fun ProjectsFloatingActionButton() {
    FloatingActionButton(
        onClick = {}
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(id = R.string.projects_add_project)
        )
    }
}

@Composable
private fun ProjectsContent(
    modifier: Modifier,
    projects: List<ProjectDisplay>,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(projects) {
            ProjectCard(
                title = it.name,
                color = it.color,
                onClick = {},
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(10.dp)
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun ProjectContentPreview() {
    val projects = listOf(
        ProjectDisplay("Project 1", Color.Green),
        ProjectDisplay("Project 2", Color.Blue),
        ProjectDisplay("Project 3", Color.Red),
        ProjectDisplay("Project 4", Color.Yellow)
    )

    PikadoTheme {
        Scaffold(
            topBar = {
                ProjectsTopAppBar(title = stringResource(id = R.string.projects_title))
            },
            floatingActionButton = { ProjectsFloatingActionButton() }
        ) {
            ProjectsContent(
                modifier = Modifier.padding(it),
                projects
            )
        }
    }
}