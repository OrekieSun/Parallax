package com.orekie.parallaxView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.orekie.parallaxView.widget.ParallaxRecyclerView;


public class MyAdapter extends ParallaxRecyclerView.ParallaxAdapter<MyAdapter.VH> {

    Data[] datas = new Data[]{
            new Data("hello", 0),
            new Data("  ~  ", 0),
            new Data("world", 0),
            new Data(null, R.drawable.i0),
            new Data("hello", 0),
            new Data("  ~  ", 0),
            new Data("world", 0),
            new Data(null, R.drawable.i1),
            new Data("hello", 0),
            new Data("  ~  ", 0),
            new Data("world", 0),
            new Data(null, R.drawable.i2),
            new Data("hello", 0),
            new Data("  ~  ", 0),
            new Data("world", 0),
    };

    Handler handler = new Handler();

    Context context;

    public MyAdapter(ParallaxRecyclerView recyclerView, Context context) {
        super(recyclerView);
        this.context = context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new VH(LayoutInflater.from(context).inflate(R.layout.item_0, parent, false));
        } else {
            return new VH(LayoutInflater.from(context).inflate(R.layout.item_1, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return null == datas[position].string ? 0 : 1;
    }


    @Override
    public void onBind(final VH holder, final int position) {
        if (getItemViewType(position) == 1) {
            ((TextView) holder.itemView).setText(datas[position].string);
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final Drawable drawable = ContextCompat.getDrawable(context, datas[position].id);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ((ImageView) holder.itemView.findViewById(R.id.iv))
                                    .setImageDrawable(drawable);
                        }
                    });
                }
            }).start();
        }
    }

    @Override
    public void onUnbind(VH holder) {

    }


    @Override
    public int getItemCount() {
        return datas.length;
    }

    public class VH extends RecyclerView.ViewHolder {

        public VH(View itemView) {
            super(itemView);
        }
    }

    public class Data {
        private String string;
        private int id;

        Data(String string, int id) {
            this.string = string;
            this.id = id;
        }

    }
}
