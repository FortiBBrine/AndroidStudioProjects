package me.sashasteblevets.lesson10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        EditText userNameField = findViewById(R.id.user_name_field);
        EditText userBiographyField = findViewById(R.id.user_biography_field);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = userNameField.getText().toString();
                String userBiography = userBiographyField.getText().toString();

                try {
                    FileOutputStream fileOutput = openFileOutput("userdata.txt", MODE_PRIVATE);

                    fileOutput.write((userName+"."+userBiography).getBytes());

                    fileOutput.close();

                    Toast.makeText(MainActivity.this, "Текст збережено", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Не вдалось зберегти інформацію", Toast.LENGTH_SHORT).show();
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fileInput = openFileInput("userdata.txt");

                    Scanner scanner = new Scanner(fileInput);

                    StringBuilder result = new StringBuilder();

                    while (scanner.hasNextLine()) {
                        result.append(scanner.nextLine()).append("\n");
                    }

                    String resultString = result.substring(0, result.length() - 1);
                    String[] res = resultString.split("\\.");

                    userNameField.setText(res[0]);

                    StringBuilder biography = new StringBuilder();

                    for (int i = 1; i < res.length; i++) {
                        biography.append(res[i]).append(".");
                    }

                    String biographyString = biography.toString();

                    biographyString = biographyString.substring(0, biographyString.length() - 1);

                    userBiographyField.setText(biographyString);

                    scanner.close();
                    fileInput.close();

                    Toast.makeText(MainActivity.this, "Текст успішно імпортовано", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Не вдалось імпортувати інформацію", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}