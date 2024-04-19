package com.xiaopeng.montecarlo;

import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.scenes.activatescene.ActivateFragment;
import com.xiaopeng.montecarlo.scenes.activatescene.ActivateScenePresenter;
import com.xiaopeng.montecarlo.scenes.activatescene.IActivateContract;
import com.xiaopeng.montecarlo.scenes.cruisescene.CruiseFragment;
import com.xiaopeng.montecarlo.scenes.cruisescene.CruiseScenePresenter;
import com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract;
import com.xiaopeng.montecarlo.scenes.debugscene.DebugFragment;
import com.xiaopeng.montecarlo.scenes.downloadscene.MapDownloadFragment;
import com.xiaopeng.montecarlo.scenes.downloadscene.MapDownloadPresenter;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkSeamlessNaviContract;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.LinkPlatformFragment;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.LinkPlatformPresent;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.LinkSeamlessNaviFragment;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.LinkSeamlessNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreFragment;
import com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreScenePresenter;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter;
import com.xiaopeng.montecarlo.scenes.popdialogscene.IPopDialogContract;
import com.xiaopeng.montecarlo.scenes.popdialogscene.PopDialogFragment;
import com.xiaopeng.montecarlo.scenes.popdialogscene.PopDialogPresenter;
import com.xiaopeng.montecarlo.scenes.restrictscene.IRestrictContract;
import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictFragment;
import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictLandFragment;
import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictScenePresenter;
import com.xiaopeng.montecarlo.scenes.routescene.RouteFragment;
import com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter;
import com.xiaopeng.montecarlo.scenes.scanscene.ScanSearchFragment;
import com.xiaopeng.montecarlo.scenes.scanscene.ScanSearchPresenter;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchPresenter;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchResultPresenter;
import com.xiaopeng.montecarlo.scenes.setcarlogo.ISetCarLogoContract;
import com.xiaopeng.montecarlo.scenes.setcarlogo.SetCarLogoFragment;
import com.xiaopeng.montecarlo.scenes.setcarlogo.SetCarLogoPresenter;
import com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract;
import com.xiaopeng.montecarlo.scenes.settingscene.ISettingLicencePlateContract;
import com.xiaopeng.montecarlo.scenes.settingscene.SettingFragment;
import com.xiaopeng.montecarlo.scenes.settingscene.SettingLicencePlateFragment;
import com.xiaopeng.montecarlo.scenes.settingscene.SettingLicencePlatePresenter;
import com.xiaopeng.montecarlo.scenes.settingscene.SettingPreferencePresenter;
import com.xiaopeng.montecarlo.util.Utils;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class ScenesFactory {
    public static BaseScene createScene(StatusConst.Mode mode) {
        if (mode == StatusConst.Mode.SEARCH || mode == StatusConst.Mode.SET_HOME_OFFICE) {
            SearchFragment newInstance = SearchFragment.newInstance();
            newInstance.setContentViewID(R.id.layer_scene);
            new SearchPresenter(newInstance);
            return newInstance;
        } else if (mode == StatusConst.Mode.SEARCH_RESULT) {
            SearchResultFragment newInstance2 = SearchResultFragment.newInstance();
            newInstance2.setContentViewID(R.id.layer_scene);
            new SearchResultPresenter(newInstance2);
            return newInstance2;
        } else if (mode == StatusConst.Mode.ROUTE) {
            RouteFragment newInstance3 = RouteFragment.newInstance();
            newInstance3.setContentViewID(R.id.layer_scene);
            new RouteScenePresenter(newInstance3);
            return newInstance3;
        } else if (mode == StatusConst.Mode.NAVI) {
            NaviFragment newInstance4 = NaviFragment.newInstance();
            newInstance4.setContentViewID(R.id.layer_scene);
            new NaviScenePresenter(newInstance4);
            return newInstance4;
        } else if (mode == StatusConst.Mode.DEBUG) {
            DebugFragment newInstance5 = DebugFragment.newInstance();
            newInstance5.setContentViewID(R.id.layer_scene);
            return newInstance5;
        } else if (mode == StatusConst.Mode.SETTING) {
            BaseScene newInstance6 = SettingFragment.newInstance();
            newInstance6.setContentViewID(R.id.layer_scene);
            new SettingPreferencePresenter((ISettingContract.LogicView) newInstance6);
            return newInstance6;
        } else if (mode == StatusConst.Mode.SETTING_LICENCE_PLATE) {
            BaseScene newInstance7 = SettingLicencePlateFragment.newInstance();
            newInstance7.setContentViewID(R.id.layer_scene);
            new SettingLicencePlatePresenter((ISettingLicencePlateContract.LogicView) newInstance7);
            return newInstance7;
        } else if (mode == StatusConst.Mode.SETTING_MAP_DOWNLOAD) {
            MapDownloadFragment newInstance8 = MapDownloadFragment.newInstance();
            newInstance8.setContentViewID(R.id.layer_scene);
            new MapDownloadPresenter(newInstance8);
            return newInstance8;
        } else if (mode == StatusConst.Mode.SCAN_SEARCH) {
            ScanSearchFragment newInstance9 = ScanSearchFragment.newInstance();
            newInstance9.setContentViewID(R.id.layer_scene);
            new ScanSearchPresenter(newInstance9);
            return newInstance9;
        } else if (mode == StatusConst.Mode.EXPLORE) {
            ExploreFragment newInstance10 = ExploreFragment.newInstance();
            newInstance10.setContentViewID(R.id.layer_scene);
            new ExploreScenePresenter(newInstance10);
            return newInstance10;
        } else if (mode == StatusConst.Mode.RESTRICT) {
            BaseScene newInstance11 = Utils.isLandscape() ? RestrictLandFragment.newInstance() : RestrictFragment.newInstance();
            newInstance11.setContentViewID(R.id.layer_scene);
            new RestrictScenePresenter((IRestrictContract.LogicView) newInstance11);
            return newInstance11;
        } else if (mode == StatusConst.Mode.CRUISE) {
            BaseScene newInstance12 = CruiseFragment.newInstance();
            newInstance12.setContentViewID(R.id.layer_scene);
            new CruiseScenePresenter((ICruiseContract.LogicView) newInstance12);
            return newInstance12;
        } else if (mode == StatusConst.Mode.LINK_SEAMLESS_NAVI) {
            BaseScene newInstance13 = LinkSeamlessNaviFragment.newInstance();
            newInstance13.setContentViewID(R.id.layer_scene);
            new LinkSeamlessNaviPresenter((ILinkSeamlessNaviContract.LogicView) newInstance13);
            return newInstance13;
        } else if (mode == StatusConst.Mode.LINK_PLATFORM) {
            BaseScene newInstance14 = LinkPlatformFragment.newInstance();
            newInstance14.setContentViewID(R.id.layer_scene);
            new LinkPlatformPresent((ILinkPlatformContract.LogicView) newInstance14);
            return newInstance14;
        } else if (mode == StatusConst.Mode.POPDIALOG) {
            BaseScene newInstance15 = PopDialogFragment.newInstance();
            newInstance15.setContentViewID(R.id.layer_scene);
            new PopDialogPresenter((IPopDialogContract.LogicView) newInstance15);
            return newInstance15;
        } else if (mode == StatusConst.Mode.ACTIVATE) {
            BaseScene newInstance16 = ActivateFragment.newInstance();
            newInstance16.setContentViewID(R.id.layer_scene);
            new ActivateScenePresenter((IActivateContract.LogicView) newInstance16);
            return newInstance16;
        } else if (mode == StatusConst.Mode.SET_CAR_LOGO) {
            BaseScene newInstance17 = SetCarLogoFragment.newInstance();
            newInstance17.setContentViewID(R.id.layer_scene);
            new SetCarLogoPresenter((ISetCarLogoContract.LogicView) newInstance17);
            return newInstance17;
        } else {
            throw new InvalidParameterException("unknown type");
        }
    }
}
