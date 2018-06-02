package com.ilkayaktas.makemepopular.views.widgets.gridlayout;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by ilkay on 7/9/17.
 * <p/>
 * Item decorator for {@link PhotoGridAdapter}
 * used for adding spaces in the items.
 *
 * @see <a href="http://stackoverflow.com/a/30794046/3354265">Reference</a>
 */
public class SpaceItemDecorator extends RecyclerView.ItemDecoration {

    private int mItemOffset;

    public SpaceItemDecorator(int itemOffset) {
        mItemOffset = itemOffset;
    }

    public SpaceItemDecorator(@NonNull Context context, @DimenRes int itemOffsetId) {
        this(context.getResources().getDimensionPixelSize(itemOffsetId));
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
    }
}
