package com.pedaily.yc.ycparallaxeffect.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.pedaily.yc.ycparallaxeffect.R;
import com.pedaily.yc.ycparallaxeffectlib.ParallaxEffectListView;

public class FirstActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Cheeses.NAMES);
		ParallaxEffectListView pe= (ParallaxEffectListView) findViewById(R.id.pe);
		View header = View.inflate(this, R.layout.header, null);
		ImageView iv_head= (ImageView) header.findViewById(R.id.iv_head);
		pe.setImageView(iv_head);
		pe.addHeaderView(header);
		pe.setAdapter(adapter);
        pe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
	}
}
