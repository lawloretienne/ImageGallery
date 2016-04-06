package com.etiennelawlor.imagegallery.library.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.etiennelawlor.imagegallery.library.R;
import com.etiennelawlor.imagegallery.library.adapters.FullScreenImageGalleryAdapter;
import com.etiennelawlor.imagegallery.library.enums.PaletteColorType;
import com.etiennelawlor.imagegallery.library.util.ImageGalleryUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayo on 26.11.15.
 */
public class FullScreenImageGalleryFragment extends Fragment{

    private static List<String> mImages;
    private static int mPosition;
    private static PaletteColorType mPaletteColorType;

    private View view;
    private ViewPager mViewPager;

    public static FullScreenImageGalleryFragment getInstance(List<String> imageList, int position, PaletteColorType paletteColorType) {
        mImages = imageList;
        mPosition = position;
        mPaletteColorType = paletteColorType;
        return new FullScreenImageGalleryFragment();
    }

    public FullScreenImageGalleryFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_full_screen_image_gallery, container, false);

        setUpViewPager();

        return view;
    }

    private final ViewPager.OnPageChangeListener mViewPagerOnPageChangeListener = new ViewPager.OnPageChangeListener() {
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        removeListeners();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {

            getActivity().onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void setUpViewPager() {
        ArrayList<String> images = new ArrayList<>();

        int width = ImageGalleryUtils.getScreenWidth(getActivity());
        int height = ImageGalleryUtils.getScreenHeight(getActivity());

        for (String image : mImages) {
            String imageUrl = ImageGalleryUtils.getFormattedImageUrl(image, width, height);
            images.add(imageUrl);
        }

        mViewPager = (ViewPager) view.findViewById(R.id.vp);
        FullScreenImageGalleryAdapter fullScreenImageGalleryAdapter = new FullScreenImageGalleryAdapter(images, mPaletteColorType);
        mViewPager.setAdapter(fullScreenImageGalleryAdapter);
        mViewPager.addOnPageChangeListener(mViewPagerOnPageChangeListener);
        mViewPager.setCurrentItem(mPosition);
    }

    private void setActionBarTitle(int position) {
        if (mViewPager != null && mImages.size() > 1) {
            int totalPages = mViewPager.getAdapter().getCount();

            ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
            if (actionBar != null)
                actionBar.setTitle(String.format("%d of %d", (position + 1), totalPages));
        }
    }

    private void removeListeners() {
        mViewPager.removeOnPageChangeListener(mViewPagerOnPageChangeListener);
    }

}