package tech.app.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Home extends AppCompatActivity {

    int imageArr[] = {R.drawable.bgo, R.drawable.bgt, R.drawable.bgth};
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        iv = findViewById(R.id.sv_iv);

        Runnable r = new  Runnable(){
            int i=0;
            public void run()
            {
                iv.setImageResource(imageArr[i]);
                i++;
                if(i > imageArr.length-1)
                {
                    i = 0;
                }
                iv.postDelayed(this,5000);

            }
        };
        iv.postDelayed(r,5000);
    }
}
