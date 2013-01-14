//***********************************************************************
// Project: Program 2
// Account: cs11100n_nn
//
// Author: Craig Tuschhoff
//
// Completion time: 3 hours total
//
// Honor Code: I pledge that this program represents my own program code.
// I received help from (write names here or no one) in designing and
// debugging my program.
//***********************************************************************

import java.util.*;

public class DriverExamDemo {
   
   //create an exam that is globally accessible
   private static DriverExam exam;

   //declare test length
   final private static int TEST_LENGTH = 20;
   
   public static void main(String[] args) {

      //create scanner object to get user input
      Scanner keyboard = new Scanner(System.in);
      
      //create array to store student answers in
      char[] studentAnswers = new char[TEST_LENGTH];
      
      //create array of legal answers
      char legalAnswers[] = {'A', 'B', 'C', 'D'};
      
      //collect answers from student
      System.out.print("\n");
      System.out.println("Driver's License Exam");
      System.out.println("---------------------");
      
      for(int index = 0; index < TEST_LENGTH; index++) {
         
         //adjusts zero based iterator for displaying question number
         int currentQuestion = index + 1;
         
         //display number of question to be answered
         System.out.print(currentQuestion + ": ");
         
         //get user answer
         String userInput = keyboard.next();
         studentAnswers[index] = userInput.charAt(0);
         
         //validate user input
         if(!validateAnswer(studentAnswers[index], legalAnswers)) {
            System.out.println("Invalid answer, Please try again.");
            index--;
         }
      }

      //initialize the DriverExam object
      exam = new DriverExam(studentAnswers);
            
      //Display results to user
      System.out.print("\n");
      displayResults();
   }
   
   /**
      The validateAnswer method returns true when the passed
      character exists in the passed character array.
      otherwise it returns false
   */
   public static boolean validateAnswer(char s, char[] l) {
      
      //compare answers, return true if any match
      for(int i = 0; i < l.length; i++) {
         if(s == l[i]) {
            return true;
         }
      }
      
      //if no answers match, return false
      return false;
   }
   
   /**
      displayResults calls a series of methods within the
      DriverExam class to print the results of the test
   */
   public static void displayResults() {
      
      //print correct and incorrect numbers to screen
      System.out.print("Number Correct = ");
      System.out.println(exam.totalCorrect());
      System.out.print("Number Incorrect = ");
      System.out.println(exam.totalIncorrect());
      
      //check if passed and print result
      if(exam.passed()) {
         System.out.println("Congratulations, you Passed!");
      } else {
         System.out.println("Sorry, you failed");
      }
      
      //display which questions were missed
      System.out.print("You missed questions: ");
      for(int i = 0; i < exam.questionsMissed().length; i++) {
         System.out.print(exam.questionsMissed()[i] + ", ");
      }

      System.out.println("\n");
   }
}
