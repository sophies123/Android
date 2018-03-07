package com.hdu.a15061103.test201801;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private Button affirmButton;
    private String Name;
    private String Password;
    private Context mContext;
    private String pass="123456";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name_text);
        password=(EditText)findViewById(R.id.passwords);
        affirmButton=(Button)findViewById(R.id.AffirmButton);
        affirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name=name.getText().toString();
                Password=password.getText().toString();
                Intent i=new Intent(MainActivity.this,DetailActivity.class);
                if(Password.equals(pass)){
                    startActivity(i);

                }
                /*else{
                    Toast.makeText(mContext,"密码错误", Toast.LENGTH_SHORT).show();
                }*/
            }
        });

    }
}
