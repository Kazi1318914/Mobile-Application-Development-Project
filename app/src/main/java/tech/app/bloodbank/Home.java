package tech.app.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Home extends AppCompatActivity implements  View.OnClickListener{

    int imageArr[] = {R.drawable.bgo, R.drawable.bgt, R.drawable.bgth};
    ImageView iv;
    ImageView[][] pImageViews = new ImageView[2][3];
    TextView[][] pTextViews = new TextView[2][3];

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
                iv.postDelayed(this,5000);  //rest of the delay

            }
        };
        iv.postDelayed(r,5000);                     //for the 1st delay

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                String imgID = "iv"+i+j;
                String txtID = "tv"+i+j;
                pImageViews[i][j] = findViewById(getResources().getIdentifier(imgID, "id", getPackageName()));
                pTextViews[i][j] = findViewById(getResources().getIdentifier(txtID, "id", getPackageName()));

                pImageViews[i][j].setOnClickListener(this);
                pTextViews[i][j].setOnClickListener(this);
            }
        }
    }

    public void test(View view) {
        Toast.makeText(this,"LayoutClickableDone",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                    if(v == pImageViews[i][j] || v == pTextViews[i][j])
                    {
                        if(i == 0 && j == 0)
                        {
                            Intent it = new Intent(this, RequestForBlood.class);
                            startActivity(it);
                        }
                        else if(i == 0 && j == 1)
                        {
                            Toast.makeText(this, "Feed", Toast.LENGTH_SHORT).show();

                        }
                        else if(i == 0 && j == 2)
                        {
                            Toast.makeText(this, "Organization", Toast.LENGTH_SHORT).show();

                        }
                        else if(i == 1 && j == 0)
                        {
                            Toast.makeText(this, "Ambulance", Toast.LENGTH_SHORT).show();

                        }
                        else if(i == 1 && j == 1)
                        {
                            Toast.makeText(this, "I Sleep", Toast.LENGTH_SHORT).show();

                        }
                        else if(i == 1 && j == 2)
                        {
                            Toast.makeText(this, "Info", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
            }
    }
}
