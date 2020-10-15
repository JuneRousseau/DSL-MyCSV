package org.xtext.generator;

import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
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
import org.xtext.myCsv.ExpressionLog;
import org.xtext.myCsv.ExpressionRel;
import org.xtext.myCsv.Field;
import org.xtext.myCsv.FieldIndexName;
import org.xtext.myCsv.FieldIndexNum;
import org.xtext.myCsv.Insert;
import org.xtext.myCsv.InsertField;
import org.xtext.myCsv.InsertLine;
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
public class MyCsvPrettyPrinter {
  protected String _prettyPrint(final Program p) {
    String res = "";
    EList<Statement> _stmts = p.getStmts();
    for (final Statement stmt : _stmts) {
      String _res = res;
      String _prettyPrint = this.prettyPrint(stmt);
      String _plus = (_prettyPrint + "\n");
      res = (_res + _plus);
    }
    return res;
  }
  
  protected String _prettyPrint(final LineIndexCond f) {
    return this.prettyPrint(f.getCond());
  }
  
  protected String _prettyPrint(final LineIndexNum f) {
    String res = "";
    EList<Integer> _lines = f.getLines();
    for (final Integer num : _lines) {
      res = ((res + num) + " ");
    }
    return res;
  }
  
  protected String _prettyPrint(final FieldIndexName f) {
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
  
  protected String _prettyPrint(final FieldIndexNum f) {
    String res = "";
    EList<Integer> _columns = f.getColumns();
    for (final Integer col : _columns) {
      res = ((res + col) + " ");
    }
    return res;
  }
  
  protected String _prettyPrint(final CellIndex f) {
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
  
  protected String _prettyPrint(final Values v) {
    String res = "";
    EList<Value> _values = v.getValues();
    for (final Value value : _values) {
      String _prettyPrint = this.prettyPrint(value);
      String _plus = (res + _prettyPrint);
      String _plus_1 = (_plus + " ");
      res = _plus_1;
    }
    return res;
  }
  
  protected String _prettyPrint(final Load l) {
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
  
  protected String _prettyPrint(final Store l) {
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
  
  protected String _prettyPrint(final ExportJson l) {
    String _value = l.getPath().getValue();
    String _plus = ("ExportJson \"" + _value);
    return (_plus + "\"");
  }
  
  protected String _prettyPrint(final Projection l) {
    String _prettyPrint = this.prettyPrint(l.getField());
    return ("Projection " + _prettyPrint);
  }
  
  protected String _prettyPrint(final Select l) {
    String _prettyPrint = this.prettyPrint(l.getLine());
    return ("Select " + _prettyPrint);
  }
  
  protected String _prettyPrint(final Delete l) {
    String _prettyPrint = this.prettyPrint(l);
    return ("Delete " + _prettyPrint);
  }
  
  protected String _prettyPrint(final DeleteField l) {
    String _prettyPrint = this.prettyPrint(l.getFields());
    return ("field " + _prettyPrint);
  }
  
  protected String _prettyPrint(final DeleteLine l) {
    String _prettyPrint = this.prettyPrint(l.getLines());
    return ("line " + _prettyPrint);
  }
  
  protected String _prettyPrint(final Insert l) {
    String _prettyPrint = this.prettyPrint(l);
    return ("Insert " + _prettyPrint);
  }
  
  protected String _prettyPrint(final InsertField l) {
    String _value = l.getFieldname().getValue();
    String _plus = ("field " + _value);
    String _plus_1 = (_plus + ": ");
    String _prettyPrint = this.prettyPrint(l.getValues());
    return (_plus_1 + _prettyPrint);
  }
  
  protected String _prettyPrint(final InsertLine l) {
    String _prettyPrint = this.prettyPrint(l.getValues());
    return ("line " + _prettyPrint);
  }
  
  protected String _prettyPrint(final Modify l) {
    String _prettyPrint = this.prettyPrint(l);
    return ("Modify " + _prettyPrint);
  }
  
  protected String _prettyPrint(final ModifyField l) {
    String _prettyPrint = this.prettyPrint(l.getFields());
    String _plus = ("field " + _prettyPrint);
    String _plus_1 = (_plus + " with ");
    String _prettyPrint_1 = this.prettyPrint(l.getValues());
    return (_plus_1 + _prettyPrint_1);
  }
  
  protected String _prettyPrint(final ModifyLine l) {
    String _prettyPrint = this.prettyPrint(l.getLines());
    String _plus = ("line " + _prettyPrint);
    String _plus_1 = (_plus + " with ");
    String _prettyPrint_1 = this.prettyPrint(l.getValues());
    return (_plus_1 + _prettyPrint_1);
  }
  
  protected String _prettyPrint(final ModifyCell l) {
    String _prettyPrint = this.prettyPrint(l.getCell());
    String _plus = ("cell " + _prettyPrint);
    String _plus_1 = (_plus + " with ");
    String _prettyPrint_1 = this.prettyPrint(l.getValue());
    return (_plus_1 + _prettyPrint_1);
  }
  
  protected String _prettyPrint(final Print l) {
    String _prettyPrint = this.prettyPrint(l);
    return ("Print " + _prettyPrint);
  }
  
  protected String _prettyPrint(final PrintField l) {
    String _prettyPrint = this.prettyPrint(l.getFields());
    return ("field " + _prettyPrint);
  }
  
  protected String _prettyPrint(final PrintLine l) {
    String _prettyPrint = this.prettyPrint(l.getLines());
    return ("line " + _prettyPrint);
  }
  
  protected String _prettyPrint(final PrintCell l) {
    String _prettyPrint = this.prettyPrint(l.getCell());
    return ("cell " + _prettyPrint);
  }
  
  protected String _prettyPrint(final PrintTable l) {
    return "table ";
  }
  
  protected String _prettyPrint(final PrintExpr l) {
    String _prettyPrint = this.prettyPrint(l.getExp());
    return ("expr " + _prettyPrint);
  }
  
  protected String _prettyPrint(final ExpressionLog l) {
    return this.prettyPrint(l.getExpr());
  }
  
  protected String _prettyPrint(final OrExpression l) {
    String res = this.prettyPrint(l.getLhs());
    EList<AndExpression> _rhs = l.getRhs();
    for (final AndExpression expr : _rhs) {
      String _prettyPrint = this.prettyPrint(expr);
      String _plus = ((res + " or ") + _prettyPrint);
      res = _plus;
    }
    return res;
  }
  
  protected String _prettyPrint(final AndExpression l) {
    String res = this.prettyPrint(l.getLhs());
    EList<UnaryLogExpression> _rhs = l.getRhs();
    for (final UnaryLogExpression expr : _rhs) {
      String _prettyPrint = this.prettyPrint(expr);
      String _plus = ((res + " and ") + _prettyPrint);
      res = _plus;
    }
    return res;
  }
  
  protected String _prettyPrint(final UnaryLogExpression l) {
    String res = "";
    boolean _isNot = l.isNot();
    if (_isNot) {
      res = (res + "not ");
    }
    String _prettyPrint = this.prettyPrint(l.getExpr());
    return (res + _prettyPrint);
  }
  
  protected String _prettyPrint(final ExpressionRel l) {
    String _value = l.getField().getValue();
    String _string = l.getOp().toString();
    String _plus = (_value + _string);
    String _prettyPrint = this.prettyPrint(l.getVal());
    String _plus_1 = (_plus + _prettyPrint);
    return (_plus_1 + " ");
  }
  
  protected String _prettyPrint(final NestedLogExpression l) {
    String _prettyPrint = this.prettyPrint(l.getExpr());
    String _plus = ("(" + _prettyPrint);
    return (_plus + ")");
  }
  
  protected String _prettyPrint(final ExpressionCalcul l) {
    return this.prettyPrint(l.getExpr());
  }
  
  protected String _prettyPrint(final AdditiveExpression l) {
    String res = this.prettyPrint(l.getLhs());
    EList<AdditiveExpressionRhs> _rhs = l.getRhs();
    for (final AdditiveExpressionRhs expr : _rhs) {
      String _prettyPrint = this.prettyPrint(expr);
      String _plus = (res + _prettyPrint);
      res = _plus;
    }
    return res;
  }
  
  protected String _prettyPrint(final AdditiveExpressionRhs l) {
    String _string = l.getOp().toString();
    String _plus = (_string + "");
    String _prettyPrint = this.prettyPrint(l.getRhs());
    return (_plus + _prettyPrint);
  }
  
  protected String _prettyPrint(final MultiplicativeExpression l) {
    String res = this.prettyPrint(l.getLhs());
    EList<MultiplicativeExpressionRhs> _rhs = l.getRhs();
    for (final MultiplicativeExpressionRhs expr : _rhs) {
      String _prettyPrint = this.prettyPrint(expr);
      String _plus = (res + _prettyPrint);
      res = _plus;
    }
    return res;
  }
  
  protected String _prettyPrint(final MultiplicativeExpressionRhs l) {
    String _string = l.getOp().toString();
    String _plus = (_string + "");
    String _prettyPrint = this.prettyPrint(l.getRhs());
    return (_plus + _prettyPrint);
  }
  
  protected String _prettyPrint(final UnaryExpression l) {
    String res = "";
    boolean _isOp = l.isOp();
    if (_isOp) {
      res = (res + "-");
    }
    String _prettyPrint = this.prettyPrint(l.getExpr());
    return (res + _prettyPrint);
  }
  
  protected String _prettyPrint(final NbField l) {
    return "NbField";
  }
  
  protected String _prettyPrint(final AggregatExpression l) {
    String _string = l.getAggregatOp().toString();
    String _plus = (_string + " ");
    String _value = l.getArg().getValue();
    return (_plus + _value);
  }
  
  protected String _prettyPrint(final LitteralInt l) {
    int _val = l.getVal();
    return (Integer.valueOf(_val) + "");
  }
  
  protected String _prettyPrint(final LitteralFloat l) {
    float _val = l.getVal();
    return (Float.valueOf(_val) + "");
  }
  
  protected String _prettyPrint(final NestedExpressionCalcul l) {
    String _prettyPrint = this.prettyPrint(l.getExpr());
    String _plus = ("(" + _prettyPrint);
    return (_plus + ")");
  }
  
  protected String _prettyPrint(final LitteralString l) {
    String _val = l.getVal();
    return (_val + "");
  }
  
  public String prettyPrint(final EObject l) {
    if (l instanceof DeleteField) {
      return _prettyPrint((DeleteField)l);
    } else if (l instanceof DeleteLine) {
      return _prettyPrint((DeleteLine)l);
    } else if (l instanceof InsertField) {
      return _prettyPrint((InsertField)l);
    } else if (l instanceof InsertLine) {
      return _prettyPrint((InsertLine)l);
    } else if (l instanceof ModifyCell) {
      return _prettyPrint((ModifyCell)l);
    } else if (l instanceof ModifyField) {
      return _prettyPrint((ModifyField)l);
    } else if (l instanceof ModifyLine) {
      return _prettyPrint((ModifyLine)l);
    } else if (l instanceof PrintCell) {
      return _prettyPrint((PrintCell)l);
    } else if (l instanceof PrintExpr) {
      return _prettyPrint((PrintExpr)l);
    } else if (l instanceof PrintField) {
      return _prettyPrint((PrintField)l);
    } else if (l instanceof PrintLine) {
      return _prettyPrint((PrintLine)l);
    } else if (l instanceof PrintTable) {
      return _prettyPrint((PrintTable)l);
    } else if (l instanceof AggregatExpression) {
      return _prettyPrint((AggregatExpression)l);
    } else if (l instanceof Delete) {
      return _prettyPrint((Delete)l);
    } else if (l instanceof ExportJson) {
      return _prettyPrint((ExportJson)l);
    } else if (l instanceof ExpressionCalcul) {
      return _prettyPrint((ExpressionCalcul)l);
    } else if (l instanceof ExpressionRel) {
      return _prettyPrint((ExpressionRel)l);
    } else if (l instanceof FieldIndexName) {
      return _prettyPrint((FieldIndexName)l);
    } else if (l instanceof FieldIndexNum) {
      return _prettyPrint((FieldIndexNum)l);
    } else if (l instanceof Insert) {
      return _prettyPrint((Insert)l);
    } else if (l instanceof LineIndexCond) {
      return _prettyPrint((LineIndexCond)l);
    } else if (l instanceof LineIndexNum) {
      return _prettyPrint((LineIndexNum)l);
    } else if (l instanceof LitteralFloat) {
      return _prettyPrint((LitteralFloat)l);
    } else if (l instanceof LitteralInt) {
      return _prettyPrint((LitteralInt)l);
    } else if (l instanceof LitteralString) {
      return _prettyPrint((LitteralString)l);
    } else if (l instanceof Load) {
      return _prettyPrint((Load)l);
    } else if (l instanceof Modify) {
      return _prettyPrint((Modify)l);
    } else if (l instanceof NbField) {
      return _prettyPrint((NbField)l);
    } else if (l instanceof NestedExpressionCalcul) {
      return _prettyPrint((NestedExpressionCalcul)l);
    } else if (l instanceof NestedLogExpression) {
      return _prettyPrint((NestedLogExpression)l);
    } else if (l instanceof Print) {
      return _prettyPrint((Print)l);
    } else if (l instanceof Projection) {
      return _prettyPrint((Projection)l);
    } else if (l instanceof Select) {
      return _prettyPrint((Select)l);
    } else if (l instanceof Store) {
      return _prettyPrint((Store)l);
    } else if (l instanceof AdditiveExpression) {
      return _prettyPrint((AdditiveExpression)l);
    } else if (l instanceof AdditiveExpressionRhs) {
      return _prettyPrint((AdditiveExpressionRhs)l);
    } else if (l instanceof AndExpression) {
      return _prettyPrint((AndExpression)l);
    } else if (l instanceof CellIndex) {
      return _prettyPrint((CellIndex)l);
    } else if (l instanceof ExpressionLog) {
      return _prettyPrint((ExpressionLog)l);
    } else if (l instanceof MultiplicativeExpression) {
      return _prettyPrint((MultiplicativeExpression)l);
    } else if (l instanceof MultiplicativeExpressionRhs) {
      return _prettyPrint((MultiplicativeExpressionRhs)l);
    } else if (l instanceof OrExpression) {
      return _prettyPrint((OrExpression)l);
    } else if (l instanceof Program) {
      return _prettyPrint((Program)l);
    } else if (l instanceof UnaryExpression) {
      return _prettyPrint((UnaryExpression)l);
    } else if (l instanceof UnaryLogExpression) {
      return _prettyPrint((UnaryLogExpression)l);
    } else if (l instanceof Values) {
      return _prettyPrint((Values)l);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(l).toString());
    }
  }
}
