package com.example.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Login;
    EditText Password;
    TextView Result;
    //private static final int pass=89918032;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login=findViewById(R.id.btn);
        Password=findViewById(R.id.edt);
        //Result=findViewById(R.id.txt2);

        Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String pass1=Password.getText().toString();
                //Result.setText(pass1);

                if (pass1.equals("89918032p"))
                {
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }
               else {
                    Toast.makeText(MainActivity.this,"Wrong password, please enter the correct password",Toast.LENGTH_LONG).show();
                }
                    //validate(Password.getText().toString());
            }
        });
    }

//    private void validate(String userPassword)
//    {
//        if(userPassword=="89918032")
//        {
//            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
//            startActivity(intent);
//        }
//        else{
//            Toast.makeText(MainActivity.this,"Wrong password, please enter the correct password",Toast.LENGTH_LONG).show();
//        }
//    }
}
