package tech.app.bloodbank;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpOne extends AppCompatActivity implements View.OnClickListener{
    int currentYear, currentMonth, currentDay;
    Button dob, next;
    TextView dobtv;
    com.google.android.material.textfield.TextInputEditText name, email, number,passtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_one);

        dob = (Button)findViewById(R.id.dobBt);
        next = (Button)findViewById(R.id.nextBt);
        name = (com.google.android.material.textfield.TextInputEditText)findViewById(R.id.etname);
        email = (com.google.android.material.textfield.TextInputEditText)findViewById(R.id.etemail);
        number = (com.google.android.material.textfield.TextInputEditText)findViewById(R.id.etnumber);
        passtv = (com.google.android.material.textfield.TextInputEditText)findViewById(R.id.password);
        dob.setOnClickListener(this);
        next.setOnClickListener(this);


        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(!name.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !number.getText().toString().isEmpty() && !passtv.getText().toString().isEmpty())
                {
                    next.setEnabled(true);
                }
                else{
                    next.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(!name.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !number.getText().toString().isEmpty()&& !passtv.getText().toString().isEmpty() && !dob.getText().toString().equals("Pick your date of birth"))
                {
                    next.setEnabled(true);
                }
                else{
                    next.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(!name.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !number.getText().toString().isEmpty()&& !passtv.getText().toString().isEmpty() && !dob.getText().toString().equals("Pick your date of birth"))
                {
                    next.setEnabled(true);
                }
                else{
                    next.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        passtv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(!name.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !number.getText().toString().isEmpty()&& !passtv.getText().toString().isEmpty() && !dob.getText().toString().equals("Pick your date of birth"))
                {
                    next.setEnabled(true);
                }
                else{
                    next.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View v) {

        DatePicker datePicker = new DatePicker(this);
        currentDay = datePicker.getDayOfMonth();
        currentMonth = datePicker.getMonth()+1;
        currentYear = datePicker.getYear();

        //LocalDate today = LocalDate.of(currentYear, currentMonth, currentDay);
        //LocalDate birthDay;
        if(v == dob)
        {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            //birthDay = LocalDate.of(year, month+1, dayOfMonth);
                            dob.setText(dayOfMonth + "-" + (month+1) + "-" + year);
                            if(!name.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !number.getText().toString().isEmpty()&& !passtv.getText().toString().isEmpty() && !dob.getText().toString().equals("Pick your date of birth"))
                            {
                                next.setEnabled(true);
                            }
                        }
                    },
                    currentYear, currentMonth, currentDay);

            datePickerDialog.show();

            /*String s = dobtv.getText().toString();
            String ax[] = s.split("-");
            birthDay = LocalDate.of(Integer.parseInt(ax[2]),Integer.parseInt(ax[1]),Integer.parseInt(ax[0]));
            Period p = Period.between(birthDay, today);
            if(p.getYears() >= 18)
            {
                next.setEnabled(true);
            }
            else{
                next.setEnabled(false);
            }*/
        }
        else if(v == next)
        {
            //Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show();
            //Intent i = new Intent(SignUpOne.this, SignUpTwo.class);
            //startActivity(i);

            String s = dob.getText().toString();
            String ax[] = s.split("-");
            //Toast.makeText(this,ax[0]+ax[1]+ax[2],Toast.LENGTH_SHORT).show();
            int age = (currentYear - Integer.parseInt(ax[2]));
            if(currentMonth < Integer.parseInt(ax[1]))
            {
                age-=1;
            }
            /*if(age >= 18)
            {
                Intent i = new Intent(SignUpOne.this, SignUpTwo.class);
                startActivity(i);
            }*/
            if (age < 18)
            {
                Toast.makeText(this,"Your age must have to be 18 years or above",Toast.LENGTH_SHORT).show();
            }
            else if(age >= 18 && validate(email.getText().toString()))
            {
                Intent i = new Intent(SignUpOne.this, SignUpTwo.class);
                i.putExtra("nam", name.getText().toString());
                i.putExtra("mail", email.getText().toString());
                i.putExtra("num", number.getText().toString());
                i.putExtra("dob", dob.getText().toString());
                i.putExtra("pass",passtv.getText().toString());
                startActivity(i);
            }
            else
            {
                Toast.makeText(this,"Not a valid email",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
}
