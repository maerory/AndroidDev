package net.n1books.dev.numbergame;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Main3Activity extends AppCompatActivity {

    int[] buttons = {
            R.id.imageButton1, R.id.imageButton2
    };
    int blank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        blank=1;
    }

    public void imgBtn_onClick(View view) {
        int current = getCurrent(view.getId());
        ImageButton currentImage = (ImageButton) findViewById(buttons[current]);
        ImageButton blankImage = (ImageButton) findViewById(buttons[blank]);
        Drawable background = currentImage.getBackground();
        currentImage.setBackground(blankImage.getBackground());
        blankImage.setBackground(background);
        blank = current;
    }

    private int getCurrent(int id) {
        for (int i=0; i < buttons.length; i++) {
            if (buttons[i] == id) {
                return i;
            }
        }
        return -1;
    }

}
