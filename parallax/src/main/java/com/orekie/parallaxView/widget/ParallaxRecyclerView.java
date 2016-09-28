package com.orekie.parallaxView.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.orekie.parallaxView.helper.ParallaxHelper;
import com.orekie.parallaxView.i.ParallaxScrollable;


public class ParallaxRecyclerView extends RecyclerView
        implements ParallaxScrollable {

    public final static int UNSPECIFIED = ParallaxHelper.UNSPECIFIED;

    private int orientation = UNSPECIFIED;
    private ParallaxHelper helper;

    public ParallaxRecyclerView(Context context) {
        super(context);
    }

    public ParallaxRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ParallaxRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        helper = new ParallaxHelper();
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);


    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        helper.makeParallax(orientation);
    }


    public void setOritation(int orientation) {
        this.orientation = this.orientation;
    }

    @Override
    public void setLayoutManager(LayoutManager layout) {
        super.setLayoutManager(layout);
        if (layout.canScrollHorizontally()) {
            orientation = HORIZONTAL;
        } else if (layout.canScrollVertically()) {
            orientation = VERTICAL;
        } else {
            orientation = UNSPECIFIED;
        }
    }

    @Override
    public void onDraw(Canvas c) {
        int[] a = new int[2];
        getLocationOnScreen(a);
        int left = a[0];
        int top = a[1];
        int height = getMeasuredHeight();
        int width = getMeasuredWidth();
        helper.setLayoutParams(top, left, height, width);
        helper.makeParallax(orientation);
        super.onDraw(c);
    }

    @Override
    public void addParallaxView(ParallaxView parallaxView) {
        helper.addParallaxChild(parallaxView);
    }

    @Override
    public void removeParallaxView(ParallaxView parallaxView) {
        helper.removeParallaxChild(parallaxView);
    }

    public boolean isHorizontal() {
        return orientation == HORIZONTAL;
    }

    static public abstract class ParallaxAdapter<T extends ViewHolder>
            extends Adapter<T> {

        private ParallaxScrollable recyclerView;

        public ParallaxAdapter(ParallaxScrollable recyclerView) {
            this.recyclerView = recyclerView;
        }

        @Override
        public void onViewRecycled(T holder) {
            View v = holder.itemView;
            if (v instanceof ParallaxView) {
                recyclerView.removeParallaxView((ParallaxView) v);
            }
            onUnbind(holder);
        }

        @Override
        public void onBindViewHolder(T holder, int position) {
            View v = holder.itemView;
            if (v instanceof ParallaxView) {
                recyclerView.addParallaxView((ParallaxView) v);
            }
            onBind(holder, position);
        }


        public abstract void onBind(T holder, int position);

        public abstract void onUnbind(T holder);
    }
}
