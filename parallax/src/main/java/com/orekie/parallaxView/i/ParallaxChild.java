package com.orekie.parallaxView.i;


public interface ParallaxChild {

    /**
     * 在 ParallaxScrollable 滚动时由 ParallaxHelper 回调
     *
     * @param percent 0.0: 当前 view 的底边与父布局的顶边重合
     *                ~
     *                1.0:  当前 view 的顶与父布局的底边重合
     */
    void setOffset(float percent, boolean isHorizontal);

    /**
     * 一个 ParallaxChild 的实现类应该支持设置视差效果
     *
     * @param param 视差效果因数
     */
    void setParallaxParam(float param);

}
