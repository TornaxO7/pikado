package de.tornaxo7.pikado.ui.login

import android.webkit.WebSettings.TextSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.tornaxo7.pikado.R

@Composable
fun LoginComposable() {
    LoginContentPreview()
}

@Composable
private fun LoginContent(
    username: String,
    password: String,
    serverUrl: String,
    onLoginChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onServerUrlChange: (String) -> Unit,
    onLogin: () -> Unit,
    onRegister: () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Card(
                modifier = Modifier
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(IntrinsicSize.Min)
                        .padding(30.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.login_title),
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )

                    OutlinedTextField(
                        value = username,
                        onValueChange = onLoginChange,
                        label = { Text(stringResource(id = R.string.login_username)) }
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = onPasswordChange,
                        label = { Text(stringResource(id = R.string.login_password)) }
                    )

                    OutlinedTextField(
                        value = serverUrl,
                        onValueChange = onServerUrlChange,
                        label = { Text(stringResource(id = R.string.login_server_url)) }
                    )

                    HorizontalDivider(
                        modifier = Modifier.padding(10.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            onClick = onRegister,
                            modifier = Modifier
                                .weight(0.1f)
                                .padding(end = 5.dp)
                        )
                        {
                            Text(stringResource(id = R.string.login_register))
                        }

                        Button(
                            onClick = onLogin,
                            modifier = Modifier
                                .weight(0.1f)
                                .padding(start = 5.dp)
                        ) {
                            Text(stringResource(id = R.string.login_login))
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun LoginContentPreview() {
    LoginContent(
        username = "",
        password = "",
        serverUrl = "",
        onLoginChange = {},
        onPasswordChange = {},
        onServerUrlChange = {},
        onLogin = { },
        onRegister = { }
    )
}