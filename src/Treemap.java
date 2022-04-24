import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

//Ennek a classnak persze nem ez a neve csak hat hogy ersd, tudod
public class Treemap {
    public static final String ANSI_RESET = "\u001B[0m"; //Ezzel ne foglalkozz
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    //Letrehozod az uj Map-od ami egy kulcshoz erteket kot, itt mivel egy datumra tobb esemeny lehet igy egy listat adunk neki
    TreeMap<Date, ArrayList<String>> map = new TreeMap<Date, ArrayList<String>>();
    //impelementalod az add-ot
    void add(Date date, String string){
            //Megnezzuk, hogy letezik-e a kulcs amivel hozzaakarjuk adni az esemenyt (Nezz utana: map.putIfAbsent();)
            if(!map.containsKey(date)){
                //Ha nem letezik meg a Map-ben ez a kulcs akkor leterhozunk egy uj listat amihez hozzaadjuk a Event stringet amit kaptunk
               ArrayList<String> newlist = new ArrayList<>();
               newlist.add(string);
               //aztan a kulcsot es a kesz listat berakjuk a map-be
               map.put(date,newlist);
               return;
            }
            //itt ugye mivel mar letezik a kulcs ezert a lista is, ezeltal a kulcs mutat mar egy listara ezert megkerdezzuk a kulcs cimen levo listat es hozzafuzzuk az uj adatot
            map.get(date).add(string);
    }
    //mondjuk get-eled az esemenyeket egy datumra es visszaadunk egy listat
    List<String> get(Date date){
        if(date != null){
            return map.get(date);
        }
        return null;
    }
    //ez itt bonyibb de kitalalod, csak kiirom az elemeket
    void printAll(){
        map.forEach((d,e) -> {
            StringBuilder string = new StringBuilder();
            string.append(ANSI_GREEN+"\nEsemenyek:\n"+ANSI_RESET);
            for (int i = 0; i < e.size(); i++) {
                string.append(e.get(i)).append("\n");
            }
            System.out.println(ANSI_BLUE+"Ev:"+d.getYear()+" Honap:"+d.getMonth()+" Nap:"+d.getDay()+ANSI_RESET+" "+string);
        });
    }
}
