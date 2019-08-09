package com.example.braingames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
EditText mail,pass,con,phone,name;
Button reg;
database obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mail=(EditText)findViewById(R.id.c);
       pass=(EditText)findViewById(R.id.d);
       con=(EditText)findViewById(R.id.e);
       phone=(EditText)findViewById(R.id.b);
       reg=(Button)findViewById(R.id.f);
       name=(EditText)findViewById(R.id.a);
       obj=new database(this);
       reg.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       int flag=1;
                       String p=phone.getText().toString();
                       for(int i=0;i<p.length();i++)
                       {
                           if(Character.isDigit(p.charAt(i))==true)
                           {
                           }
                           else
                           {
                               flag=0;
                           }
                       }
                      if((name.getText().toString().isEmpty() || phone.getText().toString().isEmpty() || pass.getText().toString().isEmpty() || con.getText().toString().isEmpty())) {
                          Toast.makeText(Register.this, "Please fill all the fields!!", Toast.LENGTH_SHORT).show();
                       }
                      else {
                          if (phone.getText().toString().length() == 10 && flag==1) {
                              if(pass.getText().toString().length()>=8&&con.getText().toString().length()>=8) {
                                  if (pass.getText().toString().equals(con.getText().toString())) {
                                      obj.add_reg(mail.getText().toString(), pass.getText().toString(),name.getText().toString());
                                      Intent i = new Intent(Register.this, login.class);
                                      Toast.makeText(Register.this, "You are successfully registered", Toast.LENGTH_SHORT).show();
                                      cln();
                                      startActivity(i);
                                  }
                                  else{
                                      Toast.makeText(Register.this, "Password and Confirm password should be same", Toast.LENGTH_SHORT).show();
                                  }
                              }
                              else {
                                  Toast.makeText(Register.this, "Length of the password should be of 8 digit", Toast.LENGTH_SHORT).show();
                              }


                          } else {
                              Toast.makeText(Register.this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show();

                          }
                      }




                   }
               }
       );

    }
    public void cln()
    {
     mail.setText(null);
     pass.setText(null);
     con.setText(null);
     phone.setText(null);
     name.setText(null);
     name.requestFocus();
    }
}
