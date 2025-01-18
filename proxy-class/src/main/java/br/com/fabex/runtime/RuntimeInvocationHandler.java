package br.com.fabex.runtime;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RuntimeInvocationHandler implements InvocationHandler {
    private final Object target;

    public RuntimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long init = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        System.out.println("Method: " + method.getName() + ", took " + (System.currentTimeMillis() - init) + "ms");
        return result;
    }
}
