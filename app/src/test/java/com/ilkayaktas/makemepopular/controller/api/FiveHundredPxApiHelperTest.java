package com.ilkayaktas.makemepopular.controller.api;

import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.http.FiveHundredPxPhotoService;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Photo;
import com.ilkayaktas.makemepopular.utils.AppConstants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import io.reactivex.Observable;
import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by aselsan on 7.11.2017 at 08:08.
 */
public class FiveHundredPxApiHelperTest {
    static FiveHundredPxPhotoService fiveHundredPxPhotoService;



    @BeforeClass
    public static void setUp(){
        Retrofit retrofitApi = new Retrofit.Builder()
            .baseUrl(AppConstants.FIVEHUNDREDPX_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
        fiveHundredPxPhotoService = retrofitApi.create(FiveHundredPxPhotoService.class);
    }

    @Test
    public void fetchPhotos() throws Exception {
    }

    @Test
    public void getSinglePhoto() throws Exception {
        Observable<Photo> obs = fiveHundredPxPhotoService.getSinglePhoto("234558593");

        obs.doOnNext(photoResponse -> System.out.println(photoResponse.url));
    }

}