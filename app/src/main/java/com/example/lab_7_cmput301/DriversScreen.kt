package com.example.lab_7_cmput301

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController) {
    var driver by remember {
        mutableStateOf("")
    }

    var drivers = remember {
        mutableStateListOf<String>()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("driversBackButton")
        ) {
            Text("Back")
        }

        Text(
            text = "FormulaZero Drivers",
            fontSize = 30.sp,
            modifier = Modifier.testTag("driversTitle")
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = driver,
            onValueChange = {
                driver = it
            },
            label = {
                Text("Driver Name")
            },
            modifier = Modifier.testTag("driverInput")
        )

        Button(
            onClick = {
                if (driver.isNotBlank()) {
                    drivers.add(driver)
                    driver = ""
                }
            },
            modifier = Modifier.testTag("addDriverButton")
        ) {
            Text("Add")
        }

        Button(
            onClick = {
                drivers.clear()
            },
            modifier = Modifier.testTag("clearDriversButton")
        ) {
            Text("Clear All")
        }

        LazyColumn {
            items(drivers) { name ->
                Text(
                    text = name,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .testTag("driverItem")
                )
            }
        }
    }
}