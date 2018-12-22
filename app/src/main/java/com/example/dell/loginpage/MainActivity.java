package com.example.dell.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText)findViewById(R.id.etname);
        Password = (EditText)findViewById(R.id.etpassword);
        Info = (TextView)findViewById(R.id.textView);
        Login = (Button)findViewById(R.id.btnLogin);
        Info.setText("No of attemps remaining:5");
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }
    private void validate(String userName,String userPassword)
    {
        if ((userName.equals("a")) && (userPassword.equals("a"))){
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }else{ counter--;
            Info.setText("No of attemps remaining:"+ String.valueOf(counter));
               if (counter == 0){
                   Login.setEnabled(false);
               }

        }
    }
}
