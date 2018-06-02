
package com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image implements Serializable
{

    @SerializedName("size")
    @Expose
    public int size;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("https_url")
    @Expose
    public String httpsUrl;
    @SerializedName("format")
    @Expose
    public String format;
    private final static long serialVersionUID = -255393915323878196L;

}
