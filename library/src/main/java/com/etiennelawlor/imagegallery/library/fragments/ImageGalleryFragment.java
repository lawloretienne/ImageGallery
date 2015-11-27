package com.etiennelawlor.imagegallery.library.fragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.etiennelawlor.imagegallery.library.R;
import com.etiennelawlor.imagegallery.library.activities.FullScreenImageGalleryActivity;
import com.etiennelawlor.imagegallery.library.adapters.ImageGalleryAdapter;
import com.etiennelawlor.imagegallery.library.enums.PaletteColorType;
import com.etiennelawlor.imagegallery.library.util.ImageGalleryUtils;
import com.etiennelawlor.imagegallery.library.view.GridSpacesItemDecoration;

import java.util.ArrayList;

/**
 * Created by ayo on 26.11.15.
 */
public class ImageGalleryFragment extends Fragment implements ImageGalleryAdapter.OnImageClickListener{

    private static ArrayList<String> mImages;
    private static PaletteColorType mPaletteColorType;

    protected RecyclerView mRecyclerView;
    protected View view;

    public static ImageGalleryFragment getInstance(ArrayList<String> imageList, PaletteColorType paletteColorType) {
        mImages = imageList;
        mPaletteColorType = paletteColorType;
        return new ImageGalleryFragment();
    }

    public ImageGalleryFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_image_gallery, container, false);

        setUpRecyclerView();

        return view;
    }

    @Override
    public void onImageClick(int position) {
        changeFragment(FullScreenImageGalleryFragment.getInstance(mImages, position, mPaletteColorType));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setUpRecyclerView();
    }

    private void setUpRecyclerView(){
        int numOfColumns;
        if(ImageGalleryUtils.isInLandscapeMode(getActivity())){
            numOfColumns = 4;
        } else {
            numOfColumns = 3;
        }

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numOfColumns));
        mRecyclerView.addItemDecoration(new GridSpacesItemDecoration(ImageGalleryUtils.dp2px(getActivity(), 2), numOfColumns));
        ImageGalleryAdapter imageGalleryAdapter = new ImageGalleryAdapter(mImages);
        imageGalleryAdapter.setOnImageClickListener(this);

        mRecyclerView.setAdapter(imageGalleryAdapter);
    }

    private void changeFragment(Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, fragment).addToBackStack("").commit();
    }
}