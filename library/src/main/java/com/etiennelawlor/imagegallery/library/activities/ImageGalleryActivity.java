package com.etiennelawlor.imagegallery.library.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.etiennelawlor.imagegallery.library.R;
import com.etiennelawlor.imagegallery.library.adapters.ImageGalleryAdapter;
import com.etiennelawlor.imagegallery.library.enums.PaletteColorType;
import com.etiennelawlor.imagegallery.library.util.ImageGalleryUtils;

import java.util.ArrayList;
import java.util.List;

public class ImageGalleryActivity extends AppCompatActivity {

    // region Member Variables
    private ImageGalleryAdapter mImageGalleryAdapter;
    private List<String> mImages;
    private PaletteColorType mPaletteColorType;

    private Toolbar mToolbar;
    private ViewPager mViewPager;
    // endregion

    // region Listeners
    private ViewPager.OnPageChangeListener mViewPagerOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (mViewPager != null) {
                mViewPager.setCurrentItem(position);

                setActionBarTitle(position);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    // endregion

    // region Lifecycle Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image_gallery);

        bindViews();

        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                mImages = extras.getStringArrayList("images");
                mPaletteColorType = (PaletteColorType) extras.get("palette_color_type");
            }
        }

        setUpViewPager();
        setUpActionBarTitle();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mViewPager.removeOnPageChangeListener(mViewPagerOnPageChangeListener);
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

    // region Helper Methods
    private void setActionBarTitle(int position) {
        if (mViewPager != null) {
            int totalPages = mViewPager.getAdapter().getCount();
            getSupportActionBar().setTitle(String.format("%d of %d", (position + 1), totalPages));
        }
    }

    private void bindViews() {
        mViewPager = (ViewPager) findViewById(R.id.vp);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void setUpActionBarTitle(){
        if (mImages.size() > 1) {
            setActionBarTitle(0);
        }
    }

    private void setUpViewPager(){
        ArrayList<String> images = new ArrayList<>();

        int width = ImageGalleryUtils.getScreenWidth(this);
        int height = ImageGalleryUtils.getScreenHeight(this);

        String dimens = String.format("w=%d&h=%d", width, height);
        String xImageFormatter = "http://xi.mg/%s?%s";

        for(String image : mImages){
            images.add(String.format(xImageFormatter, image, dimens));
        }

        mImageGalleryAdapter = new ImageGalleryAdapter(images, mPaletteColorType);
        mViewPager.setAdapter(mImageGalleryAdapter);
        mViewPager.addOnPageChangeListener(mViewPagerOnPageChangeListener);
    }
    // endregion
}
