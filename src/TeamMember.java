/**
 
 @author  
 */
public class TeamMember 
{
   private String name;
   private Date   startDate;
   
   public TeamMember(String nm, Date date)
   {
      this.name = nm;
      this.startDate = date;
   }
   
   public Date getStartDate()
   {
      Date dateCopy = new Date(startDate);
      return dateCopy;
   }
   
   public String getName(){
      return this.name;
   }
   public boolean equals(Object obj)
   {
      TeamMember teamMemberArg = (TeamMember)(obj);
      if(teamMemberArg.getName().equals(this.name) &&
         teamMemberArg.getStartDate().equals(this.startDate) )
         return true;
      return false;
   }  
   
   public String toString()
   {
       //name + " " + startDate;
       return this.name + " " + this.startDate;
   }

   public static void main(String [] args)
   {
      //testbed main; you must include test cases that exercise 
      //the constructor and all methods in this class.

      //Constructor Tests
      TeamMember teamMember1 = new TeamMember("Name1", new Date("1/1/2020"));
      if(!teamMember1.name.equals("Name1"))
         System.out.println("Constructor test failed. name = " + teamMember1.name + " : Expected value = Name1");
      if(!teamMember1.startDate.equals(new Date("1/1/2020")) )
         System.out.println("Constructor test failed. date = " + teamMember1.startDate.toString() + " : Expected value = 1/1/2020");

      //getStartDate Tests
      if(!teamMember1.getStartDate().equals(teamMember1.startDate))
         System.out.println("getStartDate() test failed, value of date returned by getStartDate() = " +
      teamMember1.getStartDate().toString() + " : Expected value = " + teamMember1.startDate.toString() );

      //getName Tests
      if(!teamMember1.getName().equals(teamMember1.name))
         System.out.println("getName() test failed, value of name returned by getName() = " +
      teamMember1.getName() + " : Expected value = " + teamMember1.name);

      //equals Tests 
      String name1 = "TestName1", name2 = "TestName2";
      Date date1 = new Date("1/1/2020"), date2 = new Date("2/2/2020");
      TeamMember teamMemberA = new TeamMember(name1, date1);
      TeamMember teamMemberB = new TeamMember(name1, date2);
      TeamMember teamMemberC = new TeamMember(name2, date1);
      if(!teamMemberA.equals(teamMemberA))
         System.out.println("equals() test failed. a teamMember is not equal to itself");
      if(teamMemberA.equals(teamMemberB))
         System.out.println("equals() test failed. Returned true when dates are not equivalent");
      if(teamMemberA.equals(teamMemberC))
         System.out.println("equals() test failed. Returned true when names are not equivalent");
      
      //toString() Tests
      if(!teamMember1.toString().equals("Name1 1/1/2020"))
         System.out.println("toString() test failed. Returned string = " + teamMember1.toString() + " : Expected value = Name1 1/1/2020");
   }
}
