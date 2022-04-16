import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator{

    public static final int MAX_ITERATIONS = 2000;

    // Определение наиболее "интересной" области комплексной плоскости
    public void getInitialRange(Rectangle2D.Double range) {
    range.x = -2;
    range.y = -1.5;
    range.width = 3;
    range.height = 3;
    }

    // Реализует итеративную функцию для фрактала Мандельброта
    public int numIterations(double x, double y){
        int i = 0;
        ComplexNums num = new ComplexNums(x, y);
        while ( i < MAX_ITERATIONS && ((num.Zreal * num.Zreal) + (num.Zimaginary * num.Zimaginary)) < 4) {
            num.iterationMandelbrot();
            i++;
        }
        if (i == MAX_ITERATIONS)
            return -1;
        else
            return i;
    }

    public String toString (){
        return "Mandelbrot";
    }
}
