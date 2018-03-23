package net.n1books.dev.numbergame;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtValue;
    Button btnStart, btnOk, btnLeft, btnRight;
    EditText editResult;

    int count = 0;
    int you = 0;
    int com = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValue = findViewById(R.id.txtValue);
        btnLeft = findViewById(R.id.btnLeft);
        btnRight = findViewById(R.id.btnRight);
        btnOk = findViewById(R.id.btnOk);
        btnStart = findViewById(R.id.btnStart);
        editResult = findViewById(R.id.editResult);


        editResult.setClickable(false);
        initialize();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialize();
            }
        });

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process(-1);
            }
        });

        btnLeft.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                process(-10);
                return true;
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process(1);
            }
        });

        btnRight.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                process(10);
                return true;
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                try {
                    you = Integer.parseInt(txtValue.getText().toString().trim());
                    txtValue.setText("50");
//                    hideSoftKeyboard(MainActivity.this, view);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Wrong Input",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (you > 99 || you < 1) {
                    editResult.append("\nNot in proper range");
                } else if (you > com) {
                    editResult.append("\nI am lesser than " + you + "!");
                } else if (you < com) {
                    editResult.append("\nI am greater than " + you + "!");
                } else {
                    String result = "<font color=\"red\"><b>\nCorrect after " + count + " tries.</b></font>";
                    editResult.append(Html.fromHtml(result));
                    btnStart.setEnabled(true);
                    btnOk.setEnabled(false);
                }
            }
        });
    }
    public void process(int addVal) {

        if (Integer.parseInt(txtValue.getText().toString()) != 1 && !btnLeft.isEnabled()) btnLeft.setEnabled(true);
        if (Integer.parseInt(txtValue.getText().toString()) != 99 && !btnRight.isEnabled()) btnRight.setEnabled(true);

        you = Integer.parseInt(txtValue.getText().toString().trim());
        you+=addVal;
        if (you < 1) you = 1;
        else if (you > 99) you = 99;

        if (you == 1) btnLeft.setEnabled(false);
        if (you == 99) btnRight.setEnabled(false);



        txtValue.setText(String.valueOf(you));
    }

    private void initialize() {
        com = (int) (Math.random() * 99 + 1);
        count = 0;
        Toast.makeText(getApplicationContext(), "Let the game begin!", Toast.LENGTH_LONG).show();
        editResult.setText(null);
        btnStart.setEnabled(false);
        btnOk.setEnabled(true);
    }

//    public static void hideSoftKeyboard (Activity activity, View view)
//    {
//        InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
//    }


}
