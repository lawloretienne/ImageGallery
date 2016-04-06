package com.etiennelawlor.imagegallery.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import com.etiennelawlor.imagegallery.R;
import com.etiennelawlor.imagegallery.library.enums.PaletteColorType;
import com.etiennelawlor.imagegallery.library.fragments.ImageGalleryFragment;

import java.util.ArrayList;

/**
 * Created by ayo on 26.11.15.
 */
public class MainFragment extends AppCompatActivity {

    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        changeFragment(ImageGalleryFragment.getInstance(getPictures(), PaletteColorType.VIBRANT));
    }

    public ArrayList<String> getPictures(){
        ArrayList<String> images = new ArrayList<>();

        images.add("https://images.unsplash.com/photo-1437422061949-f6efbde0a471?q=80&fm=jpg&s=e23055c9ba7686b8fe583fb8318a1f88");
        images.add("https://images.unsplash.com/photo-1434139240289-56c519f77cb0?q=80&fm=jpg&s=13f8a0d1c2f96b5f311dedeb17cddb60");
        images.add("https://images.unsplash.com/photo-1429152937938-07b5f2828cdd?q=80&fm=jpg&s=a4f424db0ae5a398297df5ae5e0520d6");
        images.add("https://images.unsplash.com/photo-1430866880825-336a7d7814eb?q=80&fm=jpg&s=450de8563ac041f48b1563b499f56895");
        images.add("https://images.unsplash.com/photo-1429547584745-d8bec594c82e?q=80&fm=jpg&s=e9a7d9973088122a3e453cb2af541201");
        images.add("https://images.unsplash.com/photo-1429277158984-614d155e0017?q=80&fm=jpg&s=138f154e17a304b296c953323862633b");
        images.add("https://images.unsplash.com/photo-1429042007245-890c9e2603af?q=80&fm=jpg&s=8b76d20174cf46bffe32ea18f05551d3");
        images.add("https://images.unsplash.com/photo-1429091967365-492aaa5accfe?q=80&fm=jpg&s=b7430cfe5508430aea39fcf3b0645878");
        images.add("https://images.unsplash.com/photo-1430132594682-16e1185b17c5?q=80&fm=jpg&s=a70abbfff85382d11b03b9bbc71649c3");
        images.add("https://images.unsplash.com/photo-1436891620584-47fd0e565afb?q=80&fm=jpg&s=33cf5b0ee9fbd292475a0c03bee481c9");

        images.add("https://images.unsplash.com/photo-1415871989540-61fe9268d3c8?q=80&fm=jpg&s=061a03a7abe860a6c165cc3994feaba2");
        images.add("https://images.unsplash.com/photo-1415033523948-6c31d010530d?q=80&fm=jpg&s=ebe77e93f095b1a21ff6f090d332a815");
        images.add("https://images.unsplash.com/photo-1415201179613-bd037ff5eb29?q=80&fm=jpg&s=46a25087049ca6bdcff8390a342b9c59");
        images.add("https://images.unsplash.com/photo-1418227165283-1595d13726cd?q=80&fm=jpg&s=45b1869e9cd4fce23510ded9370e3966");
        images.add("https://images.unsplash.com/photo-1416949929422-a1d9c8fe84af?q=80&fm=jpg&s=ba414d9605af43b67d974182756cfb1d");
        images.add("https://images.unsplash.com/reserve/JaI1BywIT5Or8Jfmci1E_zakopane.jpg?q=80&fm=jpg&s=57142c70a82dc560fc67ce09c12a6052");
        images.add("https://images.unsplash.com/uploads/141362941583982a7e0fc/abcfbca1?q=80&fm=jpg&s=4f36891ccddbd86ed034d5943fb0eccb");
        images.add("https://images.unsplash.com/uploads/14116941824817ba1f28e/78c8dff1?q=80&fm=jpg&s=5600be7f06b56681c56f55c787128538");
        images.add("https://images.unsplash.com/photo-1413977886085-3bbbf9a7cf6e?q=80&fm=jpg&s=bc09d3becea6f665b39290475f3467c8");
        images.add("https://images.unsplash.com/photo-1415226194219-638f50c5d25f?q=80&fm=jpg&s=4f3f71caf6caeb5d4f508a001111e480");

        images.add("https://images.unsplash.com/photo-1416934625760-d56f5e79f6fe?q=80&fm=jpg&s=4c526b15bda8434c6f9e7eefe12b29be");
        images.add("https://images.unsplash.com/uploads/141220211075617c40312/e2ddba22?q=80&fm=jpg&s=394885b1c8da6776e79815e961118c81");
        images.add("https://images.unsplash.com/uploads/1412238370909393b4a19/79f023f1?q=80&fm=jpg&s=95844dfcd1993f4f0b10eab82c183631");
        images.add("https://images.unsplash.com/reserve/OQx70jjBSLOMI5ackhxm_urbex-ppc-030.jpg?q=80&fm=jpg&s=821aacb41fc9d3a94e5263d58dccce80");
        images.add("https://images.unsplash.com/39/yvDPJ8ZSmSVob7pRxIvU_IMG_40322.jpg?q=80&fm=jpg&s=30b5834ad1c403bcfd7fa5c4dfaba625");
        images.add("https://images.unsplash.com/22/one-scene.JPG?q=80&fm=jpg&s=b8b57577424cdf5545bb11bdf6f4b5a7");
        images.add("https://images.unsplash.com/36/e6mVuK2jQlWxKt3eAnQT_image.jpg?q=80&fm=jpg&s=0a3d8da572b0ed5e0cb963f6fa13588a");
        images.add("https://images.unsplash.com/41/pHyYeNZMRFOIRpYeW7X3_manacloseup%20copy.jpg?q=80&fm=jpg&s=99f2dbdf1526488a93d3cf307dea43d6");
        images.add("https://images.unsplash.com/44/MIbCzcvxQdahamZSNQ26_12082014-IMG_3526.jpg?q=80&fm=jpg&s=9f2b7926c5c13f719c57536392d78b49");
        images.add("https://images.unsplash.com/photo-1415226556993-1404e0c6e727?q=80&fm=jpg&s=334b8b5271cdbd8cbd4990a3aef89074");

        return images;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack("").commit();
    }
}