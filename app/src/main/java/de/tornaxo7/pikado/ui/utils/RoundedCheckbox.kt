package de.tornaxo7.pikado.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.tornaxo7.pikado.R

// Inspired by https://stackoverflow.com/a/71236536/11035194
@Composable
fun RoundedCheckbox(
    onClick: () -> Unit,
    initIsChecked: Boolean = false,
    modifier: Modifier = Modifier,
) {
    var isChecked by remember { mutableStateOf(initIsChecked) }

    Card(
        shape = CircleShape,
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(25.dp)
                .background(if (isChecked) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.background)
                .clickable {
                    isChecked = !isChecked
                    onClick()
                }
        ) {
            if (isChecked) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = stringResource(id = R.string.task_card_checked)
                )
            }
        }
    }
}

@Composable
@Preview
private fun RoundedCheckboxPreview() {
    RoundedCheckbox(
        onClick = {}
    )
}