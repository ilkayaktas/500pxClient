package com.ilkayaktas.makemepopular.utils;

import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Image;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Photo;
import com.ilkayaktas.makemepopular.model.db.realm.RealmPhoto;

import java.util.Arrays;

/**
 * Created by aselsan on 31.10.2017 at 16:46.
 */

public class ObjectConverter {
    public static RealmPhoto toRealmPhoto(Photo photo) {
        RealmPhoto realmPhoto = new RealmPhoto();

        realmPhoto.id = photo.id;
        realmPhoto.url = photo.images.get(0).url;
        realmPhoto.bigUrl = photo.images.get(1).url;
        realmPhoto.name = photo.name;
        realmPhoto.positiveVoteCount = photo.positiveVotesCount;

        return realmPhoto;
    }

    public static Photo toPhoto(RealmPhoto realmPhoto){
        Photo photo = new Photo();

        photo.id = realmPhoto.id;
        photo.images = Arrays.asList(new Image(), new Image());
        photo.images.get(0).url = realmPhoto.url;
        photo.images.get(1).url = realmPhoto.bigUrl;
        photo.name = realmPhoto.name;
        photo.positiveVotesCount = realmPhoto.positiveVoteCount;

        return photo;
    }
}
