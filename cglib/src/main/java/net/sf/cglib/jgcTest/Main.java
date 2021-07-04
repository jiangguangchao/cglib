package net.sf.cglib.jgcTest;

import net.sf.cglib.core.KeyFactory;
import net.sf.cglib.core.ReflectUtils;
import net.sf.cglib.jgcTest.bean.Person;
import net.sf.cglib.jgcTest.callback.MyMethodIntercept;
import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Enhancer.EnhancerKey JGC_KEY_FACTORY =
            (Enhancer.EnhancerKey) KeyFactory.create(Enhancer.EnhancerKey.class);

    @Test
    public void testMethodIntercept() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new MyMethodIntercept());
        enhancer.setSuperclass(Person.class);
        Person p1 = (Person) enhancer.create();
        System.gc();
        Person p2 = (Person) enhancer.create();
        Person p3 = (Person) enhancer.create();
        p1.work("编程");
        System.out.println(p1.getClass().getName());
        System.out.println(p2.getClass().getName());
        System.out.println(p3.getClass().getName());


//        Object key1 = JGC_KEY_FACTORY.newInstance((enhancer.superclass != null) ? enhancer.superclass.getName() : null,
//                ReflectUtils.getNames(enhancer.interfaces),
//                enhancer.filter,
//                enhancer.callbackTypes,
//                enhancer.useFactory,
//                enhancer.interceptDuringConstruction,
//                enhancer.serialVersionUID);
//
//        Object key2 = JGC_KEY_FACTORY.newInstance((enhancer.superclass != null) ? enhancer.superclass.getName() : null,
//                ReflectUtils.getNames(enhancer.interfaces),
//                enhancer.filter,
//                enhancer.callbackTypes,
//                enhancer.useFactory,
//                enhancer.interceptDuringConstruction,
//                enhancer.serialVersionUID);
//
//        System.out.println("key1Name:" + key1.getClass().getName());
//        System.out.println("key2Name:" + key2.getClass().getName());
//
//        System.out.println("key1 equeal key2 :" + key1.equals(key2));
//        System.out.println("key1 == key2 :" + key1 == key2);
    }

    @Test
    public void f(){
        ThreadLocal t = new ThreadLocal();
        Object c = t.get();
        if (c == null) {
            System.out.println("c is null");
        } else {
            System.out.println(c.getClass().getName());
        }
        t.set(this);
        c = t.get();

        if (c == null) {
            System.out.println("c is null too");
        } else {
            System.out.println("c should this... :" + c.getClass().getName());
        }

    }

}
