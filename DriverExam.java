//***********************************************************************
// Project: Program 2
// Account: cs11100n_nn
//
// Author: Craig Tuschhoff
//
// Completion time: 2 hours total
//
// Honor Code: I pledge that this program represents my own program code.
// I received help from (no one) in designing and debugging my program.
//***********************************************************************

import java.util.ArrayList;

public class DriverExam {

   //Instance fields
   private char[] correctAnswers =
   {'B','D','A','A','C','A','B','A','C','D','B','C','D','A','D','C','C','B','D','A'};

   private char[] studentAnswers;

   final private static int TEST_LENGTH = 20;

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

      boolean pass;
      int index = 0;

      //compare answers
      do{
         if(studentAnswers[index] == correctAnswers[index]) {
            pass = true;
            index++;
         } else {
            pass = false;
         }
      }while(pass == true && index < studentAnswers.length);

      return pass;
   }

   /**
      the questionsMissed method returns an array of
      the question numbers where studentAnswers and
      correctAnswers differed
   */
   public int[] questionsMissed() {

      //ArrayList used because number of incorrect submissions is unknown
      ArrayList<Integer> wrongAnswers = new ArrayList<Integer>();

      int index = 0; //keep track of question being graded

      int[] toReturn; //holds array to be returned to caller

      //loop through answers to find incorrect submissions
      do{
         if(studentAnswers[index] == correctAnswers[index]) {
            index ++;
         } else {
            wrongAnswers.add(index + 1);
            index++;
         }
      }while(index < studentAnswers.length);

      //move incorrect submissions into a normal array
      toReturn = new int[wrongAnswers.size()];

      for(int i = 0; i < wrongAnswers.size(); i++) {
         toReturn[i] = wrongAnswers.get(i);
      }

      //return incorrrect answers
      return toReturn;
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
      }while(index < studentAnswers.length);


      return rightAnswerCount;
   }

   /**
      the totalIncorrect method returns the total number
      of questions the user got wrong
   */
   public int totalIncorrect() {

      //holds position of current read
      int index = 0;
      int wrongAnswerCount = 0;

      //loop through answers and count correct submissions
      do{
         if(studentAnswers[index] == correctAnswers[index]) {
            index ++;
         } else {
            wrongAnswerCount++;
            index++;
         }
      }while(index < studentAnswers.length);


      return wrongAnswerCount;
   }
}

