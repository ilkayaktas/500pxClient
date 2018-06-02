package com.ilkayaktas.makemepopular.views.activities.splash;


import com.ilkayaktas.makemepopular.di.annotations.PerActivity;
import com.ilkayaktas.makemepopular.views.activities.base.MvpPresenter;

/**
 * Created by ilkay on 11/03/2017.
 */

@PerActivity
public interface SplashScreenMvpPresenter<V extends SplashScreenMvpView> extends MvpPresenter<V> {
	String getPreferredLanguage();
}
