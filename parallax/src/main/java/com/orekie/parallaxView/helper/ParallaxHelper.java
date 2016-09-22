package com.orekie.parallaxView.helper;

import android.view.View;

import com.orekie.parallaxView.widget.ParallaxView;
import com.orekie.parallaxView.i.ParallaxChild;

import java.util.ArrayList;
import java.util.List;


public class ParallaxHelper {

    private List<ParallaxChild> parallaxChildren;
    private int top, left;
    private int height, width;

    public ParallaxHelper() {
        parallaxChildren = new ArrayList<>();
    }

    public void setLayoutParams(int top, int left, int height, int width) {
        this.top = top;
        this.left = left;
        this.height = height;
        this.width = width;
    }

    public void makeParallax(boolean isHorizontal) {
        if (!isHorizontal) {
            for (ParallaxChild v : parallaxChildren) {
                Point point = calculateViewOffset((View) v);
                if (point.y + ((View) v).getMeasuredHeight() >= 0 && point.y <= height) {
                    float percent = point.y * 1f / (height + ((View) v).getMeasuredHeight());
                    v.setOffset(percent, false);
                }
            }
        } else {
            for (ParallaxChild v : parallaxChildren) {
                Point point = calculateViewOffset((View) v);
                if (point.x + ((View) v).getMeasuredWidth() >= 0 && point.x <= width) {
                    float percent = point.x * 1f / (width + ((View) v).getMeasuredWidth());
                    v.setOffset(percent, true);
                }
            }
        }

    }

    public Point calculateViewOffset(View v) {
        int[] a = new int[2];
        v.getLocationOnScreen(a);
        int x = a[0] - left, y = a[1] - top;
        return new Point(x, y);
    }

    public void addParallaxChild(ParallaxView parallaxView) {
        parallaxChildren.add(parallaxView);
    }

    public void removeParallaxChild(ParallaxView parallaxView) {
        parallaxChildren.remove(parallaxView);
    }

    public void clearParallaxChildren() {
        parallaxChildren.clear();
    }

    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
