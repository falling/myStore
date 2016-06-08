package filter;

import bean.Usertablebean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by falling on 2016/6/8.
 */
@WebFilter(filterName = "Filter",urlPatterns = "/buy.jsp")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("do filter");
        HttpServletRequest request = (HttpServletRequest)req;
        Usertablebean user = (Usertablebean) request.getSession().getAttribute("user");
        if (user == null && !request.getServletPath().equals("/login.jsp")) {
            req.setAttribute("msg","请先登陆");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
