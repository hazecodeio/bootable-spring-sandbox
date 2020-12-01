package viaXmlConfig.post_processors;

public class BeanWithInitDestroyMethods {

    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    void init(){
        System.out.println("Bean is going through init.");
    }

    void destroy(){
        System.out.println("Bean will destroy now.");
    }
}
