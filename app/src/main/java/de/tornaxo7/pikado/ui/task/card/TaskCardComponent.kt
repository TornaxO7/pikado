package de.tornaxo7.pikado.ui.task.card

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.tornaxo7.pikado.ui.theme.PikadoTheme
import de.tornaxo7.pikado.ui.utils.RoundedCheckbox

@Composable
fun TaskCardComponent(
    title: String,
    projectName: String,
    dueDate: String,
    onCardClick: () -> Unit,
    onCheckboxClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TaskCardContent(
        title = title,
        projectName = projectName,
        dueDate = dueDate,
        onCardClick = onCardClick,
        onCheckboxClick = onCheckboxClick,
        modifier = modifier,
    )
}

@Composable
private fun TaskCardContent(
    title: String,
    projectName: String,
    dueDate: String,
    onCardClick: () -> Unit,
    onCheckboxClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxHeight()
        ) {
            RoundedCheckbox(
                onClick = onCheckboxClick,
                initIsChecked = false,
                modifier = Modifier
                    .size(40.dp)
                    .padding(5.dp)
            )

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 5.dp)
                    .clickable { onCardClick() }
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Row {
                    Text(
                        text = dueDate,
                    )

                    Spacer(modifier = Modifier.weight(0.1f))

                    Text(text = projectName, modifier = Modifier.padding(end = 5.dp))
                }
            }
        }
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun TaskCardComposablePreview() {
    PikadoTheme {
        TaskCardContent(
            title = "Title",
            projectName = "Project Name",
            dueDate = "Due in 69 days (nice)!",
            onCardClick = {},
            onCheckboxClick = {},
            modifier = Modifier
                .height(100.dp)
        )
    }
}