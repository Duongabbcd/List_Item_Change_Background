package com.example.list_item_change_background;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listview ;
    private int[] icon={R.drawable.soccer,R.drawable.telephone,
            R.drawable.google,R.drawable.soccer};

    private String[] title={"Android","IoS","Blackberry","Bro"} ;
    private String[] subtitle = {"Sub 1","Sub 2","Sub 3","Sub 4"};
    private String[] content = {"content 1","content 1","content 1","content 1"} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.listView) ;
        MyListAdapter adapter =  new MyListAdapter(this,icon,title,subtitle,content) ;
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(int i = 0 ; i < adapter.getCount();i++){
                    parent.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);

                    parent.getChildAt(position).setBackgroundColor(Color.YELLOW);
                }

                Toast.makeText(MainActivity.this,"select :"+adapter.getTitle(position),Toast.LENGTH_LONG) .show();
            }
        });
    }
}