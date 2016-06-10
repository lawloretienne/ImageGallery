package com.etiennelawlor.imagegallery.library.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by etiennelawlor on 1/8/15.
 */
public class GridSpacesItemDecoration extends RecyclerView.ItemDecoration {

    // region Member Variables
    private final int space;
    private final int numOfColumns;
    // endregion

    // region Constructors
    public GridSpacesItemDecoration(int space, int numOfColumns) {
        this.space = space;
        this.numOfColumns = numOfColumns;
    }
    // endregion

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        int position = parent.getChildAdapterPosition(view);
        if(position < numOfColumns){
            outRect.top = space;
        }

        if(numOfColumns == 3){
            if(position % numOfColumns == 0){
                outRect.left = space;
                outRect.right = space/2;
            } else if(position % numOfColumns == 1){
                outRect.left = space/2;
                outRect.right = space/2;
            } else {
                outRect.left = space/2;
                outRect.right = space;
            }
        } else if(numOfColumns == 4){
            if(position % numOfColumns == 0){
                outRect.left = space;
                outRect.right = space/2;
            } else if(position % numOfColumns == 1){
                outRect.left = space/2;
                outRect.right = space/2;
            } else if(position % numOfColumns == 2){
                outRect.left = space/2;
                outRect.right = space/2;
            } else {
                outRect.left = space/2;
                outRect.right = space;
            }
        }

        outRect.bottom = space;
    }
}

