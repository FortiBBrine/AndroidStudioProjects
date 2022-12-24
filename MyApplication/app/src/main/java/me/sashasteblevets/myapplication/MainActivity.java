package me.sashasteblevets.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private Button button;
    private EditText editText1;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.resultTextView = findViewById(R.id.textView);
        this.button = findViewById(R.id.button);
        this.editText1 = findViewById(R.id.numberInput1);
        this.editText2 = findViewById(R.id.numberInput2);

        this.button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double num1 = Float.parseFloat(editText1.getText().toString());
                double num2 = Float.parseFloat(editText2.getText().toString());
                double res = num1 + num2;
                resultTextView.setText(String.valueOf(res));
            }
        });
    }
}