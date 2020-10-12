package org.xtext.generator;

import org.eclipse.emf.common.util.EList;
import org.xtext.myCsv.AdditiveExpression;
import org.xtext.myCsv.AdditiveExpressionRhs;
import org.xtext.myCsv.AggregatExpression;
import org.xtext.myCsv.AndExpression;
import org.xtext.myCsv.CellIndex;
import org.xtext.myCsv.Delete;
import org.xtext.myCsv.DeleteField;
import org.xtext.myCsv.DeleteLine;
import org.xtext.myCsv.ExportJson;
import org.xtext.myCsv.ExpressionCalcul;
import org.xtext.myCsv.ExpressionCalculPrimary;
import org.xtext.myCsv.ExpressionLog;
import org.xtext.myCsv.ExpressionLogPrimary;
import org.xtext.myCsv.ExpressionRel;
import org.xtext.myCsv.FieldIndex;
import org.xtext.myCsv.FieldIndexName;
import org.xtext.myCsv.FieldIndexNum;
import org.xtext.myCsv.Insert;
import org.xtext.myCsv.InsertField;
import org.xtext.myCsv.InsertLine;
import org.xtext.myCsv.LineIndex;
import org.xtext.myCsv.LineIndexCond;
import org.xtext.myCsv.LineIndexNum;
import org.xtext.myCsv.LitteralFloat;
import org.xtext.myCsv.LitteralInt;
import org.xtext.myCsv.LitteralString;
import org.xtext.myCsv.Load;
import org.xtext.myCsv.Modify;
import org.xtext.myCsv.ModifyCell;
import org.xtext.myCsv.ModifyField;
import org.xtext.myCsv.ModifyLine;
import org.xtext.myCsv.MultiplicativeExpression;
import org.xtext.myCsv.MultiplicativeExpressionRhs;
import org.xtext.myCsv.NbField;
import org.xtext.myCsv.NestedExpressionCalcul;
import org.xtext.myCsv.NestedLogExpression;
import org.xtext.myCsv.OrExpression;
import org.xtext.myCsv.Print;
import org.xtext.myCsv.PrintCell;
import org.xtext.myCsv.PrintExpr;
import org.xtext.myCsv.PrintField;
import org.xtext.myCsv.PrintLine;
import org.xtext.myCsv.PrintTable;
import org.xtext.myCsv.Program;
import org.xtext.myCsv.Projection;
import org.xtext.myCsv.Select;
import org.xtext.myCsv.Statement;
import org.xtext.myCsv.Store;
import org.xtext.myCsv.UnaryExpression;
import org.xtext.myCsv.UnaryLogExpression;
import org.xtext.myCsv.Value;
import org.xtext.myCsv.Values;

/**
 * String visits
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public abstract class MyCsvVisitor {
  public String visit(final Program p) {
    String res = this.beforeVisit(p);
    EList<Statement> _stmts = p.getStmts();
    for (final Statement stmt : _stmts) {
      String _res = res;
      String _visit = this.visit(stmt);
      res = (_res + _visit);
    }
    String _afterVisit = this.afterVisit(p);
    return (res + _afterVisit);
  }
  
  public abstract String beforeVisit(final Program program);
  
  public abstract String afterVisit(final Program program);
  
  public String visit(final LineIndex l) {
    String res = this.beforeVisit(l);
    if ((l instanceof LineIndexCond)) {
      String _visit = this.visit(((LineIndexCond) l));
      String _plus = (res + _visit);
      res = _plus;
    }
    if ((l instanceof LineIndexNum)) {
      String _visit_1 = this.visit(((LineIndexNum) l));
      String _plus_1 = (res + _visit_1);
      res = _plus_1;
    }
    String _afterVisit = this.afterVisit(l);
    return (res + _afterVisit);
  }
  
  public abstract String beforeVisit(final LineIndex l);
  
  public abstract String afterVisit(final LineIndex l);
  
  public abstract String visit(final LineIndexCond f);
  
  public abstract String visit(final LineIndexNum f);
  
  public String visit(final FieldIndex l) {
    String res = this.beforeVisit(l);
    if ((l instanceof FieldIndexName)) {
      String _visit = this.visit(((FieldIndexName) l));
      String _plus = (res + _visit);
      res = _plus;
    }
    if ((l instanceof FieldIndexNum)) {
      String _visit_1 = this.visit(((FieldIndexNum) l));
      String _plus_1 = (res + _visit_1);
      res = _plus_1;
    }
    String _afterVisit = this.afterVisit(l);
    return (res + _afterVisit);
  }
  
  public abstract String beforeVisit(final FieldIndex l);
  
  public abstract String afterVisit(final FieldIndex l);
  
  public abstract String visit(final FieldIndexName f);
  
  public abstract String visit(final FieldIndexNum f);
  
  public abstract String visit(final CellIndex f);
  
  public String visit(final Value l) {
    String res = this.beforeVisit(l);
    if ((l instanceof ExpressionCalcul)) {
      String _visit = this.visit(((ExpressionCalcul) l));
      String _plus = (res + _visit);
      res = _plus;
    }
    if ((l instanceof LitteralString)) {
      String _visit_1 = this.visit(((LitteralString) l));
      String _plus_1 = (res + _visit_1);
      res = _plus_1;
    }
    String _afterVisit = this.afterVisit(l);
    return (res + _afterVisit);
  }
  
  public abstract String beforeVisit(final Value l);
  
  public abstract String afterVisit(final Value l);
  
  public abstract String visit(final Values v);
  
  public String visit(final Statement l) {
    String res = this.beforeVisit(l);
    if ((l instanceof Load)) {
      String _visit = this.visit(((Load) l));
      String _plus = (res + _visit);
      res = _plus;
    }
    if ((l instanceof Store)) {
      String _visit_1 = this.visit(((Store) l));
      String _plus_1 = (res + _visit_1);
      res = _plus_1;
    }
    if ((l instanceof ExportJson)) {
      String _visit_2 = this.visit(((ExportJson) l));
      String _plus_2 = (res + _visit_2);
      res = _plus_2;
    }
    if ((l instanceof Projection)) {
      String _visit_3 = this.visit(((Projection) l));
      String _plus_3 = (res + _visit_3);
      res = _plus_3;
    }
    if ((l instanceof Select)) {
      String _visit_4 = this.visit(((Select) l));
      String _plus_4 = (res + _visit_4);
      res = _plus_4;
    }
    if ((l instanceof Delete)) {
      String _visit_5 = this.visit(((Delete) l));
      String _plus_5 = (res + _visit_5);
      res = _plus_5;
    }
    if ((l instanceof Insert)) {
      String _visit_6 = this.visit(((Insert) l));
      String _plus_6 = (res + _visit_6);
      res = _plus_6;
    }
    if ((l instanceof Modify)) {
      String _visit_7 = this.visit(((Modify) l));
      String _plus_7 = (res + _visit_7);
      res = _plus_7;
    }
    if ((l instanceof Print)) {
      String _visit_8 = this.visit(((Print) l));
      String _plus_8 = (res + _visit_8);
      res = _plus_8;
    }
    String _afterVisit = this.afterVisit(l);
    return (res + _afterVisit);
  }
  
  public abstract String beforeVisit(final Statement l);
  
  public abstract String afterVisit(final Statement l);
  
  public abstract String visit(final Load l);
  
  public abstract String visit(final Store l);
  
  public abstract String visit(final ExportJson l);
  
  public abstract String visit(final Projection l);
  
  public abstract String visit(final Select l);
  
  public String visit(final Delete l) {
    String res = this.beforeVisit(l);
    if ((l instanceof DeleteField)) {
      String _visit = this.visit(((DeleteField) l));
      String _plus = (res + _visit);
      res = _plus;
    }
    if ((l instanceof DeleteLine)) {
      String _visit_1 = this.visit(((DeleteLine) l));
      String _plus_1 = (res + _visit_1);
      res = _plus_1;
    }
    String _afterVisit = this.afterVisit(l);
    return (res + _afterVisit);
  }
  
  public abstract String beforeVisit(final Delete l);
  
  public abstract String afterVisit(final Delete l);
  
  public abstract String visit(final DeleteField l);
  
  public abstract String visit(final DeleteLine l);
  
  public String visit(final Insert l) {
    String res = this.beforeVisit(l);
    if ((l instanceof InsertField)) {
      String _visit = this.visit(((InsertField) l));
      String _plus = (res + _visit);
      res = _plus;
    }
    if ((l instanceof InsertLine)) {
      String _visit_1 = this.visit(((InsertLine) l));
      String _plus_1 = (res + _visit_1);
      res = _plus_1;
    }
    String _afterVisit = this.afterVisit(l);
    return (res + _afterVisit);
  }
  
  public abstract String beforeVisit(final Insert l);
  
  public abstract String afterVisit(final Insert l);
  
  public abstract String visit(final InsertField l);
  
  public abstract String visit(final InsertLine l);
  
  public String visit(final Modify l) {
    String res = this.beforeVisit(l);
    if ((l instanceof ModifyField)) {
      String _visit = this.visit(((ModifyField) l));
      String _plus = (res + _visit);
      res = _plus;
    }
    if ((l instanceof ModifyLine)) {
      String _visit_1 = this.visit(((ModifyLine) l));
      String _plus_1 = (res + _visit_1);
      res = _plus_1;
    }
    if ((l instanceof ModifyCell)) {
      String _visit_2 = this.visit(((ModifyCell) l));
      String _plus_2 = (res + _visit_2);
      res = _plus_2;
    }
    String _afterVisit = this.afterVisit(l);
    return (res + _afterVisit);
  }
  
  public abstract String beforeVisit(final Modify l);
  
  public abstract String afterVisit(final Modify l);
  
  public abstract String visit(final ModifyField l);
  
  public abstract String visit(final ModifyLine l);
  
  public abstract String visit(final ModifyCell l);
  
  public String visit(final Print l) {
    String res = this.beforeVisit(l);
    if ((l instanceof PrintField)) {
      String _visit = this.visit(((PrintField) l));
      String _plus = (res + _visit);
      res = _plus;
    }
    if ((l instanceof PrintLine)) {
      String _visit_1 = this.visit(((PrintLine) l));
      String _plus_1 = (res + _visit_1);
      res = _plus_1;
    }
    if ((l instanceof PrintCell)) {
      String _visit_2 = this.visit(((PrintCell) l));
      String _plus_2 = (res + _visit_2);
      res = _plus_2;
    }
    if ((l instanceof PrintTable)) {
      String _visit_3 = this.visit(((PrintTable) l));
      String _plus_3 = (res + _visit_3);
      res = _plus_3;
    }
    if ((l instanceof PrintExpr)) {
      String _visit_4 = this.visit(((PrintExpr) l));
      String _plus_4 = (res + _visit_4);
      res = _plus_4;
    }
    String _afterVisit = this.afterVisit(l);
    return (res + _afterVisit);
  }
  
  public abstract String beforeVisit(final Print l);
  
  public abstract String afterVisit(final Print l);
  
  public abstract String visit(final PrintField l);
  
  public abstract String visit(final PrintLine l);
  
  public abstract String visit(final PrintCell l);
  
  public abstract String visit(final PrintTable l);
  
  public abstract String visit(final PrintExpr l);
  
  public abstract String visit(final ExpressionLog l);
  
  public abstract String visit(final OrExpression l);
  
  public abstract String visit(final AndExpression l);
  
  public abstract String visit(final UnaryLogExpression l);
  
  public String visit(final ExpressionLogPrimary l) {
    String res = this.beforeVisit(l);
    if ((l instanceof ExpressionRel)) {
      String _visit = this.visit(((ExpressionRel) l));
      String _plus = (res + _visit);
      res = _plus;
    }
    if ((l instanceof NestedLogExpression)) {
      String _visit_1 = this.visit(((NestedLogExpression) l));
      String _plus_1 = (res + _visit_1);
      res = _plus_1;
    }
    String _afterVisit = this.afterVisit(l);
    return (res + _afterVisit);
  }
  
  public abstract String beforeVisit(final ExpressionLogPrimary l);
  
  public abstract String afterVisit(final ExpressionLogPrimary l);
  
  public abstract String visit(final ExpressionRel l);
  
  public abstract String visit(final NestedLogExpression l);
  
  public abstract String visit(final ExpressionCalcul l);
  
  public abstract String visit(final AdditiveExpression l);
  
  public abstract String visit(final AdditiveExpressionRhs l);
  
  public abstract String visit(final MultiplicativeExpression l);
  
  public abstract String visit(final MultiplicativeExpressionRhs l);
  
  public abstract String visit(final UnaryExpression l);
  
  public String visit(final ExpressionCalculPrimary l) {
    String res = this.beforeVisit(l);
    if ((l instanceof NbField)) {
      String _visit = this.visit(((NbField) l));
      String _plus = (res + _visit);
      res = _plus;
    }
    if ((l instanceof AggregatExpression)) {
      String _visit_1 = this.visit(((AggregatExpression) l));
      String _plus_1 = (res + _visit_1);
      res = _plus_1;
    }
    if ((l instanceof LitteralInt)) {
      String _visit_2 = this.visit(((LitteralInt) l));
      String _plus_2 = (res + _visit_2);
      res = _plus_2;
    }
    if ((l instanceof LitteralFloat)) {
      String _visit_3 = this.visit(((LitteralFloat) l));
      String _plus_3 = (res + _visit_3);
      res = _plus_3;
    }
    if ((l instanceof NestedExpressionCalcul)) {
      String _visit_4 = this.visit(((NestedExpressionCalcul) l));
      String _plus_4 = (res + _visit_4);
      res = _plus_4;
    }
    String _afterVisit = this.afterVisit(l);
    return (res + _afterVisit);
  }
  
  public abstract String beforeVisit(final ExpressionCalculPrimary l);
  
  public abstract String afterVisit(final ExpressionCalculPrimary l);
  
  public abstract String visit(final NbField l);
  
  public abstract String visit(final AggregatExpression l);
  
  public abstract String visit(final LitteralInt l);
  
  public abstract String visit(final LitteralFloat l);
  
  public abstract String visit(final NestedExpressionCalcul l);
  
  public abstract String visit(final LitteralString l);
}
