import java.util.StringTokenizer;
/**
 This class defines the properties of a date.
 @author Robert Bonagura rjb348
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

   }
}
