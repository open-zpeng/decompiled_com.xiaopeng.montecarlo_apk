package com.autonavi.gbl.guide.model.guidecontrol;

import com.autonavi.gbl.guide.model.guidecontrol.Type;
/* loaded from: classes.dex */
public class Param {
    public CameraParam camera;
    public CommonParam common;
    public NaviPointInfo companyInfo;
    public CrossingParam crossing;
    public CruiseParam cruise;
    public Easy3dParam easy3D;
    public ElecVehicleCharge elecVehicle;
    public EmulatorParam emulator;
    public ExitParam exit;
    public NaviPointInfo homeInfo;
    public JiliAutoParam jiliAuto;
    public LaneParam lane;
    public NaviParam navi;
    public NaviCloseEventParam naviCloseEventParam;
    public NaviFacilityParam naviFacility;
    public NaviWeatherParam naviWeatherParam;
    public NetworkParam network;
    public SAPAParam sapa;
    public TMCParam tmc;
    public TollGateLaneParam tollGateLane;
    public TRParam tr;
    public TravelTraceParam travelTrace;
    public TravelVoiceParam travelVoice;
    public TravelWeatherParam travelWeather;
    public TTSPlayParam tts;
    @Type.Type1
    public int type;
    public VehicleParam vehicle;

    public Param() {
        this.type = 0;
        this.common = new CommonParam();
        this.tmc = new TMCParam();
        this.tr = new TRParam();
        this.sapa = new SAPAParam();
        this.lane = new LaneParam();
        this.cruise = new CruiseParam();
        this.navi = new NaviParam();
        this.camera = new CameraParam();
        this.exit = new ExitParam();
        this.crossing = new CrossingParam();
        this.tts = new TTSPlayParam();
        this.vehicle = new VehicleParam();
        this.network = new NetworkParam();
        this.easy3D = new Easy3dParam();
        this.emulator = new EmulatorParam();
        this.jiliAuto = new JiliAutoParam();
        this.naviWeatherParam = new NaviWeatherParam();
        this.naviCloseEventParam = new NaviCloseEventParam();
        this.homeInfo = new NaviPointInfo();
        this.companyInfo = new NaviPointInfo();
        this.tollGateLane = new TollGateLaneParam();
        this.naviFacility = new NaviFacilityParam();
        this.elecVehicle = new ElecVehicleCharge();
        this.travelVoice = new TravelVoiceParam();
        this.travelWeather = new TravelWeatherParam();
        this.travelTrace = new TravelTraceParam();
    }

    public Param(@Type.Type1 int i, CommonParam commonParam, TMCParam tMCParam, TRParam tRParam, SAPAParam sAPAParam, LaneParam laneParam, CruiseParam cruiseParam, NaviParam naviParam, CameraParam cameraParam, ExitParam exitParam, CrossingParam crossingParam, TTSPlayParam tTSPlayParam, VehicleParam vehicleParam, NetworkParam networkParam, Easy3dParam easy3dParam, EmulatorParam emulatorParam, JiliAutoParam jiliAutoParam, NaviWeatherParam naviWeatherParam, NaviCloseEventParam naviCloseEventParam, NaviPointInfo naviPointInfo, NaviPointInfo naviPointInfo2, TollGateLaneParam tollGateLaneParam, NaviFacilityParam naviFacilityParam, ElecVehicleCharge elecVehicleCharge, TravelVoiceParam travelVoiceParam, TravelWeatherParam travelWeatherParam, TravelTraceParam travelTraceParam) {
        this.type = i;
        this.common = commonParam;
        this.tmc = tMCParam;
        this.tr = tRParam;
        this.sapa = sAPAParam;
        this.lane = laneParam;
        this.cruise = cruiseParam;
        this.navi = naviParam;
        this.camera = cameraParam;
        this.exit = exitParam;
        this.crossing = crossingParam;
        this.tts = tTSPlayParam;
        this.vehicle = vehicleParam;
        this.network = networkParam;
        this.easy3D = easy3dParam;
        this.emulator = emulatorParam;
        this.jiliAuto = jiliAutoParam;
        this.naviWeatherParam = naviWeatherParam;
        this.naviCloseEventParam = naviCloseEventParam;
        this.homeInfo = naviPointInfo;
        this.companyInfo = naviPointInfo2;
        this.tollGateLane = tollGateLaneParam;
        this.naviFacility = naviFacilityParam;
        this.elecVehicle = elecVehicleCharge;
        this.travelVoice = travelVoiceParam;
        this.travelWeather = travelWeatherParam;
        this.travelTrace = travelTraceParam;
    }
}
