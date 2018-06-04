
package com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable{

    @SerializedName("store_on")
    @Expose
    public Boolean storeOn;
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("usertype")
    @Expose
    public Integer usertype;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("userpic_url")
    @Expose
    public String userpicUrl;
    @SerializedName("cover_url")
    @Expose
    public String coverUrl;
    @SerializedName("affection")
    @Expose
    public Integer affection;
    @SerializedName("upgrade_status")
    @Expose
    public Integer upgradeStatus;
    @SerializedName("userpic_https_url")
    @Expose
    public String userpicHttpsUrl;
    @SerializedName("lastname")
    @Expose
    public String lastname;
    @SerializedName("firstname")
    @Expose
    public String firstname;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("fullname")
    @Expose
    public String fullname;
    @SerializedName("avatars")
    @Expose
    public Avatars avatars;

}
