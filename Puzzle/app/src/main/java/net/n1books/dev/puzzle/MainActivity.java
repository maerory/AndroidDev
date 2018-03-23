package net.n1books.dev.puzzle;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] ibuttons = {
            R.id.ibutton1,
            R.id.ibutton2,
            R.id.ibutton3,
            R.id.ibutton4,
            R.id.ibutton5,
            R.id.ibutton6,
            R.id.ibutton7,
            R.id.ibutton8,
            R.id.ibutton9
    };

    int[] images = {
            R.drawable.button1,
            R.drawable.button2,
            R.drawable.button3,
            R.drawable.button4,
            R.drawable.button5,
            R.drawable.button6,
            R.drawable.button7,
            R.drawable.button8,
            R.drawable.blank
    };

    int blank = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shuffle(667);
    }

    private void shuffle(int n) {
        for (int i = 0; i < n; i++) {
            int current1 = (int) (Math.random() * 9);
            int current2 = blank;

            ImageButton currentImage1 = findViewById(ibuttons[current1]);
            ImageButton currentImage2 = findViewById(ibuttons[current2]);

            Drawable background = currentImage1.getBackground();
            currentImage1.setBackground(currentImage2.getBackground());
            currentImage2.setBackground(background);
            blank = current1;
        }
    }

    public void btn_onClick(View v) {
        int current = getCurrent(v.getId());
        int[] available;

        if (ibuttons[current] == blank) {
            return;
        }

        if (current % 3 == 0) {
            available = new int[]{current - 3, current + 1, current + 3};
        } else if (current % 3 == 1) {
            available = new int[]{current - 3, current - 1, current + 1, current + 3};
        } else {
            available = new int[]{current - 3, current - 1, current + 3};
        }

        for (int i = 0; i < available.length; i++) {
            if (available[i] == blank) {
                ImageButton currentImage = findViewById(ibuttons[current]);
                ImageButton blankImage = findViewById(ibuttons[blank]);
                Drawable background = currentImage.getBackground();
                currentImage.setBackground(blankImage.getBackground());
                blankImage.setBackground(background);
                blank = current;
            }
        }
    }

    private int getCurrent(int id) {
        for (int i = 0; i < ibuttons.length; i++) {
            if (ibuttons[i] == id) {
                return i;
            }
        }
        return -1;
    }
}
