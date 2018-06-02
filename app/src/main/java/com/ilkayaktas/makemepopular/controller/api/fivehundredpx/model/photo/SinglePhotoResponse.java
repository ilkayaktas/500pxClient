package com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aselsan on 7.11.2017 at 11:26.
 */

public class SinglePhotoResponse {
    @SerializedName("photo")
    @Expose
    public Photo photo;
}
