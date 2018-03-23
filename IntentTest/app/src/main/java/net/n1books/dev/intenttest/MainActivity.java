package net.n1books.dev.intenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String id;
    String pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_click(View v) {
        Intent intent = new Intent(getApplicationContext(),Main2Activity.class); //Explicit Intent, tells you where to go
        intent.putExtra("name","James");
        intent.putExtra("age",
                54);
        startActivity(intent);
    }

}
