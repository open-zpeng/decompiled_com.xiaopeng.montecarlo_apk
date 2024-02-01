package org.objectweb.asm;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:org/objectweb/asm/CurrentFrame.SCL.lombok */
final class CurrentFrame extends Frame {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CurrentFrame(Label owner) {
        super(owner);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.objectweb.asm.Frame
    public void execute(int opcode, int arg, Symbol symbolArg, SymbolTable symbolTable) {
        super.execute(opcode, arg, symbolArg, symbolTable);
        Frame successor = new Frame(null);
        merge(symbolTable, successor, 0);
        copyFrom(successor);
    }
}
