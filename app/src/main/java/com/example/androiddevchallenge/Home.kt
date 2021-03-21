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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun Home() {

    Scaffold(bottomBar = { BottomBar() },
    modifier = Modifier.navigationBarsPadding()) {
        Column(modifier = Modifier.padding(16.dp)) {

            Spacer(modifier = Modifier.height(40.dp))

            OutlinedTextField(
                value = "Search", onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )

            Text(
                text = "Browse themes",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.paddingFromBaseline(top = 32.dp)
            )

            LazyRowList()
            Text(
                text = "Design your home garden",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary
            )

            LazyColumnList()
        }
    }
}

@Composable
fun BottomBar() {

    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.height(56.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            // Column() {
            //     Image(
            //         painter = painterResource(id = R.drawable.home),
            //         contentDescription = "Home",
            //         colorFilter = ColorFilter.tint(Color.Black)
            //     )
            //     Text("Home", style = MaterialTheme.typography.caption)
            // }
            // Column() {
            //     Image(
            //         painter = painterResource(id = R.drawable.favarites),
            //         contentDescription = "",
            //         colorFilter = ColorFilter.tint(Color.LightGray)
            //     )
            //     Text("Favorites", style = MaterialTheme.typography.caption)
            // }
            //
            // Column() {
            //     Image(
            //         painter = painterResource(id = R.drawable.profile),
            //         contentDescription = "Home",
            //         colorFilter = ColorFilter.tint(Color.LightGray)
            //     )
            //     Text("Profile", style = MaterialTheme.typography.caption)
            // }
            // Column() {
            //     Image(
            //         painter = painterResource(id = R.drawable.cart),
            //         contentDescription = "Home",
            //         colorFilter = ColorFilter.tint(Color.LightGray)
            //     )
            //     Text("Cart", style = MaterialTheme.typography.caption)
            // }
        }
    }
}

@Composable
fun LazyColumnList() {
    LazyColumn(
        content = {
            item {
                KindCard(n = "Monstera", rid = R.drawable.monstera)
            }
            // item {
            //     KindCard(n = "Aglaonema", rid = R.drawable.aglaonema)
            // }
            // item {
            //     KindCard(n = "Peace Lily", rid = R.drawable.peace_lilly)
            // }
            // item {
            //     KindCard(n = "Fiddle Leaf tree", rid = R.drawable.fiddle_leaf)
            // }
            // item {
            //     KindCard(n = "Snake plant", rid = R.drawable.snake_plant)
            // }
            // item {
            //     KindCard(n = "Pothos", rid = R.drawable.pothos)
            // }
        }
    )
}

@Composable
fun KindCard(n: String, rid: Int) {
    Row(
        modifier = Modifier.height(64.dp)
    ) {
        Image(
            painter = painterResource(id = rid),
            contentDescription = "",
            modifier = Modifier.clip(shape = MaterialTheme.shapes.small)
        )
        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(
                text = n,
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onPrimary
            )
            Text(
                text = "This is a description",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onPrimary
            )
            Divider()
        }
    }
}

@Composable
fun LazyRowList() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            item { ThemeCard("Desert chic", R.drawable.desert_chic) }
            // item { ThemeCard("Tiny terrariums", R.drawable.tiny_terrariums) }
            // item { ThemeCard("Jungle vibes", R.drawable.jungle_vibes) }
            // item { ThemeCard("Easy care", R.drawable.easy_care) }
            // item { ThemeCard("Statements", R.drawable.statements) }
        }
    )
}

@Composable
fun ThemeCard(n: String, rid: Int) {

    Box(
        modifier = Modifier
            .height(136.dp)
            .width(136.dp)
    ) {
        Image(
            painter = painterResource(id = rid),
            contentDescription = "",
            modifier = Modifier.clip(shape = MaterialTheme.shapes.small),
            contentScale = ContentScale.Fit
        )
        Text(
            text = n,
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 16.dp),
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onPrimary
        )
    }
}
