package interceptor;

import bean.Usertablebean;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by falling on 2016/5/5.
 */
public class LoginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        HttpServletRequest req = (HttpServletRequest) actionInvocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
        HttpServletResponse resp = (HttpServletResponse) actionInvocation.getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);
        Usertablebean user = (Usertablebean) req.getSession().getAttribute("user");
        if (user == null && !req.getServletPath().equals("/login.jsp")) {
            req.setAttribute("msg","请先登陆");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
        return actionInvocation.invoke();
    }
}
