import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class datetime {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Date: " + today);
        String year = today.getYear() +"";
        System.out.println("Year: " + year);
        String month = today.getMonth() +"";
        System.out.println("Month: "+ month);
        String day = today.getDayOfMonth()+"";
        System.out.println("Day: "+day);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your birth date: ");
        String ans = sc.nextLine();
        LocalDate birthdate = LocalDate.parse(ans);
        Period diff = Period.between(birthdate, today);
        String age =diff.getYears()+"";
        System.out.println("You are " + age +" years old.");

        System.out.print("Enter your birthday: ");
        ans=sc.nextLine();
        birthdate = LocalDate.parse(ans);
        LocalDate days = birthdate.withYear(today.getYear());
        if (days.isBefore(today) || days.isEqual(today)) {
            days = days.plusYears(1);
        }
        int test =(int) ChronoUnit.DAYS.between(today, days);
        System.out.println("Days until your next birthday: "+test);
    }
}
