package net.n1books.dev.logintest;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements {

    EditText edtId, edtPw;
    Button btnLogin;

    public static final int REQUEST_CODE = 504;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtId = findViewById(R.id.edtId);
        edtPw = findViewById(R.id.edtPw);
        btnLogin = findViewById(R.id.btnLogin);

    }

/**
    public void button_login_onclick(View v) {

        Bundle bundle = new Bundle();
        bundle.putString("id",edtId.getText().toString());
        bundle.putString("pw",edtPw.getText().toString());

        Intent intent = new Intent(this, LoginSuccess.class);
//      2. Intent에 오브젝트 전달 Parcelable 구현
//        Member member = new Member(
//                edtId.getText().toString(),
//                edtPw.getText().toString()
//        );
        intent.putExtras(bundle);
        startActivityForResult(intent, REQUEST_CODE);
    }
**/

    public void button_login_onclick(View v) {
        String id = edtId.getText().toString().trim();
        String pw = edtPw.getText().toString().trim();

        if (id.equals("forsaken") && pw.equals("1234")) {
            Intent intent = new Intent("com.n1books.dev.TEST_ACTION");
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"Wrong ID or PW!",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String msg = intent.getExtras().getString("msg");
                Toast.makeText(getApplicationContext(),
                        msg, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "누구냐 넌!", Toast.LENGTH_SHORT).show();
        }
    }
}
