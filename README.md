# Parallax

可以方便的实现 google 日历列表的滚动视差效果

# 如何使用

## RecyclerView

使用 ParallaxRecyclerView 代替 RecyclerView
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

item 的根布局使用 ParallaxView 包裹即可对子布局进行视差，内容不限，可包裹复杂 Layout 此处以 ImagView 为例
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

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:padding="20dp"
                android:text="hello" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:padding="20dp"
                android:text="world" />

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

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:padding="20dp"
                android:text="hello" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:padding="20dp"
                android:text="world" />

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

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:padding="20dp"
                android:text="hello" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:padding="20dp"
                android:text="world" />

            <com.orekie.parallaxView.widget.ParallaxView 
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                app:parallaxParam="0.7">

                <ImageView
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:scaleType="centerCrop"
                    android:src="@drawable/i2" />

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:padding="20dp"
                    android:text="hello" />

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:padding="20dp"
                    android:text="world" />
            </com.orekie.parallaxView.widget.ParallaxView>
        </LinearLayout>
    </com.orekie.parallaxView.widget.ParallaxScrollView>
</RelativeLayout>

```
