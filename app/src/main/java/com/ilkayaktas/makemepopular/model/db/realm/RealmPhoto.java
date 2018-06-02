package com.ilkayaktas.makemepopular.model.db.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ilkay on 10/09/2017.
 */

public class RealmPhoto extends RealmObject {
	@PrimaryKey
	public int id;
	public String url;
	public String bigUrl;
	public String name;
	public int positiveVoteCount;
	
	public RealmPhoto() {
	}
	
	public RealmPhoto(int id, String url, String bigUrl, String name, int positiveVoteCount) {
		this.id = id;
		this.url = url;
		this.bigUrl = bigUrl;
		this.name = name;
		this.positiveVoteCount = positiveVoteCount;
	}
}
