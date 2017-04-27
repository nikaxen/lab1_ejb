
package Singleton;

import java.io.PrintWriter;
import java.io.Serializable;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@Singleton
@LocalBean
public class Single implements Serializable{
    private int count;

    public Single() {
        count = 0;
    }

    public void CountInc(){
        count++;
    }
    
    @AroundInvoke
    public Object numberOfCalls(InvocationContext ctx) throws Exception {
        //count++;
        CountInc();
        System.out.println("Вызвано " + getCount() + " раз");
        return ctx.proceed();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
