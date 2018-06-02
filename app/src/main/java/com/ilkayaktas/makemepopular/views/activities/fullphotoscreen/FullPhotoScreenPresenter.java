package com.ilkayaktas.makemepopular.views.activities.fullphotoscreen;


import android.util.Log;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Photo;
import com.ilkayaktas.makemepopular.views.activities.base.BasePresenter;

/**
 * Created by ilkay on 02/08/2017.
 */

public class FullPhotoScreenPresenter<V extends FullPhotoScreenMvpView> extends BasePresenter<V>
		implements FullPhotoScreenMvpPresenter<V> {
	private static final String TAG = "FullPhotoScreenPresentr";

	public FullPhotoScreenPresenter(com.ilkayaktas.makemepopular.controller.IDataManager IDataManager) {
		super(IDataManager);
	}
	
	@Override
	public void savePhoto(Photo photo) {
		getIDataManager().savePhoto(photo);
	}

	@Override
	public void setAsFavorite(boolean isFavorite, Photo photo) {
		if(isFavorite){
			getIDataManager().savePhoto(photo);
		} else{
			getIDataManager().removePhoto(photo);
		}

		Log.d(TAG, "setAsFavorite: "+isFavorite+ " photo:"+photo);
	}

	@Override
	public void checkIfPhotoIsFavorite(Photo photo) {
		Log.d(TAG, "checkIfPhotoIsFavorite: "+photo.toString());

		if(getIDataManager().getPhoto(photo.id) == null){
			getMvpView().setAsFavorite(false);
			return;
		}

		getMvpView().setAsFavorite(true);
	}
}
