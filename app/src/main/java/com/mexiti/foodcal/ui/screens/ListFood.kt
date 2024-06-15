package com.mexiti.foodcal.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mexiti.foodcal.R
import com.mexiti.foodcal.model.DayRepository
import com.mexiti.foodcal.ui.theme.FoodAppTheme


@Composable
fun FoodsApp(){
    Scaffold(
        topBar = {
            FoodTopBar()
        }
    ) {
        it ->
        LazyColumn(
            contentPadding = it
        ) {
            items(DayRepository.days) { food -> CardDayInfo(dayFood = food) }

        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodTopBar(){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineMedium

            )
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.topAppBarColors(
            titleContentColor = MaterialTheme.colorScheme.onSecondary,
            containerColor = MaterialTheme.colorScheme.onBackground
        )

    )
}


@Preview(showBackground = true)
@Composable
fun FoodAppPreview(){
    FoodAppTheme {
        FoodsApp()
    }
}
