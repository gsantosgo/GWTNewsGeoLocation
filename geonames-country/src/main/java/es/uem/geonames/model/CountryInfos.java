package es.uem.geonames.model;

import java.util.ArrayList;

public class CountryInfos {
	private ArrayList<CountryInfo> items;

	public ArrayList<CountryInfo> getContent() {
		return items;
	}

	public void add(CountryInfo item) {
		items.add(item);
	}

}
