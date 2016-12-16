package com.etiennelawlor.imagegallery.library.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.etiennelawlor.imagegallery.library.R;
import com.etiennelawlor.imagegallery.library.utilities.DisplayUtility;

import java.util.List;

/**
 * Created by etiennelawlor on 8/20/15.
 */
public class FullScreenImageGalleryAdapter extends PagerAdapter {

    // region Member Variables
    private final List<String> images;
    private FullScreenImageLoader fullScreenImageLoader;
    // endregion

    // region Interfaces
    public interface FullScreenImageLoader {
        void loadFullScreenImage(ImageView iv, String imageUrl, int width, LinearLayout bglinearLayout);
    }
    // endregion

    // region Constructors
    public FullScreenImageGalleryAdapter(List<String> images) {
        this.images = images;
    }
    // endregion

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) container.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.fullscreen_image, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll);

        String image = images.get(position);

        Context context = imageView.getContext();
        int width = DisplayUtility.getScreenWidth(context);

        fullScreenImageLoader.loadFullScreenImage(imageView, image, width, linearLayout);

        container.addView(view, 0);

        return view;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    // region Helper Methods
    public void setFullScreenImageLoader(FullScreenImageLoader loader) {
        this.fullScreenImageLoader = loader;
    }
    // endregion
}
