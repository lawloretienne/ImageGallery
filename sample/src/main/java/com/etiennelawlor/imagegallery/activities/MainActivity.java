package com.etiennelawlor.imagegallery.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.etiennelawlor.imagegallery.R;
import com.etiennelawlor.imagegallery.library.activities.ImageGalleryActivity;
import com.etiennelawlor.imagegallery.library.enums.PaletteColorType;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by etiennelawlor on 8/20/15.
 */
public class MainActivity extends AppCompatActivity {

    // region Listeners
    @OnClick(R.id.view_gallery_btn)
    public void onViewGalleryButtonClicked(final View v) {
        Intent intent = new Intent(MainActivity.this, ImageGalleryActivity.class);

        ArrayList<String> images = new ArrayList<>();
        images.add("http://www.kirnak.com/wp-content/uploads/bikini_temptation_02.jpg");
        images.add("http://img1.efu.com.cn/upfile/fashion/photo/18381/426800.jpg");
        images.add("http://img1.efu.com.cn/upfile/fashion/photo/18381/426807.jpg");
        images.add("http://www.magxone.com/uploads/2009/10/Bar-Refaeli-Victorias-Secret-Swimsuit-3.jpg");
        images.add("http://i.dailymail.co.uk/i/pix/2015/02/03/254DF88F00000578-0-Gigi_Hadid_s_latest_campaign_images_for_Australian_swimwear_bran-m-96_1422981085166.jpg");
        images.add("http://cache.desktopnexus.com/thumbseg/1614/1614611-bigthumbnail.jpg");
        images.add("http://www.supermodelgirlfriend.com/wp-content/uploads/2015/01/nina-agdal-banana-moon-swimwear-black-bikini-supermodel-girlfriend-adam-dunlap.jpg");
        images.add("http://3.bp.blogspot.com/-k-qXckxTMVc/U1AY0EHG6GI/AAAAAAAAGpg/669lFJfmkbU/s1600/Bregje-Heinen-swimwear-03.jpg");
        images.add("http://4.bp.blogspot.com/-tpbU39jdIWw/VTQ99D6FWvI/AAAAAAABzGM/pKWEKiKXDvE/s1600/5_Zoe_PinkBridgestone_9489.jpg");
        images.add("http://i2.listal.com/image/413503/600full-petra-nemcova.jpg");

        intent.putStringArrayListExtra("images", images);
        intent.putExtra("palette_color_type", PaletteColorType.LIGHT_VIBRANT);

        startActivity(intent);
    }
    // endregion

    // region Lifecycle Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }
    // endregion
}
