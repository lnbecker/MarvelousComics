package com.example.marvelouscomics

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.marvelouscomics.views.MainActivity
import org.junit.Rule
import org.junit.Test


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
//@RunWith(AndroidJUnit4::class)
@LargeTest
class RecyclerViewVisibleInstrumentedTest {
    @get: Rule
    var activityScenarioRule: ActivityScenarioRule<MainActivity?>? = ActivityScenarioRule(
        MainActivity::class.java
    )


    @Test
    fun testNotEmpty(){
        onView(withId(R.id.rv_comic_list))
            .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }


}