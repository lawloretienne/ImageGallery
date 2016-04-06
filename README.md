# ImageGallery [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ImageGallery-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/2364)
A gallery used to host an array of images

You can add one or more images to the gallery

Support for using <a href="https://developer.android.com/intl/zh-cn/reference/android/support/v7/graphics/Palette.html">Palette</a> to set the background color

Palette color types
 - VIBRANT
 - LIGHT_VIBRANT
 - DARK_VIBRANT
 - MUTED
 - LIGHT_MUTED
 - DARK_MUTED

Supports pinch-to-zoom on the images

![ImageGallery](https://raw.githubusercontent.com/lawloretienne/ImageGallery/master/images/ImageGallery_Screenshot6.png)

![ImageGallery](https://raw.githubusercontent.com/lawloretienne/ImageGallery/master/images/ImageGallery_Screenshot4.png)

## Setup

#### Gradle

`compile 'com.github.lawloretienne:imagegallery:0.0.14'`

#### Maven
```
<dependency>
    <groupId>com.github.lawloretienne</groupId>
    <artifactId>imagegallery</artifactId>
    <version>0.0.14</version>
</dependency>
```

## Sample Usage

```java
Intent intent = new Intent(MainActivity.this, ImageGalleryActivity.class);

ArrayList<String> images = new ArrayList<>();

images.add("https://images.unsplash.com/photo-1437422061949-f6efbde0a471?q=80&fm=jpg&s=e23055c9ba7686b8fe583fb8318a1f88");
images.add("https://images.unsplash.com/photo-1434139240289-56c519f77cb0?q=80&fm=jpg&s=13f8a0d1c2f96b5f311dedeb17cddb60");
images.add("https://images.unsplash.com/photo-1429152937938-07b5f2828cdd?q=80&fm=jpg&s=a4f424db0ae5a398297df5ae5e0520d6");
images.add("https://images.unsplash.com/photo-1430866880825-336a7d7814eb?q=80&fm=jpg&s=450de8563ac041f48b1563b499f56895");
images.add("https://images.unsplash.com/photo-1429547584745-d8bec594c82e?q=80&fm=jpg&s=e9a7d9973088122a3e453cb2af541201");
images.add("https://images.unsplash.com/photo-1429277158984-614d155e0017?q=80&fm=jpg&s=138f154e17a304b296c953323862633b");
images.add("https://images.unsplash.com/photo-1429042007245-890c9e2603af?q=80&fm=jpg&s=8b76d20174cf46bffe32ea18f05551d3");
images.add("https://images.unsplash.com/photo-1429091967365-492aaa5accfe?q=80&fm=jpg&s=b7430cfe5508430aea39fcf3b0645878");
images.add("https://images.unsplash.com/photo-1430132594682-16e1185b17c5?q=80&fm=jpg&s=a70abbfff85382d11b03b9bbc71649c3");
images.add("https://images.unsplash.com/photo-1436891620584-47fd0e565afb?q=80&fm=jpg&s=33cf5b0ee9fbd292475a0c03bee481c9");

intent.putStringArrayListExtra("images", images);
// optionally set background color using Palette
intent.putExtra("palette_color_type", PaletteColorType.VIBRANT);

startActivity(intent);
```

```xml

<!-- Declare this activity in your AndroidManfest.xml -->
<activity
    android:name="com.etiennelawlor.imagegallery.library.activities.ImageGalleryActivity"
    android:configChanges="orientation|keyboardHidden|screenSize"
    android:label=""
    android:theme="@style/ImageGalleryTheme" />
```

## Developed By

* Etienne Lawlor 
 
&nbsp;&nbsp;&nbsp;**Email** - lawloretienne@gmail.com

&nbsp;&nbsp;&nbsp;**Website** - https://medium.com/@etiennelawlor

## Projects/Apps using ImageGallery

- <a href="https://play.google.com/store/apps/details?id=com.biggu.shopsavvy&hl=en">ShopSavvy</a>

Feel free to contact me to add yours to this list.

## License

```
Copyright 2015 Etienne Lawlor

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
