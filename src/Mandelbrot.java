import java.awt.geom.Rectangle2D;


public class Mandelbrot extends FractalGenerator{ //Класс фрактала множества мандельброта, наследуемый от генератора фракталов
    public static final int MAX_ITERATIONS = 2000; // максимальное количество итераций

    @Override
    public void getInitialRange(Rectangle2D.Double range){ //Переопределение метода для получения исходного диапазона на определённое комп.число
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;

    }
    @Override
    public int numIterations(double x, double y){//Переопределение метода для получения кол-ва итераций для текущей координаты
        int iteration = 0;
        double zreal = 0;
        double zimaginary = 0;
        double zreal2 = 0;
        double zimaginary2 = 0;
        while(iteration < MAX_ITERATIONS && (zreal2 + zreal2) < 4)
        {
            zimaginary = (2 * zreal * zimaginary) + y;
            zreal = (zreal2 - zimaginary2) + x;

            zreal2 = zreal*zreal;
            zimaginary2 = zimaginary*zimaginary;
            iteration++;
        }
        if (iteration == MAX_ITERATIONS) { // если алгоритм дошел до макс.знач. выводим -1
            return -1;
        }
        return iteration;
    }
}
