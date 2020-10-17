/**
 * generated by Xtext 2.23.0
 */
package org.xtext.myCsv.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.myCsv.MultiplicativeExpression;
import org.xtext.myCsv.MultiplicativeExpressionRhs;
import org.xtext.myCsv.MyCsvPackage;
import org.xtext.myCsv.UnaryExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicative Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.myCsv.impl.MultiplicativeExpressionImpl#getLhs <em>Lhs</em>}</li>
 *   <li>{@link org.xtext.myCsv.impl.MultiplicativeExpressionImpl#getRhs <em>Rhs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultiplicativeExpressionImpl extends MinimalEObjectImpl.Container implements MultiplicativeExpression
{
  /**
   * The cached value of the '{@link #getLhs() <em>Lhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLhs()
   * @generated
   * @ordered
   */
  protected UnaryExpression lhs;

  /**
   * The cached value of the '{@link #getRhs() <em>Rhs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRhs()
   * @generated
   * @ordered
   */
  protected EList<MultiplicativeExpressionRhs> rhs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MultiplicativeExpressionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MyCsvPackage.Literals.MULTIPLICATIVE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnaryExpression getLhs()
  {
    return lhs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLhs(UnaryExpression newLhs, NotificationChain msgs)
  {
    UnaryExpression oldLhs = lhs;
    lhs = newLhs;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyCsvPackage.MULTIPLICATIVE_EXPRESSION__LHS, oldLhs, newLhs);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLhs(UnaryExpression newLhs)
  {
    if (newLhs != lhs)
    {
      NotificationChain msgs = null;
      if (lhs != null)
        msgs = ((InternalEObject)lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyCsvPackage.MULTIPLICATIVE_EXPRESSION__LHS, null, msgs);
      if (newLhs != null)
        msgs = ((InternalEObject)newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyCsvPackage.MULTIPLICATIVE_EXPRESSION__LHS, null, msgs);
      msgs = basicSetLhs(newLhs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyCsvPackage.MULTIPLICATIVE_EXPRESSION__LHS, newLhs, newLhs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<MultiplicativeExpressionRhs> getRhs()
  {
    if (rhs == null)
    {
      rhs = new EObjectContainmentEList<MultiplicativeExpressionRhs>(MultiplicativeExpressionRhs.class, this, MyCsvPackage.MULTIPLICATIVE_EXPRESSION__RHS);
    }
    return rhs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MyCsvPackage.MULTIPLICATIVE_EXPRESSION__LHS:
        return basicSetLhs(null, msgs);
      case MyCsvPackage.MULTIPLICATIVE_EXPRESSION__RHS:
        return ((InternalEList<?>)getRhs()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MyCsvPackage.MULTIPLICATIVE_EXPRESSION__LHS:
        return getLhs();
      case MyCsvPackage.MULTIPLICATIVE_EXPRESSION__RHS:
        return getRhs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MyCsvPackage.MULTIPLICATIVE_EXPRESSION__LHS:
        setLhs((UnaryExpression)newValue);
        return;
      case MyCsvPackage.MULTIPLICATIVE_EXPRESSION__RHS:
        getRhs().clear();
        getRhs().addAll((Collection<? extends MultiplicativeExpressionRhs>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MyCsvPackage.MULTIPLICATIVE_EXPRESSION__LHS:
        setLhs((UnaryExpression)null);
        return;
      case MyCsvPackage.MULTIPLICATIVE_EXPRESSION__RHS:
        getRhs().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MyCsvPackage.MULTIPLICATIVE_EXPRESSION__LHS:
        return lhs != null;
      case MyCsvPackage.MULTIPLICATIVE_EXPRESSION__RHS:
        return rhs != null && !rhs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MultiplicativeExpressionImpl