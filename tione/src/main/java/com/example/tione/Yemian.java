package com.example.tione;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class Yemian extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView mRlv;
    private ArrayList<Fengzhuang> arr;
    private Myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemian);
        initView();

        setSupportActionBar(mToolbar);

        mRlv.setLayoutManager(new LinearLayoutManager(this));
        arr = new ArrayList<>();
       /* arr.add(new Fengzhuang(1,"大众","60000"));
        arr.add(new Fengzhuang(2,"宝马","200000"));
        arr.add(new Fengzhuang(3,"保时捷","300000"));
        arr.add(new Fengzhuang(4,"现代","80000"));
        arr.add(new Fengzhuang(5,"路虎","200000"));
        arr.add(new Fengzhuang(6,"奔驰","300000"));*/
        myadapter = new Myadapter(this, arr);
        mRlv.setAdapter(myadapter);

/*

        for (Fengzhuang a:arr) {
            Datahelper.getDatahelper().insert(a);
            myadapter.notifyDataSetChanged();
        }
*/

        List<Fengzhuang> quary = Datahelper.getDatahelper().quary();
        arr.addAll(quary);
        myadapter.notifyDataSetChanged();
        myadapter.setOnItemclickListener(new Myadapter.OnItemclickListener() {
            @Override
            public void Onitemclick(int position) {
                Fengzhuang f = arr.get(position);
                Intent intent = new Intent(Yemian.this, Xiangqing.class);
                intent.putExtra("name",f.getName());
                intent.putExtra("price",f.getPrice());
                intent.putExtra("url",f.getIv());
                startActivity(intent);
            }
        });
    }


    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRlv = (RecyclerView) findViewById(R.id.rlv);
    }
}
