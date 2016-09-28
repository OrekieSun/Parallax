# Parallax

可以方便的实现 google 日历列表的滚动视差效果

# 如何使用

RecyclerView
item 的根布局使用 ParallaxView 包裹即可对子布局进行视差，内容不限
```xml
<?xml version="1.0" encoding="utf-8"?>
<com.orekie.parallaxView.widget.ParallaxView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:parallaxParam="0.7">

    <ImageView
        android:id="@+id/iv"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:scaleType="centerCrop"
        android:src="@drawable/i0" />
</com.orekie.parallaxView.widget.ParallaxView>
```
```java

```
