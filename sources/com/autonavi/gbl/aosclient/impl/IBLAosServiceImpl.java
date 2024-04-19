package com.autonavi.gbl.aosclient.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.BLAosService;
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
@IntfAuto(target = BLAosService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IBLAosServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IBLAosServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int abortRequestNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native BLAosCookie getCookieNative(long j, IBLAosServiceImpl iBLAosServiceImpl);

    private static native int getServiceIDNative(long j, IBLAosServiceImpl iBLAosServiceImpl);

    private static native String getVersionNative(long j, IBLAosServiceImpl iBLAosServiceImpl);

    private static native int isInitNative(long j, IBLAosServiceImpl iBLAosServiceImpl);

    private static native void logSwitchNative(long j, IBLAosServiceImpl iBLAosServiceImpl, int i);

    private static native long sendReqAddressPredictNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GAddressPredictRequestParam gAddressPredictRequestParam, long j3, ICallBackAddressPredictImpl iCallBackAddressPredictImpl);

    private static native long sendReqCancelSignPayNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GCancelSignPayRequestParam gCancelSignPayRequestParam, long j3, ICallBackCancelSignPayImpl iCallBackCancelSignPayImpl);

    private static native long sendReqCarLtdBindNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GCarLtdBindRequestParam gCarLtdBindRequestParam, long j3, ICallBackCarLtdBindImpl iCallBackCarLtdBindImpl);

    private static native long sendReqCarLtdCheckTokenNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GCarLtdCheckTokenRequestParam gCarLtdCheckTokenRequestParam, long j3, ICallBackCarLtdCheckTokenImpl iCallBackCarLtdCheckTokenImpl);

    private static native long sendReqCarLtdQuickLoginNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GCarLtdQuickLoginRequestParam gCarLtdQuickLoginRequestParam, long j3, ICallBackCarLtdQuickLoginImpl iCallBackCarLtdQuickLoginImpl);

    private static native long sendReqCarLtdQuickRegisterNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GCarLtdQuickRegisterRequestParam gCarLtdQuickRegisterRequestParam, long j3, ICallBackCarLtdQuickRegisterImpl iCallBackCarLtdQuickRegisterImpl);

    private static native long sendReqCarLtdUnbindNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GCarLtdUnbindRequestParam gCarLtdUnbindRequestParam, long j3, ICallBackCarLtdUnbindImpl iCallBackCarLtdUnbindImpl);

    private static native long sendReqCouponrecvapplyNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GCouponrecvapplyRequestParam gCouponrecvapplyRequestParam, long j3, ICallBackCouponrecvapplyImpl iCallBackCouponrecvapplyImpl);

    private static native long sendReqCouponrecvlistNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GCouponrecvlistRequestParam gCouponrecvlistRequestParam, long j3, ICallBackCouponrecvlistImpl iCallBackCouponrecvlistImpl);

    private static native long sendReqDriveReportNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GDriveReportUploadRequestParam gDriveReportUploadRequestParam, long j3, ICallBackDriveReportUploadImpl iCallBackDriveReportUploadImpl);

    private static native long sendReqDriveReportSmsNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GDriveReportSmsRequestParam gDriveReportSmsRequestParam, long j3, ICallBackDriveReportSmsImpl iCallBackDriveReportSmsImpl);

    private static native long sendReqEtaRequestRequestNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, CEtaRequestRequestParam cEtaRequestRequestParam, long j3, ICallBackEtaRequestImpl iCallBackEtaRequestImpl);

    private static native long sendReqFeedbackReportNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GFeedbackReportRequestParam gFeedbackReportRequestParam, long j3, ICallBackFeedbackReportImpl iCallBackFeedbackReportImpl);

    private static native long sendReqGasstationcalpriceNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GGasstationcalpriceRequestParam gGasstationcalpriceRequestParam, long j3, ICallBackGasstationcalpriceImpl iCallBackGasstationcalpriceImpl);

    private static native long sendReqHolidayListNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GHolidayListRequestParam gHolidayListRequestParam, long j3, ICallBackHolidayListImpl iCallBackHolidayListImpl);

    private static native long sendReqHttpGetPostNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GHttpGetPostRequestParam gHttpGetPostRequestParam, long j3, ICallBackHttpGetPostImpl iCallBackHttpGetPostImpl);

    private static native long sendReqImGetAppuidNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GImGetAppuidRequestParam gImGetAppuidRequestParam, long j3, ICallBackImGetAppuidImpl iCallBackImGetAppuidImpl);

    private static native long sendReqImGetLoginTokenNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GImGetLoginTokenRequestParam gImGetLoginTokenRequestParam, long j3, ICallBackImGetLoginTokenImpl iCallBackImGetLoginTokenImpl);

    private static native long sendReqLbpEventSyncCommonNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GLbpEventSyncCommonRequestParam gLbpEventSyncCommonRequestParam, long j3, ICallBackLbpEventSyncCommonImpl iCallBackLbpEventSyncCommonImpl);

    private static native long sendReqLogUploadNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GLogUploadRequestParam gLogUploadRequestParam, long j3, ICallBackLogUploadImpl iCallBackLogUploadImpl);

    private static native long sendReqMojiWeatherNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GMojiWeatherRequestParam gMojiWeatherRequestParam, long j3, ICallBackMojiWeatherImpl iCallBackMojiWeatherImpl);

    private static native long sendReqNavigationEtaqueryNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GNavigationEtaqueryRequestParam gNavigationEtaqueryRequestParam, long j3, ICallBackNavigationEtaqueryImpl iCallBackNavigationEtaqueryImpl);

    private static native long sendReqParkOrderCreateNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GParkOrderCreateRequestParam gParkOrderCreateRequestParam, long j3, ICallBackParkOrderCreateImpl iCallBackParkOrderCreateImpl);

    private static native long sendReqParkOrderDetailNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GParkOrderDetailRequestParam gParkOrderDetailRequestParam, long j3, ICallBackParkOrderDetailImpl iCallBackParkOrderDetailImpl);

    private static native long sendReqParkOrderListNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GParkOrderListRequestParam gParkOrderListRequestParam, long j3, ICallBackParkOrderListImpl iCallBackParkOrderListImpl);

    private static native long sendReqParkPayStatusNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GParkPayStatusRequestParam gParkPayStatusRequestParam, long j3, ICallBackParkPayStatusImpl iCallBackParkPayStatusImpl);

    private static native long sendReqParkServiceNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GParkServiceRequestParam gParkServiceRequestParam, long j3, ICallBackParkServiceImpl iCallBackParkServiceImpl);

    private static native long sendReqPaymentBindAlipayNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GPaymentBindAlipayRequestParam gPaymentBindAlipayRequestParam, long j3, ICallBackPaymentBindAlipayImpl iCallBackPaymentBindAlipayImpl);

    private static native long sendReqPaymentStatusNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GPaymentStatusRequestParam gPaymentStatusRequestParam, long j3, ICallBackPaymentStatusImpl iCallBackPaymentStatusImpl);

    private static native long sendReqPaymentUnbindAlipayNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GPaymentUnbindAlipayRequestParam gPaymentUnbindAlipayRequestParam, long j3, ICallBackPaymentUnbindAlipayImpl iCallBackPaymentUnbindAlipayImpl);

    private static native long sendReqQRCodeConfirmNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GQRCodeConfirmRequestParam gQRCodeConfirmRequestParam, long j3, ICallBackQRCodeConfirmImpl iCallBackQRCodeConfirmImpl);

    private static native long sendReqQueryCarMsgNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GQueryCarMsgRequestParam gQueryCarMsgRequestParam, long j3, ICallBackQueryCarMsgImpl iCallBackQueryCarMsgImpl);

    private static native long sendReqQueryPersentWeatherNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GQueryPersentWeatherRequestParam gQueryPersentWeatherRequestParam, long j3, ICallBackQueryPersentWeatherImpl iCallBackQueryPersentWeatherImpl);

    private static native long sendReqQueryWeatherByLinkNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GQueryWeatherByLinkRequestParam gQueryWeatherByLinkRequestParam, long j3, ICallBackQueryWeatherByLinkImpl iCallBackQueryWeatherByLinkImpl);

    private static native long sendReqQuerybylinksNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GQuerybylinksRequestParam gQuerybylinksRequestParam, long j3, ICallBackQuerybylinksImpl iCallBackQuerybylinksImpl);

    private static native long sendReqRangeSpiderNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GRangeSpiderRequestParam gRangeSpiderRequestParam, long j3, ICallBackRangeSpiderImpl iCallBackRangeSpiderImpl);

    private static native long sendReqReStrictedAreaNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GReStrictedAreaRequestParam gReStrictedAreaRequestParam, long j3, ICallBackReStrictedAreaImpl iCallBackReStrictedAreaImpl);

    private static native long sendReqSendToPhoneNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GSendToPhoneRequestParam gSendToPhoneRequestParam, long j3, ICallBackSendToPhoneImpl iCallBackSendToPhoneImpl);

    private static native long sendReqServerTimestampNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GServerTimestampRequestParam gServerTimestampRequestParam, long j3, ICallBackServerTimestampImpl iCallBackServerTimestampImpl);

    private static native long sendReqTrafficEventCommentNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GTrafficEventCommentRequestParam gTrafficEventCommentRequestParam, long j3, ICallBackTrafficEventCommentImpl iCallBackTrafficEventCommentImpl);

    private static native long sendReqTrafficEventDetailNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GTrafficEventDetailRequestParam gTrafficEventDetailRequestParam, long j3, ICallBackTrafficEventDetailImpl iCallBackTrafficEventDetailImpl);

    private static native long sendReqTrafficRestrictNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GTrafficRestrictRequestParam gTrafficRestrictRequestParam, long j3, ICallBackTrafficRestrictImpl iCallBackTrafficRestrictImpl);

    private static native long sendReqTripodCompanyNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GTripodCompanyRequestParam gTripodCompanyRequestParam, long j3, ICallBackTripodCompanyImpl iCallBackTripodCompanyImpl);

    private static native long sendReqUserDeviceNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GUserDeviceRequestParam gUserDeviceRequestParam, long j3, ICallBackUserDeviceImpl iCallBackUserDeviceImpl);

    private static native long sendReqWorkdayListNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWorkdayListRequestParam gWorkdayListRequestParam, long j3, ICallBackWorkdayListImpl iCallBackWorkdayListImpl);

    private static native long sendReqWsAosDestinationSearchNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsAosDestinationSearchRequestParam gWsAosDestinationSearchRequestParam, long j3, ICallBackWsAosDestinationSearchImpl iCallBackWsAosDestinationSearchImpl);

    private static native long sendReqWsAppConfAppUpdateNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsAppConfAppUpdateRequestParam gWsAppConfAppUpdateRequestParam, long j3, ICallBackWsAppConfAppUpdateImpl iCallBackWsAppConfAppUpdateImpl);

    private static native long sendReqWsArchiveTrafficeventUpdateNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsArchiveTrafficeventUpdateRequestParam gWsArchiveTrafficeventUpdateRequestParam, long j3, ICallBackWsArchiveTrafficeventUpdateImpl iCallBackWsArchiveTrafficeventUpdateImpl);

    private static native long sendReqWsAudiHcp3EventSearchNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsAudiHcp3EventSearchRequestParam gWsAudiHcp3EventSearchRequestParam, long j3, ICallBackWsAudiHcp3EventSearchImpl iCallBackWsAudiHcp3EventSearchImpl);

    private static native long sendReqWsAuthcarServiceEnableNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsAuthcarServiceEnableRequestParam gWsAuthcarServiceEnableRequestParam, long j3, ICallBackWsAuthcarServiceEnableImpl iCallBackWsAuthcarServiceEnableImpl);

    private static native long sendReqWsAuthcarServiceProvisionNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsAuthcarServiceProvisionRequestParam gWsAuthcarServiceProvisionRequestParam, long j3, ICallBackWsAuthcarServiceProvisionImpl iCallBackWsAuthcarServiceProvisionImpl);

    private static native long sendReqWsAuthcarServicelistNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsAuthcarServicelistRequestParam gWsAuthcarServicelistRequestParam, long j3, ICallBackWsAuthcarServicelistImpl iCallBackWsAuthcarServicelistImpl);

    private static native long sendReqWsAuthcarTokenNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsAuthcarTokenRequestParam gWsAuthcarTokenRequestParam, long j3, ICallBackWsAuthcarTokenImpl iCallBackWsAuthcarTokenImpl);

    private static native long sendReqWsAutoCollectNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsAutoCollectRequestParam gWsAutoCollectRequestParam, long j3, ICallBackWsAutoCollectImpl iCallBackWsAutoCollectImpl);

    private static native long sendReqWsCloudUploadNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsCloudUploadRequestParam gWsCloudUploadRequestParam, long j3, ICallBackWsCloudUploadImpl iCallBackWsCloudUploadImpl);

    private static native long sendReqWsCommerceInfraChargeRecordsWaitingEnableNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsCommerceInfraChargeRecordsWaitingEnableRequestParam gWsCommerceInfraChargeRecordsWaitingEnableRequestParam, long j3, ICallBackWsCommerceInfraChargeRecordsWaitingEnableImpl iCallBackWsCommerceInfraChargeRecordsWaitingEnableImpl);

    private static native long sendReqWsDeviceAdiusNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsDeviceAdiusRequestParam gWsDeviceAdiusRequestParam, long j3, ICallBackWsDeviceAdiusImpl iCallBackWsDeviceAdiusImpl);

    private static native long sendReqWsFeedbackReviewGetNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsFeedbackReviewGetRequestParam gWsFeedbackReviewGetRequestParam, long j3, ICallBackWsFeedbackReviewGetImpl iCallBackWsFeedbackReviewGetImpl);

    private static native long sendReqWsFeedbackReviewReportNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsFeedbackReviewReportRequestParam gWsFeedbackReviewReportRequestParam, long j3, ICallBackWsFeedbackReviewReportImpl iCallBackWsFeedbackReviewReportImpl);

    private static native long sendReqWsHcp3ChargeListNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsHcp3ChargeListRequestParam gWsHcp3ChargeListRequestParam, long j3, ICallBackWsHcp3ChargeListImpl iCallBackWsHcp3ChargeListImpl);

    private static native long sendReqWsIcsLifeCouponOptionsNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsIcsLifeCouponOptionsRequestParam gWsIcsLifeCouponOptionsRequestParam, long j3, ICallBackWsIcsLifeCouponOptionsImpl iCallBackWsIcsLifeCouponOptionsImpl);

    private static native long sendReqWsIcsLifeUserCouponListNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsIcsLifeUserCouponListRequestParam gWsIcsLifeUserCouponListRequestParam, long j3, ICallBackWsIcsLifeUserCouponListImpl iCallBackWsIcsLifeUserCouponListImpl);

    private static native long sendReqWsMapapiAutoInitNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsMapapiAutoInitRequestParam gWsMapapiAutoInitRequestParam, long j3, ICallBackWsMapapiAutoInitImpl iCallBackWsMapapiAutoInitImpl);

    private static native long sendReqWsMapapiAutoSwitchNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsMapapiAutoSwitchRequestParam gWsMapapiAutoSwitchRequestParam, long j3, ICallBackWsMapapiAutoSwitchImpl iCallBackWsMapapiAutoSwitchImpl);

    private static native long sendReqWsMapapiBenzLinkidsNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsMapapiBenzLinkidsRequestParam gWsMapapiBenzLinkidsRequestParam, long j3, ICallBackWsMapapiBenzLinkidsImpl iCallBackWsMapapiBenzLinkidsImpl);

    private static native long sendReqWsMapapiBenzRoadNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsMapapiBenzRoadRequestParam gWsMapapiBenzRoadRequestParam, long j3, ICallBackWsMapapiBenzRoadImpl iCallBackWsMapapiBenzRoadImpl);

    private static native long sendReqWsMapapiConfOfflineNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsMapapiConfOfflineRequestParam gWsMapapiConfOfflineRequestParam, long j3, ICallBackWsMapapiConfOfflineImpl iCallBackWsMapapiConfOfflineImpl);

    private static native long sendReqWsMapapiGeoCodeNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsMapapiGeoCodeRequestParam gWsMapapiGeoCodeRequestParam, long j3, ICallBackWsMapapiGeoCodeImpl iCallBackWsMapapiGeoCodeImpl);

    private static native long sendReqWsMapapiPoiCodepointNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsMapapiPoiCodepointRequestParam gWsMapapiPoiCodepointRequestParam, long j3, ICallBackWsMapapiPoiCodepointImpl iCallBackWsMapapiPoiCodepointImpl);

    private static native long sendReqWsMapapiPoiVoicesearchNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsMapapiPoiVoicesearchRequestParam gWsMapapiPoiVoicesearchRequestParam, long j3, ICallBackWsMapapiPoiVoicesearchImpl iCallBackWsMapapiPoiVoicesearchImpl);

    private static native long sendReqWsNavigationDynamicDataNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsNavigationDynamicDataRequestParam gWsNavigationDynamicDataRequestParam, long j3, ICallBackWsNavigationDynamicDataImpl iCallBackWsNavigationDynamicDataImpl);

    private static native long sendReqWsNavigationDynamicFatigueNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsNavigationDynamicFatigueRequestParam gWsNavigationDynamicFatigueRequestParam, long j3, ICallBackWsNavigationDynamicFatigueImpl iCallBackWsNavigationDynamicFatigueImpl);

    private static native long sendReqWsNtg6SdsFilesNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsNtg6SdsFilesRequestParam gWsNtg6SdsFilesRequestParam, long j3, ICallBackWsNtg6SdsFilesImpl iCallBackWsNtg6SdsFilesImpl);

    private static native long sendReqWsOssMaplayerListNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsOssMaplayerListRequestParam gWsOssMaplayerListRequestParam, long j3, ICallBackWsOssMaplayerListImpl iCallBackWsOssMaplayerListImpl);

    private static native long sendReqWsPpAccountDeactivateHelpNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsPpAccountDeactivateHelpRequestParam gWsPpAccountDeactivateHelpRequestParam, long j3, ICallBackWsPpAccountDeactivateHelpImpl iCallBackWsPpAccountDeactivateHelpImpl);

    private static native long sendReqWsPpAccountDeactivateNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsPpAccountDeactivateRequestParam gWsPpAccountDeactivateRequestParam, long j3, ICallBackWsPpAccountDeactivateImpl iCallBackWsPpAccountDeactivateImpl);

    private static native long sendReqWsPpAccountProfileUpdateNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsPpAccountProfileUpdateRequestParam gWsPpAccountProfileUpdateRequestParam, long j3, ICallBackWsPpAccountProfileUpdateImpl iCallBackWsPpAccountProfileUpdateImpl);

    private static native long sendReqWsPpAutoWeixinQrcodeNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsPpAutoWeixinQrcodeRequestParam gWsPpAutoWeixinQrcodeRequestParam, long j3, ICallBackWsPpAutoWeixinQrcodeImpl iCallBackWsPpAutoWeixinQrcodeImpl);

    private static native long sendReqWsPpAutoWeixinStatusNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsPpAutoWeixinStatusRequestParam gWsPpAutoWeixinStatusRequestParam, long j3, ICallBackWsPpAutoWeixinStatusImpl iCallBackWsPpAutoWeixinStatusImpl);

    private static native long sendReqWsPpAutoWeixinUnbindNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsPpAutoWeixinUnbindRequestParam gWsPpAutoWeixinUnbindRequestParam, long j3, ICallBackWsPpAutoWeixinUnbindImpl iCallBackWsPpAutoWeixinUnbindImpl);

    private static native long sendReqWsPpCarltdCheckbindNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsPpCarltdCheckbindRequestParam gWsPpCarltdCheckbindRequestParam, long j3, ICallBackWsPpCarltdCheckbindImpl iCallBackWsPpCarltdCheckbindImpl);

    private static native long sendReqWsPpCarltdLogin4bindNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsPpCarltdLogin4bindRequestParam gWsPpCarltdLogin4bindRequestParam, long j3, ICallBackWsPpCarltdLogin4bindImpl iCallBackWsPpCarltdLogin4bindImpl);

    private static native long sendReqWsPpContactBindMobileNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsPpContactBindMobileRequestParam gWsPpContactBindMobileRequestParam, long j3, ICallBackWsPpContactBindMobileImpl iCallBackWsPpContactBindMobileImpl);

    private static native long sendReqWsPpContactUnbindMobileNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsPpContactUnbindMobileRequestParam gWsPpContactUnbindMobileRequestParam, long j3, ICallBackWsPpContactUnbindMobileImpl iCallBackWsPpContactUnbindMobileImpl);

    private static native long sendReqWsPpQrcodeUrlTranslateNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsPpQrcodeUrlTranslateRequestParam gWsPpQrcodeUrlTranslateRequestParam, long j3, ICallBackWsPpQrcodeUrlTranslateImpl iCallBackWsPpQrcodeUrlTranslateImpl);

    private static native long sendReqWsShieldAsbpApiUploadNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsShieldAsbpApiUploadRequestParam gWsShieldAsbpApiUploadRequestParam, long j3, ICallBackWsShieldAsbpApiUploadImpl iCallBackWsShieldAsbpApiUploadImpl);

    private static native long sendReqWsShieldNavigationRoutepathrestorationNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsShieldNavigationRoutepathrestorationRequestParam gWsShieldNavigationRoutepathrestorationRequestParam, long j3, ICallBackWsShieldNavigationRoutepathrestorationImpl iCallBackWsShieldNavigationRoutepathrestorationImpl);

    private static native long sendReqWsShieldSearchMainPageRecNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsShieldSearchMainPageRecRequestParam gWsShieldSearchMainPageRecRequestParam, long j3, ICallBackWsShieldSearchMainPageRecImpl iCallBackWsShieldSearchMainPageRecImpl);

    private static native long sendReqWsShieldSearchRanklistCityNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsShieldSearchRanklistCityRequestParam gWsShieldSearchRanklistCityRequestParam, long j3, ICallBackWsShieldSearchRanklistCityImpl iCallBackWsShieldSearchRanklistCityImpl);

    private static native long sendReqWsShieldSearchRanklistLandingNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsShieldSearchRanklistLandingRequestParam gWsShieldSearchRanklistLandingRequestParam, long j3, ICallBackWsShieldSearchRanklistLandingImpl iCallBackWsShieldSearchRanklistLandingImpl);

    private static native long sendReqWsShieldSearchRanklistPortalNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsShieldSearchRanklistPortalRequestParam gWsShieldSearchRanklistPortalRequestParam, long j3, ICallBackWsShieldSearchRanklistPortalImpl iCallBackWsShieldSearchRanklistPortalImpl);

    private static native long sendReqWsTcCommonAgreementStatusNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTcCommonAgreementStatusRequestParam gWsTcCommonAgreementStatusRequestParam, long j3, ICallBackWsTcCommonAgreementStatusImpl iCallBackWsTcCommonAgreementStatusImpl);

    private static native long sendReqWsTcFuelCancelNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTcFuelCancelRequestParam gWsTcFuelCancelRequestParam, long j3, ICallBackWsTcFuelCancelImpl iCallBackWsTcFuelCancelImpl);

    private static native long sendReqWsTcFuelCreateNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTcFuelCreateRequestParam gWsTcFuelCreateRequestParam, long j3, ICallBackWsTcFuelCreateImpl iCallBackWsTcFuelCreateImpl);

    private static native long sendReqWsTcFuelGetwaitingpayordersNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTcFuelGetwaitingpayordersRequestParam gWsTcFuelGetwaitingpayordersRequestParam, long j3, ICallBackWsTcFuelGetwaitingpayordersImpl iCallBackWsTcFuelGetwaitingpayordersImpl);

    private static native long sendReqWsTcFuelQueryagreementNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTcFuelQueryagreementRequestParam gWsTcFuelQueryagreementRequestParam, long j3, ICallBackWsTcFuelQueryagreementImpl iCallBackWsTcFuelQueryagreementImpl);

    private static native long sendReqWsTcOrderDetailNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTcOrderDetailRequestParam gWsTcOrderDetailRequestParam, long j3, ICallBackWsTcOrderDetailImpl iCallBackWsTcOrderDetailImpl);

    private static native long sendReqWsTcOrderListNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTcOrderListRequestParam gWsTcOrderListRequestParam, long j3, ICallBackWsTcOrderListImpl iCallBackWsTcOrderListImpl);

    private static native long sendReqWsTserviceInternalLinkAutoReportNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceInternalLinkAutoReportRequestParam gWsTserviceInternalLinkAutoReportRequestParam, long j3, ICallBackWsTserviceInternalLinkAutoReportImpl iCallBackWsTserviceInternalLinkAutoReportImpl);

    private static native long sendReqWsTserviceInternalLinkCarGetNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceInternalLinkCarGetRequestParam gWsTserviceInternalLinkCarGetRequestParam, long j3, ICallBackWsTserviceInternalLinkCarGetImpl iCallBackWsTserviceInternalLinkCarGetImpl);

    private static native long sendReqWsTserviceInternalLinkCarReportNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceInternalLinkCarReportRequestParam gWsTserviceInternalLinkCarReportRequestParam, long j3, ICallBackWsTserviceInternalLinkCarReportImpl iCallBackWsTserviceInternalLinkCarReportImpl);

    private static native long sendReqWsTserviceIotDeviceListNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceIotDeviceListRequestParam gWsTserviceIotDeviceListRequestParam, long j3, ICallBackWsTserviceIotDeviceListImpl iCallBackWsTserviceIotDeviceListImpl);

    private static native long sendReqWsTserviceIotDeviceRelieveNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceIotDeviceRelieveRequestParam gWsTserviceIotDeviceRelieveRequestParam, long j3, ICallBackWsTserviceIotDeviceRelieveImpl iCallBackWsTserviceIotDeviceRelieveImpl);

    private static native long sendReqWsTserviceIotTripodEventNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceIotTripodEventRequestParam gWsTserviceIotTripodEventRequestParam, long j3, ICallBackWsTserviceIotTripodEventImpl iCallBackWsTserviceIotTripodEventImpl);

    private static native long sendReqWsTserviceIotTripodSnAutoBindForceNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceIotTripodSnAutoBindForceRequestParam gWsTserviceIotTripodSnAutoBindForceRequestParam, long j3, ICallBackWsTserviceIotTripodSnAutoBindForceImpl iCallBackWsTserviceIotTripodSnAutoBindForceImpl);

    private static native long sendReqWsTserviceIotTripodSnAutoBindNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceIotTripodSnAutoBindRequestParam gWsTserviceIotTripodSnAutoBindRequestParam, long j3, ICallBackWsTserviceIotTripodSnAutoBindImpl iCallBackWsTserviceIotTripodSnAutoBindImpl);

    private static native long sendReqWsTserviceIotTripodSnAutoBoundNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceIotTripodSnAutoBoundRequestParam gWsTserviceIotTripodSnAutoBoundRequestParam, long j3, ICallBackWsTserviceIotTripodSnAutoBoundImpl iCallBackWsTserviceIotTripodSnAutoBoundImpl);

    private static native long sendReqWsTserviceIotTripodStatusNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceIotTripodStatusRequestParam gWsTserviceIotTripodStatusRequestParam, long j3, ICallBackWsTserviceIotTripodStatusImpl iCallBackWsTserviceIotTripodStatusImpl);

    private static native long sendReqWsTserviceRequestIpNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceRequestIpRequestParam gWsTserviceRequestIpRequestParam, long j3, ICallBackWsTserviceRequestIpImpl iCallBackWsTserviceRequestIpImpl);

    private static native long sendReqWsTserviceTeamCreateNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceTeamCreateRequestParam gWsTserviceTeamCreateRequestParam, long j3, ICallBackWsTserviceTeamCreateImpl iCallBackWsTserviceTeamCreateImpl);

    private static native long sendReqWsTserviceTeamDismissNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceTeamDismissRequestParam gWsTserviceTeamDismissRequestParam, long j3, ICallBackWsTserviceTeamDismissImpl iCallBackWsTserviceTeamDismissImpl);

    private static native long sendReqWsTserviceTeamInfoGetNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceTeamInfoGetRequestParam gWsTserviceTeamInfoGetRequestParam, long j3, ICallBackWsTserviceTeamInfoGetImpl iCallBackWsTserviceTeamInfoGetImpl);

    private static native long sendReqWsTserviceTeamInfoUpdateNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceTeamInfoUpdateRequestParam gWsTserviceTeamInfoUpdateRequestParam, long j3, ICallBackWsTserviceTeamInfoUpdateImpl iCallBackWsTserviceTeamInfoUpdateImpl);

    private static native long sendReqWsTserviceTeamInviteNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceTeamInviteRequestParam gWsTserviceTeamInviteRequestParam, long j3, ICallBackWsTserviceTeamInviteImpl iCallBackWsTserviceTeamInviteImpl);

    private static native long sendReqWsTserviceTeamJoinNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceTeamJoinRequestParam gWsTserviceTeamJoinRequestParam, long j3, ICallBackWsTserviceTeamJoinImpl iCallBackWsTserviceTeamJoinImpl);

    private static native long sendReqWsTserviceTeamKickNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceTeamKickRequestParam gWsTserviceTeamKickRequestParam, long j3, ICallBackWsTserviceTeamKickImpl iCallBackWsTserviceTeamKickImpl);

    private static native long sendReqWsTserviceTeamQrNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceTeamQrRequestParam gWsTserviceTeamQrRequestParam, long j3, ICallBackWsTserviceTeamQrImpl iCallBackWsTserviceTeamQrImpl);

    private static native long sendReqWsTserviceTeamQuitNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceTeamQuitRequestParam gWsTserviceTeamQuitRequestParam, long j3, ICallBackWsTserviceTeamQuitImpl iCallBackWsTserviceTeamQuitImpl);

    private static native long sendReqWsTserviceTeamUserFriendsNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceTeamUserFriendsRequestParam gWsTserviceTeamUserFriendsRequestParam, long j3, ICallBackWsTserviceTeamUserFriendsImpl iCallBackWsTserviceTeamUserFriendsImpl);

    private static native long sendReqWsTserviceTeamUserStatusNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceTeamUserStatusRequestParam gWsTserviceTeamUserStatusRequestParam, long j3, ICallBackWsTserviceTeamUserStatusImpl iCallBackWsTserviceTeamUserStatusImpl);

    private static native long sendReqWsTserviceTeamUserTnnUpdateNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsTserviceTeamUserTnnUpdateRequestParam gWsTserviceTeamUserTnnUpdateRequestParam, long j3, ICallBackWsTserviceTeamUserTnnUpdateImpl iCallBackWsTserviceTeamUserTnnUpdateImpl);

    private static native long sendReqWsUserviewFootprintNaviDeleteNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsUserviewFootprintNaviDeleteRequestParam gWsUserviewFootprintNaviDeleteRequestParam, long j3, ICallBackWsUserviewFootprintNaviDeleteImpl iCallBackWsUserviewFootprintNaviDeleteImpl);

    private static native long sendReqWsUserviewFootprintNaviRecordNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsUserviewFootprintNaviRecordRequestParam gWsUserviewFootprintNaviRecordRequestParam, long j3, ICallBackWsUserviewFootprintNaviRecordImpl iCallBackWsUserviewFootprintNaviRecordImpl);

    private static native long sendReqWsUserviewFootprintSummaryNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsUserviewFootprintSummaryRequestParam gWsUserviewFootprintSummaryRequestParam, long j3, ICallBackWsUserviewFootprintSummaryImpl iCallBackWsUserviewFootprintSummaryImpl);

    private static native long sendReqWsUserviewFootprintSwitchNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsUserviewFootprintSwitchRequestParam gWsUserviewFootprintSwitchRequestParam, long j3, ICallBackWsUserviewFootprintSwitchImpl iCallBackWsUserviewFootprintSwitchImpl);

    private static native long sendReqWsVaCarLogoExchangeNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsVaCarLogoExchangeRequestParam gWsVaCarLogoExchangeRequestParam, long j3, ICallBackWsVaCarLogoExchangeImpl iCallBackWsVaCarLogoExchangeImpl);

    private static native long sendReqWsVaCarLogoNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsVaCarLogoRequestParam gWsVaCarLogoRequestParam, long j3, ICallBackWsVaCarLogoImpl iCallBackWsVaCarLogoImpl);

    private static native long sendReqWsVaCarLogoSelectNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, GWsVaCarLogoSelectRequestParam gWsVaCarLogoSelectRequestParam, long j3, ICallBackWsVaCarLogoSelectImpl iCallBackWsVaCarLogoSelectImpl);

    private static native boolean setCookieNative(long j, IBLAosServiceImpl iBLAosServiceImpl, long j2, BLAosCookie bLAosCookie);

    private static native void unInitNative(long j, IBLAosServiceImpl iBLAosServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IBLAosServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBLAosServiceImpl) && getUID(this) == getUID((IBLAosServiceImpl) obj);
    }

    private static long getUID(IBLAosServiceImpl iBLAosServiceImpl) {
        long cPtr = getCPtr(iBLAosServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBLAosServiceImpl iBLAosServiceImpl) {
        if (iBLAosServiceImpl == null) {
            return 0L;
        }
        return iBLAosServiceImpl.swigCPtr;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        return this.swigCPtr;
    }

    protected synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public IBLAosServiceImpl() {
        this(createNativeObj(), true);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    public String getVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVersionNative(j, this);
    }

    public void logSwitch(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        logSwitchNative(j, this, i);
    }

    public int getServiceID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getServiceIDNative(j, this);
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInitNative(j, this);
    }

    public BLAosCookie getCookie() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCookieNative(j, this);
    }

    public boolean setCookie(BLAosCookie bLAosCookie) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setCookieNative(j, this, 0L, bLAosCookie);
    }

    public int abortRequest(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return abortRequestNative(j2, this, j);
    }

    public long sendReqNavigationEtaquery(GNavigationEtaqueryRequestParam gNavigationEtaqueryRequestParam, ICallBackNavigationEtaqueryImpl iCallBackNavigationEtaqueryImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqNavigationEtaqueryNative(j, this, 0L, gNavigationEtaqueryRequestParam, ICallBackNavigationEtaqueryImpl.getCPtr(iCallBackNavigationEtaqueryImpl), iCallBackNavigationEtaqueryImpl);
    }

    public long sendReqRangeSpider(GRangeSpiderRequestParam gRangeSpiderRequestParam, ICallBackRangeSpiderImpl iCallBackRangeSpiderImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqRangeSpiderNative(j, this, 0L, gRangeSpiderRequestParam, ICallBackRangeSpiderImpl.getCPtr(iCallBackRangeSpiderImpl), iCallBackRangeSpiderImpl);
    }

    public long sendReqQueryWeatherByLink(GQueryWeatherByLinkRequestParam gQueryWeatherByLinkRequestParam, ICallBackQueryWeatherByLinkImpl iCallBackQueryWeatherByLinkImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqQueryWeatherByLinkNative(j, this, 0L, gQueryWeatherByLinkRequestParam, ICallBackQueryWeatherByLinkImpl.getCPtr(iCallBackQueryWeatherByLinkImpl), iCallBackQueryWeatherByLinkImpl);
    }

    public long sendReqQueryPersentWeather(GQueryPersentWeatherRequestParam gQueryPersentWeatherRequestParam, ICallBackQueryPersentWeatherImpl iCallBackQueryPersentWeatherImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqQueryPersentWeatherNative(j, this, 0L, gQueryPersentWeatherRequestParam, ICallBackQueryPersentWeatherImpl.getCPtr(iCallBackQueryPersentWeatherImpl), iCallBackQueryPersentWeatherImpl);
    }

    public long sendReqEtaRequestRequest(CEtaRequestRequestParam cEtaRequestRequestParam, ICallBackEtaRequestImpl iCallBackEtaRequestImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqEtaRequestRequestNative(j, this, 0L, cEtaRequestRequestParam, ICallBackEtaRequestImpl.getCPtr(iCallBackEtaRequestImpl), iCallBackEtaRequestImpl);
    }

    public long sendReqAddressPredict(GAddressPredictRequestParam gAddressPredictRequestParam, ICallBackAddressPredictImpl iCallBackAddressPredictImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqAddressPredictNative(j, this, 0L, gAddressPredictRequestParam, ICallBackAddressPredictImpl.getCPtr(iCallBackAddressPredictImpl), iCallBackAddressPredictImpl);
    }

    public long sendReqHolidayList(GHolidayListRequestParam gHolidayListRequestParam, ICallBackHolidayListImpl iCallBackHolidayListImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqHolidayListNative(j, this, 0L, gHolidayListRequestParam, ICallBackHolidayListImpl.getCPtr(iCallBackHolidayListImpl), iCallBackHolidayListImpl);
    }

    public long sendReqMojiWeather(GMojiWeatherRequestParam gMojiWeatherRequestParam, ICallBackMojiWeatherImpl iCallBackMojiWeatherImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqMojiWeatherNative(j, this, 0L, gMojiWeatherRequestParam, ICallBackMojiWeatherImpl.getCPtr(iCallBackMojiWeatherImpl), iCallBackMojiWeatherImpl);
    }

    public long sendReqReStrictedArea(GReStrictedAreaRequestParam gReStrictedAreaRequestParam, ICallBackReStrictedAreaImpl iCallBackReStrictedAreaImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqReStrictedAreaNative(j, this, 0L, gReStrictedAreaRequestParam, ICallBackReStrictedAreaImpl.getCPtr(iCallBackReStrictedAreaImpl), iCallBackReStrictedAreaImpl);
    }

    public long sendReqWorkdayList(GWorkdayListRequestParam gWorkdayListRequestParam, ICallBackWorkdayListImpl iCallBackWorkdayListImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWorkdayListNative(j, this, 0L, gWorkdayListRequestParam, ICallBackWorkdayListImpl.getCPtr(iCallBackWorkdayListImpl), iCallBackWorkdayListImpl);
    }

    public long sendReqWsMapapiPoiVoicesearch(GWsMapapiPoiVoicesearchRequestParam gWsMapapiPoiVoicesearchRequestParam, ICallBackWsMapapiPoiVoicesearchImpl iCallBackWsMapapiPoiVoicesearchImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsMapapiPoiVoicesearchNative(j, this, 0L, gWsMapapiPoiVoicesearchRequestParam, ICallBackWsMapapiPoiVoicesearchImpl.getCPtr(iCallBackWsMapapiPoiVoicesearchImpl), iCallBackWsMapapiPoiVoicesearchImpl);
    }

    public long sendReqWsMapapiPoiCodepoint(GWsMapapiPoiCodepointRequestParam gWsMapapiPoiCodepointRequestParam, ICallBackWsMapapiPoiCodepointImpl iCallBackWsMapapiPoiCodepointImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsMapapiPoiCodepointNative(j, this, 0L, gWsMapapiPoiCodepointRequestParam, ICallBackWsMapapiPoiCodepointImpl.getCPtr(iCallBackWsMapapiPoiCodepointImpl), iCallBackWsMapapiPoiCodepointImpl);
    }

    public long sendReqWsAppConfAppUpdate(GWsAppConfAppUpdateRequestParam gWsAppConfAppUpdateRequestParam, ICallBackWsAppConfAppUpdateImpl iCallBackWsAppConfAppUpdateImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsAppConfAppUpdateNative(j, this, 0L, gWsAppConfAppUpdateRequestParam, ICallBackWsAppConfAppUpdateImpl.getCPtr(iCallBackWsAppConfAppUpdateImpl), iCallBackWsAppConfAppUpdateImpl);
    }

    public long sendReqWsMapapiGeoCode(GWsMapapiGeoCodeRequestParam gWsMapapiGeoCodeRequestParam, ICallBackWsMapapiGeoCodeImpl iCallBackWsMapapiGeoCodeImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsMapapiGeoCodeNative(j, this, 0L, gWsMapapiGeoCodeRequestParam, ICallBackWsMapapiGeoCodeImpl.getCPtr(iCallBackWsMapapiGeoCodeImpl), iCallBackWsMapapiGeoCodeImpl);
    }

    public long sendReqWsMapapiAutoSwitch(GWsMapapiAutoSwitchRequestParam gWsMapapiAutoSwitchRequestParam, ICallBackWsMapapiAutoSwitchImpl iCallBackWsMapapiAutoSwitchImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsMapapiAutoSwitchNative(j, this, 0L, gWsMapapiAutoSwitchRequestParam, ICallBackWsMapapiAutoSwitchImpl.getCPtr(iCallBackWsMapapiAutoSwitchImpl), iCallBackWsMapapiAutoSwitchImpl);
    }

    public long sendReqCancelSignPay(GCancelSignPayRequestParam gCancelSignPayRequestParam, ICallBackCancelSignPayImpl iCallBackCancelSignPayImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqCancelSignPayNative(j, this, 0L, gCancelSignPayRequestParam, ICallBackCancelSignPayImpl.getCPtr(iCallBackCancelSignPayImpl), iCallBackCancelSignPayImpl);
    }

    public long sendReqFeedbackReport(GFeedbackReportRequestParam gFeedbackReportRequestParam, ICallBackFeedbackReportImpl iCallBackFeedbackReportImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqFeedbackReportNative(j, this, 0L, gFeedbackReportRequestParam, ICallBackFeedbackReportImpl.getCPtr(iCallBackFeedbackReportImpl), iCallBackFeedbackReportImpl);
    }

    public long sendReqParkService(GParkServiceRequestParam gParkServiceRequestParam, ICallBackParkServiceImpl iCallBackParkServiceImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqParkServiceNative(j, this, 0L, gParkServiceRequestParam, ICallBackParkServiceImpl.getCPtr(iCallBackParkServiceImpl), iCallBackParkServiceImpl);
    }

    public long sendReqParkOrderCreate(GParkOrderCreateRequestParam gParkOrderCreateRequestParam, ICallBackParkOrderCreateImpl iCallBackParkOrderCreateImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqParkOrderCreateNative(j, this, 0L, gParkOrderCreateRequestParam, ICallBackParkOrderCreateImpl.getCPtr(iCallBackParkOrderCreateImpl), iCallBackParkOrderCreateImpl);
    }

    public long sendReqParkOrderDetail(GParkOrderDetailRequestParam gParkOrderDetailRequestParam, ICallBackParkOrderDetailImpl iCallBackParkOrderDetailImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqParkOrderDetailNative(j, this, 0L, gParkOrderDetailRequestParam, ICallBackParkOrderDetailImpl.getCPtr(iCallBackParkOrderDetailImpl), iCallBackParkOrderDetailImpl);
    }

    public long sendReqParkOrderList(GParkOrderListRequestParam gParkOrderListRequestParam, ICallBackParkOrderListImpl iCallBackParkOrderListImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqParkOrderListNative(j, this, 0L, gParkOrderListRequestParam, ICallBackParkOrderListImpl.getCPtr(iCallBackParkOrderListImpl), iCallBackParkOrderListImpl);
    }

    public long sendReqParkPayStatus(GParkPayStatusRequestParam gParkPayStatusRequestParam, ICallBackParkPayStatusImpl iCallBackParkPayStatusImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqParkPayStatusNative(j, this, 0L, gParkPayStatusRequestParam, ICallBackParkPayStatusImpl.getCPtr(iCallBackParkPayStatusImpl), iCallBackParkPayStatusImpl);
    }

    public long sendReqTrafficEventComment(GTrafficEventCommentRequestParam gTrafficEventCommentRequestParam, ICallBackTrafficEventCommentImpl iCallBackTrafficEventCommentImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqTrafficEventCommentNative(j, this, 0L, gTrafficEventCommentRequestParam, ICallBackTrafficEventCommentImpl.getCPtr(iCallBackTrafficEventCommentImpl), iCallBackTrafficEventCommentImpl);
    }

    public long sendReqTrafficEventDetail(GTrafficEventDetailRequestParam gTrafficEventDetailRequestParam, ICallBackTrafficEventDetailImpl iCallBackTrafficEventDetailImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqTrafficEventDetailNative(j, this, 0L, gTrafficEventDetailRequestParam, ICallBackTrafficEventDetailImpl.getCPtr(iCallBackTrafficEventDetailImpl), iCallBackTrafficEventDetailImpl);
    }

    public long sendReqUserDevice(GUserDeviceRequestParam gUserDeviceRequestParam, ICallBackUserDeviceImpl iCallBackUserDeviceImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqUserDeviceNative(j, this, 0L, gUserDeviceRequestParam, ICallBackUserDeviceImpl.getCPtr(iCallBackUserDeviceImpl), iCallBackUserDeviceImpl);
    }

    public long sendReqQRCodeConfirm(GQRCodeConfirmRequestParam gQRCodeConfirmRequestParam, ICallBackQRCodeConfirmImpl iCallBackQRCodeConfirmImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqQRCodeConfirmNative(j, this, 0L, gQRCodeConfirmRequestParam, ICallBackQRCodeConfirmImpl.getCPtr(iCallBackQRCodeConfirmImpl), iCallBackQRCodeConfirmImpl);
    }

    public long sendReqWsArchiveTrafficeventUpdate(GWsArchiveTrafficeventUpdateRequestParam gWsArchiveTrafficeventUpdateRequestParam, ICallBackWsArchiveTrafficeventUpdateImpl iCallBackWsArchiveTrafficeventUpdateImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsArchiveTrafficeventUpdateNative(j, this, 0L, gWsArchiveTrafficeventUpdateRequestParam, ICallBackWsArchiveTrafficeventUpdateImpl.getCPtr(iCallBackWsArchiveTrafficeventUpdateImpl), iCallBackWsArchiveTrafficeventUpdateImpl);
    }

    public long sendReqWsPpAccountProfileUpdate(GWsPpAccountProfileUpdateRequestParam gWsPpAccountProfileUpdateRequestParam, ICallBackWsPpAccountProfileUpdateImpl iCallBackWsPpAccountProfileUpdateImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsPpAccountProfileUpdateNative(j, this, 0L, gWsPpAccountProfileUpdateRequestParam, ICallBackWsPpAccountProfileUpdateImpl.getCPtr(iCallBackWsPpAccountProfileUpdateImpl), iCallBackWsPpAccountProfileUpdateImpl);
    }

    public long sendReqCarLtdBind(GCarLtdBindRequestParam gCarLtdBindRequestParam, ICallBackCarLtdBindImpl iCallBackCarLtdBindImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqCarLtdBindNative(j, this, 0L, gCarLtdBindRequestParam, ICallBackCarLtdBindImpl.getCPtr(iCallBackCarLtdBindImpl), iCallBackCarLtdBindImpl);
    }

    public long sendReqCarLtdUnbind(GCarLtdUnbindRequestParam gCarLtdUnbindRequestParam, ICallBackCarLtdUnbindImpl iCallBackCarLtdUnbindImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqCarLtdUnbindNative(j, this, 0L, gCarLtdUnbindRequestParam, ICallBackCarLtdUnbindImpl.getCPtr(iCallBackCarLtdUnbindImpl), iCallBackCarLtdUnbindImpl);
    }

    public long sendReqCarLtdCheckToken(GCarLtdCheckTokenRequestParam gCarLtdCheckTokenRequestParam, ICallBackCarLtdCheckTokenImpl iCallBackCarLtdCheckTokenImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqCarLtdCheckTokenNative(j, this, 0L, gCarLtdCheckTokenRequestParam, ICallBackCarLtdCheckTokenImpl.getCPtr(iCallBackCarLtdCheckTokenImpl), iCallBackCarLtdCheckTokenImpl);
    }

    public long sendReqCarLtdQuickLogin(GCarLtdQuickLoginRequestParam gCarLtdQuickLoginRequestParam, ICallBackCarLtdQuickLoginImpl iCallBackCarLtdQuickLoginImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqCarLtdQuickLoginNative(j, this, 0L, gCarLtdQuickLoginRequestParam, ICallBackCarLtdQuickLoginImpl.getCPtr(iCallBackCarLtdQuickLoginImpl), iCallBackCarLtdQuickLoginImpl);
    }

    public long sendReqCarLtdQuickRegister(GCarLtdQuickRegisterRequestParam gCarLtdQuickRegisterRequestParam, ICallBackCarLtdQuickRegisterImpl iCallBackCarLtdQuickRegisterImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqCarLtdQuickRegisterNative(j, this, 0L, gCarLtdQuickRegisterRequestParam, ICallBackCarLtdQuickRegisterImpl.getCPtr(iCallBackCarLtdQuickRegisterImpl), iCallBackCarLtdQuickRegisterImpl);
    }

    public long sendReqPaymentBindAlipay(GPaymentBindAlipayRequestParam gPaymentBindAlipayRequestParam, ICallBackPaymentBindAlipayImpl iCallBackPaymentBindAlipayImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqPaymentBindAlipayNative(j, this, 0L, gPaymentBindAlipayRequestParam, ICallBackPaymentBindAlipayImpl.getCPtr(iCallBackPaymentBindAlipayImpl), iCallBackPaymentBindAlipayImpl);
    }

    public long sendReqPaymentStatus(GPaymentStatusRequestParam gPaymentStatusRequestParam, ICallBackPaymentStatusImpl iCallBackPaymentStatusImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqPaymentStatusNative(j, this, 0L, gPaymentStatusRequestParam, ICallBackPaymentStatusImpl.getCPtr(iCallBackPaymentStatusImpl), iCallBackPaymentStatusImpl);
    }

    public long sendReqPaymentUnbindAlipay(GPaymentUnbindAlipayRequestParam gPaymentUnbindAlipayRequestParam, ICallBackPaymentUnbindAlipayImpl iCallBackPaymentUnbindAlipayImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqPaymentUnbindAlipayNative(j, this, 0L, gPaymentUnbindAlipayRequestParam, ICallBackPaymentUnbindAlipayImpl.getCPtr(iCallBackPaymentUnbindAlipayImpl), iCallBackPaymentUnbindAlipayImpl);
    }

    public long sendReqWsPpAutoWeixinQrcode(GWsPpAutoWeixinQrcodeRequestParam gWsPpAutoWeixinQrcodeRequestParam, ICallBackWsPpAutoWeixinQrcodeImpl iCallBackWsPpAutoWeixinQrcodeImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsPpAutoWeixinQrcodeNative(j, this, 0L, gWsPpAutoWeixinQrcodeRequestParam, ICallBackWsPpAutoWeixinQrcodeImpl.getCPtr(iCallBackWsPpAutoWeixinQrcodeImpl), iCallBackWsPpAutoWeixinQrcodeImpl);
    }

    public long sendReqWsPpAutoWeixinUnbind(GWsPpAutoWeixinUnbindRequestParam gWsPpAutoWeixinUnbindRequestParam, ICallBackWsPpAutoWeixinUnbindImpl iCallBackWsPpAutoWeixinUnbindImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsPpAutoWeixinUnbindNative(j, this, 0L, gWsPpAutoWeixinUnbindRequestParam, ICallBackWsPpAutoWeixinUnbindImpl.getCPtr(iCallBackWsPpAutoWeixinUnbindImpl), iCallBackWsPpAutoWeixinUnbindImpl);
    }

    public long sendReqWsPpAutoWeixinStatus(GWsPpAutoWeixinStatusRequestParam gWsPpAutoWeixinStatusRequestParam, ICallBackWsPpAutoWeixinStatusImpl iCallBackWsPpAutoWeixinStatusImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsPpAutoWeixinStatusNative(j, this, 0L, gWsPpAutoWeixinStatusRequestParam, ICallBackWsPpAutoWeixinStatusImpl.getCPtr(iCallBackWsPpAutoWeixinStatusImpl), iCallBackWsPpAutoWeixinStatusImpl);
    }

    public long sendReqWsPpQrcodeUrlTranslate(GWsPpQrcodeUrlTranslateRequestParam gWsPpQrcodeUrlTranslateRequestParam, ICallBackWsPpQrcodeUrlTranslateImpl iCallBackWsPpQrcodeUrlTranslateImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsPpQrcodeUrlTranslateNative(j, this, 0L, gWsPpQrcodeUrlTranslateRequestParam, ICallBackWsPpQrcodeUrlTranslateImpl.getCPtr(iCallBackWsPpQrcodeUrlTranslateImpl), iCallBackWsPpQrcodeUrlTranslateImpl);
    }

    public long sendReqWsPpCarltdCheckbind(GWsPpCarltdCheckbindRequestParam gWsPpCarltdCheckbindRequestParam, ICallBackWsPpCarltdCheckbindImpl iCallBackWsPpCarltdCheckbindImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsPpCarltdCheckbindNative(j, this, 0L, gWsPpCarltdCheckbindRequestParam, ICallBackWsPpCarltdCheckbindImpl.getCPtr(iCallBackWsPpCarltdCheckbindImpl), iCallBackWsPpCarltdCheckbindImpl);
    }

    public long sendReqDriveReportSms(GDriveReportSmsRequestParam gDriveReportSmsRequestParam, ICallBackDriveReportSmsImpl iCallBackDriveReportSmsImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqDriveReportSmsNative(j, this, 0L, gDriveReportSmsRequestParam, ICallBackDriveReportSmsImpl.getCPtr(iCallBackDriveReportSmsImpl), iCallBackDriveReportSmsImpl);
    }

    public long sendReqTrafficRestrict(GTrafficRestrictRequestParam gTrafficRestrictRequestParam, ICallBackTrafficRestrictImpl iCallBackTrafficRestrictImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqTrafficRestrictNative(j, this, 0L, gTrafficRestrictRequestParam, ICallBackTrafficRestrictImpl.getCPtr(iCallBackTrafficRestrictImpl), iCallBackTrafficRestrictImpl);
    }

    public long sendReqDriveReport(GDriveReportUploadRequestParam gDriveReportUploadRequestParam, ICallBackDriveReportUploadImpl iCallBackDriveReportUploadImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqDriveReportNative(j, this, 0L, gDriveReportUploadRequestParam, ICallBackDriveReportUploadImpl.getCPtr(iCallBackDriveReportUploadImpl), iCallBackDriveReportUploadImpl);
    }

    public long sendReqLogUpload(GLogUploadRequestParam gLogUploadRequestParam, ICallBackLogUploadImpl iCallBackLogUploadImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqLogUploadNative(j, this, 0L, gLogUploadRequestParam, ICallBackLogUploadImpl.getCPtr(iCallBackLogUploadImpl), iCallBackLogUploadImpl);
    }

    public long sendReqQueryCarMsg(GQueryCarMsgRequestParam gQueryCarMsgRequestParam, ICallBackQueryCarMsgImpl iCallBackQueryCarMsgImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqQueryCarMsgNative(j, this, 0L, gQueryCarMsgRequestParam, ICallBackQueryCarMsgImpl.getCPtr(iCallBackQueryCarMsgImpl), iCallBackQueryCarMsgImpl);
    }

    public long sendReqSendToPhone(GSendToPhoneRequestParam gSendToPhoneRequestParam, ICallBackSendToPhoneImpl iCallBackSendToPhoneImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqSendToPhoneNative(j, this, 0L, gSendToPhoneRequestParam, ICallBackSendToPhoneImpl.getCPtr(iCallBackSendToPhoneImpl), iCallBackSendToPhoneImpl);
    }

    public long sendReqWsTserviceTeamCreate(GWsTserviceTeamCreateRequestParam gWsTserviceTeamCreateRequestParam, ICallBackWsTserviceTeamCreateImpl iCallBackWsTserviceTeamCreateImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceTeamCreateNative(j, this, 0L, gWsTserviceTeamCreateRequestParam, ICallBackWsTserviceTeamCreateImpl.getCPtr(iCallBackWsTserviceTeamCreateImpl), iCallBackWsTserviceTeamCreateImpl);
    }

    public long sendReqWsTserviceTeamUserStatus(GWsTserviceTeamUserStatusRequestParam gWsTserviceTeamUserStatusRequestParam, ICallBackWsTserviceTeamUserStatusImpl iCallBackWsTserviceTeamUserStatusImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceTeamUserStatusNative(j, this, 0L, gWsTserviceTeamUserStatusRequestParam, ICallBackWsTserviceTeamUserStatusImpl.getCPtr(iCallBackWsTserviceTeamUserStatusImpl), iCallBackWsTserviceTeamUserStatusImpl);
    }

    public long sendReqWsTserviceTeamJoin(GWsTserviceTeamJoinRequestParam gWsTserviceTeamJoinRequestParam, ICallBackWsTserviceTeamJoinImpl iCallBackWsTserviceTeamJoinImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceTeamJoinNative(j, this, 0L, gWsTserviceTeamJoinRequestParam, ICallBackWsTserviceTeamJoinImpl.getCPtr(iCallBackWsTserviceTeamJoinImpl), iCallBackWsTserviceTeamJoinImpl);
    }

    public long sendReqWsTserviceTeamUserFriends(GWsTserviceTeamUserFriendsRequestParam gWsTserviceTeamUserFriendsRequestParam, ICallBackWsTserviceTeamUserFriendsImpl iCallBackWsTserviceTeamUserFriendsImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceTeamUserFriendsNative(j, this, 0L, gWsTserviceTeamUserFriendsRequestParam, ICallBackWsTserviceTeamUserFriendsImpl.getCPtr(iCallBackWsTserviceTeamUserFriendsImpl), iCallBackWsTserviceTeamUserFriendsImpl);
    }

    public long sendReqWsTserviceTeamQr(GWsTserviceTeamQrRequestParam gWsTserviceTeamQrRequestParam, ICallBackWsTserviceTeamQrImpl iCallBackWsTserviceTeamQrImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceTeamQrNative(j, this, 0L, gWsTserviceTeamQrRequestParam, ICallBackWsTserviceTeamQrImpl.getCPtr(iCallBackWsTserviceTeamQrImpl), iCallBackWsTserviceTeamQrImpl);
    }

    public long sendReqWsTserviceTeamInvite(GWsTserviceTeamInviteRequestParam gWsTserviceTeamInviteRequestParam, ICallBackWsTserviceTeamInviteImpl iCallBackWsTserviceTeamInviteImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceTeamInviteNative(j, this, 0L, gWsTserviceTeamInviteRequestParam, ICallBackWsTserviceTeamInviteImpl.getCPtr(iCallBackWsTserviceTeamInviteImpl), iCallBackWsTserviceTeamInviteImpl);
    }

    public long sendReqWsTserviceTeamInfoGet(GWsTserviceTeamInfoGetRequestParam gWsTserviceTeamInfoGetRequestParam, ICallBackWsTserviceTeamInfoGetImpl iCallBackWsTserviceTeamInfoGetImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceTeamInfoGetNative(j, this, 0L, gWsTserviceTeamInfoGetRequestParam, ICallBackWsTserviceTeamInfoGetImpl.getCPtr(iCallBackWsTserviceTeamInfoGetImpl), iCallBackWsTserviceTeamInfoGetImpl);
    }

    public long sendReqWsTserviceTeamKick(GWsTserviceTeamKickRequestParam gWsTserviceTeamKickRequestParam, ICallBackWsTserviceTeamKickImpl iCallBackWsTserviceTeamKickImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceTeamKickNative(j, this, 0L, gWsTserviceTeamKickRequestParam, ICallBackWsTserviceTeamKickImpl.getCPtr(iCallBackWsTserviceTeamKickImpl), iCallBackWsTserviceTeamKickImpl);
    }

    public long sendReqWsTserviceTeamQuit(GWsTserviceTeamQuitRequestParam gWsTserviceTeamQuitRequestParam, ICallBackWsTserviceTeamQuitImpl iCallBackWsTserviceTeamQuitImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceTeamQuitNative(j, this, 0L, gWsTserviceTeamQuitRequestParam, ICallBackWsTserviceTeamQuitImpl.getCPtr(iCallBackWsTserviceTeamQuitImpl), iCallBackWsTserviceTeamQuitImpl);
    }

    public long sendReqWsTserviceTeamDismiss(GWsTserviceTeamDismissRequestParam gWsTserviceTeamDismissRequestParam, ICallBackWsTserviceTeamDismissImpl iCallBackWsTserviceTeamDismissImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceTeamDismissNative(j, this, 0L, gWsTserviceTeamDismissRequestParam, ICallBackWsTserviceTeamDismissImpl.getCPtr(iCallBackWsTserviceTeamDismissImpl), iCallBackWsTserviceTeamDismissImpl);
    }

    public long sendReqWsTserviceTeamInfoUpdate(GWsTserviceTeamInfoUpdateRequestParam gWsTserviceTeamInfoUpdateRequestParam, ICallBackWsTserviceTeamInfoUpdateImpl iCallBackWsTserviceTeamInfoUpdateImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceTeamInfoUpdateNative(j, this, 0L, gWsTserviceTeamInfoUpdateRequestParam, ICallBackWsTserviceTeamInfoUpdateImpl.getCPtr(iCallBackWsTserviceTeamInfoUpdateImpl), iCallBackWsTserviceTeamInfoUpdateImpl);
    }

    public long sendReqWsTserviceTeamUserTnnUpdate(GWsTserviceTeamUserTnnUpdateRequestParam gWsTserviceTeamUserTnnUpdateRequestParam, ICallBackWsTserviceTeamUserTnnUpdateImpl iCallBackWsTserviceTeamUserTnnUpdateImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceTeamUserTnnUpdateNative(j, this, 0L, gWsTserviceTeamUserTnnUpdateRequestParam, ICallBackWsTserviceTeamUserTnnUpdateImpl.getCPtr(iCallBackWsTserviceTeamUserTnnUpdateImpl), iCallBackWsTserviceTeamUserTnnUpdateImpl);
    }

    public long sendReqWsDeviceAdius(GWsDeviceAdiusRequestParam gWsDeviceAdiusRequestParam, ICallBackWsDeviceAdiusImpl iCallBackWsDeviceAdiusImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsDeviceAdiusNative(j, this, 0L, gWsDeviceAdiusRequestParam, ICallBackWsDeviceAdiusImpl.getCPtr(iCallBackWsDeviceAdiusImpl), iCallBackWsDeviceAdiusImpl);
    }

    public long sendReqHttpGetPost(GHttpGetPostRequestParam gHttpGetPostRequestParam, ICallBackHttpGetPostImpl iCallBackHttpGetPostImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqHttpGetPostNative(j, this, 0L, gHttpGetPostRequestParam, ICallBackHttpGetPostImpl.getCPtr(iCallBackHttpGetPostImpl), iCallBackHttpGetPostImpl);
    }

    public long sendReqWsOssMaplayerList(GWsOssMaplayerListRequestParam gWsOssMaplayerListRequestParam, ICallBackWsOssMaplayerListImpl iCallBackWsOssMaplayerListImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsOssMaplayerListNative(j, this, 0L, gWsOssMaplayerListRequestParam, ICallBackWsOssMaplayerListImpl.getCPtr(iCallBackWsOssMaplayerListImpl), iCallBackWsOssMaplayerListImpl);
    }

    public long sendReqWsShieldNavigationRoutepathrestoration(GWsShieldNavigationRoutepathrestorationRequestParam gWsShieldNavigationRoutepathrestorationRequestParam, ICallBackWsShieldNavigationRoutepathrestorationImpl iCallBackWsShieldNavigationRoutepathrestorationImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsShieldNavigationRoutepathrestorationNative(j, this, 0L, gWsShieldNavigationRoutepathrestorationRequestParam, ICallBackWsShieldNavigationRoutepathrestorationImpl.getCPtr(iCallBackWsShieldNavigationRoutepathrestorationImpl), iCallBackWsShieldNavigationRoutepathrestorationImpl);
    }

    public long sendReqWsVaCarLogo(GWsVaCarLogoRequestParam gWsVaCarLogoRequestParam, ICallBackWsVaCarLogoImpl iCallBackWsVaCarLogoImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsVaCarLogoNative(j, this, 0L, gWsVaCarLogoRequestParam, ICallBackWsVaCarLogoImpl.getCPtr(iCallBackWsVaCarLogoImpl), iCallBackWsVaCarLogoImpl);
    }

    public long sendReqWsVaCarLogoExchange(GWsVaCarLogoExchangeRequestParam gWsVaCarLogoExchangeRequestParam, ICallBackWsVaCarLogoExchangeImpl iCallBackWsVaCarLogoExchangeImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsVaCarLogoExchangeNative(j, this, 0L, gWsVaCarLogoExchangeRequestParam, ICallBackWsVaCarLogoExchangeImpl.getCPtr(iCallBackWsVaCarLogoExchangeImpl), iCallBackWsVaCarLogoExchangeImpl);
    }

    public long sendReqWsVaCarLogoSelect(GWsVaCarLogoSelectRequestParam gWsVaCarLogoSelectRequestParam, ICallBackWsVaCarLogoSelectImpl iCallBackWsVaCarLogoSelectImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsVaCarLogoSelectNative(j, this, 0L, gWsVaCarLogoSelectRequestParam, ICallBackWsVaCarLogoSelectImpl.getCPtr(iCallBackWsVaCarLogoSelectImpl), iCallBackWsVaCarLogoSelectImpl);
    }

    public long sendReqWsAuthcarServiceProvision(GWsAuthcarServiceProvisionRequestParam gWsAuthcarServiceProvisionRequestParam, ICallBackWsAuthcarServiceProvisionImpl iCallBackWsAuthcarServiceProvisionImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsAuthcarServiceProvisionNative(j, this, 0L, gWsAuthcarServiceProvisionRequestParam, ICallBackWsAuthcarServiceProvisionImpl.getCPtr(iCallBackWsAuthcarServiceProvisionImpl), iCallBackWsAuthcarServiceProvisionImpl);
    }

    public long sendReqWsAuthcarServicelist(GWsAuthcarServicelistRequestParam gWsAuthcarServicelistRequestParam, ICallBackWsAuthcarServicelistImpl iCallBackWsAuthcarServicelistImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsAuthcarServicelistNative(j, this, 0L, gWsAuthcarServicelistRequestParam, ICallBackWsAuthcarServicelistImpl.getCPtr(iCallBackWsAuthcarServicelistImpl), iCallBackWsAuthcarServicelistImpl);
    }

    public long sendReqWsAuthcarToken(GWsAuthcarTokenRequestParam gWsAuthcarTokenRequestParam, ICallBackWsAuthcarTokenImpl iCallBackWsAuthcarTokenImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsAuthcarTokenNative(j, this, 0L, gWsAuthcarTokenRequestParam, ICallBackWsAuthcarTokenImpl.getCPtr(iCallBackWsAuthcarTokenImpl), iCallBackWsAuthcarTokenImpl);
    }

    public long sendReqWsShieldAsbpApiUpload(GWsShieldAsbpApiUploadRequestParam gWsShieldAsbpApiUploadRequestParam, ICallBackWsShieldAsbpApiUploadImpl iCallBackWsShieldAsbpApiUploadImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsShieldAsbpApiUploadNative(j, this, 0L, gWsShieldAsbpApiUploadRequestParam, ICallBackWsShieldAsbpApiUploadImpl.getCPtr(iCallBackWsShieldAsbpApiUploadImpl), iCallBackWsShieldAsbpApiUploadImpl);
    }

    public long sendReqWsCloudUpload(GWsCloudUploadRequestParam gWsCloudUploadRequestParam, ICallBackWsCloudUploadImpl iCallBackWsCloudUploadImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsCloudUploadNative(j, this, 0L, gWsCloudUploadRequestParam, ICallBackWsCloudUploadImpl.getCPtr(iCallBackWsCloudUploadImpl), iCallBackWsCloudUploadImpl);
    }

    public long sendReqWsMapapiAutoInit(GWsMapapiAutoInitRequestParam gWsMapapiAutoInitRequestParam, ICallBackWsMapapiAutoInitImpl iCallBackWsMapapiAutoInitImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsMapapiAutoInitNative(j, this, 0L, gWsMapapiAutoInitRequestParam, ICallBackWsMapapiAutoInitImpl.getCPtr(iCallBackWsMapapiAutoInitImpl), iCallBackWsMapapiAutoInitImpl);
    }

    public long sendReqWsMapapiConfOffline(GWsMapapiConfOfflineRequestParam gWsMapapiConfOfflineRequestParam, ICallBackWsMapapiConfOfflineImpl iCallBackWsMapapiConfOfflineImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsMapapiConfOfflineNative(j, this, 0L, gWsMapapiConfOfflineRequestParam, ICallBackWsMapapiConfOfflineImpl.getCPtr(iCallBackWsMapapiConfOfflineImpl), iCallBackWsMapapiConfOfflineImpl);
    }

    public long sendReqQuerybylinks(GQuerybylinksRequestParam gQuerybylinksRequestParam, ICallBackQuerybylinksImpl iCallBackQuerybylinksImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqQuerybylinksNative(j, this, 0L, gQuerybylinksRequestParam, ICallBackQuerybylinksImpl.getCPtr(iCallBackQuerybylinksImpl), iCallBackQuerybylinksImpl);
    }

    public long sendReqWsPpContactBindMobile(GWsPpContactBindMobileRequestParam gWsPpContactBindMobileRequestParam, ICallBackWsPpContactBindMobileImpl iCallBackWsPpContactBindMobileImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsPpContactBindMobileNative(j, this, 0L, gWsPpContactBindMobileRequestParam, ICallBackWsPpContactBindMobileImpl.getCPtr(iCallBackWsPpContactBindMobileImpl), iCallBackWsPpContactBindMobileImpl);
    }

    public long sendReqWsPpContactUnbindMobile(GWsPpContactUnbindMobileRequestParam gWsPpContactUnbindMobileRequestParam, ICallBackWsPpContactUnbindMobileImpl iCallBackWsPpContactUnbindMobileImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsPpContactUnbindMobileNative(j, this, 0L, gWsPpContactUnbindMobileRequestParam, ICallBackWsPpContactUnbindMobileImpl.getCPtr(iCallBackWsPpContactUnbindMobileImpl), iCallBackWsPpContactUnbindMobileImpl);
    }

    public long sendReqWsAutoCollect(GWsAutoCollectRequestParam gWsAutoCollectRequestParam, ICallBackWsAutoCollectImpl iCallBackWsAutoCollectImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsAutoCollectNative(j, this, 0L, gWsAutoCollectRequestParam, ICallBackWsAutoCollectImpl.getCPtr(iCallBackWsAutoCollectImpl), iCallBackWsAutoCollectImpl);
    }

    public long sendReqWsTserviceIotTripodSnAutoBind(GWsTserviceIotTripodSnAutoBindRequestParam gWsTserviceIotTripodSnAutoBindRequestParam, ICallBackWsTserviceIotTripodSnAutoBindImpl iCallBackWsTserviceIotTripodSnAutoBindImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceIotTripodSnAutoBindNative(j, this, 0L, gWsTserviceIotTripodSnAutoBindRequestParam, ICallBackWsTserviceIotTripodSnAutoBindImpl.getCPtr(iCallBackWsTserviceIotTripodSnAutoBindImpl), iCallBackWsTserviceIotTripodSnAutoBindImpl);
    }

    public long sendReqWsTserviceIotTripodSnAutoBound(GWsTserviceIotTripodSnAutoBoundRequestParam gWsTserviceIotTripodSnAutoBoundRequestParam, ICallBackWsTserviceIotTripodSnAutoBoundImpl iCallBackWsTserviceIotTripodSnAutoBoundImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceIotTripodSnAutoBoundNative(j, this, 0L, gWsTserviceIotTripodSnAutoBoundRequestParam, ICallBackWsTserviceIotTripodSnAutoBoundImpl.getCPtr(iCallBackWsTserviceIotTripodSnAutoBoundImpl), iCallBackWsTserviceIotTripodSnAutoBoundImpl);
    }

    public long sendReqWsTserviceIotTripodSnAutoBindForce(GWsTserviceIotTripodSnAutoBindForceRequestParam gWsTserviceIotTripodSnAutoBindForceRequestParam, ICallBackWsTserviceIotTripodSnAutoBindForceImpl iCallBackWsTserviceIotTripodSnAutoBindForceImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceIotTripodSnAutoBindForceNative(j, this, 0L, gWsTserviceIotTripodSnAutoBindForceRequestParam, ICallBackWsTserviceIotTripodSnAutoBindForceImpl.getCPtr(iCallBackWsTserviceIotTripodSnAutoBindForceImpl), iCallBackWsTserviceIotTripodSnAutoBindForceImpl);
    }

    public long sendReqWsTserviceIotDeviceList(GWsTserviceIotDeviceListRequestParam gWsTserviceIotDeviceListRequestParam, ICallBackWsTserviceIotDeviceListImpl iCallBackWsTserviceIotDeviceListImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceIotDeviceListNative(j, this, 0L, gWsTserviceIotDeviceListRequestParam, ICallBackWsTserviceIotDeviceListImpl.getCPtr(iCallBackWsTserviceIotDeviceListImpl), iCallBackWsTserviceIotDeviceListImpl);
    }

    public long sendReqWsTserviceIotDeviceRelieve(GWsTserviceIotDeviceRelieveRequestParam gWsTserviceIotDeviceRelieveRequestParam, ICallBackWsTserviceIotDeviceRelieveImpl iCallBackWsTserviceIotDeviceRelieveImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceIotDeviceRelieveNative(j, this, 0L, gWsTserviceIotDeviceRelieveRequestParam, ICallBackWsTserviceIotDeviceRelieveImpl.getCPtr(iCallBackWsTserviceIotDeviceRelieveImpl), iCallBackWsTserviceIotDeviceRelieveImpl);
    }

    public long sendReqWsTserviceIotTripodStatus(GWsTserviceIotTripodStatusRequestParam gWsTserviceIotTripodStatusRequestParam, ICallBackWsTserviceIotTripodStatusImpl iCallBackWsTserviceIotTripodStatusImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceIotTripodStatusNative(j, this, 0L, gWsTserviceIotTripodStatusRequestParam, ICallBackWsTserviceIotTripodStatusImpl.getCPtr(iCallBackWsTserviceIotTripodStatusImpl), iCallBackWsTserviceIotTripodStatusImpl);
    }

    public long sendReqWsTserviceIotTripodEvent(GWsTserviceIotTripodEventRequestParam gWsTserviceIotTripodEventRequestParam, ICallBackWsTserviceIotTripodEventImpl iCallBackWsTserviceIotTripodEventImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceIotTripodEventNative(j, this, 0L, gWsTserviceIotTripodEventRequestParam, ICallBackWsTserviceIotTripodEventImpl.getCPtr(iCallBackWsTserviceIotTripodEventImpl), iCallBackWsTserviceIotTripodEventImpl);
    }

    public long sendReqWsTserviceRequestIp(GWsTserviceRequestIpRequestParam gWsTserviceRequestIpRequestParam, ICallBackWsTserviceRequestIpImpl iCallBackWsTserviceRequestIpImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceRequestIpNative(j, this, 0L, gWsTserviceRequestIpRequestParam, ICallBackWsTserviceRequestIpImpl.getCPtr(iCallBackWsTserviceRequestIpImpl), iCallBackWsTserviceRequestIpImpl);
    }

    public long sendReqWsPpCarltdLogin4bind(GWsPpCarltdLogin4bindRequestParam gWsPpCarltdLogin4bindRequestParam, ICallBackWsPpCarltdLogin4bindImpl iCallBackWsPpCarltdLogin4bindImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsPpCarltdLogin4bindNative(j, this, 0L, gWsPpCarltdLogin4bindRequestParam, ICallBackWsPpCarltdLogin4bindImpl.getCPtr(iCallBackWsPpCarltdLogin4bindImpl), iCallBackWsPpCarltdLogin4bindImpl);
    }

    public long sendReqWsShieldSearchMainPageRec(GWsShieldSearchMainPageRecRequestParam gWsShieldSearchMainPageRecRequestParam, ICallBackWsShieldSearchMainPageRecImpl iCallBackWsShieldSearchMainPageRecImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsShieldSearchMainPageRecNative(j, this, 0L, gWsShieldSearchMainPageRecRequestParam, ICallBackWsShieldSearchMainPageRecImpl.getCPtr(iCallBackWsShieldSearchMainPageRecImpl), iCallBackWsShieldSearchMainPageRecImpl);
    }

    public long sendReqTripodCompany(GTripodCompanyRequestParam gTripodCompanyRequestParam, ICallBackTripodCompanyImpl iCallBackTripodCompanyImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqTripodCompanyNative(j, this, 0L, gTripodCompanyRequestParam, ICallBackTripodCompanyImpl.getCPtr(iCallBackTripodCompanyImpl), iCallBackTripodCompanyImpl);
    }

    public long sendReqServerTimestamp(GServerTimestampRequestParam gServerTimestampRequestParam, ICallBackServerTimestampImpl iCallBackServerTimestampImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqServerTimestampNative(j, this, 0L, gServerTimestampRequestParam, ICallBackServerTimestampImpl.getCPtr(iCallBackServerTimestampImpl), iCallBackServerTimestampImpl);
    }

    public long sendReqWsFeedbackReviewGet(GWsFeedbackReviewGetRequestParam gWsFeedbackReviewGetRequestParam, ICallBackWsFeedbackReviewGetImpl iCallBackWsFeedbackReviewGetImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsFeedbackReviewGetNative(j, this, 0L, gWsFeedbackReviewGetRequestParam, ICallBackWsFeedbackReviewGetImpl.getCPtr(iCallBackWsFeedbackReviewGetImpl), iCallBackWsFeedbackReviewGetImpl);
    }

    public long sendReqWsFeedbackReviewReport(GWsFeedbackReviewReportRequestParam gWsFeedbackReviewReportRequestParam, ICallBackWsFeedbackReviewReportImpl iCallBackWsFeedbackReviewReportImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsFeedbackReviewReportNative(j, this, 0L, gWsFeedbackReviewReportRequestParam, ICallBackWsFeedbackReviewReportImpl.getCPtr(iCallBackWsFeedbackReviewReportImpl), iCallBackWsFeedbackReviewReportImpl);
    }

    public long sendReqWsUserviewFootprintSummary(GWsUserviewFootprintSummaryRequestParam gWsUserviewFootprintSummaryRequestParam, ICallBackWsUserviewFootprintSummaryImpl iCallBackWsUserviewFootprintSummaryImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsUserviewFootprintSummaryNative(j, this, 0L, gWsUserviewFootprintSummaryRequestParam, ICallBackWsUserviewFootprintSummaryImpl.getCPtr(iCallBackWsUserviewFootprintSummaryImpl), iCallBackWsUserviewFootprintSummaryImpl);
    }

    public long sendReqWsUserviewFootprintSwitch(GWsUserviewFootprintSwitchRequestParam gWsUserviewFootprintSwitchRequestParam, ICallBackWsUserviewFootprintSwitchImpl iCallBackWsUserviewFootprintSwitchImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsUserviewFootprintSwitchNative(j, this, 0L, gWsUserviewFootprintSwitchRequestParam, ICallBackWsUserviewFootprintSwitchImpl.getCPtr(iCallBackWsUserviewFootprintSwitchImpl), iCallBackWsUserviewFootprintSwitchImpl);
    }

    public long sendReqImGetLoginToken(GImGetLoginTokenRequestParam gImGetLoginTokenRequestParam, ICallBackImGetLoginTokenImpl iCallBackImGetLoginTokenImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqImGetLoginTokenNative(j, this, 0L, gImGetLoginTokenRequestParam, ICallBackImGetLoginTokenImpl.getCPtr(iCallBackImGetLoginTokenImpl), iCallBackImGetLoginTokenImpl);
    }

    public long sendReqImGetAppuid(GImGetAppuidRequestParam gImGetAppuidRequestParam, ICallBackImGetAppuidImpl iCallBackImGetAppuidImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqImGetAppuidNative(j, this, 0L, gImGetAppuidRequestParam, ICallBackImGetAppuidImpl.getCPtr(iCallBackImGetAppuidImpl), iCallBackImGetAppuidImpl);
    }

    public long sendReqWsTserviceInternalLinkCarGet(GWsTserviceInternalLinkCarGetRequestParam gWsTserviceInternalLinkCarGetRequestParam, ICallBackWsTserviceInternalLinkCarGetImpl iCallBackWsTserviceInternalLinkCarGetImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceInternalLinkCarGetNative(j, this, 0L, gWsTserviceInternalLinkCarGetRequestParam, ICallBackWsTserviceInternalLinkCarGetImpl.getCPtr(iCallBackWsTserviceInternalLinkCarGetImpl), iCallBackWsTserviceInternalLinkCarGetImpl);
    }

    public long sendReqWsTserviceInternalLinkCarReport(GWsTserviceInternalLinkCarReportRequestParam gWsTserviceInternalLinkCarReportRequestParam, ICallBackWsTserviceInternalLinkCarReportImpl iCallBackWsTserviceInternalLinkCarReportImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceInternalLinkCarReportNative(j, this, 0L, gWsTserviceInternalLinkCarReportRequestParam, ICallBackWsTserviceInternalLinkCarReportImpl.getCPtr(iCallBackWsTserviceInternalLinkCarReportImpl), iCallBackWsTserviceInternalLinkCarReportImpl);
    }

    public long sendReqWsPpAccountDeactivateHelp(GWsPpAccountDeactivateHelpRequestParam gWsPpAccountDeactivateHelpRequestParam, ICallBackWsPpAccountDeactivateHelpImpl iCallBackWsPpAccountDeactivateHelpImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsPpAccountDeactivateHelpNative(j, this, 0L, gWsPpAccountDeactivateHelpRequestParam, ICallBackWsPpAccountDeactivateHelpImpl.getCPtr(iCallBackWsPpAccountDeactivateHelpImpl), iCallBackWsPpAccountDeactivateHelpImpl);
    }

    public long sendReqWsPpAccountDeactivate(GWsPpAccountDeactivateRequestParam gWsPpAccountDeactivateRequestParam, ICallBackWsPpAccountDeactivateImpl iCallBackWsPpAccountDeactivateImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsPpAccountDeactivateNative(j, this, 0L, gWsPpAccountDeactivateRequestParam, ICallBackWsPpAccountDeactivateImpl.getCPtr(iCallBackWsPpAccountDeactivateImpl), iCallBackWsPpAccountDeactivateImpl);
    }

    public long sendReqWsTserviceInternalLinkAutoReport(GWsTserviceInternalLinkAutoReportRequestParam gWsTserviceInternalLinkAutoReportRequestParam, ICallBackWsTserviceInternalLinkAutoReportImpl iCallBackWsTserviceInternalLinkAutoReportImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTserviceInternalLinkAutoReportNative(j, this, 0L, gWsTserviceInternalLinkAutoReportRequestParam, ICallBackWsTserviceInternalLinkAutoReportImpl.getCPtr(iCallBackWsTserviceInternalLinkAutoReportImpl), iCallBackWsTserviceInternalLinkAutoReportImpl);
    }

    public long sendReqWsMapapiBenzLinkids(GWsMapapiBenzLinkidsRequestParam gWsMapapiBenzLinkidsRequestParam, ICallBackWsMapapiBenzLinkidsImpl iCallBackWsMapapiBenzLinkidsImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsMapapiBenzLinkidsNative(j, this, 0L, gWsMapapiBenzLinkidsRequestParam, ICallBackWsMapapiBenzLinkidsImpl.getCPtr(iCallBackWsMapapiBenzLinkidsImpl), iCallBackWsMapapiBenzLinkidsImpl);
    }

    public long sendReqWsMapapiBenzRoad(GWsMapapiBenzRoadRequestParam gWsMapapiBenzRoadRequestParam, ICallBackWsMapapiBenzRoadImpl iCallBackWsMapapiBenzRoadImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsMapapiBenzRoadNative(j, this, 0L, gWsMapapiBenzRoadRequestParam, ICallBackWsMapapiBenzRoadImpl.getCPtr(iCallBackWsMapapiBenzRoadImpl), iCallBackWsMapapiBenzRoadImpl);
    }

    public long sendReqWsAudiHcp3EventSearch(GWsAudiHcp3EventSearchRequestParam gWsAudiHcp3EventSearchRequestParam, ICallBackWsAudiHcp3EventSearchImpl iCallBackWsAudiHcp3EventSearchImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsAudiHcp3EventSearchNative(j, this, 0L, gWsAudiHcp3EventSearchRequestParam, ICallBackWsAudiHcp3EventSearchImpl.getCPtr(iCallBackWsAudiHcp3EventSearchImpl), iCallBackWsAudiHcp3EventSearchImpl);
    }

    public long sendReqWsHcp3ChargeList(GWsHcp3ChargeListRequestParam gWsHcp3ChargeListRequestParam, ICallBackWsHcp3ChargeListImpl iCallBackWsHcp3ChargeListImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsHcp3ChargeListNative(j, this, 0L, gWsHcp3ChargeListRequestParam, ICallBackWsHcp3ChargeListImpl.getCPtr(iCallBackWsHcp3ChargeListImpl), iCallBackWsHcp3ChargeListImpl);
    }

    public long sendReqWsNtg6SdsFiles(GWsNtg6SdsFilesRequestParam gWsNtg6SdsFilesRequestParam, ICallBackWsNtg6SdsFilesImpl iCallBackWsNtg6SdsFilesImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsNtg6SdsFilesNative(j, this, 0L, gWsNtg6SdsFilesRequestParam, ICallBackWsNtg6SdsFilesImpl.getCPtr(iCallBackWsNtg6SdsFilesImpl), iCallBackWsNtg6SdsFilesImpl);
    }

    public long sendReqWsUserviewFootprintNaviDelete(GWsUserviewFootprintNaviDeleteRequestParam gWsUserviewFootprintNaviDeleteRequestParam, ICallBackWsUserviewFootprintNaviDeleteImpl iCallBackWsUserviewFootprintNaviDeleteImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsUserviewFootprintNaviDeleteNative(j, this, 0L, gWsUserviewFootprintNaviDeleteRequestParam, ICallBackWsUserviewFootprintNaviDeleteImpl.getCPtr(iCallBackWsUserviewFootprintNaviDeleteImpl), iCallBackWsUserviewFootprintNaviDeleteImpl);
    }

    public long sendReqWsUserviewFootprintNaviRecord(GWsUserviewFootprintNaviRecordRequestParam gWsUserviewFootprintNaviRecordRequestParam, ICallBackWsUserviewFootprintNaviRecordImpl iCallBackWsUserviewFootprintNaviRecordImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsUserviewFootprintNaviRecordNative(j, this, 0L, gWsUserviewFootprintNaviRecordRequestParam, ICallBackWsUserviewFootprintNaviRecordImpl.getCPtr(iCallBackWsUserviewFootprintNaviRecordImpl), iCallBackWsUserviewFootprintNaviRecordImpl);
    }

    public long sendReqWsNavigationDynamicData(GWsNavigationDynamicDataRequestParam gWsNavigationDynamicDataRequestParam, ICallBackWsNavigationDynamicDataImpl iCallBackWsNavigationDynamicDataImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsNavigationDynamicDataNative(j, this, 0L, gWsNavigationDynamicDataRequestParam, ICallBackWsNavigationDynamicDataImpl.getCPtr(iCallBackWsNavigationDynamicDataImpl), iCallBackWsNavigationDynamicDataImpl);
    }

    public long sendReqWsNavigationDynamicFatigue(GWsNavigationDynamicFatigueRequestParam gWsNavigationDynamicFatigueRequestParam, ICallBackWsNavigationDynamicFatigueImpl iCallBackWsNavigationDynamicFatigueImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsNavigationDynamicFatigueNative(j, this, 0L, gWsNavigationDynamicFatigueRequestParam, ICallBackWsNavigationDynamicFatigueImpl.getCPtr(iCallBackWsNavigationDynamicFatigueImpl), iCallBackWsNavigationDynamicFatigueImpl);
    }

    public long sendReqCouponrecvapply(GCouponrecvapplyRequestParam gCouponrecvapplyRequestParam, ICallBackCouponrecvapplyImpl iCallBackCouponrecvapplyImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqCouponrecvapplyNative(j, this, 0L, gCouponrecvapplyRequestParam, ICallBackCouponrecvapplyImpl.getCPtr(iCallBackCouponrecvapplyImpl), iCallBackCouponrecvapplyImpl);
    }

    public long sendReqCouponrecvlist(GCouponrecvlistRequestParam gCouponrecvlistRequestParam, ICallBackCouponrecvlistImpl iCallBackCouponrecvlistImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqCouponrecvlistNative(j, this, 0L, gCouponrecvlistRequestParam, ICallBackCouponrecvlistImpl.getCPtr(iCallBackCouponrecvlistImpl), iCallBackCouponrecvlistImpl);
    }

    public long sendReqWsTcFuelCancel(GWsTcFuelCancelRequestParam gWsTcFuelCancelRequestParam, ICallBackWsTcFuelCancelImpl iCallBackWsTcFuelCancelImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTcFuelCancelNative(j, this, 0L, gWsTcFuelCancelRequestParam, ICallBackWsTcFuelCancelImpl.getCPtr(iCallBackWsTcFuelCancelImpl), iCallBackWsTcFuelCancelImpl);
    }

    public long sendReqWsTcFuelCreate(GWsTcFuelCreateRequestParam gWsTcFuelCreateRequestParam, ICallBackWsTcFuelCreateImpl iCallBackWsTcFuelCreateImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTcFuelCreateNative(j, this, 0L, gWsTcFuelCreateRequestParam, ICallBackWsTcFuelCreateImpl.getCPtr(iCallBackWsTcFuelCreateImpl), iCallBackWsTcFuelCreateImpl);
    }

    public long sendReqWsTcFuelGetwaitingpayorders(GWsTcFuelGetwaitingpayordersRequestParam gWsTcFuelGetwaitingpayordersRequestParam, ICallBackWsTcFuelGetwaitingpayordersImpl iCallBackWsTcFuelGetwaitingpayordersImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTcFuelGetwaitingpayordersNative(j, this, 0L, gWsTcFuelGetwaitingpayordersRequestParam, ICallBackWsTcFuelGetwaitingpayordersImpl.getCPtr(iCallBackWsTcFuelGetwaitingpayordersImpl), iCallBackWsTcFuelGetwaitingpayordersImpl);
    }

    public long sendReqWsTcOrderDetail(GWsTcOrderDetailRequestParam gWsTcOrderDetailRequestParam, ICallBackWsTcOrderDetailImpl iCallBackWsTcOrderDetailImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTcOrderDetailNative(j, this, 0L, gWsTcOrderDetailRequestParam, ICallBackWsTcOrderDetailImpl.getCPtr(iCallBackWsTcOrderDetailImpl), iCallBackWsTcOrderDetailImpl);
    }

    public long sendReqGasstationcalprice(GGasstationcalpriceRequestParam gGasstationcalpriceRequestParam, ICallBackGasstationcalpriceImpl iCallBackGasstationcalpriceImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqGasstationcalpriceNative(j, this, 0L, gGasstationcalpriceRequestParam, ICallBackGasstationcalpriceImpl.getCPtr(iCallBackGasstationcalpriceImpl), iCallBackGasstationcalpriceImpl);
    }

    public long sendReqWsShieldSearchRanklistCity(GWsShieldSearchRanklistCityRequestParam gWsShieldSearchRanklistCityRequestParam, ICallBackWsShieldSearchRanklistCityImpl iCallBackWsShieldSearchRanklistCityImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsShieldSearchRanklistCityNative(j, this, 0L, gWsShieldSearchRanklistCityRequestParam, ICallBackWsShieldSearchRanklistCityImpl.getCPtr(iCallBackWsShieldSearchRanklistCityImpl), iCallBackWsShieldSearchRanklistCityImpl);
    }

    public long sendReqWsShieldSearchRanklistLanding(GWsShieldSearchRanklistLandingRequestParam gWsShieldSearchRanklistLandingRequestParam, ICallBackWsShieldSearchRanklistLandingImpl iCallBackWsShieldSearchRanklistLandingImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsShieldSearchRanklistLandingNative(j, this, 0L, gWsShieldSearchRanklistLandingRequestParam, ICallBackWsShieldSearchRanklistLandingImpl.getCPtr(iCallBackWsShieldSearchRanklistLandingImpl), iCallBackWsShieldSearchRanklistLandingImpl);
    }

    public long sendReqWsShieldSearchRanklistPortal(GWsShieldSearchRanklistPortalRequestParam gWsShieldSearchRanklistPortalRequestParam, ICallBackWsShieldSearchRanklistPortalImpl iCallBackWsShieldSearchRanklistPortalImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsShieldSearchRanklistPortalNative(j, this, 0L, gWsShieldSearchRanklistPortalRequestParam, ICallBackWsShieldSearchRanklistPortalImpl.getCPtr(iCallBackWsShieldSearchRanklistPortalImpl), iCallBackWsShieldSearchRanklistPortalImpl);
    }

    public long sendReqWsIcsLifeUserCouponList(GWsIcsLifeUserCouponListRequestParam gWsIcsLifeUserCouponListRequestParam, ICallBackWsIcsLifeUserCouponListImpl iCallBackWsIcsLifeUserCouponListImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsIcsLifeUserCouponListNative(j, this, 0L, gWsIcsLifeUserCouponListRequestParam, ICallBackWsIcsLifeUserCouponListImpl.getCPtr(iCallBackWsIcsLifeUserCouponListImpl), iCallBackWsIcsLifeUserCouponListImpl);
    }

    public long sendReqWsIcsLifeCouponOptions(GWsIcsLifeCouponOptionsRequestParam gWsIcsLifeCouponOptionsRequestParam, ICallBackWsIcsLifeCouponOptionsImpl iCallBackWsIcsLifeCouponOptionsImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsIcsLifeCouponOptionsNative(j, this, 0L, gWsIcsLifeCouponOptionsRequestParam, ICallBackWsIcsLifeCouponOptionsImpl.getCPtr(iCallBackWsIcsLifeCouponOptionsImpl), iCallBackWsIcsLifeCouponOptionsImpl);
    }

    public long sendReqWsTcOrderList(GWsTcOrderListRequestParam gWsTcOrderListRequestParam, ICallBackWsTcOrderListImpl iCallBackWsTcOrderListImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTcOrderListNative(j, this, 0L, gWsTcOrderListRequestParam, ICallBackWsTcOrderListImpl.getCPtr(iCallBackWsTcOrderListImpl), iCallBackWsTcOrderListImpl);
    }

    public long sendReqLbpEventSyncCommon(GLbpEventSyncCommonRequestParam gLbpEventSyncCommonRequestParam, ICallBackLbpEventSyncCommonImpl iCallBackLbpEventSyncCommonImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqLbpEventSyncCommonNative(j, this, 0L, gLbpEventSyncCommonRequestParam, ICallBackLbpEventSyncCommonImpl.getCPtr(iCallBackLbpEventSyncCommonImpl), iCallBackLbpEventSyncCommonImpl);
    }

    public long sendReqWsTcFuelQueryagreement(GWsTcFuelQueryagreementRequestParam gWsTcFuelQueryagreementRequestParam, ICallBackWsTcFuelQueryagreementImpl iCallBackWsTcFuelQueryagreementImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTcFuelQueryagreementNative(j, this, 0L, gWsTcFuelQueryagreementRequestParam, ICallBackWsTcFuelQueryagreementImpl.getCPtr(iCallBackWsTcFuelQueryagreementImpl), iCallBackWsTcFuelQueryagreementImpl);
    }

    public long sendReqWsTcCommonAgreementStatus(GWsTcCommonAgreementStatusRequestParam gWsTcCommonAgreementStatusRequestParam, ICallBackWsTcCommonAgreementStatusImpl iCallBackWsTcCommonAgreementStatusImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsTcCommonAgreementStatusNative(j, this, 0L, gWsTcCommonAgreementStatusRequestParam, ICallBackWsTcCommonAgreementStatusImpl.getCPtr(iCallBackWsTcCommonAgreementStatusImpl), iCallBackWsTcCommonAgreementStatusImpl);
    }

    public long sendReqWsCommerceInfraChargeRecordsWaitingEnable(GWsCommerceInfraChargeRecordsWaitingEnableRequestParam gWsCommerceInfraChargeRecordsWaitingEnableRequestParam, ICallBackWsCommerceInfraChargeRecordsWaitingEnableImpl iCallBackWsCommerceInfraChargeRecordsWaitingEnableImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsCommerceInfraChargeRecordsWaitingEnableNative(j, this, 0L, gWsCommerceInfraChargeRecordsWaitingEnableRequestParam, ICallBackWsCommerceInfraChargeRecordsWaitingEnableImpl.getCPtr(iCallBackWsCommerceInfraChargeRecordsWaitingEnableImpl), iCallBackWsCommerceInfraChargeRecordsWaitingEnableImpl);
    }

    public long sendReqWsAuthcarServiceEnable(GWsAuthcarServiceEnableRequestParam gWsAuthcarServiceEnableRequestParam, ICallBackWsAuthcarServiceEnableImpl iCallBackWsAuthcarServiceEnableImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsAuthcarServiceEnableNative(j, this, 0L, gWsAuthcarServiceEnableRequestParam, ICallBackWsAuthcarServiceEnableImpl.getCPtr(iCallBackWsAuthcarServiceEnableImpl), iCallBackWsAuthcarServiceEnableImpl);
    }

    public long sendReqWsAosDestinationSearch(GWsAosDestinationSearchRequestParam gWsAosDestinationSearchRequestParam, ICallBackWsAosDestinationSearchImpl iCallBackWsAosDestinationSearchImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendReqWsAosDestinationSearchNative(j, this, 0L, gWsAosDestinationSearchRequestParam, ICallBackWsAosDestinationSearchImpl.getCPtr(iCallBackWsAosDestinationSearchImpl), iCallBackWsAosDestinationSearchImpl);
    }
}
