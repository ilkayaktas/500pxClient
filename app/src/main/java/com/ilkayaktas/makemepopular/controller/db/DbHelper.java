package com.ilkayaktas.makemepopular.controller.db;


import android.util.Log;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.LocalPhotoRepository;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Photo;
import com.ilkayaktas.makemepopular.controller.db.crud.DatabaseManager;
import com.ilkayaktas.makemepopular.model.db.realm.RealmPhoto;
import com.ilkayaktas.makemepopular.utils.ObjectConverter;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by ilkay on 12/03/2017.
 */

@Singleton
public class DbHelper implements IDbHelper {

	private final String TAG = "DbHelper";

	private final DatabaseManager databaseManager;
	private LocalPhotoRepository localPhotoRepository = null;

	@Inject
	public DbHelper(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}
	
	@Override
	public void savePhoto(Photo photo) {
		RealmPhoto realmPhoto = ObjectConverter.toRealmPhoto(photo);
		databaseManager.saveOrUpdate(realmPhoto);
	}
	
	@Override
	public Photo getPhoto(int id) {
		List photoList = databaseManager.get(RealmPhoto.class, "id", id);
		if(photoList.size() == 0){
			return null;
		} else{
			return ObjectConverter.toPhoto((RealmPhoto) photoList.get(0));
		}
	}

	@Override
	public void removePhoto(Photo photo) {
		databaseManager.delete(RealmPhoto.class, "id", photo.id);
	}

	@Override
	public List<Photo> getFavorites(boolean nextPage) {

		List<Photo> photos = new ArrayList<>();
		List<RealmPhoto> favoryPhotos = databaseManager.getAll(RealmPhoto.class);

		for (RealmPhoto realmPhoto : favoryPhotos) {
			Log.d(TAG, "getFavorites: "+realmPhoto.id);
			photos.add(ObjectConverter.toPhoto(realmPhoto));
		}
		return photos;
	}
}
