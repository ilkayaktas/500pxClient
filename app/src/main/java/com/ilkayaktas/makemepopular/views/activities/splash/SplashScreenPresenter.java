package com.ilkayaktas.makemepopular.views.activities.splash;


import com.ilkayaktas.makemepopular.views.activities.base.BasePresenter;

/**
 * Created by ilkay on 11/03/2017.
 */

public class SplashScreenPresenter <V extends SplashScreenMvpView> extends BasePresenter<V>
		implements SplashScreenMvpPresenter<V>{
	
	public SplashScreenPresenter(com.ilkayaktas.makemepopular.controller.IDataManager IDataManager) {
		super(IDataManager);
	}
	
	@Override
	public String getPreferredLanguage() {
		return getIDataManager().getPreferredLanguage();
	}
	
}
