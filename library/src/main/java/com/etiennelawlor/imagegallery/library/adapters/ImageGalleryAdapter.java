package com.etiennelawlor.imagegallery.library.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.etiennelawlor.imagegallery.library.R;
import com.etiennelawlor.imagegallery.library.utilities.DisplayUtility;

import java.util.List;

/**
 * Created by etiennelawlor on 8/20/15.
 */
public class ImageGalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // region Member Variables
    private final List<String> images;
    private int gridItemWidth;
    private int gridItemHeight;
    private OnImageClickListener onImageClickListener;
    private ImageThumbnailLoader imageThumbnailLoader;
    // endregion

    // region Interfaces
    public interface OnImageClickListener {
        void onImageClick(int position);
    }

    public interface ImageThumbnailLoader {
        void loadImageThumbnail(ImageView iv, String imageUrl, int dimension);
    }
    // endregion

    // region Constructors
    public ImageGalleryAdapter(Context context, List<String> images) {
        this.images = images;

        int screenWidth = DisplayUtility.getScreenWidth(context);
        int numOfColumns;
        if (DisplayUtility.isInLandscapeMode(context)) {
            numOfColumns = 4;
        } else {
            numOfColumns = 3;
        }

        gridItemWidth = screenWidth / numOfColumns;
    }
    // endregion

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_thumbnail, viewGroup, false);
        v.setLayoutParams(getGridItemLayoutParams(v));

        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final ImageViewHolder holder = (ImageViewHolder) viewHolder;

        String image = images.get(position);

        imageThumbnailLoader.loadImageThumbnail(holder.imageView, image, gridItemWidth);

        holder.frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPos = holder.getAdapterPosition();
                if(adapterPos != RecyclerView.NO_POSITION){
                    if (onImageClickListener != null) {
                        onImageClickListener.onImageClick(adapterPos);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (images != null) {
            return images.size();
        } else {
            return 0;
        }
    }

    // region Helper Methods
    public void setOnImageClickListener(OnImageClickListener listener) {
        this.onImageClickListener = listener;
    }

    public void setImageThumbnailLoader(ImageThumbnailLoader loader) {
        this.imageThumbnailLoader = loader;
    }

    private ViewGroup.LayoutParams getGridItemLayoutParams(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();

        layoutParams.width = gridItemWidth;
        layoutParams.height = gridItemWidth;

        return layoutParams;
    }
    // endregion

    // region Inner Classes

    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        // region Views
        private final ImageView imageView;
        private final FrameLayout frameLayout;
        // endregion

        // region Constructors
        public ImageViewHolder(final View view) {
            super(view);

            imageView = (ImageView) view.findViewById(R.id.iv);
            frameLayout = (FrameLayout) view.findViewById(R.id.fl);
        }
        // endregion
    }

    // endregion
}
