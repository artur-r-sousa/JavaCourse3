package applications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapMain {

	public static void main(String[] args) {

		Map<Integer, String> cookies0 = new LinkedHashMap<>();
		Map<Integer, String> cookies1 = new TreeMap<>();
		Map<Integer, String> cookies2 = new HashMap<>();
		
		List<Map<Integer, String>> mapList = new ArrayList<>();
		
		cookies0.put(1, "Maria");
		cookies1.put(1, "Maria");
		cookies2.put(1, "Maria");
		int j = 0;
		
		for (int i = 0; i < 10 ; i ++) {	
			j++;
			cookies0.put(i, String.valueOf(j));		
		}
		
		mapList.add(cookies0);
		
		for (Object o : mapList) {
			System.out.println(o);
		}
		
		for (Integer key : cookies0.keySet()) {
			System.out.println(key + ": " + cookies0.get(key));
		}

	}

}
