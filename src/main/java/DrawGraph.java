import javax.swing.*;
import java.awt.*;

public class DrawGraph extends JPanel {

    JFrame jFrame = new JFrame("Line Graph");
    int x = 0;
    int y = 0;
    DrawGraph(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void draw(){
        jFrame.getContentPane().add(new DrawGraph(x,y));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(700,700);
        jFrame.setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        g.drawLine(x,x +2,y,y + 2);
    }
}
