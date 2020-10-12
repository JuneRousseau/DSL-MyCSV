package org.xtext.generator;

import org.eclipse.emf.common.util.EList;
import org.xtext.generator.MyCsvVisitor;
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
import org.xtext.myCsv.Field;
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
 * PrettyPrinter
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class MyCsvPrettyPrinter extends MyCsvVisitor {
  @Override
  public String beforeVisit(final Program program) {
    return "";
  }
  
  @Override
  public String afterVisit(final Program program) {
    return "";
  }
  
  @Override
  public String beforeVisit(final LineIndex l) {
    return "";
  }
  
  @Override
  public String afterVisit(final LineIndex l) {
    return "";
  }
  
  @Override
  public String visit(final LineIndexCond f) {
    return this.visit(f.getCond());
  }
  
  @Override
  public String visit(final LineIndexNum f) {
    String res = "";
    EList<Integer> _lines = f.getLines();
    for (final Integer num : _lines) {
      res = ((res + num) + " ");
    }
    return res;
  }
  
  @Override
  public String beforeVisit(final FieldIndex l) {
    return "";
  }
  
  @Override
  public String afterVisit(final FieldIndex l) {
    return "";
  }
  
  @Override
  public String visit(final FieldIndexName f) {
    String res = "";
    EList<Field> _fields = f.getFields();
    for (final Field field : _fields) {
      String _value = field.getValue();
      String _plus = (res + _value);
      String _plus_1 = (_plus + " ");
      res = _plus_1;
    }
    return res;
  }
  
  @Override
  public String visit(final FieldIndexNum f) {
    String res = "";
    EList<Integer> _columns = f.getColumns();
    for (final Integer col : _columns) {
      res = ((res + col) + " ");
    }
    return res;
  }
  
  @Override
  public String visit(final CellIndex f) {
    int _line = f.getLine();
    String _plus = ("(" + Integer.valueOf(_line));
    String res = (_plus + ", ");
    Field _colname = f.getColname();
    boolean _tripleEquals = (_colname == null);
    if (_tripleEquals) {
      int _colnum = f.getColnum();
      String _plus_1 = (res + Integer.valueOf(_colnum));
      res = _plus_1;
    } else {
      String _value = f.getColname().getValue();
      String _plus_2 = (res + _value);
      res = _plus_2;
    }
    res = (res + ")");
    return res;
  }
  
  @Override
  public String beforeVisit(final Value l) {
    return "";
  }
  
  @Override
  public String afterVisit(final Value l) {
    return "";
  }
  
  @Override
  public String visit(final Values v) {
    String res = "";
    EList<Value> _values = v.getValues();
    for (final Value value : _values) {
      String _visit = this.visit(value);
      String _plus = (res + _visit);
      String _plus_1 = (_plus + " ");
      res = _plus_1;
    }
    return res;
  }
  
  @Override
  public String beforeVisit(final Statement l) {
    return "";
  }
  
  @Override
  public String afterVisit(final Statement l) {
    return "\n";
  }
  
  @Override
  public String visit(final Load l) {
    String _value = l.getPath().getValue();
    String _plus = ("Load \"" + _value);
    String res = (_plus + "\"");
    boolean _isSepDefined = l.isSepDefined();
    if (_isSepDefined) {
      String _sep = l.getSep();
      String _plus_1 = ((res + " sep=\"") + _sep);
      String _plus_2 = (_plus_1 + "\"");
      res = _plus_2;
    }
    boolean _isNoHeader = l.isNoHeader();
    if (_isNoHeader) {
      res = (res + " noheader");
    }
    return res;
  }
  
  @Override
  public String visit(final Store l) {
    String _value = l.getPath().getValue();
    String _plus = ("Store \"" + _value);
    String res = (_plus + "\"");
    boolean _isSepDefined = l.isSepDefined();
    if (_isSepDefined) {
      String _sep = l.getSep();
      String _plus_1 = ((res + " sep=\"") + _sep);
      String _plus_2 = (_plus_1 + "\"");
      res = _plus_2;
    }
    return res;
  }
  
  @Override
  public String visit(final ExportJson l) {
    String _value = l.getPath().getValue();
    String _plus = ("ExportJson \"" + _value);
    return (_plus + "\"");
  }
  
  @Override
  public String visit(final Projection l) {
    String _visit = this.visit(l.getField());
    return ("Projection " + _visit);
  }
  
  @Override
  public String visit(final Select l) {
    String _visit = this.visit(l.getLine());
    return ("Select " + _visit);
  }
  
  @Override
  public String beforeVisit(final Delete l) {
    return "Delete ";
  }
  
  @Override
  public String afterVisit(final Delete l) {
    return "";
  }
  
  @Override
  public String visit(final DeleteField l) {
    String _visit = this.visit(l.getFields());
    return ("field " + _visit);
  }
  
  @Override
  public String visit(final DeleteLine l) {
    String _visit = this.visit(l.getLines());
    return ("line " + _visit);
  }
  
  @Override
  public String beforeVisit(final Insert l) {
    return "Insert ";
  }
  
  @Override
  public String afterVisit(final Insert l) {
    return "";
  }
  
  @Override
  public String visit(final InsertField l) {
    String _value = l.getFieldname().getValue();
    String _plus = ("field " + _value);
    String _plus_1 = (_plus + ": ");
    String _visit = this.visit(l.getValues());
    return (_plus_1 + _visit);
  }
  
  @Override
  public String visit(final InsertLine l) {
    String _visit = this.visit(l.getValues());
    return ("line " + _visit);
  }
  
  @Override
  public String beforeVisit(final Modify l) {
    return "Modify ";
  }
  
  @Override
  public String afterVisit(final Modify l) {
    return "";
  }
  
  @Override
  public String visit(final ModifyField l) {
    String _visit = this.visit(l.getFields());
    String _plus = ("field " + _visit);
    String _plus_1 = (_plus + " with ");
    String _visit_1 = this.visit(l.getValues());
    return (_plus_1 + _visit_1);
  }
  
  @Override
  public String visit(final ModifyLine l) {
    String _visit = this.visit(l.getLines());
    String _plus = ("line " + _visit);
    String _plus_1 = (_plus + " with ");
    String _visit_1 = this.visit(l.getValues());
    return (_plus_1 + _visit_1);
  }
  
  @Override
  public String visit(final ModifyCell l) {
    String _visit = this.visit(l.getCell());
    String _plus = ("cell " + _visit);
    String _plus_1 = (_plus + " with ");
    String _visit_1 = this.visit(l.getValue());
    return (_plus_1 + _visit_1);
  }
  
  @Override
  public String beforeVisit(final Print l) {
    return "Print ";
  }
  
  @Override
  public String afterVisit(final Print l) {
    return "";
  }
  
  @Override
  public String visit(final PrintField l) {
    String _visit = this.visit(l.getFields());
    return ("field " + _visit);
  }
  
  @Override
  public String visit(final PrintLine l) {
    String _visit = this.visit(l.getLines());
    return ("line " + _visit);
  }
  
  @Override
  public String visit(final PrintCell l) {
    String _visit = this.visit(l.getCell());
    return ("cell " + _visit);
  }
  
  @Override
  public String visit(final PrintTable l) {
    return "table ";
  }
  
  @Override
  public String visit(final PrintExpr l) {
    String _visit = this.visit(l.getExp());
    return ("expr " + _visit);
  }
  
  @Override
  public String visit(final ExpressionLog l) {
    return this.visit(l.getExpr());
  }
  
  @Override
  public String visit(final OrExpression l) {
    String res = this.visit(l.getLhs());
    EList<AndExpression> _rhs = l.getRhs();
    for (final AndExpression expr : _rhs) {
      String _visit = this.visit(expr);
      String _plus = ((res + " or ") + _visit);
      res = _plus;
    }
    return res;
  }
  
  @Override
  public String visit(final AndExpression l) {
    String res = this.visit(l.getLhs());
    EList<UnaryLogExpression> _rhs = l.getRhs();
    for (final UnaryLogExpression expr : _rhs) {
      String _visit = this.visit(expr);
      String _plus = ((res + " and ") + _visit);
      res = _plus;
    }
    return res;
  }
  
  @Override
  public String visit(final UnaryLogExpression l) {
    String res = "";
    boolean _isNot = l.isNot();
    if (_isNot) {
      res = (res + "not ");
    }
    String _visit = this.visit(l.getExpr());
    return (res + _visit);
  }
  
  @Override
  public String beforeVisit(final ExpressionLogPrimary l) {
    return "";
  }
  
  @Override
  public String afterVisit(final ExpressionLogPrimary l) {
    return "";
  }
  
  @Override
  public String visit(final ExpressionRel l) {
    String _value = l.getField().getValue();
    String _string = l.getOp().toString();
    String _plus = (_value + _string);
    String _visit = this.visit(l.getVal());
    String _plus_1 = (_plus + _visit);
    return (_plus_1 + " ");
  }
  
  @Override
  public String visit(final NestedLogExpression l) {
    String _visit = this.visit(l.getExpr());
    String _plus = ("(" + _visit);
    return (_plus + ")");
  }
  
  @Override
  public String visit(final ExpressionCalcul l) {
    return this.visit(l.getExpr());
  }
  
  @Override
  public String visit(final AdditiveExpression l) {
    String res = this.visit(l.getLhs());
    EList<AdditiveExpressionRhs> _rhs = l.getRhs();
    for (final AdditiveExpressionRhs expr : _rhs) {
      String _visit = this.visit(expr);
      String _plus = (res + _visit);
      res = _plus;
    }
    return res;
  }
  
  @Override
  public String visit(final AdditiveExpressionRhs l) {
    String _string = l.getOp().toString();
    String _plus = (_string + "");
    String _visit = this.visit(l.getRhs());
    return (_plus + _visit);
  }
  
  @Override
  public String visit(final MultiplicativeExpression l) {
    String res = this.visit(l.getLhs());
    EList<MultiplicativeExpressionRhs> _rhs = l.getRhs();
    for (final MultiplicativeExpressionRhs expr : _rhs) {
      String _visit = this.visit(expr);
      String _plus = (res + _visit);
      res = _plus;
    }
    return res;
  }
  
  @Override
  public String visit(final MultiplicativeExpressionRhs l) {
    String _string = l.getOp().toString();
    String _plus = (_string + "");
    String _visit = this.visit(l.getRhs());
    return (_plus + _visit);
  }
  
  @Override
  public String visit(final UnaryExpression l) {
    String res = "";
    boolean _isOp = l.isOp();
    if (_isOp) {
      res = (res + "-");
    }
    String _visit = this.visit(l.getExpr());
    return (res + _visit);
  }
  
  @Override
  public String beforeVisit(final ExpressionCalculPrimary l) {
    return "";
  }
  
  @Override
  public String afterVisit(final ExpressionCalculPrimary l) {
    return "";
  }
  
  @Override
  public String visit(final NbField l) {
    return "NbField";
  }
  
  @Override
  public String visit(final AggregatExpression l) {
    String _string = l.getAggregatOp().toString();
    String _plus = (_string + " ");
    String _value = l.getArg().getValue();
    return (_plus + _value);
  }
  
  @Override
  public String visit(final LitteralInt l) {
    int _val = l.getVal();
    return (Integer.valueOf(_val) + "");
  }
  
  @Override
  public String visit(final LitteralFloat l) {
    float _val = l.getVal();
    return (Float.valueOf(_val) + "");
  }
  
  @Override
  public String visit(final NestedExpressionCalcul l) {
    String _visit = this.visit(l.getExpr());
    String _plus = ("(" + _visit);
    return (_plus + ")");
  }
  
  @Override
  public String visit(final LitteralString l) {
    String _val = l.getVal();
    return (_val + "");
  }
}
