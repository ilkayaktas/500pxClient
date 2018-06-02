
package com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PhotoResponse implements Serializable
{

    @SerializedName("current_page")
    @Expose
    public int currentPage;
    @SerializedName("total_pages")
    @Expose
    public int totalPages;
    @SerializedName("total_items")
    @Expose
    public int totalItems;
    @SerializedName("photos")
    @Expose
    public List<Photo> photos = null;
//    @SerializedName("filters")
//    @Expose
//    public Filters filters;
    @SerializedName("feature")
    @Expose
    public String feature;
    private final static long serialVersionUID = -4960494026320430098L;

}
