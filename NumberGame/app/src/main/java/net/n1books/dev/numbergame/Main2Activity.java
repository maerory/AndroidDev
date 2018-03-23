package net.n1books.dev.numbergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button[] buttons = new Button[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
    }

    public void btn_onClick(View v) {
        Button button = (Button) v;
        if (!button.getText().toString().equals("")) {
            Log.d("c504", "No Space");
            switch (button.getId()) {
                case R.id.button1:
                    buttons[1].setText(button.getText());
                    button.setText("");
                    break;
                case R.id.button2:
                    buttons[0].setText(button.getText());
                    button.setText("");
                    break;
            }
        } else {
            Log.d("c504", "Space");
        }
    }
}


