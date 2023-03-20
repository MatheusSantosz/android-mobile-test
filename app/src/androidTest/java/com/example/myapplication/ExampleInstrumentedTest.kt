package com.example.myapplication

import android.support.test.rule.ActivityTestRule
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    var mainActivity: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loginComSucesso() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.myapplication", appContext.packageName)
        onView(withText("Pagina de Login")).check(matches(isDisplayed()))
        onView(withId(R.id.editTextTextEmailAddress2)).perform(typeText("test@email.com.br"))
        closeSoftKeyboard()
        onView(withId(R.id.editTextTextPassword2)).perform(typeText("senha123"))
        closeSoftKeyboard()
        onView(withId(R.id.button_first)).perform(click())
        onView(withText("Logado com Sucesso!!")).check(matches(isDisplayed()))
        onView(withId(R.id.button_second)).perform(click())
    }
}