import java.awt.image.BufferedImage;
import java.awt.*;

//Класс наследуется от JComponent
public class JImageDisplay extends javax.swing.JComponent{
    private BufferedImage buffim;

    //Конструктор класса
    public  JImageDisplay (int width, int height) {
        buffim = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Dimension d = new Dimension(width, height);
        super.setPreferredSize(d);

    }
    // метод для создания изображения
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage (buffim, 0, 0, buffim.getWidth(), buffim.getHeight(), null);
    }
    // метод закрашивает пиксель в черный(убирает изображение)
    public void clearImage (){
        int[] rgbArray = new int[buffim.getWidth() * buffim.getHeight()];
        buffim.setRGB(0, 0, buffim.getWidth(), buffim.getHeight(), rgbArray, 0, 1);

    }
    //Метод, который устанавливает пиксель в определенный цвет
    public void drawPixel (int x, int y, int rgbColor){
        buffim.setRGB(x, y, rgbColor);
    }
}
