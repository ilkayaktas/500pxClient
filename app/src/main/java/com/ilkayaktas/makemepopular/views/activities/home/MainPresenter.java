package com.ilkayaktas.makemepopular.views.activities.home;


import com.ilkayaktas.makemepopular.controller.IDataManager;
import com.ilkayaktas.makemepopular.views.activities.base.BasePresenter;

/**
 * Created by ilkay on 12/03/2017.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
		implements MainMvpPresenter<V>{
	
	public MainPresenter(IDataManager IDataManager) {
		super(IDataManager);

	}

}
