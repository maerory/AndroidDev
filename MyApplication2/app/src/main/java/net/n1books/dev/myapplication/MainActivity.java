package net.n1books.dev.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        LinearLayout linearLayout = new LinearLayout(this); //순차적으로 Layout을 찍어주는 클래스
//        button = new Button(this);
//        button.setText("Hit Me!");
//        linearLayout.addView(button); //button 도 view를 상속받았음
//        setContentView(linearLayout); //XML 값 아니면 화면 배치 변수 필요. 여기서는 linearLayout 이용
        button = findViewById(R.id.button);
        //button.setOnClickListener(this);
    }

    public void onClick(View view) {
        Toast.makeText(getApplication(), "You dare speak to me!?", Toast.LENGTH_LONG).show();
        //1. MainActivity 에 OnclickListener를 바로 상속받아서 만들기
        //2. ButtonClick class를 새로 만들어서 넣어주기
        //3. View Onclick Listener를 일회용으로 Overriding 해주기
    }

    class ButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplication(), "You dare speak to me!", Toast.LENGTH_LONG).show();
        } //inner class
    }


}
