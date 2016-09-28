# Parallax

可以方便的实现 google 日历列表的滚动视差效果

# 如何使用

## RecyclerView

使用 ParallaxRecyclerView 代替 RecyclerView ,使用 ParallaxRecylerView.Adapter 代替 RecycleView.Adapter 
ParallaxRecylerView.Adapter.onBind() 方法替代 RecycleView.Adapter.onBindViewHolder() 方法
ParallaxRecylerView.Adapter.onUnBind() 方法替代 RecycleView.Adapter.onViewRecycled() 方法

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".RecyclerViewActivity">


    <com.orekie.parallaxView.widget.ParallaxRecyclerView
        android:id="@+id/v"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</RelativeLayout>
```

item 的根布局使用 ParallaxView 包裹即可对子布局进行视差，内容不限，可包裹复杂 Layout 此处以 ImageView 为例
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

RecyclerView 默认支持了 LinearLayoutManager 等，如若使用自定义的复杂 LayoutManager 请手动设置 RecyclerView 的滚动方向
```java
    recyclerView.setOrientation(ParallaxRecyclerView.VERTICAL);
```
## ScrollView

使用 ParallaxScrollView 代替 NestedScrollView 或者 ScrollView
其中需要进行视差展示的元素用 ParallaxView 包裹
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    tools:context=".ScrollViewActivity">

    <com.orekie.parallaxView.widget.ParallaxScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <!-- place normal view here -->

            <com.orekie.parallaxView.widget.ParallaxView
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

            <!-- place normal view here -->

            <com.orekie.parallaxView.widget.ParallaxView 
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                app:parallaxParam="0.7">

                <ImageView
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:scaleType="centerCrop"
                    android:src="@drawable/i1" />
            </com.orekie.parallaxView.widget.ParallaxView>

            <!-- place normal view here -->

            <com.orekie.parallaxView.widget.ParallaxView 
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                app:parallaxParam="0.7">

                <ImageView
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:scaleType="centerCrop"
                    android:src="@drawable/i2" />
            </com.orekie.parallaxView.widget.ParallaxView>
        </LinearLayout>
    </com.orekie.parallaxView.widget.ParallaxScrollView>
</RelativeLayout>

```

## 设置视差强度

在 ParallaxView 节点添加 app:parallaxParam 属性，默认为 0.7，理论上支持 0.1-1 的范围变量

```xml
<com.orekie.parallaxView.widget.ParallaxView 
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                app:parallaxParam="0.7">
```

或者在 Java 中使用 setParallaxParam(float) 方法

```java
  parallaxView.setParallaxParam(0.7f);
```
