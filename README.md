# ImageGallery
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

![ImageGallery](https://raw.githubusercontent.com/lawloretienne/ImageGallery/master/images/ImageGallery_Screenshot.png)

## Setup

#### Gradle

`compile 'com.github.lawloretienne:imagegallery:0.0.1'`

#### Maven
```
<dependency>
    <groupId>com.github.lawloretienne</groupId>
    <artifactId>imagegallery</artifactId>
    <version>0.0.1</version>
</dependency>
```

## Sample Usage

```java
Intent intent = new Intent(MainActivity.this, ImageGalleryActivity.class);

ArrayList<String> images = new ArrayList<>();
images.add("http://www.kirnak.com/wp-content/uploads/bikini_temptation_02.jpg");
images.add("http://img1.efu.com.cn/upfile/fashion/photo/18381/426800.jpg");
images.add("http://img1.efu.com.cn/upfile/fashion/photo/18381/426807.jpg");
images.add("http://www.magxone.com/uploads/2009/10/Bar-Refaeli-Victorias-Secret-Swimsuit-3.jpg");
images.add("http://i.dailymail.co.uk/i/pix/2015/02/03/254DF88F00000578-0-Gigi_Hadid_s_latest_campaign_images_for_Australian_swimwear_bran-m-96_1422981085166.jpg");
images.add("http://cache.desktopnexus.com/thumbseg/1614/1614611-bigthumbnail.jpg");
images.add("http://www.supermodelgirlfriend.com/wp-content/uploads/2015/01/nina-agdal-banana-moon-swimwear-black-bikini-supermodel-girlfriend-adam-dunlap.jpg");
images.add("http://3.bp.blogspot.com/-k-qXckxTMVc/U1AY0EHG6GI/AAAAAAAAGpg/669lFJfmkbU/s1600/Bregje-Heinen-swimwear-03.jpg");
images.add("http://4.bp.blogspot.com/-tpbU39jdIWw/VTQ99D6FWvI/AAAAAAABzGM/pKWEKiKXDvE/s1600/5_Zoe_PinkBridgestone_9489.jpg");
images.add("http://i2.listal.com/image/413503/600full-petra-nemcova.jpg");

intent.putStringArrayListExtra("images", images);
intent.putExtra("palette_color_type", PaletteColorType.LIGHT_VIBRANT);

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
