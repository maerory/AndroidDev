package net.n1books.dev.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int a = 0;
    int b = 0;

    Button btnCal;
    EditText edtNum1, edtNum2;
    TextView edtResult;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        edtResult = findViewById(R.id.edtResult);
        btnCal = findViewById(R.id.btnCal);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    a = Integer.parseInt(edtNum1.getText().toString().trim());
                    b = Integer.parseInt(edtNum2.getText().toString().trim());
                    edtResult.setText(String.valueOf(a + b));
                } catch (Exception e) {
                    Toast.makeText(getApplication(),"Wrong Input",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
