package com.example.lab_7_cmput301

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // Navigate to races.
        composeTestRule.onNodeWithTag("raceButton")
            .performClick()

        composeTestRule.onNodeWithText("Upcoming Races")
            .assertIsDisplayed()

        // Add a race location.
        composeTestRule.onNodeWithTag("locationInput")
            .performTextInput("Canada")

        composeTestRule.onNodeWithTag("addRaceButton")
            .performClick()

        // Verify the race appears.
        composeTestRule.onNodeWithText("Canada")
            .assertIsDisplayed()

        // Return home.
        composeTestRule.onNodeWithTag("backButton")
            .performClick()

        composeTestRule.onNodeWithText("FormulaZero Home")
            .assertIsDisplayed()
    }

    @Test
    fun navigate_to_drivers_add_clear_and_return_home() {
        // Navigate to Drivers.
        composeTestRule.onNodeWithTag("driversButton")
            .performClick()

        composeTestRule.onNodeWithTag("driversTitle")
            .assertIsDisplayed()

        // Add a driver.
        composeTestRule.onNodeWithTag("driverInput")
            .performTextInput("Lewis Hamilton")

        composeTestRule.onNodeWithTag("addDriverButton")
            .performClick()

        // Verify the driver appears in the list.
        composeTestRule.onNodeWithTag("driverItem")
            .assertIsDisplayed()
            .assertTextEquals("Lewis Hamilton")

        // Clear all drivers.
        composeTestRule.onNodeWithTag("clearDriversButton")
            .performClick()

        composeTestRule.onAllNodesWithTag("driverItem")
            .assertCountEquals(0)

        // Return home.
        composeTestRule.onNodeWithTag("driversBackButton")
            .performClick()

        composeTestRule.onNodeWithText("FormulaZero Home")
            .assertIsDisplayed()
    }
}