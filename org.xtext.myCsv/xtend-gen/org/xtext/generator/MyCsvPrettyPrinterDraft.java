package org.xtext.generator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.xtext.myCsv.CellIndex;
import org.xtext.myCsv.Delete;
import org.xtext.myCsv.DeleteField;
import org.xtext.myCsv.DeleteLine;
import org.xtext.myCsv.ExportJson;
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
import org.xtext.myCsv.Load;
import org.xtext.myCsv.Modify;
import org.xtext.myCsv.ModifyCell;
import org.xtext.myCsv.ModifyField;
import org.xtext.myCsv.ModifyLine;
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
import org.xtext.myCsv.Value;
import org.xtext.myCsv.Values;

/**
 * Pretty-prints
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class MyCsvPrettyPrinterDraft {
  public void prettyPrint(final Program p) {
    EList<Statement> _stmts = p.getStmts();
    for (final Statement stmt : _stmts) {
      this.prettyPrint(stmt);
    }
  }
  
  public void prettyPrint(final Load l) {
    String _value = l.getPath().getValue();
    String _plus = ("Load \"" + _value);
    String _plus_1 = (_plus + "\"");
    InputOutput.<String>print(_plus_1);
    boolean _isSepDefined = l.isSepDefined();
    if (_isSepDefined) {
      String _sep = l.getSep();
      String _plus_2 = (" sep=\"" + _sep);
      String _plus_3 = (_plus_2 + "\"");
      InputOutput.<String>print(_plus_3);
    }
    boolean _isNoHeader = l.isNoHeader();
    if (_isNoHeader) {
      InputOutput.<String>print(" noheader");
    }
    InputOutput.println();
  }
  
  public void prettyPrint(final Store l) {
    String _value = l.getPath().getValue();
    String _plus = ("Store \"" + _value);
    String _plus_1 = (_plus + "\"");
    InputOutput.<String>print(_plus_1);
    boolean _isSepDefined = l.isSepDefined();
    if (_isSepDefined) {
      String _sep = l.getSep();
      String _plus_2 = (" sep=\"" + _sep);
      String _plus_3 = (_plus_2 + "\"");
      InputOutput.<String>print(_plus_3);
    }
    InputOutput.println();
  }
  
  public String prettyPrint(final ExportJson l) {
    String _value = l.getPath().getValue();
    String _plus = ("ExportJson \"" + _value);
    String _plus_1 = (_plus + "\"");
    return InputOutput.<String>println(_plus_1);
  }
  
  public void prettyPrint(final Projection l) {
    InputOutput.<String>print("Projecion ");
    this.prettyPrint(l.getField());
    InputOutput.println();
  }
  
  public void prettyPrint(final Select l) {
    InputOutput.<String>print("Select ");
    this.prettyPrint(l.getLine());
    InputOutput.println();
  }
  
  public void prettyPrint(final Delete l) {
    InputOutput.<String>print("Delete ");
    if ((l instanceof DeleteField)) {
      this.prettyPrint(((DeleteField) l));
    }
    if ((l instanceof DeleteLine)) {
      this.prettyPrint(((DeleteLine) l));
    }
    InputOutput.println();
  }
  
  public String prettyPrint(final DeleteField l) {
    String _xblockexpression = null;
    {
      InputOutput.<String>print("field ");
      _xblockexpression = this.prettyPrint(l.getFields());
    }
    return _xblockexpression;
  }
  
  public String prettyPrint(final DeleteLine l) {
    String _xblockexpression = null;
    {
      InputOutput.<String>print("line ");
      _xblockexpression = this.prettyPrint(l.getLines());
    }
    return _xblockexpression;
  }
  
  public void prettyPrint(final Modify l) {
    InputOutput.<String>print("Modify ");
    if ((l instanceof ModifyField)) {
      this.prettyPrint(((ModifyField) l));
    }
    if ((l instanceof ModifyLine)) {
      this.prettyPrint(((ModifyLine) l));
    }
    if ((l instanceof ModifyCell)) {
      this.prettyPrint(((ModifyCell) l));
    }
    InputOutput.println();
  }
  
  public String prettyPrint(final ModifyField l) {
    String _xblockexpression = null;
    {
      InputOutput.<String>print("field ");
      this.prettyPrint(l.getFields());
      InputOutput.<String>print(" with ");
      _xblockexpression = this.prettyPrint(l.getValues());
    }
    return _xblockexpression;
  }
  
  public String prettyPrint(final ModifyLine l) {
    String _xblockexpression = null;
    {
      InputOutput.<String>print("line ");
      this.prettyPrint(l.getLines());
      InputOutput.<String>print(" with ");
      _xblockexpression = this.prettyPrint(l.getValues());
    }
    return _xblockexpression;
  }
  
  public String prettyPrint(final ModifyCell l) {
    String _xblockexpression = null;
    {
      InputOutput.<String>print("cell ");
      this.prettyPrint(l.getCell());
      InputOutput.<String>print(" with ");
      _xblockexpression = this.prettyPrint(l.getValue());
    }
    return _xblockexpression;
  }
  
  public void prettyPrint(final Insert l) {
    InputOutput.<String>print("Insert ");
    if ((l instanceof InsertField)) {
      this.prettyPrint(((InsertField) l));
    }
    if ((l instanceof InsertLine)) {
      this.prettyPrint(((InsertLine) l));
    }
    InputOutput.println();
  }
  
  public String prettyPrint(final InsertField l) {
    String _xblockexpression = null;
    {
      String _value = l.getFieldname().getValue();
      String _plus = ("field " + _value);
      String _plus_1 = (_plus + ": ");
      InputOutput.<String>print(_plus_1);
      _xblockexpression = this.prettyPrint(l.getValues());
    }
    return _xblockexpression;
  }
  
  public String prettyPrint(final InsertLine l) {
    String _xblockexpression = null;
    {
      InputOutput.<String>print("line ");
      _xblockexpression = this.prettyPrint(l.getValues());
    }
    return _xblockexpression;
  }
  
  public void prettyPrint(final Print l) {
    InputOutput.<String>print("Print ");
    if ((l instanceof PrintField)) {
      this.prettyPrint(((PrintField) l));
    }
    if ((l instanceof PrintLine)) {
      this.prettyPrint(((PrintLine) l));
    }
    if ((l instanceof PrintCell)) {
      this.prettyPrint(((PrintCell) l));
    }
    if ((l instanceof PrintTable)) {
      this.prettyPrint(((PrintTable) l));
    }
    if ((l instanceof PrintExpr)) {
      this.prettyPrint(((PrintExpr) l));
    }
    InputOutput.println();
  }
  
  public String prettyPrint(final PrintField l) {
    String _xblockexpression = null;
    {
      InputOutput.<String>print("field ");
      _xblockexpression = this.prettyPrint(l.getFields());
    }
    return _xblockexpression;
  }
  
  public String prettyPrint(final PrintLine l) {
    String _xblockexpression = null;
    {
      InputOutput.<String>print("line ");
      _xblockexpression = this.prettyPrint(l.getLines());
    }
    return _xblockexpression;
  }
  
  public String prettyPrint(final PrintCell l) {
    String _xblockexpression = null;
    {
      InputOutput.<String>print("cell ");
      _xblockexpression = this.prettyPrint(l.getCell());
    }
    return _xblockexpression;
  }
  
  public String prettyPrint(final PrintTable l) {
    return InputOutput.<String>print("table");
  }
  
  public String prettyPrint(final PrintExpr l) {
    String _xblockexpression = null;
    {
      InputOutput.<String>print("expr ");
      _xblockexpression = this.prettyPrint(l.getExp());
    }
    return _xblockexpression;
  }
  
  public String prettyPrint(final Values v) {
    return InputOutput.<String>print("<Values>");
  }
  
  public String prettyPrint(final Value v) {
    return InputOutput.<String>print("<Value>");
  }
  
  public void prettyPrint(final Statement stmt) {
    if ((stmt instanceof Load)) {
      final Load l = ((Load) stmt);
      this.prettyPrint(l);
    }
    if ((stmt instanceof Store)) {
      final Store l_1 = ((Store) stmt);
      this.prettyPrint(l_1);
    }
    if ((stmt instanceof ExportJson)) {
      final ExportJson l_2 = ((ExportJson) stmt);
      this.prettyPrint(l_2);
    }
    if ((stmt instanceof Projection)) {
      final Projection l_3 = ((Projection) stmt);
      this.prettyPrint(l_3);
    }
    if ((stmt instanceof Select)) {
      final Select l_4 = ((Select) stmt);
      this.prettyPrint(l_4);
    }
    if ((stmt instanceof Delete)) {
      final Delete l_5 = ((Delete) stmt);
      this.prettyPrint(l_5);
    }
    if ((stmt instanceof Insert)) {
      final Insert l_6 = ((Insert) stmt);
      this.prettyPrint(l_6);
    }
    if ((stmt instanceof Modify)) {
      final Modify l_7 = ((Modify) stmt);
      this.prettyPrint(l_7);
    }
    if ((stmt instanceof Print)) {
      final Print l_8 = ((Print) stmt);
      this.prettyPrint(l_8);
    }
  }
  
  public String prettyPrint(final FieldIndex f) {
    String _xblockexpression = null;
    {
      if ((f instanceof FieldIndexName)) {
        final FieldIndexName x = ((FieldIndexName) f);
        this.prettyPrint(x);
      }
      String _xifexpression = null;
      if ((f instanceof FieldIndexNum)) {
        String _xblockexpression_1 = null;
        {
          final FieldIndexNum x_1 = ((FieldIndexNum) f);
          _xblockexpression_1 = this.prettyPrint(x_1);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String prettyPrint(final FieldIndexName f) {
    return InputOutput.<String>print("<fieldIndexName>");
  }
  
  public String prettyPrint(final FieldIndexNum f) {
    return InputOutput.<String>print("<fieldIndexNum>");
  }
  
  public String prettyPrint(final LineIndex f) {
    String _xblockexpression = null;
    {
      if ((f instanceof LineIndexCond)) {
        final LineIndexCond x = ((LineIndexCond) f);
        this.prettyPrint(x);
      }
      String _xifexpression = null;
      if ((f instanceof LineIndexNum)) {
        String _xblockexpression_1 = null;
        {
          final LineIndexNum x_1 = ((LineIndexNum) f);
          _xblockexpression_1 = this.prettyPrint(x_1);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String prettyPrint(final LineIndexCond f) {
    return InputOutput.<String>print("<LineIndexCond>");
  }
  
  public String prettyPrint(final LineIndexNum f) {
    return InputOutput.<String>print("<LineIndexNum>");
  }
  
  public String prettyPrint(final CellIndex f) {
    String _xblockexpression = null;
    {
      int _line = f.getLine();
      String _plus = ("(" + Integer.valueOf(_line));
      String _plus_1 = (_plus + ", ");
      InputOutput.<String>print(_plus_1);
      Field _colname = f.getColname();
      boolean _tripleEquals = (_colname == null);
      if (_tripleEquals) {
        InputOutput.<Integer>print(Integer.valueOf(f.getColnum()));
      } else {
        InputOutput.<String>print(f.getColname().getValue());
      }
      _xblockexpression = InputOutput.<String>print(")");
    }
    return _xblockexpression;
  }
}
