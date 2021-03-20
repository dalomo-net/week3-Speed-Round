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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate

@Composable
fun Welcome(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.primary
    ) {

        Box() {
            Image(
                painter = painterResource(id = R.drawable.light_welcome_bg),
                contentDescription = ""
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

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
                    modifier = Modifier.paddingFromBaseline(32.dp, 40.dp),
                    style = MaterialTheme.typography.subtitle1
                )

                Button(
                    onClick = { },
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxWidth()
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
                    modifier = Modifier
                        .fillMaxWidth()
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
