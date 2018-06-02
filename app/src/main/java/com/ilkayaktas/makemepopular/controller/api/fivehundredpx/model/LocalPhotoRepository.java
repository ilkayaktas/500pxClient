package com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model;

import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Photo;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.PhotoResponse;
import com.ilkayaktas.makemepopular.model.db.realm.RealmPhoto;
import com.ilkayaktas.makemepopular.utils.ObjectConverter;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iaktas on 05.09.2017.
 */
@Singleton
public class LocalPhotoRepository {
    private boolean isAtEnd;
    private int currentPage;
    private List<Photo> photos;

    public List<Photo> getPhotos() {
        return photos;
    }

    /**
     * Returns true if singleton contains data
     */
    public boolean hasData() {
        return photos != null;
    }

    /**
     * Returns the next page from the response
     */
    public int getNextPage() {
        if (photos == null) {
            return 1;
        } else if (!isAtEnd) {
            return currentPage + 1;
        } else {
            return currentPage;
        }
    }

    /**
     * Sets the updated response whenever a call to new page is requested
     *
     * @param photoResponse response to set
     */
    public void setPhotoResponse(PhotoResponse photoResponse) {
        if (photos == null) {
            photos = photoResponse.photos;
        } else if (photoResponse.photos.size() == 0) {
            isAtEnd = true;
        } else {
            photos.addAll(photoResponse.photos);
        }
        currentPage = photoResponse.currentPage;
    }

    public void setRealmPhotos(List<RealmPhoto> realmPhotos){
        if (photos == null) {
            photos = new ArrayList<>();
        }

        photos.clear();

        for (RealmPhoto realmPhoto : realmPhotos) {
            photos.add(ObjectConverter.toPhoto(realmPhoto));
        }
        currentPage = 1;
    }

}
