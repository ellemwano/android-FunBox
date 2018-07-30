package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mwano.lauren.androidlibrary.JokeDisplayActivity;


public class MainActivity extends AppCompatActivity implements OnTaskCompleted {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Execute the EndPointAsyncTask to get a joke from the library via the GoogleCloudEndpoint
     * @param view the button clicked to execute the asyncTask
     */
    public void fetchJoke(View view) {
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(MainActivity.this);
        asyncTask.execute(this);
        //Toast.makeText(this, funnyJoke, Toast.LENGTH_LONG).show();
    }


    /**
     * Intent to launch the JokeDisplayActivity to display the joke fetched from the library
     * @param joke The joke fetched from the library, through the GCE
     */
    @Override
    public void onTaskCompleted(String joke) {
        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.JOKE, joke);
        startActivity(intent);
    }
}
