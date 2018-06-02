
package com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Photo implements Serializable
{

    @SerializedName("license_type")
    @Expose
    public Integer licenseType;
    @SerializedName("image_format")
    @Expose
    public String imageFormat;
    @SerializedName("image_url")
    @Expose
    public List<String> imageUrl = null;
    @SerializedName("purchased")
    @Expose
    public Boolean purchased;
    @SerializedName("feature")
    @Expose
    public String feature;
    @SerializedName("taken_at")
    @Expose
    public String takenAt;
    @SerializedName("for_sale")
    @Expose
    public Boolean forSale;
    @SerializedName("lens")
    @Expose
    public String lens;
    @SerializedName("feature_date")
    @Expose
    public String featureDate;
    @SerializedName("disliked")
    @Expose
    public Boolean disliked;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("editors_choice_date")
    @Expose
    public Object editorsChoiceDate;
    @SerializedName("hi_res_uploaded")
    @Expose
    public Integer hiResUploaded;
    @SerializedName("exclude_gads")
    @Expose
    public Boolean excludeGads;
    @SerializedName("highest_rating_date")
    @Expose
    public String highestRatingDate;
    @SerializedName("focal_length")
    @Expose
    public String focalLength;
    @SerializedName("aperture")
    @Expose
    public String aperture;
    @SerializedName("converted_bits")
    @Expose
    public Integer convertedBits;
    @SerializedName("editored_by")
    @Expose
    public EditoredBy editoredBy;
    @SerializedName("positive_votes_count")
    @Expose
    public Integer positiveVotesCount;
    @SerializedName("collections_count")
    @Expose
    public Integer collectionsCount;
    @SerializedName("crop_version")
    @Expose
    public Integer cropVersion;
    @SerializedName("profile")
    @Expose
    public Boolean profile;
    @SerializedName("user_id")
    @Expose
    public Integer userId;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("times_viewed")
    @Expose
    public Integer timesViewed;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("request_to_buy_enabled")
    @Expose
    public Boolean requestToBuyEnabled;
    @SerializedName("camera")
    @Expose
    public String camera;
    @SerializedName("longitude")
    @Expose
    public Double longitude;
    @SerializedName("editors_choice")
    @Expose
    public Boolean editorsChoice;
    @SerializedName("favorites_count")
    @Expose
    public Integer favoritesCount;
    @SerializedName("license_requests_enabled")
    @Expose
    public Boolean licenseRequestsEnabled;
    @SerializedName("voted")
    @Expose
    public Boolean voted;
    @SerializedName("licensing_requested")
    @Expose
    public Boolean licensingRequested;
    @SerializedName("for_sale_date")
    @Expose
    public Object forSaleDate;
    @SerializedName("iso")
    @Expose
    public String iso;
    @SerializedName("licensing_suggested")
    @Expose
    public Boolean licensingSuggested;
    @SerializedName("is_free_photo")
    @Expose
    public Boolean isFreePhoto;
    @SerializedName("location")
    @Expose
    public Object location;
    @SerializedName("privacy")
    @Expose
    public Boolean privacy;
    @SerializedName("shutter_speed")
    @Expose
    public String shutterSpeed;
    @SerializedName("user")
    @Expose
    public User user;
    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("width")
    @Expose
    public Integer width;
    @SerializedName("description")
    @Expose
    public Object description;
    @SerializedName("comments")
    @Expose
    public List<Object> comments = null;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("critiques_callout_dismissed")
    @Expose
    public Boolean critiquesCalloutDismissed;
    @SerializedName("watermark")
    @Expose
    public Boolean watermark;
    @SerializedName("sales_count")
    @Expose
    public Integer salesCount;
    @SerializedName("for_critique")
    @Expose
    public Boolean forCritique;
    @SerializedName("images")
    @Expose
    public List<Image> images = null;
    @SerializedName("licensing_status")
    @Expose
    public Integer licensingStatus;
    @SerializedName("rating")
    @Expose
    public Double rating;
    @SerializedName("nsfw")
    @Expose
    public Boolean nsfw;
    @SerializedName("comments_count")
    @Expose
    public Integer commentsCount;
    @SerializedName("category")
    @Expose
    public Integer category;
    @SerializedName("liked")
    @Expose
    public Boolean liked;
    @SerializedName("highest_rating")
    @Expose
    public Double highestRating;
    @SerializedName("converted")
    @Expose
    public Boolean converted;
    @SerializedName("latitude")
    @Expose
    public Double latitude;
    @SerializedName("votes_count")
    @Expose
    public Integer votesCount;
    @SerializedName("store_width")
    @Expose
    public Integer storeWidth;
    @SerializedName("store_height")
    @Expose
    public Integer storeHeight;

    public boolean isSharedPreviously;

}
