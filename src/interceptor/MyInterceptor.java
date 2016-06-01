package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


/**
 * Created by falling on 2016/5/5.
 */
public class MyInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("Before");

        try {
            return actionInvocation.invoke();
        } finally {
            System.out.println("after");
        }

    }
}
