package com.example.tione;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Xiangqing extends AppCompatActivity {

    /**
     * pinpai
     */
    private TextView mPinpai;
    /**
     * pinpai
     */
    private TextView mJiage;
    private ProgressBar mPrograss;
    private int max = 100;
    private ImageView mIvone;
    private LinearLayout mLin1;
    private LinearLayout mLin2;
    private ArrayList<String> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        initView();


        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = mPrograss.getProgress();
                while ((progress + 10) <= max) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mPrograss.setProgress(progress + 10);
                    progress = progress + 10;
                  /*  if (max == 100) {
                        mPrograss.setVisibility(View.VISIBLE);
                        mIvone.setVisibility(View.VISIBLE);
                        mLin1.setVisibility(View.VISIBLE);
                        mLin2.setVisibility(View.VISIBLE);

                    }*/
                }

            }
        }).start();

        final Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        String url = intent.getStringExtra("url");

        arr = new ArrayList<>();
        arr.add(name);
        arr.add(url);
        arr.add(price);


        mPinpai.setText(name);
        mJiage.setText(price);
        Glide.with(Xiangqing.this).load(url).into(mIvone);
      /*  mIvone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Xiangqing.this, Main2Activity.class);
                intent1.putExtra("name",arr);
                startActivity(intent1);
            }
        });*/
    }

    private void initView() {
        mPinpai = (TextView) findViewById(R.id.pinpai);
        mJiage = (TextView) findViewById(R.id.jiage);
        mPrograss = (ProgressBar) findViewById(R.id.prograss);
        mIvone = (ImageView) findViewById(R.id.ivone);
        mLin1 = (LinearLayout) findViewById(R.id.lin1);
        mLin2 = (LinearLayout) findViewById(R.id.lin2);
    }
}
