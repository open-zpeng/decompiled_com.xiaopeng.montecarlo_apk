package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.navcore.bean.restrict.XPGRestrictCity;
import com.xiaopeng.montecarlo.navcore.bean.restrict.XPRectDouble;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.mapscene.RestrictedAreaAdapter;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class DetailRestrictRulesView extends LinearLayout {
    private static final L.Tag TAG = new L.Tag("DetailRestrictRulesView");
    private IActionCallback mActionCallback;
    @BindView(R.id.area_title)
    XTextView mAreaTitle;
    private Unbinder mButterBinder;
    @BindView(R.id.desc)
    XTextView mDesc;
    private int mLastSelectedIndex;
    @BindView(R.id.otherdesc)
    XTextView mOtherDesc;
    @BindView(R.id.otherdesc_title)
    XTextView mOtherdesTitle;
    RestrictedAreaAdapter mRestrictedAreaAdapter;
    @BindView(R.id.left_list_view)
    ListView mRestrictedAreaRulesListView;
    @BindView(R.id.right_image_content)
    XTextView mRightImage;
    private View mRootView;
    @BindView(R.id.restrict_item_area)
    XTextView mRuleArea;
    private XPGRestrictCity mRuleData;
    @BindView(R.id.restrict_item_realtime)
    XTextView mRuleTime;
    @BindView(R.id.rule_title)
    XTextView mRuleTitle;
    private XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchListener;
    @BindView(R.id.time_title)
    XTextView mTimeTitle;

    /* loaded from: classes3.dex */
    public interface IActionCallback {
        void drawRuleOnMap(int i);

        void updateRuleRectOnly(XPRectDouble xPRectDouble);
    }

    public DetailRestrictRulesView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mRestrictedAreaAdapter = null;
        this.mLastSelectedIndex = 0;
        this.mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.DetailRestrictRulesView.1
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public void onThemeSwitch(int i) {
                DetailRestrictRulesView.this.updateTheme();
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.layout_restrict_rule_detail, this);
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-1, ContextUtils.getDimensionPixelSize(R.dimen.detail_restrict_rules_view_height)));
        this.mButterBinder = ButterKnife.bind(this, this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTheme() {
        initRes();
    }

    private void initRes() {
        setBackground(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_restrict_border_gray));
    }

    public void setActionCallback(IActionCallback iActionCallback) {
        this.mActionCallback = iActionCallback;
    }

    public void setRuleData(XPGRestrictCity xPGRestrictCity, int i) {
        this.mRuleData = xPGRestrictCity;
        initLeftTitle();
        if (i > this.mRuleData.mRules.size()) {
            this.mLastSelectedIndex = 0;
        } else {
            this.mLastSelectedIndex = i;
        }
        this.mRestrictedAreaRulesListView.setItemChecked(this.mLastSelectedIndex, true);
        this.mRestrictedAreaAdapter.setSelectIndex(this.mLastSelectedIndex);
        showRuleItem(this.mLastSelectedIndex);
        initRes();
    }

    private void initLeftTitle() {
        this.mRestrictedAreaAdapter = new RestrictedAreaAdapter(this.mRuleData, getContext());
        this.mRestrictedAreaRulesListView.setAdapter((ListAdapter) this.mRestrictedAreaAdapter);
        this.mRestrictedAreaRulesListView.setChoiceMode(1);
        this.mRestrictedAreaRulesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.xiaopeng.montecarlo.views.DetailRestrictRulesView.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
                if (DetailRestrictRulesView.this.mLastSelectedIndex != i) {
                    DetailRestrictRulesView.this.showRuleItem(i);
                    UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.DetailRestrictRulesView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DetailRestrictRulesView.this.mActionCallback.drawRuleOnMap(i);
                        }
                    });
                    DetailRestrictRulesView.this.mLastSelectedIndex = i;
                    DetailRestrictRulesView.this.mRestrictedAreaAdapter.setSelectIndex(DetailRestrictRulesView.this.mLastSelectedIndex);
                    return;
                }
                if (L.ENABLE) {
                    L.Tag tag = DetailRestrictRulesView.TAG;
                    L.d(tag, " onItemClick return position=" + i);
                }
                DetailRestrictRulesView.this.mActionCallback.updateRuleRectOnly(DetailRestrictRulesView.this.mRuleData.mRules.get(i).mBound);
            }
        });
        this.mRestrictedAreaRulesListView.setItemChecked(0, true);
        this.mRestrictedAreaAdapter.setSelectIndex(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRuleItem(int i) {
        XPGRestrictCity xPGRestrictCity = this.mRuleData;
        if (xPGRestrictCity == null) {
            return;
        }
        this.mRuleTime.setText(xPGRestrictCity.mRules.get(i).mTime);
        String[] split = this.mRuleData.mRules.get(i).mSummary.split("(；|、)(?![^（]*?）)");
        String str = "";
        int i2 = 0;
        while (i2 < split.length) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append("、");
            sb.append(split[i2]);
            sb.append(";<br/>");
            str = sb.toString();
            i2 = i3;
        }
        this.mRuleArea.setText(Html.fromHtml(str));
        if (!"".equals(this.mRuleData.mRules.get(i).mDesc.trim())) {
            this.mDesc.setText(Html.fromHtml(this.mRuleData.mRules.get(i).mDesc));
            this.mRuleTitle.setVisibility(0);
        }
        if (!"".equals(this.mRuleData.mRules.get(i).mOtherdesc.trim())) {
            this.mOtherDesc.setText(Html.fromHtml(this.mRuleData.mRules.get(i).mOtherdesc));
            this.mOtherdesTitle.setVisibility(0);
        }
        if (this.mRuleData.mRules.get(i).mEffect == 1) {
            this.mRightImage.setVisibility(0);
        } else {
            this.mRightImage.setVisibility(8);
        }
    }

    public void show() {
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcherUtil.removeXpThemeListener(this.mThemeSwitchListener);
    }
}
