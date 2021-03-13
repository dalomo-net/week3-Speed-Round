/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {

    Surface(color = MaterialTheme.colors.background) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "welcome"
        ) {
            composable("welcome") {
                Welcome(navController = navController)
            }
            composable("login") {
                Login(navController = navController)
            }
            composable("home") {
                Home(navController = navController)
            }
        }
    }
}

@Composable
fun Welcome(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.primary
    ) {

        Box(

        ) {
            Image(
                painter = painterResource(id = R.drawable.light_welcome_bg),
                contentDescription = ""
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Spacer(modifier = Modifier.height(72.dp))

                Image(
                    modifier = Modifier
                        .padding(start = 88.dp, top = 72.dp, bottom = 48.dp),
                    contentScale = ContentScale.None,
                    painter = painterResource(id = R.drawable.light_welcome_illos),
                    contentDescription = ""
                )
                Image(
                    painter = painterResource(id = R.drawable.light_logo),
                    contentDescription = ""
                )
                Text(
                    text = "Beautiful home garden solutions",
                    lineHeight = 72.sp,
                    style = MaterialTheme.typography.subtitle1
                )

                Button(
                    onClick = { },
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.fillMaxWidth()
                        .height(48.dp)
                        .padding(top = 40.dp)

                ) {
                    Text(
                        text = "Create account",
                        color = MaterialTheme.colors.background,
                        style = MaterialTheme.typography.button
                    )
                }
                Button(
                    onClick = { navController.navigate("login") },
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.fillMaxWidth()
                        .height(48.dp)
                        .padding(top = 8.dp)
                ) {
                    Text(
                        text = "Log in",
                        color = MaterialTheme.colors.secondary,
                        style = MaterialTheme.typography.button
                    )
                }

            }
        }

    }
}

@Composable
fun Login(navController: NavController) {

    var eaddress = remember { mutableStateOf("Email address") }
    var pwd = remember { mutableStateOf("Password (8+ characters)") }

    Scaffold() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Log in with email",
                modifier = Modifier
                    .padding(top = 184.dp)
                    .wrapContentSize(),
                style = MaterialTheme.typography.h1
            )

            OutlinedTextField(
                value = eaddress.value,
                onValueChange = { eaddress.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                textStyle = MaterialTheme.typography.body1
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = pwd.value,
                onValueChange = { pwd.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                textStyle = MaterialTheme.typography.body1
            )

            Text(
                buildAnnotatedString {
                    append("By clicking below, you agree to our ")
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append("Term of Use")
                    }
                    append(" and consent to our ")
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append("Privacy Policy")
                    }
                    append(".")
                },
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 24.dp,)
            )
            Button(
                onClick = { navController.navigate("home") },
                shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth()
                .height(48.dp)
                .padding(top = 16.dp)
            ) {
                Text(
                    text = "Log in",
                    color = MaterialTheme.colors.secondary,
                    style = MaterialTheme.typography.button
                )

            }

        }
    }
}

@Composable
fun Home(navController: NavController) {
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
