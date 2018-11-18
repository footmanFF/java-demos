package com.footmanff.groovy.metaprogramming;

import groovy.transform.CompileStatic;
import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.MethodNode;
import org.codehaus.groovy.ast.expr.ArgumentListExpression;
import org.codehaus.groovy.ast.expr.ConstantExpression;
import org.codehaus.groovy.ast.expr.MethodCallExpression;
import org.codehaus.groovy.ast.expr.VariableExpression;
import org.codehaus.groovy.ast.stmt.BlockStatement;
import org.codehaus.groovy.ast.stmt.ExpressionStatement;
import org.codehaus.groovy.ast.stmt.Statement;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

import java.util.List;

/**
 * @author footmanff on 2018/11/18.
 */
@CompileStatic
@GroovyASTTransformation( phase = CompilePhase.SEMANTIC_ANALYSIS )
public class WithLoggingASTTransformation implements ASTTransformation {

    @Override
    public void visit(ASTNode[] nodes, SourceUnit sourceUnit) {
        MethodNode method = (MethodNode) nodes[1];

        Statement startMessage = createPrintlnAst("Starting $method.name");
        Statement endMessage = createPrintlnAst("Ending $method.name");

        List<Statement> existingStatements = ((BlockStatement) method.getCode()).getStatements();
        existingStatements.add(0, startMessage);
        existingStatements.add(endMessage);

    }

    private static Statement createPrintlnAst(String message) {
        return new ExpressionStatement(
                new MethodCallExpression(
                        new VariableExpression("this"),
                        new ConstantExpression("println"),
                        new ArgumentListExpression(
                                new ConstantExpression(message)
                        )
                )
        );
    }
}