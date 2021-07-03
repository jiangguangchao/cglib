package net.sf.cglib.jgcTest.callback;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodIntercept implements MethodInterceptor {
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("方法[" + method.getName() + "]调用前参数记录，args：" + args);
        Object result = null;
        if (args != null && args.length > 0 && args[0].toString().equals("敏感词")) {
            //不执行methodProxy.invokeSuper(o,objects);就相当于没有执行目标方法
        } else {
            result = proxy.invokeSuper(obj,args);
        }
        System.out.println("方法[" + method.getName() + "]调用后结果记录，result：" + result);
        return result;
    }
}
