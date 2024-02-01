package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsTcKoubeiOrderSubmitRequestData implements Serializable {
    public String alipayUid;
    public String alscOrderReqStr;
    public ArrayList<WsTcKoubeiOrderSubmitRequestDataAssetList> assetList;
    public WsTcKoubeiOrderSubmitClientInfoDto clientInfoDTO;
    public WsTcKoubeiOrderSubmitRequestDataExt ext;
    public ArrayList<WsTcKoubeiOrderSubmitRequestDataItemList> itemList;
    public String itemsTotalAmount;
    public String itemsTotalPromotionAmount;
    public String mobile;
    public String orderRealAmount;
    public String payChannel;
    public String poiId;
    public String poiName;
    public String shopId;
    public String shopName;
    public WsTcKoubeiOrderSubmitRequestDataUserLocDto userLocDTO;

    public WsTcKoubeiOrderSubmitRequestData() {
        this.alscOrderReqStr = "";
        this.assetList = new ArrayList<>();
        this.clientInfoDTO = new WsTcKoubeiOrderSubmitClientInfoDto();
        this.ext = new WsTcKoubeiOrderSubmitRequestDataExt();
        this.itemList = new ArrayList<>();
        this.itemsTotalPromotionAmount = "";
        this.itemsTotalAmount = "";
        this.mobile = "";
        this.orderRealAmount = "";
        this.payChannel = "";
        this.poiId = "";
        this.poiName = "";
        this.shopId = "";
        this.shopName = "";
        this.alipayUid = "";
        this.userLocDTO = new WsTcKoubeiOrderSubmitRequestDataUserLocDto();
    }

    public WsTcKoubeiOrderSubmitRequestData(String str, ArrayList<WsTcKoubeiOrderSubmitRequestDataAssetList> arrayList, WsTcKoubeiOrderSubmitClientInfoDto wsTcKoubeiOrderSubmitClientInfoDto, WsTcKoubeiOrderSubmitRequestDataExt wsTcKoubeiOrderSubmitRequestDataExt, ArrayList<WsTcKoubeiOrderSubmitRequestDataItemList> arrayList2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, WsTcKoubeiOrderSubmitRequestDataUserLocDto wsTcKoubeiOrderSubmitRequestDataUserLocDto) {
        this.alscOrderReqStr = str;
        this.assetList = arrayList;
        this.clientInfoDTO = wsTcKoubeiOrderSubmitClientInfoDto;
        this.ext = wsTcKoubeiOrderSubmitRequestDataExt;
        this.itemList = arrayList2;
        this.itemsTotalPromotionAmount = str2;
        this.itemsTotalAmount = str3;
        this.mobile = str4;
        this.orderRealAmount = str5;
        this.payChannel = str6;
        this.poiId = str7;
        this.poiName = str8;
        this.shopId = str9;
        this.shopName = str10;
        this.alipayUid = str11;
        this.userLocDTO = wsTcKoubeiOrderSubmitRequestDataUserLocDto;
    }
}
