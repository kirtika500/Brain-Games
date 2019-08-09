package com.example.braingames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class admin_set_ques extends AppCompatActivity {
Spinner sp;
String sub[]={"-Select subject-","C","DSA","DBMS","JAVA","LINUX"};
EditText q,o1,o2,o3,o4,an;
database ob;
Button su,sk;
String g;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_set_ques);
        sp=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String>obj=new ArrayAdapter<>(admin_set_ques.this,R.layout.support_simple_spinner_dropdown_item,sub);
        sp.setAdapter(obj);
        q=(EditText)findViewById(R.id.a);
    o1=(EditText)findViewById(R.id.b);
     o2=(EditText)findViewById(R.id.c);
     o3=(EditText)findViewById(R.id.d);
     o4=(EditText)findViewById(R.id.e);
    an=(EditText)findViewById(R.id.f);
    su=(Button)findViewById(R.id.sub1);
    sk=(Button)findViewById(R.id.sk1);
    ob=new database(this);
       sp.setOnItemSelectedListener(
               new AdapterView.OnItemSelectedListener() {
                   @Override
                   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                       g=sp.getSelectedItem().toString();
                       Toast.makeText(admin_set_ques.this,"Selected="+g,Toast.LENGTH_SHORT).show();

                   }

                   @Override
                   public void onNothingSelected(AdapterView<?> parent) {

                   }
               }
       );
        su.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(g.equals("C"))
                        {
                            if(q.getText().toString().isEmpty()||o1.getText().toString().isEmpty()||o2.getText().toString().isEmpty()||o3.getText().toString().isEmpty()||o4.getText().toString().isEmpty()||an.getText().toString().isEmpty())
                            {
                                Toast.makeText(admin_set_ques.this,"Please fill it coorrectly",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                ob.add_c(q.getText().toString(), o1.getText().toString(), o2.getText().toString(), o3.getText().toString(), o4.getText().toString(), an.getText().toString());
                                Toast.makeText(admin_set_ques.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                                cln();
                            }
                        }
                        else if(g.equals("DSA"))
                        {
                            if(q.getText().toString().isEmpty()||o1.getText().toString().isEmpty()||o2.getText().toString().isEmpty()||o3.getText().toString().isEmpty()||o4.getText().toString().isEmpty()||an.getText().toString().isEmpty())
                            {
                                Toast.makeText(admin_set_ques.this,"Please fill it coorrectly",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                ob.add_dsa(q.getText().toString(), o1.getText().toString(), o2.getText().toString(), o3.getText().toString(), o4.getText().toString(), an.getText().toString());
                                Toast.makeText(admin_set_ques.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                                cln();
                            }

                        }
                        else if(g.equals("DBMS"))
                        {
                            if(q.getText().toString().isEmpty()||o1.getText().toString().isEmpty()||o2.getText().toString().isEmpty()||o3.getText().toString().isEmpty()||o4.getText().toString().isEmpty()||an.getText().toString().isEmpty())
                            {
                                Toast.makeText(admin_set_ques.this,"Please fill it coorrectly",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                ob.add_dbms(q.getText().toString(), o1.getText().toString(), o2.getText().toString(), o3.getText().toString(), o4.getText().toString(), an.getText().toString());
                                Toast.makeText(admin_set_ques.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                                cln();
                            }
                        }
                        else if(g.equals("JAVA"))
                        {
                            if(q.getText().toString().isEmpty()||o1.getText().toString().isEmpty()||o2.getText().toString().isEmpty()||o3.getText().toString().isEmpty()||o4.getText().toString().isEmpty()||an.getText().toString().isEmpty())
                            {
                                Toast.makeText(admin_set_ques.this,"Please fill it coorrectly",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                ob.add_java(q.getText().toString(), o1.getText().toString(), o2.getText().toString(), o3.getText().toString(), o4.getText().toString(), an.getText().toString());
                                Toast.makeText(admin_set_ques.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                                cln();
                            }
                        }
                        else if(g.equals("LINUX"))
                        {
                            if(q.getText().toString().isEmpty()||o1.getText().toString().isEmpty()||o2.getText().toString().isEmpty()||o3.getText().toString().isEmpty()||o4.getText().toString().isEmpty()||an.getText().toString().isEmpty())
                            {
                                Toast.makeText(admin_set_ques.this,"Please fill it coorrectly",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                ob.add_linux(q.getText().toString(), o1.getText().toString(), o2.getText().toString(), o3.getText().toString(), o4.getText().toString(), an.getText().toString());
                                Toast.makeText(admin_set_ques.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                                cln();
                            }
                        }
                        else {
                            Toast.makeText(admin_set_ques.this,"Please select subject",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
         sk.setOnClickListener(
                 new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         cln();
                     }
                 }
         );

    }
    public void cln(){
     q.setText(null);
     q.requestFocus();
     o1.setText(null);
     o2.setText(null);
     o3.setText(null);
     o4.setText(null);
     an.setText(null);
    }
}
