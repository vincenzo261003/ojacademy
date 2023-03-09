import java.util.HashMap;
import java.util.HashSet;

public class Hashmap{

	public static void main(String[] args) {
		
//		HashMap<Integer, String> elenco = new HashMap<>();
//		
//		elenco.put(5, "Cinque");
//		elenco.put(2, "Due");
//		elenco.put(16, "Sedici");
//		
//		System.out.println(elenco.get(16));
//		System.out.println(elenco);
		
		
		HashSet<String> el = new HashSet<>();
		el.add("BMW");
		el.add("Lamborghini");
		el.add("BMW");
		
		System.out.println(el);
		System.out.println(el.contains("Lamborghini"));
		
		if (el.contains("Lamborghini"))
			el.remove("Lamborghini");
		
		System.out.println(el.contains("Lamborghini"));
		
	}

}
