package train.oracle.apps.ak.ak18726.lov.server;

import oracle.apps.fnd.framework.server.OAViewRowImpl;

import oracle.jbo.server.AttributeDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class groupLovVORowImpl extends OAViewRowImpl {


    public static final int PROCUREMENTGROUPCODE = 0;

    /**This is the default constructor (do not remove)
     */
    public groupLovVORowImpl() {
    }

    /**Gets the attribute value for the calculated attribute ProcurementGroupCode
     */
    public String getProcurementGroupCode() {
        return (String) getAttributeInternal(PROCUREMENTGROUPCODE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute ProcurementGroupCode
     */
    public void setProcurementGroupCode(String value) {
        setAttributeInternal(PROCUREMENTGROUPCODE, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case PROCUREMENTGROUPCODE:
            return getProcurementGroupCode();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case PROCUREMENTGROUPCODE:
            setProcurementGroupCode((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }
}
