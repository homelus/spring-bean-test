package jun.config;

public class JunBean {

    public JunBean() {
        System.out.println("Jun Bean Initialized");
    }

    private int count = 10;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void doSomething() {
        System.out.println("Jun Do Something!");
    }

}
