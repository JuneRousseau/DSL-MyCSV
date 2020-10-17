/**
 * generated by Xtext 2.23.0
 */
package org.xtext.myCsv;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.myCsv.UnaryExpression#isOp <em>Op</em>}</li>
 *   <li>{@link org.xtext.myCsv.UnaryExpression#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see org.xtext.myCsv.MyCsvPackage#getUnaryExpression()
 * @model
 * @generated
 */
public interface UnaryExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(boolean)
   * @see org.xtext.myCsv.MyCsvPackage#getUnaryExpression_Op()
   * @model
   * @generated
   */
  boolean isOp();

  /**
   * Sets the value of the '{@link org.xtext.myCsv.UnaryExpression#isOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #isOp()
   * @generated
   */
  void setOp(boolean value);

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(ExpressionCalculPrimary)
   * @see org.xtext.myCsv.MyCsvPackage#getUnaryExpression_Expr()
   * @model containment="true"
   * @generated
   */
  ExpressionCalculPrimary getExpr();

  /**
   * Sets the value of the '{@link org.xtext.myCsv.UnaryExpression#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(ExpressionCalculPrimary value);

} // UnaryExpression