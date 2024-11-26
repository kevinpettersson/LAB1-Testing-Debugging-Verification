public class DatesImprove {

    /* Precondition: month is between 1 and 12, inclusive */
    /* Postcondition: returns the number of days in the given month */
    public static int daysInMonth (int month) {
        if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
            return 30;
        }
        if((month == 2)){
            return 28;
        }
        else return 31;
    }

    public static boolean isValidDate(int day, int month){
        if ((month == 4 || month == 6 || month == 9 || month == 11) && 1 <= day && day <= 30) {
            return true;
        }else if ((month == 2) && 1 <= day && day <= 28) {
            return true;
        }else if((month == 1 || month == 3 || month == 5 || month == 7 ||month == 8 || month == 10 ||month == 12) && 1 <= day && day <= 31) {
            return true;
        }
        return false;
    }

    public static void main (String[] args) {
        int someMonth, someDay;
        int laterMonth, laterDay;
        int aMonth;

        if((isValidDate(Integer.parseInt(args[1]), Integer.parseInt(args[0])))
                && isValidDate(Integer.parseInt(args[3]), Integer.parseInt(args[2]))){

            someMonth = Integer.parseInt(args[0]);
            someDay = Integer.parseInt(args[1]);
            laterMonth = Integer.parseInt(args[2]);
            laterDay = Integer.parseInt(args[3]);
        }else{
            throw new IllegalArgumentException("Invalid date");
        }

        /* Used to record what day in the year the first day  */
        /* of someMonth and laterMonth are. */
        int someDayInYear = 0;
        int laterDayInYear = 0;

        for (aMonth = 1; aMonth < someMonth; aMonth++) {
            someDayInYear += daysInMonth(aMonth);
        }

        for (aMonth = 1; aMonth < laterMonth; aMonth++) {
            laterDayInYear += daysInMonth(aMonth);
        }

        int daysBetween = (laterDayInYear + laterDay) - (someDayInYear + someDay);

        if(laterMonth < someMonth || laterMonth == someMonth && laterDay < someDay) {
            daysBetween += 365;
        }

        System.out.println("The difference in days between " +
                someMonth + "/" + someDay + " and " +
                laterMonth + "/" + laterDay + " is: ");

        System.out.println(daysBetween);
    }
}
