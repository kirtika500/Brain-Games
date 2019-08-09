package com.example.braingames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin_instruction extends AppCompatActivity {
Button skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_instruction);
        skip=(Button)findViewById(R.id.button);
        skip.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(admin_instruction.this,admin_set_ques.class);
                        startActivity(i);
                    }
                }
        );
    }
}
