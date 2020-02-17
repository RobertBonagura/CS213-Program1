/**
Implements an arraylist of TeamMembers with some basic services. 
Services include add(TeamMember), remove(TeamMember), contains(TeamMember) and print() to output all TeamMembers
@author Ezra Haleva
*/
public class Team 
{
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow.length
   private TeamMember [] team;
   private int numMembers;
   /**
   Initializes array of TeamMembers and sets numMembers to 0
   */
   public Team()
   {
      //this is the default constructor
      this.team = new TeamMember[GROW_SIZE];
      this.numMembers = 0;
   }
   /**
   performs a linear search on team array to find passed TeamMember. 
   @param m The TeamMember that is searched for. 
   @return if found, returns the index of the TeamMember in the array. If not found, returns -1. 
   */
   private int find(TeamMember m)
   {
      for(int i = 0; i < numMembers; i++)
         if(team[i].equals(m))
            return i;
      return NOT_FOUND;
   }
   /**
   Transfers data of team array into a new, larger array. Sets the team variable to reference this new array.
   First creates a new array 4 times the size of the size of the old array, then copies the contents of the
   old array into the new one.
   */
   private void grow()
   {
      TeamMember[] newTeamArray = new TeamMember[team.length * GROW_SIZE];
      copyTeamToNewArray(newTeamArray);
      this.team = newTeamArray;
   }
   /**
   Copies contents of the team array into a newArray. 
   New array must be at least as large as current number of TeamMembers
   @param newArray the new array into which contents of team are copied
   */
   private void copyTeamToNewArray(TeamMember[] newArray){
      for(int i = 0; i < numMembers; i++)
         newArray[i] = team[i];
   }
   /**
   Checks if there are any members in the team array.
   It is assumed value of numMembers will never be less than 0.
   @return true if there are 0 members, false otherwise.
   */
   public boolean isEmpty()
   {
      if(numMembers == 0)
         return true;
      return false; 
   }
   /**
   Sets the next unused index in team array to the passed TeamMember. Increments numMembers
   If team array is full after adding new TeamMember, calls grow function to increase capacity of team array.
   @param m The TeamMember to be added to the team array.
   */
   public void add(TeamMember m)
   {     
      team[numMembers] = m;
      numMembers++;
      if(numMembers == team.length)
         grow();
   }
   /**
   Searches for a TeamMember in the team array and, if found, removes it and decrements numMembers.
   Uses find() to determine the index of the TeamMember to remove. Overwrites TeamMember at that index with
   last TeamMember in team array. Sets last occupied index of array to null. 
   @param m TeamMember to search for and remove.
   @return true if m is found and removed succesfully. False if m is not found in team array.
   */
   public boolean remove(TeamMember m)
   {
      int indexToRemove = find(m);
      if(indexToRemove == NOT_FOUND)
         return false;
      team[indexToRemove] = team[numMembers-1];
      team[numMembers-1] = null;
      numMembers--;
      return true;
   }
   /**
   uses linear search to search for a TeamMember in the team array. 
   @param m TeamMember to search for
   @return true if TeamMember is found, false otherwise
   */
   public boolean contains(TeamMember m)
   {
      for(int i = 0; i < numMembers; i++)
         if(team[i].equals(m))
            return true;
      return false;
   } 
   /**
   Loops through the team array up to numMembers and prints out the toString() of each TeamMember on a new line.
   */
   public void print()
   {
      for(int i = 0; i < numMembers; i++)
         System.out.println(team[i].toString());
   } 
}
