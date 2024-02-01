package com.xiaopeng.montecarlo.scenes.searchscene;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.ChildPoiGridView;
import com.xiaopeng.montecarlo.views.GotoPoiView;
import com.xiaopeng.montecarlo.views.SetHomeOfficeView;
import com.xiaopeng.montecarlo.views.SetWayPointView;
import com.xiaopeng.montecarlo.views.XPRecyclerView;
import com.xiaopeng.xui.vui.VuiView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class SearchResultVuiHelper {
    private static final L.Tag TAG = new L.Tag(SearchResultVuiHelper.class.getSimpleName());
    private static volatile SearchResultVuiHelper sInstance = new SearchResultVuiHelper();
    private IBaseScene mScene;

    public static SearchResultVuiHelper getInstance() {
        return sInstance;
    }

    public void updateSearchResultVui(final XPRecyclerView xPRecyclerView, IBaseScene iBaseScene, int i) {
        if (xPRecyclerView == null || xPRecyclerView.getVisibility() != 0) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("updateSearchResultVui vuiSceneId:" + iBaseScene + ",recyclerView:" + xPRecyclerView));
        }
        this.mScene = iBaseScene;
        xPRecyclerView.setVuiLayoutLoadable(true);
        RecyclerView.LayoutManager layoutManager = xPRecyclerView.getLayoutManager();
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, L.formatVoiceFullScenesLog("updateSearchResultVui vuiSceneId:" + iBaseScene + ",lm:" + layoutManager + ",recyclerView:" + xPRecyclerView));
        }
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition < 0 || findLastVisibleItemPosition < 0) {
                return;
            }
            if (L.ENABLE) {
                L.Tag tag3 = TAG;
                L.d(tag3, L.formatVoiceFullScenesLog("updateSearchResultVui firstVisiblePosition:" + findFirstVisibleItemPosition + ",lastVisiblePosition:" + findLastVisibleItemPosition));
            }
            for (int i2 = findFirstVisibleItemPosition; i2 <= findLastVisibleItemPosition; i2++) {
                View findViewByPosition = linearLayoutManager.findViewByPosition(i2);
                if (L.ENABLE) {
                    L.Tag tag4 = TAG;
                    L.d(tag4, L.formatVoiceFullScenesLog("updateSearchResultVui view:" + findViewByPosition));
                }
                if (findViewByPosition != null) {
                    RecyclerView.ViewHolder childViewHolder = xPRecyclerView.getChildViewHolder(findViewByPosition);
                    if (childViewHolder instanceof XpSearchViewHolder) {
                        XpSearchViewHolder xpSearchViewHolder = (XpSearchViewHolder) childViewHolder;
                        if (L.ENABLE) {
                            L.Tag tag5 = TAG;
                            L.d(tag5, L.formatVoiceFullScenesLog("updateSceneForVui holder:" + xpSearchViewHolder.getClass()));
                        }
                        if (xpSearchViewHolder.getPoiInfo(i2) != null && L.ENABLE) {
                            L.Tag tag6 = TAG;
                            L.d(tag6, L.formatVoiceFullScenesLog("updateSceneForVui poi name:" + xpSearchViewHolder.getPoiInfo(i2).getName()));
                        }
                        updateSceneWithAddWayResultViewHolder(xpSearchViewHolder, i2, findFirstVisibleItemPosition);
                        updateSceneWithSetResultViewHolder(xpSearchViewHolder, i2, i, findFirstVisibleItemPosition);
                        updateSceneWithGotoPoiResultViewHolder(xpSearchViewHolder, i2, findFirstVisibleItemPosition);
                    }
                }
            }
            UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultVuiHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SearchResultVuiHelper.this.mScene != null) {
                        VoiceFullScenesUtil.updateScene(SearchResultVuiHelper.this.mScene, xPRecyclerView);
                    }
                }
            }, 1000L);
        }
    }

    public void release() {
        this.mScene = null;
    }

    private void updateSceneWithAddWayResultViewHolder(XpSearchViewHolder xpSearchViewHolder, int i, int i2) {
        if (xpSearchViewHolder instanceof SearchResultAdapter.AddWayResultViewHolder) {
            SearchResultAdapter.AddWayResultViewHolder addWayResultViewHolder = (SearchResultAdapter.AddWayResultViewHolder) xpSearchViewHolder;
            formatWayPointViewHolder(addWayResultViewHolder.mTvOrder, addWayResultViewHolder.mTvName, addWayResultViewHolder.mTvAddress, addWayResultViewHolder.mContainer, addWayResultViewHolder.mItemDetail, addWayResultViewHolder.mContainerChild, addWayResultViewHolder.mSetWayPointView, i, "-result_waypoint", i2);
        }
    }

    private void updateSceneWithSetResultViewHolder(XpSearchViewHolder xpSearchViewHolder, int i, int i2, int i3) {
        if (xpSearchViewHolder instanceof SearchResultAdapter.SetResultViewHolder) {
            SearchResultAdapter.SetResultViewHolder setResultViewHolder = (SearchResultAdapter.SetResultViewHolder) xpSearchViewHolder;
            formatSetViewHolder(setResultViewHolder.mTvOrder, setResultViewHolder.mTvName, setResultViewHolder.mTvAddress, setResultViewHolder.mContainer, setResultViewHolder.mItemDetail, setResultViewHolder.mContainerChild, setResultViewHolder.mSetHomeOfficeView, i, String.format("-%s_%s", "", i2 == 1001 ? "SetHome" : i2 == 1002 ? "SetCompany" : "Set"), i3);
        }
    }

    private void updateSceneWithGotoPoiResultViewHolder(XpSearchViewHolder xpSearchViewHolder, int i, int i2) {
        if (xpSearchViewHolder instanceof SearchResultAdapter.GotoPoiResultViewHolder) {
            SearchResultAdapter.GotoPoiResultViewHolder gotoPoiResultViewHolder = (SearchResultAdapter.GotoPoiResultViewHolder) xpSearchViewHolder;
            formatGoToPoiViewHolder(gotoPoiResultViewHolder.mTvOrder, gotoPoiResultViewHolder.mTvName, gotoPoiResultViewHolder.mTvAddress, gotoPoiResultViewHolder.mContainer, gotoPoiResultViewHolder.mItemDetail, gotoPoiResultViewHolder.mContainerChild, gotoPoiResultViewHolder.mContainerGotoPoi, i, "-result_goto", i2);
        }
    }

    private <V extends View & VuiView> void formatWayPointViewHolder(final XTextView xTextView, XTextView xTextView2, XTextView xTextView3, final V v, final V v2, final ChildPoiGridView childPoiGridView, final SetWayPointView setWayPointView, final int i, final String str, final int i2) {
        if (xTextView2 == null || xTextView3 == null) {
            return;
        }
        final CharSequence text = xTextView2.getText();
        final CharSequence text2 = xTextView3.getText();
        if (TextUtils.isEmpty(text) && TextUtils.isEmpty(text2)) {
            return;
        }
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultVuiHelper.2
            @Override // java.lang.Runnable
            public void run() {
                final String formatElementFatherLabelForSearch = CommonVuiHelper.getInstance().formatElementFatherLabelForSearch(i, text, text2, i2, xTextView);
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultVuiHelper.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (v != null && v2 != null) {
                            ((VuiView) v).setVuiLabel(formatElementFatherLabelForSearch);
                            VoiceFullScenesUtil.setVuiElementTag(v2, v2.getId() + "-" + i + str);
                            ((VuiView) v2).setVuiLabel(ContextUtils.getString(R.string.vui_label_search_show_detail));
                            ((VuiView) v2).setVuiAction(ContextUtils.getString(R.string.vui_action_click_detail));
                        }
                        if (childPoiGridView != null) {
                            CommonVuiHelper.getInstance().formatChildPoi(childPoiGridView, text.toString(), i, str, formatElementFatherLabelForSearch);
                        }
                        if (setWayPointView != null) {
                            XLinearLayout containerAddWayPoint = setWayPointView.getContainerAddWayPoint();
                            VoiceFullScenesUtil.setVuiElementTag(containerAddWayPoint, containerAddWayPoint.getId() + "-" + i + str);
                            containerAddWayPoint.setVuiLabel(setWayPointView.getAddWaypointText());
                            containerAddWayPoint.setVuiAction(ContextUtils.getString(R.string.vui_action_click_add_waypoint));
                            CommonVuiHelper.getInstance().setExecElement((VuiView) v, containerAddWayPoint.getVuiElementId());
                            XLinearLayout containerDeleteWayPoint = setWayPointView.getContainerDeleteWayPoint();
                            VoiceFullScenesUtil.setVuiElementTag(containerDeleteWayPoint, containerDeleteWayPoint.getId() + "-" + i + str);
                            containerDeleteWayPoint.setVuiLabel(setWayPointView.getDeleteWaypointText());
                            containerDeleteWayPoint.setVuiAction(ContextUtils.getString(R.string.vui_action_click_delete_waypoint));
                            XLinearLayout containerGotoWayPoint = setWayPointView.getContainerGotoWayPoint();
                            VoiceFullScenesUtil.setVuiElementTag(containerGotoWayPoint, containerGotoWayPoint.getId() + "-" + i + str);
                            containerGotoWayPoint.setVuiLabel(ContextUtils.getString(R.string.vui_label_search_goto));
                        }
                    }
                });
            }
        });
    }

    private <V extends View & VuiView> void formatSetViewHolder(final XTextView xTextView, XTextView xTextView2, XTextView xTextView3, final V v, final V v2, final ChildPoiGridView childPoiGridView, final SetHomeOfficeView setHomeOfficeView, final int i, final String str, final int i2) {
        if (xTextView2 == null || xTextView3 == null) {
            return;
        }
        final CharSequence text = xTextView2.getText();
        final CharSequence text2 = xTextView3.getText();
        if (TextUtils.isEmpty(text) && TextUtils.isEmpty(text2)) {
            return;
        }
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultVuiHelper.3
            @Override // java.lang.Runnable
            public void run() {
                final String formatElementFatherLabelForSearch = CommonVuiHelper.getInstance().formatElementFatherLabelForSearch(i, text, text2, i2, xTextView);
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultVuiHelper.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (v != null && v2 != null) {
                            ((VuiView) v).setVuiLabel(formatElementFatherLabelForSearch);
                            VoiceFullScenesUtil.setVuiElementTag(v2, v2.getId() + "-" + i + str);
                            ((VuiView) v2).setVuiLabel(ContextUtils.getString(R.string.vui_label_search_show_detail));
                            ((VuiView) v2).setVuiAction(ContextUtils.getString(R.string.vui_action_click_detail));
                        }
                        if (setHomeOfficeView != null) {
                            if (setHomeOfficeView.getViewType() == 0) {
                                setHomeOfficeView.setId(R.id.container_set_home);
                            } else {
                                setHomeOfficeView.setId(R.id.container_set_office);
                            }
                            VoiceFullScenesUtil.setVuiElementTag(setHomeOfficeView, setHomeOfficeView.getId() + "-" + i + str);
                            setHomeOfficeView.setVuiLabel(setHomeOfficeView.getViewText().getText().toString());
                            if (setHomeOfficeView.getVisibility() == 0) {
                                setHomeOfficeView.setVuiAction(ContextUtils.getString(R.string.vui_action_click_set_address));
                                CommonVuiHelper.getInstance().setExecElement((VuiView) v, setHomeOfficeView.getVuiElementId());
                            }
                        }
                        if (childPoiGridView != null) {
                            CommonVuiHelper.getInstance().formatChildPoi(childPoiGridView, text.toString(), i, str, formatElementFatherLabelForSearch);
                        }
                    }
                });
            }
        });
    }

    private <V extends View & VuiView> void formatGoToPoiViewHolder(final XTextView xTextView, XTextView xTextView2, XTextView xTextView3, final V v, final V v2, final ChildPoiGridView childPoiGridView, final GotoPoiView gotoPoiView, final int i, final String str, final int i2) {
        if (xTextView2 == null || xTextView3 == null) {
            return;
        }
        final CharSequence text = xTextView2.getText();
        final CharSequence text2 = xTextView3.getText();
        if (TextUtils.isEmpty(text) && TextUtils.isEmpty(text2)) {
            return;
        }
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultVuiHelper.4
            @Override // java.lang.Runnable
            public void run() {
                final String formatElementFatherLabelForSearch = CommonVuiHelper.getInstance().formatElementFatherLabelForSearch(i, text, text2, i2, xTextView);
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultVuiHelper.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (v != null && v2 != null) {
                            ((VuiView) v).setVuiLabel(formatElementFatherLabelForSearch);
                            VoiceFullScenesUtil.setVuiElementTag(v2, v2.getId() + "-" + i + str);
                            ((VuiView) v2).setVuiLabel(ContextUtils.getString(R.string.vui_label_search_show_detail));
                            ((VuiView) v2).setVuiAction(ContextUtils.getString(R.string.vui_action_click_detail));
                        }
                        if (gotoPoiView != null) {
                            XLinearLayout containerGotoPoi = gotoPoiView.getContainerGotoPoi();
                            VoiceFullScenesUtil.setVuiElementTag(containerGotoPoi, containerGotoPoi.getId() + "-" + i + str);
                            containerGotoPoi.setVuiAction(ContextUtils.getString(R.string.vui_action_click_select_navi));
                            CommonVuiHelper.getInstance().setExecElement((VuiView) v, containerGotoPoi.getVuiElementId());
                            CommonVuiHelper.getInstance().setVuiLabel(containerGotoPoi, ContextUtils.getString(R.string.vui_label_search_goto), gotoPoiView.getText().toString());
                        }
                        if (L.ENABLE) {
                            L.Tag tag = SearchResultVuiHelper.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append(L.formatVoiceFullScenesLog("formatGoToPoiViewHolder container:" + ((VuiView) v2).getVuiElementId() + ",gotoPoiView:" + gotoPoiView.getContainerGotoPoi().getVuiElementId() + ",label:" + ((VuiView) v2).getVuiLabel()));
                            sb.append(",fatherLabel:");
                            sb.append(formatElementFatherLabelForSearch);
                            L.d(tag, sb.toString());
                        }
                        if (childPoiGridView != null) {
                            CommonVuiHelper.getInstance().formatChildPoi(childPoiGridView, text.toString(), i, str, formatElementFatherLabelForSearch);
                        }
                    }
                });
            }
        });
    }
}
