import java.util.Scanner;

/**
 * The user interface class that handles input commands and outputs messages.
 * @author Robert Bonagura
 */
public class ProjectManager {

   private Scanner stdin;
   private Team cs213;
   private String command;
   private String name;
   private Date date;
   private TeamMember member;

   /**
    * Runs an infinite loop, processing user commands until user quits program.
    * Parses user input and if appropriate number of arguments are given
    * executes the command.
    */
   public void run() {

      stdin = new Scanner(System.in);
      cs213 = new Team();
      boolean done = false;
      while (!done) {

         command  = stdin.next();

         if (command.charAt(0) == 'A' || command.charAt(0) == 'R' ) {
            name = stdin.next();
            String dateStr = stdin.next();
            date = new Date(dateStr);
            member = new TeamMember(name, date);
         }

         switch (command.charAt(0)) {
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
               print();
               done = true;
               break;
            default:
               System.out.println("Command '" + command + "' not supported!");
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
         System.out.printf("%s is not a valid date\n", date.toString());
         return;
      }
      if (cs213.contains(member)){
         System.out.printf("%s %s is already in the team.\n", name,
                 date.toString());
      } else {
         cs213.add(member);
         System.out.printf("%s %s has joined the team.\n", name,
                 date.toString());
      }
   }

   /**
    * Removes member from team.
    * Prints confirmation on success and notifies user on error.
    * Checks that date is valid and that member exists.
    */
   private void remove() {
      if (!date.isValid()) {
         System.out.printf("%s is not a valid date!\n", date.toString());
         return;
      }
      if (!cs213.contains(member)){
         System.out.printf("%s %s is not a team member.\n", name,
                 date.toString());
      } else {
         cs213.remove(member);
         System.out.printf("%s %s has left the team.\n", name,
                 date.toString());
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
         System.out.println("-- end of list --");
      }
   }
} //ProjectManager
