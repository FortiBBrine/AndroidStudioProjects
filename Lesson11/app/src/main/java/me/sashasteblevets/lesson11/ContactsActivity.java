package me.sashasteblevets.lesson11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ContactsActivity extends AppCompatActivity {

    private String[] namesArray = new String[] {"John", "Sasha", "Roman"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        Button moveButton1 = findViewById(R.id.moveButton1);
        Button moveButton2 = findViewById(R.id.moveButton2);
        Button moveButton3 = findViewById(R.id.moveButton3);

        moveButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ListView listView = findViewById(R.id.list_view);

        // ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, this.namesArray);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.name_item, R.id.username, this.namesArray);


        listView.setAdapter(adapter);

    }
}