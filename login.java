package com.example.braingames;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    TextView register;
    EditText email,pass;
    Button user,admin;
    database obj;
    static String m,p,mm,pp,nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register=(TextView)findViewById(R.id.textView2);
        user=(Button)findViewById(R.id.c);
        email=(EditText)findViewById(R.id.a);
        pass=(EditText)findViewById(R.id.b);
        admin=(Button)findViewById(R.id.button2);
        obj=new database(this);
        admin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            m=email.getText().toString();
                            p=pass.getText().toString();
                            if(m.isEmpty() || p.isEmpty())
                            {
                                Toast.makeText(login.this,"Please fill login details correctly!!",Toast.LENGTH_SHORT).show();
                            }
                            else if(m.equals("admin@gmail.com")&&p.equals("12345678")){
                                    Intent i = new Intent(login.this, admin_instruction.class);
                                    Toast.makeText(login.this,"LogIn Successful",Toast.LENGTH_SHORT).show();
                                    cln();
                                    startActivity(i);
                            }
                            else
                            {
                                Toast.makeText(login.this,"Invalid Login and password",Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception e) {
                            Toast.makeText(login.this, "Error Occured!! Try Again!!", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
        );
        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(login.this,Register.class);
                        startActivity(i);
                    }
                }
        );
        user.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            m=email.getText().toString();
                            p=pass.getText().toString();
                            Cursor cursor=obj.all_data_reg(m,p);
                            if(m.isEmpty() || p.isEmpty())
                            {
                             Toast.makeText(login.this,"Please fill login details correctly!!",Toast.LENGTH_SHORT).show();
                            }
                            else if(cursor.getCount()==0)
                            {
                                Toast.makeText(login.this,"Invalid Login and password",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                cursor.moveToFirst();
                                 mm=cursor.getString(0);
                                  pp=cursor.getString(1);
                                if(mm.equals(m)&&pp.equals(p)) {
                                    Intent i = new Intent(login.this, mcq_instruction.class);
                                    Toast.makeText(login.this,"LogIn Successful",Toast.LENGTH_SHORT).show();
                                    nm=cursor.getString(2);
                                    cln();
                                    startActivity(i);
                                }


                            }

                        } catch (Exception e) {
                            Toast.makeText(login.this, "Error Occured!! Try Again!!", Toast.LENGTH_SHORT).show();
                        }
                    } }
                    );

    }
    public void cln()
    {
      email.setText(null);
      email.requestFocus();
      pass.setText(null);
    }
}
