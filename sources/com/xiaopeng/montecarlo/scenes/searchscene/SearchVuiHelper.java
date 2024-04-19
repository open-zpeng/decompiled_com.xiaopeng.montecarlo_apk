package com.xiaopeng.montecarlo.scenes.searchscene;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.searchscene.FavoriteAdapter;
import com.xiaopeng.montecarlo.scenes.searchscene.HistoryRecordAdapter;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchAdapter;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.ChildPoiGridView;
import com.xiaopeng.montecarlo.views.GotoPoiView;
import com.xiaopeng.montecarlo.views.HistoryRouteView;
import com.xiaopeng.montecarlo.views.SetHomeOfficeView;
import com.xiaopeng.montecarlo.views.SetWayPointView;
import com.xiaopeng.montecarlo.views.SwipeMenuLayout;
import com.xiaopeng.montecarlo.views.XPRecyclerView;
import com.xiaopeng.xui.vui.VuiView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SearchVuiHelper {
    private static final L.Tag TAG = new L.Tag("SearchVuiHelper");
    private static volatile SearchVuiHelper sInstance = new SearchVuiHelper();
    private int mPageVuiState = 0;

    public static SearchVuiHelper getInstance() {
        return sInstance;
    }

    public int getPageVuiState() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("getPageVuiState mPageVuiState:" + this.mPageVuiState));
        }
        return this.mPageVuiState;
    }

    public String getPageVuiStateDesc() {
        return ContextUtils.getStringArray(R.array.search_page_vui_state_arr)[getPageVuiState()];
    }

    public void setPageVuiState(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("setPageVuiState vuiState:" + i));
        }
        this.mPageVuiState = i;
    }

    public void resetPageVuiState() {
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("resetPageVuiState"));
        }
        setPageVuiState(0);
    }

    /* loaded from: classes3.dex */
    public class PageVuiState {
        public static final int VUI_STATE_SEARCH_AROUND = 4;
        public static final int VUI_STATE_SETTING_HOME = 1;
        public static final int VUI_STATE_SETTING_OFFICE = 2;
        public static final int VUI_STATE_STANDARD = 0;
        public static final int VUI_STATE_WAYPOINT = 3;

        public PageVuiState() {
        }
    }

    public boolean updateSceneForVui(final XPRecyclerView xPRecyclerView, final IBaseScene iBaseScene, CharSequence charSequence, int i) {
        if (xPRecyclerView != null || xPRecyclerView.getVisibility() == 0) {
            xPRecyclerView.setVuiLayoutLoadable(true);
            RecyclerView.LayoutManager layoutManager = xPRecyclerView.getLayoutManager();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatVoiceFullScenesLog("updateSceneForVui vuiSceneId:" + iBaseScene + ",lm:" + layoutManager + ",recyclerView:" + xPRecyclerView + ",keyword:" + ((Object) charSequence) + ",searchDest:" + i));
            }
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (findFirstVisibleItemPosition < 0 || findLastVisibleItemPosition < 0) {
                    return false;
                }
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, L.formatVoiceFullScenesLog("updateSceneForVui firstVisiblePosition:" + findFirstVisibleItemPosition + ",lastVisiblePosition:" + findLastVisibleItemPosition));
                }
                for (int i2 = findFirstVisibleItemPosition; i2 <= findLastVisibleItemPosition; i2++) {
                    View findViewByPosition = linearLayoutManager.findViewByPosition(i2);
                    if (L.ENABLE) {
                        L.Tag tag3 = TAG;
                        L.d(tag3, L.formatVoiceFullScenesLog("updateSceneForVui view:" + findViewByPosition + ",position:" + i2));
                    }
                    if (findViewByPosition != null) {
                        RecyclerView.ViewHolder childViewHolder = xPRecyclerView.getChildViewHolder(findViewByPosition);
                        if (childViewHolder instanceof XpSearchViewHolder) {
                            XpSearchViewHolder xpSearchViewHolder = (XpSearchViewHolder) childViewHolder;
                            if (L.ENABLE) {
                                L.Tag tag4 = TAG;
                                L.d(tag4, L.formatVoiceFullScenesLog("updateSceneForVui holder:" + xpSearchViewHolder.getClass()));
                            }
                            if (xpSearchViewHolder.getPoiInfo(i2) != null && L.ENABLE) {
                                L.Tag tag5 = TAG;
                                StringBuilder sb = new StringBuilder();
                                sb.append(L.formatVoiceFullScenesLog("updateSceneForVui poi name:" + xpSearchViewHolder.getPoiInfo(i2).getName()));
                                sb.append(",position:");
                                sb.append(i2);
                                L.d(tag5, sb.toString());
                            }
                            updateSceneWithKeywordViewHolder(findViewByPosition, xpSearchViewHolder, i2, findFirstVisibleItemPosition);
                            updateSceneWithHistoryRouteHolder(findViewByPosition, xpSearchViewHolder, i2, findFirstVisibleItemPosition);
                            updateSceneWithWayPointViewHolder(findViewByPosition, xpSearchViewHolder, i2, findFirstVisibleItemPosition);
                            int i3 = i2;
                            updateSceneWithSetViewHolder(findViewByPosition, xpSearchViewHolder, i3, i, findFirstVisibleItemPosition);
                            updateSceneWithGoToPoiViewHolder(findViewByPosition, xpSearchViewHolder, i3, charSequence, findFirstVisibleItemPosition);
                        }
                    }
                }
                UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchVuiHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VoiceFullScenesUtil.updateScene(iBaseScene, xPRecyclerView);
                    }
                }, 1000L);
                return true;
            }
            return true;
        }
        return false;
    }

    private void updateSceneWithWayPointViewHolder(View view, XpSearchViewHolder xpSearchViewHolder, int i, int i2) {
        if (xpSearchViewHolder instanceof HistoryRecordAdapter.AddWayViewHolder) {
            HistoryRecordAdapter.AddWayViewHolder addWayViewHolder = (HistoryRecordAdapter.AddWayViewHolder) xpSearchViewHolder;
            formatWayPointViewHolder(addWayViewHolder.mName, addWayViewHolder.mAddressName, addWayViewHolder.mSwipeMenuLayout, addWayViewHolder.mContainer, addWayViewHolder.mContainerChild, addWayViewHolder.mSetWayPointView, addWayViewHolder.mTvDestDelete, i, view, "-history_waypoint", i2);
        } else if (xpSearchViewHolder instanceof SearchAdapter.AddWayViewHolder) {
            SearchAdapter.AddWayViewHolder addWayViewHolder2 = (SearchAdapter.AddWayViewHolder) xpSearchViewHolder;
            formatWayPointViewHolder(addWayViewHolder2.mTvName, addWayViewHolder2.mTvAddress, addWayViewHolder2.mContainerContent, addWayViewHolder2.mItemDetail, null, addWayViewHolder2.mSetWayPointView, null, i, view, "-search_waypoint", i2);
        } else if (xpSearchViewHolder instanceof FavoriteAdapter.AddWayViewHolder) {
            FavoriteAdapter.AddWayViewHolder addWayViewHolder3 = (FavoriteAdapter.AddWayViewHolder) xpSearchViewHolder;
            formatWayPointViewHolder(addWayViewHolder3.mTvName, addWayViewHolder3.mTvAddress, addWayViewHolder3.mSwipeMenuLayout, addWayViewHolder3.mContainer, null, addWayViewHolder3.mSetWayPointView, addWayViewHolder3.mDelete, i, view, "-favorite_waypoint", i2);
        }
    }

    private <V extends View & VuiView> void formatWayPointViewHolder(XTextView xTextView, XTextView xTextView2, final V v, final V v2, final ChildPoiGridView childPoiGridView, final SetWayPointView setWayPointView, final XTextView xTextView3, final int i, final View view, final String str, final int i2) {
        if (xTextView == null || xTextView2 == null) {
            return;
        }
        final CharSequence text = xTextView.getText();
        final CharSequence text2 = xTextView2.getText();
        if (TextUtils.isEmpty(text) && TextUtils.isEmpty(text2)) {
            return;
        }
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchVuiHelper.2
            @Override // java.lang.Runnable
            public void run() {
                final String formatElementFatherLabelForSearch = CommonVuiHelper.getInstance().formatElementFatherLabelForSearch(i, text, text2, i2, null);
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchVuiHelper.2.1
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
                            if (containerAddWayPoint.getVisibility() == 0) {
                                CommonVuiHelper.getInstance().setExecElement((VuiView) v, containerAddWayPoint.getVuiElementId());
                            }
                            XLinearLayout containerDeleteWayPoint = setWayPointView.getContainerDeleteWayPoint();
                            VoiceFullScenesUtil.setVuiElementTag(containerDeleteWayPoint, containerDeleteWayPoint.getId() + "-" + i + str);
                            containerDeleteWayPoint.setVuiLabel(setWayPointView.getDeleteWaypointText());
                            containerDeleteWayPoint.setVuiAction(ContextUtils.getString(R.string.vui_action_click_delete_waypoint));
                            if (containerDeleteWayPoint.getVisibility() == 0) {
                                CommonVuiHelper.getInstance().setExecElement((VuiView) v, containerDeleteWayPoint.getVuiElementId());
                            }
                            XLinearLayout containerGotoWayPoint = setWayPointView.getContainerGotoWayPoint();
                            VoiceFullScenesUtil.setVuiElementTag(containerGotoWayPoint, containerGotoWayPoint.getId() + "-" + i + str);
                            containerGotoWayPoint.setVuiLabel(String.format("%s|%s", ContextUtils.getString(R.string.vui_label_search_goto), setWayPointView.getGotoWaypointText()));
                            containerGotoWayPoint.setVuiAction(ContextUtils.getString(R.string.vui_action_click_select_navi));
                        }
                        if (xTextView3 != null) {
                            VoiceFullScenesUtil.setVuiElementTag(xTextView3, xTextView3.getId() + "-" + i + str);
                            xTextView3.setVuiAction(ContextUtils.getString(R.string.vui_action_click_delete));
                        }
                        view.setTag(Integer.valueOf(i));
                    }
                });
            }
        });
    }

    private void updateSceneWithGoToPoiViewHolder(View view, XpSearchViewHolder xpSearchViewHolder, int i, CharSequence charSequence, int i2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(L.formatVoiceFullScenesLog("updateSceneWithGoToPoiViewHolder holder:" + xpSearchViewHolder.getClass()));
            sb.append(",position:");
            sb.append(i);
            L.d(tag, sb.toString());
        }
        if (xpSearchViewHolder instanceof HistoryRecordAdapter.GotoPoiViewHolder) {
            HistoryRecordAdapter.GotoPoiViewHolder gotoPoiViewHolder = (HistoryRecordAdapter.GotoPoiViewHolder) xpSearchViewHolder;
            formatGoToPoiViewHolder(gotoPoiViewHolder.mName, gotoPoiViewHolder.mAddressName, gotoPoiViewHolder.mSwipeMenuLayout, gotoPoiViewHolder.mContainer, gotoPoiViewHolder.mContainerChild, gotoPoiViewHolder.mContainerGotoPoi, gotoPoiViewHolder.mTvDestDelete, i, view, "-history_goto", i2);
        } else if (xpSearchViewHolder instanceof SearchAdapter.GotoPoiViewHolder) {
            SearchAdapter.GotoPoiViewHolder gotoPoiViewHolder2 = (SearchAdapter.GotoPoiViewHolder) xpSearchViewHolder;
            formatGoToPoiViewHolder(gotoPoiViewHolder2.mTvName, gotoPoiViewHolder2.mTvAddress, gotoPoiViewHolder2.mContainerContent, gotoPoiViewHolder2.mItemDetail, null, gotoPoiViewHolder2.mContainerGotoPoi, null, i, view, TextUtils.isEmpty(charSequence) ? "-search_goto" : "-search_goto_sug", i2);
        } else if (xpSearchViewHolder instanceof FavoriteAdapter.GotoPoiViewHolder) {
            FavoriteAdapter.GotoPoiViewHolder gotoPoiViewHolder3 = (FavoriteAdapter.GotoPoiViewHolder) xpSearchViewHolder;
            formatGoToPoiViewHolder(gotoPoiViewHolder3.mTvName, gotoPoiViewHolder3.mTvAddress, gotoPoiViewHolder3.mSwipeMenuLayout, gotoPoiViewHolder3.mContainer, null, gotoPoiViewHolder3.mContainerGotoPoi, gotoPoiViewHolder3.mDelete, i, view, "-favorite_goto", i2);
        }
    }

    private <V extends View & VuiView> void formatGoToPoiViewHolder(XTextView xTextView, XTextView xTextView2, final V v, final V v2, final ChildPoiGridView childPoiGridView, final GotoPoiView gotoPoiView, final XTextView xTextView3, final int i, final View view, final String str, final int i2) {
        if (xTextView == null || xTextView2 == null) {
            return;
        }
        final CharSequence text = xTextView.getText();
        final CharSequence text2 = xTextView2.getText();
        if (TextUtils.isEmpty(text) && TextUtils.isEmpty(text2)) {
            return;
        }
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchVuiHelper.3
            @Override // java.lang.Runnable
            public void run() {
                final String formatElementFatherLabelForSearch = CommonVuiHelper.getInstance().formatElementFatherLabelForSearch(i, text, text2, i2, null);
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchVuiHelper.3.1
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
                            containerGotoPoi.setVuiLabel(String.format("%s|%s", ContextUtils.getString(R.string.vui_label_search_goto), gotoPoiView.getText().toString()));
                            containerGotoPoi.setVuiAction(ContextUtils.getString(R.string.vui_action_click_select_navi));
                            CommonVuiHelper.getInstance().setExecElement((VuiView) v, containerGotoPoi.getVuiElementId());
                        }
                        if (L.ENABLE) {
                            L.Tag tag = SearchVuiHelper.TAG;
                            L.d(tag, L.formatVoiceFullScenesLog("formatGoToPoiViewHolder container:" + ((VuiView) v2).getVuiElementId() + ",gotoPoiView:" + gotoPoiView.getContainerGotoPoi().getVuiElementId() + ",label:" + formatElementFatherLabelForSearch));
                        }
                        if (childPoiGridView != null) {
                            CommonVuiHelper.getInstance().formatChildPoi(childPoiGridView, text.toString(), i, str, formatElementFatherLabelForSearch);
                        }
                        if (xTextView3 != null) {
                            VoiceFullScenesUtil.setVuiElementTag(xTextView3, xTextView3.getId() + "-" + i + str);
                            xTextView3.setVuiAction(ContextUtils.getString(R.string.vui_action_click_delete));
                        }
                        view.setTag(Integer.valueOf(i));
                    }
                });
            }
        });
    }

    private void updateSceneWithSetViewHolder(View view, XpSearchViewHolder xpSearchViewHolder, int i, int i2, int i3) {
        String str = i2 == 1001 ? "SetHome" : i2 == 1002 ? "SetCompany" : "Set";
        if (xpSearchViewHolder instanceof HistoryRecordAdapter.SetViewHolder) {
            HistoryRecordAdapter.SetViewHolder setViewHolder = (HistoryRecordAdapter.SetViewHolder) xpSearchViewHolder;
            formatSetViewHolder(setViewHolder.mName, setViewHolder.mAddressName, setViewHolder.mSwipeMenuLayout, setViewHolder.mContainer, setViewHolder.mContainerChild, setViewHolder.mSetHomeOfficeView, setViewHolder.mTvDestDelete, i, view, String.format("-%s_%s", "History", str), i3);
        } else if (xpSearchViewHolder instanceof SearchAdapter.SetViewHolder) {
            SearchAdapter.SetViewHolder setViewHolder2 = (SearchAdapter.SetViewHolder) xpSearchViewHolder;
            formatSetViewHolder(setViewHolder2.mTvName, setViewHolder2.mTvAddress, setViewHolder2.mContainerContent, setViewHolder2.mItemDetail, null, setViewHolder2.mSetHomeOfficeView, null, i, view, String.format("-%s_%s", "Search", str), i3);
        }
    }

    private <V extends View & VuiView> void formatSetViewHolder(XTextView xTextView, XTextView xTextView2, final V v, final V v2, final ChildPoiGridView childPoiGridView, final SetHomeOfficeView setHomeOfficeView, final XTextView xTextView3, final int i, final View view, final String str, final int i2) {
        if (xTextView == null || xTextView2 == null) {
            return;
        }
        final CharSequence text = xTextView.getText();
        final CharSequence text2 = xTextView2.getText();
        if (TextUtils.isEmpty(text) && TextUtils.isEmpty(text2)) {
            return;
        }
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchVuiHelper.4
            @Override // java.lang.Runnable
            public void run() {
                final String formatElementFatherLabelForSearch = CommonVuiHelper.getInstance().formatElementFatherLabelForSearch(i, text, text2, i2, null);
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchVuiHelper.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (v != null && v2 != null) {
                            ((VuiView) v).setVuiLabel(formatElementFatherLabelForSearch);
                            VoiceFullScenesUtil.setVuiElementTag(v2, v2.getId() + "-" + i + str);
                            ((VuiView) v2).setVuiAction(ContextUtils.getString(R.string.vui_action_click_detail));
                            ((VuiView) v2).setVuiLabel(ContextUtils.getString(R.string.vui_label_search_show_detail));
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
                        if (xTextView3 != null) {
                            xTextView3.setVuiAction(ContextUtils.getString(R.string.vui_action_click_delete));
                            VoiceFullScenesUtil.setVuiElementTag(xTextView3, xTextView3.getId() + "-" + i + str);
                        }
                        view.setTag(Integer.valueOf(i));
                    }
                });
            }
        });
    }

    private void updateSceneWithHistoryRouteHolder(final View view, XpSearchViewHolder xpSearchViewHolder, final int i, final int i2) {
        if (xpSearchViewHolder instanceof HistoryRecordAdapter.HistoryRouteHolder) {
            HistoryRecordAdapter.HistoryRouteHolder historyRouteHolder = (HistoryRecordAdapter.HistoryRouteHolder) xpSearchViewHolder;
            final SwipeMenuLayout swipeMenuLayout = historyRouteHolder.mSwipeMenuLayout;
            final XRelativeLayout xRelativeLayout = historyRouteHolder.mContainerHistoryRoute;
            HistoryRouteView historyRouteView = historyRouteHolder.mHistoryRouteView;
            XTextView xTextView = historyRouteHolder.mDeleteText;
            final StringBuilder sb = new StringBuilder();
            CharSequence text = historyRouteView.getTvDestName().getText();
            CharSequence text2 = historyRouteView.getTvVia1Name().getText();
            CharSequence text3 = historyRouteView.getTvVia2Name().getText();
            CharSequence text4 = historyRouteView.getTvVia3Name().getText();
            if (TextUtils.isEmpty(text) && TextUtils.isEmpty(text2) && TextUtils.isEmpty(text3) && TextUtils.isEmpty(text4)) {
                return;
            }
            if (!TextUtils.isEmpty(text)) {
                sb.append(text.toString());
                sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
            }
            if (!TextUtils.isEmpty(text2)) {
                sb.append(text2.toString());
                sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
            }
            if (!TextUtils.isEmpty(text3)) {
                sb.append(text3.toString());
                sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
            }
            if (!TextUtils.isEmpty(text4)) {
                sb.append(text4.toString());
                sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            xRelativeLayout.setVuiLabel(ContextUtils.getString(R.string.vui_label_search_goto));
            xRelativeLayout.setVuiAction(ContextUtils.getString(R.string.vui_action_click_select_navi));
            VoiceFullScenesUtil.setVuiElementTag(xRelativeLayout, xRelativeLayout.getId() + "-" + i + "-history_route");
            xRelativeLayout.setVuiProps(formatHistoryRouteVuiNavInfo(xpSearchViewHolder.getPoiInfo(i), historyRouteView.getRecordInfo()));
            xTextView.setVuiAction(ContextUtils.getString(R.string.vui_action_click_delete));
            VoiceFullScenesUtil.setVuiElementTag(xTextView, xTextView.getId() + "-" + i + "-history_route");
            WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchVuiHelper.5
                @Override // java.lang.Runnable
                public void run() {
                    CommonVuiHelper.getInstance().setVuiLabel(swipeMenuLayout, CommonVuiHelper.getInstance().formatElementFatherLabelForSearch(i, null, null, i2, null), sb.toString());
                    CommonVuiHelper.getInstance().setExecElement(swipeMenuLayout, xRelativeLayout.getVuiElementId());
                    view.setTag(Integer.valueOf(i));
                }
            });
        }
    }

    private JSONObject formatHistoryRouteVuiNavInfo(XPPoiInfo xPPoiInfo, HistoryRecordInfo historyRecordInfo) {
        return CommonVuiHelper.getInstance().formatNavElement(xPPoiInfo, historyRecordInfo != null ? historyRecordInfo.getViaPois() : null);
    }

    private void updateSceneWithKeywordViewHolder(final View view, XpSearchViewHolder xpSearchViewHolder, final int i, final int i2) {
        if (xpSearchViewHolder instanceof HistoryRecordAdapter.KeywordViewHolder) {
            HistoryRecordAdapter.KeywordViewHolder keywordViewHolder = (HistoryRecordAdapter.KeywordViewHolder) xpSearchViewHolder;
            final SwipeMenuLayout swipeMenuLayout = keywordViewHolder.mSwipeMenuLayout;
            final XRelativeLayout xRelativeLayout = keywordViewHolder.mKeywordParent;
            final XTextView xTextView = keywordViewHolder.mDeleteText;
            final CharSequence text = keywordViewHolder.mKeywordText.getText();
            if (TextUtils.isEmpty(text)) {
                return;
            }
            WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchVuiHelper.6
                @Override // java.lang.Runnable
                public void run() {
                    final String formatElementFatherLabelForSearch = CommonVuiHelper.getInstance().formatElementFatherLabelForSearch(i, text, null, i2, null);
                    UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchVuiHelper.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            swipeMenuLayout.setVuiLabel(formatElementFatherLabelForSearch);
                            xRelativeLayout.setVuiLabel(ContextUtils.getString(R.string.vui_label_search_item_history_search));
                            VoiceFullScenesUtil.setVuiElementTag(xRelativeLayout, xRelativeLayout.getId() + "-" + i + r7);
                            xTextView.setVuiAction(ContextUtils.getString(R.string.vui_action_click_delete));
                            VoiceFullScenesUtil.setVuiElementTag(xTextView, xTextView.getId() + "-" + i + r7);
                            CommonVuiHelper.getInstance().setExecElement(swipeMenuLayout, xRelativeLayout.getVuiElementId());
                            view.setTag(Integer.valueOf(i));
                        }
                    });
                }
            });
        }
    }

    public void updateHomeForVui(XRelativeLayout xRelativeLayout, String str) {
        FavoriteAddress home = FavoriteDataManager.getInstance().getHome();
        if (home != null) {
            XPPoiInfo xPPoiInfo = home.getXPPoiInfo();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatVoiceFullScenesLog("updateHomeForVui homeInfo:" + xPPoiInfo + ",vuiSceneId:" + str));
            }
        }
    }

    public void updateOfficeForVui(XRelativeLayout xRelativeLayout, String str) {
        FavoriteAddress company = FavoriteDataManager.getInstance().getCompany();
        if (company != null) {
            XPPoiInfo xPPoiInfo = company.getXPPoiInfo();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatVoiceFullScenesLog("updateOfficeForVui officeInfo:" + xPPoiInfo + ",vuiSceneId:" + str));
            }
        }
    }
}
