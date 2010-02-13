//$Id: UnaryArithmeticNode.java,v 1.1 2008/01/14 09:32:45 b18146 Exp $
package org.hibernate.hql.ast.tree;

import org.hibernate.hql.ast.util.ColumnHelper;
import org.hibernate.type.Type;

import antlr.SemanticException;

public class UnaryArithmeticNode extends AbstractSelectExpression implements UnaryOperatorNode {

	public Type getDataType() {
		return ( ( SqlNode ) getOperand() ).getDataType();
	}

	public void setScalarColumnText(int i) throws SemanticException {
		ColumnHelper.generateSingleScalarColumn( this, i );
	}

	public void initialize() {
		// nothing to do; even if the operand is a parameter, no way we could
		// infer an appropriate expected type here
	}

	public Node getOperand() {
		return ( Node ) getFirstChild();
	}
}