package com.example.braingames;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.braingames.login.nm;

public class select_sub extends AppCompatActivity {
Button c11,dsa1,dbms,java,linux;
static String sub;
TextView us;
    database ob;
    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sub);
        c11=(Button)findViewById(R.id.c12);
        dsa1=(Button)findViewById(R.id.dsa);
        dbms=(Button)findViewById(R.id.db);
        java=(Button)findViewById(R.id.ja);
        linux=(Button)findViewById(R.id.lin);
        us=(TextView)findViewById(R.id.a2);
        us.setText(nm);
         ob=new database(this);
        c11.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sub="C";
                        Cursor cu = ob.info_c(i);
                        if (cu.getCount() == 0) {

                            Toast.makeText(select_sub.this, "There are no question set..", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Intent j=new Intent(select_sub.this,user_answer.class);
                            startActivity(j);
                        }

                    }
                }
        );
        dsa1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sub="DSA";
                        Cursor cu = ob.info_c(i);
                        if (cu.getCount() == 0) {

                            Toast.makeText(select_sub.this, "There are no question set..", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Intent j=new Intent(select_sub.this,user_dsa.class);
                            startActivity(j);
                        }
                    }
                }
        );
        dbms.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sub="DBMS";
                        Cursor cu = ob.info_dbms(i);
                        if (cu.getCount() == 0) {

                            Toast.makeText(select_sub.this, "There are no question set..", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Intent j=new Intent(select_sub.this,user_dbms.class);
                            startActivity(j);
                        }
                    }
                }
        );
        java.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sub="JAVA";
                        Cursor cu = ob.info_java(i);
                        if (cu.getCount() == 0) {

                            Toast.makeText(select_sub.this, "There are no question set..", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Intent j=new Intent(select_sub.this,user_java.class);
                            startActivity(j);
                        }
                    }
                }
        );
        linux.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sub="LINUX";
                        Cursor cu = ob.info_linux(i);
                        if (cu.getCount() == 0) {

                            Toast.makeText(select_sub.this, "There are no question set..", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Intent j=new Intent(select_sub.this,user_linux.class);
                            startActivity(j);
                        }
                    }
                }
        );
    }
}
