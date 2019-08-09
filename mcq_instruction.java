package com.example.braingames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.braingames.login.nm;

public class mcq_instruction extends AppCompatActivity {
Button skip;
TextView us;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcq_instruction);
        skip=(Button)findViewById(R.id.button);
        us=(TextView)findViewById(R.id.a2);
        us.setText(nm);
        skip.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(mcq_instruction.this,select_sub.class);
                        startActivity(i);
                    }
                }
        );
    }
}
