package com.pedaily.yc.ycparallaxeffect.second;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.pedaily.yc.ycparallaxeffect.R;
import com.pedaily.yc.ycparallaxeffect.first.Cheeses;
import com.pedaily.yc.ycparallaxeffectlib.PullToZoomListView;


public class SecondActivity extends AppCompatActivity {

    private PullToZoomListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
    }

    private void init() {
        listView = (PullToZoomListView)findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter<>(SecondActivity.this,android.R.layout.simple_list_item_1,  Cheeses.NAMES));
        listView.getHeaderView().setImageResource(R.drawable.parallax_img);
        listView.getHeaderView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        listView.setShadow(R.drawable.shadow_bottom);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SecondActivity.this,"click index:"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

}
