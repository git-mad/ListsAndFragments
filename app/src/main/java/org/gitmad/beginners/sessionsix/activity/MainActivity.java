package org.gitmad.beginners.sessionsix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.gitmad.beginners.sessionsix.R;

public class MainActivity extends AppCompatActivity {

    /*
     * Make MainActivity OnThreadClickedListener so ChooseThreadFragment
     * can communicate with it.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void startThreadDetailsActivity(int threadIndex) {
        Intent intent = new Intent(this, ThreadDetailsActivity.class);

        intent.putExtra(ThreadDetailsActivity.KEY_THREAD_INDEX, threadIndex);

        startActivity(intent);
    }
}
