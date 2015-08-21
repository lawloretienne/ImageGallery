package com.etiennelawlor.imagegallery.library.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.etiennelawlor.imagegallery.library.R;
import com.etiennelawlor.imagegallery.library.view.PaletteTransformation;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by etiennelawlor on 8/20/15.
 */
public class ImageGalleryAdapter extends PagerAdapter {

    // region Member Variables
    private List<String> mImages;
    // endregion

    // region Constructors
    public ImageGalleryAdapter(List<String> images) {
        mImages = images;
    }
    // endregion

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) container.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.fullscreen_image, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll);

        Picasso.with(imageView.getContext())
                .load(mImages.get(position))
                .transform(PaletteTransformation.instance())
                .into(imageView, new PaletteTransformation.PaletteCallback(imageView) {
                    @Override
                    public void onError() {

                    }

                    @Override
                    public void onSuccess(Palette palette) {
                        int vibrant = palette.getVibrantColor(0x000000);
                        int vibrantLight = palette.getLightVibrantColor(0x000000);
                        int vibrantDark = palette.getDarkVibrantColor(0x000000);
                        int muted = palette.getMutedColor(0x000000);
                        int mutedLight = palette.getLightMutedColor(0x000000);
                        int mutedDark = palette.getDarkMutedColor(0x000000);

                        linearLayout.setBackgroundColor(vibrantLight);
                    }
                });

        ((ViewPager) container).addView(view, 0);

        return view;
    }


    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
