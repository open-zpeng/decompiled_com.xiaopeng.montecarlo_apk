package lombok.patcher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/patcher/Symbols.SCL.lombok */
public class Symbols {
    private static final ThreadLocal<LinkedList<String>> stack = new ThreadLocal<LinkedList<String>>() { // from class: lombok.patcher.Symbols.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public LinkedList<String> initialValue() {
            return new LinkedList<>();
        }
    };

    private Symbols() {
    }

    public static void push(String symbol) {
        stack.get().addFirst(symbol);
    }

    public static void pop() {
        stack.get().poll();
    }

    public static boolean isEmpty() {
        return stack.get().isEmpty();
    }

    public static int size() {
        return stack.get().size();
    }

    public static boolean hasSymbol(String symbol) {
        if (symbol == null) {
            throw new NullPointerException("symbol");
        }
        return stack.get().contains(symbol);
    }

    public static boolean hasTail(String symbol) {
        if (symbol == null) {
            throw new NullPointerException("symbol");
        }
        return symbol.equals(stack.get().peek());
    }

    public static List<String> getCopy() {
        return new ArrayList(stack.get());
    }
}
