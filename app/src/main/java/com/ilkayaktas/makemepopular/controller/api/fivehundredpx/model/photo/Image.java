
package com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Image implements Serializable{

    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("size")
    @Expose
    public Integer size;
    @SerializedName("https_url")
    @Expose
    public String httpsUrl;
    @SerializedName("format")
    @Expose
    public String format;

}
