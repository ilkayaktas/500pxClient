
package com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Filters {

    @SerializedName("category")
    @Expose
    public Integer category;
    @SerializedName("exclude")
    @Expose
    public Boolean exclude;

}
