/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package train.oracle.apps.ak.ak18726.webui;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

import com.sun.java.util.collections.ArrayList;

import com.sun.java.util.collections.HashMap;

import java.io.Serializable;

import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;

import oracle.apps.fnd.framework.webui.beans.form.OASubmitButtonBean;

import oracle.jbo.domain.Number;

/**
 * Controller for ...
 */
public class test2CO extends OAControllerImpl
{
  public static final String RCS_ID="$Header$";
  public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");

    public static final String URL = 
        "OA.jsp?page=/train/oracle/apps/ak/ak18726/webui/test2PG";
    
    public static final String PRE_BUTTON = "preButton";
    public static final String NEXT_BUTTON = "nextButton";
    public static final String RETURN_BUTTON = "returnButton";
    
    public static final String FROM_PAGE = "fromPage";
    //  public static final String FROM_270A = "270A";
    public static final String FROM_280A = "280A";
    public static final String FROM_QUERY_TYPE = "fromQueryType";
    public static final String DETAIL_MAP = "detailMap";
    
    private String fromPage = "";
    private String fromQueryType;
    private HashMap parameters;
    
    private int recordNum = 0;
    private ArrayList paraS;
    private ArrayList paraB;
    private ArrayList paraV = null;
    private Number SumAmount;
    private Number BeginningCarryingoverId;
    private Number VoCountNum;

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
      OAApplicationModule am = pageContext.getApplicationModule(webBean);
        super.processRequest(pageContext, webBean);
      
        String sFromPage = pageContext.getParameter(FROM_PAGE);
        System.out.println("sFromPage"+sFromPage);
        if (sFromPage != null && !"".equals(sFromPage)) {
            fromPage = sFromPage;
        }
        String sFromQueryType = pageContext.getParameter(FROM_QUERY_TYPE);
        System.out.println("sFromQueryType"+sFromQueryType);
        if (sFromQueryType != null && !"".equals(sFromQueryType)) {
            fromQueryType = sFromQueryType;
        }
        if (parameters == null) {
            parameters = (HashMap)pageContext.getTransientSessionValue(DETAIL_MAP);
            //pageContext.removeTransientSessionValue(DETAIL_MAP);
            Class[] paramsTypes = { parameters.getClass() };
            Serializable[] saveParams = { parameters };
            am.invokeMethod("setParameters", saveParams, paramsTypes);
            parameters = (HashMap)am.invokeMethod("getParameters");
        }
        recordNum = (Integer)am.invokeMethod("getRecordNum");
        paraS = (ArrayList)parameters.get("sumAmount");
        //int size = paraS.size();
        //parameters = (HashMap)am.invokeMethod("getParameters");
        paraB = (ArrayList)parameters.get("beginningCarryingoverId");
        paraV = (ArrayList)parameters.get("countNum");
        SumAmount = (Number)paraS.get(recordNum);
        BeginningCarryingoverId = (Number)paraB.get(recordNum);
        VoCountNum = (Number)paraV.get(recordNum);
        Serializable[] paramC = { SumAmount, BeginningCarryingoverId, VoCountNum };
        Class[] paramType = { Number.class, Number.class, Number.class };
        am.invokeMethod("initQuery", paramC, paramType);
        // 「????ボタン
        OASubmitButtonBean preBtn = (OASubmitButtonBean)webBean.findChildRecursive(PRE_BUTTON);
        // 「次??ボタン
        OASubmitButtonBean nextBtn = (OASubmitButtonBean)webBean.findChildRecursive(NEXT_BUTTON);
        Boolean isFirst = (Boolean)am.invokeMethod("isFirstRow");
        Boolean isLast = (Boolean)am.invokeMethod("isLastRow");
        if (preBtn != null) {
            preBtn.setDisabled(isFirst);
        }

        if (nextBtn != null) {
            nextBtn.setDisabled(isLast);
        }
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
      if(pageContext.getParameter("return")!=null) {
          System.out.println("createBtn click");
          pageContext.forwardImmediately("OA.jsp?page=/train/oracle/apps/ak/ak18726/webui/test1PG",
                                        null,
                                        OAWebBeanConstants.KEEP_MENU_CONTEXT,
                                        null,
                                        null,
                                        true, // retain AM
                                        OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
            
      }
      OAApplicationModule am = pageContext.getApplicationModule(webBean);
           
            OASubmitButtonBean preBtn = (OASubmitButtonBean)webBean.findChildRecursive(PRE_BUTTON);
            OASubmitButtonBean nextBtn = (OASubmitButtonBean)webBean.findChildRecursive(NEXT_BUTTON);
            int size = paraS.size();
            if (pageContext.getParameter(PRE_BUTTON) != null) {
                recordNum = (Integer)am.invokeMethod("getRecordNum");
                --recordNum;
                Class[] paramsTypes = { int.class };
                Serializable[] saveParams = { new Integer(recordNum) };
                am.invokeMethod("setRecordNum", saveParams, paramsTypes);
                SumAmount = (Number)paraS.get(recordNum);
                BeginningCarryingoverId = (Number)paraB.get(recordNum);
                VoCountNum = (Number)paraV.get(recordNum);
                Serializable[] paramC = { SumAmount, BeginningCarryingoverId, VoCountNum };
                Class[] paramType = { Number.class, Number.class, Number.class };
                am.invokeMethod("initQuery", paramC, paramType);
                if (recordNum == 0) {
                    preBtn.setDisabled(true);
                }
                nextBtn.setDisabled(false);
            } else if (pageContext.getParameter(NEXT_BUTTON) != null) {
                recordNum = (Integer)am.invokeMethod("getRecordNum");
                ++recordNum;
                Class[] paramsTypes = { int.class };
                Serializable[] saveParams = { new Integer(recordNum) };
                am.invokeMethod("setRecordNum", saveParams, paramsTypes);
                SumAmount = (Number)paraS.get(recordNum);  
                BeginningCarryingoverId = (Number)paraB.get(recordNum); 
                VoCountNum = (Number)paraV.get(recordNum); // 点数       
                Serializable[] paramC = { SumAmount, BeginningCarryingoverId, VoCountNum };
                Class[] paramType = { Number.class, Number.class, Number.class };
                am.invokeMethod("initQuery", paramC, paramType);
                if (recordNum == size - 1) {
                    nextBtn.setDisabled(true);
                }
                preBtn.setDisabled(false);
            }
  }

}
