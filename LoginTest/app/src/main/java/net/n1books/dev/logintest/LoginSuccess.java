package net.n1books.dev.logintest;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginSuccess extends AppCompatActivity {


    Button btnClose;
    ImageButton btnHorde;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        Button btnClose = findViewById(R.id.btnClose);
        ImageButton btnHorde = findViewById(R.id.imgHorde);

        /** Intent에 Member오브젝트 전달 Parcelable 사용
        Intent intent = getIntent();
         Member member = (Member) intent.getExtras().get("member");
         String id = member.getId();
         String pw = member.getPw();

         //3. 번들이용방식
         Bundle bundle = intent.getExtras();
         String id = (String) bundle.get("id");
         String pw = (String) bundle.get("pw");
         for (String key : bundle.keySet()) {
            Log.d("c504", key + " : " + bundle.get(key) + "♣♣♣♣);
         }

         if( id.equals("next") && pw.equals("1111") {
            editResult.setText(id + " 님이 로그인 하였습니다.");
         } else {
            editResult.setText("아이디 혹은 비밀번호가 틀립니다.");
         }
         **/
    }

    public void btnClose_click (View v) {
        finish();
    }

    public void imgHorde_click (View v) {
        Toast.makeText(getApplicationContext(),"For the Horde!",Toast.LENGTH_SHORT).show();
    }

    public void imgAlliance_click (View v) {
        Toast.makeText(getApplicationContext(),"For the Alliance!",Toast.LENGTH_SHORT).show();
    }
}
