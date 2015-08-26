package com.etiennelawlor.imagegallery.library.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.Set;

/**
 * Created by etiennelawlor on 8/25/15.
 */
public class ImageGalleryUtils {

    public static int getScreenWidth(@NonNull Context context) {
        Point size = new Point();
        ((Activity) context).getWindowManager().getDefaultDisplay().getSize(size);
        return size.x;
    }

    public static int getScreenHeight(@NonNull Context context) {
        Point size = new Point();
        ((Activity) context).getWindowManager().getDefaultDisplay().getSize(size);
        return size.y;
    }

    public static String getImageUrl(@Nullable String url, int width, int height) {
        if (!TextUtils.isEmpty(url)) {

            Uri uri = Uri.parse(url);
            String scheme = uri.getScheme();
            String authority = uri.getAuthority();
            String path = uri.getEncodedPath();

            Set<String> queryParameterNames = uri.getQueryParameterNames();

            Uri.Builder builder = new Uri.Builder();
            builder.scheme(scheme)
                    .authority(authority)
                    .appendPath(path.substring(1));

            boolean isWidthSet = false;
            boolean isHeightSet = false;

            if(width > 2048){
                width = 2048;
            }

            if(height > 2048){
                height = 2048;
            }

            for (String key : queryParameterNames) {
                if(key.equals("w")){
                    builder.appendQueryParameter(key, String.valueOf(width));
                    isWidthSet = true;
                } else if (key.equals("h")){
                    builder.appendQueryParameter(key, String.valueOf(height));
                    isHeightSet = true;
                } else {
                    builder.appendQueryParameter(key, uri.getQueryParameter(key));
                }
            }

            if(!isWidthSet){
                builder.appendQueryParameter("w", String.valueOf(width));
            }

            if(!isHeightSet){
                builder.appendQueryParameter("h", String.valueOf(height));
            }

            String formattedUrl = String.format("http://xi.mg/%s", builder.build().toString());
            formattedUrl = formattedUrl.replace(" ", "%20");

            return formattedUrl;
        }

        return "";
    }
}
