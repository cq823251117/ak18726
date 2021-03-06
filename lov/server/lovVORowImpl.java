package train.oracle.apps.ak.ak18726.lov.server;

import oracle.apps.fnd.framework.server.OAViewRowImpl;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class lovVORowImpl extends OAViewRowImpl {


    public static final int SUPPLIERID = 0;
    public static final int SUPPLIERCODE = 1;
    public static final int KANJISUPPLIERNAME = 2;

    /**This is the default constructor (do not remove)
     */
    public lovVORowImpl() {
    }

    /**Gets the attribute value for the calculated attribute SupplierId
     */
    public Number getSupplierId() {
        return (Number) getAttributeInternal(SUPPLIERID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute SupplierId
     */
    public void setSupplierId(Number value) {
        setAttributeInternal(SUPPLIERID, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case SUPPLIERID:
            return getSupplierId();
        case SUPPLIERCODE:
            return getSupplierCode();
        case KANJISUPPLIERNAME:
            return getKanjiSupplierName();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case SUPPLIERID:
            setSupplierId((Number)value);
            return;
        case SUPPLIERCODE:
            setSupplierCode((String)value);
            return;
        case KANJISUPPLIERNAME:
            setKanjiSupplierName((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the attribute value for the calculated attribute KanjiSupplierName
     */
    public String getKanjiSupplierName() {
        return (String) getAttributeInternal(KANJISUPPLIERNAME);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute KanjiSupplierName
     */
    public void setKanjiSupplierName(String value) {
        setAttributeInternal(KANJISUPPLIERNAME, value);
    }

    /**Gets the attribute value for the calculated attribute SupplierCode
     */
    public String getSupplierCode() {
        return (String) getAttributeInternal(SUPPLIERCODE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute SupplierCode
     */
    public void setSupplierCode(String value) {
        setAttributeInternal(SUPPLIERCODE, value);
    }
}
