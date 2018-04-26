package jstl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by dik81 on 27.03.18.
 */
public class DepartmentName extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print("DEPARTMENT:");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
