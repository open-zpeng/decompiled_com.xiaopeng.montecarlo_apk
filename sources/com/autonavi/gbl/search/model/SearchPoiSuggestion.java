package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchPoiSuggestion implements Serializable {
    public ArrayList<SearchCitySuggestion> citySuggestion;
    public ArrayList<String> wordSuggestion;

    public SearchPoiSuggestion() {
        this.citySuggestion = new ArrayList<>();
        this.wordSuggestion = new ArrayList<>();
    }

    public SearchPoiSuggestion(ArrayList<SearchCitySuggestion> arrayList, ArrayList<String> arrayList2) {
        this.citySuggestion = arrayList;
        this.wordSuggestion = arrayList2;
    }
}
