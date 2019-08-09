package com.example.braingames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.braingames.login.nm;
import static com.example.braingames.select_sub.sub;
import static com.example.braingames.user_answer.count;
import static com.example.braingames.user_answer.mark;
import static com.example.braingames.user_dsa.mark_dsa;

public class result extends AppCompatActivity {
TextView res,su,rq,wq,per,ff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        res=(TextView)findViewById(R.id.a);
        su=(TextView)findViewById(R.id.b);
        rq=(TextView)findViewById(R.id.c);
        wq=(TextView)findViewById(R.id.d);
        per=(TextView)findViewById(R.id.e);
        ff=(TextView)findViewById(R.id.f);
        su.setText(sub);
        ff.setText(nm);
        res.setText(""+mark);
        rq.setText(""+count);
        int w=5-count;
        wq.setText(""+w);
        int perc=(mark*100)/25;
        per.setText(""+perc+"%");
    }
}
