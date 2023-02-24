package com.github.miazga.bootcampapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;
import android.widget.TextView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.nio.channels.InterruptedByTimeoutException;

@RunWith(AndroidJUnit4.class)
public class GreetingActivityTest {


    @Test
    public void testIntent() {
        Intents.init();
        Intent i = new Intent(ApplicationProvider.getApplicationContext(), Greeting_Activity.class);
        ActivityScenario.launch(i).close();

        onView(withId(R.id.textView));
        Intents.release();


    }

    /*@Test
    public void testIntentMatch() {
        Intents.init();
        Intent i = new Intent(ApplicationProvider.getApplicationContext(), Greeting_Activity.class);
        ActivityScenario.launch(i).close();

        onView(withId(R.id.textView))
                .check(matches(withText("Greetings Enter your name")));
        Intents.release();
    }*/

    @Test
    public void newTest() {

    }
}
