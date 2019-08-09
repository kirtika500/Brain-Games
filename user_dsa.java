package com.example.braingames;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.braingames.login.nm;

public class user_dsa extends AppCompatActivity {
    TextView ques,aa1,aa2;
    RadioGroup rg;
    RadioButton op1,op2,op3,op4,res;
    static int mark_dsa=0,count_dsa=0;
    database ob;
    int i=1;
    int k=1;
    Button submit,skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dsa);
        ques=(TextView) findViewById(R.id.aa);
        op1=(RadioButton) findViewById(R.id.bb);
        op2=(RadioButton) findViewById(R.id.cc);
        op3=(RadioButton) findViewById(R.id.dd);
        op4=(RadioButton) findViewById(R.id.ee);
        rg=(RadioGroup)findViewById(R.id.r);
        submit=(Button)findViewById(R.id.subb);
        skip=(Button)findViewById(R.id.skk);
        aa1=(TextView)findViewById(R.id.a1);
        aa2=(TextView)findViewById(R.id.a2);
        aa2.setText(nm);
        ob=new database(this);


        try {
            Cursor cu = ob.info_dsa(i);
            if (cu.getCount() == 0) {

                Toast.makeText(user_dsa.this, "There are no question set..", Toast.LENGTH_SHORT).show();
            } else {
                cu.moveToFirst();
                ques.setText(cu.getString(1));
                op1.setText(cu.getString(2));
                op2.setText(cu.getString(3));
                op3.setText(cu.getString(4));
                op4.setText(cu.getString(5));
                aa1.setText(""+i);

                op1.setChecked(true);
            }
        }
        catch (Exception e)
        {
            Toast.makeText(user_dsa.this,"Error occured!Try Again",Toast.LENGTH_SHORT).show();
        }
        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(i<5) {
                            int id = rg.getCheckedRadioButtonId();
                            res = (RadioButton) findViewById(id);
                            Cursor cu = ob.info_dsa(i);
                            cu.moveToFirst();
                            String result = res.getText().toString();
                            if (result.equals(cu.getString(6))) {
                                mark_dsa=mark_dsa+5;
                                count_dsa++;
                                Toast.makeText(user_dsa.this, "Secured=5", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(user_dsa.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                            }
                            i++;
                            if(k<5)
                            {
                                try {
                                    cu = ob.info_dsa(i);
                                    if (cu.getCount() == 0) {
                                    } else {
                                        cu.moveToFirst();
                                        ques.setText(cu.getString(1));
                                        op1.setText(cu.getString(2));
                                        op2.setText(cu.getString(3));
                                        op3.setText(cu.getString(4));
                                        op4.setText(cu.getString(5));
                                        aa1.setText(""+i);
                                        op1.setChecked(true);
                                        k++;
                                    }

                                } catch (Exception t) {

                                }
                            }
                        }
                        else
                        {
                            Intent j=new Intent(user_dsa.this,result_dsa.class);
                            int id = rg.getCheckedRadioButtonId();
                            res = (RadioButton) findViewById(id);
                            Cursor cu = ob.info_dsa(i);
                            cu.moveToFirst();
                            String result = res.getText().toString();
                            if (result.equals(cu.getString(6))) {
                                mark_dsa=mark_dsa+5;
                                count_dsa++;
                                Toast.makeText(user_dsa.this, "Secured=5", Toast.LENGTH_SHORT).show();
                            }
                            startActivity(j);
                        }
                    }
                }
        );
        skip.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(user_dsa.this, "You skipped this question", Toast.LENGTH_SHORT).show();
                        i++;
                        if(k<5)
                        {
                            try {
                                Cursor cu = ob.info_dsa(i);
                                if (cu.getCount() == 0) {
                                } else {
                                    cu.moveToFirst();
                                    ques.setText(cu.getString(1));
                                    op1.setText(cu.getString(2));
                                    op2.setText(cu.getString(3));
                                    op3.setText(cu.getString(4));
                                    op4.setText(cu.getString(5));
                                    aa1.setText(""+i);
                                    op1.setChecked(true);
                                    k++;
                                }

                            } catch (Exception t) {

                            }
                        }
                        else {
                            Intent j = new Intent(user_dsa.this, result_dsa.class);
                            Toast.makeText(user_dsa.this, "You skipped this question", Toast.LENGTH_SHORT).show();
                            startActivity(j);
                        }
                    }
                }
        );
    }
}
