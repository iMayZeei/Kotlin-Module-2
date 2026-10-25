
package com.example.module2

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun addWaterTest() {
        composeTestRule.setContent {
            WaterTracker()
        }

        composeTestRule.onNodeWithText("+250 мл").assertExists()
        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("350 мл").assertExists()
    }

    @Test
    fun finishDayTest() {
        composeTestRule.setContent {
            WaterTracker()
        }

        repeat(6) {
            composeTestRule.onNodeWithText("+250 мл").performClick()
        }

        composeTestRule.onNodeWithText("Завершить день").assertExists()
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("0 мл").assertExists()
    }

    @Test
    fun streakDaysTest() {
        composeTestRule.setContent {
            WaterTracker()
        }

        repeat(6) {
            composeTestRule.onNodeWithText("+250 мл").performClick()
        }

        composeTestRule.onNodeWithText("Завершить день").performClick()

        composeTestRule.onNodeWithText(
            "Дней подряд (1500 мл и более): 1"
        ).assertExists()

        composeTestRule.onNodeWithText("Завершить день").performClick()

        composeTestRule.onNodeWithText(
            "Дней подряд (1500 мл и более): 0"
        ).assertExists()
    }
}
