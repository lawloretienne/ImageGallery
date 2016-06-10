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

`compile 'com.github.lawloretienne:imagegallery:0.0.15'`

#### Maven
```
<dependency>
    <groupId>com.github.lawloretienne</groupId>
    <artifactId>imagegallery</artifactId>
    <version>0.0.15</version>
</dependency>
```

## Sample Usage

```java
Intent intent = new Intent(MainActivity.this, ImageGalleryActivity.class);

String[] images = getResources().getStringArray(R.array.unsplash_images);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, new ArrayList<>(Arrays.asList(images)));
        bundle.putString(ImageGalleryActivity.KEY_TITLE, "Unsplash Images");
        intent.putExtras(bundle);

startActivity(intent);
```


If you want to use the ImageGalleryActivity you must declare the following in your AndroidManifest.xml .

```xml

<!-- Declare this activity in your AndroidManfest.xml -->
<activity
    android:name="com.etiennelawlor.imagegallery.library.activities.ImageGalleryActivity"
    android:configChanges="orientation|keyboardHidden|screenSize"
    android:label=""
    android:theme="@style/ImageGalleryTheme" />
```

Alternatively, you can now use the ImageGalleryFragment and host the fragment in your own Activity.

### Important Note
You must now set up image loading by implementing these interfaces `ImageGalleryAdapter.ImageThumbnailLoader` and `FullScreenImageGalleryAdapter.FullScreenImageLoader`. See https://github.com/lawloretienne/ImageGallery/blob/master/sample/src/main/java/com/etiennelawlor/imagegallery/activities/MainActivity.java .


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
