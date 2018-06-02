package com.ilkayaktas.makemepopular.di.components;


import android.app.Application;
import android.content.Context;

import com.ilkayaktas.makemepopular.App;
import com.ilkayaktas.makemepopular.controller.IDataManager;
import com.ilkayaktas.makemepopular.di.annotations.ApplicationContext;
import com.ilkayaktas.makemepopular.di.modules.ApplicationModule;
import com.ilkayaktas.makemepopular.controller.db.crud.DatabaseManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ilkay on 26/02/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(App app);
    
    @ApplicationContext
    Context context();
    
    Application application();
    
    IDataManager getDataManager();
    
    DatabaseManager getDatabaseManager();
    
}
