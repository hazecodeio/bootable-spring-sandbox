package viaJavaConfig.post_processors;

import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanWithInitDestroyMethods implements BeanNameAware {

    String msg;
    String name;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @PostConstruct
    void init(){
        System.out.println(String.format("Bean with name (%s) is going through init.", name));
        System.out.println(msg);
    }

    @PreDestroy
    void destroy(){
        System.out.println(String.format("Bean with name (%s) will destroy now.", name));
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }
}
