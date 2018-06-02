package com.ilkayaktas.makemepopular.di.modules;

import android.app.Application;
import android.content.Context;
import com.ilkayaktas.makemepopular.controller.DataManager;
import com.ilkayaktas.makemepopular.controller.IDataManager;
import com.ilkayaktas.makemepopular.controller.api.FiveHundredPxApiHelper;
import com.ilkayaktas.makemepopular.controller.api.IFiveHundredPxApiHelper;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.http.FiveHundredPxPhotoService;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.LocalPhotoRepository;
import com.ilkayaktas.makemepopular.controller.db.DbHelper;
import com.ilkayaktas.makemepopular.controller.db.IDbHelper;
import com.ilkayaktas.makemepopular.controller.db.crud.DatabaseManager;
import com.ilkayaktas.makemepopular.controller.db.crud.DatabaseMigration;
import com.ilkayaktas.makemepopular.controller.db.crud.RealmManager;
import com.ilkayaktas.makemepopular.controller.pref.IPreferenceHelper;
import com.ilkayaktas.makemepopular.controller.pref.PreferenceHelper;
import com.ilkayaktas.makemepopular.di.annotations.ApplicationContext;
import com.ilkayaktas.makemepopular.utils.AppConstants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;
import java.util.HashMap;
/**
 * Created by ilkay on 09/03/2017.
 */

@Module
public class ApplicationModule {
	
	private final Application app;
	private RealmConfiguration realmConfiguration = null;
	private DatabaseManager databaseManager = null;
	private DataManager dataManager = null;
	
	public ApplicationModule(Application app) {
		this.app = app;
	}
	
	@Provides
	@ApplicationContext
	Context provideContext() {
		return app;
	}
	
	@Provides
	Application provideApplication(){
		return app;
	}
	
	@Provides
	@Singleton
    IDataManager provideDataManager(@ApplicationContext Context context, IDbHelper mIDbHelper, IPreferenceHelper mIPreferenceHelper, IFiveHundredPxApiHelper mIApiHelper) {
		if(dataManager == null) {
			dataManager = new DataManager(context, mIDbHelper, mIPreferenceHelper, mIApiHelper);
		}
		return dataManager;
	}
	
	@Provides
	@Singleton
	IDbHelper provideDbHelper(DatabaseManager databaseManager) {
		return new DbHelper(databaseManager);
	}
	
	@Provides
	@Singleton
	DatabaseManager provideDatabaseManager(Realm realm){
		if(databaseManager == null) {
			databaseManager = new RealmManager(realm);
		}
		return databaseManager;
	}
	
	@Provides
	@Singleton
	Realm provideRealm(){
		
		if(realmConfiguration == null) {
			// Create a RealmConfiguration that saves the Realm file in the app's "files" directory.
			realmConfiguration = new RealmConfiguration.Builder()
					.name("islamic.db")
					.migration(new DatabaseMigration())
					.encryptionKey(new String("YhvPohxPIDXI8wneZTgYwFElAuSeWOhea8WILKRvuHeiOQYaz1RLZ4m0ZEaAP7Gc").getBytes())
					.schemaVersion(1)
					.build();
		}
		
		// Get a Realm instance for this thread
		Realm realm = Realm.getInstance(realmConfiguration);
		
		return realm;
	}
	
	@Provides
	@Singleton
	IPreferenceHelper providePreferencesHelper(@ApplicationContext Context context) {
		return new PreferenceHelper(context);
	}
	
	@Provides
	@Singleton
	IFiveHundredPxApiHelper provideApiHelper(FiveHundredPxPhotoService fiveHundredPxPhotoService, HashMap<String, LocalPhotoRepository> localPhotoRepositories) {
		return new FiveHundredPxApiHelper(fiveHundredPxPhotoService, localPhotoRepositories);
	}

	@Provides
	@Singleton
	HashMap<String, LocalPhotoRepository> providesLocalPhotoRepositories(){
		return new HashMap<>();
	}

	@Provides
	@Singleton
	FiveHundredPxPhotoService provideAuthenticationFiveHundred(){
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
		// set your desired log level
		logging.setLevel(HttpLoggingInterceptor.Level.BODY);

		Retrofit retrofitApi = new Retrofit.Builder()
				.baseUrl(AppConstants.FIVEHUNDREDPX_BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.client(new OkHttpClient.Builder().addInterceptor(logging).build())
				.build();

		return retrofitApi.create(FiveHundredPxPhotoService.class);
	}

}
