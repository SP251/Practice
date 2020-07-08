import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Map<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "Surekha");
		hm.put(15, "Srikanth");
		hm.put(2, "Bindu");
		hm.put(12, "Siddhu");
		System.out.println(hm);
		
		String value = hm.get(3);
		System.out.println("Value: " + value);
		
		for(Map.Entry<Integer, String> entry: hm.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		//hm.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		
		
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>();
		lhm.put(102, "Bindu");
		lhm.put(101, "Surekha");
		lhm.put(104, "Nagarjuna");
		
		Book b1 = new Book(101, "Let us C", "Yaswant Kanetkar", "BPB", 8);
		Book b2 = new Book(102, "Data Communicatiosn & Networking", "Forouzan", "Mc Graw Hill", 8);
		Book b3 = new Book(103, "Operating Systems", "Galvin", "Wiley", 8);
		
		Map<Integer, Book> map  = new HashMap<Integer, Book>();
		map.put(2, b2);
		map.put(1, b1);
		map.put(3, b3);
		
		for (Map.Entry<Integer, Book> entry : map.entrySet()) {
			int key = entry.getKey();
			Book b = entry.getValue();
			System.out.println(key+" Details: ");
			System.out.println(b.id + " :" + b.name + " :" + b.author + " :" + b.publisher + " :" + b.quantity);
		}
	}

}
