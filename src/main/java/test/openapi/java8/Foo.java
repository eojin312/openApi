package test.openapi.java8;

public class Foo {
    public static void main(String[] args) {
        RunSomeThing runSomeThing = (number) -> System.out.println("good" + number + 1);
        runSomeThing.doit(1);
        runSomeThing.doit(2);
        runSomeThing.doit(3);
        runSomeThing.doit(4);
        runSomeThing.doit(5);
    }
}
