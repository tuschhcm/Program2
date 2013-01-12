//***********************************************************************
// Project: Program 2
// Account: cs11100n_nn
//
// Author: Craig Tuschhoff
//
// Completion time: 3 hours total
//
// Honor Code: I pledge that this program represents my own program code.
// I received help from (no one) in designing and debugging my program.
//***********************************************************************

public class DriverExam {

   //Instance fields
   private char[] correctAnswers =
   {'B','D','A','A','C','A','B','A','C','D','B','C','D','A','D','C','C','B','D','A'};

   private char[] studentAnswers;

   final private static int TEST_LENGTH = 20;
   final private static int INCORRECT_ANS_ALLOWED = 5;

   //Constructor
   public DriverExam(char[] c) {

      studentAnswers = new char[TEST_LENGTH];

      //move passed array values to instance field
      for(int i = 0; i < c.length; i++) {
         studentAnswers[i] = c[i];
      }
   }

   /**
      the passed method compares studentAnswers to
      correctAnswers and returns true if the
      answers match, false if they do not.
   */
   public boolean passed() {

      //return false if the totalincorrect is greater than allowed    
      if(totalIncorrect()> INCORRECT_ANS_ALLOWED) {
         return false;
      }
      return true;
   }

   /**
      the questionsMissed method returns an array of
      the question numbers where studentAnswers and
      correctAnswers differed
   */
   public int[] questionsMissed() {

      int index = 0; //keep track of question being graded
      int wrongAnswerIterator = 0; //keep track of wrong answer being added

      int[] wrongAnswers = new int[totalIncorrect()]; //holds array to be returned to caller

      //loop through answers to find incorrect submissions
      do{
         if(studentAnswers[index] == correctAnswers[index]) {
            index ++;
         } else {
            wrongAnswers[wrongAnswerIterator] = (index + 1);
            index++;
            wrongAnswerIterator++;
         }
      }while(index < TEST_LENGTH);

      //return array of incorrect answers
      return wrongAnswers;
   }

   /**
      the totalCorrect method returns the total number
      of questions the user got right
   */
   public int totalCorrect() {

      //holds position of current read
      int index = 0;
      int rightAnswerCount = 0;

      //loop through answers and count correct submissions
      do{
         if(studentAnswers[index] == correctAnswers[index]) {
            rightAnswerCount++;
            index ++;
         } else {
            index++;
         }
      }while(index < TEST_LENGTH);

      return rightAnswerCount;
   }

   /**
      the totalIncorrect method returns the total number
      of questions the user got wrong
   */
   public int totalIncorrect() {
      return TEST_LENGTH - totalCorrect();
   }
}

