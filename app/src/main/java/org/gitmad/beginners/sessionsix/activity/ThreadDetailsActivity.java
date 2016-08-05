package org.gitmad.beginners.sessionsix.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import org.gitmad.beginners.sessionsix.R;

public class ThreadDetailsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static String KEY_THREAD_INDEX = "thread index asdf";
    private int threadIndex;
    private Spinner threadChangeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_details);

        threadIndex = getIntent().getIntExtra(KEY_THREAD_INDEX, -1);

        setThreadText();

        setUpSpinner();
    }

    private void setThreadText() {
        String threadTitle = getResources().getStringArray(R.array.thread_names)[threadIndex];
        String threadDescription = getResources().getStringArray(R.array.thread_descriptions)[threadIndex];

        TextView threadTitleTextView = (TextView) findViewById(R.id.threadNameTextView);
        TextView threadDescriptionTextView = (TextView) findViewById(R.id.threadDescriptionTextView);

        threadTitleTextView.setText(threadTitle);
        threadDescriptionTextView.setText(threadDescription);
    }

    private void setUpSpinner() {
        threadChangeSpinner = (Spinner) findViewById(R.id.threadChangeSpinner);

        SpinnerAdapter adapter = ArrayAdapter.createFromResource(this, R.array.thread_names, android.R.layout.simple_spinner_item);

        threadChangeSpinner.setAdapter(adapter);

        threadChangeSpinner.setOnItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        threadChangeSpinner.setSelection(threadIndex);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position != threadIndex) {
            startThreadDetailsActivity(position);
        }
    }

    private void startThreadDetailsActivity(int threadIndex) {
        Intent intent = new Intent(this, ThreadDetailsActivity.class);

        intent.putExtra(ThreadDetailsActivity.KEY_THREAD_INDEX, threadIndex);

        startActivity(intent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
