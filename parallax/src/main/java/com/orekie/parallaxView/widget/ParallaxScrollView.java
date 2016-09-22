package com.orekie.parallaxView.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.orekie.parallaxView.helper.ParallaxHelper;

/**
 * Created by orekie on 16-9-22.
 */
public class ParallaxScrollView extends NestedScrollView {
    private ParallaxHelper helper;

    public ParallaxScrollView(Context context) {
        super(context);
    }

    public ParallaxScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ParallaxScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        helper = new ParallaxHelper();
        init();
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
        helper.makeParallax(false);
        super.onDraw(c);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        helper.makeParallax(false);
    }

    private void init() {
        ViewGroup container = (ViewGroup) getChildAt(0);
        findParallaxChild(container);
    }

    private void findParallaxChild(ViewGroup container) {
        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            if (v instanceof ParallaxView) {
               helper.addParallaxChild((ParallaxView) v);
            }
        }
    }
}
