import java.awt.geom.Rectangle2D;

/**
 * Этот класс является делегатом абстрактного класса FractalGenerator.
 * В нем реализованы методы:
 * getInitialRange
 * numIterations
 */
public class BurningShip extends FractalGenerator{

    public static final int MAX_ITERATIONS = 2000;

    /**
     * Метод устанавливает базовые значения x, y для формулы Tricorn,
     * а также ширину и высоту увеличения области фрактала.
     */
    public void getInitialRange(Rectangle2D.Double range){
        range.x = -2;
        range.y = -2.5;
        range.width = 4;
        range.height = 4;
    }

    /**
     * Данный метод вычисляет количество итераций для каждого пикселя
     * в соответствии с итерациями фрактала BurningShip. При этом
     * модуль комплексного числа мандельброта не должен превышать 2.
     */
    public int numIterations (double x, double y){
        int i = 0;
        ComplexNums num = new ComplexNums(x, y);
        while ( i < MAX_ITERATIONS && ((num.Zreal * num.Zreal) + (num.Zimaginary * num.Zimaginary)) < 4) {
            num.iterationBurningShip();
            i++;
        }
        if (i == MAX_ITERATIONS)
            return -1;
        else
            return i;
    }

    public String toString (){
        return "Burning Ship";
    }
}