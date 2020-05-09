package now.geextudio;

import com.google.common.collect.Lists;
import org.joda.time.LocalTime;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World of Java (Maven)!" );

        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);

        //List<String> dailySpecials = Lists.newArrayList("SaltyCaramel","CoconutChip","MauiMango");
        System.out.println("Today's specialsare:");
        /*  dailySpecials.forEach(s>System.out.println(""+s)); */

    }
}
