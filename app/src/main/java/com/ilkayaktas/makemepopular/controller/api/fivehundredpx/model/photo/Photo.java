
package com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Photo implements Serializable
{

    public boolean isSharedPreviously;

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("user_id")
    @Expose
    public int userId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("description")
    @Expose
    public Object description;
    @SerializedName("camera")
    @Expose
    public String camera;
    @SerializedName("lens")
    @Expose
    public String lens;
    @SerializedName("focal_length")
    @Expose
    public String focalLength;
    @SerializedName("iso")
    @Expose
    public String iso;
    @SerializedName("shutter_speed")
    @Expose
    public String shutterSpeed;
    @SerializedName("aperture")
    @Expose
    public String aperture;
    @SerializedName("times_viewed")
    @Expose
    public int timesViewed;
    @SerializedName("rating")
    @Expose
    public double rating;
    @SerializedName("status")
    @Expose
    public int status;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("category")
    @Expose
    public int category;
    @SerializedName("location")
    @Expose
    public Object location;
    @SerializedName("latitude")
    @Expose
    public Object latitude;
    @SerializedName("longitude")
    @Expose
    public Object longitude;
    @SerializedName("taken_at")
    @Expose
    public String takenAt;
    @SerializedName("hi_res_uploaded")
    @Expose
    public int hiResUploaded;
    @SerializedName("for_sale")
    @Expose
    public boolean forSale;
    @SerializedName("width")
    @Expose
    public int width;
    @SerializedName("height")
    @Expose
    public int height;
    @SerializedName("votes_count")
    @Expose
    public int votesCount;
    @SerializedName("favorites_count")
    @Expose
    public int favoritesCount;
    @SerializedName("comments_count")
    @Expose
    public int commentsCount;
    @SerializedName("nsfw")
    @Expose
    public boolean nsfw;
    @SerializedName("sales_count")
    @Expose
    public int salesCount;
    @SerializedName("for_sale_date")
    @Expose
    public Object forSaleDate;
    @SerializedName("highest_rating")
    @Expose
    public double highestRating;
    @SerializedName("highest_rating_date")
    @Expose
    public String highestRatingDate;
    @SerializedName("license_type")
    @Expose
    public int licenseType;
    @SerializedName("collections_count")
    @Expose
    public int collectionsCount;
    @SerializedName("crop_version")
    @Expose
    public int cropVersion;
    @SerializedName("privacy")
    @Expose
    public boolean privacy;
    @SerializedName("profile")
    @Expose
    public boolean profile;
    @SerializedName("for_critique")
    @Expose
    public boolean forCritique;
    @SerializedName("critiques_callout_dismissed")
    @Expose
    public boolean critiquesCalloutDismissed;
    @SerializedName("image_url")
    @Expose
    public String imageUrl;
    @SerializedName("images")
    @Expose
    public List<Image> images = null;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("positive_votes_count")
    @Expose
    public int positiveVotesCount;
    @SerializedName("converted_bits")
    @Expose
    public int convertedBits;
    @SerializedName("store_download")
    @Expose
    public boolean storeDownload;
    @SerializedName("store_print")
    @Expose
    public boolean storePrint;
    @SerializedName("store_license")
    @Expose
    public boolean storeLicense;
    @SerializedName("request_to_buy_enabled")
    @Expose
    public boolean requestToBuyEnabled;
    @SerializedName("license_requests_enabled")
    @Expose
    public boolean licenseRequestsEnabled;
    @SerializedName("store_width")
    @Expose
    public int storeWidth;
    @SerializedName("store_height")
    @Expose
    public int storeHeight;
    @SerializedName("watermark")
    @Expose
    public boolean watermark;
    @SerializedName("image_format")
    @Expose
    public String imageFormat;
    @SerializedName("user")
    @Expose
    public User user;
    @SerializedName("licensing_requested")
    @Expose
    public boolean licensingRequested;
    @SerializedName("licensing_suggested")
    @Expose
    public boolean licensingSuggested;
    @SerializedName("is_free_photo")
    @Expose
    public boolean isFreePhoto;
    private final static long serialVersionUID = -8474578451491964858L;

}
