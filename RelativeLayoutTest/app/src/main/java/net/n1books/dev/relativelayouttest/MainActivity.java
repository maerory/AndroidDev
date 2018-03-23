package net.n1books.dev.relativelayouttest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText edtURL;
    Button btnOk, btnCancel;
    WebView webView;

    InputMethodManager inputMethodManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtURL = findViewById(R.id.edtURL);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);
        webView = findViewById(R.id.webView);

        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = edtURL.getText().toString();
                if (!url.substring(0,7).equals("http://")) {
                    url = "http://" + url;
                }
                inputMethodManager.hideSoftInputFromWindow(edtURL.getWindowToken(),0);
                webView.getSettings().setJavaScriptEnabled(true); //Allow JSP pages???
                webView.setWebViewClient(new MyWebViewClient());
                webView.loadUrl(url);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
