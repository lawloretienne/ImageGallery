package com.etiennelawlor.imagegallery.library.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.etiennelawlor.imagegallery.library.R;
import com.etiennelawlor.imagegallery.library.adapters.ImageGalleryAdapter;
import com.etiennelawlor.imagegallery.library.utilities.DisplayUtility;

import java.util.ArrayList;

public class ImageGalleryActivity extends AppCompatActivity implements ImageGalleryAdapter.OnImageClickListener, ImageGalleryAdapter.ImageThumbnailLoader {

    // region Constants
    public static final String KEY_IMAGES = "KEY_IMAGES";
    public static final String KEY_TITLE = "KEY_TITLE";
    // endregion

    // region Views
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    // endregion

    // region Member Variables
    private ArrayList<String> images;
    private String title;
    private static ImageGalleryAdapter.ImageThumbnailLoader imageThumbnailLoader;
    // endregion

    // region Lifecycle Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                images = extras.getStringArrayList(KEY_IMAGES);
                title = extras.getString(KEY_TITLE);
            }
        }

        setContentView(R.layout.activity_image_gallery);

        bindViews();

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(title);
        }

        setUpRecyclerView();
    }
    // endregion

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setUpRecyclerView();
    }

    // region ImageGalleryAdapter.OnImageClickListener Methods
    @Override
    public void onImageClick(int position) {
        Intent intent = new Intent(ImageGalleryActivity.this, FullScreenImageGalleryActivity.class);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(FullScreenImageGalleryActivity.KEY_IMAGES, images);
        bundle.putInt(FullScreenImageGalleryActivity.KEY_POSITION, position);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    // endregion

    // region ImageGalleryAdapter.ImageThumbnailLoader Methods
    @Override
    public void loadImageThumbnail(ImageView iv, String imageUrl, int dimension) {
        imageThumbnailLoader.loadImageThumbnail(iv, imageUrl, dimension);
    }
    // endregion

    // region Helper Methods
    private void bindViews() {
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void setUpRecyclerView() {
        int numOfColumns;
        if (DisplayUtility.isInLandscapeMode(this)) {
            numOfColumns = 4;
        } else {
            numOfColumns = 3;
        }

        recyclerView.setLayoutManager(new GridLayoutManager(ImageGalleryActivity.this, numOfColumns));
        ImageGalleryAdapter imageGalleryAdapter = new ImageGalleryAdapter(this, images);
        imageGalleryAdapter.setOnImageClickListener(this);
        imageGalleryAdapter.setImageThumbnailLoader(this);

        recyclerView.setAdapter(imageGalleryAdapter);
    }

    public static void setImageThumbnailLoader(ImageGalleryAdapter.ImageThumbnailLoader loader) {
        imageThumbnailLoader = loader;
    }
    // endregion
}
