package test.openapi.java8;

public class Greeting {

    private String name;

    public Greeting(String name) {
        this.name = name;
    }

    public Greeting() {
    }

    // 인스턴스 메소드
    public String hello(String name) {
        return "Hello" + name;
    }

    public static String hi(String name) {
        return "hi" + name;
    }

    public String getName() {
        return name;
    }
}
