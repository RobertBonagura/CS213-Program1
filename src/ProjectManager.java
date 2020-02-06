import java.util.Scanner;

/**
 * The user interface class that handles input commands and outputs messages.
 * @author Robert Bonagura rjb348
 */
public class ProjectManager {

   private Scanner stdin;
   private Team cs213;
   private String cmd;
   private String name;
   private String dateStr;
   private Date date;
   private TeamMember member;


   /**
    * Runs an infinite loop, processing user commands until user quits
    * program.
    * Prints to console a confirmation of successful command.
    * Otherwise, prints a message indicating invalid command.
    */
   public void run() {

      boolean done = false;
      while (!done) {
         String command  = stdin.next();
         String[] parsedInput = command.split(" ");
         cmd = parsedInput[0];

         if (cmd.length() > 1){
            System.out.println("Invalid command: First argument must be one character.");
            continue;
         }

         if ((cmd.charAt(0) == 'A' || cmd.charAt(0) == 'R' )
                 && parsedInput.length == 3){

            name = parsedInput[1];
            dateStr = parsedInput[2];
            date = new Date(dateStr);
            member = new TeamMember(name, date);
         } else if (parsedInput.length == 3) {
            System.out.println("Error: Add and Remove commands require exactly 3 arguments.");
         }

         switch (cmd.charAt(0)) {
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
               break;
            default:
               System.out.println("Command '" + cmd + "' not supported!");
               break;
         }
      }
      System.out.println("The team is ready to go!");
   } //run()

   /**
    * Adds member to team.
    * Prints confirmation on success and notifies user on error.
    * Checks that date is valid and that member doesn't already exist.
    */
   private void add() {
      if (!date.isValid()) {
         System.out.printf("%s is not a valid date\n", dateStr);
         return;
      }
      if (cs213.contains(member)){
         System.out.printf("%s %s is already in the team.\n", name, dateStr);
      } else {
         cs213.add(member);
         System.out.printf("%s %s has joined the team.\n", name, dateStr);
      }
   }

   /**
    * Removes member from team.
    * Prints confirmation on success and notifies user on error.
    * Checks that date is valid and that member exists.
    */
   private void remove() {
      if (!date.isValid()) {
         System.out.printf("%s is not a valid date\n", dateStr);
         return;
      }
      if (!cs213.contains(member)){
         System.out.printf("%s %s is not a team member.\n", name, dateStr);
      } else {
         cs213.remove(member);
         System.out.printf("%s %s has left the team.\n", name, dateStr);
      }
   }

   /**
    * Prints all members in team.
    * When empty notifies user that there are 0 team members.
    */
   private void print() {
      if (cs213.isEmpty()){
         System.out.println("We have 0 team members!");
      } else {
         System.out.println("We have the following team members:");
         cs213.print();
      }
   }
} //ProjectManager
