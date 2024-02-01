package com.xiaopeng.montecarlo.util;

import android.os.Bundle;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.bridge.SearchResultBridge;
import com.xiaopeng.montecarlo.scenes.searchscene.PresenterData;
/* loaded from: classes3.dex */
public class BundleUtil {
    public Bundle searchBundleToBundle(PresenterData presenterData) {
        Bundle bundle = new Bundle();
        bundle.putInt(SearchBridge.SEARCH_MODE, presenterData.getSearchMode());
        bundle.putInt(SearchBridge.FROM_SCENE_INDEX, presenterData.getFromSceneIndex());
        bundle.putInt(SearchBridge.FROM_SCENE_CHILD_INDEX, presenterData.getFromSceneChildIndex());
        bundle.putInt(SearchBridge.SEARCH_DEST_KEY, presenterData.getSearchDest());
        if (presenterData.getSearchType() != 0) {
            bundle.putInt(SearchBridge.SEARCH_TYPE_KEY, presenterData.getSearchType());
        }
        if (presenterData.getSearchModeView() != 0) {
            bundle.putInt(SearchBridge.SEARCH_MODE_VIEW, presenterData.getSearchModeView());
        }
        if (presenterData.getAroundPoi() != null) {
            bundle.putParcelable(SearchBridge.SEARCH_AROUND_ITEM, presenterData.getAroundPoi());
        }
        if (presenterData.getSearchResult() != null) {
            bundle.putParcelableArrayList("search_result", presenterData.getSearchResult());
        }
        if (presenterData.getSearchResultSearchParams() != null) {
            bundle.putParcelable(SearchResultBridge.SEARCH_RESULT_SEARCH_PARAMS, presenterData.getSearchResultSearchParams());
        }
        if (presenterData.getSearchResultFavoritePoi() != null) {
            bundle.putParcelable(SearchResultBridge.SEARCH_RESULT_FAVORITE_POI, presenterData.getSearchResultFavoritePoi());
        }
        if (presenterData.getSearchFromKey() != null && !presenterData.getSearchFromKey().isEmpty()) {
            bundle.putString(SearchBridge.SEARCH_FROM_KEY, presenterData.getSearchFromKey());
        }
        if (presenterData.getAnimType() != 0) {
            bundle.putInt(SearchBridge.ANIM_TYPE, presenterData.getAnimType());
        }
        if (presenterData.getSearchKeywordText() != null && !presenterData.getSearchKeywordText().isEmpty()) {
            bundle.putString(SearchBridge.SEARCH_KEYWORD_TEXT, presenterData.getSearchKeywordText());
        }
        return bundle;
    }
}
