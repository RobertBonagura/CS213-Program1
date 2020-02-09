/**
  
 @author  
 */
public class Team 
{
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow.length
   private TeamMember [] team;
   private int numMembers;
   
   public Team()
   {
      //this is the default constructor
      this.team = new TeamMember[GROW_SIZE];
      this.numMembers = 0;
   }
   
   private int find(TeamMember m)
   {
      for(int i = 0; i < numMembers; i++)
         if(team[i].equals(m))
            return i;
      return NOT_FOUND;
   }
   
   private void grow()
   {
      TeamMember[] newTeamArray = new TeamMember[team.length * GROW_SIZE];
      copyTeamToNewArray(newTeamArray);
      this.team = newTeamArray;
   }
   
   private void copyTeamToNewArray(TeamMember[] newArray){
      for(int i = 0; i < numMembers; i++)
         newArray[i] = team[i];
   }

   public boolean isEmpty()
   {
      if(numMembers == 0)
         return true;
      return false; 
   }
   
   public void add(TeamMember m)
   {     
      team[numMembers] = m;
      numMembers++;
      if(numMembers == team.length)
         grow();
   }
   
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
   
   public boolean contains(TeamMember m)
   {
      for(int i = 0; i < numMembers; i++)
         if(team[i].equals(m))
            return true;
      return false;
   } 
   
   public void print()
   {
      for(int i = 0; i < numMembers; i++)
         System.out.println(team[i].toString());
   } 
   
   public static void main(String[] args){
      //testbed main
   }
}
