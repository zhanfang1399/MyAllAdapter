package com.example.administrator.myapplication;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.MyBaseAdapter;
import adapter.ViewHolder;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private EditText et;
    private TextView tv;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();


        final Typeface typefaceDroidSansFallback=Typeface.createFromAsset(getResources().getAssets(), "fonts/DroidSansFallback.ttf");
        et.setTypeface(typefaceDroidSansFallback);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("rttttttttttttttt","et:"+et.getText().toString());
                tv.setText(et.getText().toString());
                tv.setTypeface(typefaceDroidSansFallback);
            }
        });


        MyBaseAdapter<String> adapter=new MyBaseAdapter<String>(getData(),R.layout.gridview_item,this) {
            @Override
            protected void convert(ViewHolder viewHolder, String s) {
                View view=viewHolder.getmContentView();
                ImageView iv=(ImageView)view.findViewById(R.id.iv);
                Button btn=(Button)view.findViewById(R.id.item_text);
                TextView tv=(TextView)view.findViewById(R.id.tv);
                iv.setImageResource(R.mipmap.ic_launcher);
                btn.setText(s);
                tv.setText(s);
                btn.setTextColor(Color.BLUE);
                tv.setTextColor(Color.RED);

            }
        };

        listview.setAdapter(adapter);


    }

    private ArrayList<String> getData(){
        ArrayList<String> arrayList=new ArrayList<>();
        for(int i=0;i<30;i++){
            arrayList.add("数据源"+i);
        }
        return arrayList;
    }



    private void assignViews() {
        btn=(Button)findViewById(R.id.btn);
        tv=(TextView)findViewById(R.id.tv);
        et=(EditText)findViewById(R.id.et);
        listview = (ListView) findViewById(R.id.listview);
    }

}
