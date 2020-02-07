/**
  
 @author Robert Bonagura
 */
public class Date 
{
   private int  day;
   private int  month;
   private int  year;
   
   public Date(String d)
   {
      //use StringTokenizer to parse the String and create a Date object
      String delim = "/";
      StringTokenizer st = new StringTokenizer(d, delim);
      this.month = Integer.parseInt(st.nextToken());
      if (st.hasMoreTokens()){
         this.day = Integer.parseInt(st.nextToken());
      }
      if (st.hasMoreTokens()){
         this.year = Integer.parseInt(st.nextToken().parseInt());
      }
      return;
   }
   
   public Date(Date d)
   {
      //this is a constructor
      this.day = d.day;
      this.month = d.month;
      this.year = d.year;
      return;
   }      
   
   public boolean isValid()
   {
      int DAY_FIRST = 1;
      switch (this.month){
         case JAN:
         case MAR:
         case MAY:
         case JUL:
         case AUG:
         case OCT:
         case DEC:
            if (this.day < DAY_FIRST || this.day > DAYS_ODD){
               return false;
            }
            break;
         case APR:
         case JUN:
         case SEP:
         case NOV:
            if (this.day < DAY_FIRST || this.day > DAYS_EVEN){
               return false;
            }
            break;
         case FEB:
            if (isLeapYear()){
               if (this.day < DAY_FIRST || this.day > DAYS_FEB + 1) {
                  return false;
               }   
            } else {
               if (this.day < DAY_FIRST || this.day > DAYS_FEB) {
                  return false;
               } 
            } 
            break;
         default:
            return false;
            break;
      }
      return true;
   }

   private void isLeapYear()
   {
      if (this.year % 4 == 0) {
         if (this.year % 100 == 0){
            if (this.year % 400 == 0) {
               return true;
            } else {
               return false;
            }
         } else {
            return true;
         }
      }
      return false;
   }
   
   @Override
   public String toString()
   {
       //use the format "month/day/year"
       String slash = "/";
       String monthStr = Integer.toString(this.month);
       String dayStr = Integer.toString(this.day);
       String yearStr = Integer.toString(this.year);
       String output = monthStr + slash + dayStr + slash + yearStr;
       return output;

   }
   
   @Override
   public boolean equals(Object obj)
   {
    
    
   }  


