package com.ilkayaktas.makemepopular.controller;

import android.content.Context;
import com.ilkayaktas.makemepopular.controller.api.IFiveHundredPxApiHelper;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Photo;
import com.ilkayaktas.makemepopular.controller.db.IDbHelper;
import com.ilkayaktas.makemepopular.controller.pref.IPreferenceHelper;
import com.ilkayaktas.makemepopular.di.annotations.ApplicationContext;
import io.reactivex.Observable;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;


/**
 * Created by ilkay on 11/03/2017.
 */

@Singleton
public class DataManager implements IDataManager {

	private final String TAG = "DataManager";
	private final Context mContext;
	private final IDbHelper mIDbHelper;
	private final IPreferenceHelper mIPreferenceHelper;
	private final IFiveHundredPxApiHelper mIFiveHundredPxApiHelper;
	
	@Inject
	public DataManager(@ApplicationContext Context mContext, IDbHelper mIDbHelper, IPreferenceHelper mIPreferenceHelper, IFiveHundredPxApiHelper mIFiveHundredPxApiHelper) {
		this.mContext = mContext;
		this.mIDbHelper = mIDbHelper;
		this.mIPreferenceHelper = mIPreferenceHelper;
		this.mIFiveHundredPxApiHelper = mIFiveHundredPxApiHelper;
	}

	@Override
	public boolean getDatabaseCreatedStatus() {
		return mIPreferenceHelper.getDatabaseCreatedStatus();
	}

	@Override
	public void setDatabaseCreatedStatus(boolean isCreated) {
		mIPreferenceHelper.setDatabaseCreatedStatus(isCreated);
	}
	
	@Override
	public String getPreferredLanguage() {
		return mIPreferenceHelper.getPreferredLanguage();
	}
	
	@Override
	public void setPreferredLanguage(String language) {
		mIPreferenceHelper.setPreferredLanguage(language);
	}
	
	@Override
	public Observable<List<Photo>> fetchPhotos(String category, boolean nextPage) {
		return mIFiveHundredPxApiHelper.fetchPhotos(category, nextPage);
	}

	@Override
	public Observable<Photo> getSinglePhoto(String photoId) {
		return mIFiveHundredPxApiHelper.getSinglePhoto(photoId);
	}

	@Override
	public void savePhoto(Photo photo) {
		mIDbHelper.savePhoto(photo);
	}
	
	@Override
	public Photo getPhoto(int id) {
		return mIDbHelper.getPhoto(id);
	}

	@Override
	public void removePhoto(Photo photo) {
		mIDbHelper.removePhoto(photo);
	}

	@Override
	public List<Photo> getFavorites(boolean nextPage) {
		return mIDbHelper.getFavorites(nextPage);
	}
}
