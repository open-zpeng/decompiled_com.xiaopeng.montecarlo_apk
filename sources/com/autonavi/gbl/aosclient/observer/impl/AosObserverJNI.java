package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.gbl.aosclient.model.AuthTokenInfo;
import com.autonavi.gbl.aosclient.model.BLResponseBase;
import com.autonavi.gbl.aosclient.model.CEtaRequestReponseParam;
import com.autonavi.gbl.aosclient.model.GAddressPredictResponseParam;
import com.autonavi.gbl.aosclient.model.GCancelSignPayResponseParam;
import com.autonavi.gbl.aosclient.model.GCarLtdBindAuthInfoResponseParam;
import com.autonavi.gbl.aosclient.model.GCarLtdBindResponseParam;
import com.autonavi.gbl.aosclient.model.GCarLtdCheckTokenResponseParam;
import com.autonavi.gbl.aosclient.model.GCarLtdQuickLoginResponseParam;
import com.autonavi.gbl.aosclient.model.GCarLtdQuickRegisterResponseParam;
import com.autonavi.gbl.aosclient.model.GCarLtdUnbindResponseParam;
import com.autonavi.gbl.aosclient.model.GCouponrecvapplyResponseParam;
import com.autonavi.gbl.aosclient.model.GCouponrecvlistResponseParam;
import com.autonavi.gbl.aosclient.model.GDriveReportSmsResponseParam;
import com.autonavi.gbl.aosclient.model.GDriveReportUploadResponseParam;
import com.autonavi.gbl.aosclient.model.GFeedbackReportResponseParam;
import com.autonavi.gbl.aosclient.model.GGasstationcalpriceResponseParam;
import com.autonavi.gbl.aosclient.model.GHolidayListResponseParam;
import com.autonavi.gbl.aosclient.model.GHttpGetPostResponseParam;
import com.autonavi.gbl.aosclient.model.GImGetAppuidResponseParam;
import com.autonavi.gbl.aosclient.model.GImGetLoginTokenResponseParam;
import com.autonavi.gbl.aosclient.model.GLbpEventSyncCommonResponseParam;
import com.autonavi.gbl.aosclient.model.GLogUploadResponseParam;
import com.autonavi.gbl.aosclient.model.GMojiWeatherResponseParam;
import com.autonavi.gbl.aosclient.model.GNavigationEtaqueryResponseParam;
import com.autonavi.gbl.aosclient.model.GParkOrderCreateResponseParam;
import com.autonavi.gbl.aosclient.model.GParkOrderDetailResponseParam;
import com.autonavi.gbl.aosclient.model.GParkOrderListResponseParam;
import com.autonavi.gbl.aosclient.model.GParkPayStatusResponseParam;
import com.autonavi.gbl.aosclient.model.GParkServiceResponseParam;
import com.autonavi.gbl.aosclient.model.GPaymentBindAlipayResponseParam;
import com.autonavi.gbl.aosclient.model.GPaymentStatusResponseParam;
import com.autonavi.gbl.aosclient.model.GPaymentUnbindAlipayResponseParam;
import com.autonavi.gbl.aosclient.model.GQRCodeConfirmResponseParam;
import com.autonavi.gbl.aosclient.model.GQueryCarMsgResponseParam;
import com.autonavi.gbl.aosclient.model.GQueryPersentWeatherResponseParam;
import com.autonavi.gbl.aosclient.model.GQueryWeatherByLinkResponseParam;
import com.autonavi.gbl.aosclient.model.GQuerybylinksResponseParam;
import com.autonavi.gbl.aosclient.model.GRangeSpiderResponseParam;
import com.autonavi.gbl.aosclient.model.GReStrictedAreaResponseParam;
import com.autonavi.gbl.aosclient.model.GSendToPhoneResponseParam;
import com.autonavi.gbl.aosclient.model.GServerTimestampResponseParam;
import com.autonavi.gbl.aosclient.model.GTrafficEventCommentResponseParam;
import com.autonavi.gbl.aosclient.model.GTrafficEventDetailResponseParam;
import com.autonavi.gbl.aosclient.model.GTrafficRestrictResponseParam;
import com.autonavi.gbl.aosclient.model.GTripodCompanyResponseParam;
import com.autonavi.gbl.aosclient.model.GUserDeviceResponseParam;
import com.autonavi.gbl.aosclient.model.GWorkdayListResponseParam;
import com.autonavi.gbl.aosclient.model.GWsAosDestinationSearchResponseParam;
import com.autonavi.gbl.aosclient.model.GWsAppConfAppUpdateResponseParam;
import com.autonavi.gbl.aosclient.model.GWsArchiveTrafficeventUpdateResponseParam;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServiceEnableResponseParam;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServiceProvisionResponseParam;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServicelistResponseParam;
import com.autonavi.gbl.aosclient.model.GWsAuthcarTokenResponseParam;
import com.autonavi.gbl.aosclient.model.GWsAutoCollectResponseParam;
import com.autonavi.gbl.aosclient.model.GWsChargeListResponseParam;
import com.autonavi.gbl.aosclient.model.GWsCloudUploadResponseParam;
import com.autonavi.gbl.aosclient.model.GWsCommerceInfraChargeRecordsWaitingEnableResponseParam;
import com.autonavi.gbl.aosclient.model.GWsDeviceAdiusResponseParam;
import com.autonavi.gbl.aosclient.model.GWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam;
import com.autonavi.gbl.aosclient.model.GWsDynamicInfoCongestionGroupChatUserRemoveResponseParam;
import com.autonavi.gbl.aosclient.model.GWsDynamicInfoEventPraiseStampStatusQueryResponseParam;
import com.autonavi.gbl.aosclient.model.GWsEventSearchResponseParam;
import com.autonavi.gbl.aosclient.model.GWsFeedbackReviewGetResponseParam;
import com.autonavi.gbl.aosclient.model.GWsFeedbackReviewReportResponseParam;
import com.autonavi.gbl.aosclient.model.GWsFencingFencesQueryResponseParam;
import com.autonavi.gbl.aosclient.model.GWsFencingGroupsQueryResponseParam;
import com.autonavi.gbl.aosclient.model.GWsIcsLifeCouponOptionsResponseParam;
import com.autonavi.gbl.aosclient.model.GWsIcsLifeUserCouponListResponseParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiAutoInitResponseParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiAutoSwitchResponseParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiConfOfflineResponseParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiGeoCodeResponseParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiLinkidsResponseParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiPoiVoicesearchResponseParam;
import com.autonavi.gbl.aosclient.model.GWsMapapiRoadResponseParam;
import com.autonavi.gbl.aosclient.model.GWsMiniappCarVipGwResponseParam;
import com.autonavi.gbl.aosclient.model.GWsNavigationDynamicDataResponseParam;
import com.autonavi.gbl.aosclient.model.GWsNavigationDynamicFatigueResponseParam;
import com.autonavi.gbl.aosclient.model.GWsOssMaplayerListResponseParam;
import com.autonavi.gbl.aosclient.model.GWsPpAccountDeactivateHelpResponseParam;
import com.autonavi.gbl.aosclient.model.GWsPpAccountDeactivateResponseParam;
import com.autonavi.gbl.aosclient.model.GWsPpAccountProfileUpdateResponseParam;
import com.autonavi.gbl.aosclient.model.GWsPpAutoWeixinQrcodeResponseParam;
import com.autonavi.gbl.aosclient.model.GWsPpAutoWeixinStatusResponseParam;
import com.autonavi.gbl.aosclient.model.GWsPpAutoWeixinUnbindResponseParam;
import com.autonavi.gbl.aosclient.model.GWsPpCarltdAuthCancelResponseParam;
import com.autonavi.gbl.aosclient.model.GWsPpCarltdCheckbindResponseParam;
import com.autonavi.gbl.aosclient.model.GWsPpCarltdLogin4bindResponseParam;
import com.autonavi.gbl.aosclient.model.GWsPpContactBindMobileResponseParam;
import com.autonavi.gbl.aosclient.model.GWsPpContactUnbindMobileResponseParam;
import com.autonavi.gbl.aosclient.model.GWsPpQrcodeInnerGetResponseParam;
import com.autonavi.gbl.aosclient.model.GWsPpQrcodeUrlTranslateResponseParam;
import com.autonavi.gbl.aosclient.model.GWsSdsFilesResponseParam;
import com.autonavi.gbl.aosclient.model.GWsSearchPoiAutoCmallFillOrderResponseParam;
import com.autonavi.gbl.aosclient.model.GWsShieldAsbpApiUploadResponseParam;
import com.autonavi.gbl.aosclient.model.GWsShieldImMsgCommentSetResponseParam;
import com.autonavi.gbl.aosclient.model.GWsShieldNavigationRoutepathrestorationResponseParam;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchMainPageRecResponseParam;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistCityResponseParam;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistLandingResponseParam;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistPortalResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTcAlscOrderCancelResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTcCarServiceOrderCancelResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTcCarServiceSubmitResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTcCommonAgreementOrderquickpayResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTcCommonAgreementSignResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTcCommonAgreementStatusResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTcFuelCancelResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTcFuelCreateResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTcFuelGetwaitingpayordersResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTcFuelQueryagreementResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTcKoubeiOrderSubmitResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTcOrderApiMergeListResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTcOrderDetailResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTcOrderListResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTcPoiInfoResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceDatainterflowGetResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceInternalLinkAutoReportResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceInternalLinkCarGetResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceInternalLinkCarReportResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotDeviceListResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotDeviceRelieveResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodEventResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodSnAutoBindForceResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodSnAutoBindResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodSnAutoBoundResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodStatusResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceRequestIpResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamCreateResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamDismissResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamInfoGetResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamInfoUpdateResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamInviteResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamJoinResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamKickResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamQrResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamQuitResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamUserFriendsResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamUserStatusResponseParam;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamUserTnnUpdateResponseParam;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintNaviDeleteResponseParam;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintNaviRecordResponseParam;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintSummaryResponseParam;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintSwitchResponseParam;
import com.autonavi.gbl.aosclient.model.GWsVaCarLogoExchangeResponseParam;
import com.autonavi.gbl.aosclient.model.GWsVaCarLogoResponseParam;
import com.autonavi.gbl.aosclient.model.GWsVaCarLogoSelectResponseParam;
/* loaded from: classes.dex */
public class AosObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_ICallBackAddressPredictImpl_onRecvAck(ICallBackAddressPredictImpl iCallBackAddressPredictImpl, GAddressPredictResponseParam gAddressPredictResponseParam) {
        iCallBackAddressPredictImpl.onRecvAck(gAddressPredictResponseParam);
    }

    public static void SwigDirector_ICallBackCancelSignPayImpl_onRecvAck(ICallBackCancelSignPayImpl iCallBackCancelSignPayImpl, GCancelSignPayResponseParam gCancelSignPayResponseParam) {
        iCallBackCancelSignPayImpl.onRecvAck(gCancelSignPayResponseParam);
    }

    public static void SwigDirector_ICallBackCarLtdBindImpl_onRecvAck(ICallBackCarLtdBindImpl iCallBackCarLtdBindImpl, GCarLtdBindResponseParam gCarLtdBindResponseParam) {
        iCallBackCarLtdBindImpl.onRecvAck(gCarLtdBindResponseParam);
    }

    public static void SwigDirector_ICallBackCarLtdBindAuthInfoImpl_onRecvAck(ICallBackCarLtdBindAuthInfoImpl iCallBackCarLtdBindAuthInfoImpl, GCarLtdBindAuthInfoResponseParam gCarLtdBindAuthInfoResponseParam) {
        iCallBackCarLtdBindAuthInfoImpl.onRecvAck(gCarLtdBindAuthInfoResponseParam);
    }

    public static void SwigDirector_ICallBackCarLtdQuickLoginImpl_onRecvAck(ICallBackCarLtdQuickLoginImpl iCallBackCarLtdQuickLoginImpl, GCarLtdQuickLoginResponseParam gCarLtdQuickLoginResponseParam) {
        iCallBackCarLtdQuickLoginImpl.onRecvAck(gCarLtdQuickLoginResponseParam);
    }

    public static void SwigDirector_ICallBackCarLtdQuickRegisterImpl_onRecvAck(ICallBackCarLtdQuickRegisterImpl iCallBackCarLtdQuickRegisterImpl, GCarLtdQuickRegisterResponseParam gCarLtdQuickRegisterResponseParam) {
        iCallBackCarLtdQuickRegisterImpl.onRecvAck(gCarLtdQuickRegisterResponseParam);
    }

    public static void SwigDirector_ICallBackCarLtdUnbindImpl_onRecvAck(ICallBackCarLtdUnbindImpl iCallBackCarLtdUnbindImpl, GCarLtdUnbindResponseParam gCarLtdUnbindResponseParam) {
        iCallBackCarLtdUnbindImpl.onRecvAck(gCarLtdUnbindResponseParam);
    }

    public static void SwigDirector_ICallBackDriveReportUploadImpl_onRecvAck(ICallBackDriveReportUploadImpl iCallBackDriveReportUploadImpl, GDriveReportUploadResponseParam gDriveReportUploadResponseParam) {
        iCallBackDriveReportUploadImpl.onRecvAck(gDriveReportUploadResponseParam);
    }

    public static void SwigDirector_ICallBackDriveReportSmsImpl_onRecvAck(ICallBackDriveReportSmsImpl iCallBackDriveReportSmsImpl, GDriveReportSmsResponseParam gDriveReportSmsResponseParam) {
        iCallBackDriveReportSmsImpl.onRecvAck(gDriveReportSmsResponseParam);
    }

    public static void SwigDirector_ICallBackEtaRequestImpl_onRecvAck(ICallBackEtaRequestImpl iCallBackEtaRequestImpl, CEtaRequestReponseParam cEtaRequestReponseParam) {
        iCallBackEtaRequestImpl.onRecvAck(cEtaRequestReponseParam);
    }

    public static void SwigDirector_ICallBackFeedbackReportImpl_onRecvAck(ICallBackFeedbackReportImpl iCallBackFeedbackReportImpl, GFeedbackReportResponseParam gFeedbackReportResponseParam) {
        iCallBackFeedbackReportImpl.onRecvAck(gFeedbackReportResponseParam);
    }

    public static void SwigDirector_ICallBackHolidayListImpl_onRecvAck(ICallBackHolidayListImpl iCallBackHolidayListImpl, GHolidayListResponseParam gHolidayListResponseParam) {
        iCallBackHolidayListImpl.onRecvAck(gHolidayListResponseParam);
    }

    public static void SwigDirector_ICallBackLogUploadImpl_onRecvAck(ICallBackLogUploadImpl iCallBackLogUploadImpl, GLogUploadResponseParam gLogUploadResponseParam) {
        iCallBackLogUploadImpl.onRecvAck(gLogUploadResponseParam);
    }

    public static void SwigDirector_ICallBackMojiWeatherImpl_onRecvAck(ICallBackMojiWeatherImpl iCallBackMojiWeatherImpl, GMojiWeatherResponseParam gMojiWeatherResponseParam) {
        iCallBackMojiWeatherImpl.onRecvAck(gMojiWeatherResponseParam);
    }

    public static void SwigDirector_ICallBackNavigationEtaqueryImpl_onRecvAck(ICallBackNavigationEtaqueryImpl iCallBackNavigationEtaqueryImpl, GNavigationEtaqueryResponseParam gNavigationEtaqueryResponseParam) {
        iCallBackNavigationEtaqueryImpl.onRecvAck(gNavigationEtaqueryResponseParam);
    }

    public static void SwigDirector_ICallBackParkServiceImpl_onRecvAck(ICallBackParkServiceImpl iCallBackParkServiceImpl, GParkServiceResponseParam gParkServiceResponseParam) {
        iCallBackParkServiceImpl.onRecvAck(gParkServiceResponseParam);
    }

    public static void SwigDirector_ICallBackParkOrderDetailImpl_onRecvAck(ICallBackParkOrderDetailImpl iCallBackParkOrderDetailImpl, GParkOrderDetailResponseParam gParkOrderDetailResponseParam) {
        iCallBackParkOrderDetailImpl.onRecvAck(gParkOrderDetailResponseParam);
    }

    public static void SwigDirector_ICallBackParkOrderListImpl_onRecvAck(ICallBackParkOrderListImpl iCallBackParkOrderListImpl, GParkOrderListResponseParam gParkOrderListResponseParam) {
        iCallBackParkOrderListImpl.onRecvAck(gParkOrderListResponseParam);
    }

    public static void SwigDirector_ICallBackParkPayStatusImpl_onRecvAck(ICallBackParkPayStatusImpl iCallBackParkPayStatusImpl, GParkPayStatusResponseParam gParkPayStatusResponseParam) {
        iCallBackParkPayStatusImpl.onRecvAck(gParkPayStatusResponseParam);
    }

    public static void SwigDirector_ICallBackPaymentStatusImpl_onRecvAck(ICallBackPaymentStatusImpl iCallBackPaymentStatusImpl, GPaymentStatusResponseParam gPaymentStatusResponseParam) {
        iCallBackPaymentStatusImpl.onRecvAck(gPaymentStatusResponseParam);
    }

    public static void SwigDirector_ICallBackPaymentUnbindAlipayImpl_onRecvAck(ICallBackPaymentUnbindAlipayImpl iCallBackPaymentUnbindAlipayImpl, GPaymentUnbindAlipayResponseParam gPaymentUnbindAlipayResponseParam) {
        iCallBackPaymentUnbindAlipayImpl.onRecvAck(gPaymentUnbindAlipayResponseParam);
    }

    public static void SwigDirector_ICallBackQRCodeConfirmImpl_onRecvAck(ICallBackQRCodeConfirmImpl iCallBackQRCodeConfirmImpl, GQRCodeConfirmResponseParam gQRCodeConfirmResponseParam) {
        iCallBackQRCodeConfirmImpl.onRecvAck(gQRCodeConfirmResponseParam);
    }

    public static void SwigDirector_ICallBackQueryCarMsgImpl_onRecvAck(ICallBackQueryCarMsgImpl iCallBackQueryCarMsgImpl, GQueryCarMsgResponseParam gQueryCarMsgResponseParam) {
        iCallBackQueryCarMsgImpl.onRecvAck(gQueryCarMsgResponseParam);
    }

    public static void SwigDirector_ICallBackSendToPhoneImpl_onRecvAck(ICallBackSendToPhoneImpl iCallBackSendToPhoneImpl, GSendToPhoneResponseParam gSendToPhoneResponseParam) {
        iCallBackSendToPhoneImpl.onRecvAck(gSendToPhoneResponseParam);
    }

    public static void SwigDirector_ICallBackTrafficRestrictImpl_onRecvAck(ICallBackTrafficRestrictImpl iCallBackTrafficRestrictImpl, GTrafficRestrictResponseParam gTrafficRestrictResponseParam) {
        iCallBackTrafficRestrictImpl.onRecvAck(gTrafficRestrictResponseParam);
    }

    public static void SwigDirector_ICallBackTrafficEventCommentImpl_onRecvAck(ICallBackTrafficEventCommentImpl iCallBackTrafficEventCommentImpl, GTrafficEventCommentResponseParam gTrafficEventCommentResponseParam) {
        iCallBackTrafficEventCommentImpl.onRecvAck(gTrafficEventCommentResponseParam);
    }

    public static void SwigDirector_ICallBackTrafficEventDetailImpl_onRecvAck(ICallBackTrafficEventDetailImpl iCallBackTrafficEventDetailImpl, GTrafficEventDetailResponseParam gTrafficEventDetailResponseParam) {
        iCallBackTrafficEventDetailImpl.onRecvAck(gTrafficEventDetailResponseParam);
    }

    public static void SwigDirector_ICallBackUserDeviceImpl_onRecvAck(ICallBackUserDeviceImpl iCallBackUserDeviceImpl, GUserDeviceResponseParam gUserDeviceResponseParam) {
        iCallBackUserDeviceImpl.onRecvAck(gUserDeviceResponseParam);
    }

    public static void SwigDirector_ICallBackWorkdayListImpl_onRecvAck(ICallBackWorkdayListImpl iCallBackWorkdayListImpl, GWorkdayListResponseParam gWorkdayListResponseParam) {
        iCallBackWorkdayListImpl.onRecvAck(gWorkdayListResponseParam);
    }

    public static void SwigDirector_ICallBackWsAppConfAppUpdateImpl_onRecvAck(ICallBackWsAppConfAppUpdateImpl iCallBackWsAppConfAppUpdateImpl, GWsAppConfAppUpdateResponseParam gWsAppConfAppUpdateResponseParam) {
        iCallBackWsAppConfAppUpdateImpl.onRecvAck(gWsAppConfAppUpdateResponseParam);
    }

    public static void SwigDirector_ICallBackWsArchiveTrafficeventUpdateImpl_onRecvAck(ICallBackWsArchiveTrafficeventUpdateImpl iCallBackWsArchiveTrafficeventUpdateImpl, GWsArchiveTrafficeventUpdateResponseParam gWsArchiveTrafficeventUpdateResponseParam) {
        iCallBackWsArchiveTrafficeventUpdateImpl.onRecvAck(gWsArchiveTrafficeventUpdateResponseParam);
    }

    public static void SwigDirector_ICallBackWsDeviceAdiusImpl_onRecvAck(ICallBackWsDeviceAdiusImpl iCallBackWsDeviceAdiusImpl, GWsDeviceAdiusResponseParam gWsDeviceAdiusResponseParam) {
        iCallBackWsDeviceAdiusImpl.onRecvAck(gWsDeviceAdiusResponseParam);
    }

    public static void SwigDirector_ICallBackWsMapapiAutoSwitchImpl_onRecvAck(ICallBackWsMapapiAutoSwitchImpl iCallBackWsMapapiAutoSwitchImpl, GWsMapapiAutoSwitchResponseParam gWsMapapiAutoSwitchResponseParam) {
        iCallBackWsMapapiAutoSwitchImpl.onRecvAck(gWsMapapiAutoSwitchResponseParam);
    }

    public static void SwigDirector_ICallBackWsMapapiGeoCodeImpl_onRecvAck(ICallBackWsMapapiGeoCodeImpl iCallBackWsMapapiGeoCodeImpl, GWsMapapiGeoCodeResponseParam gWsMapapiGeoCodeResponseParam) {
        iCallBackWsMapapiGeoCodeImpl.onRecvAck(gWsMapapiGeoCodeResponseParam);
    }

    public static void SwigDirector_ICallBackWsMapapiPoiVoicesearchImpl_onRecvAck(ICallBackWsMapapiPoiVoicesearchImpl iCallBackWsMapapiPoiVoicesearchImpl, GWsMapapiPoiVoicesearchResponseParam gWsMapapiPoiVoicesearchResponseParam) {
        iCallBackWsMapapiPoiVoicesearchImpl.onRecvAck(gWsMapapiPoiVoicesearchResponseParam);
    }

    public static void SwigDirector_ICallBackWsPpAccountProfileUpdateImpl_onRecvAck(ICallBackWsPpAccountProfileUpdateImpl iCallBackWsPpAccountProfileUpdateImpl, GWsPpAccountProfileUpdateResponseParam gWsPpAccountProfileUpdateResponseParam) {
        iCallBackWsPpAccountProfileUpdateImpl.onRecvAck(gWsPpAccountProfileUpdateResponseParam);
    }

    public static void SwigDirector_ICallBackWsPpAutoWeixinQrcodeImpl_onRecvAck(ICallBackWsPpAutoWeixinQrcodeImpl iCallBackWsPpAutoWeixinQrcodeImpl, GWsPpAutoWeixinQrcodeResponseParam gWsPpAutoWeixinQrcodeResponseParam) {
        iCallBackWsPpAutoWeixinQrcodeImpl.onRecvAck(gWsPpAutoWeixinQrcodeResponseParam);
    }

    public static void SwigDirector_ICallBackWsPpAutoWeixinStatusImpl_onRecvAck(ICallBackWsPpAutoWeixinStatusImpl iCallBackWsPpAutoWeixinStatusImpl, GWsPpAutoWeixinStatusResponseParam gWsPpAutoWeixinStatusResponseParam) {
        iCallBackWsPpAutoWeixinStatusImpl.onRecvAck(gWsPpAutoWeixinStatusResponseParam);
    }

    public static void SwigDirector_ICallBackWsPpAutoWeixinUnbindImpl_onRecvAck(ICallBackWsPpAutoWeixinUnbindImpl iCallBackWsPpAutoWeixinUnbindImpl, GWsPpAutoWeixinUnbindResponseParam gWsPpAutoWeixinUnbindResponseParam) {
        iCallBackWsPpAutoWeixinUnbindImpl.onRecvAck(gWsPpAutoWeixinUnbindResponseParam);
    }

    public static void SwigDirector_ICallBackWsPpCarltdCheckbindImpl_onRecvAck(ICallBackWsPpCarltdCheckbindImpl iCallBackWsPpCarltdCheckbindImpl, GWsPpCarltdCheckbindResponseParam gWsPpCarltdCheckbindResponseParam) {
        iCallBackWsPpCarltdCheckbindImpl.onRecvAck(gWsPpCarltdCheckbindResponseParam);
    }

    public static void SwigDirector_ICallBackWsPpQrcodeUrlTranslateImpl_onRecvAck(ICallBackWsPpQrcodeUrlTranslateImpl iCallBackWsPpQrcodeUrlTranslateImpl, GWsPpQrcodeUrlTranslateResponseParam gWsPpQrcodeUrlTranslateResponseParam) {
        iCallBackWsPpQrcodeUrlTranslateImpl.onRecvAck(gWsPpQrcodeUrlTranslateResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceTeamDismissImpl_onRecvAck(ICallBackWsTserviceTeamDismissImpl iCallBackWsTserviceTeamDismissImpl, GWsTserviceTeamDismissResponseParam gWsTserviceTeamDismissResponseParam) {
        iCallBackWsTserviceTeamDismissImpl.onRecvAck(gWsTserviceTeamDismissResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceTeamInviteImpl_onRecvAck(ICallBackWsTserviceTeamInviteImpl iCallBackWsTserviceTeamInviteImpl, GWsTserviceTeamInviteResponseParam gWsTserviceTeamInviteResponseParam) {
        iCallBackWsTserviceTeamInviteImpl.onRecvAck(gWsTserviceTeamInviteResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceTeamQrImpl_onRecvAck(ICallBackWsTserviceTeamQrImpl iCallBackWsTserviceTeamQrImpl, GWsTserviceTeamQrResponseParam gWsTserviceTeamQrResponseParam) {
        iCallBackWsTserviceTeamQrImpl.onRecvAck(gWsTserviceTeamQrResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceTeamUserFriendsImpl_onRecvAck(ICallBackWsTserviceTeamUserFriendsImpl iCallBackWsTserviceTeamUserFriendsImpl, GWsTserviceTeamUserFriendsResponseParam gWsTserviceTeamUserFriendsResponseParam) {
        iCallBackWsTserviceTeamUserFriendsImpl.onRecvAck(gWsTserviceTeamUserFriendsResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceTeamUserStatusImpl_onRecvAck(ICallBackWsTserviceTeamUserStatusImpl iCallBackWsTserviceTeamUserStatusImpl, GWsTserviceTeamUserStatusResponseParam gWsTserviceTeamUserStatusResponseParam) {
        iCallBackWsTserviceTeamUserStatusImpl.onRecvAck(gWsTserviceTeamUserStatusResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceTeamUserTnnUpdateImpl_onRecvAck(ICallBackWsTserviceTeamUserTnnUpdateImpl iCallBackWsTserviceTeamUserTnnUpdateImpl, GWsTserviceTeamUserTnnUpdateResponseParam gWsTserviceTeamUserTnnUpdateResponseParam) {
        iCallBackWsTserviceTeamUserTnnUpdateImpl.onRecvAck(gWsTserviceTeamUserTnnUpdateResponseParam);
    }

    public static void SwigDirector_IBLAosCallBackImpl_onRecvResponse(IBLAosCallBackImpl iBLAosCallBackImpl, BLResponseBase bLResponseBase) {
        iBLAosCallBackImpl.onRecvResponse(bLResponseBase);
    }

    public static void SwigDirector_ICallBackAuthenticationImpl_onRecvAuthcarServerlist(ICallBackAuthenticationImpl iCallBackAuthenticationImpl, GWsAuthcarServicelistResponseParam gWsAuthcarServicelistResponseParam) {
        iCallBackAuthenticationImpl.onRecvAuthcarServerlist(gWsAuthcarServicelistResponseParam);
    }

    public static void SwigDirector_ICallBackAuthenticationImpl_onRecvAuthcarToken(ICallBackAuthenticationImpl iCallBackAuthenticationImpl, GWsAuthcarTokenResponseParam gWsAuthcarTokenResponseParam) {
        iCallBackAuthenticationImpl.onRecvAuthcarToken(gWsAuthcarTokenResponseParam);
    }

    public static void SwigDirector_ICallBackAuthenticationImpl_onAuthcarTokenError(ICallBackAuthenticationImpl iCallBackAuthenticationImpl, AuthTokenInfo authTokenInfo) {
        iCallBackAuthenticationImpl.onAuthcarTokenError(authTokenInfo);
    }

    public static void SwigDirector_ICallBackCarLtdCheckTokenImpl_onRecvAck(ICallBackCarLtdCheckTokenImpl iCallBackCarLtdCheckTokenImpl, GCarLtdCheckTokenResponseParam gCarLtdCheckTokenResponseParam) {
        iCallBackCarLtdCheckTokenImpl.onRecvAck(gCarLtdCheckTokenResponseParam);
    }

    public static void SwigDirector_ICallBackParkOrderCreateImpl_onRecvAck(ICallBackParkOrderCreateImpl iCallBackParkOrderCreateImpl, GParkOrderCreateResponseParam gParkOrderCreateResponseParam) {
        iCallBackParkOrderCreateImpl.onRecvAck(gParkOrderCreateResponseParam);
    }

    public static void SwigDirector_ICallBackPaymentBindAlipayImpl_onRecvAck(ICallBackPaymentBindAlipayImpl iCallBackPaymentBindAlipayImpl, GPaymentBindAlipayResponseParam gPaymentBindAlipayResponseParam) {
        iCallBackPaymentBindAlipayImpl.onRecvAck(gPaymentBindAlipayResponseParam);
    }

    public static void SwigDirector_ICallBackCouponrecvapplyImpl_onRecvAck(ICallBackCouponrecvapplyImpl iCallBackCouponrecvapplyImpl, GCouponrecvapplyResponseParam gCouponrecvapplyResponseParam) {
        iCallBackCouponrecvapplyImpl.onRecvAck(gCouponrecvapplyResponseParam);
    }

    public static void SwigDirector_ICallBackCouponrecvlistImpl_onRecvAck(ICallBackCouponrecvlistImpl iCallBackCouponrecvlistImpl, GCouponrecvlistResponseParam gCouponrecvlistResponseParam) {
        iCallBackCouponrecvlistImpl.onRecvAck(gCouponrecvlistResponseParam);
    }

    public static void SwigDirector_ICallBackGasstationcalpriceImpl_onRecvAck(ICallBackGasstationcalpriceImpl iCallBackGasstationcalpriceImpl, GGasstationcalpriceResponseParam gGasstationcalpriceResponseParam) {
        iCallBackGasstationcalpriceImpl.onRecvAck(gGasstationcalpriceResponseParam);
    }

    public static void SwigDirector_ICallBackHttpGetPostImpl_onRecvAck(ICallBackHttpGetPostImpl iCallBackHttpGetPostImpl, GHttpGetPostResponseParam gHttpGetPostResponseParam) {
        iCallBackHttpGetPostImpl.onRecvAck(gHttpGetPostResponseParam);
    }

    public static void SwigDirector_ICallBackImGetAppuidImpl_onRecvAck(ICallBackImGetAppuidImpl iCallBackImGetAppuidImpl, GImGetAppuidResponseParam gImGetAppuidResponseParam) {
        iCallBackImGetAppuidImpl.onRecvAck(gImGetAppuidResponseParam);
    }

    public static void SwigDirector_ICallBackImGetLoginTokenImpl_onRecvAck(ICallBackImGetLoginTokenImpl iCallBackImGetLoginTokenImpl, GImGetLoginTokenResponseParam gImGetLoginTokenResponseParam) {
        iCallBackImGetLoginTokenImpl.onRecvAck(gImGetLoginTokenResponseParam);
    }

    public static void SwigDirector_ICallBackLbpEventSyncCommonImpl_onRecvAck(ICallBackLbpEventSyncCommonImpl iCallBackLbpEventSyncCommonImpl, GLbpEventSyncCommonResponseParam gLbpEventSyncCommonResponseParam) {
        iCallBackLbpEventSyncCommonImpl.onRecvAck(gLbpEventSyncCommonResponseParam);
    }

    public static void SwigDirector_ICallBackQuerybylinksImpl_onRecvAck(ICallBackQuerybylinksImpl iCallBackQuerybylinksImpl, GQuerybylinksResponseParam gQuerybylinksResponseParam) {
        iCallBackQuerybylinksImpl.onRecvAck(gQuerybylinksResponseParam);
    }

    public static void SwigDirector_ICallBackServerTimestampImpl_onRecvAck(ICallBackServerTimestampImpl iCallBackServerTimestampImpl, GServerTimestampResponseParam gServerTimestampResponseParam) {
        iCallBackServerTimestampImpl.onRecvAck(gServerTimestampResponseParam);
    }

    public static void SwigDirector_ICallBackTripodCompanyImpl_onRecvAck(ICallBackTripodCompanyImpl iCallBackTripodCompanyImpl, GTripodCompanyResponseParam gTripodCompanyResponseParam) {
        iCallBackTripodCompanyImpl.onRecvAck(gTripodCompanyResponseParam);
    }

    public static void SwigDirector_ICallBackWsAosDestinationSearchImpl_onRecvAck(ICallBackWsAosDestinationSearchImpl iCallBackWsAosDestinationSearchImpl, GWsAosDestinationSearchResponseParam gWsAosDestinationSearchResponseParam) {
        iCallBackWsAosDestinationSearchImpl.onRecvAck(gWsAosDestinationSearchResponseParam);
    }

    public static void SwigDirector_ICallBackWsAuthcarServicelistImpl_onRecvAck(ICallBackWsAuthcarServicelistImpl iCallBackWsAuthcarServicelistImpl, GWsAuthcarServicelistResponseParam gWsAuthcarServicelistResponseParam) {
        iCallBackWsAuthcarServicelistImpl.onRecvAck(gWsAuthcarServicelistResponseParam);
    }

    public static void SwigDirector_ICallBackWsAuthcarTokenImpl_onRecvAck(ICallBackWsAuthcarTokenImpl iCallBackWsAuthcarTokenImpl, GWsAuthcarTokenResponseParam gWsAuthcarTokenResponseParam) {
        iCallBackWsAuthcarTokenImpl.onRecvAck(gWsAuthcarTokenResponseParam);
    }

    public static void SwigDirector_ICallBackWsAutoCollectImpl_onRecvAck(ICallBackWsAutoCollectImpl iCallBackWsAutoCollectImpl, GWsAutoCollectResponseParam gWsAutoCollectResponseParam) {
        iCallBackWsAutoCollectImpl.onRecvAck(gWsAutoCollectResponseParam);
    }

    public static void SwigDirector_ICallBackWsChargeListImpl_onRecvAck(ICallBackWsChargeListImpl iCallBackWsChargeListImpl, GWsChargeListResponseParam gWsChargeListResponseParam) {
        iCallBackWsChargeListImpl.onRecvAck(gWsChargeListResponseParam);
    }

    public static void SwigDirector_ICallBackWsCloudUploadImpl_onRecvAck(ICallBackWsCloudUploadImpl iCallBackWsCloudUploadImpl, GWsCloudUploadResponseParam gWsCloudUploadResponseParam) {
        iCallBackWsCloudUploadImpl.onRecvAck(gWsCloudUploadResponseParam);
    }

    public static void SwigDirector_ICallBackWsCommerceInfraChargeRecordsWaitingEnableImpl_onRecvAck(ICallBackWsCommerceInfraChargeRecordsWaitingEnableImpl iCallBackWsCommerceInfraChargeRecordsWaitingEnableImpl, GWsCommerceInfraChargeRecordsWaitingEnableResponseParam gWsCommerceInfraChargeRecordsWaitingEnableResponseParam) {
        iCallBackWsCommerceInfraChargeRecordsWaitingEnableImpl.onRecvAck(gWsCommerceInfraChargeRecordsWaitingEnableResponseParam);
    }

    public static void SwigDirector_ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl_onRecvAck(ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl iCallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl, GWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam gWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam) {
        iCallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl.onRecvAck(gWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam);
    }

    public static void SwigDirector_ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl_onRecvAck(ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl iCallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl, GWsDynamicInfoCongestionGroupChatUserRemoveResponseParam gWsDynamicInfoCongestionGroupChatUserRemoveResponseParam) {
        iCallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl.onRecvAck(gWsDynamicInfoCongestionGroupChatUserRemoveResponseParam);
    }

    public static void SwigDirector_ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl_onRecvAck(ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl iCallBackWsDynamicInfoEventPraiseStampStatusQueryImpl, GWsDynamicInfoEventPraiseStampStatusQueryResponseParam gWsDynamicInfoEventPraiseStampStatusQueryResponseParam) {
        iCallBackWsDynamicInfoEventPraiseStampStatusQueryImpl.onRecvAck(gWsDynamicInfoEventPraiseStampStatusQueryResponseParam);
    }

    public static void SwigDirector_ICallBackWsEventSearchImpl_onRecvAck(ICallBackWsEventSearchImpl iCallBackWsEventSearchImpl, GWsEventSearchResponseParam gWsEventSearchResponseParam) {
        iCallBackWsEventSearchImpl.onRecvAck(gWsEventSearchResponseParam);
    }

    public static void SwigDirector_ICallBackWsFeedbackReviewGetImpl_onRecvAck(ICallBackWsFeedbackReviewGetImpl iCallBackWsFeedbackReviewGetImpl, GWsFeedbackReviewGetResponseParam gWsFeedbackReviewGetResponseParam) {
        iCallBackWsFeedbackReviewGetImpl.onRecvAck(gWsFeedbackReviewGetResponseParam);
    }

    public static void SwigDirector_ICallBackWsFeedbackReviewReportImpl_onRecvAck(ICallBackWsFeedbackReviewReportImpl iCallBackWsFeedbackReviewReportImpl, GWsFeedbackReviewReportResponseParam gWsFeedbackReviewReportResponseParam) {
        iCallBackWsFeedbackReviewReportImpl.onRecvAck(gWsFeedbackReviewReportResponseParam);
    }

    public static void SwigDirector_ICallBackWsFencingFencesQueryImpl_onRecvAck(ICallBackWsFencingFencesQueryImpl iCallBackWsFencingFencesQueryImpl, GWsFencingFencesQueryResponseParam gWsFencingFencesQueryResponseParam) {
        iCallBackWsFencingFencesQueryImpl.onRecvAck(gWsFencingFencesQueryResponseParam);
    }

    public static void SwigDirector_ICallBackWsFencingGroupsQueryImpl_onRecvAck(ICallBackWsFencingGroupsQueryImpl iCallBackWsFencingGroupsQueryImpl, GWsFencingGroupsQueryResponseParam gWsFencingGroupsQueryResponseParam) {
        iCallBackWsFencingGroupsQueryImpl.onRecvAck(gWsFencingGroupsQueryResponseParam);
    }

    public static void SwigDirector_ICallBackWsIcsLifeCouponOptionsImpl_onRecvAck(ICallBackWsIcsLifeCouponOptionsImpl iCallBackWsIcsLifeCouponOptionsImpl, GWsIcsLifeCouponOptionsResponseParam gWsIcsLifeCouponOptionsResponseParam) {
        iCallBackWsIcsLifeCouponOptionsImpl.onRecvAck(gWsIcsLifeCouponOptionsResponseParam);
    }

    public static void SwigDirector_ICallBackWsIcsLifeUserCouponListImpl_onRecvAck(ICallBackWsIcsLifeUserCouponListImpl iCallBackWsIcsLifeUserCouponListImpl, GWsIcsLifeUserCouponListResponseParam gWsIcsLifeUserCouponListResponseParam) {
        iCallBackWsIcsLifeUserCouponListImpl.onRecvAck(gWsIcsLifeUserCouponListResponseParam);
    }

    public static void SwigDirector_ICallBackWsMapapiAutoInitImpl_onRecvAck(ICallBackWsMapapiAutoInitImpl iCallBackWsMapapiAutoInitImpl, GWsMapapiAutoInitResponseParam gWsMapapiAutoInitResponseParam) {
        iCallBackWsMapapiAutoInitImpl.onRecvAck(gWsMapapiAutoInitResponseParam);
    }

    public static void SwigDirector_ICallBackWsMapapiConfOfflineImpl_onRecvAck(ICallBackWsMapapiConfOfflineImpl iCallBackWsMapapiConfOfflineImpl, GWsMapapiConfOfflineResponseParam gWsMapapiConfOfflineResponseParam) {
        iCallBackWsMapapiConfOfflineImpl.onRecvAck(gWsMapapiConfOfflineResponseParam);
    }

    public static void SwigDirector_ICallBackWsMapapiLinkidsImpl_onRecvAck(ICallBackWsMapapiLinkidsImpl iCallBackWsMapapiLinkidsImpl, GWsMapapiLinkidsResponseParam gWsMapapiLinkidsResponseParam) {
        iCallBackWsMapapiLinkidsImpl.onRecvAck(gWsMapapiLinkidsResponseParam);
    }

    public static void SwigDirector_ICallBackWsMapapiRoadImpl_onRecvAck(ICallBackWsMapapiRoadImpl iCallBackWsMapapiRoadImpl, GWsMapapiRoadResponseParam gWsMapapiRoadResponseParam) {
        iCallBackWsMapapiRoadImpl.onRecvAck(gWsMapapiRoadResponseParam);
    }

    public static void SwigDirector_ICallBackWsMiniappCarVipGwImpl_onRecvAck(ICallBackWsMiniappCarVipGwImpl iCallBackWsMiniappCarVipGwImpl, GWsMiniappCarVipGwResponseParam gWsMiniappCarVipGwResponseParam) {
        iCallBackWsMiniappCarVipGwImpl.onRecvAck(gWsMiniappCarVipGwResponseParam);
    }

    public static void SwigDirector_ICallBackWsNavigationDynamicDataImpl_onRecvAck(ICallBackWsNavigationDynamicDataImpl iCallBackWsNavigationDynamicDataImpl, GWsNavigationDynamicDataResponseParam gWsNavigationDynamicDataResponseParam) {
        iCallBackWsNavigationDynamicDataImpl.onRecvAck(gWsNavigationDynamicDataResponseParam);
    }

    public static void SwigDirector_ICallBackWsNavigationDynamicFatigueImpl_onRecvAck(ICallBackWsNavigationDynamicFatigueImpl iCallBackWsNavigationDynamicFatigueImpl, GWsNavigationDynamicFatigueResponseParam gWsNavigationDynamicFatigueResponseParam) {
        iCallBackWsNavigationDynamicFatigueImpl.onRecvAck(gWsNavigationDynamicFatigueResponseParam);
    }

    public static void SwigDirector_ICallBackWsOssMaplayerListImpl_onRecvAck(ICallBackWsOssMaplayerListImpl iCallBackWsOssMaplayerListImpl, GWsOssMaplayerListResponseParam gWsOssMaplayerListResponseParam) {
        iCallBackWsOssMaplayerListImpl.onRecvAck(gWsOssMaplayerListResponseParam);
    }

    public static void SwigDirector_ICallBackWsPpAccountDeactivateImpl_onRecvAck(ICallBackWsPpAccountDeactivateImpl iCallBackWsPpAccountDeactivateImpl, GWsPpAccountDeactivateResponseParam gWsPpAccountDeactivateResponseParam) {
        iCallBackWsPpAccountDeactivateImpl.onRecvAck(gWsPpAccountDeactivateResponseParam);
    }

    public static void SwigDirector_ICallBackWsPpAccountDeactivateHelpImpl_onRecvAck(ICallBackWsPpAccountDeactivateHelpImpl iCallBackWsPpAccountDeactivateHelpImpl, GWsPpAccountDeactivateHelpResponseParam gWsPpAccountDeactivateHelpResponseParam) {
        iCallBackWsPpAccountDeactivateHelpImpl.onRecvAck(gWsPpAccountDeactivateHelpResponseParam);
    }

    public static void SwigDirector_ICallBackWsPpCarltdAuthCancelImpl_onRecvAck(ICallBackWsPpCarltdAuthCancelImpl iCallBackWsPpCarltdAuthCancelImpl, GWsPpCarltdAuthCancelResponseParam gWsPpCarltdAuthCancelResponseParam) {
        iCallBackWsPpCarltdAuthCancelImpl.onRecvAck(gWsPpCarltdAuthCancelResponseParam);
    }

    public static void SwigDirector_ICallBackWsPpCarltdLogin4bindImpl_onRecvAck(ICallBackWsPpCarltdLogin4bindImpl iCallBackWsPpCarltdLogin4bindImpl, GWsPpCarltdLogin4bindResponseParam gWsPpCarltdLogin4bindResponseParam) {
        iCallBackWsPpCarltdLogin4bindImpl.onRecvAck(gWsPpCarltdLogin4bindResponseParam);
    }

    public static void SwigDirector_ICallBackWsPpContactBindMobileImpl_onRecvAck(ICallBackWsPpContactBindMobileImpl iCallBackWsPpContactBindMobileImpl, GWsPpContactBindMobileResponseParam gWsPpContactBindMobileResponseParam) {
        iCallBackWsPpContactBindMobileImpl.onRecvAck(gWsPpContactBindMobileResponseParam);
    }

    public static void SwigDirector_ICallBackWsPpContactUnbindMobileImpl_onRecvAck(ICallBackWsPpContactUnbindMobileImpl iCallBackWsPpContactUnbindMobileImpl, GWsPpContactUnbindMobileResponseParam gWsPpContactUnbindMobileResponseParam) {
        iCallBackWsPpContactUnbindMobileImpl.onRecvAck(gWsPpContactUnbindMobileResponseParam);
    }

    public static void SwigDirector_ICallBackWsPpQrcodeInnerGetImpl_onRecvAck(ICallBackWsPpQrcodeInnerGetImpl iCallBackWsPpQrcodeInnerGetImpl, GWsPpQrcodeInnerGetResponseParam gWsPpQrcodeInnerGetResponseParam) {
        iCallBackWsPpQrcodeInnerGetImpl.onRecvAck(gWsPpQrcodeInnerGetResponseParam);
    }

    public static void SwigDirector_ICallBackWsSdsFilesImpl_onRecvAck(ICallBackWsSdsFilesImpl iCallBackWsSdsFilesImpl, GWsSdsFilesResponseParam gWsSdsFilesResponseParam) {
        iCallBackWsSdsFilesImpl.onRecvAck(gWsSdsFilesResponseParam);
    }

    public static void SwigDirector_ICallBackWsSearchPoiAutoCmallFillOrderImpl_onRecvAck(ICallBackWsSearchPoiAutoCmallFillOrderImpl iCallBackWsSearchPoiAutoCmallFillOrderImpl, GWsSearchPoiAutoCmallFillOrderResponseParam gWsSearchPoiAutoCmallFillOrderResponseParam) {
        iCallBackWsSearchPoiAutoCmallFillOrderImpl.onRecvAck(gWsSearchPoiAutoCmallFillOrderResponseParam);
    }

    public static void SwigDirector_ICallBackWsShieldAsbpApiUploadImpl_onRecvAck(ICallBackWsShieldAsbpApiUploadImpl iCallBackWsShieldAsbpApiUploadImpl, GWsShieldAsbpApiUploadResponseParam gWsShieldAsbpApiUploadResponseParam) {
        iCallBackWsShieldAsbpApiUploadImpl.onRecvAck(gWsShieldAsbpApiUploadResponseParam);
    }

    public static void SwigDirector_ICallBackWsShieldImMsgCommentSetImpl_onRecvAck(ICallBackWsShieldImMsgCommentSetImpl iCallBackWsShieldImMsgCommentSetImpl, GWsShieldImMsgCommentSetResponseParam gWsShieldImMsgCommentSetResponseParam) {
        iCallBackWsShieldImMsgCommentSetImpl.onRecvAck(gWsShieldImMsgCommentSetResponseParam);
    }

    public static void SwigDirector_ICallBackWsShieldNavigationRoutepathrestorationImpl_onRecvAck(ICallBackWsShieldNavigationRoutepathrestorationImpl iCallBackWsShieldNavigationRoutepathrestorationImpl, GWsShieldNavigationRoutepathrestorationResponseParam gWsShieldNavigationRoutepathrestorationResponseParam) {
        iCallBackWsShieldNavigationRoutepathrestorationImpl.onRecvAck(gWsShieldNavigationRoutepathrestorationResponseParam);
    }

    public static void SwigDirector_ICallBackWsShieldSearchMainPageRecImpl_onRecvAck(ICallBackWsShieldSearchMainPageRecImpl iCallBackWsShieldSearchMainPageRecImpl, GWsShieldSearchMainPageRecResponseParam gWsShieldSearchMainPageRecResponseParam) {
        iCallBackWsShieldSearchMainPageRecImpl.onRecvAck(gWsShieldSearchMainPageRecResponseParam);
    }

    public static void SwigDirector_ICallBackWsShieldSearchRanklistCityImpl_onRecvAck(ICallBackWsShieldSearchRanklistCityImpl iCallBackWsShieldSearchRanklistCityImpl, GWsShieldSearchRanklistCityResponseParam gWsShieldSearchRanklistCityResponseParam) {
        iCallBackWsShieldSearchRanklistCityImpl.onRecvAck(gWsShieldSearchRanklistCityResponseParam);
    }

    public static void SwigDirector_ICallBackWsShieldSearchRanklistLandingImpl_onRecvAck(ICallBackWsShieldSearchRanklistLandingImpl iCallBackWsShieldSearchRanklistLandingImpl, GWsShieldSearchRanklistLandingResponseParam gWsShieldSearchRanklistLandingResponseParam) {
        iCallBackWsShieldSearchRanklistLandingImpl.onRecvAck(gWsShieldSearchRanklistLandingResponseParam);
    }

    public static void SwigDirector_ICallBackWsShieldSearchRanklistPortalImpl_onRecvAck(ICallBackWsShieldSearchRanklistPortalImpl iCallBackWsShieldSearchRanklistPortalImpl, GWsShieldSearchRanklistPortalResponseParam gWsShieldSearchRanklistPortalResponseParam) {
        iCallBackWsShieldSearchRanklistPortalImpl.onRecvAck(gWsShieldSearchRanklistPortalResponseParam);
    }

    public static void SwigDirector_ICallBackWsTcAlscOrderCancelImpl_onRecvAck(ICallBackWsTcAlscOrderCancelImpl iCallBackWsTcAlscOrderCancelImpl, GWsTcAlscOrderCancelResponseParam gWsTcAlscOrderCancelResponseParam) {
        iCallBackWsTcAlscOrderCancelImpl.onRecvAck(gWsTcAlscOrderCancelResponseParam);
    }

    public static void SwigDirector_ICallBackWsTcCarServiceOrderCancelImpl_onRecvAck(ICallBackWsTcCarServiceOrderCancelImpl iCallBackWsTcCarServiceOrderCancelImpl, GWsTcCarServiceOrderCancelResponseParam gWsTcCarServiceOrderCancelResponseParam) {
        iCallBackWsTcCarServiceOrderCancelImpl.onRecvAck(gWsTcCarServiceOrderCancelResponseParam);
    }

    public static void SwigDirector_ICallBackWsTcCarServiceSubmitImpl_onRecvAck(ICallBackWsTcCarServiceSubmitImpl iCallBackWsTcCarServiceSubmitImpl, GWsTcCarServiceSubmitResponseParam gWsTcCarServiceSubmitResponseParam) {
        iCallBackWsTcCarServiceSubmitImpl.onRecvAck(gWsTcCarServiceSubmitResponseParam);
    }

    public static void SwigDirector_ICallBackWsTcCommonAgreementOrderquickpayImpl_onRecvAck(ICallBackWsTcCommonAgreementOrderquickpayImpl iCallBackWsTcCommonAgreementOrderquickpayImpl, GWsTcCommonAgreementOrderquickpayResponseParam gWsTcCommonAgreementOrderquickpayResponseParam) {
        iCallBackWsTcCommonAgreementOrderquickpayImpl.onRecvAck(gWsTcCommonAgreementOrderquickpayResponseParam);
    }

    public static void SwigDirector_ICallBackWsTcCommonAgreementSignImpl_onRecvAck(ICallBackWsTcCommonAgreementSignImpl iCallBackWsTcCommonAgreementSignImpl, GWsTcCommonAgreementSignResponseParam gWsTcCommonAgreementSignResponseParam) {
        iCallBackWsTcCommonAgreementSignImpl.onRecvAck(gWsTcCommonAgreementSignResponseParam);
    }

    public static void SwigDirector_ICallBackWsTcCommonAgreementStatusImpl_onRecvAck(ICallBackWsTcCommonAgreementStatusImpl iCallBackWsTcCommonAgreementStatusImpl, GWsTcCommonAgreementStatusResponseParam gWsTcCommonAgreementStatusResponseParam) {
        iCallBackWsTcCommonAgreementStatusImpl.onRecvAck(gWsTcCommonAgreementStatusResponseParam);
    }

    public static void SwigDirector_ICallBackWsTcFuelCancelImpl_onRecvAck(ICallBackWsTcFuelCancelImpl iCallBackWsTcFuelCancelImpl, GWsTcFuelCancelResponseParam gWsTcFuelCancelResponseParam) {
        iCallBackWsTcFuelCancelImpl.onRecvAck(gWsTcFuelCancelResponseParam);
    }

    public static void SwigDirector_ICallBackWsTcFuelCreateImpl_onRecvAck(ICallBackWsTcFuelCreateImpl iCallBackWsTcFuelCreateImpl, GWsTcFuelCreateResponseParam gWsTcFuelCreateResponseParam) {
        iCallBackWsTcFuelCreateImpl.onRecvAck(gWsTcFuelCreateResponseParam);
    }

    public static void SwigDirector_ICallBackWsTcFuelGetwaitingpayordersImpl_onRecvAck(ICallBackWsTcFuelGetwaitingpayordersImpl iCallBackWsTcFuelGetwaitingpayordersImpl, GWsTcFuelGetwaitingpayordersResponseParam gWsTcFuelGetwaitingpayordersResponseParam) {
        iCallBackWsTcFuelGetwaitingpayordersImpl.onRecvAck(gWsTcFuelGetwaitingpayordersResponseParam);
    }

    public static void SwigDirector_ICallBackWsTcFuelQueryagreementImpl_onRecvAck(ICallBackWsTcFuelQueryagreementImpl iCallBackWsTcFuelQueryagreementImpl, GWsTcFuelQueryagreementResponseParam gWsTcFuelQueryagreementResponseParam) {
        iCallBackWsTcFuelQueryagreementImpl.onRecvAck(gWsTcFuelQueryagreementResponseParam);
    }

    public static void SwigDirector_ICallBackWsTcKoubeiOrderSubmitImpl_onRecvAck(ICallBackWsTcKoubeiOrderSubmitImpl iCallBackWsTcKoubeiOrderSubmitImpl, GWsTcKoubeiOrderSubmitResponseParam gWsTcKoubeiOrderSubmitResponseParam) {
        iCallBackWsTcKoubeiOrderSubmitImpl.onRecvAck(gWsTcKoubeiOrderSubmitResponseParam);
    }

    public static void SwigDirector_ICallBackWsTcOrderApiMergeListImpl_onRecvAck(ICallBackWsTcOrderApiMergeListImpl iCallBackWsTcOrderApiMergeListImpl, GWsTcOrderApiMergeListResponseParam gWsTcOrderApiMergeListResponseParam) {
        iCallBackWsTcOrderApiMergeListImpl.onRecvAck(gWsTcOrderApiMergeListResponseParam);
    }

    public static void SwigDirector_ICallBackWsTcOrderDetailImpl_onRecvAck(ICallBackWsTcOrderDetailImpl iCallBackWsTcOrderDetailImpl, GWsTcOrderDetailResponseParam gWsTcOrderDetailResponseParam) {
        iCallBackWsTcOrderDetailImpl.onRecvAck(gWsTcOrderDetailResponseParam);
    }

    public static void SwigDirector_ICallBackWsTcOrderListImpl_onRecvAck(ICallBackWsTcOrderListImpl iCallBackWsTcOrderListImpl, GWsTcOrderListResponseParam gWsTcOrderListResponseParam) {
        iCallBackWsTcOrderListImpl.onRecvAck(gWsTcOrderListResponseParam);
    }

    public static void SwigDirector_ICallBackWsTcPoiInfoImpl_onRecvAck(ICallBackWsTcPoiInfoImpl iCallBackWsTcPoiInfoImpl, GWsTcPoiInfoResponseParam gWsTcPoiInfoResponseParam) {
        iCallBackWsTcPoiInfoImpl.onRecvAck(gWsTcPoiInfoResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceDatainterflowGetImpl_onRecvAck(ICallBackWsTserviceDatainterflowGetImpl iCallBackWsTserviceDatainterflowGetImpl, GWsTserviceDatainterflowGetResponseParam gWsTserviceDatainterflowGetResponseParam) {
        iCallBackWsTserviceDatainterflowGetImpl.onRecvAck(gWsTserviceDatainterflowGetResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceInternalLinkAutoReportImpl_onRecvAck(ICallBackWsTserviceInternalLinkAutoReportImpl iCallBackWsTserviceInternalLinkAutoReportImpl, GWsTserviceInternalLinkAutoReportResponseParam gWsTserviceInternalLinkAutoReportResponseParam) {
        iCallBackWsTserviceInternalLinkAutoReportImpl.onRecvAck(gWsTserviceInternalLinkAutoReportResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceInternalLinkCarGetImpl_onRecvAck(ICallBackWsTserviceInternalLinkCarGetImpl iCallBackWsTserviceInternalLinkCarGetImpl, GWsTserviceInternalLinkCarGetResponseParam gWsTserviceInternalLinkCarGetResponseParam) {
        iCallBackWsTserviceInternalLinkCarGetImpl.onRecvAck(gWsTserviceInternalLinkCarGetResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceInternalLinkCarReportImpl_onRecvAck(ICallBackWsTserviceInternalLinkCarReportImpl iCallBackWsTserviceInternalLinkCarReportImpl, GWsTserviceInternalLinkCarReportResponseParam gWsTserviceInternalLinkCarReportResponseParam) {
        iCallBackWsTserviceInternalLinkCarReportImpl.onRecvAck(gWsTserviceInternalLinkCarReportResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceIotDeviceListImpl_onRecvAck(ICallBackWsTserviceIotDeviceListImpl iCallBackWsTserviceIotDeviceListImpl, GWsTserviceIotDeviceListResponseParam gWsTserviceIotDeviceListResponseParam) {
        iCallBackWsTserviceIotDeviceListImpl.onRecvAck(gWsTserviceIotDeviceListResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceIotDeviceRelieveImpl_onRecvAck(ICallBackWsTserviceIotDeviceRelieveImpl iCallBackWsTserviceIotDeviceRelieveImpl, GWsTserviceIotDeviceRelieveResponseParam gWsTserviceIotDeviceRelieveResponseParam) {
        iCallBackWsTserviceIotDeviceRelieveImpl.onRecvAck(gWsTserviceIotDeviceRelieveResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceIotTripodEventImpl_onRecvAck(ICallBackWsTserviceIotTripodEventImpl iCallBackWsTserviceIotTripodEventImpl, GWsTserviceIotTripodEventResponseParam gWsTserviceIotTripodEventResponseParam) {
        iCallBackWsTserviceIotTripodEventImpl.onRecvAck(gWsTserviceIotTripodEventResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceIotTripodSnAutoBindImpl_onRecvAck(ICallBackWsTserviceIotTripodSnAutoBindImpl iCallBackWsTserviceIotTripodSnAutoBindImpl, GWsTserviceIotTripodSnAutoBindResponseParam gWsTserviceIotTripodSnAutoBindResponseParam) {
        iCallBackWsTserviceIotTripodSnAutoBindImpl.onRecvAck(gWsTserviceIotTripodSnAutoBindResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceIotTripodSnAutoBindForceImpl_onRecvAck(ICallBackWsTserviceIotTripodSnAutoBindForceImpl iCallBackWsTserviceIotTripodSnAutoBindForceImpl, GWsTserviceIotTripodSnAutoBindForceResponseParam gWsTserviceIotTripodSnAutoBindForceResponseParam) {
        iCallBackWsTserviceIotTripodSnAutoBindForceImpl.onRecvAck(gWsTserviceIotTripodSnAutoBindForceResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceIotTripodSnAutoBoundImpl_onRecvAck(ICallBackWsTserviceIotTripodSnAutoBoundImpl iCallBackWsTserviceIotTripodSnAutoBoundImpl, GWsTserviceIotTripodSnAutoBoundResponseParam gWsTserviceIotTripodSnAutoBoundResponseParam) {
        iCallBackWsTserviceIotTripodSnAutoBoundImpl.onRecvAck(gWsTserviceIotTripodSnAutoBoundResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceIotTripodStatusImpl_onRecvAck(ICallBackWsTserviceIotTripodStatusImpl iCallBackWsTserviceIotTripodStatusImpl, GWsTserviceIotTripodStatusResponseParam gWsTserviceIotTripodStatusResponseParam) {
        iCallBackWsTserviceIotTripodStatusImpl.onRecvAck(gWsTserviceIotTripodStatusResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceRequestIpImpl_onRecvAck(ICallBackWsTserviceRequestIpImpl iCallBackWsTserviceRequestIpImpl, GWsTserviceRequestIpResponseParam gWsTserviceRequestIpResponseParam) {
        iCallBackWsTserviceRequestIpImpl.onRecvAck(gWsTserviceRequestIpResponseParam);
    }

    public static void SwigDirector_ICallBackWsUserviewFootprintNaviDeleteImpl_onRecvAck(ICallBackWsUserviewFootprintNaviDeleteImpl iCallBackWsUserviewFootprintNaviDeleteImpl, GWsUserviewFootprintNaviDeleteResponseParam gWsUserviewFootprintNaviDeleteResponseParam) {
        iCallBackWsUserviewFootprintNaviDeleteImpl.onRecvAck(gWsUserviewFootprintNaviDeleteResponseParam);
    }

    public static void SwigDirector_ICallBackWsUserviewFootprintNaviRecordImpl_onRecvAck(ICallBackWsUserviewFootprintNaviRecordImpl iCallBackWsUserviewFootprintNaviRecordImpl, GWsUserviewFootprintNaviRecordResponseParam gWsUserviewFootprintNaviRecordResponseParam) {
        iCallBackWsUserviewFootprintNaviRecordImpl.onRecvAck(gWsUserviewFootprintNaviRecordResponseParam);
    }

    public static void SwigDirector_ICallBackWsUserviewFootprintSummaryImpl_onRecvAck(ICallBackWsUserviewFootprintSummaryImpl iCallBackWsUserviewFootprintSummaryImpl, GWsUserviewFootprintSummaryResponseParam gWsUserviewFootprintSummaryResponseParam) {
        iCallBackWsUserviewFootprintSummaryImpl.onRecvAck(gWsUserviewFootprintSummaryResponseParam);
    }

    public static void SwigDirector_ICallBackWsUserviewFootprintSwitchImpl_onRecvAck(ICallBackWsUserviewFootprintSwitchImpl iCallBackWsUserviewFootprintSwitchImpl, GWsUserviewFootprintSwitchResponseParam gWsUserviewFootprintSwitchResponseParam) {
        iCallBackWsUserviewFootprintSwitchImpl.onRecvAck(gWsUserviewFootprintSwitchResponseParam);
    }

    public static void SwigDirector_ICallBackWsVaCarLogoImpl_onRecvAck(ICallBackWsVaCarLogoImpl iCallBackWsVaCarLogoImpl, GWsVaCarLogoResponseParam gWsVaCarLogoResponseParam) {
        iCallBackWsVaCarLogoImpl.onRecvAck(gWsVaCarLogoResponseParam);
    }

    public static void SwigDirector_ICallBackWsVaCarLogoExchangeImpl_onRecvAck(ICallBackWsVaCarLogoExchangeImpl iCallBackWsVaCarLogoExchangeImpl, GWsVaCarLogoExchangeResponseParam gWsVaCarLogoExchangeResponseParam) {
        iCallBackWsVaCarLogoExchangeImpl.onRecvAck(gWsVaCarLogoExchangeResponseParam);
    }

    public static void SwigDirector_ICallBackQueryWeatherByLinkImpl_onRecvAck(ICallBackQueryWeatherByLinkImpl iCallBackQueryWeatherByLinkImpl, GQueryWeatherByLinkResponseParam gQueryWeatherByLinkResponseParam) {
        iCallBackQueryWeatherByLinkImpl.onRecvAck(gQueryWeatherByLinkResponseParam);
    }

    public static void SwigDirector_ICallBackRangeSpiderImpl_onRecvAck(ICallBackRangeSpiderImpl iCallBackRangeSpiderImpl, GRangeSpiderResponseParam gRangeSpiderResponseParam) {
        iCallBackRangeSpiderImpl.onRecvAck(gRangeSpiderResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceTeamCreateImpl_onRecvAck(ICallBackWsTserviceTeamCreateImpl iCallBackWsTserviceTeamCreateImpl, GWsTserviceTeamCreateResponseParam gWsTserviceTeamCreateResponseParam) {
        iCallBackWsTserviceTeamCreateImpl.onRecvAck(gWsTserviceTeamCreateResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceTeamInfoGetImpl_onRecvAck(ICallBackWsTserviceTeamInfoGetImpl iCallBackWsTserviceTeamInfoGetImpl, GWsTserviceTeamInfoGetResponseParam gWsTserviceTeamInfoGetResponseParam) {
        iCallBackWsTserviceTeamInfoGetImpl.onRecvAck(gWsTserviceTeamInfoGetResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceTeamInfoUpdateImpl_onRecvAck(ICallBackWsTserviceTeamInfoUpdateImpl iCallBackWsTserviceTeamInfoUpdateImpl, GWsTserviceTeamInfoUpdateResponseParam gWsTserviceTeamInfoUpdateResponseParam) {
        iCallBackWsTserviceTeamInfoUpdateImpl.onRecvAck(gWsTserviceTeamInfoUpdateResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceTeamJoinImpl_onRecvAck(ICallBackWsTserviceTeamJoinImpl iCallBackWsTserviceTeamJoinImpl, GWsTserviceTeamJoinResponseParam gWsTserviceTeamJoinResponseParam) {
        iCallBackWsTserviceTeamJoinImpl.onRecvAck(gWsTserviceTeamJoinResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceTeamKickImpl_onRecvAck(ICallBackWsTserviceTeamKickImpl iCallBackWsTserviceTeamKickImpl, GWsTserviceTeamKickResponseParam gWsTserviceTeamKickResponseParam) {
        iCallBackWsTserviceTeamKickImpl.onRecvAck(gWsTserviceTeamKickResponseParam);
    }

    public static void SwigDirector_ICallBackWsTserviceTeamQuitImpl_onRecvAck(ICallBackWsTserviceTeamQuitImpl iCallBackWsTserviceTeamQuitImpl, GWsTserviceTeamQuitResponseParam gWsTserviceTeamQuitResponseParam) {
        iCallBackWsTserviceTeamQuitImpl.onRecvAck(gWsTserviceTeamQuitResponseParam);
    }

    public static void SwigDirector_ICallBackWsAuthcarServiceEnableImpl_onRecvAck(ICallBackWsAuthcarServiceEnableImpl iCallBackWsAuthcarServiceEnableImpl, GWsAuthcarServiceEnableResponseParam gWsAuthcarServiceEnableResponseParam) {
        iCallBackWsAuthcarServiceEnableImpl.onRecvAck(gWsAuthcarServiceEnableResponseParam);
    }

    public static void SwigDirector_ICallBackWsAuthcarServiceProvisionImpl_onRecvAck(ICallBackWsAuthcarServiceProvisionImpl iCallBackWsAuthcarServiceProvisionImpl, GWsAuthcarServiceProvisionResponseParam gWsAuthcarServiceProvisionResponseParam) {
        iCallBackWsAuthcarServiceProvisionImpl.onRecvAck(gWsAuthcarServiceProvisionResponseParam);
    }

    public static void SwigDirector_ICallBackWsVaCarLogoSelectImpl_onRecvAck(ICallBackWsVaCarLogoSelectImpl iCallBackWsVaCarLogoSelectImpl, GWsVaCarLogoSelectResponseParam gWsVaCarLogoSelectResponseParam) {
        iCallBackWsVaCarLogoSelectImpl.onRecvAck(gWsVaCarLogoSelectResponseParam);
    }

    public static void SwigDirector_ICallBackQueryPersentWeatherImpl_onRecvAck(ICallBackQueryPersentWeatherImpl iCallBackQueryPersentWeatherImpl, GQueryPersentWeatherResponseParam gQueryPersentWeatherResponseParam) {
        iCallBackQueryPersentWeatherImpl.onRecvAck(gQueryPersentWeatherResponseParam);
    }

    public static void SwigDirector_ICallBackReStrictedAreaImpl_onRecvAck(ICallBackReStrictedAreaImpl iCallBackReStrictedAreaImpl, GReStrictedAreaResponseParam gReStrictedAreaResponseParam) {
        iCallBackReStrictedAreaImpl.onRecvAck(gReStrictedAreaResponseParam);
    }
}
