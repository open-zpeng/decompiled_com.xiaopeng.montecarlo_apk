package com.xiaopeng.montecarlo.service.navi;

import android.content.Context;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.service.navi.parser.CarWashSearchParser;
import com.xiaopeng.montecarlo.service.navi.parser.CategorySearchParser;
import com.xiaopeng.montecarlo.service.navi.parser.LaunchParser;
import com.xiaopeng.montecarlo.service.navi.parser.NaviSpeechParser;
import com.xiaopeng.montecarlo.service.navi.parser.NaviStartParser;
import com.xiaopeng.montecarlo.service.navi.parser.NearestSearchParser;
import com.xiaopeng.montecarlo.service.navi.parser.SearchStartParser;
import com.xiaopeng.montecarlo.service.navi.type.ParserTag;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class ParserManager {
    public static final int PARSER_NEAREST_SEARCH = 4;
    public static final int PARSER_TYPE_CAR_WASH = 1;
    public static final int PARSER_TYPE_CATEGORY_SEARCH = 6;
    public static final int PARSER_TYPE_DEFAULT = 0;
    public static final int PARSER_TYPE_LAUNCH_MAP = 7;
    public static final int PARSER_TYPE_NAVI_SPEECH = 3;
    public static final int PARSER_TYPE_NAVI_START = 2;
    public static final int PARSER_TYPE_SEARCH_START = 5;
    private static ArrayList<ParserTag> sAllParsers = new ArrayList<>();
    private SparseArray<INaviParser> mMap = new SparseArray<>();
    private SparseArray<ArrayList<Integer>> mType = new SparseArray<>();

    static {
        sAllParsers.add(new ParserTag(1, CarWashSearchParser.class, new int[]{1}));
        sAllParsers.add(new ParserTag(2, NaviStartParser.class, new int[]{3}));
        sAllParsers.add(new ParserTag(3, NaviSpeechParser.class, new int[]{3}));
        sAllParsers.add(new ParserTag(4, NearestSearchParser.class, new int[]{1}));
        sAllParsers.add(new ParserTag(5, SearchStartParser.class, new int[]{3}));
        sAllParsers.add(new ParserTag(6, CategorySearchParser.class, new int[]{3}));
        sAllParsers.add(new ParserTag(7, LaunchParser.class, new int[]{3}));
    }

    public void init(@NonNull Context context) {
        Iterator<ParserTag> it = sAllParsers.iterator();
        while (it.hasNext()) {
            ParserTag next = it.next();
            try {
                INaviParser iNaviParser = (INaviParser) next.mClass.newInstance();
                iNaviParser.onCreate(context);
                this.mMap.put(next.mWhat, iNaviParser);
                this.mType.put(next.mWhat, next.mBackType);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            }
        }
    }

    public INaviParser getParser(int i) {
        return this.mMap.get(i);
    }

    public ArrayList<Integer> findSupportBackType(int i) {
        return this.mType.get(i);
    }
}
