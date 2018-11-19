/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package train.oracle.apps.ak.ak18726.webui;

import com.sun.java.util.collections.HashMap;

import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.TransactionUnitHelper;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageChoiceBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageLovInputBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;

import oracle.jbo.RowSetIterator;

import train.oracle.apps.ak.ak18726.server.test1AMImpl;
import train.oracle.apps.ak.ak18726.server.test1VORowImpl;

/**
 * Controller for ...
 */
public class test1CO extends OAControllerImpl
{
  public static final String RCS_ID="$Header$";
  public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
      super.processRequest(pageContext, webBean);
      OAApplicationModule am = pageContext.getApplicationModule(webBean);
      am.invokeMethod("initsearch");
  }

  /**
   * Procedure to handle form submissions for form elements in
   * a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processFormRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processFormRequest(pageContext, webBean);
    String event=pageContext.getParameter(EVENT_PARAM);
    OAApplicationModule am=pageContext.getApplicationModule(webBean);
      test1AMImpl a=new test1AMImpl();
      
      //点击关闭按钮
       if(pageContext.getParameter("closeButton")!=null) {
           //System.exit(0); 
           
           System.out.println("close button");
          
       }
    //点击检索按钮
     if(pageContext.getParameter("QueryButton")!=null) {
         System.out.println("co2go1");
         String status1 = (String)pageContext.getParameter("status1");
         String suppliercodeQ=(String)pageContext.getParameter("suppliercodeQ");
         String SupplierNameQ=(String)pageContext.getParameter("SupplierNameQ");
         String groupType=(String)pageContext.getParameter("groupType");
         String Substitute=(String)pageContext.getParameter("Substitute");
         String procurementPersonCode=(String)pageContext.getParameter("procurementPersonCode");
         HashMap parameters=new HashMap();
         parameters.put("status1",status1);
         parameters.put("suppliercodeQ",suppliercodeQ);
         parameters.put("SupplierNameQ",SupplierNameQ);
         parameters.put("groupType",groupType);
         parameters.put("Substitute",Substitute);
         parameters.put("procurementPersonCode",procurementPersonCode);
         Serializable[] methodParams={parameters};
         Class[] parameterType={parameters.getClass()};
         System.out.println("status="+status1);
         System.out.println("co2go2");
         am.invokeMethod("search",methodParams,parameterType);
     }
    
    //点击“清空”按钮的操作
     if(pageContext.getParameter("ClearButton")!=null) {
           System.out.println("Clear1");
          //OAMessageTextInputBean na =new OAMessageTextInputBean("userid");
           OAMessageChoiceBean  na=(OAMessageChoiceBean )webBean.findChildRecursive("status1");
           na.setValue(pageContext,"");
           OAMessageLovInputBean  nb=(OAMessageLovInputBean )webBean.findChildRecursive("suppliercodeQ");
           nb.setValue(pageContext,"");
           OAMessageTextInputBean nc=(OAMessageTextInputBean)webBean.findChildRecursive("SupplierNameQ");
           nc.setValue(pageContext,"");
           OAMessageLovInputBean  nd=(OAMessageLovInputBean )webBean.findChildRecursive("groupType");
           nd.setValue(pageContext,"");
           OAMessageLovInputBean  ne=(OAMessageLovInputBean )webBean.findChildRecursive("Substitute");
           ne.setValue(pageContext,"");
           OAMessageLovInputBean  nf=(OAMessageLovInputBean )webBean.findChildRecursive("procurementPersonCode");
           nf.setValue(pageContext,"");
           
           System.out.println("clear done");          
     }
     //全选
      if("selectAll".equals(event)) {
          System.out.println("select all");
          am.invokeMethod("selectAll");
          
      }
      //取消选择
       if("selectNone".equals(event)) {
           System.out.println("select none");
           
          am.invokeMethod("selectNone");
       }
     //详情跳转
     if (pageContext.getParameter("DetailButton") != null) {
         
               //am.invokeMethod("detailPreCheck");
                int count=-1;
//               int countColumn=0;//用判断是否选择了行信息
//               test1AMImpl am1=new test1AMImpl();
//               OAViewObject vo = am1.gettest1VO1();
//               test1VORowImpl row = null;
//               int fetchedRowCount = vo.getFetchedRowCount();
//               RowSetIterator checkIter = vo.createRowSetIterator("checkIter");
//               checkIter.setRangeStart(0);
//               checkIter.setRangeSize(fetchedRowCount);
//               for (int i = 0; i < fetchedRowCount; i++) {
//                   row = (test1VORowImpl)checkIter.getRowAtRangeIndex(i);
//                   if ("Y".equals(row.getSelection())) {
//                       countColumn+=1;
//                   }
//               }
//               System.out.println("countColumn="+countColumn);
               
               HashMap parameters = (HashMap)am.invokeMethod("callPricemaintenance");
    
               pageContext.putTransientSessionValue(test2CO.DETAIL_MAP, parameters);
               pageContext.putTransientSessionValue(test2CO.FROM_PAGE
                                                  , test2CO.FROM_280A);
    
               String url = test2CO.URL 
                           + "&" + test2CO.FROM_PAGE + "=" + test2CO.FROM_280A  
                           + "&" + test2CO.FROM_QUERY_TYPE + "=" + "INIT"; 
     //                      
               System.out.println("url="+url);
               count=a.getCountColumn();
               System.out.println("count="+count);
               if(count>0) {
                   pageContext.forwardImmediately(url, null, OAWebBeanConstants.KEEP_MENU_CONTEXT, null, null, true, 
                                                  OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
               }else {
                   JOptionPane.showMessageDialog(new JFrame().getContentPane(),
                   "未选择信息", "提示", JOptionPane.QUESTION_MESSAGE); 
               }
               
           }
  }

}
