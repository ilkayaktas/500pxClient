package com.ilkayaktas.makemepopular.views.fragments.photogrid;


import android.content.Context;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Photo;
import com.ilkayaktas.makemepopular.views.activities.base.MvpView;

import java.util.List;

/**
 * Created by iaktas on 14.03.2017.
 */

public interface PhotosGridFragmentMvpView extends MvpView {
    void updateGridAdapter(List<Photo> photos);

    void updateGridAdapter(Photo photos);

    void setLoadingIndicator(final boolean active);

    void showError();

    void dismissSnackbar();

    Context getContext();
}
