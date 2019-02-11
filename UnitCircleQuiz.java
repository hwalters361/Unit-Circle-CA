import java.util.*; //so i can use scanner and random int
import java.awt.*;
import java.text.DecimalFormat;
 
public class UnitCircleQuiz{
   private int totalQuestions=0;
   private int correct = 0;
   private int incorrect = 0;
   private int[] correctTrig = { 0,0,0,0,0,0 };
   
   private static Scanner console = new Scanner(System.in);
   private static Random rand = new Random();
   
   private DrawingPanel panel;
   private Graphics g;
   

   public UnitCircleQuiz(){
      
      panel = new DrawingPanel(1000,500);
      g = panel.getGraphics();
      
   }
   
   public int getCorrect(){
      return correct;
   }
   
   public int getIncorrect(){
      return incorrect;
   }
   
   public DrawingPanel getDrawingPanel(){
      return panel;
   }
   
   public Graphics getGraphics(){
      return g;
   }
   
   public UnitCircleQuiz(int totalQs, DrawingPanel givenPanel, Graphics givenG){
      this.totalQuestions = totalQs;
      this.panel = givenPanel;
      this.g = givenG;
   }

   public void playQuiz(int i){
      runQuestion(i);
   }
   
   public void finisher(){
      System.out.println("You got "+correct+" questions right out of "+totalQuestions);
      g.drawString("You got "+correct+" questions right out of "+totalQuestions, 400, 400);
      if (correct/totalQuestions <= 0.5){
         g.drawString("You probably need to work on your skills. Review the Unit Circle", 400, 380);
      }else if (0.8>correct/totalQuestions && correct/totalQuestions > 0.5){
         g.drawString("You're getting there! Review the Unit Circle", 400, 380);
      }else if (correct/totalQuestions > 0.8 && incorrect > 0){
         g.drawString("Almost perfect! Keep reviewing", 400, 380);
      }else if (incorrect == 0){
         g.drawString("Perfect score! 100%", 400, 380);
      }
      
     
   }
   
   public int[] rightAndWrong(String randTrig, String answer, String userInput){
      //this counts the specific trig functions that the user got wrong.
      //each number is a trig funtion. the numbers go as follows:
      //                                sin,cos,tan,csc,sec,cot
            
      if (randTrig == "sin"){
         //uses the method to compare the answer & user 
         correctTrig[0] = inputIsA(userInput, answer, correctTrig[0]);
      }else if (randTrig == "cos"){
         correctTrig[1] = inputIsA(userInput, answer, correctTrig[0]);
      }else if (randTrig == "tan"){
         correctTrig[2] = inputIsA(userInput, answer, correctTrig[0]);
      }else if (randTrig == "csc"){
         correctTrig[3] = inputIsA(userInput, answer, correctTrig[0]);
      }else if (randTrig == "sec"){
         correctTrig[4] = inputIsA(userInput, answer, correctTrig[0]);
      }else if (randTrig == "cot"){
         correctTrig[5] = inputIsA(userInput, answer, correctTrig[0]);
      }
      
      return correctTrig;
   }
   
   
   
   private int inputIsA(String input,String answer, int count){
      if (input.equals(answer)){
         return count++;
      }else{
         return count;
      }
   }
   
   public int runQuestion(int num){
      totalQuestions++;
      String[] trigFunctions= {"sin",
                              "cos",
                              "tan",
                              "csc",
                              "sec",
                              "cot",};
                              
                              
      
      //generates a random number to randomly select a trig function.
      
      int randomNum1 = rand.nextInt(trigFunctions.length-1);
      String randTrig = trigFunctions[randomNum1];
      
      int[] unitCircleAngles = new int[17];
      int currentAngle = 0;
      int index = 0;
      panel.clear();
      //creates an array of all unit circle angles
      
      for (int i = 0; i < 4; i++){
         for (int j = 0; j < 4; j++){
            unitCircleAngles[index] = currentAngle;
            index += 1;
      
      //if you look at a unit circle, the angle increases from 0 by 30, then 15, 15, then 30
      //I'm using that cycle here to make every angle on the unit circle and add it to an array
            if (j==0 || j==3){
               currentAngle+=30;
            }else{
               currentAngle+=15;
            }
         }
      }
      unitCircleAngles[16] = 360;
      //End of unit circle angles array
      
      int randomNum2 = rand.nextInt(unitCircleAngles.length-1);
      int randomAngle = unitCircleAngles[randomNum2];
      
      //sets the font to 20pt Times New Roman
      Font headerFont = new Font("Times New Roman", Font.ITALIC, 20 );
      Font bodyFont = new Font("Times New Roman", Font.PLAIN, 20);
      //draws the Header
      g.setFont(headerFont);    
      g.drawString("Question "+num+".", 20,20);
      g.setFont(bodyFont);
      String question = "Find the exact value (no decimal) of the function ";
      question = question+randTrig+"("+randomAngle+"): ";
      
      
      //method finds the answer to the equation in ratio form
      String myAnswer = findAnswer(randTrig, randomAngle);
      
      g.drawString(question, 20, 50);
      System.out.print(question);
      
      String userInput = console.next();
      System.out.println("Correct Answer: " + myAnswer);
      System.out.println("Your answer: " + userInput);
      int result = 0;
      
      //gathers stats on the new correct/incorrect
      int[] specificStats = rightAndWrong(randTrig, myAnswer, userInput);
      
      for (int i = 0; i < specificStats.length; i++){
         System.out.println(specificStats[i]);
      }
      
      if (myAnswer.equals(userInput)){
         result = 1;
         correct++;
         g.setColor(Color.GREEN);
         g.fillRect(10, 80, 200, 50);
         
         g.setColor(Color.WHITE);
         g.fillRect(8,78,198,48);
         
         g.setColor(Color.BLACK);
         g.drawString("Correct!", 40, 100);
         g.drawString(myAnswer,60,130);
         panel.sleep(4000);
      }else{
         incorrect++;
         result = 0;
         g.setColor(Color.RED);
         g.fillRect(10, 80, 200, 50);
         
         g.setColor(Color.WHITE);
         g.fillRect(8,78,198,48);
         
         g.setColor(Color.BLACK);
         g.drawString("Incorrect", 40, 100);
         g.drawString("Correct Answer: "+myAnswer, 60,150);
         g.drawString("Your Answer: "+userInput,60,170);
         panel.sleep(5000);
      }
      
      return result;
   }
   
   private String findAnswer(String randTrig, int randomAngle){
      String answer = "default";
   //below is the assigner for all the axis angles
      if (randomAngle == 0){
         if (randTrig == "sin"||randTrig == "tan"){
            answer = "0";
         }else if(randTrig == "cos"||randTrig == "sec"){
            answer = "1";
         }else if(randTrig == "csc"||randTrig == "cot"){
            answer = "undefined";
         }
      }else if (randomAngle == 90){
         if (randTrig == "sin"||randTrig == "csc"){
            answer = "1";
         }else if(randTrig == "cos"){
            answer = "0";
         }else if(randTrig == "cot"||randTrig == "tan"||randTrig == "sec"){
            answer = "undefined";
         }

      }else if (randomAngle == 180){
         if (randTrig == "sin"||randTrig == "tan"){
            answer = "0";
         }else if(randTrig == "cos"||randTrig == "sec"){
            answer = "-1";
         }else if(randTrig == "csc"||randTrig == "cot"){
            answer = "undefined";
         }
      }else if (randomAngle == 270){
         if (randTrig == "cos"){
            answer = "0";
         }else if(randTrig == "sin"||randTrig == "csc"){
            answer = "-1";
         }else if(randTrig == "tan"||randTrig == "sec"||randTrig == "cot"){
            answer = "undefined";
         }
      }else if (randomAngle == 360){
         if (randTrig=="sin"||randTrig=="tan"){
            answer = "0";
         }else if(randTrig=="cos"||randTrig == "sec"){
            answer = "1";
         }else if(randTrig=="csc"||randTrig == "cot"){
            answer = "undefined";
         }
      }
      //moving on to the inbetween angles.
      if (answer == "default"){
         double radians = Math.toRadians(randomAngle);
         
         DecimalFormat df = new DecimalFormat("####0.00");
         //because regular Math.round wasn't working I used a different library Decimal Format
         double sinValue = Math.sin(radians);
         double cosValue = Math.cos(radians);
         double tanValue = Math.tan(radians);
         
         String stringSinValue = df.format(Math.sin(radians));
         String stringCosValue = df.format(Math.cos(radians));
         String stringTanValue = df.format(Math.tan(radians));
         
         String astringSinValue = df.format(Math.abs(Math.sin(radians)));
         String astringCosValue = df.format(Math.abs(Math.cos(radians)));
         String astringTanValue = df.format(Math.abs(Math.tan(radians)));
         
         String cscValue = df.format(1/sinValue);
         String secValue = df.format(1/cosValue);
         String cotValue = df.format(1/tanValue);
         
         
         if (randTrig == "sin"){
            if (stringSinValue.equals("0.50")) {answer = "1/2";}
            else if(stringSinValue.equals("-0.50")){
               return "-1/2";
            }
            else if(stringSinValue.equals("0.87")){return "(3)/2";}
            else if(stringSinValue.equals("-0.87")){return "-(3)/2";}
            else if(stringSinValue.equals("0.71")){return "(2)/2";}
            else if(stringSinValue.equals("-0.71")){return "-(2)/2";}
         }else if (randTrig == "cos"){
            if (stringCosValue.equals("-0.50")){return "-1/2";}
            else if(stringCosValue.equals("0.50")){return "1/2";}
            else if(stringCosValue.equals("0.87")){return "(3)/2";}
            else if(stringCosValue.equals("-0.87")){return "-(3)/2";}
            else if(stringCosValue.equals("0.71")){return "(2)/2";}
            else if(stringCosValue.equals("-0.71")){return "-(2)/2";}
         }else if(randTrig == "tan"){
            if (stringTanValue.equals("-1")){return "-1";}
            else if(stringTanValue.equals("1")){return "1";}
            else if(stringTanValue.equals("0.58")){return "1/(3)";}
            else if(stringTanValue.equals("-0.58")){return "-(1)/3";}
            else if(stringTanValue.equals("1.73")){return "(3)";}
            else if(stringTanValue.equals("-1.73")){return "-(3)";}
         //the answers on these secant, cosecant, cotangent ones are just the inverse of the
         //functions above
         }else if(randTrig == "csc"){
            if (stringSinValue.equals("0.50")){return "2";}
            else if(stringSinValue.equals("-0.50")){return "-2";}
            else if(stringSinValue.equals("0.87")){return "2/(3)";}
            else if(stringSinValue.equals("-0.87")){return "-2/(3)";}
            else if(stringSinValue.equals("0.71")){return "2/(2)";}
            else if(stringSinValue.equals("-0.71")){return "-2/(2)";}
         }else if(randTrig == "sec"){
            if (stringCosValue.equals("-0.50")){return "-2";}
            else if(stringCosValue.equals("0.50")){return "2";}
            else if(stringCosValue.equals("0.87")){return "2/(3)";}
            else if(stringCosValue.equals("-0.87")){return "-2/(3)";}
            else if(stringCosValue.equals("0.71")){return "2/(2)";}
            else if(stringCosValue.equals("-0.71")){return "-2/(2)";}
         }else if(randTrig == "cot"){
            if (stringTanValue.equals("-1")){return "-1";}
            else if(stringTanValue.equals("1")){return "1";}
            else if(stringTanValue.equals("0.57")){return "(3)/1";}
            else if(stringTanValue.equals("-0.57")){return "-3/(1)";}
            else if(stringTanValue.equals("1.73")){return "1/(3)";}
            else if(stringTanValue.equals("-1.73")){return "-1/(3)";}
         }
;
      }
      return answer;
   }

}