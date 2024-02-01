package com.xiaopeng.montecarlo.views.font;

import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import java.lang.reflect.Field;
import org.xml.sax.XMLReader;
/* loaded from: classes3.dex */
public class PropertyReaderUtil {
    /* JADX INFO: Access modifiers changed from: protected */
    public static String getProperty(XMLReader xMLReader, String str) {
        try {
            Field declaredField = xMLReader.getClass().getDeclaredField("theNewElement");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(xMLReader);
            Field declaredField2 = obj.getClass().getDeclaredField("theAtts");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Field declaredField3 = obj2.getClass().getDeclaredField("data");
            declaredField3.setAccessible(true);
            Object[] objArr = (String[]) declaredField3.get(obj2);
            Field declaredField4 = obj2.getClass().getDeclaredField(DebugConfiguration.DebugActionExtra.CRUISE_CONGESTION_LENGTH);
            declaredField4.setAccessible(true);
            int intValue = ((Integer) declaredField4.get(obj2)).intValue();
            for (int i = 0; i < intValue; i++) {
                int i2 = i * 5;
                if (str.equals(objArr[i2 + 1])) {
                    return objArr[i2 + 4];
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
