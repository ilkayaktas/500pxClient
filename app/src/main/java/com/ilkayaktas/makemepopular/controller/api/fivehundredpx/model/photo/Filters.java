
package com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Filters implements Serializable
{

    @SerializedName("category")
    @Expose
    public int category;
    @SerializedName("exclude")
    @Expose
    public boolean exclude;
    private final static long serialVersionUID = -884068788510610686L;

}
