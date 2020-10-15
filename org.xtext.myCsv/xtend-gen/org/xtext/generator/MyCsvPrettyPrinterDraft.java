package org.xtext.generator;

import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
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
  protected Object _prettyPrint(final Program p) {
    EList<Statement> _stmts = p.getStmts();
    for (final Statement stmt : _stmts) {
      this.prettyPrint(stmt);
    }
    return null;
  }
  
  protected Object _prettyPrint(final Load l) {
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
    return null;
  }
  
  protected Object _prettyPrint(final Store l) {
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
    return null;
  }
  
  protected Object _prettyPrint(final ExportJson l) {
    String _value = l.getPath().getValue();
    String _plus = ("ExportJson \"" + _value);
    String _plus_1 = (_plus + "\"");
    return InputOutput.<String>println(_plus_1);
  }
  
  protected Object _prettyPrint(final Projection l) {
    InputOutput.<String>print("Projection ");
    this.prettyPrint(l.getField());
    InputOutput.println();
    return null;
  }
  
  protected Object _prettyPrint(final Select l) {
    InputOutput.<String>print("Select ");
    this.prettyPrint(l.getLine());
    InputOutput.println();
    return null;
  }
  
  protected Object _prettyPrint(final Delete l) {
    InputOutput.<String>print("Delete ");
    this.prettyPrint(l);
    InputOutput.println();
    return null;
  }
  
  protected Object _prettyPrint(final DeleteField l) {
    Object _xblockexpression = null;
    {
      InputOutput.<String>print("field ");
      _xblockexpression = this.prettyPrint(l.getFields());
    }
    return _xblockexpression;
  }
  
  protected Object _prettyPrint(final DeleteLine l) {
    Object _xblockexpression = null;
    {
      InputOutput.<String>print("line ");
      _xblockexpression = this.prettyPrint(l.getLines());
    }
    return _xblockexpression;
  }
  
  protected Object _prettyPrint(final Modify l) {
    Object _xblockexpression = null;
    {
      InputOutput.<String>print("Modify ");
      _xblockexpression = this.prettyPrint(l);
    }
    return _xblockexpression;
  }
  
  protected Object _prettyPrint(final ModifyField l) {
    Object _xblockexpression = null;
    {
      InputOutput.<String>print("field ");
      this.prettyPrint(l.getFields());
      InputOutput.<String>print(" with ");
      _xblockexpression = this.prettyPrint(l.getValues());
    }
    return _xblockexpression;
  }
  
  protected Object _prettyPrint(final ModifyLine l) {
    Object _xblockexpression = null;
    {
      InputOutput.<String>print("line ");
      this.prettyPrint(l.getLines());
      InputOutput.<String>print(" with ");
      _xblockexpression = this.prettyPrint(l.getValues());
    }
    return _xblockexpression;
  }
  
  protected Object _prettyPrint(final ModifyCell l) {
    Object _xblockexpression = null;
    {
      InputOutput.<String>print("cell ");
      this.prettyPrint(l.getCell());
      InputOutput.<String>print(" with ");
      _xblockexpression = this.prettyPrint(l.getValue());
    }
    return _xblockexpression;
  }
  
  protected Object _prettyPrint(final Insert l) {
    Object _xblockexpression = null;
    {
      InputOutput.<String>print("Insert ");
      _xblockexpression = this.prettyPrint(l);
    }
    return _xblockexpression;
  }
  
  protected Object _prettyPrint(final InsertField l) {
    Object _xblockexpression = null;
    {
      String _value = l.getFieldname().getValue();
      String _plus = ("field " + _value);
      String _plus_1 = (_plus + ": ");
      InputOutput.<String>print(_plus_1);
      _xblockexpression = this.prettyPrint(l.getValues());
    }
    return _xblockexpression;
  }
  
  protected Object _prettyPrint(final InsertLine l) {
    Object _xblockexpression = null;
    {
      InputOutput.<String>print("line ");
      _xblockexpression = this.prettyPrint(l.getValues());
    }
    return _xblockexpression;
  }
  
  protected Object _prettyPrint(final Print l) {
    Object _xblockexpression = null;
    {
      InputOutput.<String>print("Print ");
      _xblockexpression = this.prettyPrint(l);
    }
    return _xblockexpression;
  }
  
  protected Object _prettyPrint(final PrintField l) {
    Object _xblockexpression = null;
    {
      InputOutput.<String>print("field ");
      _xblockexpression = this.prettyPrint(l.getFields());
    }
    return _xblockexpression;
  }
  
  protected Object _prettyPrint(final PrintLine l) {
    Object _xblockexpression = null;
    {
      InputOutput.<String>print("line ");
      _xblockexpression = this.prettyPrint(l.getLines());
    }
    return _xblockexpression;
  }
  
  protected Object _prettyPrint(final PrintCell l) {
    Object _xblockexpression = null;
    {
      InputOutput.<String>print("cell ");
      _xblockexpression = this.prettyPrint(l.getCell());
    }
    return _xblockexpression;
  }
  
  protected Object _prettyPrint(final PrintTable l) {
    return InputOutput.<String>print("table");
  }
  
  protected Object _prettyPrint(final PrintExpr l) {
    Object _xblockexpression = null;
    {
      InputOutput.<String>print("expr ");
      _xblockexpression = this.prettyPrint(l.getExp());
    }
    return _xblockexpression;
  }
  
  protected Object _prettyPrint(final Values v) {
    return InputOutput.<String>print("<Values>");
  }
  
  protected Object _prettyPrint(final Value v) {
    return InputOutput.<String>print("<Value>");
  }
  
  protected Object _prettyPrint(final Statement stmt) {
    this.prettyPrint(stmt);
    InputOutput.println();
    return null;
  }
  
  protected Object _prettyPrint(final FieldIndex f) {
    return this.prettyPrint(f);
  }
  
  protected Object _prettyPrint(final FieldIndexName f) {
    return InputOutput.<String>print("<fieldIndexName>");
  }
  
  protected Object _prettyPrint(final FieldIndexNum f) {
    return InputOutput.<String>print("<fieldIndexNum>");
  }
  
  protected Object _prettyPrint(final LineIndex f) {
    return this.prettyPrint(f);
  }
  
  protected Object _prettyPrint(final LineIndexCond f) {
    return InputOutput.<String>print("<LineIndexCond>");
  }
  
  protected Object _prettyPrint(final LineIndexNum f) {
    return InputOutput.<String>print("<LineIndexNum>");
  }
  
  protected Object _prettyPrint(final CellIndex f) {
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
  
  public Object prettyPrint(final EObject l) {
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
    } else if (l instanceof Delete) {
      return _prettyPrint((Delete)l);
    } else if (l instanceof ExportJson) {
      return _prettyPrint((ExportJson)l);
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
    } else if (l instanceof Load) {
      return _prettyPrint((Load)l);
    } else if (l instanceof Modify) {
      return _prettyPrint((Modify)l);
    } else if (l instanceof Print) {
      return _prettyPrint((Print)l);
    } else if (l instanceof Projection) {
      return _prettyPrint((Projection)l);
    } else if (l instanceof Select) {
      return _prettyPrint((Select)l);
    } else if (l instanceof Store) {
      return _prettyPrint((Store)l);
    } else if (l instanceof CellIndex) {
      return _prettyPrint((CellIndex)l);
    } else if (l instanceof FieldIndex) {
      return _prettyPrint((FieldIndex)l);
    } else if (l instanceof LineIndex) {
      return _prettyPrint((LineIndex)l);
    } else if (l instanceof Program) {
      return _prettyPrint((Program)l);
    } else if (l instanceof Statement) {
      return _prettyPrint((Statement)l);
    } else if (l instanceof Value) {
      return _prettyPrint((Value)l);
    } else if (l instanceof Values) {
      return _prettyPrint((Values)l);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(l).toString());
    }
  }
}
