import java.awt.*;
public class DrawAndExplainUnitCircle{

   public static final int PANEL_WIDTH = 1000;
   public static final int PANEL_HEIGHT = 700;
   
   public static void main(String[] args){
      //creates a drawing panel window
      DrawingPanel panel1 =	new DrawingPanel(PANEL_WIDTH,	PANEL_HEIGHT);
      Graphics	g1 = panel1.getGraphics();
      
      DrawingPanel panel2 =	new DrawingPanel(PANEL_WIDTH,	PANEL_HEIGHT);
      Graphics	g2 = panel2.getGraphics();
      
      basicUnitCircle(g1, panel1);
      explainUnitCircle(g2,panel2);
      
      
   }
   public static void explainUnitCircle(Graphics g, DrawingPanel panel){
   
   }
   public static void basicUnitCircle(Graphics g, DrawingPanel panel){
      Font labelFont = new Font("Times New Roman", Font.BOLD, 14);
      Font mainFont = new Font("Times New Roman", Font.PLAIN, 20);

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
      drawOrangeLabels(g, halfWidth, halfHeight);
      
      //Draws all the lines and labels (coordinates and points) for the blue lines with degree 30
      drawBlueLabels(g, halfWidth, halfHeight);      
      
      //Draws all the lines and labels (coordinates and points) for the blue lines with degree 60
      drawRedLabels(g, halfWidth, halfHeight);
      
      g.setColor(Color.BLACK);
      g.setFont(mainFont);
      g.drawString("Because in the unit circle r = 1", 20,20);
      g.drawString("x,y = cos(),sin()",20,40);
      
      //draws the degrees
      int modX = radius;
      int modY = 0;
      for (int i=0; i < 360; i+= 90){
      
         if (i == 0){
            modY = 0;
            modX = radius;
         }else if(i == 90){
            modY = -radius;
            modX = 0;
         }else if(i == 180){
            modY = 0;
            modX = -radius;
         }else if(i == 270){
            modY = radius;
            modX = 0;
         }else if(i == 360){
            modY = 20;
            modX = radius;
         }
         
         g.setColor(Color.BLACK);
         g.drawString(i+"º",halfWidth+modX, halfHeight+modY);
      }
   }
   
   
   
   
   
   
   
   
   
   
   public static void drawOrangeLabels(Graphics g, int halfWidth, int halfHeight){
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
      
      int modX = 80;
      int modY = -60;
      for (int i=45; i < 360; i+= 90){
         g.setColor(Color.BLACK);
         //makes it so that 90,180,270, and 360 and labeled multiple times
         
         if (i == 225){
            modY*=-1;
         }
         if (i==135 || i==315){
            modX = -70;
         }else{
            modX = 50;
         }
            
            g.drawString(i+"º",halfWidth+modX, halfHeight+modY);
         }
      
      
   }
   
   public static void drawBlueLabels(Graphics g, int halfWidth, int halfHeight){
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
      
      
      //draws the degrees
      int modX = 60;
      int modY = -15;
      for (int i=30; i < 360; i+= 60){
         
         g.setColor(Color.BLACK);
         //makes it so that 90,180,270, and 360 and labeled multiple times
         if (i % 45 != 0){
            if (i%7 == 0){
               modY*=-1;
            }
            g.drawString(i+"º",halfWidth+modX, halfHeight+modY);
            if (i==30 || i==210){
               modX *= -1;
            }
         }
      }
   }
   
   public static void drawRedLabels(Graphics g, int halfWidth, int halfHeight){
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
      
      int modX = 10;
      int modY = -50;
      for (int i=60; i < 360; i+= 60){
         g.setColor(Color.BLACK);
         //makes it so that 90,180,270, and 360 and labeled multiple times
         if (i % 45 != 0){
            if (i == 240){
               modY*=-1;
            }
            if (i==120 || i==300){
               modX = -30;
            }else{
               modX = 10;
            }
            
            g.drawString(i+"º",halfWidth+modX, halfHeight+modY);
         }
         
      }

   
   }
   
}