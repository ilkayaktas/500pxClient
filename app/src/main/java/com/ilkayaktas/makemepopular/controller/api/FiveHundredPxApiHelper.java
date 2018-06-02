package com.ilkayaktas.makemepopular.controller.api;

import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.http.FiveHundredPxPhotoService;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.LocalPhotoRepository;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Photo;
import io.reactivex.Observable;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ilkay on 01/07/2017.
 */

@Singleton
public class FiveHundredPxApiHelper implements IFiveHundredPxApiHelper {

    private FiveHundredPxPhotoService fiveHundredPxPhotoService;

    private HashMap<String, LocalPhotoRepository> localRepositories;

    public FiveHundredPxApiHelper(FiveHundredPxPhotoService fiveHundredPxPhotoService, HashMap<String, LocalPhotoRepository>  localPhotoRepositories) {
        this.fiveHundredPxPhotoService = fiveHundredPxPhotoService;
        this.localRepositories = localPhotoRepositories;
    }

    @Override
    public Observable<List<Photo>> fetchPhotos(String category, boolean nextPage) {
        if (localRepositories.get(category) != null && localRepositories.get(category).hasData() && !nextPage) {
            return Observable.just(localRepositories.get(category).getPhotos());
        } else {
            if(!localRepositories.containsKey(category)) {
                localRepositories.put(category, new LocalPhotoRepository());
            }
            
            if(category.toLowerCase().equals("all")){
                return fiveHundredPxPhotoService.fetchPhotos("", localRepositories.get(category).getNextPage())
                        .doOnNext(photoResponse -> localRepositories.get(category).setPhotoResponse(photoResponse))
                        .flatMap(photoResponse -> Observable.just(localRepositories.get(category).getPhotos()));
            } else{
    
                return fiveHundredPxPhotoService.fetchPhotos(category, localRepositories.get(category).getNextPage())
                        .doOnNext(photoResponse -> localRepositories.get(category).setPhotoResponse(photoResponse))
                        .flatMap(photoResponse -> Observable.just(localRepositories.get(category).getPhotos()));
            }
        }
    }

    @Override
    public Observable<Photo> getSinglePhoto(String photoId){
        return fiveHundredPxPhotoService.getSinglePhoto(photoId).flatMap(singlePhotoResponse -> Observable.just(singlePhotoResponse.photo));
    }
}
