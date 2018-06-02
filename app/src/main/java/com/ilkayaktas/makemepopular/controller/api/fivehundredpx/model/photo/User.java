
package com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable
{

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("firstname")
    @Expose
    public String firstname;
    @SerializedName("lastname")
    @Expose
    public String lastname;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("usertype")
    @Expose
    public int usertype;
    @SerializedName("fullname")
    @Expose
    public String fullname;
    @SerializedName("userpic_url")
    @Expose
    public String userpicUrl;
    @SerializedName("userpic_https_url")
    @Expose
    public String userpicHttpsUrl;
    @SerializedName("cover_url")
    @Expose
    public String coverUrl;
    @SerializedName("upgrade_status")
    @Expose
    public int upgradeStatus;
    @SerializedName("store_on")
    @Expose
    public boolean storeOn;
    @SerializedName("affection")
    @Expose
    public int affection;
    @SerializedName("avatars")
    @Expose
    public Avatars avatars;
    @SerializedName("following")
    @Expose
    public boolean following;
    private final static long serialVersionUID = 4992388291130504345L;

}
