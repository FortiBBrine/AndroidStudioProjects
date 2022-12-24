package me.sashasteblevets.lesson7;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer firstSound, secondSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton button1 = findViewById(R.id.imageButton1);
        ImageButton button2 = findViewById(R.id.imageButton2);

        firstSound = MediaPlayer.create(this, R.raw.soundeffect1);
        secondSound = MediaPlayer.create(this, R.raw.soundeffect2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPlayButton(firstSound);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPlayButton(secondSound);
            }
        });
    }

    private void soundPlayButton(MediaPlayer sound){
        if (sound.isLooping()) {
            sound.stop();
            try {
                sound.prepare();
            } catch (IOException ignored) {}
            sound.setLooping(false);
        } else {
            sound.start();
            sound.setLooping(true);
        }

    }
}