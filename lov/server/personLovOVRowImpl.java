package train.oracle.apps.ak.ak18726.lov.server;

import oracle.apps.fnd.framework.server.OAViewRowImpl;

import oracle.jbo.server.AttributeDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class personLovOVRowImpl extends OAViewRowImpl {


    public static final int PROCUREMENTPERSONNELCODE = 0;

    /**This is the default constructor (do not remove)
     */
    public personLovOVRowImpl() {
    }

    /**Gets the attribute value for the calculated attribute ProcurementPersonnelCode
     */
    public String getProcurementPersonnelCode() {
        return (String) getAttributeInternal(PROCUREMENTPERSONNELCODE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute ProcurementPersonnelCode
     */
    public void setProcurementPersonnelCode(String value) {
        setAttributeInternal(PROCUREMENTPERSONNELCODE, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case PROCUREMENTPERSONNELCODE:
            return getProcurementPersonnelCode();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case PROCUREMENTPERSONNELCODE:
            setProcurementPersonnelCode((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }
}