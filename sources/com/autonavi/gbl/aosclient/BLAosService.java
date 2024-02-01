package com.autonavi.gbl.aosclient;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
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
import com.autonavi.gbl.aosclient.model.GWsAuthcarServiceEnableRequestParam;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServiceProvisionRequestParam;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServicelistRequestParam;
import com.autonavi.gbl.aosclient.model.GWsAuthcarTokenRequestParam;
import com.autonavi.gbl.aosclient.model.GWsAutoCollectRequestParam;
import com.autonavi.gbl.aosclient.model.GWsChargeListRequestParam;
import com.autonavi.gbl.aosclient.model.GWsCloudUploadRequestParam;
import com.autonavi.gbl.aosclient.model.GWsCommerceInfraChargeRecordsWaitingEnableRequestParam;
import com.autonavi.gbl.aosclient.model.GWsDeviceAdiusRequestParam;
import com.autonavi.gbl.aosclient.model.GWsDynamicInfoCongestionGroupChatUserAddV3RequestParam;
import com.autonavi.gbl.aosclient.model.GWsDynamicInfoCongestionGroupChatUserRemoveRequestParam;
import com.autonavi.gbl.aosclient.model.GWsDynamicInfoEventPraiseStampStatusQueryRequestParam;
import com.autonavi.gbl.aosclient.model.GWsEventSearchRequestParam;
import com.autonavi.gbl.aosclient.model.GWsFeedbackReviewGetRequestParam;
import com.autonavi.gbl.aosclient.model.GWsFeedbackReviewReportRequestParam;
import com.autonavi.gbl.aosclient.model.GWsFencingFencesQueryRequestParam;
import com.autonavi.gbl.aosclient.model.GWsFencingGroupsQueryRequestParam;
import com.autonavi.gbl.aosclient.model.GWsIcsLifeCouponOptionsRequestParam;
import com.autonavi.gbl.aosclient.model.GWsIcsLifeUserCouponListRequestParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiAutoInitRequestParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiAutoSwitchRequestParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiConfOfflineRequestParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiGeoCodeRequestParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiLinkidsRequestParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiPoiVoicesearchRequestParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiRoadRequestParam;
import com.autonavi.gbl.aosclient.model.GWsMiniappCarVipGwRequestParam;
import com.autonavi.gbl.aosclient.model.GWsNavigationDynamicDataRequestParam;
import com.autonavi.gbl.aosclient.model.GWsNavigationDynamicFatigueRequestParam;
import com.autonavi.gbl.aosclient.model.GWsOssMaplayerListRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpAccountDeactivateHelpRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpAccountDeactivateRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpAccountProfileUpdateRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpAutoWeixinQrcodeRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpAutoWeixinStatusRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpAutoWeixinUnbindRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpCarltdAuthCancelRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpCarltdCheckbindRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpCarltdLogin4bindRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpContactBindMobileRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpContactUnbindMobileRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpQrcodeInnerGetRequestParam;
import com.autonavi.gbl.aosclient.model.GWsPpQrcodeUrlTranslateRequestParam;
import com.autonavi.gbl.aosclient.model.GWsSdsFilesRequestParam;
import com.autonavi.gbl.aosclient.model.GWsSearchPoiAutoCmallFillOrderRequestParam;
import com.autonavi.gbl.aosclient.model.GWsShieldAsbpApiUploadRequestParam;
import com.autonavi.gbl.aosclient.model.GWsShieldImMsgCommentSetRequestParam;
import com.autonavi.gbl.aosclient.model.GWsShieldNavigationRoutepathrestorationRequestParam;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchMainPageRecRequestParam;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistCityRequestParam;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistLandingRequestParam;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistPortalRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcAlscOrderCancelRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcCarServiceOrderCancelRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcCarServiceSubmitRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcCommonAgreementOrderquickpayRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcCommonAgreementSignRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcCommonAgreementStatusRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcFuelCancelRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcFuelCreateRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcFuelGetwaitingpayordersRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcFuelQueryagreementRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcKoubeiOrderSubmitRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcOrderApiMergeListRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcOrderDetailRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcOrderListRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTcPoiInfoRequestParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceDatainterflowGetRequestParam;
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
import com.autonavi.gbl.aosclient.observer.ICallBackWsAuthcarServiceEnable;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAuthcarServiceProvision;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAuthcarServicelist;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAuthcarToken;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAutoCollect;
import com.autonavi.gbl.aosclient.observer.ICallBackWsChargeList;
import com.autonavi.gbl.aosclient.observer.ICallBackWsCloudUpload;
import com.autonavi.gbl.aosclient.observer.ICallBackWsCommerceInfraChargeRecordsWaitingEnable;
import com.autonavi.gbl.aosclient.observer.ICallBackWsDeviceAdius;
import com.autonavi.gbl.aosclient.observer.ICallBackWsDynamicInfoCongestionGroupChatUserAddV3;
import com.autonavi.gbl.aosclient.observer.ICallBackWsDynamicInfoCongestionGroupChatUserRemove;
import com.autonavi.gbl.aosclient.observer.ICallBackWsDynamicInfoEventPraiseStampStatusQuery;
import com.autonavi.gbl.aosclient.observer.ICallBackWsEventSearch;
import com.autonavi.gbl.aosclient.observer.ICallBackWsFeedbackReviewGet;
import com.autonavi.gbl.aosclient.observer.ICallBackWsFeedbackReviewReport;
import com.autonavi.gbl.aosclient.observer.ICallBackWsFencingFencesQuery;
import com.autonavi.gbl.aosclient.observer.ICallBackWsFencingGroupsQuery;
import com.autonavi.gbl.aosclient.observer.ICallBackWsIcsLifeCouponOptions;
import com.autonavi.gbl.aosclient.observer.ICallBackWsIcsLifeUserCouponList;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiAutoInit;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiAutoSwitch;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiConfOffline;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiGeoCode;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiLinkids;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiPoiVoicesearch;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiRoad;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMiniappCarVipGw;
import com.autonavi.gbl.aosclient.observer.ICallBackWsNavigationDynamicData;
import com.autonavi.gbl.aosclient.observer.ICallBackWsNavigationDynamicFatigue;
import com.autonavi.gbl.aosclient.observer.ICallBackWsOssMaplayerList;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAccountDeactivate;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAccountDeactivateHelp;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAccountProfileUpdate;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAutoWeixinQrcode;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAutoWeixinStatus;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAutoWeixinUnbind;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpCarltdAuthCancel;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpCarltdCheckbind;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpCarltdLogin4bind;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpContactBindMobile;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpContactUnbindMobile;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpQrcodeInnerGet;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpQrcodeUrlTranslate;
import com.autonavi.gbl.aosclient.observer.ICallBackWsSdsFiles;
import com.autonavi.gbl.aosclient.observer.ICallBackWsSearchPoiAutoCmallFillOrder;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldAsbpApiUpload;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldImMsgCommentSet;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldNavigationRoutepathrestoration;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldSearchMainPageRec;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldSearchRanklistCity;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldSearchRanklistLanding;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldSearchRanklistPortal;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcAlscOrderCancel;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcCarServiceOrderCancel;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcCarServiceSubmit;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcCommonAgreementOrderquickpay;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcCommonAgreementSign;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcCommonAgreementStatus;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcFuelCancel;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcFuelCreate;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcFuelGetwaitingpayorders;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcFuelQueryagreement;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcKoubeiOrderSubmit;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcOrderApiMergeList;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcOrderDetail;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcOrderList;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcPoiInfo;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceDatainterflowGet;
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
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarServiceEnableImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarServiceProvisionImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarServicelistImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarTokenImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAutoCollectImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsChargeListImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsCloudUploadImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsCommerceInfraChargeRecordsWaitingEnableImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDeviceAdiusImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsEventSearchImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFeedbackReviewGetImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFeedbackReviewReportImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFencingFencesQueryImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFencingGroupsQueryImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsIcsLifeCouponOptionsImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsIcsLifeUserCouponListImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiAutoInitImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiAutoSwitchImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiConfOfflineImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiGeoCodeImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiLinkidsImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiPoiVoicesearchImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiRoadImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMiniappCarVipGwImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsNavigationDynamicDataImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsNavigationDynamicFatigueImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsOssMaplayerListImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAccountDeactivateHelpImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAccountDeactivateImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAccountProfileUpdateImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAutoWeixinQrcodeImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAutoWeixinStatusImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAutoWeixinUnbindImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpCarltdAuthCancelImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpCarltdCheckbindImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpCarltdLogin4bindImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpContactBindMobileImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpContactUnbindMobileImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpQrcodeInnerGetImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpQrcodeUrlTranslateImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsSdsFilesImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsSearchPoiAutoCmallFillOrderImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldAsbpApiUploadImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldImMsgCommentSetImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldNavigationRoutepathrestorationImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchMainPageRecImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchRanklistCityImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchRanklistLandingImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchRanklistPortalImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcAlscOrderCancelImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCarServiceOrderCancelImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCarServiceSubmitImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCommonAgreementOrderquickpayImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCommonAgreementSignImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCommonAgreementStatusImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelCancelImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelCreateImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelGetwaitingpayordersImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelQueryagreementImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcKoubeiOrderSubmitImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcOrderApiMergeListImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcOrderDetailImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcOrderListImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcPoiInfoImpl;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceDatainterflowGetImpl;
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

    protected void clean() {
    }

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
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqNavigationEtaquery", GNavigationEtaqueryRequestParam.class, ICallBackNavigationEtaquery.class);
            ICallBackNavigationEtaqueryImpl iCallBackNavigationEtaqueryImpl = null;
            if (iCallBackNavigationEtaquery != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackNavigationEtaqueryImpl = (ICallBackNavigationEtaqueryImpl) typeHelper.transfer(method, 1, iCallBackNavigationEtaquery);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqNavigationEtaquery(gNavigationEtaqueryRequestParam, iCallBackNavigationEtaqueryImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqRangeSpider(GRangeSpiderRequestParam gRangeSpiderRequestParam, ICallBackRangeSpider iCallBackRangeSpider) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqRangeSpider", GRangeSpiderRequestParam.class, ICallBackRangeSpider.class);
            ICallBackRangeSpiderImpl iCallBackRangeSpiderImpl = null;
            if (iCallBackRangeSpider != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackRangeSpiderImpl = (ICallBackRangeSpiderImpl) typeHelper.transfer(method, 1, iCallBackRangeSpider);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqRangeSpider(gRangeSpiderRequestParam, iCallBackRangeSpiderImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqQueryWeatherByLink(GQueryWeatherByLinkRequestParam gQueryWeatherByLinkRequestParam, ICallBackQueryWeatherByLink iCallBackQueryWeatherByLink) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqQueryWeatherByLink", GQueryWeatherByLinkRequestParam.class, ICallBackQueryWeatherByLink.class);
            ICallBackQueryWeatherByLinkImpl iCallBackQueryWeatherByLinkImpl = null;
            if (iCallBackQueryWeatherByLink != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackQueryWeatherByLinkImpl = (ICallBackQueryWeatherByLinkImpl) typeHelper.transfer(method, 1, iCallBackQueryWeatherByLink);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqQueryWeatherByLink(gQueryWeatherByLinkRequestParam, iCallBackQueryWeatherByLinkImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqQueryPersentWeather(GQueryPersentWeatherRequestParam gQueryPersentWeatherRequestParam, ICallBackQueryPersentWeather iCallBackQueryPersentWeather) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqQueryPersentWeather", GQueryPersentWeatherRequestParam.class, ICallBackQueryPersentWeather.class);
            ICallBackQueryPersentWeatherImpl iCallBackQueryPersentWeatherImpl = null;
            if (iCallBackQueryPersentWeather != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackQueryPersentWeatherImpl = (ICallBackQueryPersentWeatherImpl) typeHelper.transfer(method, 1, iCallBackQueryPersentWeather);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqQueryPersentWeather(gQueryPersentWeatherRequestParam, iCallBackQueryPersentWeatherImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqEtaRequestRequest(CEtaRequestRequestParam cEtaRequestRequestParam, ICallBackEtaRequest iCallBackEtaRequest) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqEtaRequestRequest", CEtaRequestRequestParam.class, ICallBackEtaRequest.class);
            ICallBackEtaRequestImpl iCallBackEtaRequestImpl = null;
            if (iCallBackEtaRequest != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackEtaRequestImpl = (ICallBackEtaRequestImpl) typeHelper.transfer(method, 1, iCallBackEtaRequest);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqEtaRequestRequest(cEtaRequestRequestParam, iCallBackEtaRequestImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqAddressPredict(GAddressPredictRequestParam gAddressPredictRequestParam, ICallBackAddressPredict iCallBackAddressPredict) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqAddressPredict", GAddressPredictRequestParam.class, ICallBackAddressPredict.class);
            ICallBackAddressPredictImpl iCallBackAddressPredictImpl = null;
            if (iCallBackAddressPredict != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackAddressPredictImpl = (ICallBackAddressPredictImpl) typeHelper.transfer(method, 1, iCallBackAddressPredict);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqAddressPredict(gAddressPredictRequestParam, iCallBackAddressPredictImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqHolidayList(GHolidayListRequestParam gHolidayListRequestParam, ICallBackHolidayList iCallBackHolidayList) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqHolidayList", GHolidayListRequestParam.class, ICallBackHolidayList.class);
            ICallBackHolidayListImpl iCallBackHolidayListImpl = null;
            if (iCallBackHolidayList != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackHolidayListImpl = (ICallBackHolidayListImpl) typeHelper.transfer(method, 1, iCallBackHolidayList);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqHolidayList(gHolidayListRequestParam, iCallBackHolidayListImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqMojiWeather(GMojiWeatherRequestParam gMojiWeatherRequestParam, ICallBackMojiWeather iCallBackMojiWeather) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqMojiWeather", GMojiWeatherRequestParam.class, ICallBackMojiWeather.class);
            ICallBackMojiWeatherImpl iCallBackMojiWeatherImpl = null;
            if (iCallBackMojiWeather != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackMojiWeatherImpl = (ICallBackMojiWeatherImpl) typeHelper.transfer(method, 1, iCallBackMojiWeather);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqMojiWeather(gMojiWeatherRequestParam, iCallBackMojiWeatherImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqReStrictedArea(GReStrictedAreaRequestParam gReStrictedAreaRequestParam, ICallBackReStrictedArea iCallBackReStrictedArea) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqReStrictedArea", GReStrictedAreaRequestParam.class, ICallBackReStrictedArea.class);
            ICallBackReStrictedAreaImpl iCallBackReStrictedAreaImpl = null;
            if (iCallBackReStrictedArea != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackReStrictedAreaImpl = (ICallBackReStrictedAreaImpl) typeHelper.transfer(method, 1, iCallBackReStrictedArea);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqReStrictedArea(gReStrictedAreaRequestParam, iCallBackReStrictedAreaImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWorkdayList(GWorkdayListRequestParam gWorkdayListRequestParam, ICallBackWorkdayList iCallBackWorkdayList) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWorkdayList", GWorkdayListRequestParam.class, ICallBackWorkdayList.class);
            ICallBackWorkdayListImpl iCallBackWorkdayListImpl = null;
            if (iCallBackWorkdayList != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWorkdayListImpl = (ICallBackWorkdayListImpl) typeHelper.transfer(method, 1, iCallBackWorkdayList);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWorkdayList(gWorkdayListRequestParam, iCallBackWorkdayListImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsMapapiPoiVoicesearch(GWsMapapiPoiVoicesearchRequestParam gWsMapapiPoiVoicesearchRequestParam, ICallBackWsMapapiPoiVoicesearch iCallBackWsMapapiPoiVoicesearch) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsMapapiPoiVoicesearch", GWsMapapiPoiVoicesearchRequestParam.class, ICallBackWsMapapiPoiVoicesearch.class);
            ICallBackWsMapapiPoiVoicesearchImpl iCallBackWsMapapiPoiVoicesearchImpl = null;
            if (iCallBackWsMapapiPoiVoicesearch != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsMapapiPoiVoicesearchImpl = (ICallBackWsMapapiPoiVoicesearchImpl) typeHelper.transfer(method, 1, iCallBackWsMapapiPoiVoicesearch);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsMapapiPoiVoicesearch(gWsMapapiPoiVoicesearchRequestParam, iCallBackWsMapapiPoiVoicesearchImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsAppConfAppUpdate(GWsAppConfAppUpdateRequestParam gWsAppConfAppUpdateRequestParam, ICallBackWsAppConfAppUpdate iCallBackWsAppConfAppUpdate) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsAppConfAppUpdate", GWsAppConfAppUpdateRequestParam.class, ICallBackWsAppConfAppUpdate.class);
            ICallBackWsAppConfAppUpdateImpl iCallBackWsAppConfAppUpdateImpl = null;
            if (iCallBackWsAppConfAppUpdate != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsAppConfAppUpdateImpl = (ICallBackWsAppConfAppUpdateImpl) typeHelper.transfer(method, 1, iCallBackWsAppConfAppUpdate);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsAppConfAppUpdate(gWsAppConfAppUpdateRequestParam, iCallBackWsAppConfAppUpdateImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsMapapiGeoCode(GWsMapapiGeoCodeRequestParam gWsMapapiGeoCodeRequestParam, ICallBackWsMapapiGeoCode iCallBackWsMapapiGeoCode) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsMapapiGeoCode", GWsMapapiGeoCodeRequestParam.class, ICallBackWsMapapiGeoCode.class);
            ICallBackWsMapapiGeoCodeImpl iCallBackWsMapapiGeoCodeImpl = null;
            if (iCallBackWsMapapiGeoCode != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsMapapiGeoCodeImpl = (ICallBackWsMapapiGeoCodeImpl) typeHelper.transfer(method, 1, iCallBackWsMapapiGeoCode);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsMapapiGeoCode(gWsMapapiGeoCodeRequestParam, iCallBackWsMapapiGeoCodeImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsMapapiAutoSwitch(GWsMapapiAutoSwitchRequestParam gWsMapapiAutoSwitchRequestParam, ICallBackWsMapapiAutoSwitch iCallBackWsMapapiAutoSwitch) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsMapapiAutoSwitch", GWsMapapiAutoSwitchRequestParam.class, ICallBackWsMapapiAutoSwitch.class);
            ICallBackWsMapapiAutoSwitchImpl iCallBackWsMapapiAutoSwitchImpl = null;
            if (iCallBackWsMapapiAutoSwitch != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsMapapiAutoSwitchImpl = (ICallBackWsMapapiAutoSwitchImpl) typeHelper.transfer(method, 1, iCallBackWsMapapiAutoSwitch);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsMapapiAutoSwitch(gWsMapapiAutoSwitchRequestParam, iCallBackWsMapapiAutoSwitchImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqCancelSignPay(GCancelSignPayRequestParam gCancelSignPayRequestParam, ICallBackCancelSignPay iCallBackCancelSignPay) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqCancelSignPay", GCancelSignPayRequestParam.class, ICallBackCancelSignPay.class);
            ICallBackCancelSignPayImpl iCallBackCancelSignPayImpl = null;
            if (iCallBackCancelSignPay != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackCancelSignPayImpl = (ICallBackCancelSignPayImpl) typeHelper.transfer(method, 1, iCallBackCancelSignPay);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqCancelSignPay(gCancelSignPayRequestParam, iCallBackCancelSignPayImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqFeedbackReport(GFeedbackReportRequestParam gFeedbackReportRequestParam, ICallBackFeedbackReport iCallBackFeedbackReport) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqFeedbackReport", GFeedbackReportRequestParam.class, ICallBackFeedbackReport.class);
            ICallBackFeedbackReportImpl iCallBackFeedbackReportImpl = null;
            if (iCallBackFeedbackReport != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackFeedbackReportImpl = (ICallBackFeedbackReportImpl) typeHelper.transfer(method, 1, iCallBackFeedbackReport);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqFeedbackReport(gFeedbackReportRequestParam, iCallBackFeedbackReportImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqParkService(GParkServiceRequestParam gParkServiceRequestParam, ICallBackParkService iCallBackParkService) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqParkService", GParkServiceRequestParam.class, ICallBackParkService.class);
            ICallBackParkServiceImpl iCallBackParkServiceImpl = null;
            if (iCallBackParkService != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackParkServiceImpl = (ICallBackParkServiceImpl) typeHelper.transfer(method, 1, iCallBackParkService);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqParkService(gParkServiceRequestParam, iCallBackParkServiceImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqParkOrderCreate(GParkOrderCreateRequestParam gParkOrderCreateRequestParam, ICallBackParkOrderCreate iCallBackParkOrderCreate) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqParkOrderCreate", GParkOrderCreateRequestParam.class, ICallBackParkOrderCreate.class);
            ICallBackParkOrderCreateImpl iCallBackParkOrderCreateImpl = null;
            if (iCallBackParkOrderCreate != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackParkOrderCreateImpl = (ICallBackParkOrderCreateImpl) typeHelper.transfer(method, 1, iCallBackParkOrderCreate);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqParkOrderCreate(gParkOrderCreateRequestParam, iCallBackParkOrderCreateImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqParkOrderDetail(GParkOrderDetailRequestParam gParkOrderDetailRequestParam, ICallBackParkOrderDetail iCallBackParkOrderDetail) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqParkOrderDetail", GParkOrderDetailRequestParam.class, ICallBackParkOrderDetail.class);
            ICallBackParkOrderDetailImpl iCallBackParkOrderDetailImpl = null;
            if (iCallBackParkOrderDetail != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackParkOrderDetailImpl = (ICallBackParkOrderDetailImpl) typeHelper.transfer(method, 1, iCallBackParkOrderDetail);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqParkOrderDetail(gParkOrderDetailRequestParam, iCallBackParkOrderDetailImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqParkOrderList(GParkOrderListRequestParam gParkOrderListRequestParam, ICallBackParkOrderList iCallBackParkOrderList) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqParkOrderList", GParkOrderListRequestParam.class, ICallBackParkOrderList.class);
            ICallBackParkOrderListImpl iCallBackParkOrderListImpl = null;
            if (iCallBackParkOrderList != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackParkOrderListImpl = (ICallBackParkOrderListImpl) typeHelper.transfer(method, 1, iCallBackParkOrderList);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqParkOrderList(gParkOrderListRequestParam, iCallBackParkOrderListImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqParkPayStatus(GParkPayStatusRequestParam gParkPayStatusRequestParam, ICallBackParkPayStatus iCallBackParkPayStatus) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqParkPayStatus", GParkPayStatusRequestParam.class, ICallBackParkPayStatus.class);
            ICallBackParkPayStatusImpl iCallBackParkPayStatusImpl = null;
            if (iCallBackParkPayStatus != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackParkPayStatusImpl = (ICallBackParkPayStatusImpl) typeHelper.transfer(method, 1, iCallBackParkPayStatus);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqParkPayStatus(gParkPayStatusRequestParam, iCallBackParkPayStatusImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqTrafficEventComment(GTrafficEventCommentRequestParam gTrafficEventCommentRequestParam, ICallBackTrafficEventComment iCallBackTrafficEventComment) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqTrafficEventComment", GTrafficEventCommentRequestParam.class, ICallBackTrafficEventComment.class);
            ICallBackTrafficEventCommentImpl iCallBackTrafficEventCommentImpl = null;
            if (iCallBackTrafficEventComment != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackTrafficEventCommentImpl = (ICallBackTrafficEventCommentImpl) typeHelper.transfer(method, 1, iCallBackTrafficEventComment);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqTrafficEventComment(gTrafficEventCommentRequestParam, iCallBackTrafficEventCommentImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqTrafficEventDetail(GTrafficEventDetailRequestParam gTrafficEventDetailRequestParam, ICallBackTrafficEventDetail iCallBackTrafficEventDetail) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqTrafficEventDetail", GTrafficEventDetailRequestParam.class, ICallBackTrafficEventDetail.class);
            ICallBackTrafficEventDetailImpl iCallBackTrafficEventDetailImpl = null;
            if (iCallBackTrafficEventDetail != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackTrafficEventDetailImpl = (ICallBackTrafficEventDetailImpl) typeHelper.transfer(method, 1, iCallBackTrafficEventDetail);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqTrafficEventDetail(gTrafficEventDetailRequestParam, iCallBackTrafficEventDetailImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqUserDevice(GUserDeviceRequestParam gUserDeviceRequestParam, ICallBackUserDevice iCallBackUserDevice) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqUserDevice", GUserDeviceRequestParam.class, ICallBackUserDevice.class);
            ICallBackUserDeviceImpl iCallBackUserDeviceImpl = null;
            if (iCallBackUserDevice != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackUserDeviceImpl = (ICallBackUserDeviceImpl) typeHelper.transfer(method, 1, iCallBackUserDevice);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqUserDevice(gUserDeviceRequestParam, iCallBackUserDeviceImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqQRCodeConfirm(GQRCodeConfirmRequestParam gQRCodeConfirmRequestParam, ICallBackQRCodeConfirm iCallBackQRCodeConfirm) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqQRCodeConfirm", GQRCodeConfirmRequestParam.class, ICallBackQRCodeConfirm.class);
            ICallBackQRCodeConfirmImpl iCallBackQRCodeConfirmImpl = null;
            if (iCallBackQRCodeConfirm != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackQRCodeConfirmImpl = (ICallBackQRCodeConfirmImpl) typeHelper.transfer(method, 1, iCallBackQRCodeConfirm);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqQRCodeConfirm(gQRCodeConfirmRequestParam, iCallBackQRCodeConfirmImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsArchiveTrafficeventUpdate(GWsArchiveTrafficeventUpdateRequestParam gWsArchiveTrafficeventUpdateRequestParam, ICallBackWsArchiveTrafficeventUpdate iCallBackWsArchiveTrafficeventUpdate) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsArchiveTrafficeventUpdate", GWsArchiveTrafficeventUpdateRequestParam.class, ICallBackWsArchiveTrafficeventUpdate.class);
            ICallBackWsArchiveTrafficeventUpdateImpl iCallBackWsArchiveTrafficeventUpdateImpl = null;
            if (iCallBackWsArchiveTrafficeventUpdate != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsArchiveTrafficeventUpdateImpl = (ICallBackWsArchiveTrafficeventUpdateImpl) typeHelper.transfer(method, 1, iCallBackWsArchiveTrafficeventUpdate);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsArchiveTrafficeventUpdate(gWsArchiveTrafficeventUpdateRequestParam, iCallBackWsArchiveTrafficeventUpdateImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpAccountProfileUpdate(GWsPpAccountProfileUpdateRequestParam gWsPpAccountProfileUpdateRequestParam, ICallBackWsPpAccountProfileUpdate iCallBackWsPpAccountProfileUpdate) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpAccountProfileUpdate", GWsPpAccountProfileUpdateRequestParam.class, ICallBackWsPpAccountProfileUpdate.class);
            ICallBackWsPpAccountProfileUpdateImpl iCallBackWsPpAccountProfileUpdateImpl = null;
            if (iCallBackWsPpAccountProfileUpdate != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsPpAccountProfileUpdateImpl = (ICallBackWsPpAccountProfileUpdateImpl) typeHelper.transfer(method, 1, iCallBackWsPpAccountProfileUpdate);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpAccountProfileUpdate(gWsPpAccountProfileUpdateRequestParam, iCallBackWsPpAccountProfileUpdateImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqCarLtdBind(GCarLtdBindRequestParam gCarLtdBindRequestParam, ICallBackCarLtdBind iCallBackCarLtdBind) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqCarLtdBind", GCarLtdBindRequestParam.class, ICallBackCarLtdBind.class);
            ICallBackCarLtdBindImpl iCallBackCarLtdBindImpl = null;
            if (iCallBackCarLtdBind != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackCarLtdBindImpl = (ICallBackCarLtdBindImpl) typeHelper.transfer(method, 1, iCallBackCarLtdBind);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqCarLtdBind(gCarLtdBindRequestParam, iCallBackCarLtdBindImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqCarLtdUnbind(GCarLtdUnbindRequestParam gCarLtdUnbindRequestParam, ICallBackCarLtdUnbind iCallBackCarLtdUnbind) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqCarLtdUnbind", GCarLtdUnbindRequestParam.class, ICallBackCarLtdUnbind.class);
            ICallBackCarLtdUnbindImpl iCallBackCarLtdUnbindImpl = null;
            if (iCallBackCarLtdUnbind != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackCarLtdUnbindImpl = (ICallBackCarLtdUnbindImpl) typeHelper.transfer(method, 1, iCallBackCarLtdUnbind);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqCarLtdUnbind(gCarLtdUnbindRequestParam, iCallBackCarLtdUnbindImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqCarLtdCheckToken(GCarLtdCheckTokenRequestParam gCarLtdCheckTokenRequestParam, ICallBackCarLtdCheckToken iCallBackCarLtdCheckToken) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqCarLtdCheckToken", GCarLtdCheckTokenRequestParam.class, ICallBackCarLtdCheckToken.class);
            ICallBackCarLtdCheckTokenImpl iCallBackCarLtdCheckTokenImpl = null;
            if (iCallBackCarLtdCheckToken != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackCarLtdCheckTokenImpl = (ICallBackCarLtdCheckTokenImpl) typeHelper.transfer(method, 1, iCallBackCarLtdCheckToken);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqCarLtdCheckToken(gCarLtdCheckTokenRequestParam, iCallBackCarLtdCheckTokenImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqCarLtdQuickLogin(GCarLtdQuickLoginRequestParam gCarLtdQuickLoginRequestParam, ICallBackCarLtdQuickLogin iCallBackCarLtdQuickLogin) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqCarLtdQuickLogin", GCarLtdQuickLoginRequestParam.class, ICallBackCarLtdQuickLogin.class);
            ICallBackCarLtdQuickLoginImpl iCallBackCarLtdQuickLoginImpl = null;
            if (iCallBackCarLtdQuickLogin != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackCarLtdQuickLoginImpl = (ICallBackCarLtdQuickLoginImpl) typeHelper.transfer(method, 1, iCallBackCarLtdQuickLogin);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqCarLtdQuickLogin(gCarLtdQuickLoginRequestParam, iCallBackCarLtdQuickLoginImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqCarLtdQuickRegister(GCarLtdQuickRegisterRequestParam gCarLtdQuickRegisterRequestParam, ICallBackCarLtdQuickRegister iCallBackCarLtdQuickRegister) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqCarLtdQuickRegister", GCarLtdQuickRegisterRequestParam.class, ICallBackCarLtdQuickRegister.class);
            ICallBackCarLtdQuickRegisterImpl iCallBackCarLtdQuickRegisterImpl = null;
            if (iCallBackCarLtdQuickRegister != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackCarLtdQuickRegisterImpl = (ICallBackCarLtdQuickRegisterImpl) typeHelper.transfer(method, 1, iCallBackCarLtdQuickRegister);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqCarLtdQuickRegister(gCarLtdQuickRegisterRequestParam, iCallBackCarLtdQuickRegisterImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqPaymentBindAlipay(GPaymentBindAlipayRequestParam gPaymentBindAlipayRequestParam, ICallBackPaymentBindAlipay iCallBackPaymentBindAlipay) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqPaymentBindAlipay", GPaymentBindAlipayRequestParam.class, ICallBackPaymentBindAlipay.class);
            ICallBackPaymentBindAlipayImpl iCallBackPaymentBindAlipayImpl = null;
            if (iCallBackPaymentBindAlipay != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackPaymentBindAlipayImpl = (ICallBackPaymentBindAlipayImpl) typeHelper.transfer(method, 1, iCallBackPaymentBindAlipay);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqPaymentBindAlipay(gPaymentBindAlipayRequestParam, iCallBackPaymentBindAlipayImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqPaymentStatus(GPaymentStatusRequestParam gPaymentStatusRequestParam, ICallBackPaymentStatus iCallBackPaymentStatus) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqPaymentStatus", GPaymentStatusRequestParam.class, ICallBackPaymentStatus.class);
            ICallBackPaymentStatusImpl iCallBackPaymentStatusImpl = null;
            if (iCallBackPaymentStatus != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackPaymentStatusImpl = (ICallBackPaymentStatusImpl) typeHelper.transfer(method, 1, iCallBackPaymentStatus);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqPaymentStatus(gPaymentStatusRequestParam, iCallBackPaymentStatusImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqPaymentUnbindAlipay(GPaymentUnbindAlipayRequestParam gPaymentUnbindAlipayRequestParam, ICallBackPaymentUnbindAlipay iCallBackPaymentUnbindAlipay) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqPaymentUnbindAlipay", GPaymentUnbindAlipayRequestParam.class, ICallBackPaymentUnbindAlipay.class);
            ICallBackPaymentUnbindAlipayImpl iCallBackPaymentUnbindAlipayImpl = null;
            if (iCallBackPaymentUnbindAlipay != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackPaymentUnbindAlipayImpl = (ICallBackPaymentUnbindAlipayImpl) typeHelper.transfer(method, 1, iCallBackPaymentUnbindAlipay);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqPaymentUnbindAlipay(gPaymentUnbindAlipayRequestParam, iCallBackPaymentUnbindAlipayImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpAutoWeixinQrcode(GWsPpAutoWeixinQrcodeRequestParam gWsPpAutoWeixinQrcodeRequestParam, ICallBackWsPpAutoWeixinQrcode iCallBackWsPpAutoWeixinQrcode) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpAutoWeixinQrcode", GWsPpAutoWeixinQrcodeRequestParam.class, ICallBackWsPpAutoWeixinQrcode.class);
            ICallBackWsPpAutoWeixinQrcodeImpl iCallBackWsPpAutoWeixinQrcodeImpl = null;
            if (iCallBackWsPpAutoWeixinQrcode != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsPpAutoWeixinQrcodeImpl = (ICallBackWsPpAutoWeixinQrcodeImpl) typeHelper.transfer(method, 1, iCallBackWsPpAutoWeixinQrcode);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpAutoWeixinQrcode(gWsPpAutoWeixinQrcodeRequestParam, iCallBackWsPpAutoWeixinQrcodeImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpAutoWeixinUnbind(GWsPpAutoWeixinUnbindRequestParam gWsPpAutoWeixinUnbindRequestParam, ICallBackWsPpAutoWeixinUnbind iCallBackWsPpAutoWeixinUnbind) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpAutoWeixinUnbind", GWsPpAutoWeixinUnbindRequestParam.class, ICallBackWsPpAutoWeixinUnbind.class);
            ICallBackWsPpAutoWeixinUnbindImpl iCallBackWsPpAutoWeixinUnbindImpl = null;
            if (iCallBackWsPpAutoWeixinUnbind != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsPpAutoWeixinUnbindImpl = (ICallBackWsPpAutoWeixinUnbindImpl) typeHelper.transfer(method, 1, iCallBackWsPpAutoWeixinUnbind);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpAutoWeixinUnbind(gWsPpAutoWeixinUnbindRequestParam, iCallBackWsPpAutoWeixinUnbindImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpAutoWeixinStatus(GWsPpAutoWeixinStatusRequestParam gWsPpAutoWeixinStatusRequestParam, ICallBackWsPpAutoWeixinStatus iCallBackWsPpAutoWeixinStatus) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpAutoWeixinStatus", GWsPpAutoWeixinStatusRequestParam.class, ICallBackWsPpAutoWeixinStatus.class);
            ICallBackWsPpAutoWeixinStatusImpl iCallBackWsPpAutoWeixinStatusImpl = null;
            if (iCallBackWsPpAutoWeixinStatus != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsPpAutoWeixinStatusImpl = (ICallBackWsPpAutoWeixinStatusImpl) typeHelper.transfer(method, 1, iCallBackWsPpAutoWeixinStatus);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpAutoWeixinStatus(gWsPpAutoWeixinStatusRequestParam, iCallBackWsPpAutoWeixinStatusImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpQrcodeUrlTranslate(GWsPpQrcodeUrlTranslateRequestParam gWsPpQrcodeUrlTranslateRequestParam, ICallBackWsPpQrcodeUrlTranslate iCallBackWsPpQrcodeUrlTranslate) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpQrcodeUrlTranslate", GWsPpQrcodeUrlTranslateRequestParam.class, ICallBackWsPpQrcodeUrlTranslate.class);
            ICallBackWsPpQrcodeUrlTranslateImpl iCallBackWsPpQrcodeUrlTranslateImpl = null;
            if (iCallBackWsPpQrcodeUrlTranslate != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsPpQrcodeUrlTranslateImpl = (ICallBackWsPpQrcodeUrlTranslateImpl) typeHelper.transfer(method, 1, iCallBackWsPpQrcodeUrlTranslate);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpQrcodeUrlTranslate(gWsPpQrcodeUrlTranslateRequestParam, iCallBackWsPpQrcodeUrlTranslateImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpCarltdCheckbind(GWsPpCarltdCheckbindRequestParam gWsPpCarltdCheckbindRequestParam, ICallBackWsPpCarltdCheckbind iCallBackWsPpCarltdCheckbind) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpCarltdCheckbind", GWsPpCarltdCheckbindRequestParam.class, ICallBackWsPpCarltdCheckbind.class);
            ICallBackWsPpCarltdCheckbindImpl iCallBackWsPpCarltdCheckbindImpl = null;
            if (iCallBackWsPpCarltdCheckbind != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsPpCarltdCheckbindImpl = (ICallBackWsPpCarltdCheckbindImpl) typeHelper.transfer(method, 1, iCallBackWsPpCarltdCheckbind);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpCarltdCheckbind(gWsPpCarltdCheckbindRequestParam, iCallBackWsPpCarltdCheckbindImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqDriveReportSms(GDriveReportSmsRequestParam gDriveReportSmsRequestParam, ICallBackDriveReportSms iCallBackDriveReportSms) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqDriveReportSms", GDriveReportSmsRequestParam.class, ICallBackDriveReportSms.class);
            ICallBackDriveReportSmsImpl iCallBackDriveReportSmsImpl = null;
            if (iCallBackDriveReportSms != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackDriveReportSmsImpl = (ICallBackDriveReportSmsImpl) typeHelper.transfer(method, 1, iCallBackDriveReportSms);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqDriveReportSms(gDriveReportSmsRequestParam, iCallBackDriveReportSmsImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqTrafficRestrict(GTrafficRestrictRequestParam gTrafficRestrictRequestParam, ICallBackTrafficRestrict iCallBackTrafficRestrict) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqTrafficRestrict", GTrafficRestrictRequestParam.class, ICallBackTrafficRestrict.class);
            ICallBackTrafficRestrictImpl iCallBackTrafficRestrictImpl = null;
            if (iCallBackTrafficRestrict != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackTrafficRestrictImpl = (ICallBackTrafficRestrictImpl) typeHelper.transfer(method, 1, iCallBackTrafficRestrict);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqTrafficRestrict(gTrafficRestrictRequestParam, iCallBackTrafficRestrictImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqDriveReport(GDriveReportUploadRequestParam gDriveReportUploadRequestParam, ICallBackDriveReportUpload iCallBackDriveReportUpload) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqDriveReport", GDriveReportUploadRequestParam.class, ICallBackDriveReportUpload.class);
            ICallBackDriveReportUploadImpl iCallBackDriveReportUploadImpl = null;
            if (iCallBackDriveReportUpload != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackDriveReportUploadImpl = (ICallBackDriveReportUploadImpl) typeHelper.transfer(method, 1, iCallBackDriveReportUpload);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqDriveReport(gDriveReportUploadRequestParam, iCallBackDriveReportUploadImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqLogUpload(GLogUploadRequestParam gLogUploadRequestParam, ICallBackLogUpload iCallBackLogUpload) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqLogUpload", GLogUploadRequestParam.class, ICallBackLogUpload.class);
            ICallBackLogUploadImpl iCallBackLogUploadImpl = null;
            if (iCallBackLogUpload != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackLogUploadImpl = (ICallBackLogUploadImpl) typeHelper.transfer(method, 1, iCallBackLogUpload);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqLogUpload(gLogUploadRequestParam, iCallBackLogUploadImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqQueryCarMsg(GQueryCarMsgRequestParam gQueryCarMsgRequestParam, ICallBackQueryCarMsg iCallBackQueryCarMsg) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqQueryCarMsg", GQueryCarMsgRequestParam.class, ICallBackQueryCarMsg.class);
            ICallBackQueryCarMsgImpl iCallBackQueryCarMsgImpl = null;
            if (iCallBackQueryCarMsg != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackQueryCarMsgImpl = (ICallBackQueryCarMsgImpl) typeHelper.transfer(method, 1, iCallBackQueryCarMsg);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqQueryCarMsg(gQueryCarMsgRequestParam, iCallBackQueryCarMsgImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqSendToPhone(GSendToPhoneRequestParam gSendToPhoneRequestParam, ICallBackSendToPhone iCallBackSendToPhone) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqSendToPhone", GSendToPhoneRequestParam.class, ICallBackSendToPhone.class);
            ICallBackSendToPhoneImpl iCallBackSendToPhoneImpl = null;
            if (iCallBackSendToPhone != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackSendToPhoneImpl = (ICallBackSendToPhoneImpl) typeHelper.transfer(method, 1, iCallBackSendToPhone);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqSendToPhone(gSendToPhoneRequestParam, iCallBackSendToPhoneImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamCreate(GWsTserviceTeamCreateRequestParam gWsTserviceTeamCreateRequestParam, ICallBackWsTserviceTeamCreate iCallBackWsTserviceTeamCreate) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamCreate", GWsTserviceTeamCreateRequestParam.class, ICallBackWsTserviceTeamCreate.class);
            ICallBackWsTserviceTeamCreateImpl iCallBackWsTserviceTeamCreateImpl = null;
            if (iCallBackWsTserviceTeamCreate != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceTeamCreateImpl = (ICallBackWsTserviceTeamCreateImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamCreate);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamCreate(gWsTserviceTeamCreateRequestParam, iCallBackWsTserviceTeamCreateImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamUserStatus(GWsTserviceTeamUserStatusRequestParam gWsTserviceTeamUserStatusRequestParam, ICallBackWsTserviceTeamUserStatus iCallBackWsTserviceTeamUserStatus) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamUserStatus", GWsTserviceTeamUserStatusRequestParam.class, ICallBackWsTserviceTeamUserStatus.class);
            ICallBackWsTserviceTeamUserStatusImpl iCallBackWsTserviceTeamUserStatusImpl = null;
            if (iCallBackWsTserviceTeamUserStatus != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceTeamUserStatusImpl = (ICallBackWsTserviceTeamUserStatusImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamUserStatus);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamUserStatus(gWsTserviceTeamUserStatusRequestParam, iCallBackWsTserviceTeamUserStatusImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamJoin(GWsTserviceTeamJoinRequestParam gWsTserviceTeamJoinRequestParam, ICallBackWsTserviceTeamJoin iCallBackWsTserviceTeamJoin) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamJoin", GWsTserviceTeamJoinRequestParam.class, ICallBackWsTserviceTeamJoin.class);
            ICallBackWsTserviceTeamJoinImpl iCallBackWsTserviceTeamJoinImpl = null;
            if (iCallBackWsTserviceTeamJoin != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceTeamJoinImpl = (ICallBackWsTserviceTeamJoinImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamJoin);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamJoin(gWsTserviceTeamJoinRequestParam, iCallBackWsTserviceTeamJoinImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamUserFriends(GWsTserviceTeamUserFriendsRequestParam gWsTserviceTeamUserFriendsRequestParam, ICallBackWsTserviceTeamUserFriends iCallBackWsTserviceTeamUserFriends) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamUserFriends", GWsTserviceTeamUserFriendsRequestParam.class, ICallBackWsTserviceTeamUserFriends.class);
            ICallBackWsTserviceTeamUserFriendsImpl iCallBackWsTserviceTeamUserFriendsImpl = null;
            if (iCallBackWsTserviceTeamUserFriends != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceTeamUserFriendsImpl = (ICallBackWsTserviceTeamUserFriendsImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamUserFriends);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamUserFriends(gWsTserviceTeamUserFriendsRequestParam, iCallBackWsTserviceTeamUserFriendsImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamQr(GWsTserviceTeamQrRequestParam gWsTserviceTeamQrRequestParam, ICallBackWsTserviceTeamQr iCallBackWsTserviceTeamQr) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamQr", GWsTserviceTeamQrRequestParam.class, ICallBackWsTserviceTeamQr.class);
            ICallBackWsTserviceTeamQrImpl iCallBackWsTserviceTeamQrImpl = null;
            if (iCallBackWsTserviceTeamQr != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceTeamQrImpl = (ICallBackWsTserviceTeamQrImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamQr);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamQr(gWsTserviceTeamQrRequestParam, iCallBackWsTserviceTeamQrImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamInvite(GWsTserviceTeamInviteRequestParam gWsTserviceTeamInviteRequestParam, ICallBackWsTserviceTeamInvite iCallBackWsTserviceTeamInvite) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamInvite", GWsTserviceTeamInviteRequestParam.class, ICallBackWsTserviceTeamInvite.class);
            ICallBackWsTserviceTeamInviteImpl iCallBackWsTserviceTeamInviteImpl = null;
            if (iCallBackWsTserviceTeamInvite != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceTeamInviteImpl = (ICallBackWsTserviceTeamInviteImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamInvite);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamInvite(gWsTserviceTeamInviteRequestParam, iCallBackWsTserviceTeamInviteImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamInfoGet(GWsTserviceTeamInfoGetRequestParam gWsTserviceTeamInfoGetRequestParam, ICallBackWsTserviceTeamInfoGet iCallBackWsTserviceTeamInfoGet) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamInfoGet", GWsTserviceTeamInfoGetRequestParam.class, ICallBackWsTserviceTeamInfoGet.class);
            ICallBackWsTserviceTeamInfoGetImpl iCallBackWsTserviceTeamInfoGetImpl = null;
            if (iCallBackWsTserviceTeamInfoGet != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceTeamInfoGetImpl = (ICallBackWsTserviceTeamInfoGetImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamInfoGet);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamInfoGet(gWsTserviceTeamInfoGetRequestParam, iCallBackWsTserviceTeamInfoGetImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamKick(GWsTserviceTeamKickRequestParam gWsTserviceTeamKickRequestParam, ICallBackWsTserviceTeamKick iCallBackWsTserviceTeamKick) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamKick", GWsTserviceTeamKickRequestParam.class, ICallBackWsTserviceTeamKick.class);
            ICallBackWsTserviceTeamKickImpl iCallBackWsTserviceTeamKickImpl = null;
            if (iCallBackWsTserviceTeamKick != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceTeamKickImpl = (ICallBackWsTserviceTeamKickImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamKick);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamKick(gWsTserviceTeamKickRequestParam, iCallBackWsTserviceTeamKickImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamQuit(GWsTserviceTeamQuitRequestParam gWsTserviceTeamQuitRequestParam, ICallBackWsTserviceTeamQuit iCallBackWsTserviceTeamQuit) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamQuit", GWsTserviceTeamQuitRequestParam.class, ICallBackWsTserviceTeamQuit.class);
            ICallBackWsTserviceTeamQuitImpl iCallBackWsTserviceTeamQuitImpl = null;
            if (iCallBackWsTserviceTeamQuit != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceTeamQuitImpl = (ICallBackWsTserviceTeamQuitImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamQuit);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamQuit(gWsTserviceTeamQuitRequestParam, iCallBackWsTserviceTeamQuitImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamDismiss(GWsTserviceTeamDismissRequestParam gWsTserviceTeamDismissRequestParam, ICallBackWsTserviceTeamDismiss iCallBackWsTserviceTeamDismiss) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamDismiss", GWsTserviceTeamDismissRequestParam.class, ICallBackWsTserviceTeamDismiss.class);
            ICallBackWsTserviceTeamDismissImpl iCallBackWsTserviceTeamDismissImpl = null;
            if (iCallBackWsTserviceTeamDismiss != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceTeamDismissImpl = (ICallBackWsTserviceTeamDismissImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamDismiss);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamDismiss(gWsTserviceTeamDismissRequestParam, iCallBackWsTserviceTeamDismissImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamInfoUpdate(GWsTserviceTeamInfoUpdateRequestParam gWsTserviceTeamInfoUpdateRequestParam, ICallBackWsTserviceTeamInfoUpdate iCallBackWsTserviceTeamInfoUpdate) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamInfoUpdate", GWsTserviceTeamInfoUpdateRequestParam.class, ICallBackWsTserviceTeamInfoUpdate.class);
            ICallBackWsTserviceTeamInfoUpdateImpl iCallBackWsTserviceTeamInfoUpdateImpl = null;
            if (iCallBackWsTserviceTeamInfoUpdate != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceTeamInfoUpdateImpl = (ICallBackWsTserviceTeamInfoUpdateImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamInfoUpdate);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamInfoUpdate(gWsTserviceTeamInfoUpdateRequestParam, iCallBackWsTserviceTeamInfoUpdateImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceTeamUserTnnUpdate(GWsTserviceTeamUserTnnUpdateRequestParam gWsTserviceTeamUserTnnUpdateRequestParam, ICallBackWsTserviceTeamUserTnnUpdate iCallBackWsTserviceTeamUserTnnUpdate) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceTeamUserTnnUpdate", GWsTserviceTeamUserTnnUpdateRequestParam.class, ICallBackWsTserviceTeamUserTnnUpdate.class);
            ICallBackWsTserviceTeamUserTnnUpdateImpl iCallBackWsTserviceTeamUserTnnUpdateImpl = null;
            if (iCallBackWsTserviceTeamUserTnnUpdate != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceTeamUserTnnUpdateImpl = (ICallBackWsTserviceTeamUserTnnUpdateImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceTeamUserTnnUpdate);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceTeamUserTnnUpdate(gWsTserviceTeamUserTnnUpdateRequestParam, iCallBackWsTserviceTeamUserTnnUpdateImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsDeviceAdius(GWsDeviceAdiusRequestParam gWsDeviceAdiusRequestParam, ICallBackWsDeviceAdius iCallBackWsDeviceAdius) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsDeviceAdius", GWsDeviceAdiusRequestParam.class, ICallBackWsDeviceAdius.class);
            ICallBackWsDeviceAdiusImpl iCallBackWsDeviceAdiusImpl = null;
            if (iCallBackWsDeviceAdius != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsDeviceAdiusImpl = (ICallBackWsDeviceAdiusImpl) typeHelper.transfer(method, 1, iCallBackWsDeviceAdius);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsDeviceAdius(gWsDeviceAdiusRequestParam, iCallBackWsDeviceAdiusImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqHttpGetPost(GHttpGetPostRequestParam gHttpGetPostRequestParam, ICallBackHttpGetPost iCallBackHttpGetPost) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqHttpGetPost", GHttpGetPostRequestParam.class, ICallBackHttpGetPost.class);
            ICallBackHttpGetPostImpl iCallBackHttpGetPostImpl = null;
            if (iCallBackHttpGetPost != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackHttpGetPostImpl = (ICallBackHttpGetPostImpl) typeHelper.transfer(method, 1, iCallBackHttpGetPost);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqHttpGetPost(gHttpGetPostRequestParam, iCallBackHttpGetPostImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsOssMaplayerList(GWsOssMaplayerListRequestParam gWsOssMaplayerListRequestParam, ICallBackWsOssMaplayerList iCallBackWsOssMaplayerList) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsOssMaplayerList", GWsOssMaplayerListRequestParam.class, ICallBackWsOssMaplayerList.class);
            ICallBackWsOssMaplayerListImpl iCallBackWsOssMaplayerListImpl = null;
            if (iCallBackWsOssMaplayerList != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsOssMaplayerListImpl = (ICallBackWsOssMaplayerListImpl) typeHelper.transfer(method, 1, iCallBackWsOssMaplayerList);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsOssMaplayerList(gWsOssMaplayerListRequestParam, iCallBackWsOssMaplayerListImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsShieldNavigationRoutepathrestoration(GWsShieldNavigationRoutepathrestorationRequestParam gWsShieldNavigationRoutepathrestorationRequestParam, ICallBackWsShieldNavigationRoutepathrestoration iCallBackWsShieldNavigationRoutepathrestoration) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsShieldNavigationRoutepathrestoration", GWsShieldNavigationRoutepathrestorationRequestParam.class, ICallBackWsShieldNavigationRoutepathrestoration.class);
            ICallBackWsShieldNavigationRoutepathrestorationImpl iCallBackWsShieldNavigationRoutepathrestorationImpl = null;
            if (iCallBackWsShieldNavigationRoutepathrestoration != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsShieldNavigationRoutepathrestorationImpl = (ICallBackWsShieldNavigationRoutepathrestorationImpl) typeHelper.transfer(method, 1, iCallBackWsShieldNavigationRoutepathrestoration);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsShieldNavigationRoutepathrestoration(gWsShieldNavigationRoutepathrestorationRequestParam, iCallBackWsShieldNavigationRoutepathrestorationImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsVaCarLogo(GWsVaCarLogoRequestParam gWsVaCarLogoRequestParam, ICallBackWsVaCarLogo iCallBackWsVaCarLogo) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsVaCarLogo", GWsVaCarLogoRequestParam.class, ICallBackWsVaCarLogo.class);
            ICallBackWsVaCarLogoImpl iCallBackWsVaCarLogoImpl = null;
            if (iCallBackWsVaCarLogo != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsVaCarLogoImpl = (ICallBackWsVaCarLogoImpl) typeHelper.transfer(method, 1, iCallBackWsVaCarLogo);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsVaCarLogo(gWsVaCarLogoRequestParam, iCallBackWsVaCarLogoImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsVaCarLogoExchange(GWsVaCarLogoExchangeRequestParam gWsVaCarLogoExchangeRequestParam, ICallBackWsVaCarLogoExchange iCallBackWsVaCarLogoExchange) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsVaCarLogoExchange", GWsVaCarLogoExchangeRequestParam.class, ICallBackWsVaCarLogoExchange.class);
            ICallBackWsVaCarLogoExchangeImpl iCallBackWsVaCarLogoExchangeImpl = null;
            if (iCallBackWsVaCarLogoExchange != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsVaCarLogoExchangeImpl = (ICallBackWsVaCarLogoExchangeImpl) typeHelper.transfer(method, 1, iCallBackWsVaCarLogoExchange);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsVaCarLogoExchange(gWsVaCarLogoExchangeRequestParam, iCallBackWsVaCarLogoExchangeImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsVaCarLogoSelect(GWsVaCarLogoSelectRequestParam gWsVaCarLogoSelectRequestParam, ICallBackWsVaCarLogoSelect iCallBackWsVaCarLogoSelect) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsVaCarLogoSelect", GWsVaCarLogoSelectRequestParam.class, ICallBackWsVaCarLogoSelect.class);
            ICallBackWsVaCarLogoSelectImpl iCallBackWsVaCarLogoSelectImpl = null;
            if (iCallBackWsVaCarLogoSelect != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsVaCarLogoSelectImpl = (ICallBackWsVaCarLogoSelectImpl) typeHelper.transfer(method, 1, iCallBackWsVaCarLogoSelect);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsVaCarLogoSelect(gWsVaCarLogoSelectRequestParam, iCallBackWsVaCarLogoSelectImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsAuthcarServiceProvision(GWsAuthcarServiceProvisionRequestParam gWsAuthcarServiceProvisionRequestParam, ICallBackWsAuthcarServiceProvision iCallBackWsAuthcarServiceProvision) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsAuthcarServiceProvision", GWsAuthcarServiceProvisionRequestParam.class, ICallBackWsAuthcarServiceProvision.class);
            ICallBackWsAuthcarServiceProvisionImpl iCallBackWsAuthcarServiceProvisionImpl = null;
            if (iCallBackWsAuthcarServiceProvision != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsAuthcarServiceProvisionImpl = (ICallBackWsAuthcarServiceProvisionImpl) typeHelper.transfer(method, 1, iCallBackWsAuthcarServiceProvision);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsAuthcarServiceProvision(gWsAuthcarServiceProvisionRequestParam, iCallBackWsAuthcarServiceProvisionImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsAuthcarServicelist(GWsAuthcarServicelistRequestParam gWsAuthcarServicelistRequestParam, ICallBackWsAuthcarServicelist iCallBackWsAuthcarServicelist) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsAuthcarServicelist", GWsAuthcarServicelistRequestParam.class, ICallBackWsAuthcarServicelist.class);
            ICallBackWsAuthcarServicelistImpl iCallBackWsAuthcarServicelistImpl = null;
            if (iCallBackWsAuthcarServicelist != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsAuthcarServicelistImpl = (ICallBackWsAuthcarServicelistImpl) typeHelper.transfer(method, 1, iCallBackWsAuthcarServicelist);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsAuthcarServicelist(gWsAuthcarServicelistRequestParam, iCallBackWsAuthcarServicelistImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsAuthcarToken(GWsAuthcarTokenRequestParam gWsAuthcarTokenRequestParam, ICallBackWsAuthcarToken iCallBackWsAuthcarToken) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsAuthcarToken", GWsAuthcarTokenRequestParam.class, ICallBackWsAuthcarToken.class);
            ICallBackWsAuthcarTokenImpl iCallBackWsAuthcarTokenImpl = null;
            if (iCallBackWsAuthcarToken != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsAuthcarTokenImpl = (ICallBackWsAuthcarTokenImpl) typeHelper.transfer(method, 1, iCallBackWsAuthcarToken);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsAuthcarToken(gWsAuthcarTokenRequestParam, iCallBackWsAuthcarTokenImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsShieldAsbpApiUpload(GWsShieldAsbpApiUploadRequestParam gWsShieldAsbpApiUploadRequestParam, ICallBackWsShieldAsbpApiUpload iCallBackWsShieldAsbpApiUpload) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsShieldAsbpApiUpload", GWsShieldAsbpApiUploadRequestParam.class, ICallBackWsShieldAsbpApiUpload.class);
            ICallBackWsShieldAsbpApiUploadImpl iCallBackWsShieldAsbpApiUploadImpl = null;
            if (iCallBackWsShieldAsbpApiUpload != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsShieldAsbpApiUploadImpl = (ICallBackWsShieldAsbpApiUploadImpl) typeHelper.transfer(method, 1, iCallBackWsShieldAsbpApiUpload);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsShieldAsbpApiUpload(gWsShieldAsbpApiUploadRequestParam, iCallBackWsShieldAsbpApiUploadImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsCloudUpload(GWsCloudUploadRequestParam gWsCloudUploadRequestParam, ICallBackWsCloudUpload iCallBackWsCloudUpload) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsCloudUpload", GWsCloudUploadRequestParam.class, ICallBackWsCloudUpload.class);
            ICallBackWsCloudUploadImpl iCallBackWsCloudUploadImpl = null;
            if (iCallBackWsCloudUpload != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsCloudUploadImpl = (ICallBackWsCloudUploadImpl) typeHelper.transfer(method, 1, iCallBackWsCloudUpload);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsCloudUpload(gWsCloudUploadRequestParam, iCallBackWsCloudUploadImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsMapapiAutoInit(GWsMapapiAutoInitRequestParam gWsMapapiAutoInitRequestParam, ICallBackWsMapapiAutoInit iCallBackWsMapapiAutoInit) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsMapapiAutoInit", GWsMapapiAutoInitRequestParam.class, ICallBackWsMapapiAutoInit.class);
            ICallBackWsMapapiAutoInitImpl iCallBackWsMapapiAutoInitImpl = null;
            if (iCallBackWsMapapiAutoInit != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsMapapiAutoInitImpl = (ICallBackWsMapapiAutoInitImpl) typeHelper.transfer(method, 1, iCallBackWsMapapiAutoInit);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsMapapiAutoInit(gWsMapapiAutoInitRequestParam, iCallBackWsMapapiAutoInitImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsMapapiConfOffline(GWsMapapiConfOfflineRequestParam gWsMapapiConfOfflineRequestParam, ICallBackWsMapapiConfOffline iCallBackWsMapapiConfOffline) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsMapapiConfOffline", GWsMapapiConfOfflineRequestParam.class, ICallBackWsMapapiConfOffline.class);
            ICallBackWsMapapiConfOfflineImpl iCallBackWsMapapiConfOfflineImpl = null;
            if (iCallBackWsMapapiConfOffline != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsMapapiConfOfflineImpl = (ICallBackWsMapapiConfOfflineImpl) typeHelper.transfer(method, 1, iCallBackWsMapapiConfOffline);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsMapapiConfOffline(gWsMapapiConfOfflineRequestParam, iCallBackWsMapapiConfOfflineImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqQuerybylinks(GQuerybylinksRequestParam gQuerybylinksRequestParam, ICallBackQuerybylinks iCallBackQuerybylinks) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqQuerybylinks", GQuerybylinksRequestParam.class, ICallBackQuerybylinks.class);
            ICallBackQuerybylinksImpl iCallBackQuerybylinksImpl = null;
            if (iCallBackQuerybylinks != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackQuerybylinksImpl = (ICallBackQuerybylinksImpl) typeHelper.transfer(method, 1, iCallBackQuerybylinks);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqQuerybylinks(gQuerybylinksRequestParam, iCallBackQuerybylinksImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpContactBindMobile(GWsPpContactBindMobileRequestParam gWsPpContactBindMobileRequestParam, ICallBackWsPpContactBindMobile iCallBackWsPpContactBindMobile) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpContactBindMobile", GWsPpContactBindMobileRequestParam.class, ICallBackWsPpContactBindMobile.class);
            ICallBackWsPpContactBindMobileImpl iCallBackWsPpContactBindMobileImpl = null;
            if (iCallBackWsPpContactBindMobile != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsPpContactBindMobileImpl = (ICallBackWsPpContactBindMobileImpl) typeHelper.transfer(method, 1, iCallBackWsPpContactBindMobile);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpContactBindMobile(gWsPpContactBindMobileRequestParam, iCallBackWsPpContactBindMobileImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpContactUnbindMobile(GWsPpContactUnbindMobileRequestParam gWsPpContactUnbindMobileRequestParam, ICallBackWsPpContactUnbindMobile iCallBackWsPpContactUnbindMobile) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpContactUnbindMobile", GWsPpContactUnbindMobileRequestParam.class, ICallBackWsPpContactUnbindMobile.class);
            ICallBackWsPpContactUnbindMobileImpl iCallBackWsPpContactUnbindMobileImpl = null;
            if (iCallBackWsPpContactUnbindMobile != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsPpContactUnbindMobileImpl = (ICallBackWsPpContactUnbindMobileImpl) typeHelper.transfer(method, 1, iCallBackWsPpContactUnbindMobile);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpContactUnbindMobile(gWsPpContactUnbindMobileRequestParam, iCallBackWsPpContactUnbindMobileImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsAutoCollect(GWsAutoCollectRequestParam gWsAutoCollectRequestParam, ICallBackWsAutoCollect iCallBackWsAutoCollect) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsAutoCollect", GWsAutoCollectRequestParam.class, ICallBackWsAutoCollect.class);
            ICallBackWsAutoCollectImpl iCallBackWsAutoCollectImpl = null;
            if (iCallBackWsAutoCollect != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsAutoCollectImpl = (ICallBackWsAutoCollectImpl) typeHelper.transfer(method, 1, iCallBackWsAutoCollect);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsAutoCollect(gWsAutoCollectRequestParam, iCallBackWsAutoCollectImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceIotTripodSnAutoBind(GWsTserviceIotTripodSnAutoBindRequestParam gWsTserviceIotTripodSnAutoBindRequestParam, ICallBackWsTserviceIotTripodSnAutoBind iCallBackWsTserviceIotTripodSnAutoBind) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceIotTripodSnAutoBind", GWsTserviceIotTripodSnAutoBindRequestParam.class, ICallBackWsTserviceIotTripodSnAutoBind.class);
            ICallBackWsTserviceIotTripodSnAutoBindImpl iCallBackWsTserviceIotTripodSnAutoBindImpl = null;
            if (iCallBackWsTserviceIotTripodSnAutoBind != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceIotTripodSnAutoBindImpl = (ICallBackWsTserviceIotTripodSnAutoBindImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceIotTripodSnAutoBind);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceIotTripodSnAutoBind(gWsTserviceIotTripodSnAutoBindRequestParam, iCallBackWsTserviceIotTripodSnAutoBindImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceIotTripodSnAutoBound(GWsTserviceIotTripodSnAutoBoundRequestParam gWsTserviceIotTripodSnAutoBoundRequestParam, ICallBackWsTserviceIotTripodSnAutoBound iCallBackWsTserviceIotTripodSnAutoBound) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceIotTripodSnAutoBound", GWsTserviceIotTripodSnAutoBoundRequestParam.class, ICallBackWsTserviceIotTripodSnAutoBound.class);
            ICallBackWsTserviceIotTripodSnAutoBoundImpl iCallBackWsTserviceIotTripodSnAutoBoundImpl = null;
            if (iCallBackWsTserviceIotTripodSnAutoBound != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceIotTripodSnAutoBoundImpl = (ICallBackWsTserviceIotTripodSnAutoBoundImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceIotTripodSnAutoBound);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceIotTripodSnAutoBound(gWsTserviceIotTripodSnAutoBoundRequestParam, iCallBackWsTserviceIotTripodSnAutoBoundImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceIotTripodSnAutoBindForce(GWsTserviceIotTripodSnAutoBindForceRequestParam gWsTserviceIotTripodSnAutoBindForceRequestParam, ICallBackWsTserviceIotTripodSnAutoBindForce iCallBackWsTserviceIotTripodSnAutoBindForce) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceIotTripodSnAutoBindForce", GWsTserviceIotTripodSnAutoBindForceRequestParam.class, ICallBackWsTserviceIotTripodSnAutoBindForce.class);
            ICallBackWsTserviceIotTripodSnAutoBindForceImpl iCallBackWsTserviceIotTripodSnAutoBindForceImpl = null;
            if (iCallBackWsTserviceIotTripodSnAutoBindForce != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceIotTripodSnAutoBindForceImpl = (ICallBackWsTserviceIotTripodSnAutoBindForceImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceIotTripodSnAutoBindForce);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceIotTripodSnAutoBindForce(gWsTserviceIotTripodSnAutoBindForceRequestParam, iCallBackWsTserviceIotTripodSnAutoBindForceImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceIotDeviceList(GWsTserviceIotDeviceListRequestParam gWsTserviceIotDeviceListRequestParam, ICallBackWsTserviceIotDeviceList iCallBackWsTserviceIotDeviceList) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceIotDeviceList", GWsTserviceIotDeviceListRequestParam.class, ICallBackWsTserviceIotDeviceList.class);
            ICallBackWsTserviceIotDeviceListImpl iCallBackWsTserviceIotDeviceListImpl = null;
            if (iCallBackWsTserviceIotDeviceList != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceIotDeviceListImpl = (ICallBackWsTserviceIotDeviceListImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceIotDeviceList);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceIotDeviceList(gWsTserviceIotDeviceListRequestParam, iCallBackWsTserviceIotDeviceListImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceIotDeviceRelieve(GWsTserviceIotDeviceRelieveRequestParam gWsTserviceIotDeviceRelieveRequestParam, ICallBackWsTserviceIotDeviceRelieve iCallBackWsTserviceIotDeviceRelieve) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceIotDeviceRelieve", GWsTserviceIotDeviceRelieveRequestParam.class, ICallBackWsTserviceIotDeviceRelieve.class);
            ICallBackWsTserviceIotDeviceRelieveImpl iCallBackWsTserviceIotDeviceRelieveImpl = null;
            if (iCallBackWsTserviceIotDeviceRelieve != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceIotDeviceRelieveImpl = (ICallBackWsTserviceIotDeviceRelieveImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceIotDeviceRelieve);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceIotDeviceRelieve(gWsTserviceIotDeviceRelieveRequestParam, iCallBackWsTserviceIotDeviceRelieveImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceIotTripodStatus(GWsTserviceIotTripodStatusRequestParam gWsTserviceIotTripodStatusRequestParam, ICallBackWsTserviceIotTripodStatus iCallBackWsTserviceIotTripodStatus) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceIotTripodStatus", GWsTserviceIotTripodStatusRequestParam.class, ICallBackWsTserviceIotTripodStatus.class);
            ICallBackWsTserviceIotTripodStatusImpl iCallBackWsTserviceIotTripodStatusImpl = null;
            if (iCallBackWsTserviceIotTripodStatus != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceIotTripodStatusImpl = (ICallBackWsTserviceIotTripodStatusImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceIotTripodStatus);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceIotTripodStatus(gWsTserviceIotTripodStatusRequestParam, iCallBackWsTserviceIotTripodStatusImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceIotTripodEvent(GWsTserviceIotTripodEventRequestParam gWsTserviceIotTripodEventRequestParam, ICallBackWsTserviceIotTripodEvent iCallBackWsTserviceIotTripodEvent) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceIotTripodEvent", GWsTserviceIotTripodEventRequestParam.class, ICallBackWsTserviceIotTripodEvent.class);
            ICallBackWsTserviceIotTripodEventImpl iCallBackWsTserviceIotTripodEventImpl = null;
            if (iCallBackWsTserviceIotTripodEvent != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceIotTripodEventImpl = (ICallBackWsTserviceIotTripodEventImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceIotTripodEvent);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceIotTripodEvent(gWsTserviceIotTripodEventRequestParam, iCallBackWsTserviceIotTripodEventImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceRequestIp(GWsTserviceRequestIpRequestParam gWsTserviceRequestIpRequestParam, ICallBackWsTserviceRequestIp iCallBackWsTserviceRequestIp) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceRequestIp", GWsTserviceRequestIpRequestParam.class, ICallBackWsTserviceRequestIp.class);
            ICallBackWsTserviceRequestIpImpl iCallBackWsTserviceRequestIpImpl = null;
            if (iCallBackWsTserviceRequestIp != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceRequestIpImpl = (ICallBackWsTserviceRequestIpImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceRequestIp);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceRequestIp(gWsTserviceRequestIpRequestParam, iCallBackWsTserviceRequestIpImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpCarltdLogin4bind(GWsPpCarltdLogin4bindRequestParam gWsPpCarltdLogin4bindRequestParam, ICallBackWsPpCarltdLogin4bind iCallBackWsPpCarltdLogin4bind) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpCarltdLogin4bind", GWsPpCarltdLogin4bindRequestParam.class, ICallBackWsPpCarltdLogin4bind.class);
            ICallBackWsPpCarltdLogin4bindImpl iCallBackWsPpCarltdLogin4bindImpl = null;
            if (iCallBackWsPpCarltdLogin4bind != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsPpCarltdLogin4bindImpl = (ICallBackWsPpCarltdLogin4bindImpl) typeHelper.transfer(method, 1, iCallBackWsPpCarltdLogin4bind);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpCarltdLogin4bind(gWsPpCarltdLogin4bindRequestParam, iCallBackWsPpCarltdLogin4bindImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsShieldSearchMainPageRec(GWsShieldSearchMainPageRecRequestParam gWsShieldSearchMainPageRecRequestParam, ICallBackWsShieldSearchMainPageRec iCallBackWsShieldSearchMainPageRec) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsShieldSearchMainPageRec", GWsShieldSearchMainPageRecRequestParam.class, ICallBackWsShieldSearchMainPageRec.class);
            ICallBackWsShieldSearchMainPageRecImpl iCallBackWsShieldSearchMainPageRecImpl = null;
            if (iCallBackWsShieldSearchMainPageRec != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsShieldSearchMainPageRecImpl = (ICallBackWsShieldSearchMainPageRecImpl) typeHelper.transfer(method, 1, iCallBackWsShieldSearchMainPageRec);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsShieldSearchMainPageRec(gWsShieldSearchMainPageRecRequestParam, iCallBackWsShieldSearchMainPageRecImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqTripodCompany(GTripodCompanyRequestParam gTripodCompanyRequestParam, ICallBackTripodCompany iCallBackTripodCompany) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqTripodCompany", GTripodCompanyRequestParam.class, ICallBackTripodCompany.class);
            ICallBackTripodCompanyImpl iCallBackTripodCompanyImpl = null;
            if (iCallBackTripodCompany != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackTripodCompanyImpl = (ICallBackTripodCompanyImpl) typeHelper.transfer(method, 1, iCallBackTripodCompany);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqTripodCompany(gTripodCompanyRequestParam, iCallBackTripodCompanyImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqServerTimestamp(GServerTimestampRequestParam gServerTimestampRequestParam, ICallBackServerTimestamp iCallBackServerTimestamp) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqServerTimestamp", GServerTimestampRequestParam.class, ICallBackServerTimestamp.class);
            ICallBackServerTimestampImpl iCallBackServerTimestampImpl = null;
            if (iCallBackServerTimestamp != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackServerTimestampImpl = (ICallBackServerTimestampImpl) typeHelper.transfer(method, 1, iCallBackServerTimestamp);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqServerTimestamp(gServerTimestampRequestParam, iCallBackServerTimestampImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsFeedbackReviewGet(GWsFeedbackReviewGetRequestParam gWsFeedbackReviewGetRequestParam, ICallBackWsFeedbackReviewGet iCallBackWsFeedbackReviewGet) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsFeedbackReviewGet", GWsFeedbackReviewGetRequestParam.class, ICallBackWsFeedbackReviewGet.class);
            ICallBackWsFeedbackReviewGetImpl iCallBackWsFeedbackReviewGetImpl = null;
            if (iCallBackWsFeedbackReviewGet != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsFeedbackReviewGetImpl = (ICallBackWsFeedbackReviewGetImpl) typeHelper.transfer(method, 1, iCallBackWsFeedbackReviewGet);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsFeedbackReviewGet(gWsFeedbackReviewGetRequestParam, iCallBackWsFeedbackReviewGetImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsFeedbackReviewReport(GWsFeedbackReviewReportRequestParam gWsFeedbackReviewReportRequestParam, ICallBackWsFeedbackReviewReport iCallBackWsFeedbackReviewReport) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsFeedbackReviewReport", GWsFeedbackReviewReportRequestParam.class, ICallBackWsFeedbackReviewReport.class);
            ICallBackWsFeedbackReviewReportImpl iCallBackWsFeedbackReviewReportImpl = null;
            if (iCallBackWsFeedbackReviewReport != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsFeedbackReviewReportImpl = (ICallBackWsFeedbackReviewReportImpl) typeHelper.transfer(method, 1, iCallBackWsFeedbackReviewReport);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsFeedbackReviewReport(gWsFeedbackReviewReportRequestParam, iCallBackWsFeedbackReviewReportImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsUserviewFootprintSummary(GWsUserviewFootprintSummaryRequestParam gWsUserviewFootprintSummaryRequestParam, ICallBackWsUserviewFootprintSummary iCallBackWsUserviewFootprintSummary) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsUserviewFootprintSummary", GWsUserviewFootprintSummaryRequestParam.class, ICallBackWsUserviewFootprintSummary.class);
            ICallBackWsUserviewFootprintSummaryImpl iCallBackWsUserviewFootprintSummaryImpl = null;
            if (iCallBackWsUserviewFootprintSummary != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsUserviewFootprintSummaryImpl = (ICallBackWsUserviewFootprintSummaryImpl) typeHelper.transfer(method, 1, iCallBackWsUserviewFootprintSummary);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsUserviewFootprintSummary(gWsUserviewFootprintSummaryRequestParam, iCallBackWsUserviewFootprintSummaryImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsUserviewFootprintSwitch(GWsUserviewFootprintSwitchRequestParam gWsUserviewFootprintSwitchRequestParam, ICallBackWsUserviewFootprintSwitch iCallBackWsUserviewFootprintSwitch) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsUserviewFootprintSwitch", GWsUserviewFootprintSwitchRequestParam.class, ICallBackWsUserviewFootprintSwitch.class);
            ICallBackWsUserviewFootprintSwitchImpl iCallBackWsUserviewFootprintSwitchImpl = null;
            if (iCallBackWsUserviewFootprintSwitch != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsUserviewFootprintSwitchImpl = (ICallBackWsUserviewFootprintSwitchImpl) typeHelper.transfer(method, 1, iCallBackWsUserviewFootprintSwitch);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsUserviewFootprintSwitch(gWsUserviewFootprintSwitchRequestParam, iCallBackWsUserviewFootprintSwitchImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqImGetLoginToken(GImGetLoginTokenRequestParam gImGetLoginTokenRequestParam, ICallBackImGetLoginToken iCallBackImGetLoginToken) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqImGetLoginToken", GImGetLoginTokenRequestParam.class, ICallBackImGetLoginToken.class);
            ICallBackImGetLoginTokenImpl iCallBackImGetLoginTokenImpl = null;
            if (iCallBackImGetLoginToken != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackImGetLoginTokenImpl = (ICallBackImGetLoginTokenImpl) typeHelper.transfer(method, 1, iCallBackImGetLoginToken);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqImGetLoginToken(gImGetLoginTokenRequestParam, iCallBackImGetLoginTokenImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqImGetAppuid(GImGetAppuidRequestParam gImGetAppuidRequestParam, ICallBackImGetAppuid iCallBackImGetAppuid) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqImGetAppuid", GImGetAppuidRequestParam.class, ICallBackImGetAppuid.class);
            ICallBackImGetAppuidImpl iCallBackImGetAppuidImpl = null;
            if (iCallBackImGetAppuid != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackImGetAppuidImpl = (ICallBackImGetAppuidImpl) typeHelper.transfer(method, 1, iCallBackImGetAppuid);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqImGetAppuid(gImGetAppuidRequestParam, iCallBackImGetAppuidImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceInternalLinkCarGet(GWsTserviceInternalLinkCarGetRequestParam gWsTserviceInternalLinkCarGetRequestParam, ICallBackWsTserviceInternalLinkCarGet iCallBackWsTserviceInternalLinkCarGet) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceInternalLinkCarGet", GWsTserviceInternalLinkCarGetRequestParam.class, ICallBackWsTserviceInternalLinkCarGet.class);
            ICallBackWsTserviceInternalLinkCarGetImpl iCallBackWsTserviceInternalLinkCarGetImpl = null;
            if (iCallBackWsTserviceInternalLinkCarGet != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceInternalLinkCarGetImpl = (ICallBackWsTserviceInternalLinkCarGetImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceInternalLinkCarGet);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceInternalLinkCarGet(gWsTserviceInternalLinkCarGetRequestParam, iCallBackWsTserviceInternalLinkCarGetImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceInternalLinkCarReport(GWsTserviceInternalLinkCarReportRequestParam gWsTserviceInternalLinkCarReportRequestParam, ICallBackWsTserviceInternalLinkCarReport iCallBackWsTserviceInternalLinkCarReport) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceInternalLinkCarReport", GWsTserviceInternalLinkCarReportRequestParam.class, ICallBackWsTserviceInternalLinkCarReport.class);
            ICallBackWsTserviceInternalLinkCarReportImpl iCallBackWsTserviceInternalLinkCarReportImpl = null;
            if (iCallBackWsTserviceInternalLinkCarReport != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceInternalLinkCarReportImpl = (ICallBackWsTserviceInternalLinkCarReportImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceInternalLinkCarReport);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceInternalLinkCarReport(gWsTserviceInternalLinkCarReportRequestParam, iCallBackWsTserviceInternalLinkCarReportImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpAccountDeactivateHelp(GWsPpAccountDeactivateHelpRequestParam gWsPpAccountDeactivateHelpRequestParam, ICallBackWsPpAccountDeactivateHelp iCallBackWsPpAccountDeactivateHelp) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpAccountDeactivateHelp", GWsPpAccountDeactivateHelpRequestParam.class, ICallBackWsPpAccountDeactivateHelp.class);
            ICallBackWsPpAccountDeactivateHelpImpl iCallBackWsPpAccountDeactivateHelpImpl = null;
            if (iCallBackWsPpAccountDeactivateHelp != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsPpAccountDeactivateHelpImpl = (ICallBackWsPpAccountDeactivateHelpImpl) typeHelper.transfer(method, 1, iCallBackWsPpAccountDeactivateHelp);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpAccountDeactivateHelp(gWsPpAccountDeactivateHelpRequestParam, iCallBackWsPpAccountDeactivateHelpImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpAccountDeactivate(GWsPpAccountDeactivateRequestParam gWsPpAccountDeactivateRequestParam, ICallBackWsPpAccountDeactivate iCallBackWsPpAccountDeactivate) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpAccountDeactivate", GWsPpAccountDeactivateRequestParam.class, ICallBackWsPpAccountDeactivate.class);
            ICallBackWsPpAccountDeactivateImpl iCallBackWsPpAccountDeactivateImpl = null;
            if (iCallBackWsPpAccountDeactivate != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsPpAccountDeactivateImpl = (ICallBackWsPpAccountDeactivateImpl) typeHelper.transfer(method, 1, iCallBackWsPpAccountDeactivate);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpAccountDeactivate(gWsPpAccountDeactivateRequestParam, iCallBackWsPpAccountDeactivateImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceInternalLinkAutoReport(GWsTserviceInternalLinkAutoReportRequestParam gWsTserviceInternalLinkAutoReportRequestParam, ICallBackWsTserviceInternalLinkAutoReport iCallBackWsTserviceInternalLinkAutoReport) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceInternalLinkAutoReport", GWsTserviceInternalLinkAutoReportRequestParam.class, ICallBackWsTserviceInternalLinkAutoReport.class);
            ICallBackWsTserviceInternalLinkAutoReportImpl iCallBackWsTserviceInternalLinkAutoReportImpl = null;
            if (iCallBackWsTserviceInternalLinkAutoReport != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceInternalLinkAutoReportImpl = (ICallBackWsTserviceInternalLinkAutoReportImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceInternalLinkAutoReport);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceInternalLinkAutoReport(gWsTserviceInternalLinkAutoReportRequestParam, iCallBackWsTserviceInternalLinkAutoReportImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsMapapiLinkids(GWsMapapiLinkidsRequestParam gWsMapapiLinkidsRequestParam, ICallBackWsMapapiLinkids iCallBackWsMapapiLinkids) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsMapapiLinkids", GWsMapapiLinkidsRequestParam.class, ICallBackWsMapapiLinkids.class);
            ICallBackWsMapapiLinkidsImpl iCallBackWsMapapiLinkidsImpl = null;
            if (iCallBackWsMapapiLinkids != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsMapapiLinkidsImpl = (ICallBackWsMapapiLinkidsImpl) typeHelper.transfer(method, 1, iCallBackWsMapapiLinkids);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsMapapiLinkids(gWsMapapiLinkidsRequestParam, iCallBackWsMapapiLinkidsImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsMapapiRoad(GWsMapapiRoadRequestParam gWsMapapiRoadRequestParam, ICallBackWsMapapiRoad iCallBackWsMapapiRoad) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsMapapiRoad", GWsMapapiRoadRequestParam.class, ICallBackWsMapapiRoad.class);
            ICallBackWsMapapiRoadImpl iCallBackWsMapapiRoadImpl = null;
            if (iCallBackWsMapapiRoad != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsMapapiRoadImpl = (ICallBackWsMapapiRoadImpl) typeHelper.transfer(method, 1, iCallBackWsMapapiRoad);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsMapapiRoad(gWsMapapiRoadRequestParam, iCallBackWsMapapiRoadImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsEventSearch(GWsEventSearchRequestParam gWsEventSearchRequestParam, ICallBackWsEventSearch iCallBackWsEventSearch) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsEventSearch", GWsEventSearchRequestParam.class, ICallBackWsEventSearch.class);
            ICallBackWsEventSearchImpl iCallBackWsEventSearchImpl = null;
            if (iCallBackWsEventSearch != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsEventSearchImpl = (ICallBackWsEventSearchImpl) typeHelper.transfer(method, 1, iCallBackWsEventSearch);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsEventSearch(gWsEventSearchRequestParam, iCallBackWsEventSearchImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsChargeList(GWsChargeListRequestParam gWsChargeListRequestParam, ICallBackWsChargeList iCallBackWsChargeList) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsChargeList", GWsChargeListRequestParam.class, ICallBackWsChargeList.class);
            ICallBackWsChargeListImpl iCallBackWsChargeListImpl = null;
            if (iCallBackWsChargeList != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsChargeListImpl = (ICallBackWsChargeListImpl) typeHelper.transfer(method, 1, iCallBackWsChargeList);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsChargeList(gWsChargeListRequestParam, iCallBackWsChargeListImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsSdsFiles(GWsSdsFilesRequestParam gWsSdsFilesRequestParam, ICallBackWsSdsFiles iCallBackWsSdsFiles) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsSdsFiles", GWsSdsFilesRequestParam.class, ICallBackWsSdsFiles.class);
            ICallBackWsSdsFilesImpl iCallBackWsSdsFilesImpl = null;
            if (iCallBackWsSdsFiles != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsSdsFilesImpl = (ICallBackWsSdsFilesImpl) typeHelper.transfer(method, 1, iCallBackWsSdsFiles);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsSdsFiles(gWsSdsFilesRequestParam, iCallBackWsSdsFilesImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsUserviewFootprintNaviDelete(GWsUserviewFootprintNaviDeleteRequestParam gWsUserviewFootprintNaviDeleteRequestParam, ICallBackWsUserviewFootprintNaviDelete iCallBackWsUserviewFootprintNaviDelete) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsUserviewFootprintNaviDelete", GWsUserviewFootprintNaviDeleteRequestParam.class, ICallBackWsUserviewFootprintNaviDelete.class);
            ICallBackWsUserviewFootprintNaviDeleteImpl iCallBackWsUserviewFootprintNaviDeleteImpl = null;
            if (iCallBackWsUserviewFootprintNaviDelete != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsUserviewFootprintNaviDeleteImpl = (ICallBackWsUserviewFootprintNaviDeleteImpl) typeHelper.transfer(method, 1, iCallBackWsUserviewFootprintNaviDelete);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsUserviewFootprintNaviDelete(gWsUserviewFootprintNaviDeleteRequestParam, iCallBackWsUserviewFootprintNaviDeleteImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsUserviewFootprintNaviRecord(GWsUserviewFootprintNaviRecordRequestParam gWsUserviewFootprintNaviRecordRequestParam, ICallBackWsUserviewFootprintNaviRecord iCallBackWsUserviewFootprintNaviRecord) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsUserviewFootprintNaviRecord", GWsUserviewFootprintNaviRecordRequestParam.class, ICallBackWsUserviewFootprintNaviRecord.class);
            ICallBackWsUserviewFootprintNaviRecordImpl iCallBackWsUserviewFootprintNaviRecordImpl = null;
            if (iCallBackWsUserviewFootprintNaviRecord != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsUserviewFootprintNaviRecordImpl = (ICallBackWsUserviewFootprintNaviRecordImpl) typeHelper.transfer(method, 1, iCallBackWsUserviewFootprintNaviRecord);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsUserviewFootprintNaviRecord(gWsUserviewFootprintNaviRecordRequestParam, iCallBackWsUserviewFootprintNaviRecordImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsNavigationDynamicData(GWsNavigationDynamicDataRequestParam gWsNavigationDynamicDataRequestParam, ICallBackWsNavigationDynamicData iCallBackWsNavigationDynamicData) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsNavigationDynamicData", GWsNavigationDynamicDataRequestParam.class, ICallBackWsNavigationDynamicData.class);
            ICallBackWsNavigationDynamicDataImpl iCallBackWsNavigationDynamicDataImpl = null;
            if (iCallBackWsNavigationDynamicData != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsNavigationDynamicDataImpl = (ICallBackWsNavigationDynamicDataImpl) typeHelper.transfer(method, 1, iCallBackWsNavigationDynamicData);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsNavigationDynamicData(gWsNavigationDynamicDataRequestParam, iCallBackWsNavigationDynamicDataImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsNavigationDynamicFatigue(GWsNavigationDynamicFatigueRequestParam gWsNavigationDynamicFatigueRequestParam, ICallBackWsNavigationDynamicFatigue iCallBackWsNavigationDynamicFatigue) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsNavigationDynamicFatigue", GWsNavigationDynamicFatigueRequestParam.class, ICallBackWsNavigationDynamicFatigue.class);
            ICallBackWsNavigationDynamicFatigueImpl iCallBackWsNavigationDynamicFatigueImpl = null;
            if (iCallBackWsNavigationDynamicFatigue != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsNavigationDynamicFatigueImpl = (ICallBackWsNavigationDynamicFatigueImpl) typeHelper.transfer(method, 1, iCallBackWsNavigationDynamicFatigue);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsNavigationDynamicFatigue(gWsNavigationDynamicFatigueRequestParam, iCallBackWsNavigationDynamicFatigueImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @Deprecated
    public long sendReqCouponrecvapply(GCouponrecvapplyRequestParam gCouponrecvapplyRequestParam, ICallBackCouponrecvapply iCallBackCouponrecvapply) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqCouponrecvapply", GCouponrecvapplyRequestParam.class, ICallBackCouponrecvapply.class);
            ICallBackCouponrecvapplyImpl iCallBackCouponrecvapplyImpl = null;
            if (iCallBackCouponrecvapply != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackCouponrecvapplyImpl = (ICallBackCouponrecvapplyImpl) typeHelper.transfer(method, 1, iCallBackCouponrecvapply);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqCouponrecvapply(gCouponrecvapplyRequestParam, iCallBackCouponrecvapplyImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @Deprecated
    public long sendReqCouponrecvlist(GCouponrecvlistRequestParam gCouponrecvlistRequestParam, ICallBackCouponrecvlist iCallBackCouponrecvlist) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqCouponrecvlist", GCouponrecvlistRequestParam.class, ICallBackCouponrecvlist.class);
            ICallBackCouponrecvlistImpl iCallBackCouponrecvlistImpl = null;
            if (iCallBackCouponrecvlist != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackCouponrecvlistImpl = (ICallBackCouponrecvlistImpl) typeHelper.transfer(method, 1, iCallBackCouponrecvlist);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqCouponrecvlist(gCouponrecvlistRequestParam, iCallBackCouponrecvlistImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @Deprecated
    public long sendReqWsTcFuelCancel(GWsTcFuelCancelRequestParam gWsTcFuelCancelRequestParam, ICallBackWsTcFuelCancel iCallBackWsTcFuelCancel) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcFuelCancel", GWsTcFuelCancelRequestParam.class, ICallBackWsTcFuelCancel.class);
            ICallBackWsTcFuelCancelImpl iCallBackWsTcFuelCancelImpl = null;
            if (iCallBackWsTcFuelCancel != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTcFuelCancelImpl = (ICallBackWsTcFuelCancelImpl) typeHelper.transfer(method, 1, iCallBackWsTcFuelCancel);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcFuelCancel(gWsTcFuelCancelRequestParam, iCallBackWsTcFuelCancelImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @Deprecated
    public long sendReqWsTcFuelCreate(GWsTcFuelCreateRequestParam gWsTcFuelCreateRequestParam, ICallBackWsTcFuelCreate iCallBackWsTcFuelCreate) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcFuelCreate", GWsTcFuelCreateRequestParam.class, ICallBackWsTcFuelCreate.class);
            ICallBackWsTcFuelCreateImpl iCallBackWsTcFuelCreateImpl = null;
            if (iCallBackWsTcFuelCreate != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTcFuelCreateImpl = (ICallBackWsTcFuelCreateImpl) typeHelper.transfer(method, 1, iCallBackWsTcFuelCreate);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcFuelCreate(gWsTcFuelCreateRequestParam, iCallBackWsTcFuelCreateImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @Deprecated
    public long sendReqWsTcFuelGetwaitingpayorders(GWsTcFuelGetwaitingpayordersRequestParam gWsTcFuelGetwaitingpayordersRequestParam, ICallBackWsTcFuelGetwaitingpayorders iCallBackWsTcFuelGetwaitingpayorders) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcFuelGetwaitingpayorders", GWsTcFuelGetwaitingpayordersRequestParam.class, ICallBackWsTcFuelGetwaitingpayorders.class);
            ICallBackWsTcFuelGetwaitingpayordersImpl iCallBackWsTcFuelGetwaitingpayordersImpl = null;
            if (iCallBackWsTcFuelGetwaitingpayorders != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTcFuelGetwaitingpayordersImpl = (ICallBackWsTcFuelGetwaitingpayordersImpl) typeHelper.transfer(method, 1, iCallBackWsTcFuelGetwaitingpayorders);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcFuelGetwaitingpayorders(gWsTcFuelGetwaitingpayordersRequestParam, iCallBackWsTcFuelGetwaitingpayordersImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @Deprecated
    public long sendReqWsTcOrderDetail(GWsTcOrderDetailRequestParam gWsTcOrderDetailRequestParam, ICallBackWsTcOrderDetail iCallBackWsTcOrderDetail) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcOrderDetail", GWsTcOrderDetailRequestParam.class, ICallBackWsTcOrderDetail.class);
            ICallBackWsTcOrderDetailImpl iCallBackWsTcOrderDetailImpl = null;
            if (iCallBackWsTcOrderDetail != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTcOrderDetailImpl = (ICallBackWsTcOrderDetailImpl) typeHelper.transfer(method, 1, iCallBackWsTcOrderDetail);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcOrderDetail(gWsTcOrderDetailRequestParam, iCallBackWsTcOrderDetailImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @Deprecated
    public long sendReqGasstationcalprice(GGasstationcalpriceRequestParam gGasstationcalpriceRequestParam, ICallBackGasstationcalprice iCallBackGasstationcalprice) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqGasstationcalprice", GGasstationcalpriceRequestParam.class, ICallBackGasstationcalprice.class);
            ICallBackGasstationcalpriceImpl iCallBackGasstationcalpriceImpl = null;
            if (iCallBackGasstationcalprice != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackGasstationcalpriceImpl = (ICallBackGasstationcalpriceImpl) typeHelper.transfer(method, 1, iCallBackGasstationcalprice);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqGasstationcalprice(gGasstationcalpriceRequestParam, iCallBackGasstationcalpriceImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsShieldSearchRanklistCity(GWsShieldSearchRanklistCityRequestParam gWsShieldSearchRanklistCityRequestParam, ICallBackWsShieldSearchRanklistCity iCallBackWsShieldSearchRanklistCity) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsShieldSearchRanklistCity", GWsShieldSearchRanklistCityRequestParam.class, ICallBackWsShieldSearchRanklistCity.class);
            ICallBackWsShieldSearchRanklistCityImpl iCallBackWsShieldSearchRanklistCityImpl = null;
            if (iCallBackWsShieldSearchRanklistCity != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsShieldSearchRanklistCityImpl = (ICallBackWsShieldSearchRanklistCityImpl) typeHelper.transfer(method, 1, iCallBackWsShieldSearchRanklistCity);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsShieldSearchRanklistCity(gWsShieldSearchRanklistCityRequestParam, iCallBackWsShieldSearchRanklistCityImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsShieldSearchRanklistLanding(GWsShieldSearchRanklistLandingRequestParam gWsShieldSearchRanklistLandingRequestParam, ICallBackWsShieldSearchRanklistLanding iCallBackWsShieldSearchRanklistLanding) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsShieldSearchRanklistLanding", GWsShieldSearchRanklistLandingRequestParam.class, ICallBackWsShieldSearchRanklistLanding.class);
            ICallBackWsShieldSearchRanklistLandingImpl iCallBackWsShieldSearchRanklistLandingImpl = null;
            if (iCallBackWsShieldSearchRanklistLanding != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsShieldSearchRanklistLandingImpl = (ICallBackWsShieldSearchRanklistLandingImpl) typeHelper.transfer(method, 1, iCallBackWsShieldSearchRanklistLanding);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsShieldSearchRanklistLanding(gWsShieldSearchRanklistLandingRequestParam, iCallBackWsShieldSearchRanklistLandingImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsShieldSearchRanklistPortal(GWsShieldSearchRanklistPortalRequestParam gWsShieldSearchRanklistPortalRequestParam, ICallBackWsShieldSearchRanklistPortal iCallBackWsShieldSearchRanklistPortal) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsShieldSearchRanklistPortal", GWsShieldSearchRanklistPortalRequestParam.class, ICallBackWsShieldSearchRanklistPortal.class);
            ICallBackWsShieldSearchRanklistPortalImpl iCallBackWsShieldSearchRanklistPortalImpl = null;
            if (iCallBackWsShieldSearchRanklistPortal != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsShieldSearchRanklistPortalImpl = (ICallBackWsShieldSearchRanklistPortalImpl) typeHelper.transfer(method, 1, iCallBackWsShieldSearchRanklistPortal);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsShieldSearchRanklistPortal(gWsShieldSearchRanklistPortalRequestParam, iCallBackWsShieldSearchRanklistPortalImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @Deprecated
    public long sendReqWsIcsLifeUserCouponList(GWsIcsLifeUserCouponListRequestParam gWsIcsLifeUserCouponListRequestParam, ICallBackWsIcsLifeUserCouponList iCallBackWsIcsLifeUserCouponList) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsIcsLifeUserCouponList", GWsIcsLifeUserCouponListRequestParam.class, ICallBackWsIcsLifeUserCouponList.class);
            ICallBackWsIcsLifeUserCouponListImpl iCallBackWsIcsLifeUserCouponListImpl = null;
            if (iCallBackWsIcsLifeUserCouponList != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsIcsLifeUserCouponListImpl = (ICallBackWsIcsLifeUserCouponListImpl) typeHelper.transfer(method, 1, iCallBackWsIcsLifeUserCouponList);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsIcsLifeUserCouponList(gWsIcsLifeUserCouponListRequestParam, iCallBackWsIcsLifeUserCouponListImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @Deprecated
    public long sendReqWsIcsLifeCouponOptions(GWsIcsLifeCouponOptionsRequestParam gWsIcsLifeCouponOptionsRequestParam, ICallBackWsIcsLifeCouponOptions iCallBackWsIcsLifeCouponOptions) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsIcsLifeCouponOptions", GWsIcsLifeCouponOptionsRequestParam.class, ICallBackWsIcsLifeCouponOptions.class);
            ICallBackWsIcsLifeCouponOptionsImpl iCallBackWsIcsLifeCouponOptionsImpl = null;
            if (iCallBackWsIcsLifeCouponOptions != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsIcsLifeCouponOptionsImpl = (ICallBackWsIcsLifeCouponOptionsImpl) typeHelper.transfer(method, 1, iCallBackWsIcsLifeCouponOptions);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsIcsLifeCouponOptions(gWsIcsLifeCouponOptionsRequestParam, iCallBackWsIcsLifeCouponOptionsImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @Deprecated
    public long sendReqWsTcOrderList(GWsTcOrderListRequestParam gWsTcOrderListRequestParam, ICallBackWsTcOrderList iCallBackWsTcOrderList) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcOrderList", GWsTcOrderListRequestParam.class, ICallBackWsTcOrderList.class);
            ICallBackWsTcOrderListImpl iCallBackWsTcOrderListImpl = null;
            if (iCallBackWsTcOrderList != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTcOrderListImpl = (ICallBackWsTcOrderListImpl) typeHelper.transfer(method, 1, iCallBackWsTcOrderList);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcOrderList(gWsTcOrderListRequestParam, iCallBackWsTcOrderListImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqLbpEventSyncCommon(GLbpEventSyncCommonRequestParam gLbpEventSyncCommonRequestParam, ICallBackLbpEventSyncCommon iCallBackLbpEventSyncCommon) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqLbpEventSyncCommon", GLbpEventSyncCommonRequestParam.class, ICallBackLbpEventSyncCommon.class);
            ICallBackLbpEventSyncCommonImpl iCallBackLbpEventSyncCommonImpl = null;
            if (iCallBackLbpEventSyncCommon != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackLbpEventSyncCommonImpl = (ICallBackLbpEventSyncCommonImpl) typeHelper.transfer(method, 1, iCallBackLbpEventSyncCommon);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqLbpEventSyncCommon(gLbpEventSyncCommonRequestParam, iCallBackLbpEventSyncCommonImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTcFuelQueryagreement(GWsTcFuelQueryagreementRequestParam gWsTcFuelQueryagreementRequestParam, ICallBackWsTcFuelQueryagreement iCallBackWsTcFuelQueryagreement) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcFuelQueryagreement", GWsTcFuelQueryagreementRequestParam.class, ICallBackWsTcFuelQueryagreement.class);
            ICallBackWsTcFuelQueryagreementImpl iCallBackWsTcFuelQueryagreementImpl = null;
            if (iCallBackWsTcFuelQueryagreement != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTcFuelQueryagreementImpl = (ICallBackWsTcFuelQueryagreementImpl) typeHelper.transfer(method, 1, iCallBackWsTcFuelQueryagreement);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcFuelQueryagreement(gWsTcFuelQueryagreementRequestParam, iCallBackWsTcFuelQueryagreementImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsShieldImMsgCommentSet(GWsShieldImMsgCommentSetRequestParam gWsShieldImMsgCommentSetRequestParam, ICallBackWsShieldImMsgCommentSet iCallBackWsShieldImMsgCommentSet) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsShieldImMsgCommentSet", GWsShieldImMsgCommentSetRequestParam.class, ICallBackWsShieldImMsgCommentSet.class);
            ICallBackWsShieldImMsgCommentSetImpl iCallBackWsShieldImMsgCommentSetImpl = null;
            if (iCallBackWsShieldImMsgCommentSet != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsShieldImMsgCommentSetImpl = (ICallBackWsShieldImMsgCommentSetImpl) typeHelper.transfer(method, 1, iCallBackWsShieldImMsgCommentSet);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsShieldImMsgCommentSet(gWsShieldImMsgCommentSetRequestParam, iCallBackWsShieldImMsgCommentSetImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsDynamicInfoEventPraiseStampStatusQuery(GWsDynamicInfoEventPraiseStampStatusQueryRequestParam gWsDynamicInfoEventPraiseStampStatusQueryRequestParam, ICallBackWsDynamicInfoEventPraiseStampStatusQuery iCallBackWsDynamicInfoEventPraiseStampStatusQuery) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsDynamicInfoEventPraiseStampStatusQuery", GWsDynamicInfoEventPraiseStampStatusQueryRequestParam.class, ICallBackWsDynamicInfoEventPraiseStampStatusQuery.class);
            ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl iCallBackWsDynamicInfoEventPraiseStampStatusQueryImpl = null;
            if (iCallBackWsDynamicInfoEventPraiseStampStatusQuery != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsDynamicInfoEventPraiseStampStatusQueryImpl = (ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl) typeHelper.transfer(method, 1, iCallBackWsDynamicInfoEventPraiseStampStatusQuery);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsDynamicInfoEventPraiseStampStatusQuery(gWsDynamicInfoEventPraiseStampStatusQueryRequestParam, iCallBackWsDynamicInfoEventPraiseStampStatusQueryImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsDynamicInfoCongestionGroupChatUserAddV3(GWsDynamicInfoCongestionGroupChatUserAddV3RequestParam gWsDynamicInfoCongestionGroupChatUserAddV3RequestParam, ICallBackWsDynamicInfoCongestionGroupChatUserAddV3 iCallBackWsDynamicInfoCongestionGroupChatUserAddV3) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsDynamicInfoCongestionGroupChatUserAddV3", GWsDynamicInfoCongestionGroupChatUserAddV3RequestParam.class, ICallBackWsDynamicInfoCongestionGroupChatUserAddV3.class);
            ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl iCallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl = null;
            if (iCallBackWsDynamicInfoCongestionGroupChatUserAddV3 != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl = (ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl) typeHelper.transfer(method, 1, iCallBackWsDynamicInfoCongestionGroupChatUserAddV3);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsDynamicInfoCongestionGroupChatUserAddV3(gWsDynamicInfoCongestionGroupChatUserAddV3RequestParam, iCallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsDynamicInfoCongestionGroupChatUserRemove(GWsDynamicInfoCongestionGroupChatUserRemoveRequestParam gWsDynamicInfoCongestionGroupChatUserRemoveRequestParam, ICallBackWsDynamicInfoCongestionGroupChatUserRemove iCallBackWsDynamicInfoCongestionGroupChatUserRemove) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsDynamicInfoCongestionGroupChatUserRemove", GWsDynamicInfoCongestionGroupChatUserRemoveRequestParam.class, ICallBackWsDynamicInfoCongestionGroupChatUserRemove.class);
            ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl iCallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl = null;
            if (iCallBackWsDynamicInfoCongestionGroupChatUserRemove != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl = (ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl) typeHelper.transfer(method, 1, iCallBackWsDynamicInfoCongestionGroupChatUserRemove);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsDynamicInfoCongestionGroupChatUserRemove(gWsDynamicInfoCongestionGroupChatUserRemoveRequestParam, iCallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @Deprecated
    public long sendReqWsTcCommonAgreementStatus(GWsTcCommonAgreementStatusRequestParam gWsTcCommonAgreementStatusRequestParam, ICallBackWsTcCommonAgreementStatus iCallBackWsTcCommonAgreementStatus) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcCommonAgreementStatus", GWsTcCommonAgreementStatusRequestParam.class, ICallBackWsTcCommonAgreementStatus.class);
            ICallBackWsTcCommonAgreementStatusImpl iCallBackWsTcCommonAgreementStatusImpl = null;
            if (iCallBackWsTcCommonAgreementStatus != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTcCommonAgreementStatusImpl = (ICallBackWsTcCommonAgreementStatusImpl) typeHelper.transfer(method, 1, iCallBackWsTcCommonAgreementStatus);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcCommonAgreementStatus(gWsTcCommonAgreementStatusRequestParam, iCallBackWsTcCommonAgreementStatusImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsFencingGroupsQuery(GWsFencingGroupsQueryRequestParam gWsFencingGroupsQueryRequestParam, ICallBackWsFencingGroupsQuery iCallBackWsFencingGroupsQuery) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsFencingGroupsQuery", GWsFencingGroupsQueryRequestParam.class, ICallBackWsFencingGroupsQuery.class);
            ICallBackWsFencingGroupsQueryImpl iCallBackWsFencingGroupsQueryImpl = null;
            if (iCallBackWsFencingGroupsQuery != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsFencingGroupsQueryImpl = (ICallBackWsFencingGroupsQueryImpl) typeHelper.transfer(method, 1, iCallBackWsFencingGroupsQuery);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsFencingGroupsQuery(gWsFencingGroupsQueryRequestParam, iCallBackWsFencingGroupsQueryImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsFencingFencesQuery(GWsFencingFencesQueryRequestParam gWsFencingFencesQueryRequestParam, ICallBackWsFencingFencesQuery iCallBackWsFencingFencesQuery) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsFencingFencesQuery", GWsFencingFencesQueryRequestParam.class, ICallBackWsFencingFencesQuery.class);
            ICallBackWsFencingFencesQueryImpl iCallBackWsFencingFencesQueryImpl = null;
            if (iCallBackWsFencingFencesQuery != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsFencingFencesQueryImpl = (ICallBackWsFencingFencesQueryImpl) typeHelper.transfer(method, 1, iCallBackWsFencingFencesQuery);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsFencingFencesQuery(gWsFencingFencesQueryRequestParam, iCallBackWsFencingFencesQueryImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsAosDestinationSearch(GWsAosDestinationSearchRequestParam gWsAosDestinationSearchRequestParam, ICallBackWsAosDestinationSearch iCallBackWsAosDestinationSearch) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsAosDestinationSearch", GWsAosDestinationSearchRequestParam.class, ICallBackWsAosDestinationSearch.class);
            ICallBackWsAosDestinationSearchImpl iCallBackWsAosDestinationSearchImpl = null;
            if (iCallBackWsAosDestinationSearch != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsAosDestinationSearchImpl = (ICallBackWsAosDestinationSearchImpl) typeHelper.transfer(method, 1, iCallBackWsAosDestinationSearch);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsAosDestinationSearch(gWsAosDestinationSearchRequestParam, iCallBackWsAosDestinationSearchImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTcCommonAgreementSign(GWsTcCommonAgreementSignRequestParam gWsTcCommonAgreementSignRequestParam, ICallBackWsTcCommonAgreementSign iCallBackWsTcCommonAgreementSign) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcCommonAgreementSign", GWsTcCommonAgreementSignRequestParam.class, ICallBackWsTcCommonAgreementSign.class);
            ICallBackWsTcCommonAgreementSignImpl iCallBackWsTcCommonAgreementSignImpl = null;
            if (iCallBackWsTcCommonAgreementSign != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTcCommonAgreementSignImpl = (ICallBackWsTcCommonAgreementSignImpl) typeHelper.transfer(method, 1, iCallBackWsTcCommonAgreementSign);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcCommonAgreementSign(gWsTcCommonAgreementSignRequestParam, iCallBackWsTcCommonAgreementSignImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTcCommonAgreementOrderquickpay(GWsTcCommonAgreementOrderquickpayRequestParam gWsTcCommonAgreementOrderquickpayRequestParam, ICallBackWsTcCommonAgreementOrderquickpay iCallBackWsTcCommonAgreementOrderquickpay) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcCommonAgreementOrderquickpay", GWsTcCommonAgreementOrderquickpayRequestParam.class, ICallBackWsTcCommonAgreementOrderquickpay.class);
            ICallBackWsTcCommonAgreementOrderquickpayImpl iCallBackWsTcCommonAgreementOrderquickpayImpl = null;
            if (iCallBackWsTcCommonAgreementOrderquickpay != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTcCommonAgreementOrderquickpayImpl = (ICallBackWsTcCommonAgreementOrderquickpayImpl) typeHelper.transfer(method, 1, iCallBackWsTcCommonAgreementOrderquickpay);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcCommonAgreementOrderquickpay(gWsTcCommonAgreementOrderquickpayRequestParam, iCallBackWsTcCommonAgreementOrderquickpayImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpQrcodeInnerGet(GWsPpQrcodeInnerGetRequestParam gWsPpQrcodeInnerGetRequestParam, ICallBackWsPpQrcodeInnerGet iCallBackWsPpQrcodeInnerGet) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpQrcodeInnerGet", GWsPpQrcodeInnerGetRequestParam.class, ICallBackWsPpQrcodeInnerGet.class);
            ICallBackWsPpQrcodeInnerGetImpl iCallBackWsPpQrcodeInnerGetImpl = null;
            if (iCallBackWsPpQrcodeInnerGet != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsPpQrcodeInnerGetImpl = (ICallBackWsPpQrcodeInnerGetImpl) typeHelper.transfer(method, 1, iCallBackWsPpQrcodeInnerGet);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpQrcodeInnerGet(gWsPpQrcodeInnerGetRequestParam, iCallBackWsPpQrcodeInnerGetImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsCommerceInfraChargeRecordsWaitingEnable(GWsCommerceInfraChargeRecordsWaitingEnableRequestParam gWsCommerceInfraChargeRecordsWaitingEnableRequestParam, ICallBackWsCommerceInfraChargeRecordsWaitingEnable iCallBackWsCommerceInfraChargeRecordsWaitingEnable) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsCommerceInfraChargeRecordsWaitingEnable", GWsCommerceInfraChargeRecordsWaitingEnableRequestParam.class, ICallBackWsCommerceInfraChargeRecordsWaitingEnable.class);
            ICallBackWsCommerceInfraChargeRecordsWaitingEnableImpl iCallBackWsCommerceInfraChargeRecordsWaitingEnableImpl = null;
            if (iCallBackWsCommerceInfraChargeRecordsWaitingEnable != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsCommerceInfraChargeRecordsWaitingEnableImpl = (ICallBackWsCommerceInfraChargeRecordsWaitingEnableImpl) typeHelper.transfer(method, 1, iCallBackWsCommerceInfraChargeRecordsWaitingEnable);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsCommerceInfraChargeRecordsWaitingEnable(gWsCommerceInfraChargeRecordsWaitingEnableRequestParam, iCallBackWsCommerceInfraChargeRecordsWaitingEnableImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsAuthcarServiceEnable(GWsAuthcarServiceEnableRequestParam gWsAuthcarServiceEnableRequestParam, ICallBackWsAuthcarServiceEnable iCallBackWsAuthcarServiceEnable) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsAuthcarServiceEnable", GWsAuthcarServiceEnableRequestParam.class, ICallBackWsAuthcarServiceEnable.class);
            ICallBackWsAuthcarServiceEnableImpl iCallBackWsAuthcarServiceEnableImpl = null;
            if (iCallBackWsAuthcarServiceEnable != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsAuthcarServiceEnableImpl = (ICallBackWsAuthcarServiceEnableImpl) typeHelper.transfer(method, 1, iCallBackWsAuthcarServiceEnable);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsAuthcarServiceEnable(gWsAuthcarServiceEnableRequestParam, iCallBackWsAuthcarServiceEnableImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTcCarServiceOrderCancel(GWsTcCarServiceOrderCancelRequestParam gWsTcCarServiceOrderCancelRequestParam, ICallBackWsTcCarServiceOrderCancel iCallBackWsTcCarServiceOrderCancel) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcCarServiceOrderCancel", GWsTcCarServiceOrderCancelRequestParam.class, ICallBackWsTcCarServiceOrderCancel.class);
            ICallBackWsTcCarServiceOrderCancelImpl iCallBackWsTcCarServiceOrderCancelImpl = null;
            if (iCallBackWsTcCarServiceOrderCancel != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTcCarServiceOrderCancelImpl = (ICallBackWsTcCarServiceOrderCancelImpl) typeHelper.transfer(method, 1, iCallBackWsTcCarServiceOrderCancel);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcCarServiceOrderCancel(gWsTcCarServiceOrderCancelRequestParam, iCallBackWsTcCarServiceOrderCancelImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @Deprecated
    public long sendReqWsMiniappCarVipGw(GWsMiniappCarVipGwRequestParam gWsMiniappCarVipGwRequestParam, ICallBackWsMiniappCarVipGw iCallBackWsMiniappCarVipGw) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsMiniappCarVipGw", GWsMiniappCarVipGwRequestParam.class, ICallBackWsMiniappCarVipGw.class);
            ICallBackWsMiniappCarVipGwImpl iCallBackWsMiniappCarVipGwImpl = null;
            if (iCallBackWsMiniappCarVipGw != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsMiniappCarVipGwImpl = (ICallBackWsMiniappCarVipGwImpl) typeHelper.transfer(method, 1, iCallBackWsMiniappCarVipGw);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsMiniappCarVipGw(gWsMiniappCarVipGwRequestParam, iCallBackWsMiniappCarVipGwImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTcCarServiceSubmit(GWsTcCarServiceSubmitRequestParam gWsTcCarServiceSubmitRequestParam, ICallBackWsTcCarServiceSubmit iCallBackWsTcCarServiceSubmit) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcCarServiceSubmit", GWsTcCarServiceSubmitRequestParam.class, ICallBackWsTcCarServiceSubmit.class);
            ICallBackWsTcCarServiceSubmitImpl iCallBackWsTcCarServiceSubmitImpl = null;
            if (iCallBackWsTcCarServiceSubmit != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTcCarServiceSubmitImpl = (ICallBackWsTcCarServiceSubmitImpl) typeHelper.transfer(method, 1, iCallBackWsTcCarServiceSubmit);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcCarServiceSubmit(gWsTcCarServiceSubmitRequestParam, iCallBackWsTcCarServiceSubmitImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @Deprecated
    public long sendReqWsSearchPoiAutoCmallFillOrder(GWsSearchPoiAutoCmallFillOrderRequestParam gWsSearchPoiAutoCmallFillOrderRequestParam, ICallBackWsSearchPoiAutoCmallFillOrder iCallBackWsSearchPoiAutoCmallFillOrder) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsSearchPoiAutoCmallFillOrder", GWsSearchPoiAutoCmallFillOrderRequestParam.class, ICallBackWsSearchPoiAutoCmallFillOrder.class);
            ICallBackWsSearchPoiAutoCmallFillOrderImpl iCallBackWsSearchPoiAutoCmallFillOrderImpl = null;
            if (iCallBackWsSearchPoiAutoCmallFillOrder != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsSearchPoiAutoCmallFillOrderImpl = (ICallBackWsSearchPoiAutoCmallFillOrderImpl) typeHelper.transfer(method, 1, iCallBackWsSearchPoiAutoCmallFillOrder);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsSearchPoiAutoCmallFillOrder(gWsSearchPoiAutoCmallFillOrderRequestParam, iCallBackWsSearchPoiAutoCmallFillOrderImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @Deprecated
    public long sendReqWsTcAlscOrderCancel(GWsTcAlscOrderCancelRequestParam gWsTcAlscOrderCancelRequestParam, ICallBackWsTcAlscOrderCancel iCallBackWsTcAlscOrderCancel) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcAlscOrderCancel", GWsTcAlscOrderCancelRequestParam.class, ICallBackWsTcAlscOrderCancel.class);
            ICallBackWsTcAlscOrderCancelImpl iCallBackWsTcAlscOrderCancelImpl = null;
            if (iCallBackWsTcAlscOrderCancel != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTcAlscOrderCancelImpl = (ICallBackWsTcAlscOrderCancelImpl) typeHelper.transfer(method, 1, iCallBackWsTcAlscOrderCancel);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcAlscOrderCancel(gWsTcAlscOrderCancelRequestParam, iCallBackWsTcAlscOrderCancelImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @Deprecated
    public long sendReqWsTcOrderApiMergeList(GWsTcOrderApiMergeListRequestParam gWsTcOrderApiMergeListRequestParam, ICallBackWsTcOrderApiMergeList iCallBackWsTcOrderApiMergeList) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcOrderApiMergeList", GWsTcOrderApiMergeListRequestParam.class, ICallBackWsTcOrderApiMergeList.class);
            ICallBackWsTcOrderApiMergeListImpl iCallBackWsTcOrderApiMergeListImpl = null;
            if (iCallBackWsTcOrderApiMergeList != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTcOrderApiMergeListImpl = (ICallBackWsTcOrderApiMergeListImpl) typeHelper.transfer(method, 1, iCallBackWsTcOrderApiMergeList);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcOrderApiMergeList(gWsTcOrderApiMergeListRequestParam, iCallBackWsTcOrderApiMergeListImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @Deprecated
    public long sendReqWsTcKoubeiOrderSubmit(GWsTcKoubeiOrderSubmitRequestParam gWsTcKoubeiOrderSubmitRequestParam, ICallBackWsTcKoubeiOrderSubmit iCallBackWsTcKoubeiOrderSubmit) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcKoubeiOrderSubmit", GWsTcKoubeiOrderSubmitRequestParam.class, ICallBackWsTcKoubeiOrderSubmit.class);
            ICallBackWsTcKoubeiOrderSubmitImpl iCallBackWsTcKoubeiOrderSubmitImpl = null;
            if (iCallBackWsTcKoubeiOrderSubmit != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTcKoubeiOrderSubmitImpl = (ICallBackWsTcKoubeiOrderSubmitImpl) typeHelper.transfer(method, 1, iCallBackWsTcKoubeiOrderSubmit);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcKoubeiOrderSubmit(gWsTcKoubeiOrderSubmitRequestParam, iCallBackWsTcKoubeiOrderSubmitImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTcPoiInfo(GWsTcPoiInfoRequestParam gWsTcPoiInfoRequestParam, ICallBackWsTcPoiInfo iCallBackWsTcPoiInfo) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTcPoiInfo", GWsTcPoiInfoRequestParam.class, ICallBackWsTcPoiInfo.class);
            ICallBackWsTcPoiInfoImpl iCallBackWsTcPoiInfoImpl = null;
            if (iCallBackWsTcPoiInfo != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTcPoiInfoImpl = (ICallBackWsTcPoiInfoImpl) typeHelper.transfer(method, 1, iCallBackWsTcPoiInfo);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTcPoiInfo(gWsTcPoiInfoRequestParam, iCallBackWsTcPoiInfoImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsTserviceDatainterflowGet(GWsTserviceDatainterflowGetRequestParam gWsTserviceDatainterflowGetRequestParam, ICallBackWsTserviceDatainterflowGet iCallBackWsTserviceDatainterflowGet) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsTserviceDatainterflowGet", GWsTserviceDatainterflowGetRequestParam.class, ICallBackWsTserviceDatainterflowGet.class);
            ICallBackWsTserviceDatainterflowGetImpl iCallBackWsTserviceDatainterflowGetImpl = null;
            if (iCallBackWsTserviceDatainterflowGet != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsTserviceDatainterflowGetImpl = (ICallBackWsTserviceDatainterflowGetImpl) typeHelper.transfer(method, 1, iCallBackWsTserviceDatainterflowGet);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsTserviceDatainterflowGet(gWsTserviceDatainterflowGetRequestParam, iCallBackWsTserviceDatainterflowGetImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public long sendReqWsPpCarltdAuthCancel(GWsPpCarltdAuthCancelRequestParam gWsPpCarltdAuthCancelRequestParam, ICallBackWsPpCarltdAuthCancel iCallBackWsPpCarltdAuthCancel) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosService.class.getMethod("sendReqWsPpCarltdAuthCancel", GWsPpCarltdAuthCancelRequestParam.class, ICallBackWsPpCarltdAuthCancel.class);
            ICallBackWsPpCarltdAuthCancelImpl iCallBackWsPpCarltdAuthCancelImpl = null;
            if (iCallBackWsPpCarltdAuthCancel != null && (typeHelper = this.mTypeHelper) != null) {
                iCallBackWsPpCarltdAuthCancelImpl = (ICallBackWsPpCarltdAuthCancelImpl) typeHelper.transfer(method, 1, iCallBackWsPpCarltdAuthCancel);
            }
            IBLAosServiceImpl iBLAosServiceImpl = this.mControl;
            if (iBLAosServiceImpl != null) {
                return iBLAosServiceImpl.sendReqWsPpCarltdAuthCancel(gWsPpCarltdAuthCancelRequestParam, iCallBackWsPpCarltdAuthCancelImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    protected void unbind() {
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

    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
