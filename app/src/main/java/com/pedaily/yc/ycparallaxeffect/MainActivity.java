package com.pedaily.yc.ycparallaxeffect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pedaily.yc.ycparallaxeffect.first.FirstActivity;
import com.pedaily.yc.ycparallaxeffect.second.SecondActivity;
import com.pedaily.yc.ycparallaxeffect.third.ThirdActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_1:
                startActivity(new Intent(this, FirstActivity.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.btn_3:
                startActivity(new Intent(this, ThirdActivity.class));
                break;
        }
    }
}
