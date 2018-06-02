package com.ilkayaktas.makemepopular.views.activities.fullphotoscreen;


import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Photo;
import com.ilkayaktas.makemepopular.views.activities.base.MvpPresenter;

/**
 * Created by ilkay on 02/08/2017.
 */

public interface FullPhotoScreenMvpPresenter<V extends FullPhotoScreenMvpView> extends MvpPresenter<V> {
	void savePhoto(Photo photo);

    void setAsFavorite(boolean isFavorite, Photo photo);

    void checkIfPhotoIsFavorite(Photo photo);
}
