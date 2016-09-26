package com.orekie.parallaxView.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.orekie.parallax.R;
import com.orekie.parallaxView.i.ParallaxChild;


public class ParallaxView extends ViewGroup
        implements ParallaxChild {

    private int maxOffset;
    private float percent = 0;
    private float param = 0.7f;
    private boolean isHorizontal;

    public ParallaxView(Context context) {
        super(context);
    }

    public ParallaxView(Context context, AttributeSet attrs) {
        super(context, attrs);
        resolveAttrs(attrs);
    }


    public ParallaxView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        resolveAttrs(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ParallaxView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        resolveAttrs(attrs);
    }

    private void resolveAttrs(AttributeSet attrs) {
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.ParallaxView);
        param = array.getFloat(0, 0.7f);
        array.recycle();
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        int[] a = new int[2];
        getLocationOnScreen(a);
        View child = getChildAt(0);
        if (!isHorizontal) {
            child.layout(0,
                    (int) -(percent * maxOffset),
                    child.getMeasuredWidth(),
                    (int) -(percent * maxOffset) + child.getMeasuredHeight());
        } else {
            child.layout((int) -(percent * maxOffset),
                    0,
                    (int) -(percent * maxOffset) + child.getMeasuredWidth(),
                    child.getMeasuredHeight());
        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, MeasureSpec.UNSPECIFIED);
        View child = getChildAt(0);
        if (!isHorizontal) {
            maxOffset = (int) (child.getMeasuredHeight() * param);
            setMeasuredDimension(
                    child.getMeasuredWidth(),
                    (int) (child.getMeasuredHeight() * (1 - param))
            );
        } else {
            maxOffset = (int) (child.getMeasuredWidth() * param);
            setMeasuredDimension(
                    (int) (child.getMeasuredWidth() * (1 - param)),
                    child.getMeasuredHeight()
            );
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    public void setOffset(float percent, boolean isHorizontal) {
        this.percent = percent;
        this.isHorizontal = isHorizontal;
        requestLayout();
    }

    @Override
    public void setParallaxParam(float param) {
        this.param = param;
        measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
    }
}
