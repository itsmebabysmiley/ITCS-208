//https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
//https://docs.oracle.com/javase/7/docs/api/java/util/Set.html
//https://docs.oracle.com/javase/8/docs/api/java/util/List.html
import java.util.*;

/**
 * Set
 */
public class SetandList {
    public static void main(String[] args) {
        list();
        System.out.println();
        set(); //HashSet TreeSet LinkedHasSet
        System.out.println();
        map(); //HashMap TreeMap LinkedHashMap
        
        
        
    }

    public static void set() {
        System.out.println("###############  SET  ###############");
        System.out.println("-------------------Hashset------------------");
        System.out.println("It's a random set");
        Set<String> set = new HashSet<String>(); //Set<> set = new HashSet<>();
        set.add("Dog");
        set.add("Cat");
        set.add("Ant");
        set.add("Box");
        set.add("Dog");
        System.out.println("Hashset = "+ set);
        System.out.println("----------------LinkedHashSet---------------");
        System.out.println("It's a order set(ตามลำดับการเพิ่มข้อมูลลงเซ็ต)");
        Set<String> set4 = new LinkedHashSet<String>(set);
        System.out.println("LinkedHashSet = "+ set4);
        // set.contains(~set~);
        // System.out.println(set.containsAll(set3));

        System.out.println("-------------------TreeSet------------------");
        System.out.println("It's a sort set");
        Set<String> set3 = new TreeSet<String>(set);
        System.out.println("Treeset = "+ set3);
        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~Maybe useful~~~~~~~~~~~~~~~~~~~~~~");
        Set<String> setA = new HashSet<String>(Arrays.asList("1","2","3"));
        Set<String> setB = new HashSet<String>(Arrays.asList("2","3","4","5","6"));
        System.out.println("set A = "+setA);
        System.out.println("set B = "+setB);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();

        System.out.println("---------------------union------------------");
        Set<String> setC = new HashSet<String>(setA);
        setC.addAll(setB);
        System.out.println("set C(A u B) = "+setC+"(.addAll(~SET~)");
        System.out.println("-------------------intersec------------------");
        Set<String> setC2 = new HashSet<String>(setA);
        setC2.retainAll(setB);
        System.out.println("set C(A n B) = "+setC2+"(.retainAll(~SET~)");
        System.out.println("-------------------compement------------------");
        Set<String> setC3 = new HashSet<String>(setA);
        setC3.removeAll(setB);
        System.out.println("set C(A') = "+setC3+"(.removeAll(~SET~)");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // Set<String> set_isempty = new HashSet<>(set);
        // set_isempty.removeAll(set_isempty);
        // System.out.println("Set is empty: "+set_isempty);
        // set_isempty = set;
        // set_isempty.clear();
        // System.out.println("Set is empty: "+set_isempty);

    }

    public static void list() {
        System.out.println("############### LIST ###############");

        List<String> list = new ArrayList<String>(Arrays.asList("Dog", "Cat", "Ant", "Box", "Dog"));
        List<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(20);
        list2.add(30);
        System.out.println("List = " + list);
    }

    public static void map() {
        System.out.println("############### MAP ###############");
        Map<String, String> m = new HashMap<String, String>(); // <key,value>
        m.put("1", "one"); // .put(key,value)
        m.put("2", "two");
        m.put("3", "three");
        m.put("4", "four");
        System.out.println(m);
        System.out.println("change value in 2");
        m.put("2", "song");
        System.out.println(m);
        // m.containsKey(~key~);
        // m.containsValue(~key~);
    }

   
}
