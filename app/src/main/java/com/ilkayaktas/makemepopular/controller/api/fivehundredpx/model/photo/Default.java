
package com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Default implements Serializable
{

    @SerializedName("https")
    @Expose
    public String https;
    private final static long serialVersionUID = 2209109924178198522L;

}
