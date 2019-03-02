package pl.mpas.advanced_programming;

@FunctionalInterface
interface SayHello {
    void sayHello();
    default void goodbye() {
        System.out.println("Goodbye!!!");
    }
}

@FunctionalInterface
interface Test {
    // int a, String name
    void test1(int a, String name);

    // 2x default methods
    default void test2() {
        System.out.println("Something1");
    };

    default void test3() {
        System.out.println("Something2");
    };
}


public class HelloLambda {

    static void useTest(Test test, int a, String s) {
        test.test1(a, s);
    }

    public static void main(String[] args) {
        SayHello hello = () -> {
            System.out.println("Hello Lambda!");
        };
        hello.sayHello();

        // first test method: write "aa -- ss"
        useTest((a, b) -> System.out.println("" + a + a + " -- " + b + b)
                ,5, "Mariusz");
        // first test method: write "aaa --- sss"
        useTest((int a, String c) -> System.out.println("" + a + a + a + " --- " + c + c + c)
                ,10, ".");

        // klasa anonimowa
        useTest(new Test() {
                    @Override
                    public void test1(int a, String name) {
                        //implementacja
                    }
                }
                , 5, "aaa");




    }

}
