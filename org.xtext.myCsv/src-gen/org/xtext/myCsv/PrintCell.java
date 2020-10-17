/**
 * generated by Xtext 2.23.0
 */
package org.xtext.myCsv;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Print Cell</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.myCsv.PrintCell#getCell <em>Cell</em>}</li>
 * </ul>
 *
 * @see org.xtext.myCsv.MyCsvPackage#getPrintCell()
 * @model
 * @generated
 */
public interface PrintCell extends Print
{
  /**
   * Returns the value of the '<em><b>Cell</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cell</em>' containment reference.
   * @see #setCell(CellIndex)
   * @see org.xtext.myCsv.MyCsvPackage#getPrintCell_Cell()
   * @model containment="true"
   * @generated
   */
  CellIndex getCell();

  /**
   * Sets the value of the '{@link org.xtext.myCsv.PrintCell#getCell <em>Cell</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cell</em>' containment reference.
   * @see #getCell()
   * @generated
   */
  void setCell(CellIndex value);

} // PrintCell