package com.orekie.parallaxView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.orekie.parallaxView.widget.ParallaxRecyclerView;
import com.orekie.parallaxView.widget.ParallaxView;

public class RecyclerViewActivity extends AppCompatActivity {

    boolean b = true;
    private ParallaxRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (ParallaxRecyclerView) findViewById(R.id.v);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new MyAdapter(recyclerView, this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 233, 1, "ScrollView");
        menu.add(0, 234, 1, "LayoutManager");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 234:
                if (b)
                    recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                else
                    recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                b = !b;
                break;
            case 233:
                startActivity(new Intent(this,ScrollViewActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
