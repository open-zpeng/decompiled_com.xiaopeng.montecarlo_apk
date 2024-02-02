package lombok.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.regex.Pattern;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/core/JavaIdentifiers.SCL.lombok */
public class JavaIdentifiers {
    private static final LombokImmutableList<String> KEYWORDS = LombokImmutableList.of("public", "private", "protected", "default", "switch", "case", "for", "do", "goto", "const", "strictfp", "while", "if", "else", "byte", "short", "int", "long", TypedValues.Custom.S_FLOAT, "double", "void", TypedValues.Custom.S_BOOLEAN, "char", "null", "false", "true", "continue", "break", "return", "instanceof", "synchronized", "volatile", "transient", "final", "static", "interface", "class", "extends", "implements", "throws", "throw", "catch", "try", "finally", "abstract", "assert", "enum", "import", "package", "native", "new", "super", "this");
    private static final Pattern PRIMITIVE_TYPE_NAME_PATTERN = Pattern.compile("^(?:boolean|byte|short|int|long|float|double|char)$");

    private JavaIdentifiers() {
    }

    public static boolean isValidJavaIdentifier(String identifier) {
        if (identifier == null || identifier.isEmpty() || !Character.isJavaIdentifierStart(identifier.charAt(0))) {
            return false;
        }
        for (int i = 1; i < identifier.length(); i++) {
            if (!Character.isJavaIdentifierPart(identifier.charAt(i))) {
                return false;
            }
        }
        return !isKeyword(identifier);
    }

    public static boolean isKeyword(String keyword) {
        return KEYWORDS.contains(keyword);
    }

    public static boolean isPrimitive(String typeName) {
        return PRIMITIVE_TYPE_NAME_PATTERN.matcher(typeName).matches();
    }
}
