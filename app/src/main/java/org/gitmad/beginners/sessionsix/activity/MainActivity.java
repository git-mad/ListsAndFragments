package org.gitmad.beginners.sessionsix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.gitmad.beginners.sessionsix.R;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpList();
    }

    private void setUpList() {
        String[] threadNames = getResources().getStringArray(R.array.thread_names);

        ListAdapter threadTitleAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, threadNames);

        ListView threadsListView = (ListView) findViewById(R.id.threadListView);
        threadsListView.setAdapter(threadTitleAdapter);

        threadsListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ThreadDetailsActivity.class);

        intent.putExtra(ThreadDetailsActivity.KEY_THREAD_INDEX, position);

        startActivity(intent);
    }
}
