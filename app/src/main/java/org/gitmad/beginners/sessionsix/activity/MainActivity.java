package org.gitmad.beginners.sessionsix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.gitmad.beginners.sessionsix.R;
import org.gitmad.beginners.sessionsix.fragment.OnThreadClickedListener;

public class MainActivity extends AppCompatActivity implements OnThreadClickedListener{

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

    @Override
    public void onThreadClicked(int threadIndex) {
        startThreadDetailsActivity(threadIndex);
    }
}
