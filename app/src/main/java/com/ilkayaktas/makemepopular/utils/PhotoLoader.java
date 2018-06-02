package com.ilkayaktas.makemepopular.utils;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.ilkayaktas.makemepopular.namesofAllah.R;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

/**
 * Created by aselsan on 10.11.2017 at 16:05.
 */

@GlideModule
public class PhotoLoader extends AppGlideModule {
    public static void load(Context context, String photoUrl, ImageView imageView){

        // Glide
        if(AppConstants.PHOTO_LOADER_LIBRARY.equals(AppConstants.PhotoLoaderLibrary.GLIDE)){
            GlideApp.with(context)
                    .load(photoUrl)
                    .placeholder(R.mipmap.ic_placeholder)
                    .fitCenter()
                    .error(R.mipmap.ic_placeholder)
                    .into(imageView);
        }

        // Picasso
        if(AppConstants.PHOTO_LOADER_LIBRARY.equals(AppConstants.PhotoLoaderLibrary.PICASSO)){
            Picasso.with(context)
                    .load(photoUrl)
                    .networkPolicy(NetworkPolicy.OFFLINE)
                    .placeholder(R.mipmap.ic_placeholder)
                    .error(R.mipmap.ic_placeholder)
                    .into(imageView);
        }
    }

    public static void cancelRequest(Context context, ImageView imageView){
        // Glide
        if(AppConstants.PHOTO_LOADER_LIBRARY.equals(AppConstants.PhotoLoaderLibrary.GLIDE)){
            Glide.with(context).clear(imageView);
        }

        // Picasso
        if(AppConstants.PHOTO_LOADER_LIBRARY.equals(AppConstants.PhotoLoaderLibrary.PICASSO)) {
            Picasso.with(context).cancelRequest(imageView);
        }
    }
}
