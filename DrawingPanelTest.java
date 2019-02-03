import java.awt.*;
public class DrawingPanelTest{

   public static final int PANEL_WIDTH = 500;
   public static final int PANEL_HEIGHT = 500;
   
   public static void main(String[] args){
   
      DrawingPanel panel1 =	new DrawingPanel(PANEL_WIDTH,	PANEL_HEIGHT);
      Graphics	g = panel1.getGraphics();
      
      int diameter = 100;
      int radius = diameter/2;
      
      g.drawOval((PANEL_WIDTH/2)-radius,(PANEL_HEIGHT/2)-radius, diameter, diameter);
   }
}