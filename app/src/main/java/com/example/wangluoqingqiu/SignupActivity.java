package com.example.wangluoqingqiu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private SharedPreferences.Editor editor;

    private EditText accountEdit;

    private EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
            actionBar.hide();
        editor=getSharedPreferences("data",MODE_PRIVATE).edit();
        accountEdit=findViewById(R.id.user_account_1);
        passwordEdit=findViewById(R.id.user_key_2);
        Button button=findViewById(R.id.button_6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account=accountEdit.getText().toString();
                String password=passwordEdit.getText().toString();
                editor.putString("account",account);
                editor.putString("password",password);
                editor.apply();
                Toast.makeText(SignupActivity.this,"注册成功！",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
