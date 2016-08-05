package org.gitmad.beginners.sessionsix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.gitmad.beginners.sessionsix.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpList();
    }

    private void setUpList() {
        String[] threadNames = getResources().getStringArray(R.array.thread_names);

        /*
         * We need to find the our ListView by its id (R.id.threadListView),
         * create and set a ListAdapter to hold our thread names for the ListView,
         * and set an OnItemClickedListener that will start the ThreadDetailsActivity
         */
    }

    private void startThreadDetailsActivity(int threadIndex) {
        Intent intent = new Intent(this, ThreadDetailsActivity.class);

        intent.putExtra(ThreadDetailsActivity.KEY_THREAD_INDEX, threadIndex);

        startActivity(intent);
    }
}
