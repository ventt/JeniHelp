import java.util.Calendar;
import java.util.Date;

public class main {
        public static void main(String[] args) {
            Treemap AMapOsztaly = new Treemap();  //itt ugye letrehozom a Class-t amit elozoleg csinaltam
            AMapOsztaly.add(new Date(2022, Calendar.AUGUST, 4), "Esemeny 1"); //itt hozzadok par adatotz
            AMapOsztaly.add(new Date(2022, Calendar.AUGUST, 4), "Esemeny 2");
            AMapOsztaly.add(new Date(2022, Calendar.AUGUST, 12), "Esemeny 3");
            AMapOsztaly.printAll();
        }
}
