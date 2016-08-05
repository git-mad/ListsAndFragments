package org.gitmad.beginners.sessionsix.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.gitmad.beginners.sessionsix.R;

public class ThreadDetailsActivity extends AppCompatActivity {

    public static String KEY_THREAD_INDEX = "thread index key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_details);

        setThreadText();
    }

    private void setThreadText() {
        int threadIndex = getIntent().getIntExtra(KEY_THREAD_INDEX, -1);

        String threadTitle = getResources().getStringArray(R.array.thread_names)[threadIndex];
        String threadDescription = getResources().getStringArray(R.array.thread_descriptions)[threadIndex];

        TextView threadTitleTextView = (TextView) findViewById(R.id.threadNameTextView);
        TextView threadDescriptionTextView = (TextView) findViewById(R.id.threadDescriptionTextView);

        threadTitleTextView.setText(threadTitle);
        threadDescriptionTextView.setText(threadDescription);
    }
}
