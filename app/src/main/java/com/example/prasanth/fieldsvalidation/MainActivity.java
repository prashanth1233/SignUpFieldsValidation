package com.example.prasanth.fieldsvalidation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.prasanth.fieldsvalidation.utils.FieldValidator;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText userName, password, reEnterPassword, mobileNumber, emailAddress;
    private Button signUpButton;
    private FieldValidator fieldValidatorInstance;
    private TextView signInLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        intiViews();
    }

    public void intiViews() {
        userName = (EditText) findViewById(R.id.signUpUserNameET);
        password = (EditText) findViewById(R.id._signUpPasswordET);
        reEnterPassword = (EditText) findViewById(R.id._signUpReenterPasswordET);
        mobileNumber = (EditText) findViewById(R.id._mobileNumberET);
        emailAddress = (EditText) findViewById(R.id.emailAddressET);
        signInLink = (TextView) findViewById(R.id.signInPageLink);
        signUpButton = (Button) findViewById(R.id.SignUpButton);

        signUpButton.setOnClickListener(this);
        signInLink.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.SignUpButton:
                if (validateUserDetails()) {
                    Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.signInPageLink:
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            default:
                break;
        }
    }


    private boolean validateUserDetails() {
        fieldValidatorInstance = new FieldValidator();

        return fieldValidatorInstance.validateUserNameSpace(userName) &&
                fieldValidatorInstance.validatePassword(password) &&
                fieldValidatorInstance.validatePhoneNumberSpace(mobileNumber) &&
                fieldValidatorInstance.validateEmailAddress(emailAddress) &&
                fieldValidatorInstance.validatePasswordMatch(password, reEnterPassword);
    }


}
