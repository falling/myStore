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

    public void returnResultWithJson(Class c, String sql) throws IOException {
        List good = new DAOImpl().getAll(c, sql);
        returnResultWithJson(good);
    }

    public void returnResultWithJson(Object object) throws IOException {
        Gson gson = new Gson();
        write(gson.toJson(object));
    }

    private void write(String result) throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(result);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
