package com.example.homework8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.homework8.models.Node;

public class NoteEditActivity extends AppCompatActivity {

    EditText titleNodeEditText, bodyNodeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);
        titleNodeEditText = findViewById(R.id.nodeTitleTextEdit);
        bodyNodeEditText = findViewById(R.id.nodeBodyTextEdit);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.node_create_or_edit_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title = titleNodeEditText.getText().toString();
        String body = bodyNodeEditText.getText().toString();
        Node node = new Node(title, body);

        switch (item.getItemId()) {
            case R.id.saveNode:

                Intent intent = new Intent();
                intent.putExtra(Node.class.getSimpleName(), node);
                setResult(RESULT_OK, intent);
                finish();

                return true;
            case R.id.shareNode:
                Intent sendIntent = new Intent(android.content.Intent.ACTION_SEND);
                sendIntent
                        .putExtra(Intent.EXTRA_TEXT,
                                "Title: " + node.getTitle() + "\nBody:\n" + node.getBody() + "\nLast edit: " + node.getLastEditDate());
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent ,"Share"));
                return true;
            case R.id.deleteNode:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}