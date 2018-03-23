package net.n1books.dev.intenttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("c504","※※※onStarting※※※");
        Toast.makeText(getApplicationContext(),"onStarting",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("c504","※※※onResuming※※※");
        Toast.makeText(getApplicationContext(),"onResuming",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("c504","onDestroying");
        Toast.makeText(getApplicationContext(),"onDestroying",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("c504","※※※onPausing※※※");
        Toast.makeText(getApplicationContext(),"onPausing",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("c504","※※※onStopping※※※");
        Toast.makeText(getApplicationContext(),"onStopping",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d("c504","※※※onCreating※※※");
        Toast.makeText(getApplicationContext(),"onCreation",Toast.LENGTH_SHORT).show();


    }
}
