package br.com.fabex.runtime;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AppRuntime {

    public static void main(String[] args) throws Exception{
        if (args.length == 0) {
            System.err.println("You must provide the name of a class, the name of its method and input for the method");
            return;
        }
        String className = args[0];
        String handlerClass = args[1];

        Constructor<?> ctr;

        Class<?> myClass = Class.forName(className);
        ctr = myClass.getConstructor();
        Object object = ctr.newInstance();

        Class<?> myHandlerClass = Class.forName(handlerClass);
        ctr = myHandlerClass.getConstructor(Object.class);
        Object objectHandler = ctr.newInstance(object);

        Object proxyInstance = Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                myClass.getInterfaces(),
                (InvocationHandler) objectHandler
        );

        String methodName = args[2];

        Class<?> clazz = proxyInstance.getClass().getInterfaces()[0];
        Method method = clazz.getMethod(methodName);
        System.out.println(method.invoke(proxyInstance));
    }
}
