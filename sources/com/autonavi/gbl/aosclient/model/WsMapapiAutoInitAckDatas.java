package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsMapapiAutoInitAckDatas implements Serializable {
    public WsMapapiAutoInitAckDatasViceCommon config_file;
    public WsMapapiAutoInitAckDatasFeedBack feedback_tag;
    public WsMapapiAutoInitAckDatasGlobalDB global_db;
    public WsMapapiAutoInitAckDatasViceCommon route_file;
    public WsMapapiAutoInitAckDatasTbtFile tbt_file;
    public WsMapapiAutoInitAckDatasViceCommon voice_auto_mit_common;
    public WsMapapiAutoInitAckDatasViceCommon voice_common;

    public WsMapapiAutoInitAckDatas() {
        this.global_db = new WsMapapiAutoInitAckDatasGlobalDB();
        this.tbt_file = new WsMapapiAutoInitAckDatasTbtFile();
        this.voice_common = new WsMapapiAutoInitAckDatasViceCommon();
        this.route_file = new WsMapapiAutoInitAckDatasViceCommon();
        this.config_file = new WsMapapiAutoInitAckDatasViceCommon();
        this.feedback_tag = new WsMapapiAutoInitAckDatasFeedBack();
        this.voice_auto_mit_common = new WsMapapiAutoInitAckDatasViceCommon();
    }

    public WsMapapiAutoInitAckDatas(WsMapapiAutoInitAckDatasGlobalDB wsMapapiAutoInitAckDatasGlobalDB, WsMapapiAutoInitAckDatasTbtFile wsMapapiAutoInitAckDatasTbtFile, WsMapapiAutoInitAckDatasViceCommon wsMapapiAutoInitAckDatasViceCommon, WsMapapiAutoInitAckDatasViceCommon wsMapapiAutoInitAckDatasViceCommon2, WsMapapiAutoInitAckDatasViceCommon wsMapapiAutoInitAckDatasViceCommon3, WsMapapiAutoInitAckDatasFeedBack wsMapapiAutoInitAckDatasFeedBack, WsMapapiAutoInitAckDatasViceCommon wsMapapiAutoInitAckDatasViceCommon4) {
        this.global_db = wsMapapiAutoInitAckDatasGlobalDB;
        this.tbt_file = wsMapapiAutoInitAckDatasTbtFile;
        this.voice_common = wsMapapiAutoInitAckDatasViceCommon;
        this.route_file = wsMapapiAutoInitAckDatasViceCommon2;
        this.config_file = wsMapapiAutoInitAckDatasViceCommon3;
        this.feedback_tag = wsMapapiAutoInitAckDatasFeedBack;
        this.voice_auto_mit_common = wsMapapiAutoInitAckDatasViceCommon4;
    }
}
