package net.n1books.dev.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
    }
    public void btn_click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Toast.makeText(getApplication(), "Btn 1 Clicked!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                String txt = editText.getText().toString().trim();
                if (txt.equals("")) {
                    Snackbar.make(view, "Input Text Please...", Snackbar.LENGTH_LONG).show();
                    return;
                }
                Snackbar.make(view, "그래 난 " + txt, Snackbar.LENGTH_LONG).show();
                break;
            case R.id.button3:
                Toast.makeText(getApplication(), "Btn 3 Clicked!",Toast.LENGTH_SHORT).show();
                break;
        }

    }

}
