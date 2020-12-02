package viaXmlConfig.post_processors;

import org.springframework.beans.factory.BeanNameAware;

public class BeanWithInitDestroyMethods implements BeanNameAware {

    String msg;
    String name;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    void init() {
        System.out.println(String.format("Bean with name (%s) is going through init.", name));
    }

    void destroy() {
        System.out.println(String.format("Bean with name (%s) will destroy now.", name));
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }
}
