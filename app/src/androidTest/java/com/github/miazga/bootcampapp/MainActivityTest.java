package com.github.miazga.bootcampapp;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    public static final String STRING_TO_BE_TYPED = "Espresso";

    @Rule
    public ActivityScenarioRule<Main_Activity> testRule = new ActivityScenarioRule<>(Main_Activity.class);

    @Test
    public void displayName() {
        onView(withId(R.id.mainName))
                .perform(click())
                .check(matches(isDisplayed()));
    }

    @Test
    public void clickButton() {
        onView(withId(R.id.mainGoButton))
                .perform(click());
    }

    @Test
    public void checkTextTrue() {
        onView(withId(R.id.mainName))
                .check(matches(withText("Enter your name")));
    }

    @Test
    public void checkNameFalse() {
        onView(withId(R.id.mainName))
                .check(matches(not(withText("Hello"))));
    }


    @Test
    public void checkUniqueMainName() {
        onView(withId(R.id.mainName));
    }

    @Test
    public void testIntent() {
        Intents.init();
        Intent i = new Intent();
        String name = "Enter your name";
        i.putExtra("idName", name);
        Instrumentation.ActivityResult result =
                new Instrumentation.ActivityResult(Activity.RESULT_OK, i);

        // Set up result stubbing when an intent sent to "contacts" is seen.
        intending(toPackage("com.github.miazga.bootcampapp")).respondWith(result);

        // User action that results in "contacts" activity being launched.
        // Launching activity expects phoneNumber to be returned and displayed.
        onView(withId(R.id.mainGoButton)).perform(click());

        // Assert that the data we set up above is shown.
        onView(withId(R.id.mainName)).check(matches(withText(name)));
        Intents.release();
    }
}

