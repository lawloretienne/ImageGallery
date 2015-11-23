package com.etiennelawlor.imagegallery.library.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.etiennelawlor.imagegallery.library.R;
import com.etiennelawlor.imagegallery.library.util.ImageGalleryUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by etiennelawlor on 8/20/15.
 */
public class ImageGalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // region Member Variables
    private final List<String> mImages;
    private int mGridItemWidth;
    private int mGridItemHeight;
    private OnImageClickListener mOnImageClickListener;
    // endregion

    // region Interfaces
    public interface OnImageClickListener {
        void onImageClick(int position);
    }
    // endregion

    // region Constructors
    public ImageGalleryAdapter(List<String> images) {
        mImages = images;
    }
    // endregion

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_thumbnail, viewGroup, false);
        v.setLayoutParams(getGridItemLayoutParams(v));

        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        final ImageViewHolder holder = (ImageViewHolder) viewHolder;

        String image = mImages.get(position);

        setUpImage(holder.mImageView, image);

        holder.mFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnImageClickListener != null) {
                    mOnImageClickListener.onImageClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mImages != null) {
            return mImages.size();
        } else {
            return 0;
        }
    }

    // region Helper Methods
    public void setOnImageClickListener(OnImageClickListener listener) {
        this.mOnImageClickListener = listener;
    }

    private ViewGroup.LayoutParams getGridItemLayoutParams(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int screenWidth = ImageGalleryUtils.getScreenWidth(view.getContext());
        int numOfColumns;
        if (ImageGalleryUtils.isInLandscapeMode(view.getContext())) {
            numOfColumns = 4;
        } else {
            numOfColumns = 3;
        }

        mGridItemWidth = screenWidth / numOfColumns;
        mGridItemHeight = screenWidth / numOfColumns;

        layoutParams.width = mGridItemWidth;
        layoutParams.height = mGridItemHeight;

        return layoutParams;
    }

    private void setUpImage(ImageView iv, String imageUrl) {
        String formattedImageUrl = ImageGalleryUtils.getFormattedImageUrl(imageUrl, mGridItemWidth, mGridItemHeight);

        if (!TextUtils.isEmpty(formattedImageUrl)) {
            Picasso.with(iv.getContext())
                    .load(formattedImageUrl)
                    .into(iv);
        } else {
            iv.setImageDrawable(null);
        }
    }
    // endregion

    // region Inner Classes

    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        // region Member Variables
        private final ImageView mImageView;
        private final FrameLayout mFrameLayout;
        // endregion

        // region Constructors
        public ImageViewHolder(final View view) {
            super(view);

            mImageView = (ImageView) view.findViewById(R.id.iv);
            mFrameLayout = (FrameLayout) view.findViewById(R.id.fl);
        }
        // endregion
    }

    // endregion
}
