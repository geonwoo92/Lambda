package proxy;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathProxy {
    public static Function<Integer, Integer> absInt = Math::abs;

    public static BiFunction<Integer, Integer, Integer> maxInt = Math::max;
    public static BiFunction<Integer, Integer,Integer> minInt = Math::min;
    public static Supplier<Double> randomDouble = Math::random;

    //올림 Math.ceil()
    public static Function<Double,Double> ceilDouble = Math::ceil;

    //내림 Math.floor()
    public static Function<Double,Double> floor = Math::floor;
    //반올림 Math.round()


    //Math.sqrt( a )    //입력값 a의 제곱근을 반환하는 메서드입니다.

    public static Function<Double,Double> sqrtDouble = Math::sqrt;
    //Math.pow( a , b ) 입력값 a를 b제곱한 값을 반환하는 메서드입니다.
    public static BiFunction<Double,Double,Double> powDouble = Math::pow;

    public static BiFunction<Integer, Integer, Integer> randomInt = (a, b) -> (int) (Math.random() * (b - a) + a);
    //Integer.parseInt
}
