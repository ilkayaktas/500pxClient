package com.ilkayaktas.makemepopular.views.fragments.photogrid;


import android.util.Log;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Photo;
import com.ilkayaktas.makemepopular.namesofAllah.R;
import com.ilkayaktas.makemepopular.views.activities.base.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

/**
 * Created by iaktas on 14.03.2017.
 */

public class    PhotosGridFragmentPresenter<V extends PhotosGridFragmentMvpView> extends BasePresenter<V> implements PhotosGridFragmentMvpPresenter<V> {
    private final String TAG = "PhotosGridFrgPresenter";

    public PhotosGridFragmentPresenter(com.ilkayaktas.makemepopular.controller.IDataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void fetchPhotos(String category, boolean nextPage) {
        getMvpView().setLoadingIndicator(true);
        getMvpView().dismissSnackbar();

        if (category.equals(getMvpView().getContext().getString(R.string.your_favorite))){ // category string is last string in array. It means favorites.
            List<Photo> favoryPhotos = getIDataManager().getFavorites(nextPage);

            if(nextPage || favoryPhotos.isEmpty()){ // no next page for favorite photo. Probably, it will exist in the future.
                getMvpView().setLoadingIndicator(false);
                return;
            }
            for (Photo photo : favoryPhotos) {
                Log.d(TAG, "fetchPhotos: "+photo.id);

                getIDataManager().getSinglePhoto(String.valueOf(photo.id))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(PhotosGridFragmentPresenter.this::onNextSinglePhoto, PhotosGridFragmentPresenter.this::onError);
            }

        } else{
            getIDataManager().fetchPhotos(category, nextPage)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(PhotosGridFragmentPresenter.this::onNext, PhotosGridFragmentPresenter.this::onError);
        }

    }

    private void onNextSinglePhoto(Photo photo) {
        Log.d(TAG, "onNextSinglePhoto: " + photo.name + " " + photo.id + " " + photo.images.get(0).url);
        getMvpView().setLoadingIndicator(false);
        getMvpView().updateGridAdapter(photo);
    }

    @Override
    public Photo getPhoto(int id) {
        return getIDataManager().getPhoto(id);
    }
    
    private void onError(Throwable throwable) {
        throwable.printStackTrace();
	    getMvpView().setLoadingIndicator(false);
        getMvpView().showError();
    }

    private void onNext(List<Photo> photos) {
        for (Photo photo : photos) {
            // query photo if it's shared or not
            Photo dbPhoto = getPhoto(photo.id);
            // mark as shared previously
            if(dbPhoto != null){
                photo.isSharedPreviously = true;
            }
            Log.d(TAG, "onNext: " + photo.name + " " + photo.id + " " + photo.images.get(0).url);
            System.out.println();
        }

        getMvpView().setLoadingIndicator(false);
        getMvpView().updateGridAdapter(photos);
    }
}
