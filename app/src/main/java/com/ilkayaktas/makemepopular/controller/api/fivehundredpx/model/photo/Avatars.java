
package com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Avatars implements Serializable
{

    @SerializedName("default")
    @Expose
    public Default _default;
    @SerializedName("large")
    @Expose
    public Large large;
    @SerializedName("small")
    @Expose
    public Small small;
    @SerializedName("tiny")
    @Expose
    public Tiny tiny;
    private final static long serialVersionUID = 7945092662457836337L;

}
