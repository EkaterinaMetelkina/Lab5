import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

public class JImageDisplay extends JComponent{
    private BufferedImage bufferedImage;

    // Управляет изображением
    public BufferedImage getImage() {
        return bufferedImage;
    }

    // Инициализирует ширину, высоту и тип изображения
    public JImageDisplay(int width, int height, int TYPE_INT_RGB){
        this.bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        super.setPreferredSize(new Dimension(width, height));
    }
    @Override

    // Метод позволяет вывести изображение на экран. Этот метод переопределяет соответствующий в родительском классе
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
    }

    // Метод установления всех пикселей в черный цвет
    public void clearImage(){
        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            for (int j = 0; j < bufferedImage.getHeight(); j++) {
                bufferedImage.setRGB(i, j, 0);
            }
        }
    }
    public void drawPixel(int x, int y, int rgbColor){
        bufferedImage.setRGB(x, y, rgbColor);
    }


}
