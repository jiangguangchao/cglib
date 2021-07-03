package net.sf.cglib.jgcTest;

import net.sf.cglib.jgcTest.bean.Person;
import net.sf.cglib.jgcTest.callback.MyMethodIntercept;
import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void testMethodIntercept() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new MyMethodIntercept());
        enhancer.setSuperclass(Person.class);
        Person p = (Person) enhancer.create();
        p.work("编程");
    }

}
