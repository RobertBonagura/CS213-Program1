import java.util.Scanner;

/**
 * @author
 */

public class ProjectManager {

   Scanner stdin;
   Team cs213;

   public void run() {

      boolean done = false;
      while (!done) {
         String userInput = stdin.next();
         Command command = parseInput(userInput);
         switch (command.getCmd()) {
            case 'A':
               add();
               break;
            case 'R':
               remove();
               break;
            case 'P':
               print();
               break;
            case 'Q':
               done = true;
               System.out.println("The team is ready to go!");
               break;
            default: //deal with bad command here
               System.out.println("Command '" + command.getCmd() + "' not supported");
               break;
         }
      }
      //write java code before you terminate the program
   } //run()

   private Command parseInput(String userInput) {
      //Parse input string and create a new Command instance to return
   }

   private void add() {
      //must check if the date is valid
      //must call the contains() method to check if a given
      //team member is in the team already
   }

   private void remove() {
      //must check if the date is valid

   }

   private void print() {
      //must check if the team has 0 members. 
   }
} //ProjectManager
