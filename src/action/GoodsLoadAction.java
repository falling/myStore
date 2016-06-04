package action;

import bean.Goodstablebean;
import com.google.gson.Gson;
import dao.DAOImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by falling on 2016/6/4.
 */
public class GoodsLoadAction {
    public void execute() throws Exception {
        HttpServletResponse response=ServletActionContext.getResponse();
        Gson gson = new Gson();
        List good = new DAOImpl().getAll(Goodstablebean.class," where state = 0 and number > 0 ");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(gson.toJson(good));
        response.getWriter().flush();
        response.getWriter().close();
    }
}