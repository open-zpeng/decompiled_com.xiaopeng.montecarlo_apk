package com.autonavi.gbl.aosclient;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.impl.IBLAosServiceImpl;
import com.autonavi.gbl.aosclient.model.BLAosCookie;
import com.autonavi.gbl.aosclient.model.CEtaRequestRequestParam;
import com.autonavi.gbl.aosclient.model.GAddressPredictRequestParam;
import com.autonavi.gbl.aosclient.model.GCancelSignPayRequestParam;
import com.autonavi.gbl.aosclient.model.GCarLtdBindRequestParam;
import com.autonavi.gbl.aosclient.model.GCarLtdCheckTokenRequestParam;
import com.autonavi.gbl.aosclient.model.GCarLtdQuickLoginRequestParam;
import com.autonavi.gbl.aosclient.model.GCarLtdQuickRegisterRequestParam;
import com.autonavi.gbl.aosclient.model.GCarLtdUnbindRequestParam;
import com.autonavi.gbl.aosclient.model.GCouponrecvapplyRequestParam;
import com.autonavi.gbl.aosclient.model.GCouponrecvlistRequestParam;
import com.autonavi.gbl.aosclient.model.GDriveReportSmsRequestParam;
import com.autonavi.gbl.aosclient.model.GDriveReportUploadRequestParam;
import com.autonavi.gbl.aosclient.model.GFeedbackReportRequestParam;
import com.autonavi.gbl.aosclient.model.GGasstationcalpriceRequestParam;
import com.autonavi.gbl.aosclient.model.GHolidayListRequestParam;
import com.autonavi.gbl.aosclient.model.GHttpGetPostRequestParam;
import com.autonavi.gbl.aosclient.model.GImGetAppuidRequestParam;
import com.autonavi.gbl.aosclient.model.GImGetLoginTokenRequestParam;
import com.autonavi.gbl.aosclient.model.GLbpEventSyncCommonRequestParam;
import com.autonavi.gbl.aosclient.model.GLogUploadRequestParam;
import com.autonavi.gbl.aosclient.model.GMojiWeatherRequestParam;
import com.autonavi.gbl.aosclient.model.GNavigationEtaqueryRequestParam;
import com.autonavi.gbl.aosclient.model.GParkOrderCreateRequestParam;
import com.autonavi.gbl.aosclient.model.GParkOrderDetailRequestParam;
import com.autonavi.gbl.aosclient.model.GParkOrderListRequestParam;
import com.autonavi.gbl.aosclient.model.GParkPayStatusRequestParam;
import com.autonavi.gbl.aosclient.model.GParkServiceRequestParam;
import com.autonavi.gbl.aosclient.model.GPaymentBindAlipayRequestParam;
import com.autonavi.gbl.aosclient.model.GPaymentStatusRequestParam;
import com.autonavi.gbl.aosclient.model.GPaymentUnbindAlipayRequestParam;
import com.autonavi.gbl.aosclient.model.GQRCodeConfirmRequestParam;
import com.autonavi.gbl.aosclient.model.GQueryCarMsgRequestParam;
import com.autonavi.gbl.aosclient.model.GQueryPersentWeatherRequestParam;
import com.autonavi.gbl.aosclient.model.GQueryWeatherByLinkRequestParam;
import com.autonavi.gbl.aosclient.model.GQuerybylinksRequestParam;
import com.autonavi.gbl.aosclient.model.GRangeSpiderRequestParam;
import com.autonavi.gbl.aosclient.model.GReStrictedAreaRequestParam;
import com.autonavi.gbl.aosclient.model.GSendToPhoneRequestParam;
import com.autonavi.gbl.aosclient.model.GServerTimestampRequestParam;
import com.autonavi.gbl.aosclient.model.GTrafficEventCommentRequestParam;
import com.autonavi.gbl.aosclient.model.GTrafficEventDetailRequestParam;
import com.autonavi.gbl.aosclient.model.GTrafficRestrictRequestParam;
import com.autonavi.gbl.aosclient.model.GTripodCompanyRequestParam;
import com.autonavi.gbl.aosclient.model.GUserDeviceRequestParam;
import com.autonavi.gbl.aosclient.model.GWorkdayListRequestParam;
import com.autonavi.gbl.aosclient.model.GWsAosDestinationSearchRequestParam;
import com.autonavi.gbl.aosclient.model.GWsAppConfAppUpdateRequestParam;
import com.autonavi.gbl.aosclient.model.GWsArchiveTrafficeventUpdateRequestParam;
import com.autonavi.gbl.aosclient.model.GWsAudiHcp3EventSearchRequestParam;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServiceEnableRequestParam;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServiceProvisionRequestParam;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServicelistRequestParam;
import com.autonavi.gbl.aosclient.model.GWsAuthcarTokenRequestParam;
import com.autonavi.gbl.aosclient.model.GWsAutoCollectRequestParam;
import com.autonavi.gbl.aosclient.model.GWsCloudUploadRequestParam;
import com.autonavi.gbl.aosclient.model.GWsCommerceInfraChargeRecordsWaitingEnableRequestParam;
import com.autonavi.gbl.aosclient.model.GWsDeviceAdiusRequestParam;
import com.autonavi.gbl.aosclient.model.GWsFeedbackReviewGetRequestParam;
import com.autonavi.gbl.aosclient.model.GWsFeedbackReviewReportRequestParam;
import com.autonavi.gbl.aosclient.model.GWsHcp3ChargeListRequestParam;
import com.autonavi.gbl.aosclient.model.GWsIcsLifeCouponOptionsRequestParam;
import com.autonavi.gbl.aosclient.model.GWsIcsLifeUserCouponListRequestParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiAutoInitRequestParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiAutoSwitchRequestParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiBenzLinkidsRequestParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiBenzRoadRequestParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiConfOfflineRequestParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiGeoCodeRequestParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiPoiCodepointRequestParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiPoiVoicesearchRequestParam;
import com.autonavi.gbl.aosclient.model.GWsNavigationDynamicDataRequestParam;
import com.autonavi.gbl.aosclient.model.GWsNavigationDynamicFatigueRequestParam;
import com.autonavi.gbl.aosclient.model.GWsNtg6SdsFilesRequestParam;
import com.autonavi.gbl.aosclient.model.GWsOssMaplayerListRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpAccountDeactivateHelpRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpAccountDeactivateRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpAccountProfileUpdateRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpAutoWeixinQrcodeRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpAutoWeixinStatusRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpAutoWeixinUnbindRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpCarltdCheckbindRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpCarltdLogin4bindRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpContactBindMobileRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpContactUnbindMobileRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpQrcodeUrlTranslateRequestParam;
import com.autonavi.gbl.aosclient.model.GWsShieldAsbpApiUploadRequestParam;
import com.autonavi.gbl.aosclient.model.GWsShieldNavigationRoutepathrestorationRequestParam;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchMainPageRecRequestParam;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistCityRequestParam;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistLandingRequestParam;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistPortalRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcCommonAgreementStatusRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcFuelCancelRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcFuelCreateRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcFuelGetwaitingpayordersRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcFuelQueryagreementRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcOrderDetailRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcOrderListRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceInternalLinkAutoReportRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceInternalLinkCarGetRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceInternalLinkCarReportRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotDeviceListRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotDeviceRelieveRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodEventRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodSnAutoBindForceRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodSnAutoBindRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodSnAutoBoundRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodStatusRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceRequestIpRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamCreateRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamDismissRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamInfoGetRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamInfoUpdateRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamInviteRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamJoinRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamKickRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamQrRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamQuitRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamUserFriendsRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamUserStatusRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamUserTnnUpdateRequestParam;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintNaviDeleteRequestParam;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintNaviRecordRequestParam;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintSummaryRequestParam;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintSwitchRequestParam;
import com.autonavi.gbl.aosclient.model.GWsVaCarLogoExchangeRequestParam;
import com.autonavi.gbl.aosclient.model.GWsVaCarLogoRequestParam;
import com.autonavi.gbl.aosclient.model.GWsVaCarLogoSelectRequestParam;
import com.autonavi.gbl.aosclient.observer.ICallBackAddressPredict;
import com.autonavi.gbl.aosclient.observer.ICallBackCancelSignPay;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdBind;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdCheckToken;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdQuickLogin;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdQuickRegister;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdUnbind;
import com.autonavi.gbl.aosclient.observer.ICallBackCouponrecvapply;
import com.autonavi.gbl.aosclient.observer.ICallBackCouponrecvlist;
import com.autonavi.gbl.aosclient.observer.ICallBackDriveReportSms;
import com.autonavi.gbl.aosclient.observer.ICallBackDriveReportUpload;
import com.autonavi.gbl.aosclient.observer.ICallBackEtaRequest;
import com.autonavi.gbl.aosclient.observer.ICallBackFeedbackReport;
import com.autonavi.gbl.aosclient.observer.ICallBackGasstationcalprice;
import com.autonavi.gbl.aosclient.observer.ICallBackHolidayList;
import com.autonavi.gbl.aosclient.observer.ICallBackHttpGetPost;
import com.autonavi.gbl.aosclient.observer.ICallBackImGetAppuid;
import com.autonavi.gbl.aosclient.observer.ICallBackImGetLoginToken;
import com.autonavi.gbl.aosclient.observer.ICallBackLbpEventSyncCommon;
import com.autonavi.gbl.aosclient.observer.ICallBackLogUpload;
import com.autonavi.gbl.aosclient.observer.ICallBackMojiWeather;
import com.autonavi.gbl.aosclient.observer.ICallBackNavigationEtaquery;
import com.autonavi.gbl.aosclient.observer.ICallBackParkOrderCreate;
import com.autonavi.gbl.aosclient.observer.ICallBackParkOrderDetail;
import com.autonavi.gbl.aosclient.observer.ICallBackParkOrderList;
import com.autonavi.gbl.aosclient.observer.ICallBackParkPayStatus;
import com.autonavi.gbl.aosclient.observer.ICallBackParkService;
import com.autonavi.gbl.aosclient.observer.ICallBackPaymentBindAlipay;
import com.autonavi.gbl.aosclient.observer.ICallBackPaymentStatus;
import com.autonavi.gbl.aosclient.observer.ICallBackPaymentUnbindAlipay;
import com.autonavi.gbl.aosclient.observer.ICallBackQRCodeConfirm;
import com.autonavi.gbl.aosclient.observer.ICallBackQueryCarMsg;
import com.autonavi.gbl.aosclient.observer.ICallBackQueryPersentWeather;
import com.autonavi.gbl.aosclient.observer.ICallBackQueryWeatherByLink;
import com.autonavi.gbl.aosclient.observer.ICallBackQuerybylinks;
import com.autonavi.gbl.aosclient.observer.ICallBackRangeSpider;
import com.autonavi.gbl.aosclient.observer.ICallBackReStrictedArea;
import com.autonavi.gbl.aosclient.observer.ICallBackSendToPhone;
import com.autonavi.gbl.aosclient.observer.ICallBackServerTimestamp;
import com.autonavi.gbl.aosclient.observer.ICallBackTrafficEventComment;
import com.autonavi.gbl.aosclient.observer.ICallBackTrafficEventDetail;
import com.autonavi.gbl.aosclient.observer.ICallBackTrafficRestrict;
import com.autonavi.gbl.aosclient.observer.ICallBackTripodCompany;
import com.autonavi.gbl.aosclient.observer.ICallBackUserDevice;
import com.autonavi.gbl.aosclient.observer.ICallBackWorkdayList;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAosDestinationSearch;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAppConfAppUpdate;
import com.autonavi.gbl.aosclient.observer.ICallBackWsArchiveTrafficeventUpdate;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAudiHcp3EventSearch;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAuthcarServiceEnable;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAuthcarServiceProvision;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAuthcarServicelist;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAuthcarToken;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAutoCollect;
import com.autonavi.gbl.aosclient.observer.ICallBackWsCloudUpload;
import com.autonavi.gbl.aosclient.observer.ICallBackWsCommerceInfraChargeRecordsWaitingEnable;
import com.autonavi.gbl.aosclient.observer.ICallBackWsDeviceAdius;
import com.autonavi.gbl.aosclient.observer.ICallBackWsFeedbackReviewGet;
import com.autonavi.gbl.aosclient.observer.ICallBackWsFeedbackReviewReport;
import com.autonavi.gbl.aosclient.observer.ICallBackWsHcp3ChargeList;
import com.autonavi.gbl.aosclient.observer.ICallBackWsIcsLifeCouponOptions;
import com.autonavi.gbl.aosclient.observer.ICallBackWsIcsLifeUserCouponList;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiAutoInit;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiAutoSwitch;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiBenzLinkids;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiBenzRoad;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiConfOffline;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiGeoCode;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiPoiCodepoint;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiPoiVoicesearch;
import com.autonavi.gbl.aosclient.observer.ICallBackWsNavigationDynamicData;
import com.autonavi.gbl.aosclient.observer.ICallBackWsNavigationDynamicFatigue;
import com.autonavi.gbl.aosclient.observer.ICallBackWsNtg6SdsFiles;
import com.autonavi.gbl.aosclient.observer.ICallBackWsOssMaplayerList;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAccountDeactivate;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAccountDeactivateHelp;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAccountProfileUpdate;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAutoWeixinQrcode;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAutoWeixinStatus;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAutoWeixinUnbind;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpCarltdCheckbind;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpCarltdLogin4bind;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpContactBindMobile;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpContactUnbindMobile;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpQrcodeUrlTranslate;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldAsbpApiUpload;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldNavigationRoutepathrestoration;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldSearchMainPageRec;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldSearchRanklistCity;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldSearchRanklistLanding;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldSearchRanklistPortal;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcCommonAgreementStatus;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcFuelCancel;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcFuelCreate;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcFuelGetwaitingpayorders;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcFuelQueryagreement;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcOrderDetail;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcOrderList;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceInternalLinkAutoReport;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceInternalLinkCarGet;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceInternalLinkCarReport;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceIotDeviceList;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceIotDeviceRelieve;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceIotTripodEvent;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceIotTripodSnAutoBind;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceIotTripodSnAutoBindForce;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceIotTripodSnAutoBound;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceIotTripodStatus;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceRequestIp;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamCreate;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamDismiss;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamInfoGet;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamInfoUpdate;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamInvite;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamJoin;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamKick;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamQr;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamQuit;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamUserFriends;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamUserStatus;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamUserTnnUpdate;
import com.autonavi.gbl.aosclient.observer.ICallBackWsUserviewFootprintNaviDelete;
import com.autonavi.gbl.aosclient.observer.ICallBackWsUserviewFootprintNaviRecord;
import com.autonavi.gbl.aosclient.observer.ICallBackWsUserviewFootprintSummary;
import com.autonavi.gbl.aosclient.observer.ICallBackWsUserviewFootprintSwitch;
import com.autonavi.gbl.aosclient.observer.ICallBackWsVaCarLogo;
import com.autonavi.gbl.aosclient.observer.ICallBackWsVaCarLogoExchange;
import com.autonavi.gbl.aosclient.observer.ICallBackWsVaCarLogoSelect;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackAddressPredictImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCancelSignPayImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdBindImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdCheckTokenImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdQuickLoginImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdQuickRegisterImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdUnbindImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCouponrecvapplyImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCouponrecvlistImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackDriveReportSmsImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackDriveReportUploadImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackEtaRequestImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackFeedbackReportImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackGasstationcalpriceImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackHolidayListImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackHttpGetPostImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackImGetAppuidImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackImGetLoginTokenImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackLbpEventSyncCommonImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackLogUploadImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackMojiWeatherImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackNavigationEtaqueryImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackParkOrderCreateImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackParkOrderDetailImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackParkOrderListImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackParkPayStatusImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackParkServiceImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackPaymentBindAlipayImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackPaymentStatusImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackPaymentUnbindAlipayImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackQRCodeConfirmImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackQueryCarMsgImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackQueryPersentWeatherImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackQueryWeatherByLinkImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackQuerybylinksImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackRangeSpiderImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackReStrictedAreaImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackSendToPhoneImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackServerTimestampImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackTrafficEventCommentImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackTrafficEventDetailImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackTrafficRestrictImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackTripodCompanyImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackUserDeviceImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWorkdayListImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAosDestinationSearchImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAppConfAppUpdateImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsArchiveTrafficeventUpdateImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAudiHcp3EventSearchImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarServiceEnableImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarServiceProvisionImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarServicelistImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarTokenImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAutoCollectImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsCloudUploadImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsCommerceInfraChargeRecordsWaitingEnableImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDeviceAdiusImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFeedbackReviewGetImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFeedbackReviewReportImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsHcp3ChargeListImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsIcsLifeCouponOptionsImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsIcsLifeUserCouponListImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiAutoInitImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiAutoSwitchImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiBenzLinkidsImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiBenzRoadImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiConfOfflineImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiGeoCodeImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiPoiCodepointImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiPoiVoicesearchImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsNavigationDynamicDataImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsNavigationDynamicFatigueImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsNtg6SdsFilesImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsOssMaplayerListImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAccountDeactivateHelpImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAccountDeactivateImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAccountProfileUpdateImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAutoWeixinQrcodeImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAutoWeixinStatusImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAutoWeixinUnbindImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpCarltdCheckbindImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpCarltdLogin4bindImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpContactBindMobileImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpContactUnbindMobileImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpQrcodeUrlTranslateImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldAsbpApiUploadImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldNavigationRoutepathrestorationImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchMainPageRecImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchRanklistCityImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchRanklistLandingImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchRanklistPortalImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCommonAgreementStatusImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelCancelImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelCreateImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelGetwaitingpayordersImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelQueryagreementImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcOrderDetailImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcOrderListImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceInternalLinkAutoReportImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceInternalLinkCarGetImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceInternalLinkCarReportImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotDeviceListImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotDeviceRelieveImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodEventImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodSnAutoBindForceImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodSnAutoBindImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodSnAutoBoundImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodStatusImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceRequestIpImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamCreateImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamDismissImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamInfoGetImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamInfoUpdateImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamInviteImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamJoinImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamKickImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamQrImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamQuitImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamUserFriendsImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamUserStatusImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamUserTnnUpdateImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsUserviewFootprintNaviDeleteImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsUserviewFootprintNaviRecordImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsUserviewFootprintSummaryImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsUserviewFootprintSwitchImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsVaCarLogoExchangeImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsVaCarLogoImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsVaCarLogoSelectImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
@IntfAuto(target = IBLAosServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BLAosService implements IService {
    private static String PACKAGE = ReflexTool.PN(BLAosService.class);
    private IBLAosServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BLAosService(long j, boolean z) {
        this((IBLAosServiceImpl) ReflexTool.invokeDeclConstructorSafe(IBLAosServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BLAosService.class, this, this.mControl);
        }
    }

    public BLAosService() {
        this(new IBLAosServiceImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BLAosService.class, this, this.mControl);
        }
    }

    public BLAosService(IBLAosServiceImpl iBLAosServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBLAosServiceImpl);
    }

    private void $constructor(IBLAosServiceImpl iBLAosServiceImpl) {
        if (iBLAosServiceImpl != null) {
            this.mControl = iBLAosServiceImpl;
            this.mTargetId = String.format("BLAosService_%s_%d", String.valueOf(IBLAosServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IBLAosServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
        if (iBLAosServiceImpl != null) {
            return iBLAosServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
        if (iBLAosServiceImpl != null) {
            return iBLAosServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
        if (iBLAosServiceImpl != null) {
            iBLAosServiceImpl.onCreate();
        }
    }

    public void unInit() {
        IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
        if (iBLAosServiceImpl != null) {
            iBLAosServiceImpl.unInit();
        }
    }

    public String getVersion() {
        IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
        if (iBLAosServiceImpl != null) {
            return iBLAosServiceImpl.getVersion();
        }
        return null;
    }

    public void logSwitch(int i) {
        IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
        if (iBLAosServiceImpl != null) {
            iBLAosServiceImpl.logSwitch(i);
        }
    }

    public int getServiceID() {
        IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
        if (iBLAosServiceImpl != null) {
            return iBLAosServiceImpl.getServiceID();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
        if (iBLAosServiceImpl != null) {
            return iBLAosServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public BLAosCookie getCookie() {
        IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
        if (iBLAosServiceImpl != null) {
            return iBLAosServiceImpl.getCookie();
        }
        return null;
    }

    public boolean setCookie(BLAosCookie bLAosCookie) {
        IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
        if (iBLAosServiceImpl != null) {
            return iBLAosServiceImpl.setCookie(bLAosCookie);
        }
        return false;
    }

    public int abortRequest(long j) {
        IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
        if (iBLAosServiceImpl != null) {
            return iBLAosServiceImpl.abortRequest(j);
        }
        return 0;
    }

    public long sendReqNavigationEtaquery(GNavigationEtaqueryRequestParam gNavigationEtaqueryRequestParam, ICallBackNavigationEtaquery iCallBackNavigationEtaquery) {
        try {
            Method method = BLAosService.class.getMethod("sendReqNavigationEtaquery", GNavigationEtaqueryRequestParam.class, ICallBackNavigationEtaquery.class);
            if (iCallBackNavigationEtaquery != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackNavigationEtaqueryImpl) typeHelper.transfer(method, 1, iCallBackNavigationEtaquery) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.1
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqNavigationEtaquery(gNavigationEtaqueryRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqRangeSpider(GRangeSpiderRequestParam gRangeSpiderRequestParam, ICallBackRangeSpider iCallBackRangeSpider) {
        try {
            Method method = BLAosService.class.getMethod("sendReqRangeSpider", GRangeSpiderRequestParam.class, ICallBackRangeSpider.class);
            if (iCallBackRangeSpider != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackRangeSpiderImpl) typeHelper.transfer(method, 1, iCallBackRangeSpider) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.2
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqRangeSpider(gRangeSpiderRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqQueryWeatherByLink(GQueryWeatherByLinkRequestParam gQueryWeatherByLinkRequestParam, ICallBackQueryWeatherByLink iCallBackQueryWeatherByLink) {
        try {
            Method method = BLAosService.class.getMethod("sendReqQueryWeatherByLink", GQueryWeatherByLinkRequestParam.class, ICallBackQueryWeatherByLink.class);
            if (iCallBackQueryWeatherByLink != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackQueryWeatherByLinkImpl) typeHelper.transfer(method, 1, iCallBackQueryWeatherByLink) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.3
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqQueryWeatherByLink(gQueryWeatherByLinkRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqQueryPersentWeather(GQueryPersentWeatherRequestParam gQueryPersentWeatherRequestParam, ICallBackQueryPersentWeather iCallBackQueryPersentWeather) {
        try {
            Method method = BLAosService.class.getMethod("sendReqQueryPersentWeather", GQueryPersentWeatherRequestParam.class, ICallBackQueryPersentWeather.class);
            if (iCallBackQueryPersentWeather != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackQueryPersentWeatherImpl) typeHelper.transfer(method, 1, iCallBackQueryPersentWeather) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.4
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqQueryPersentWeather(gQueryPersentWeatherRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqEtaRequestRequest(CEtaRequestRequestParam cEtaRequestRequestParam, ICallBackEtaRequest iCallBackEtaRequest) {
        try {
            Method method = BLAosService.class.getMethod("sendReqEtaRequestRequest", CEtaRequestRequestParam.class, ICallBackEtaRequest.class);
            if (iCallBackEtaRequest != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackEtaRequestImpl) typeHelper.transfer(method, 1, iCallBackEtaRequest) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.5
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqEtaRequestRequest(cEtaRequestRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqAddressPredict(GAddressPredictRequestParam gAddressPredictRequestParam, ICallBackAddressPredict iCallBackAddressPredict) {
        try {
            Method method = BLAosService.class.getMethod("sendReqAddressPredict", GAddressPredictRequestParam.class, ICallBackAddressPredict.class);
            if (iCallBackAddressPredict != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackAddressPredictImpl) typeHelper.transfer(method, 1, iCallBackAddressPredict) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.6
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqAddressPredict(gAddressPredictRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqHolidayList(GHolidayListRequestParam gHolidayListRequestParam, ICallBackHolidayList iCallBackHolidayList) {
        try {
            Method method = BLAosService.class.getMethod("sendReqHolidayList", GHolidayListRequestParam.class, ICallBackHolidayList.class);
            if (iCallBackHolidayList != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackHolidayListImpl) typeHelper.transfer(method, 1, iCallBackHolidayList) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.7
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqHolidayList(gHolidayListRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqMojiWeather(GMojiWeatherRequestParam gMojiWeatherRequestParam, ICallBackMojiWeather iCallBackMojiWeather) {
        try {
            Method method = BLAosService.class.getMethod("sendReqMojiWeather", GMojiWeatherRequestParam.class, ICallBackMojiWeather.class);
            if (iCallBackMojiWeather != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackMojiWeatherImpl) typeHelper.transfer(method, 1, iCallBackMojiWeather) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.8
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqMojiWeather(gMojiWeatherRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqReStrictedArea(GReStrictedAreaRequestParam gReStrictedAreaRequestParam, ICallBackReStrictedArea iCallBackReStrictedArea) {
        try {
            Method method = BLAosService.class.getMethod("sendReqReStrictedArea", GReStrictedAreaRequestParam.class, ICallBackReStrictedArea.class);
            if (iCallBackReStrictedArea != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackReStrictedAreaImpl) typeHelper.transfer(method, 1, iCallBackReStrictedArea) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.9
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqReStrictedArea(gReStrictedAreaRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWorkdayList(GWorkdayListRequestParam gWorkdayListRequestParam, ICallBackWorkdayList iCallBackWorkdayList) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWorkdayList", GWorkdayListRequestParam.class, ICallBackWorkdayList.class);
            if (iCallBackWorkdayList != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWorkdayListImpl) typeHelper.transfer(method, 1, iCallBackWorkdayList) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.10
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWorkdayList(gWorkdayListRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsMapapiPoiVoicesearch(GWsMapapiPoiVoicesearchRequestParam gWsMapapiPoiVoicesearchRequestParam, ICallBackWsMapapiPoiVoicesearch iCallBackWsMapapiPoiVoicesearch) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsMapapiPoiVoicesearch", GWsMapapiPoiVoicesearchRequestParam.class, ICallBackWsMapapiPoiVoicesearch.class);
            if (iCallBackWsMapapiPoiVoicesearch != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsMapapiPoiVoicesearchImpl) typeHelper.transfer(method, 1, iCallBackWsMapapiPoiVoicesearch) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.11
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsMapapiPoiVoicesearch(gWsMapapiPoiVoicesearchRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsMapapiPoiCodepoint(GWsMapapiPoiCodepointRequestParam gWsMapapiPoiCodepointRequestParam, ICallBackWsMapapiPoiCodepoint iCallBackWsMapapiPoiCodepoint) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsMapapiPoiCodepoint", GWsMapapiPoiCodepointRequestParam.class, ICallBackWsMapapiPoiCodepoint.class);
            if (iCallBackWsMapapiPoiCodepoint != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsMapapiPoiCodepointImpl) typeHelper.transfer(method, 1, iCallBackWsMapapiPoiCodepoint) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.12
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsMapapiPoiCodepoint(gWsMapapiPoiCodepointRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsAppConfAppUpdate(GWsAppConfAppUpdateRequestParam gWsAppConfAppUpdateRequestParam, ICallBackWsAppConfAppUpdate iCallBackWsAppConfAppUpdate) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsAppConfAppUpdate", GWsAppConfAppUpdateRequestParam.class, ICallBackWsAppConfAppUpdate.class);
            if (iCallBackWsAppConfAppUpdate != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsAppConfAppUpdateImpl) typeHelper.transfer(method, 1, iCallBackWsAppConfAppUpdate) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.13
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsAppConfAppUpdate(gWsAppConfAppUpdateRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsMapapiGeoCode(GWsMapapiGeoCodeRequestParam gWsMapapiGeoCodeRequestParam, ICallBackWsMapapiGeoCode iCallBackWsMapapiGeoCode) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsMapapiGeoCode", GWsMapapiGeoCodeRequestParam.class, ICallBackWsMapapiGeoCode.class);
            if (iCallBackWsMapapiGeoCode != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsMapapiGeoCodeImpl) typeHelper.transfer(method, 1, iCallBackWsMapapiGeoCode) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.14
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsMapapiGeoCode(gWsMapapiGeoCodeRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsMapapiAutoSwitch(GWsMapapiAutoSwitchRequestParam gWsMapapiAutoSwitchRequestParam, ICallBackWsMapapiAutoSwitch iCallBackWsMapapiAutoSwitch) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsMapapiAutoSwitch", GWsMapapiAutoSwitchRequestParam.class, ICallBackWsMapapiAutoSwitch.class);
            if (iCallBackWsMapapiAutoSwitch != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsMapapiAutoSwitchImpl) typeHelper.transfer(method, 1, iCallBackWsMapapiAutoSwitch) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.15
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsMapapiAutoSwitch(gWsMapapiAutoSwitchRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqCancelSignPay(GCancelSignPayRequestParam gCancelSignPayRequestParam, ICallBackCancelSignPay iCallBackCancelSignPay) {
        try {
            Method method = BLAosService.class.getMethod("sendReqCancelSignPay", GCancelSignPayRequestParam.class, ICallBackCancelSignPay.class);
            if (iCallBackCancelSignPay != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackCancelSignPayImpl) typeHelper.transfer(method, 1, iCallBackCancelSignPay) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.16
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqCancelSignPay(gCancelSignPayRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqFeedbackReport(GFeedbackReportRequestParam gFeedbackReportRequestParam, ICallBackFeedbackReport iCallBackFeedbackReport) {
        try {
            Method method = BLAosService.class.getMethod("sendReqFeedbackReport", GFeedbackReportRequestParam.class, ICallBackFeedbackReport.class);
            if (iCallBackFeedbackReport != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackFeedbackReportImpl) typeHelper.transfer(method, 1, iCallBackFeedbackReport) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.17
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqFeedbackReport(gFeedbackReportRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqParkService(GParkServiceRequestParam gParkServiceRequestParam, ICallBackParkService iCallBackParkService) {
        try {
            Method method = BLAosService.class.getMethod("sendReqParkService", GParkServiceRequestParam.class, ICallBackParkService.class);
            if (iCallBackParkService != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackParkServiceImpl) typeHelper.transfer(method, 1, iCallBackParkService) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.18
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqParkService(gParkServiceRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqParkOrderCreate(GParkOrderCreateRequestParam gParkOrderCreateRequestParam, ICallBackParkOrderCreate iCallBackParkOrderCreate) {
        try {
            Method method = BLAosService.class.getMethod("sendReqParkOrderCreate", GParkOrderCreateRequestParam.class, ICallBackParkOrderCreate.class);
            if (iCallBackParkOrderCreate != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackParkOrderCreateImpl) typeHelper.transfer(method, 1, iCallBackParkOrderCreate) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.19
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqParkOrderCreate(gParkOrderCreateRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqParkOrderDetail(GParkOrderDetailRequestParam gParkOrderDetailRequestParam, ICallBackParkOrderDetail iCallBackParkOrderDetail) {
        try {
            Method method = BLAosService.class.getMethod("sendReqParkOrderDetail", GParkOrderDetailRequestParam.class, ICallBackParkOrderDetail.class);
            if (iCallBackParkOrderDetail != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackParkOrderDetailImpl) typeHelper.transfer(method, 1, iCallBackParkOrderDetail) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.20
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqParkOrderDetail(gParkOrderDetailRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqParkOrderList(GParkOrderListRequestParam gParkOrderListRequestParam, ICallBackParkOrderList iCallBackParkOrderList) {
        try {
            Method method = BLAosService.class.getMethod("sendReqParkOrderList", GParkOrderListRequestParam.class, ICallBackParkOrderList.class);
            if (iCallBackParkOrderList != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackParkOrderListImpl) typeHelper.transfer(method, 1, iCallBackParkOrderList) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.21
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqParkOrderList(gParkOrderListRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqParkPayStatus(GParkPayStatusRequestParam gParkPayStatusRequestParam, ICallBackParkPayStatus iCallBackParkPayStatus) {
        try {
            Method method = BLAosService.class.getMethod("sendReqParkPayStatus", GParkPayStatusRequestParam.class, ICallBackParkPayStatus.class);
            if (iCallBackParkPayStatus != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackParkPayStatusImpl) typeHelper.transfer(method, 1, iCallBackParkPayStatus) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.22
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqParkPayStatus(gParkPayStatusRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqTrafficEventComment(GTrafficEventCommentRequestParam gTrafficEventCommentRequestParam, ICallBackTrafficEventComment iCallBackTrafficEventComment) {
        try {
            Method method = BLAosService.class.getMethod("sendReqTrafficEventComment", GTrafficEventCommentRequestParam.class, ICallBackTrafficEventComment.class);
            if (iCallBackTrafficEventComment != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackTrafficEventCommentImpl) typeHelper.transfer(method, 1, iCallBackTrafficEventComment) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.23
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqTrafficEventComment(gTrafficEventCommentRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqTrafficEventDetail(GTrafficEventDetailRequestParam gTrafficEventDetailRequestParam, ICallBackTrafficEventDetail iCallBackTrafficEventDetail) {
        try {
            Method method = BLAosService.class.getMethod("sendReqTrafficEventDetail", GTrafficEventDetailRequestParam.class, ICallBackTrafficEventDetail.class);
            if (iCallBackTrafficEventDetail != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackTrafficEventDetailImpl) typeHelper.transfer(method, 1, iCallBackTrafficEventDetail) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.24
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqTrafficEventDetail(gTrafficEventDetailRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqUserDevice(GUserDeviceRequestParam gUserDeviceRequestParam, ICallBackUserDevice iCallBackUserDevice) {
        try {
            Method method = BLAosService.class.getMethod("sendReqUserDevice", GUserDeviceRequestParam.class, ICallBackUserDevice.class);
            if (iCallBackUserDevice != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackUserDeviceImpl) typeHelper.transfer(method, 1, iCallBackUserDevice) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.25
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqUserDevice(gUserDeviceRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqQRCodeConfirm(GQRCodeConfirmRequestParam gQRCodeConfirmRequestParam, ICallBackQRCodeConfirm iCallBackQRCodeConfirm) {
        try {
            Method method = BLAosService.class.getMethod("sendReqQRCodeConfirm", GQRCodeConfirmRequestParam.class, ICallBackQRCodeConfirm.class);
            if (iCallBackQRCodeConfirm != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackQRCodeConfirmImpl) typeHelper.transfer(method, 1, iCallBackQRCodeConfirm) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.26
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqQRCodeConfirm(gQRCodeConfirmRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsArchiveTrafficeventUpdate(GWsArchiveTrafficeventUpdateRequestParam gWsArchiveTrafficeventUpdateRequestParam, ICallBackWsArchiveTrafficeventUpdate iCallBackWsArchiveTrafficeventUpdate) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsArchiveTrafficeventUpdate", GWsArchiveTrafficeventUpdateRequestParam.class, ICallBackWsArchiveTrafficeventUpdate.class);
            if (iCallBackWsArchiveTrafficeventUpdate != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsArchiveTrafficeventUpdateImpl) typeHelper.transfer(method, 1, iCallBackWsArchiveTrafficeventUpdate) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.27
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsArchiveTrafficeventUpdate(gWsArchiveTrafficeventUpdateRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpAccountProfileUpdate(GWsPpAccountProfileUpdateRequestParam gWsPpAccountProfileUpdateRequestParam, ICallBackWsPpAccountProfileUpdate iCallBackWsPpAccountProfileUpdate) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpAccountProfileUpdate", GWsPpAccountProfileUpdateRequestParam.class, ICallBackWsPpAccountProfileUpdate.class);
            if (iCallBackWsPpAccountProfileUpdate != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsPpAccountProfileUpdateImpl) typeHelper.transfer(method, 1, iCallBackWsPpAccountProfileUpdate) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.28
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpAccountProfileUpdate(gWsPpAccountProfileUpdateRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqCarLtdBind(GCarLtdBindRequestParam gCarLtdBindRequestParam, ICallBackCarLtdBind iCallBackCarLtdBind) {
        try {
            Method method = BLAosService.class.getMethod("sendReqCarLtdBind", GCarLtdBindRequestParam.class, ICallBackCarLtdBind.class);
            if (iCallBackCarLtdBind != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackCarLtdBindImpl) typeHelper.transfer(method, 1, iCallBackCarLtdBind) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.29
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqCarLtdBind(gCarLtdBindRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqCarLtdUnbind(GCarLtdUnbindRequestParam gCarLtdUnbindRequestParam, ICallBackCarLtdUnbind iCallBackCarLtdUnbind) {
        try {
            Method method = BLAosService.class.getMethod("sendReqCarLtdUnbind", GCarLtdUnbindRequestParam.class, ICallBackCarLtdUnbind.class);
            if (iCallBackCarLtdUnbind != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackCarLtdUnbindImpl) typeHelper.transfer(method, 1, iCallBackCarLtdUnbind) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.30
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqCarLtdUnbind(gCarLtdUnbindRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqCarLtdCheckToken(GCarLtdCheckTokenRequestParam gCarLtdCheckTokenRequestParam, ICallBackCarLtdCheckToken iCallBackCarLtdCheckToken) {
        try {
            Method method = BLAosService.class.getMethod("sendReqCarLtdCheckToken", GCarLtdCheckTokenRequestParam.class, ICallBackCarLtdCheckToken.class);
            if (iCallBackCarLtdCheckToken != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackCarLtdCheckTokenImpl) typeHelper.transfer(method, 1, iCallBackCarLtdCheckToken) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.31
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqCarLtdCheckToken(gCarLtdCheckTokenRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqCarLtdQuickLogin(GCarLtdQuickLoginRequestParam gCarLtdQuickLoginRequestParam, ICallBackCarLtdQuickLogin iCallBackCarLtdQuickLogin) {
        try {
            Method method = BLAosService.class.getMethod("sendReqCarLtdQuickLogin", GCarLtdQuickLoginRequestParam.class, ICallBackCarLtdQuickLogin.class);
            if (iCallBackCarLtdQuickLogin != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackCarLtdQuickLoginImpl) typeHelper.transfer(method, 1, iCallBackCarLtdQuickLogin) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.32
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqCarLtdQuickLogin(gCarLtdQuickLoginRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqCarLtdQuickRegister(GCarLtdQuickRegisterRequestParam gCarLtdQuickRegisterRequestParam, ICallBackCarLtdQuickRegister iCallBackCarLtdQuickRegister) {
        try {
            Method method = BLAosService.class.getMethod("sendReqCarLtdQuickRegister", GCarLtdQuickRegisterRequestParam.class, ICallBackCarLtdQuickRegister.class);
            if (iCallBackCarLtdQuickRegister != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackCarLtdQuickRegisterImpl) typeHelper.transfer(method, 1, iCallBackCarLtdQuickRegister) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.33
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqCarLtdQuickRegister(gCarLtdQuickRegisterRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqPaymentBindAlipay(GPaymentBindAlipayRequestParam gPaymentBindAlipayRequestParam, ICallBackPaymentBindAlipay iCallBackPaymentBindAlipay) {
        try {
            Method method = BLAosService.class.getMethod("sendReqPaymentBindAlipay", GPaymentBindAlipayRequestParam.class, ICallBackPaymentBindAlipay.class);
            if (iCallBackPaymentBindAlipay != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackPaymentBindAlipayImpl) typeHelper.transfer(method, 1, iCallBackPaymentBindAlipay) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.34
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqPaymentBindAlipay(gPaymentBindAlipayRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqPaymentStatus(GPaymentStatusRequestParam gPaymentStatusRequestParam, ICallBackPaymentStatus iCallBackPaymentStatus) {
        try {
            Method method = BLAosService.class.getMethod("sendReqPaymentStatus", GPaymentStatusRequestParam.class, ICallBackPaymentStatus.class);
            if (iCallBackPaymentStatus != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackPaymentStatusImpl) typeHelper.transfer(method, 1, iCallBackPaymentStatus) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.35
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqPaymentStatus(gPaymentStatusRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqPaymentUnbindAlipay(GPaymentUnbindAlipayRequestParam gPaymentUnbindAlipayRequestParam, ICallBackPaymentUnbindAlipay iCallBackPaymentUnbindAlipay) {
        try {
            Method method = BLAosService.class.getMethod("sendReqPaymentUnbindAlipay", GPaymentUnbindAlipayRequestParam.class, ICallBackPaymentUnbindAlipay.class);
            if (iCallBackPaymentUnbindAlipay != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackPaymentUnbindAlipayImpl) typeHelper.transfer(method, 1, iCallBackPaymentUnbindAlipay) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.36
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqPaymentUnbindAlipay(gPaymentUnbindAlipayRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpAutoWeixinQrcode(GWsPpAutoWeixinQrcodeRequestParam gWsPpAutoWeixinQrcodeRequestParam, ICallBackWsPpAutoWeixinQrcode iCallBackWsPpAutoWeixinQrcode) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpAutoWeixinQrcode", GWsPpAutoWeixinQrcodeRequestParam.class, ICallBackWsPpAutoWeixinQrcode.class);
            if (iCallBackWsPpAutoWeixinQrcode != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsPpAutoWeixinQrcodeImpl) typeHelper.transfer(method, 1, iCallBackWsPpAutoWeixinQrcode) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.37
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpAutoWeixinQrcode(gWsPpAutoWeixinQrcodeRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpAutoWeixinUnbind(GWsPpAutoWeixinUnbindRequestParam gWsPpAutoWeixinUnbindRequestParam, ICallBackWsPpAutoWeixinUnbind iCallBackWsPpAutoWeixinUnbind) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpAutoWeixinUnbind", GWsPpAutoWeixinUnbindRequestParam.class, ICallBackWsPpAutoWeixinUnbind.class);
            if (iCallBackWsPpAutoWeixinUnbind != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsPpAutoWeixinUnbindImpl) typeHelper.transfer(method, 1, iCallBackWsPpAutoWeixinUnbind) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.38
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpAutoWeixinUnbind(gWsPpAutoWeixinUnbindRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpAutoWeixinStatus(GWsPpAutoWeixinStatusRequestParam gWsPpAutoWeixinStatusRequestParam, ICallBackWsPpAutoWeixinStatus iCallBackWsPpAutoWeixinStatus) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpAutoWeixinStatus", GWsPpAutoWeixinStatusRequestParam.class, ICallBackWsPpAutoWeixinStatus.class);
            if (iCallBackWsPpAutoWeixinStatus != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsPpAutoWeixinStatusImpl) typeHelper.transfer(method, 1, iCallBackWsPpAutoWeixinStatus) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.39
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpAutoWeixinStatus(gWsPpAutoWeixinStatusRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpQrcodeUrlTranslate(GWsPpQrcodeUrlTranslateRequestParam gWsPpQrcodeUrlTranslateRequestParam, ICallBackWsPpQrcodeUrlTranslate iCallBackWsPpQrcodeUrlTranslate) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpQrcodeUrlTranslate", GWsPpQrcodeUrlTranslateRequestParam.class, ICallBackWsPpQrcodeUrlTranslate.class);
            if (iCallBackWsPpQrcodeUrlTranslate != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsPpQrcodeUrlTranslateImpl) typeHelper.transfer(method, 1, iCallBackWsPpQrcodeUrlTranslate) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.40
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpQrcodeUrlTranslate(gWsPpQrcodeUrlTranslateRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpCarltdCheckbind(GWsPpCarltdCheckbindRequestParam gWsPpCarltdCheckbindRequestParam, ICallBackWsPpCarltdCheckbind iCallBackWsPpCarltdCheckbind) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpCarltdCheckbind", GWsPpCarltdCheckbindRequestParam.class, ICallBackWsPpCarltdCheckbind.class);
            if (iCallBackWsPpCarltdCheckbind != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsPpCarltdCheckbindImpl) typeHelper.transfer(method, 1, iCallBackWsPpCarltdCheckbind) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.41
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpCarltdCheckbind(gWsPpCarltdCheckbindRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqDriveReportSms(GDriveReportSmsRequestParam gDriveReportSmsRequestParam, ICallBackDriveReportSms iCallBackDriveReportSms) {
        try {
            Method method = BLAosService.class.getMethod("sendReqDriveReportSms", GDriveReportSmsRequestParam.class, ICallBackDriveReportSms.class);
            if (iCallBackDriveReportSms != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackDriveReportSmsImpl) typeHelper.transfer(method, 1, iCallBackDriveReportSms) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.42
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqDriveReportSms(gDriveReportSmsRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqTrafficRestrict(GTrafficRestrictRequestParam gTrafficRestrictRequestParam, ICallBackTrafficRestrict iCallBackTrafficRestrict) {
        try {
            Method method = BLAosService.class.getMethod("sendReqTrafficRestrict", GTrafficRestrictRequestParam.class, ICallBackTrafficRestrict.class);
            if (iCallBackTrafficRestrict != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackTrafficRestrictImpl) typeHelper.transfer(method, 1, iCallBackTrafficRestrict) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.43
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqTrafficRestrict(gTrafficRestrictRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqDriveReport(GDriveReportUploadRequestParam gDriveReportUploadRequestParam, ICallBackDriveReportUpload iCallBackDriveReportUpload) {
        try {
            Method method = BLAosService.class.getMethod("sendReqDriveReport", GDriveReportUploadRequestParam.class, ICallBackDriveReportUpload.class);
            if (iCallBackDriveReportUpload != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackDriveReportUploadImpl) typeHelper.transfer(method, 1, iCallBackDriveReportUpload) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.44
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqDriveReport(gDriveReportUploadRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqLogUpload(GLogUploadRequestParam gLogUploadRequestParam, ICallBackLogUpload iCallBackLogUpload) {
        try {
            Method method = BLAosService.class.getMethod("sendReqLogUpload", GLogUploadRequestParam.class, ICallBackLogUpload.class);
            if (iCallBackLogUpload != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackLogUploadImpl) typeHelper.transfer(method, 1, iCallBackLogUpload) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.45
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqLogUpload(gLogUploadRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqQueryCarMsg(GQueryCarMsgRequestParam gQueryCarMsgRequestParam, ICallBackQueryCarMsg iCallBackQueryCarMsg) {
        try {
            Method method = BLAosService.class.getMethod("sendReqQueryCarMsg", GQueryCarMsgRequestParam.class, ICallBackQueryCarMsg.class);
            if (iCallBackQueryCarMsg != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackQueryCarMsgImpl) typeHelper.transfer(method, 1, iCallBackQueryCarMsg) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.46
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqQueryCarMsg(gQueryCarMsgRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqSendToPhone(GSendToPhoneRequestParam gSendToPhoneRequestParam, ICallBackSendToPhone iCallBackSendToPhone) {
        try {
            Method method = BLAosService.class.getMethod("sendReqSendToPhone", GSendToPhoneRequestParam.class, ICallBackSendToPhone.class);
            if (iCallBackSendToPhone != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackSendToPhoneImpl) typeHelper.transfer(method, 1, iCallBackSendToPhone) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.47
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqSendToPhone(gSendToPhoneRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamCreate(GWsTserviceTeamCreateRequestParam gWsTserviceTeamCreateRequestParam, ICallBackWsTserviceTeamCreate iCallBackWsTserviceTeamCreate) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamCreate", GWsTserviceTeamCreateRequestParam.class, ICallBackWsTserviceTeamCreate.class);
            if (iCallBackWsTserviceTeamCreate != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceTeamCreateImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamCreate) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.48
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamCreate(gWsTserviceTeamCreateRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamUserStatus(GWsTserviceTeamUserStatusRequestParam gWsTserviceTeamUserStatusRequestParam, ICallBackWsTserviceTeamUserStatus iCallBackWsTserviceTeamUserStatus) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamUserStatus", GWsTserviceTeamUserStatusRequestParam.class, ICallBackWsTserviceTeamUserStatus.class);
            if (iCallBackWsTserviceTeamUserStatus != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceTeamUserStatusImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamUserStatus) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.49
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamUserStatus(gWsTserviceTeamUserStatusRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamJoin(GWsTserviceTeamJoinRequestParam gWsTserviceTeamJoinRequestParam, ICallBackWsTserviceTeamJoin iCallBackWsTserviceTeamJoin) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamJoin", GWsTserviceTeamJoinRequestParam.class, ICallBackWsTserviceTeamJoin.class);
            if (iCallBackWsTserviceTeamJoin != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceTeamJoinImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamJoin) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.50
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamJoin(gWsTserviceTeamJoinRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamUserFriends(GWsTserviceTeamUserFriendsRequestParam gWsTserviceTeamUserFriendsRequestParam, ICallBackWsTserviceTeamUserFriends iCallBackWsTserviceTeamUserFriends) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamUserFriends", GWsTserviceTeamUserFriendsRequestParam.class, ICallBackWsTserviceTeamUserFriends.class);
            if (iCallBackWsTserviceTeamUserFriends != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceTeamUserFriendsImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamUserFriends) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.51
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamUserFriends(gWsTserviceTeamUserFriendsRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamQr(GWsTserviceTeamQrRequestParam gWsTserviceTeamQrRequestParam, ICallBackWsTserviceTeamQr iCallBackWsTserviceTeamQr) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamQr", GWsTserviceTeamQrRequestParam.class, ICallBackWsTserviceTeamQr.class);
            if (iCallBackWsTserviceTeamQr != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceTeamQrImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamQr) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.52
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamQr(gWsTserviceTeamQrRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamInvite(GWsTserviceTeamInviteRequestParam gWsTserviceTeamInviteRequestParam, ICallBackWsTserviceTeamInvite iCallBackWsTserviceTeamInvite) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamInvite", GWsTserviceTeamInviteRequestParam.class, ICallBackWsTserviceTeamInvite.class);
            if (iCallBackWsTserviceTeamInvite != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceTeamInviteImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamInvite) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.53
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamInvite(gWsTserviceTeamInviteRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamInfoGet(GWsTserviceTeamInfoGetRequestParam gWsTserviceTeamInfoGetRequestParam, ICallBackWsTserviceTeamInfoGet iCallBackWsTserviceTeamInfoGet) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamInfoGet", GWsTserviceTeamInfoGetRequestParam.class, ICallBackWsTserviceTeamInfoGet.class);
            if (iCallBackWsTserviceTeamInfoGet != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceTeamInfoGetImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamInfoGet) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.54
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamInfoGet(gWsTserviceTeamInfoGetRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamKick(GWsTserviceTeamKickRequestParam gWsTserviceTeamKickRequestParam, ICallBackWsTserviceTeamKick iCallBackWsTserviceTeamKick) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamKick", GWsTserviceTeamKickRequestParam.class, ICallBackWsTserviceTeamKick.class);
            if (iCallBackWsTserviceTeamKick != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceTeamKickImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamKick) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.55
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamKick(gWsTserviceTeamKickRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamQuit(GWsTserviceTeamQuitRequestParam gWsTserviceTeamQuitRequestParam, ICallBackWsTserviceTeamQuit iCallBackWsTserviceTeamQuit) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamQuit", GWsTserviceTeamQuitRequestParam.class, ICallBackWsTserviceTeamQuit.class);
            if (iCallBackWsTserviceTeamQuit != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceTeamQuitImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamQuit) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.56
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamQuit(gWsTserviceTeamQuitRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamDismiss(GWsTserviceTeamDismissRequestParam gWsTserviceTeamDismissRequestParam, ICallBackWsTserviceTeamDismiss iCallBackWsTserviceTeamDismiss) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamDismiss", GWsTserviceTeamDismissRequestParam.class, ICallBackWsTserviceTeamDismiss.class);
            if (iCallBackWsTserviceTeamDismiss != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceTeamDismissImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamDismiss) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.57
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamDismiss(gWsTserviceTeamDismissRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamInfoUpdate(GWsTserviceTeamInfoUpdateRequestParam gWsTserviceTeamInfoUpdateRequestParam, ICallBackWsTserviceTeamInfoUpdate iCallBackWsTserviceTeamInfoUpdate) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamInfoUpdate", GWsTserviceTeamInfoUpdateRequestParam.class, ICallBackWsTserviceTeamInfoUpdate.class);
            if (iCallBackWsTserviceTeamInfoUpdate != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceTeamInfoUpdateImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamInfoUpdate) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.58
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamInfoUpdate(gWsTserviceTeamInfoUpdateRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamUserTnnUpdate(GWsTserviceTeamUserTnnUpdateRequestParam gWsTserviceTeamUserTnnUpdateRequestParam, ICallBackWsTserviceTeamUserTnnUpdate iCallBackWsTserviceTeamUserTnnUpdate) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamUserTnnUpdate", GWsTserviceTeamUserTnnUpdateRequestParam.class, ICallBackWsTserviceTeamUserTnnUpdate.class);
            if (iCallBackWsTserviceTeamUserTnnUpdate != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceTeamUserTnnUpdateImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamUserTnnUpdate) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.59
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamUserTnnUpdate(gWsTserviceTeamUserTnnUpdateRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsDeviceAdius(GWsDeviceAdiusRequestParam gWsDeviceAdiusRequestParam, ICallBackWsDeviceAdius iCallBackWsDeviceAdius) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsDeviceAdius", GWsDeviceAdiusRequestParam.class, ICallBackWsDeviceAdius.class);
            if (iCallBackWsDeviceAdius != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsDeviceAdiusImpl) typeHelper.transfer(method, 1, iCallBackWsDeviceAdius) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.60
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsDeviceAdius(gWsDeviceAdiusRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqHttpGetPost(GHttpGetPostRequestParam gHttpGetPostRequestParam, ICallBackHttpGetPost iCallBackHttpGetPost) {
        try {
            Method method = BLAosService.class.getMethod("sendReqHttpGetPost", GHttpGetPostRequestParam.class, ICallBackHttpGetPost.class);
            if (iCallBackHttpGetPost != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackHttpGetPostImpl) typeHelper.transfer(method, 1, iCallBackHttpGetPost) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.61
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqHttpGetPost(gHttpGetPostRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsOssMaplayerList(GWsOssMaplayerListRequestParam gWsOssMaplayerListRequestParam, ICallBackWsOssMaplayerList iCallBackWsOssMaplayerList) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsOssMaplayerList", GWsOssMaplayerListRequestParam.class, ICallBackWsOssMaplayerList.class);
            if (iCallBackWsOssMaplayerList != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsOssMaplayerListImpl) typeHelper.transfer(method, 1, iCallBackWsOssMaplayerList) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.62
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsOssMaplayerList(gWsOssMaplayerListRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsShieldNavigationRoutepathrestoration(GWsShieldNavigationRoutepathrestorationRequestParam gWsShieldNavigationRoutepathrestorationRequestParam, ICallBackWsShieldNavigationRoutepathrestoration iCallBackWsShieldNavigationRoutepathrestoration) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsShieldNavigationRoutepathrestoration", GWsShieldNavigationRoutepathrestorationRequestParam.class, ICallBackWsShieldNavigationRoutepathrestoration.class);
            if (iCallBackWsShieldNavigationRoutepathrestoration != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsShieldNavigationRoutepathrestorationImpl) typeHelper.transfer(method, 1, iCallBackWsShieldNavigationRoutepathrestoration) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.63
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsShieldNavigationRoutepathrestoration(gWsShieldNavigationRoutepathrestorationRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsVaCarLogo(GWsVaCarLogoRequestParam gWsVaCarLogoRequestParam, ICallBackWsVaCarLogo iCallBackWsVaCarLogo) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsVaCarLogo", GWsVaCarLogoRequestParam.class, ICallBackWsVaCarLogo.class);
            if (iCallBackWsVaCarLogo != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsVaCarLogoImpl) typeHelper.transfer(method, 1, iCallBackWsVaCarLogo) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.64
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsVaCarLogo(gWsVaCarLogoRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsVaCarLogoExchange(GWsVaCarLogoExchangeRequestParam gWsVaCarLogoExchangeRequestParam, ICallBackWsVaCarLogoExchange iCallBackWsVaCarLogoExchange) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsVaCarLogoExchange", GWsVaCarLogoExchangeRequestParam.class, ICallBackWsVaCarLogoExchange.class);
            if (iCallBackWsVaCarLogoExchange != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsVaCarLogoExchangeImpl) typeHelper.transfer(method, 1, iCallBackWsVaCarLogoExchange) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.65
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsVaCarLogoExchange(gWsVaCarLogoExchangeRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsVaCarLogoSelect(GWsVaCarLogoSelectRequestParam gWsVaCarLogoSelectRequestParam, ICallBackWsVaCarLogoSelect iCallBackWsVaCarLogoSelect) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsVaCarLogoSelect", GWsVaCarLogoSelectRequestParam.class, ICallBackWsVaCarLogoSelect.class);
            if (iCallBackWsVaCarLogoSelect != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsVaCarLogoSelectImpl) typeHelper.transfer(method, 1, iCallBackWsVaCarLogoSelect) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.66
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsVaCarLogoSelect(gWsVaCarLogoSelectRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsAuthcarServiceProvision(GWsAuthcarServiceProvisionRequestParam gWsAuthcarServiceProvisionRequestParam, ICallBackWsAuthcarServiceProvision iCallBackWsAuthcarServiceProvision) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsAuthcarServiceProvision", GWsAuthcarServiceProvisionRequestParam.class, ICallBackWsAuthcarServiceProvision.class);
            if (iCallBackWsAuthcarServiceProvision != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsAuthcarServiceProvisionImpl) typeHelper.transfer(method, 1, iCallBackWsAuthcarServiceProvision) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.67
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsAuthcarServiceProvision(gWsAuthcarServiceProvisionRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsAuthcarServicelist(GWsAuthcarServicelistRequestParam gWsAuthcarServicelistRequestParam, ICallBackWsAuthcarServicelist iCallBackWsAuthcarServicelist) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsAuthcarServicelist", GWsAuthcarServicelistRequestParam.class, ICallBackWsAuthcarServicelist.class);
            if (iCallBackWsAuthcarServicelist != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsAuthcarServicelistImpl) typeHelper.transfer(method, 1, iCallBackWsAuthcarServicelist) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.68
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsAuthcarServicelist(gWsAuthcarServicelistRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsAuthcarToken(GWsAuthcarTokenRequestParam gWsAuthcarTokenRequestParam, ICallBackWsAuthcarToken iCallBackWsAuthcarToken) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsAuthcarToken", GWsAuthcarTokenRequestParam.class, ICallBackWsAuthcarToken.class);
            if (iCallBackWsAuthcarToken != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsAuthcarTokenImpl) typeHelper.transfer(method, 1, iCallBackWsAuthcarToken) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.69
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsAuthcarToken(gWsAuthcarTokenRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsShieldAsbpApiUpload(GWsShieldAsbpApiUploadRequestParam gWsShieldAsbpApiUploadRequestParam, ICallBackWsShieldAsbpApiUpload iCallBackWsShieldAsbpApiUpload) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsShieldAsbpApiUpload", GWsShieldAsbpApiUploadRequestParam.class, ICallBackWsShieldAsbpApiUpload.class);
            if (iCallBackWsShieldAsbpApiUpload != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsShieldAsbpApiUploadImpl) typeHelper.transfer(method, 1, iCallBackWsShieldAsbpApiUpload) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.70
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsShieldAsbpApiUpload(gWsShieldAsbpApiUploadRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsCloudUpload(GWsCloudUploadRequestParam gWsCloudUploadRequestParam, ICallBackWsCloudUpload iCallBackWsCloudUpload) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsCloudUpload", GWsCloudUploadRequestParam.class, ICallBackWsCloudUpload.class);
            if (iCallBackWsCloudUpload != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsCloudUploadImpl) typeHelper.transfer(method, 1, iCallBackWsCloudUpload) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.71
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsCloudUpload(gWsCloudUploadRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsMapapiAutoInit(GWsMapapiAutoInitRequestParam gWsMapapiAutoInitRequestParam, ICallBackWsMapapiAutoInit iCallBackWsMapapiAutoInit) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsMapapiAutoInit", GWsMapapiAutoInitRequestParam.class, ICallBackWsMapapiAutoInit.class);
            if (iCallBackWsMapapiAutoInit != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsMapapiAutoInitImpl) typeHelper.transfer(method, 1, iCallBackWsMapapiAutoInit) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.72
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsMapapiAutoInit(gWsMapapiAutoInitRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsMapapiConfOffline(GWsMapapiConfOfflineRequestParam gWsMapapiConfOfflineRequestParam, ICallBackWsMapapiConfOffline iCallBackWsMapapiConfOffline) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsMapapiConfOffline", GWsMapapiConfOfflineRequestParam.class, ICallBackWsMapapiConfOffline.class);
            if (iCallBackWsMapapiConfOffline != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsMapapiConfOfflineImpl) typeHelper.transfer(method, 1, iCallBackWsMapapiConfOffline) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.73
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsMapapiConfOffline(gWsMapapiConfOfflineRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqQuerybylinks(GQuerybylinksRequestParam gQuerybylinksRequestParam, ICallBackQuerybylinks iCallBackQuerybylinks) {
        try {
            Method method = BLAosService.class.getMethod("sendReqQuerybylinks", GQuerybylinksRequestParam.class, ICallBackQuerybylinks.class);
            if (iCallBackQuerybylinks != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackQuerybylinksImpl) typeHelper.transfer(method, 1, iCallBackQuerybylinks) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.74
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqQuerybylinks(gQuerybylinksRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpContactBindMobile(GWsPpContactBindMobileRequestParam gWsPpContactBindMobileRequestParam, ICallBackWsPpContactBindMobile iCallBackWsPpContactBindMobile) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpContactBindMobile", GWsPpContactBindMobileRequestParam.class, ICallBackWsPpContactBindMobile.class);
            if (iCallBackWsPpContactBindMobile != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsPpContactBindMobileImpl) typeHelper.transfer(method, 1, iCallBackWsPpContactBindMobile) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.75
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpContactBindMobile(gWsPpContactBindMobileRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpContactUnbindMobile(GWsPpContactUnbindMobileRequestParam gWsPpContactUnbindMobileRequestParam, ICallBackWsPpContactUnbindMobile iCallBackWsPpContactUnbindMobile) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpContactUnbindMobile", GWsPpContactUnbindMobileRequestParam.class, ICallBackWsPpContactUnbindMobile.class);
            if (iCallBackWsPpContactUnbindMobile != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsPpContactUnbindMobileImpl) typeHelper.transfer(method, 1, iCallBackWsPpContactUnbindMobile) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.76
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpContactUnbindMobile(gWsPpContactUnbindMobileRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsAutoCollect(GWsAutoCollectRequestParam gWsAutoCollectRequestParam, ICallBackWsAutoCollect iCallBackWsAutoCollect) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsAutoCollect", GWsAutoCollectRequestParam.class, ICallBackWsAutoCollect.class);
            if (iCallBackWsAutoCollect != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsAutoCollectImpl) typeHelper.transfer(method, 1, iCallBackWsAutoCollect) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.77
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsAutoCollect(gWsAutoCollectRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceIotTripodSnAutoBind(GWsTserviceIotTripodSnAutoBindRequestParam gWsTserviceIotTripodSnAutoBindRequestParam, ICallBackWsTserviceIotTripodSnAutoBind iCallBackWsTserviceIotTripodSnAutoBind) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceIotTripodSnAutoBind", GWsTserviceIotTripodSnAutoBindRequestParam.class, ICallBackWsTserviceIotTripodSnAutoBind.class);
            if (iCallBackWsTserviceIotTripodSnAutoBind != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceIotTripodSnAutoBindImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceIotTripodSnAutoBind) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.78
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceIotTripodSnAutoBind(gWsTserviceIotTripodSnAutoBindRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceIotTripodSnAutoBound(GWsTserviceIotTripodSnAutoBoundRequestParam gWsTserviceIotTripodSnAutoBoundRequestParam, ICallBackWsTserviceIotTripodSnAutoBound iCallBackWsTserviceIotTripodSnAutoBound) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceIotTripodSnAutoBound", GWsTserviceIotTripodSnAutoBoundRequestParam.class, ICallBackWsTserviceIotTripodSnAutoBound.class);
            if (iCallBackWsTserviceIotTripodSnAutoBound != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceIotTripodSnAutoBoundImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceIotTripodSnAutoBound) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.79
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceIotTripodSnAutoBound(gWsTserviceIotTripodSnAutoBoundRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceIotTripodSnAutoBindForce(GWsTserviceIotTripodSnAutoBindForceRequestParam gWsTserviceIotTripodSnAutoBindForceRequestParam, ICallBackWsTserviceIotTripodSnAutoBindForce iCallBackWsTserviceIotTripodSnAutoBindForce) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceIotTripodSnAutoBindForce", GWsTserviceIotTripodSnAutoBindForceRequestParam.class, ICallBackWsTserviceIotTripodSnAutoBindForce.class);
            if (iCallBackWsTserviceIotTripodSnAutoBindForce != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceIotTripodSnAutoBindForceImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceIotTripodSnAutoBindForce) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.80
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceIotTripodSnAutoBindForce(gWsTserviceIotTripodSnAutoBindForceRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceIotDeviceList(GWsTserviceIotDeviceListRequestParam gWsTserviceIotDeviceListRequestParam, ICallBackWsTserviceIotDeviceList iCallBackWsTserviceIotDeviceList) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceIotDeviceList", GWsTserviceIotDeviceListRequestParam.class, ICallBackWsTserviceIotDeviceList.class);
            if (iCallBackWsTserviceIotDeviceList != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceIotDeviceListImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceIotDeviceList) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.81
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceIotDeviceList(gWsTserviceIotDeviceListRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceIotDeviceRelieve(GWsTserviceIotDeviceRelieveRequestParam gWsTserviceIotDeviceRelieveRequestParam, ICallBackWsTserviceIotDeviceRelieve iCallBackWsTserviceIotDeviceRelieve) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceIotDeviceRelieve", GWsTserviceIotDeviceRelieveRequestParam.class, ICallBackWsTserviceIotDeviceRelieve.class);
            if (iCallBackWsTserviceIotDeviceRelieve != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceIotDeviceRelieveImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceIotDeviceRelieve) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.82
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceIotDeviceRelieve(gWsTserviceIotDeviceRelieveRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceIotTripodStatus(GWsTserviceIotTripodStatusRequestParam gWsTserviceIotTripodStatusRequestParam, ICallBackWsTserviceIotTripodStatus iCallBackWsTserviceIotTripodStatus) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceIotTripodStatus", GWsTserviceIotTripodStatusRequestParam.class, ICallBackWsTserviceIotTripodStatus.class);
            if (iCallBackWsTserviceIotTripodStatus != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceIotTripodStatusImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceIotTripodStatus) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.83
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceIotTripodStatus(gWsTserviceIotTripodStatusRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceIotTripodEvent(GWsTserviceIotTripodEventRequestParam gWsTserviceIotTripodEventRequestParam, ICallBackWsTserviceIotTripodEvent iCallBackWsTserviceIotTripodEvent) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceIotTripodEvent", GWsTserviceIotTripodEventRequestParam.class, ICallBackWsTserviceIotTripodEvent.class);
            if (iCallBackWsTserviceIotTripodEvent != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceIotTripodEventImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceIotTripodEvent) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.84
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceIotTripodEvent(gWsTserviceIotTripodEventRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceRequestIp(GWsTserviceRequestIpRequestParam gWsTserviceRequestIpRequestParam, ICallBackWsTserviceRequestIp iCallBackWsTserviceRequestIp) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceRequestIp", GWsTserviceRequestIpRequestParam.class, ICallBackWsTserviceRequestIp.class);
            if (iCallBackWsTserviceRequestIp != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceRequestIpImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceRequestIp) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.85
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceRequestIp(gWsTserviceRequestIpRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpCarltdLogin4bind(GWsPpCarltdLogin4bindRequestParam gWsPpCarltdLogin4bindRequestParam, ICallBackWsPpCarltdLogin4bind iCallBackWsPpCarltdLogin4bind) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpCarltdLogin4bind", GWsPpCarltdLogin4bindRequestParam.class, ICallBackWsPpCarltdLogin4bind.class);
            if (iCallBackWsPpCarltdLogin4bind != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsPpCarltdLogin4bindImpl) typeHelper.transfer(method, 1, iCallBackWsPpCarltdLogin4bind) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.86
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpCarltdLogin4bind(gWsPpCarltdLogin4bindRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsShieldSearchMainPageRec(GWsShieldSearchMainPageRecRequestParam gWsShieldSearchMainPageRecRequestParam, ICallBackWsShieldSearchMainPageRec iCallBackWsShieldSearchMainPageRec) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsShieldSearchMainPageRec", GWsShieldSearchMainPageRecRequestParam.class, ICallBackWsShieldSearchMainPageRec.class);
            if (iCallBackWsShieldSearchMainPageRec != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsShieldSearchMainPageRecImpl) typeHelper.transfer(method, 1, iCallBackWsShieldSearchMainPageRec) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.87
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsShieldSearchMainPageRec(gWsShieldSearchMainPageRecRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqTripodCompany(GTripodCompanyRequestParam gTripodCompanyRequestParam, ICallBackTripodCompany iCallBackTripodCompany) {
        try {
            Method method = BLAosService.class.getMethod("sendReqTripodCompany", GTripodCompanyRequestParam.class, ICallBackTripodCompany.class);
            if (iCallBackTripodCompany != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackTripodCompanyImpl) typeHelper.transfer(method, 1, iCallBackTripodCompany) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.88
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqTripodCompany(gTripodCompanyRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqServerTimestamp(GServerTimestampRequestParam gServerTimestampRequestParam, ICallBackServerTimestamp iCallBackServerTimestamp) {
        try {
            Method method = BLAosService.class.getMethod("sendReqServerTimestamp", GServerTimestampRequestParam.class, ICallBackServerTimestamp.class);
            if (iCallBackServerTimestamp != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackServerTimestampImpl) typeHelper.transfer(method, 1, iCallBackServerTimestamp) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.89
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqServerTimestamp(gServerTimestampRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsFeedbackReviewGet(GWsFeedbackReviewGetRequestParam gWsFeedbackReviewGetRequestParam, ICallBackWsFeedbackReviewGet iCallBackWsFeedbackReviewGet) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsFeedbackReviewGet", GWsFeedbackReviewGetRequestParam.class, ICallBackWsFeedbackReviewGet.class);
            if (iCallBackWsFeedbackReviewGet != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsFeedbackReviewGetImpl) typeHelper.transfer(method, 1, iCallBackWsFeedbackReviewGet) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.90
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsFeedbackReviewGet(gWsFeedbackReviewGetRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsFeedbackReviewReport(GWsFeedbackReviewReportRequestParam gWsFeedbackReviewReportRequestParam, ICallBackWsFeedbackReviewReport iCallBackWsFeedbackReviewReport) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsFeedbackReviewReport", GWsFeedbackReviewReportRequestParam.class, ICallBackWsFeedbackReviewReport.class);
            if (iCallBackWsFeedbackReviewReport != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsFeedbackReviewReportImpl) typeHelper.transfer(method, 1, iCallBackWsFeedbackReviewReport) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.91
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsFeedbackReviewReport(gWsFeedbackReviewReportRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsUserviewFootprintSummary(GWsUserviewFootprintSummaryRequestParam gWsUserviewFootprintSummaryRequestParam, ICallBackWsUserviewFootprintSummary iCallBackWsUserviewFootprintSummary) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsUserviewFootprintSummary", GWsUserviewFootprintSummaryRequestParam.class, ICallBackWsUserviewFootprintSummary.class);
            if (iCallBackWsUserviewFootprintSummary != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsUserviewFootprintSummaryImpl) typeHelper.transfer(method, 1, iCallBackWsUserviewFootprintSummary) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.92
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsUserviewFootprintSummary(gWsUserviewFootprintSummaryRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsUserviewFootprintSwitch(GWsUserviewFootprintSwitchRequestParam gWsUserviewFootprintSwitchRequestParam, ICallBackWsUserviewFootprintSwitch iCallBackWsUserviewFootprintSwitch) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsUserviewFootprintSwitch", GWsUserviewFootprintSwitchRequestParam.class, ICallBackWsUserviewFootprintSwitch.class);
            if (iCallBackWsUserviewFootprintSwitch != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsUserviewFootprintSwitchImpl) typeHelper.transfer(method, 1, iCallBackWsUserviewFootprintSwitch) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.93
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsUserviewFootprintSwitch(gWsUserviewFootprintSwitchRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqImGetLoginToken(GImGetLoginTokenRequestParam gImGetLoginTokenRequestParam, ICallBackImGetLoginToken iCallBackImGetLoginToken) {
        try {
            Method method = BLAosService.class.getMethod("sendReqImGetLoginToken", GImGetLoginTokenRequestParam.class, ICallBackImGetLoginToken.class);
            if (iCallBackImGetLoginToken != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackImGetLoginTokenImpl) typeHelper.transfer(method, 1, iCallBackImGetLoginToken) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.94
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqImGetLoginToken(gImGetLoginTokenRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqImGetAppuid(GImGetAppuidRequestParam gImGetAppuidRequestParam, ICallBackImGetAppuid iCallBackImGetAppuid) {
        try {
            Method method = BLAosService.class.getMethod("sendReqImGetAppuid", GImGetAppuidRequestParam.class, ICallBackImGetAppuid.class);
            if (iCallBackImGetAppuid != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackImGetAppuidImpl) typeHelper.transfer(method, 1, iCallBackImGetAppuid) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.95
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqImGetAppuid(gImGetAppuidRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceInternalLinkCarGet(GWsTserviceInternalLinkCarGetRequestParam gWsTserviceInternalLinkCarGetRequestParam, ICallBackWsTserviceInternalLinkCarGet iCallBackWsTserviceInternalLinkCarGet) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceInternalLinkCarGet", GWsTserviceInternalLinkCarGetRequestParam.class, ICallBackWsTserviceInternalLinkCarGet.class);
            if (iCallBackWsTserviceInternalLinkCarGet != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceInternalLinkCarGetImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceInternalLinkCarGet) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.96
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceInternalLinkCarGet(gWsTserviceInternalLinkCarGetRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceInternalLinkCarReport(GWsTserviceInternalLinkCarReportRequestParam gWsTserviceInternalLinkCarReportRequestParam, ICallBackWsTserviceInternalLinkCarReport iCallBackWsTserviceInternalLinkCarReport) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceInternalLinkCarReport", GWsTserviceInternalLinkCarReportRequestParam.class, ICallBackWsTserviceInternalLinkCarReport.class);
            if (iCallBackWsTserviceInternalLinkCarReport != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceInternalLinkCarReportImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceInternalLinkCarReport) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.97
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceInternalLinkCarReport(gWsTserviceInternalLinkCarReportRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpAccountDeactivateHelp(GWsPpAccountDeactivateHelpRequestParam gWsPpAccountDeactivateHelpRequestParam, ICallBackWsPpAccountDeactivateHelp iCallBackWsPpAccountDeactivateHelp) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpAccountDeactivateHelp", GWsPpAccountDeactivateHelpRequestParam.class, ICallBackWsPpAccountDeactivateHelp.class);
            if (iCallBackWsPpAccountDeactivateHelp != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsPpAccountDeactivateHelpImpl) typeHelper.transfer(method, 1, iCallBackWsPpAccountDeactivateHelp) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.98
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpAccountDeactivateHelp(gWsPpAccountDeactivateHelpRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpAccountDeactivate(GWsPpAccountDeactivateRequestParam gWsPpAccountDeactivateRequestParam, ICallBackWsPpAccountDeactivate iCallBackWsPpAccountDeactivate) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpAccountDeactivate", GWsPpAccountDeactivateRequestParam.class, ICallBackWsPpAccountDeactivate.class);
            if (iCallBackWsPpAccountDeactivate != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsPpAccountDeactivateImpl) typeHelper.transfer(method, 1, iCallBackWsPpAccountDeactivate) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.99
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpAccountDeactivate(gWsPpAccountDeactivateRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceInternalLinkAutoReport(GWsTserviceInternalLinkAutoReportRequestParam gWsTserviceInternalLinkAutoReportRequestParam, ICallBackWsTserviceInternalLinkAutoReport iCallBackWsTserviceInternalLinkAutoReport) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceInternalLinkAutoReport", GWsTserviceInternalLinkAutoReportRequestParam.class, ICallBackWsTserviceInternalLinkAutoReport.class);
            if (iCallBackWsTserviceInternalLinkAutoReport != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTserviceInternalLinkAutoReportImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceInternalLinkAutoReport) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.100
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceInternalLinkAutoReport(gWsTserviceInternalLinkAutoReportRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsMapapiBenzLinkids(GWsMapapiBenzLinkidsRequestParam gWsMapapiBenzLinkidsRequestParam, ICallBackWsMapapiBenzLinkids iCallBackWsMapapiBenzLinkids) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsMapapiBenzLinkids", GWsMapapiBenzLinkidsRequestParam.class, ICallBackWsMapapiBenzLinkids.class);
            if (iCallBackWsMapapiBenzLinkids != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsMapapiBenzLinkidsImpl) typeHelper.transfer(method, 1, iCallBackWsMapapiBenzLinkids) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.101
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsMapapiBenzLinkids(gWsMapapiBenzLinkidsRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsMapapiBenzRoad(GWsMapapiBenzRoadRequestParam gWsMapapiBenzRoadRequestParam, ICallBackWsMapapiBenzRoad iCallBackWsMapapiBenzRoad) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsMapapiBenzRoad", GWsMapapiBenzRoadRequestParam.class, ICallBackWsMapapiBenzRoad.class);
            if (iCallBackWsMapapiBenzRoad != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsMapapiBenzRoadImpl) typeHelper.transfer(method, 1, iCallBackWsMapapiBenzRoad) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.102
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsMapapiBenzRoad(gWsMapapiBenzRoadRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsAudiHcp3EventSearch(GWsAudiHcp3EventSearchRequestParam gWsAudiHcp3EventSearchRequestParam, ICallBackWsAudiHcp3EventSearch iCallBackWsAudiHcp3EventSearch) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsAudiHcp3EventSearch", GWsAudiHcp3EventSearchRequestParam.class, ICallBackWsAudiHcp3EventSearch.class);
            if (iCallBackWsAudiHcp3EventSearch != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsAudiHcp3EventSearchImpl) typeHelper.transfer(method, 1, iCallBackWsAudiHcp3EventSearch) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.103
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsAudiHcp3EventSearch(gWsAudiHcp3EventSearchRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsHcp3ChargeList(GWsHcp3ChargeListRequestParam gWsHcp3ChargeListRequestParam, ICallBackWsHcp3ChargeList iCallBackWsHcp3ChargeList) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsHcp3ChargeList", GWsHcp3ChargeListRequestParam.class, ICallBackWsHcp3ChargeList.class);
            if (iCallBackWsHcp3ChargeList != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsHcp3ChargeListImpl) typeHelper.transfer(method, 1, iCallBackWsHcp3ChargeList) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.104
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsHcp3ChargeList(gWsHcp3ChargeListRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsNtg6SdsFiles(GWsNtg6SdsFilesRequestParam gWsNtg6SdsFilesRequestParam, ICallBackWsNtg6SdsFiles iCallBackWsNtg6SdsFiles) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsNtg6SdsFiles", GWsNtg6SdsFilesRequestParam.class, ICallBackWsNtg6SdsFiles.class);
            if (iCallBackWsNtg6SdsFiles != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsNtg6SdsFilesImpl) typeHelper.transfer(method, 1, iCallBackWsNtg6SdsFiles) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.105
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsNtg6SdsFiles(gWsNtg6SdsFilesRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsUserviewFootprintNaviDelete(GWsUserviewFootprintNaviDeleteRequestParam gWsUserviewFootprintNaviDeleteRequestParam, ICallBackWsUserviewFootprintNaviDelete iCallBackWsUserviewFootprintNaviDelete) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsUserviewFootprintNaviDelete", GWsUserviewFootprintNaviDeleteRequestParam.class, ICallBackWsUserviewFootprintNaviDelete.class);
            if (iCallBackWsUserviewFootprintNaviDelete != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsUserviewFootprintNaviDeleteImpl) typeHelper.transfer(method, 1, iCallBackWsUserviewFootprintNaviDelete) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.106
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsUserviewFootprintNaviDelete(gWsUserviewFootprintNaviDeleteRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsUserviewFootprintNaviRecord(GWsUserviewFootprintNaviRecordRequestParam gWsUserviewFootprintNaviRecordRequestParam, ICallBackWsUserviewFootprintNaviRecord iCallBackWsUserviewFootprintNaviRecord) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsUserviewFootprintNaviRecord", GWsUserviewFootprintNaviRecordRequestParam.class, ICallBackWsUserviewFootprintNaviRecord.class);
            if (iCallBackWsUserviewFootprintNaviRecord != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsUserviewFootprintNaviRecordImpl) typeHelper.transfer(method, 1, iCallBackWsUserviewFootprintNaviRecord) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.107
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsUserviewFootprintNaviRecord(gWsUserviewFootprintNaviRecordRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsNavigationDynamicData(GWsNavigationDynamicDataRequestParam gWsNavigationDynamicDataRequestParam, ICallBackWsNavigationDynamicData iCallBackWsNavigationDynamicData) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsNavigationDynamicData", GWsNavigationDynamicDataRequestParam.class, ICallBackWsNavigationDynamicData.class);
            if (iCallBackWsNavigationDynamicData != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsNavigationDynamicDataImpl) typeHelper.transfer(method, 1, iCallBackWsNavigationDynamicData) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.108
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsNavigationDynamicData(gWsNavigationDynamicDataRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsNavigationDynamicFatigue(GWsNavigationDynamicFatigueRequestParam gWsNavigationDynamicFatigueRequestParam, ICallBackWsNavigationDynamicFatigue iCallBackWsNavigationDynamicFatigue) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsNavigationDynamicFatigue", GWsNavigationDynamicFatigueRequestParam.class, ICallBackWsNavigationDynamicFatigue.class);
            if (iCallBackWsNavigationDynamicFatigue != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsNavigationDynamicFatigueImpl) typeHelper.transfer(method, 1, iCallBackWsNavigationDynamicFatigue) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.109
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsNavigationDynamicFatigue(gWsNavigationDynamicFatigueRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqCouponrecvapply(GCouponrecvapplyRequestParam gCouponrecvapplyRequestParam, ICallBackCouponrecvapply iCallBackCouponrecvapply) {
        try {
            Method method = BLAosService.class.getMethod("sendReqCouponrecvapply", GCouponrecvapplyRequestParam.class, ICallBackCouponrecvapply.class);
            if (iCallBackCouponrecvapply != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackCouponrecvapplyImpl) typeHelper.transfer(method, 1, iCallBackCouponrecvapply) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.110
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqCouponrecvapply(gCouponrecvapplyRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqCouponrecvlist(GCouponrecvlistRequestParam gCouponrecvlistRequestParam, ICallBackCouponrecvlist iCallBackCouponrecvlist) {
        try {
            Method method = BLAosService.class.getMethod("sendReqCouponrecvlist", GCouponrecvlistRequestParam.class, ICallBackCouponrecvlist.class);
            if (iCallBackCouponrecvlist != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackCouponrecvlistImpl) typeHelper.transfer(method, 1, iCallBackCouponrecvlist) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.111
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqCouponrecvlist(gCouponrecvlistRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTcFuelCancel(GWsTcFuelCancelRequestParam gWsTcFuelCancelRequestParam, ICallBackWsTcFuelCancel iCallBackWsTcFuelCancel) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcFuelCancel", GWsTcFuelCancelRequestParam.class, ICallBackWsTcFuelCancel.class);
            if (iCallBackWsTcFuelCancel != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTcFuelCancelImpl) typeHelper.transfer(method, 1, iCallBackWsTcFuelCancel) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.112
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcFuelCancel(gWsTcFuelCancelRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTcFuelCreate(GWsTcFuelCreateRequestParam gWsTcFuelCreateRequestParam, ICallBackWsTcFuelCreate iCallBackWsTcFuelCreate) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcFuelCreate", GWsTcFuelCreateRequestParam.class, ICallBackWsTcFuelCreate.class);
            if (iCallBackWsTcFuelCreate != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTcFuelCreateImpl) typeHelper.transfer(method, 1, iCallBackWsTcFuelCreate) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.113
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcFuelCreate(gWsTcFuelCreateRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTcFuelGetwaitingpayorders(GWsTcFuelGetwaitingpayordersRequestParam gWsTcFuelGetwaitingpayordersRequestParam, ICallBackWsTcFuelGetwaitingpayorders iCallBackWsTcFuelGetwaitingpayorders) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcFuelGetwaitingpayorders", GWsTcFuelGetwaitingpayordersRequestParam.class, ICallBackWsTcFuelGetwaitingpayorders.class);
            if (iCallBackWsTcFuelGetwaitingpayorders != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTcFuelGetwaitingpayordersImpl) typeHelper.transfer(method, 1, iCallBackWsTcFuelGetwaitingpayorders) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.114
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcFuelGetwaitingpayorders(gWsTcFuelGetwaitingpayordersRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTcOrderDetail(GWsTcOrderDetailRequestParam gWsTcOrderDetailRequestParam, ICallBackWsTcOrderDetail iCallBackWsTcOrderDetail) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcOrderDetail", GWsTcOrderDetailRequestParam.class, ICallBackWsTcOrderDetail.class);
            if (iCallBackWsTcOrderDetail != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTcOrderDetailImpl) typeHelper.transfer(method, 1, iCallBackWsTcOrderDetail) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.115
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcOrderDetail(gWsTcOrderDetailRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqGasstationcalprice(GGasstationcalpriceRequestParam gGasstationcalpriceRequestParam, ICallBackGasstationcalprice iCallBackGasstationcalprice) {
        try {
            Method method = BLAosService.class.getMethod("sendReqGasstationcalprice", GGasstationcalpriceRequestParam.class, ICallBackGasstationcalprice.class);
            if (iCallBackGasstationcalprice != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackGasstationcalpriceImpl) typeHelper.transfer(method, 1, iCallBackGasstationcalprice) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.116
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqGasstationcalprice(gGasstationcalpriceRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsShieldSearchRanklistCity(GWsShieldSearchRanklistCityRequestParam gWsShieldSearchRanklistCityRequestParam, ICallBackWsShieldSearchRanklistCity iCallBackWsShieldSearchRanklistCity) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsShieldSearchRanklistCity", GWsShieldSearchRanklistCityRequestParam.class, ICallBackWsShieldSearchRanklistCity.class);
            if (iCallBackWsShieldSearchRanklistCity != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsShieldSearchRanklistCityImpl) typeHelper.transfer(method, 1, iCallBackWsShieldSearchRanklistCity) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.117
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsShieldSearchRanklistCity(gWsShieldSearchRanklistCityRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsShieldSearchRanklistLanding(GWsShieldSearchRanklistLandingRequestParam gWsShieldSearchRanklistLandingRequestParam, ICallBackWsShieldSearchRanklistLanding iCallBackWsShieldSearchRanklistLanding) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsShieldSearchRanklistLanding", GWsShieldSearchRanklistLandingRequestParam.class, ICallBackWsShieldSearchRanklistLanding.class);
            if (iCallBackWsShieldSearchRanklistLanding != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsShieldSearchRanklistLandingImpl) typeHelper.transfer(method, 1, iCallBackWsShieldSearchRanklistLanding) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.118
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsShieldSearchRanklistLanding(gWsShieldSearchRanklistLandingRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsShieldSearchRanklistPortal(GWsShieldSearchRanklistPortalRequestParam gWsShieldSearchRanklistPortalRequestParam, ICallBackWsShieldSearchRanklistPortal iCallBackWsShieldSearchRanklistPortal) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsShieldSearchRanklistPortal", GWsShieldSearchRanklistPortalRequestParam.class, ICallBackWsShieldSearchRanklistPortal.class);
            if (iCallBackWsShieldSearchRanklistPortal != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsShieldSearchRanklistPortalImpl) typeHelper.transfer(method, 1, iCallBackWsShieldSearchRanklistPortal) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.119
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsShieldSearchRanklistPortal(gWsShieldSearchRanklistPortalRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsIcsLifeUserCouponList(GWsIcsLifeUserCouponListRequestParam gWsIcsLifeUserCouponListRequestParam, ICallBackWsIcsLifeUserCouponList iCallBackWsIcsLifeUserCouponList) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsIcsLifeUserCouponList", GWsIcsLifeUserCouponListRequestParam.class, ICallBackWsIcsLifeUserCouponList.class);
            if (iCallBackWsIcsLifeUserCouponList != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsIcsLifeUserCouponListImpl) typeHelper.transfer(method, 1, iCallBackWsIcsLifeUserCouponList) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.120
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsIcsLifeUserCouponList(gWsIcsLifeUserCouponListRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsIcsLifeCouponOptions(GWsIcsLifeCouponOptionsRequestParam gWsIcsLifeCouponOptionsRequestParam, ICallBackWsIcsLifeCouponOptions iCallBackWsIcsLifeCouponOptions) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsIcsLifeCouponOptions", GWsIcsLifeCouponOptionsRequestParam.class, ICallBackWsIcsLifeCouponOptions.class);
            if (iCallBackWsIcsLifeCouponOptions != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsIcsLifeCouponOptionsImpl) typeHelper.transfer(method, 1, iCallBackWsIcsLifeCouponOptions) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.121
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsIcsLifeCouponOptions(gWsIcsLifeCouponOptionsRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTcOrderList(GWsTcOrderListRequestParam gWsTcOrderListRequestParam, ICallBackWsTcOrderList iCallBackWsTcOrderList) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcOrderList", GWsTcOrderListRequestParam.class, ICallBackWsTcOrderList.class);
            if (iCallBackWsTcOrderList != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTcOrderListImpl) typeHelper.transfer(method, 1, iCallBackWsTcOrderList) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.122
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcOrderList(gWsTcOrderListRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqLbpEventSyncCommon(GLbpEventSyncCommonRequestParam gLbpEventSyncCommonRequestParam, ICallBackLbpEventSyncCommon iCallBackLbpEventSyncCommon) {
        try {
            Method method = BLAosService.class.getMethod("sendReqLbpEventSyncCommon", GLbpEventSyncCommonRequestParam.class, ICallBackLbpEventSyncCommon.class);
            if (iCallBackLbpEventSyncCommon != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackLbpEventSyncCommonImpl) typeHelper.transfer(method, 1, iCallBackLbpEventSyncCommon) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.123
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqLbpEventSyncCommon(gLbpEventSyncCommonRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTcFuelQueryagreement(GWsTcFuelQueryagreementRequestParam gWsTcFuelQueryagreementRequestParam, ICallBackWsTcFuelQueryagreement iCallBackWsTcFuelQueryagreement) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcFuelQueryagreement", GWsTcFuelQueryagreementRequestParam.class, ICallBackWsTcFuelQueryagreement.class);
            if (iCallBackWsTcFuelQueryagreement != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTcFuelQueryagreementImpl) typeHelper.transfer(method, 1, iCallBackWsTcFuelQueryagreement) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.124
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcFuelQueryagreement(gWsTcFuelQueryagreementRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTcCommonAgreementStatus(GWsTcCommonAgreementStatusRequestParam gWsTcCommonAgreementStatusRequestParam, ICallBackWsTcCommonAgreementStatus iCallBackWsTcCommonAgreementStatus) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcCommonAgreementStatus", GWsTcCommonAgreementStatusRequestParam.class, ICallBackWsTcCommonAgreementStatus.class);
            if (iCallBackWsTcCommonAgreementStatus != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsTcCommonAgreementStatusImpl) typeHelper.transfer(method, 1, iCallBackWsTcCommonAgreementStatus) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.125
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcCommonAgreementStatus(gWsTcCommonAgreementStatusRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsCommerceInfraChargeRecordsWaitingEnable(GWsCommerceInfraChargeRecordsWaitingEnableRequestParam gWsCommerceInfraChargeRecordsWaitingEnableRequestParam, ICallBackWsCommerceInfraChargeRecordsWaitingEnable iCallBackWsCommerceInfraChargeRecordsWaitingEnable) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsCommerceInfraChargeRecordsWaitingEnable", GWsCommerceInfraChargeRecordsWaitingEnableRequestParam.class, ICallBackWsCommerceInfraChargeRecordsWaitingEnable.class);
            if (iCallBackWsCommerceInfraChargeRecordsWaitingEnable != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsCommerceInfraChargeRecordsWaitingEnableImpl) typeHelper.transfer(method, 1, iCallBackWsCommerceInfraChargeRecordsWaitingEnable) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.126
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsCommerceInfraChargeRecordsWaitingEnable(gWsCommerceInfraChargeRecordsWaitingEnableRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsAuthcarServiceEnable(GWsAuthcarServiceEnableRequestParam gWsAuthcarServiceEnableRequestParam, ICallBackWsAuthcarServiceEnable iCallBackWsAuthcarServiceEnable) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsAuthcarServiceEnable", GWsAuthcarServiceEnableRequestParam.class, ICallBackWsAuthcarServiceEnable.class);
            if (iCallBackWsAuthcarServiceEnable != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsAuthcarServiceEnableImpl) typeHelper.transfer(method, 1, iCallBackWsAuthcarServiceEnable) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.127
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsAuthcarServiceEnable(gWsAuthcarServiceEnableRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsAosDestinationSearch(GWsAosDestinationSearchRequestParam gWsAosDestinationSearchRequestParam, ICallBackWsAosDestinationSearch iCallBackWsAosDestinationSearch) {
        try {
            Method method = BLAosService.class.getMethod("sendReqWsAosDestinationSearch", GWsAosDestinationSearchRequestParam.class, ICallBackWsAosDestinationSearch.class);
            if (iCallBackWsAosDestinationSearch != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (ICallBackWsAosDestinationSearchImpl) typeHelper.transfer(method, 1, iCallBackWsAosDestinationSearch) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pAosCallbackRef == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.128
                    }));
                    return 0L;
                }
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsAosDestinationSearch(gWsAosDestinationSearchRequestParam, r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.129
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.130
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosService.131
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            ReflexTool.invokeDeclMethodSafe(this.mControl, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mControl = null;
        }
        unbind();
    }
}
