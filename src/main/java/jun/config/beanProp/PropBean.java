package jun.config.beanProp;

public class PropBean {

    public PropBean() {
        System.out.println("Prop Bean Initialized");
    }

    public void initProperty() {
        System.out.println("Init Property");
    }

    public void destroyProperty() {
        System.out.println("Destroy Property");
    }

    public void doSomething() {
        System.out.println("Do Something Property!");
    }

}
