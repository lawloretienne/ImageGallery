package com.etiennelawlor.imagegallery.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.etiennelawlor.imagegallery.R;
import com.etiennelawlor.imagegallery.library.ImageGalleryFragment;

import butterknife.ButterKnife;

/**
 * Created by etiennelawlor on 6/10/16.
 */

public class HostImageGalleryActivity extends AppCompatActivity {

    // region Lifecycle Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_image_gallery);
        ButterKnife.bind(this);

        Fragment fragment = getSupportFragmentManager().findFragmentById(android.R.id.content);
        if (fragment == null) {
            fragment = ImageGalleryFragment.newInstance(getIntent().getExtras());
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, fragment, "")
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .attach(fragment)
                    .commit();
        }
    }
    // endregion

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                supportFinishAfterTransition();
//                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
