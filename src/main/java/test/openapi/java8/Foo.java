package test.openapi.java8;

public class Foo {
    public static void main(String[] args) {
        RunSomeThing runSomeThing = new RunSomeThing() {
            @Override
            public void doit() {
                System.out.println("good");
            }
        };
    }
}
