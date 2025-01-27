package tech.app.bloodbank;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SignUpTwo extends AppCompatActivity implements  View.OnClickListener{
    int checkRg1=0, checkRg2=0;
    Button finish;
    String blood="", bFactor="";
    TextView showBlood;
    RadioButton radioButton;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String userKey = "nameKey";
    public static final String passKey = "emailKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_two);

        showBlood = findViewById(R.id.tvShowBlood);
        finish = findViewById(R.id.finishBt);
        finish.setOnClickListener(this);
        sharedpreferences = getApplicationContext().getSharedPreferences(mypreference, 0); // 0 - for private mode

    }

    public void onBloodSelected(View view) {
        RadioGroup radioGroup = findViewById(R.id.rgBlood);
        switch (radioGroup.getCheckedRadioButtonId())
        {
            case R.id.rbA:
                //Toast.makeText(this, "A blood group", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rbA);
                blood = "A";
                showBlood.setText("Your blood group is: "+blood+bFactor);
                checkRg1=1;
                break;
            case R.id.rbB:
                //Toast.makeText(this, "B blood group", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rbB);
                blood = "B";
                showBlood.setText("Your blood group is: "+blood+bFactor);
                checkRg1=1;
                break;
            case R.id.rbO:
                //Toast.makeText(this, "O blood group", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rbO);
                blood = "O";
                showBlood.setText("Your blood group is: "+blood+bFactor);
                checkRg1=1;
                break;
            case R.id.rbAB:
                //Toast.makeText(this, "AB blood group", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rbAB);
                blood = "AB";
                showBlood.setText("Your blood group is: "+blood+bFactor);
                checkRg1=1;
                break;
        }

        if(checkRg1 == 1 && checkRg2 == 1)
        {
            finish.setEnabled(true);
        }
        else
        {
            finish.setEnabled(false);
        }
    }

    public void onFactorSelected(View view) {

        RadioGroup radioGroup = findViewById(R.id.rgFactor);
        switch (radioGroup.getCheckedRadioButtonId())
        {
            case R.id.rbPlus:
                //Toast.makeText(this, "+ factor", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rbPlus);
                bFactor = "+(ve)";
                showBlood.setText("Your blood group is: "+blood+bFactor);
                checkRg2=1;
                break;
            case R.id.rbMinus:
                //Toast.makeText(this, "- factor", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rbMinus);
                bFactor = "-(ve)";
                showBlood.setText("Your blood group is: "+blood+bFactor);
                checkRg2=1;
                break;
        }

        if(checkRg1 == 1 && checkRg2 == 1)
        {
            finish.setEnabled(true);
        }
        else
        {
            finish.setEnabled(false);
        }
    }

    String dob,phone,name,email,b_group,pass;
    @Override
    public void onClick(View v) {
        Bundle bundle = getIntent().getExtras();
         b_group = blood+bFactor;
        System.out.println(b_group);
         name = bundle.getString("nam");
         email = bundle.getString("mail");
         phone = bundle.getString("num");
        dob = bundle.getString("dob");
        pass = bundle.getString("pass");
        String url = "https://mrrobi.tech/dld/signup.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(SignUpTwo.this,response,Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(userKey, phone);
                editor.putString(passKey, pass);
                editor.commit();
                if(response.equals("SignUp Successful...")){
                    Intent intent = new Intent(SignUpTwo.this,Login.class);
                    //Intent intent = new Intent(Login.this,home.class);
                    startActivity(intent);
                    finish();
                }else{

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Error");
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("username",phone);
                params.put("pass",pass);
                params.put("dob",dob);
                params.put("email",email);
                params.put("name",name);
                params.put("b_group",b_group);
                return params;
            }
        };
        MySingleton.getInstance(SignUpTwo.this).addToRequestQueue(stringRequest);
    }
}
