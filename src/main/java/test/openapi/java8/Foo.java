package test.openapi.java8;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Slf4j
public class Foo {
    public static void main(String[] args) {
        RunSomeThing runSomeThing = (number) -> System.out.println("good" + number + 1);
        runSomeThing.doit(1);
        runSomeThing.doit(2);
        runSomeThing.doit(3);
        runSomeThing.doit(4);
        runSomeThing.doit(5);

        Plus plus = new Plus();

        plus.apply(1);

        Function<Integer, Integer> multiple = (integer) -> integer + 10;
        Function<Integer, Integer> composeInteger = (integer) -> integer * 2;
        Function<Integer, Integer> composeIntegerAndPlus10 = (integer) -> integer * 2;


        log.info("[FUNCTION] andthen :{}", plus.andThen(composeInteger).toString());
        log.info("[FUNCTION] compose :{}", plus.compose(multiple));

        Consumer<Integer> printT = (i) -> System.out.println(i);

        printT.accept(10);

        Supplier<Integer> get10 = () -> 10;

        System.out.println(get10);

        Predicate<String> startWithEojin = (s) -> s.startsWith("Eojin312");

        System.out.println(startWithEojin);


        UnaryOperator<Integer> plus10 = integer -> integer + 100;

        Supplier<Integer> getInteger = () -> 10;

        BinaryOperator<Integer> getIntegerBinary = (t, r) -> t + r;

        Foo foo = new Foo();

        foo.run();

        Function<Integer, String> intToString = (i) -> "number";

        UnaryOperator<String> hi = (s) -> "hi" + s;

        UnaryOperator<String> hiForGreeting = Greeting::hi;

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello; // static 이 아니라 인스턴스 메소드라서
        System.out.println("hello" + hello.apply("어진"));

        Supplier<Greeting> newGreeting = Greeting::new;
        newGreeting.get();

        // 생성자 참조
        Function<String, Greeting> eojinGreeting = Greeting::new;
        Greeting eojin = eojinGreeting.apply("eojin");

        System.out.println(eojin.getName());

        String[] names = {"eojin", "hj", "jh"};

        Arrays.sort(names, String::compareToIgnoreCase); // compareToIgnoreCase 임의의 객체를 참조

        System.out.println(names.toString());
    }

    private void run() {
        int baseNumber = 10;

        IntConsumer printInt = (i) -> System.out.println(i + baseNumber); // 변수 캡쳐 익명함수에서 사용하던 거
        printInt.accept(10);

    }

}
