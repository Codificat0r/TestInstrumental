package com.example.greeter;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testGreet() {
        //Busca la vista, el edittext, por su ID y escribe en el "Jake", despues cierra el teclado
        onView(withId(R.id.greetEditText)).perform(typeText("Jake"), closeSoftKeyboard());
        //Busca la vista por texto. Debe ser el mismo texto incluyendo mayus y minus.
        onView(withText("GREET")).perform(click());
        //Comprobamos que el texto del TextView cuadra con el resultado que debería dar.
        onView(withId(R.id.messageTextView)).check(matches(withText("Hello, Jake!")));
    }
}
