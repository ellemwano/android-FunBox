package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static org.junit.Assert.assertEquals;


/**
 * Code help: https://stackoverflow.com/a/5722193
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    // create  a signal to let us know when our task is done.
    final CountDownLatch signal = new CountDownLatch(1);
    final String error = "Error loading joke";
    private String mResult;

    @Test
    public void testAsyncTask() throws Throwable {

        @SuppressLint("StaticFieldLeak")
        final EndpointsAsyncTask asyncTask = new EndpointsAsyncTask() {

            @Override
            protected void onPostExecute(String result) {
                mResult = result;
                signal.countDown();
            }
        };

        // Execute the async task on the UI thread
        Runnable runTestOnUiThread = new Runnable() {
            @Override
            public void run() {
                asyncTask.execute();
            }
        };
        runTestOnUiThread.run();
        // The testing thread waits here until the UI thread releases it above with the countdown()
        // or 30 sec passes and the time is out
        signal.await(30, TimeUnit.SECONDS);

       // The asyncTask is completed
        assertEquals(false, mResult.equals(error));
        assertFalse(mResult.isEmpty());
    }
}
