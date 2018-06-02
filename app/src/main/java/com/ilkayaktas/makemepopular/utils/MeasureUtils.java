package com.ilkayaktas.makemepopular.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by iaktas on 20.09.2017.
 */

public class MeasureUtils {
    public static int pxToDp(int px, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, px,
                context.getResources().getDisplayMetrics());
    }

    public static int dpToPx(float dp, Context context) {
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }
}
