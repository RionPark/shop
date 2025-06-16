import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaExample {
    public static void main(String[] args) {
        // 1. 기본적인 람다식 예제
        List<String> fruits = Arrays.asList("사과", "바나나", "오렌지", "포도", "키위");
        
        // 전통적인 for-each 루프
        System.out.println("전통적인 for-each 루프:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        
        // 람다식을 사용한 forEach
        System.out.println("\n람다식을 사용한 forEach:");
        fruits.forEach(fruit -> System.out.println(fruit));
        
        // 2. Predicate를 사용한 필터링
        System.out.println("\n길이가 2글자인 과일만 필터링:");
        fruits.stream()
              .filter(fruit -> fruit.length() == 2)
              .forEach(System.out::println);
        
        // 3. Consumer 인터페이스 사용
        System.out.println("\nConsumer 인터페이스 사용:");
        Consumer<String> printWithPrefix = fruit -> System.out.println("과일: " + fruit);
        fruits.forEach(printWithPrefix);
        
        // 4. Predicate 인터페이스 사용
        System.out.println("\nPredicate 인터페이스 사용:");
        Predicate<String> isLongFruit = fruit -> fruit.length() > 2;
        fruits.stream()
              .filter(isLongFruit)
              .forEach(System.out::println);
    }
} 