public class UnitCircleQuizTest{
   public static void main(String[] args){
      UnitCircleQuiz quiz = new UnitCircleQuiz();
      
      for (int i = 1; i<11; i++){
         quiz.playQuiz(i);
      }
      quiz.finisher();
      
      
   }
}