package com.pedaily.yc.ycparallaxeffect.third;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pedaily.yc.ycparallaxeffect.R;


public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mPullZoomHeaderView;
    private Button mPullZoomFooterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        mPullZoomFooterView = (Button) findViewById(R.id.pull_zoom_footer);
        mPullZoomHeaderView = (Button) findViewById(R.id.pull_zoom_header);

        mPullZoomHeaderView.setOnClickListener(this);
        mPullZoomFooterView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pull_zoom_header:
                Intent headerIntent = new Intent(ThirdActivity.this, PullZoomHeaderActivity.class);
                startActivity(headerIntent);
                break;
            case R.id.pull_zoom_footer:
                Intent footerIntent = new Intent(ThirdActivity.this, PullZoomFooterActivity.class);
                startActivity(footerIntent);
                break;
            default:
                break;
        }
    }
}