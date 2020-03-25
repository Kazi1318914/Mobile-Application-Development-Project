package tech.app.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RequestForBlood extends AppCompatActivity implements View.OnClickListener{

    TextView showBlood;
    String blood="", bFactor="";
    RadioButton radioButton;
    int checkRg1=0, checkRg2=0, checkRg3=0, checkRg4=0, bag;
    Button request;
    String gender="";
    com.google.android.material.textfield.TextInputEditText message, addresss;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_for_blood);

        showBlood = findViewById(R.id.tvRShowBlood);
        request = findViewById(R.id.requestBt);
        message = (com.google.android.material.textfield.TextInputEditText)findViewById(R.id.etReason);
        addresss = (com.google.android.material.textfield.TextInputEditText)findViewById(R.id.etAddress);

        //request.setOnClickListener(this);

        message.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(!message.getText().toString().isEmpty() && !addresss.getText().toString().isEmpty())
                {
                    if(checkRg1 == 1 && checkRg2 == 1 && checkRg3 == 1 && checkRg4 == 1)
                    {
                        request.setEnabled(true);
                    }
                }
                else{
                    request.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        addresss.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(!message.getText().toString().isEmpty() && !addresss.getText().toString().isEmpty())
                {
                    if(checkRg1 == 1 && checkRg2 == 1 && checkRg3 == 1 && checkRg4 == 1)
                    {
                        request.setEnabled(true);
                    }
                }
                else{
                    request.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        request.setOnClickListener(this);
    }

    public void onRequestBloodSelected(View view) {
        RadioGroup radioGroup = findViewById(R.id.rrgBlood);
        switch (radioGroup.getCheckedRadioButtonId())
        {
            case R.id.rrbA:
                //Toast.makeText(this, "A blood group", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rrbA);
                blood = "A";
                showBlood.setText("Blood group is: "+blood+bFactor);
                checkRg1=1;
                break;
            case R.id.rrbB:
                //Toast.makeText(this, "B blood group", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rrbB);
                blood = "B";
                showBlood.setText("Blood group is: "+blood+bFactor);
                checkRg1=1;
                break;
            case R.id.rrbO:
                //Toast.makeText(this, "O blood group", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rrbO);
                blood = "O";
                showBlood.setText("Blood group is: "+blood+bFactor);
                checkRg1=1;
                break;
            case R.id.rrbAB:
                //Toast.makeText(this, "AB blood group", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rrbAB);
                blood = "AB";
                showBlood.setText("Blood group is: "+blood+bFactor);
                checkRg1=1;
                break;
        }

        if(checkRg1 == 1 && checkRg2 == 1 && checkRg3 == 1 && checkRg4 == 1)
        {
            if(!message.getText().toString().isEmpty() && !addresss.getText().toString().isEmpty())
            {
                request.setEnabled(true);
            }
        }
        else
        {
            request.setEnabled(false);
        }


    }

    public void onRequestFactorSelected(View view) {
        RadioGroup radioGroup = findViewById(R.id.rrgFactor);
        switch (radioGroup.getCheckedRadioButtonId())
        {
            case R.id.rrbPlus:
                //Toast.makeText(this, "+ factor", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rrbPlus);
                bFactor = "+(ve)";
                showBlood.setText("Blood group is: "+blood+bFactor);
                checkRg2=1;
                break;
            case R.id.rrbMinus:
                //Toast.makeText(this, "- factor", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rrbMinus);
                bFactor = "-(ve)";
                showBlood.setText("Blood group is: "+blood+bFactor);
                checkRg2=1;
                break;
        }

        if(checkRg1 == 1 && checkRg2 == 1 && checkRg3 == 1 && checkRg4 == 1)
        {
            if(!message.getText().toString().isEmpty() && !addresss.getText().toString().isEmpty())
            {
                request.setEnabled(true);
            }
        }
        else
        {
            request.setEnabled(false);
        }


    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Request has sent", Toast.LENGTH_SHORT).show();
    }

    public void onRequestGenderSelected(View view) {
        RadioGroup radioGroup = findViewById(R.id.rrgGender);
        switch (radioGroup.getCheckedRadioButtonId())
        {
            case R.id.rrbMale:
                //Toast.makeText(this, "+ factor", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rrbMale);
                gender = "male";
                checkRg3=1;
                break;
            case R.id.rrbFemale:
                //Toast.makeText(this, "- factor", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rrbFemale);
                gender = "female";
                checkRg3=1;
                break;
        }

        if(checkRg1 == 1 && checkRg2 == 1 && checkRg3 == 1 && checkRg4 == 1)
        {
            if(!message.getText().toString().isEmpty() && !addresss.getText().toString().isEmpty())
            {
                request.setEnabled(true);
            }
        }
        else
        {
            request.setEnabled(false);
        }


    }

    public void onRequestBagSelected(View view) {
        RadioGroup radioGroup = findViewById(R.id.rrgBag);
        switch (radioGroup.getCheckedRadioButtonId())
        {
            case R.id.rrbOne:
                //Toast.makeText(this, "+ factor", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rrbOne);
                bag = 1;
                checkRg4=1;
                break;
            case R.id.rrbTwo:
                //Toast.makeText(this, "- factor", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rrbTwo);
                bag = 2;
                checkRg4=1;
                break;
            case R.id.rrbThree:
                //Toast.makeText(this, "- factor", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rrbThree);
                bag = 3;
                checkRg4=1;
                break;
            case R.id.rrbFour:
                //Toast.makeText(this, "- factor", Toast.LENGTH_SHORT).show();
                radioButton = findViewById(R.id.rrbFour);
                bag = 4;
                checkRg4=1;
                break;
        }

        if(checkRg1 == 1 && checkRg2 == 1 && checkRg3 == 1 && checkRg4 == 1)
        {
            if(!message.getText().toString().isEmpty() && !addresss.getText().toString().isEmpty())
            {
                request.setEnabled(true);
            }
        }
        else
        {
            request.setEnabled(false);
        }

    }
}
