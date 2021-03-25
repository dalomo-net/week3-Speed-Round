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

import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun Home() {

    Scaffold(
        bottomBar = { BottomBar() },
        modifier = Modifier.navigationBarsPadding()
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {

            Spacer(modifier = Modifier.height(40.dp))

            OutlinedTextField(
                value = "Search", onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search",
                        Modifier.size(18.dp)
                    )
                }
            )

            Text(
                text = "Browse themes",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.paddingFromBaseline(top = 32.dp, bottom = 16.dp)
            )

            LazyRowList()

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 40.dp)
            ) {

                Text(
                    text = "Design your home garden",
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onPrimary,
                )
                Icon(
                    imageVector = Icons.Default.FilterList,
                    contentDescription = "filterlist",
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumnList()
        }
    }
}

@Composable
fun BottomBar() {

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.height(56.dp)
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
            label = { Text(text = "Home", style = MaterialTheme.typography.caption) }
        )
        BottomNavigationItem(
            selected = false,
            icon = {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "favorite"
                )
            },
            label = { Text(text = "Favorites", style = MaterialTheme.typography.caption) },
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            selected = false,
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "profile"
                )
            },
            label = { Text(text = "Profile", style = MaterialTheme.typography.caption) },
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            selected = false,
            icon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "cart") },
            label = { Text(text = "Cart", style = MaterialTheme.typography.caption) },
            onClick = { /*TODO*/ }
        )
    }
}

@Composable
fun LazyColumnList() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(bottom = 56.dp)
    )
    {
        item {
            PlantItem(n = "Monstera", rid = R.drawable.monstera)
        }
        item {
            PlantItem(n = "Aglaonema", rid = R.drawable.aglaonema)
        }
        item {
            PlantItem(n = "Peace Lily", rid = R.drawable.peace_lilly)
        }
        item {
            PlantItem(n = "Fiddle Leaf tree", rid = R.drawable.fiddle_leaf)
        }
        item {
            PlantItem(n = "Snake plant", rid = R.drawable.snake_plant)
        }
        item {
            PlantItem(n = "Pothos", rid = R.drawable.pothos)
        }
    }
}

@Composable
fun PlantItem(n: String, rid: Int) {
    Row(
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CoilImage(
            data = rid,
            contentDescription = "",
            modifier = Modifier
                .size(64.dp)
                .clip(shape = MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop
        ) {

        }
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(modifier = Modifier.padding(start = 16.dp)) {

                    Text(
                        text = n,
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.paddingFromBaseline(top = 24.dp)
                    )
                    Text(
                        text = "This is a description",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.paddingFromBaseline(bottom = 16.dp)
                    )
                }
                Checkbox(
                    checked = true,
                    onCheckedChange = {},
                    modifier = Modifier.size(24.dp)
                )
            }
            Divider(modifier = Modifier.padding(start = 8.dp), thickness = 2.dp)
        }
    }
}

@Composable
fun LazyRowList() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.height(136.dp),
        content = {
            item { ThemeCard("Desert chic", R.drawable.desert_chic) }
            item { ThemeCard("Tiny terrariums", R.drawable.tiny_terrariums) }
            item { ThemeCard("Jungle vibes", R.drawable.jungle_vibes) }
            item { ThemeCard("Easy care", R.drawable.easy_care) }
            item { ThemeCard("Statements", R.drawable.statements) }
        }
    )
}

@Composable
fun ThemeCard(n: String, rid: Int) {

    val context = LocalContext.current
    val image: Drawable = ResourcesCompat.getDrawable(context.resources, rid, null)!!

    val path: Uri = Uri.parse("android.resource://com.example.androiddevchallenge/$rid")


    Card(
        modifier = Modifier
            .size(136.dp)
            .clickable { },
        shape = MaterialTheme.shapes.small,
        elevation = 1.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            CoilImage(
                data = path,
                contentDescription = "",
                modifier = Modifier
                    .height(96.dp),
                contentScale = ContentScale.Crop
            ) {

            }
            Text(
                text = n,
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp)
                    .paddingFromBaseline(top = 24.dp)
            )

        }
    }
}

@Preview
@Composable
fun Previewterm() {

    Home()
}

