package json;

import bean.Goodstablebean;
import com.google.gson.Gson;
import dao.DAOImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by falling on 2016/6/9.
 */
public class JsonRequest {
    public void returnAllWithJson(Class c, String sql) throws IOException {
        HttpServletResponse response= ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        List good = new DAOImpl().getAll(c,sql);
        response.getWriter().println(gson.toJson(good));
        response.getWriter().flush();
        response.getWriter().close();
    }
}
