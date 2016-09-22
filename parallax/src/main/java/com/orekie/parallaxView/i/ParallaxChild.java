package com.orekie.parallaxView.i;

/**
 * Created by orekie on 16-9-22.
 */
public interface ParallaxChild {

    /**
     * A ParallaxScrollable should call this method when scrolling
     * This method is to ensure child view will perform a parallax-behavior during scrolling procedure
     * A ParallaxChild should adjust visible part of content to ensure parallax-behavior
     *
     * @param percent 0.0: the top of view reaches the top of ParallaxScrollable
     *                ~
     *                1.0: the top of view reaches the bot of ParallaxScrollable
     */
    void setOffset(float percent, boolean isHorizontal);

    void setParallaxParam(float param);

}
