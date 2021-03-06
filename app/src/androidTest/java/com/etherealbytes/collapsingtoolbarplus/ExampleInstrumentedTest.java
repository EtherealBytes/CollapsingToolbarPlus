package com.etherealbytes.collapsingtoolbarplus;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.WindowManager;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
  @Rule
  public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
          MainActivity.class);

  @Before
  public void setUp() {
    final MainActivity activity = mActivityRule.getActivity();
    Runnable wakeUpDevice = new Runnable() {
      public void run() {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
      }
    };
    activity.runOnUiThread(wakeUpDevice);
  }
  @Test
  public void useAppContext() throws Exception {
    // Context of the app under test.
    Context appContext = InstrumentationRegistry.getTargetContext();

    assertEquals("com.etherealbytes.collapsingtoolbarplus", appContext.getPackageName());
  }
}
