package jun.config;

public class SubBean {

    public SubBean() {
        System.out.println("Sub Bean Initialized");
    }

    public void doSomething() {
        System.out.println("Sub Do Something!");
    }

    public void doAutoWired() {
        System.out.println("Sub do Autowired!");
    }

}
