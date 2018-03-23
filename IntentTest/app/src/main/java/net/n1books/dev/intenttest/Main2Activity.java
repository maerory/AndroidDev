package net.n1books.dev.intenttest;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    TextView textView;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView.findViewById(R.id.textView);
        mediaPlayer = MediaPlayer.create(this, R.raw.fallout4);
        mediaPlayer.start();

        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        int age = intent.getExtras().getInt("age");
        textView.append(", name:" + name + "age, " + age);
    }

    public void button_sub_click(View v) {
        mediaPlayer.release();
        finish();
    }
}
