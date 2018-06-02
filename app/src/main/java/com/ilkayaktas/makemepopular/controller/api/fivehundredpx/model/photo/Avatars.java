
package com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Avatars {

    @SerializedName("small")
    @Expose
    public Small small;
    @SerializedName("large")
    @Expose
    public Large large;
    @SerializedName("default")
    @Expose
    public Default _default;
    @SerializedName("tiny")
    @Expose
    public Tiny tiny;

}
