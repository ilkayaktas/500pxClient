package com.ilkayaktas.makemepopular;

import android.app.Application;
import com.ilkayaktas.makemepopular.di.components.ApplicationComponent;
import com.ilkayaktas.makemepopular.di.components.DaggerApplicationComponent;
import com.ilkayaktas.makemepopular.di.modules.ApplicationModule;
import io.realm.Realm;

public class App extends Application {
	
	ApplicationComponent appComponent;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		Realm.init(this);
		
		initializeInjector();
		
	}
	
	private void initializeInjector(){
		appComponent = DaggerApplicationComponent.builder()
				.applicationModule(new ApplicationModule(this))
				.build();
		
		appComponent.inject(this);

	}
	
	public ApplicationComponent getAppComponent(){
		return appComponent;
	}
	
}