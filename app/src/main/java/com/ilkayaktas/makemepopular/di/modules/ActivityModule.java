package com.ilkayaktas.makemepopular.di.modules;

import android.app.Activity;
import android.graphics.Typeface;

import com.ilkayaktas.makemepopular.controller.IDataManager;
import com.ilkayaktas.makemepopular.controller.services.MobssAsyncTask;
import com.ilkayaktas.makemepopular.controller.strategy.Strategy;
import com.ilkayaktas.makemepopular.di.annotations.ActivityContext;
import com.ilkayaktas.makemepopular.di.annotations.PerActivity;
import com.ilkayaktas.makemepopular.views.activities.fullphotoscreen.FullPhotoScreenMvpPresenter;
import com.ilkayaktas.makemepopular.views.activities.fullphotoscreen.FullPhotoScreenMvpView;
import com.ilkayaktas.makemepopular.views.activities.fullphotoscreen.FullPhotoScreenPresenter;
import com.ilkayaktas.makemepopular.views.activities.home.MainMvpPresenter;
import com.ilkayaktas.makemepopular.views.activities.home.MainMvpView;
import com.ilkayaktas.makemepopular.views.activities.home.MainPresenter;
import com.ilkayaktas.makemepopular.views.activities.splash.SplashScreenMvpPresenter;
import com.ilkayaktas.makemepopular.views.activities.splash.SplashScreenMvpView;
import com.ilkayaktas.makemepopular.views.activities.splash.SplashScreenPresenter;
import com.ilkayaktas.makemepopular.views.fragments.photogrid.PhotosGridFragmentMvpPresenter;
import com.ilkayaktas.makemepopular.views.fragments.photogrid.PhotosGridFragmentMvpView;
import com.ilkayaktas.makemepopular.views.fragments.photogrid.PhotosGridFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ilkay on 10/03/2017.
 */

@Module
public class ActivityModule {
    Activity activity;
    
    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity provideActivity(){
        return activity;
    }
    
    @Provides
    @PerActivity
    Typeface provideTypeface(){
        return Typeface.createFromAsset(activity.getAssets(), "fonts/Roboto-Light.ttf");
    }
    
    @Provides
    @PerActivity
    @ActivityContext
    Typeface provideTypefaceForActivity(){
        return Typeface.createFromAsset(activity.getAssets(), "fonts/gothic.TTF");
    }
    
    @Provides
    @PerActivity
    SplashScreenMvpPresenter<SplashScreenMvpView> provideSplashScreenPresenter(IDataManager IDataManager) {
        return new SplashScreenPresenter<>(IDataManager);
    }
    
    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> providesMainPresenter(IDataManager IDataManager){
        return new MainPresenter<>(IDataManager);
    }

    @Provides
    PhotosGridFragmentMvpPresenter<PhotosGridFragmentMvpView> providesPhotosGridPresenter(IDataManager IDataManager){
        return new PhotosGridFragmentPresenter<>(IDataManager);
    }

    @Provides
    @PerActivity
    FullPhotoScreenMvpPresenter<FullPhotoScreenMvpView> providesSlideUpPanelPresenter(IDataManager IDataManager){
        return new FullPhotoScreenPresenter<>(IDataManager);
    }

    @Provides
    @PerActivity
    MobssAsyncTask providesMobssAsyncTask(Activity activity, Strategy strategy){
        return new MobssAsyncTask(activity, strategy);
    }

    @Provides
    @PerActivity
    List<String> provideSearchList(IDataManager IDataManager){
        List<String> isimList = new ArrayList<>();
                
        return isimList;
    }
}
