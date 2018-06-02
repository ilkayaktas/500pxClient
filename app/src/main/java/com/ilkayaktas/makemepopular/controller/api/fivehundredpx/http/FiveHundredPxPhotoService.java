package com.ilkayaktas.makemepopular.controller.api.fivehundredpx.http;


import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.PhotoResponse;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.SinglePhotoResponse;
import com.ilkayaktas.makemepopular.namesofAllah.BuildConfig;
import com.ilkayaktas.makemepopular.utils.AppConstants;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by iaktas on 05.09.2017.
 */

public interface FiveHundredPxPhotoService {


    @GET(AppConstants.FIVEHUNDREDPX_PHOTOS_ENDPOINT_PATH +
            AppConstants.FIVEHUNDREDPX_IMAGE_SIZE_600_2048 +
            AppConstants.FIVEHUNDREDPX_PHOTOS_CONSUMER_KEY + BuildConfig.API_KEY+
            AppConstants.FIVEHUNDREDPX_PHOTOS_EXCLUDE)
    Observable<PhotoResponse> fetchPhotos(@Query(AppConstants.FIVEHUNDREDPX_PHOTOS_CATEGORY)String category,
                                          @Query(AppConstants.FIVEHUNDREDPX_PAGE) int page);

    @GET(AppConstants.FIVEHUNDREDPX_PHOTOS_BYID_ENDPOINT_PATH +
            AppConstants.FIVEHUNDREDPX_IMAGE_SIZE_600_2048 +
            AppConstants.FIVEHUNDREDPX_PHOTOS_CONSUMER_KEY + BuildConfig.API_KEY)
    Observable<SinglePhotoResponse> getSinglePhoto(@Path("id") String photoId);

}
