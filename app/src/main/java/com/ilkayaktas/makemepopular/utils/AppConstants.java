/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.ilkayaktas.makemepopular.utils;

/**
 * Created by iaktas on 24/04/17.
 */

public final class AppConstants {
    private AppConstants() {
        // This utility class is not publicly instantiable
    }

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    public static final String LANGUAGE_TR = "tr";

    public static final String LANGUAGE_EN = "en";

    public static final String FIVEHUNDREDPX_BASE_URL = "https://api.500px.com/v1/";
    public static final String FIVEHUNDREDPX_PHOTOS_ENDPOINT_PATH = "photos?feature=popular";
    public static final String FIVEHUNDREDPX_PHOTOS_CONSUMER_KEY = "&consumer_key=";
    public static final String FIVEHUNDREDPX_IMAGE_SIZE_600_2048 = "&image_size=21,5";
    public static final String FIVEHUNDREDPX_PHOTOS_CATEGORY = "only";
    public static final String FIVEHUNDREDPX_PHOTOS_EXCLUDE = "&exclude=0,1,4,5,6,7,14,16,19,21,24,26,27";
    public static final String FIVEHUNDREDPX_PAGE = "page";
    public static final String FIVEHUNDREDPX_PHOTOS_BYID_ENDPOINT_PATH = "photos/{id}?";
    public static final int FIVEHUNDREDPX_OFF_SCREEN_PAGE_LIMIT = 4;

    public static final int MAX_ROW_HEIGHT = 250;

    public static final PhotoLoaderLibrary PHOTO_LOADER_LIBRARY = PhotoLoaderLibrary.GLIDE;
    enum PhotoLoaderLibrary{
        GLIDE,
        PICASSO
    }
}
