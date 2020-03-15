package tech.app.bloodbank;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String userKey = "nameKey";
    public static final String passKey = "emailKey";
    com.google.android.material.textfield.TextInputEditText username , password;
    Button login,signup,forgot_pass;
    private final String user="username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.pass);
        login = findViewById(R.id.btn_login);
        signup = findViewById(R.id.btn_signup);
        forgot_pass = findViewById(R.id.btn_forgot_pass);

        login.setOnClickListener(this);
        signup.setOnClickListener(this);
        forgot_pass.setOnClickListener(this);
        sharedpreferences = getApplicationContext().getSharedPreferences(mypreference, 0); // 0 - for private mode

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //here is your code
                if(!password.getText().toString().isEmpty()&&!username.getText().toString().isEmpty()){
                    login.setEnabled(true);
                }else{
                    login.setEnabled(false);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //here is your code
                if(!password.getText().toString().isEmpty()&&!username.getText().toString().isEmpty()){
                    login.setEnabled(true);
                }else{
                    login.setEnabled(false);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v == login){
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String url = "https://mrrobi.tech/dld/login.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(Login.this,response,Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(userKey, username.getText().toString());
                    editor.putString(passKey, password.getText().toString());
                    editor.commit();
                    username.setText("");
                    password.setText("");
                    if(response.equals("Login Successful...")){
                        Intent intent = new Intent(Login.this,Home.class);
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
                    params.put("username",username.getText().toString());
                    params.put("pass",password.getText().toString());
                    return params;
                }
            };
            MySingleton.getInstance(Login.this).addToRequestQueue(stringRequest);

        }else if(v == signup){
            //Toast.makeText(this,"signup Button pressed",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Login.this, SignUpOne.class);
            startActivity(i);
        }else if(v == forgot_pass){
            Toast.makeText(this,"forgot Button pressed",Toast.LENGTH_SHORT).show();
        }
    }
}
