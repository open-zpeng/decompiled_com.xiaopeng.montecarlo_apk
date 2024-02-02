package lombok.javac.handlers;

import com.autonavi.gbl.pos.model.LocFuncSwitch;
import com.sun.tools.javac.tree.JCTree;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import lombok.Lombok;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.PrintAST;
import lombok.javac.JavacASTVisitor;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
@HandlerPriority(LocFuncSwitch.LocFuncPatchFrameForFeiGeG8G9)
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/javac/handlers/HandlePrintAST.SCL.lombok */
public class HandlePrintAST extends JavacAnnotationHandler<PrintAST> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<PrintAST> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        PrintStream stream = System.out;
        String fileName = annotation.getInstance().outfile();
        if (fileName.length() > 0) {
            try {
                stream = new PrintStream(new File(fileName));
            } catch (FileNotFoundException e) {
                throw Lombok.sneakyThrow(e);
            }
        }
        try {
            annotationNode.up().traverse(new JavacASTVisitor.Printer(annotation.getInstance().printContent(), stream));
            if (stream != System.out) {
                try {
                    stream.close();
                } catch (Exception e2) {
                    throw Lombok.sneakyThrow(e2);
                }
            }
        } catch (Throwable th) {
            if (stream != System.out) {
                try {
                    stream.close();
                } catch (Exception e3) {
                    throw Lombok.sneakyThrow(e3);
                }
            }
            throw th;
        }
    }
}
