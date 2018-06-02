
package com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tiny implements Serializable
{

    @SerializedName("https")
    @Expose
    public String https;
    private final static long serialVersionUID = 438106937618485427L;

}
