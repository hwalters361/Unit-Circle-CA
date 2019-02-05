import java.awt.*;
public class DrawAndExplainUnitCircle{

   public static final int PANEL_WIDTH = 1000;
   public static final int PANEL_HEIGHT = 700;
   
   public static void main(String[] args){
      //creates a drawing panel window
      DrawingPanel panel1 =	new DrawingPanel(PANEL_WIDTH,	PANEL_HEIGHT);
      Graphics	g1 = panel1.getGraphics();
      
      basicUnitCircle(g1, panel1);
      
      
      
   }
   
   public static void basicUnitCircle(Graphics g, DrawingPanel panel){
      Font labelFont = new Font("Times New Roman", Font.BOLD, 14);
      Font mainText = new Font("Times New Roman", Font.PLAIN, 20);

      //creates circles diameter
      int diameter = 400;
      int radius = diameter/2;
      
      //finds the x middle and the y middle
      int halfWidth = PANEL_WIDTH/2;
      int halfHeight = PANEL_HEIGHT/2;
      
      g.setFont(labelFont);
      
      g.drawOval(halfWidth-radius,halfHeight-radius, diameter, diameter);
      
      g.drawLine(halfWidth,100,halfWidth,600);
      g.drawLine(250,halfHeight,750,halfHeight);
      
      g.fillOval(halfWidth-5,halfHeight-5,10,10);
      
      //Draws all the lines and labels (coordinates and points) for the orange lines with degree 45
      g.setColor(Color.ORANGE);
      
      g.fillOval(360-5,211-5,10,10);
      g.drawString("(-√2/2), (√2/2)",364,213);
      
      g.fillOval(360-5,491-5,10,10);
      g.drawString("(-√2/2), (-√2/2)", 364, 494);
      
      g.fillOval(641-5,211-5,10,10);
      g.drawString("(√2/2), (√2/2)", 644, 213);
      
      g.fillOval(641-5,491-5,10,10);
      g.drawString("(√2/2), (-√2/2)", 644, 494);
      
      g.drawLine(halfWidth-177, halfHeight+177, halfWidth+177,halfHeight-177);
      g.drawLine(halfWidth-177, halfHeight-177, halfWidth+177, halfHeight+177);
      
      //Draws all the lines and labels (coordinates and points) for the blue lines with degree 30
      g.setColor(Color.BLUE);
      
      g.fillOval(675-5,250-5,10,10);
      g.drawString("(√3/2), (1/2)",678,250);
      
      g.fillOval(328-5,250-5,10,10);
      g.drawString("(-√3/2), (1/2)", 330, 259);
      
      g.fillOval(325-5,450-5,10,10);
      g.drawString("(-√3/2), (-1/2)", 330, 453);
      
      g.fillOval(675-5,450-5,10,10);
      g.drawString("(√3/2),(-1/2)", 678, 453);
      
      
      g.drawLine(halfWidth-216, halfHeight-125, halfWidth+216, halfHeight+125);
      g.drawLine(halfWidth+216, halfHeight-125, halfWidth-216, halfHeight+125);
      
      //Draws all the lines and labels (coordinates and points) for the blue lines with degree 60
      g.setColor(Color.RED);
      
      g.fillOval(601-5,525-5,10,10);
      g.drawString("(1/2), (-√3/2)",606,530);
      
      g.fillOval(601-5,180-5,10,10);
      g.drawString("(1/2), (√3/2) ", 606, 185);
      
      g.fillOval(400-5,180-5,10,10);
      g.drawString("(-1/2), (√3/2)", 405, 185);
      
      g.fillOval(400-5,525-5,10,10);
      g.drawString("(-1/2), (-√3/2)",405, 530);
      
      g.drawLine(halfWidth+125, halfHeight+216, halfWidth-125, halfHeight-216);
      g.drawLine(halfWidth-125, halfHeight+216, halfWidth+125, halfHeight-216);
   }
   
   
}