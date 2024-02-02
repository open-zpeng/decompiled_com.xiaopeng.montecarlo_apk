package com.xiaopeng.montecarlo.bridge;

import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class SearchBridge extends BaseBridge {
    public static final String ANIM_START_H = "anim_start_h";
    public static final String ANIM_START_W = "anim_start_w";
    public static final String ANIM_START_X = "anim_start_x";
    public static final String ANIM_START_Y = "anim_start_y";
    public static final String ANIM_TYPE = "anim_type";
    public static final int ANIM_TYPE_NULL = 0;
    public static final int ANIM_TYPE_STYTLE_1 = 1;
    public static final int ANIM_TYPE_STYTLE_2 = 2;
    public static final int DEST_GOTO = 1000;
    public static final int DEST_SET_COMPANY = 1002;
    public static final int DEST_SET_HOME = 1001;
    public static final String FROM_SCENE_CHILD_INDEX = "from_scene_child_index";
    public static final String FROM_SCENE_INDEX = "from_scene_index";
    public static final String KEY_IS_ONWAY_OF_VOICE_FUSION = "is_onway_of_voice_fusion";
    public static final String KEY_START_FROM = "key_start_from";
    public static final String POI_FROM_FAVORITE = "favorite";
    public static final String POI_FROM_HISTORY = "history";
    public static final String PREVIOUS_SCENE_MODE = "previous_scene_mode";
    public static final String SEARCH_AROUND_ITEM = "search_around_item";
    public static final String SEARCH_DEST_KEY = "search_dest_key";
    public static final String SEARCH_FROM_KEY = "search_from_key";
    public static final String SEARCH_KEYWORD_TEXT = "search_keyword_text";
    public static final String SEARCH_MODE = "search_mode";
    public static final int SEARCH_MODE_AROUND = 101;
    public static final int SEARCH_MODE_CRUISE_CARD = 104;
    public static final int SEARCH_MODE_KEYWORD = 100;
    public static final int SEARCH_MODE_SCREEN_CHARGE = 103;
    public static final String SEARCH_MODE_VIEW = "search_mode_view";
    public static final int SEARCH_MODE_WAYPOINT = 102;
    public static final String SEARCH_RADIUS = "search_radius";
    public static final String SEARCH_TYPE_KEY = "search_type_key";
    public static final String SET_RESULT_OBJECT = "set_result_object";
    public static final int START_FROM_NONE = 0;
    public static final int START_FROM_SPEECH = 1;
    public static final int START_FROM_SPEECH_FOR_FUSION = 2;
    public static final String SUB_CONTAINER_TYPE = "sub_container_type";
    private static final String TAG = "com.xiaopeng.montecarlo.bridge.SearchBridge";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface StartFrom {
    }

    public SearchBridge() {
        super(StatusConst.Mode.SEARCH);
    }

    public SearchBridge(StatusConst.Mode mode) {
        super(mode);
    }
}
