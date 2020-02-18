import java.util.StringTokenizer;
/**
 This class defines the properties of a date.
 @author Robert Bonagura
 */
public class Date {
   private int day;
   private int month;
   private int year;

   /**
    * Tokenize String into a Date object.
    * @param d to be parsed into date
    */
   public Date(String d) {
      String delim = "/";
      StringTokenizer st = new StringTokenizer(d, delim);
      this.month = Integer.parseInt(st.nextToken());
      if (st.hasMoreTokens()) {
         this.day = Integer.parseInt(st.nextToken());
      }
      if (st.hasMoreTokens()) {
         this.year = Integer.parseInt(st.nextToken());
      }
      return;
   }

   /**
    * Creates a Date object that is a copy of the parameter.
    * @param d Date argument to copy as new Date object
    */
   public Date(Date d) {
      this.day = d.day;
      this.month = d.month;
      this.year = d.year;
      return;
   }

   /**
    * Checks if the date is valid.
    * Checks that date is consistent with number of days in that given month.
    * @return true if date is valid, false if not
    */
   public boolean isValid() {
      int DAY_FIRST = 1;
      switch (this.month) {
         case Month.JAN:
         case Month.MAR:
         case Month.MAY:
         case Month.JUL:
         case Month.AUG:
         case Month.OCT:
         case Month.DEC:
            if (this.day < DAY_FIRST || this.day > Month.DAYS_ODD) {
               return false;
            }
            break;
         case Month.APR:
         case Month.JUN:
         case Month.SEP:
         case Month.NOV:
            if (this.day < DAY_FIRST || this.day > Month.DAYS_EVEN) {
               return false;
            }
            break;
         case Month.FEB:
            if (isLeapYear()) {
               if (this.day < DAY_FIRST || this.day > Month.DAYS_FEB + 1) {
                  return false;
               }
            } else {
               if (this.day < DAY_FIRST || this.day > Month.DAYS_FEB) {
                  return false;
               }
            }
            break;
         default:
            return false;
      }
      return true;
   }

   /**
    * Checks if the year of the current Date object is a leap year
    * @return true if it is leap year, otherwise returns false
    */
   private boolean isLeapYear() {
      if (this.year % 4 == 0) {
         if (this.year % 100 == 0) {
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

   /**
    * Compose a String from the Date object in MM/DD/YYYY format.
    * @return String in MM/DD/YYYY format
    */
   @Override
   public String toString() {
      String slash = "/";
      String monthStr = Integer.toString(this.month);
      String dayStr = Integer.toString(this.day);
      String yearStr = Integer.toString(this.year);
      String output = monthStr + slash + dayStr + slash + yearStr;
      return output;
   }

   /**
    * Compares whether or not the given argument matches this date object.
    * @param obj Object being compared to this date object
    * @return True if they haven the same date, false otherwise.
    */
   @Override
   public boolean equals(Object obj) {
      if (obj instanceof Date) {
         Date date = (Date) obj;
         if (this.day == date.day && this.month == date.month
                 && this.year == date.year) {
            return true;
         }
      }
      return false;
   }

   /**
    * Testbed main function for Date class.
    * Tests each method of the class.
    */
   public static void main(String[] args) {

      int MAX_SIZE = 10;
      Date[] dates = new Date[MAX_SIZE];

      System.out.println("Testing first constructor, isValid(), " +
              "isLeapYear() and toString() methods:");
      dates[0] = new Date("1/01/2000");
      dates[1] = new Date("6/01/2007");
      dates[2] = new Date("12/01/2003");
      dates[3] = new Date("13/01/2002");
      dates[4] = new Date("0/01/2002");
      dates[5] = new Date("2/30/2000");
      dates[6] = new Date("2/28/2007");
      dates[7] = new Date("2/29/2000");
      dates[8] = new Date("2/29/2002");
      dates[9] = new Date("2/28/2002");

      for (int i = 0; i < MAX_SIZE; i++ ){
         String leapYearStr, validity;
         if (dates[i].isLeapYear()){
            leapYearStr = "is a leap year";
         } else {
            leapYearStr = "is not a leap year";
         }
         if (dates[i].isValid()) {
            validity = "and is a valid date.";
         } else {
            validity = "and is NOT a valid date.";
         }
         System.out.printf("%s %s %s\n", dates[i], leapYearStr, validity);
      }

      System.out.println("Testing second constructor and isEquals method:");
      Date date1 = dates[0];
      Date date2 = new Date(date1);
      Date date3 = new Date(date1.toString());
      Date date4 = new Date(dates[1]);
      System.out.printf("%s equals %s: %s\n", date1, date2, date1.equals(date2));
      System.out.printf("%s equals %s: %s\n", date1, date3, date1.equals(date3));
      System.out.printf("%s equals %s: %s\n", date1, date4, date1.equals(date4));
   }
}
