package com.xiaopeng.montecarlo.scenes.debugscene.page;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.convert.HttpResponseConverter;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IChargeStationSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.ChargeSearchByOneRequest;
import com.xiaopeng.montecarlo.navcore.search.RequestFactory;
import com.xiaopeng.montecarlo.navcore.search.ResponseCallback;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.policy.KeywordSearchType;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.text.DecimalFormat;
/* loaded from: classes2.dex */
public class SearchPoiIdPage extends BasePage implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private static final L.Tag TAG = new L.Tag("SearchPoiIdPage");
    private EditText mEditText;
    private RadioGroup mRadioGroup;
    private TextView mResult;
    private Button mSearch;
    private POI mPoiType = POI.POI_BL;
    private IChargeStationSearchService mChargeStationSearchService = (IChargeStationSearchService) HttpClientManager.getInstance().getService(IChargeStationSearchService.class);

    /* loaded from: classes2.dex */
    enum POI {
        POI_BL,
        POI_CHARGE
    }

    public static String formatJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char c = 0;
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != ',') {
                if (charAt != '[') {
                    if (charAt != ']') {
                        if (charAt != '{') {
                            if (charAt != '}') {
                                sb.append(charAt);
                            }
                        }
                    }
                    sb.append('\n');
                    i2--;
                    addIndentBlank(sb, i2);
                    sb.append(charAt);
                }
                sb.append(charAt);
                sb.append('\n');
                i2++;
                addIndentBlank(sb, i2);
            } else {
                sb.append(charAt);
                if (c != '\\') {
                    sb.append('\n');
                    addIndentBlank(sb, i2);
                }
            }
            i++;
            c = charAt;
        }
        return sb.toString();
    }

    private static void addIndentBlank(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append('\t');
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public View onCreateView(LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.layout_debug_search_poi, viewGroup, false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public void onViewCreated(View view) {
        initViews(view);
    }

    private void initViews(View view) {
        this.mRadioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
        this.mEditText = (EditText) view.findViewById(R.id.et_poi_id);
        this.mSearch = (Button) view.findViewById(R.id.btn_search);
        this.mResult = (TextView) view.findViewById(R.id.tv_result);
        this.mRadioGroup.setOnCheckedChangeListener(this);
        this.mSearch.setOnClickListener(this);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.poi_bl) {
            this.mPoiType = POI.POI_BL;
        } else if (i != R.id.poi_charge) {
        } else {
            this.mPoiType = POI.POI_CHARGE;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.mSearch.setEnabled(false);
        String trim = this.mEditText.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            return;
        }
        if (POI.POI_BL == this.mPoiType) {
            searchBL(trim);
        } else if (POI.POI_CHARGE == this.mPoiType) {
            searchCharge(trim);
        }
    }

    private void searchBL(String str) {
        int requestId = SearchClient.getInstance().getRequestId();
        RequestFactory requestFactory = new RequestFactory(1);
        CarLoc carLocation = this.mMainContext.getMapView().getBizControlManager().getCarLocation();
        if (carLocation == null || CollectionUtils.isEmpty(carLocation.vecPathMatchInfo) || carLocation.vecPathMatchInfo.get(0) == null) {
            return;
        }
        SearchClient.getInstance().enqueue(requestFactory.newBuilder().requestId(requestId).searchType(KeywordSearchType.KEYWORD_SEARCH_TYPE_POI).poiId(str).poiLocation(new XPCoordinate2DDouble(carLocation.vecPathMatchInfo.get(0).longitude, carLocation.vecPathMatchInfo.get(0).latitude)).build(), new ResponseCallback() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.SearchPoiIdPage.1
            @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
            public void onResponse(Request request, XPSearchResult xPSearchResult) {
                SearchPoiIdPage.this.setResult(xPSearchResult.getXPPoiInfos());
            }
        });
    }

    private void searchCharge(String str) {
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        final ChargeSearchByOneRequest stationIds = new ChargeSearchByOneRequest().setLat(new DecimalFormat("#.00000").format(currentLocation.mLat)).setLng(new DecimalFormat("#.00000").format(currentLocation.mLon)).setDetail(true).setStationIds(str);
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.-$$Lambda$SearchPoiIdPage$bv5wILfVotB26HgeDWuGYrb7uiA
            @Override // java.lang.Runnable
            public final void run() {
                SearchPoiIdPage.this.lambda$searchCharge$0$SearchPoiIdPage(stationIds);
            }
        });
    }

    public /* synthetic */ void lambda$searchCharge$0$SearchPoiIdPage(ChargeSearchByOneRequest chargeSearchByOneRequest) {
        setResult(HttpResponseConverter.fetchXPPoiInfoListFromSearchByOneResponse(this.mChargeStationSearchService.searchByOne(chargeSearchByOneRequest)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(final Object obj) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.SearchPoiIdPage.2
            @Override // java.lang.Runnable
            public void run() {
                if (SearchPoiIdPage.this.mSearch == null || SearchPoiIdPage.this.mSearch.getVisibility() != 0) {
                    return;
                }
                SearchPoiIdPage.this.mSearch.setEnabled(true);
                String json = GsonUtil.toJson(obj);
                SearchPoiIdPage.this.mResult.setText(SearchPoiIdPage.formatJson(json));
                if (L.ENABLE) {
                    L.Tag tag = SearchPoiIdPage.TAG;
                    L.d(tag, "result:" + json);
                }
            }
        });
    }
}
