package com.ilkayaktas.makemepopular.controller.db;


import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Photo;

import java.util.List;

/**
 * Created by iaktas on 24/04/17.
 */

public interface IDbHelper {
	void savePhoto(Photo photo);
	
	Photo getPhoto(int id);

	void removePhoto(Photo photo);

    List<Photo> getFavorites(boolean nextPage);
}
