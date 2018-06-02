package com.ilkayaktas.makemepopular.views.fragments.photogrid;


import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Photo;
import com.ilkayaktas.makemepopular.views.activities.base.MvpPresenter;

/**
 * Created by iaktas on 14.03.2017.
 */

public interface PhotosGridFragmentMvpPresenter<V extends PhotosGridFragmentMvpView> extends MvpPresenter<V> {
    void fetchPhotos(String category, boolean nextPage);
    
    Photo getPhoto(int id);
}
