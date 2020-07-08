import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo {

	public static void main(String[] args) {
		// demo();
		oddNumbers(2, 10);

	}

	private static void demo() {
		AprioriFrequentItemsetGenerator<String> generator = new AprioriFrequentItemsetGenerator<>();

		List<Set<String>> itemsetList = new ArrayList<>();

		itemsetList.add(new HashSet<>(Arrays.asList("Corn", "Lettuce", "Cheese")));
		itemsetList.add(new HashSet<>(Arrays.asList("Corn", "Lettuce", "Oil")));
		itemsetList.add(new HashSet<>(Arrays.asList("Corn", "Sugar", "Cheese")));
		itemsetList.add(new HashSet<>(Arrays.asList("Corn", "Sugar", "Cheese")));
		itemsetList.add(new HashSet<>(Arrays.asList("Butter", "Sugar", "Cake")));
		itemsetList.add(new HashSet<>(Arrays.asList("Butter", "Lettuce", "Cheese")));
		itemsetList.add(new HashSet<>(Arrays.asList("Corn", "Sugar", "Cheese")));
		itemsetList.add(new HashSet<>(Arrays.asList("Corn", "Lettuce", "Cheese")));
		itemsetList.add(new HashSet<>(Arrays.asList("Cream", "Bun", "Oil")));
		itemsetList.add(new HashSet<>(Arrays.asList("Corn", "Lettuce", "Cheese")));

		long startTime = System.nanoTime();
		FrequentItemsetData<String> data = generator.generate(itemsetList, 0.20);
		long endTime = System.nanoTime();

		int i = 1;

		System.out.println("--- Frequent itemsets ---");

		for (Set<String> itemset : data.getFrequentItemsetList()) {
			System.out.printf("%2d: %9s, support: %1.1f\n", i++, itemset, data.getSupport(itemset));
		}

		System.out.printf("Mined frequent itemset in %d milliseconds.\n", (endTime - startTime) / 1_000_000);

		startTime = System.nanoTime();
		List<AssociationRule<String>> associationRuleList = new AssociationRuleGenerator<String>()
				.mineAssociationRules(data, 0.80);
		endTime = System.nanoTime();

		i = 1;

		System.out.println();
		System.out.println("--- Association rules ---");

		for (AssociationRule<String> rule : associationRuleList) {
			System.out.printf("%2d: %s\n", i++, rule);
		}

		System.out.printf("Mined association rules in %d milliseconds.\n", (endTime - startTime) / 1_000_000);
	}

	static String findNumber(List<Integer> arr, int k) {
		String validInput = "NO";
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) == k) {
				validInput = "Yes";
				break;
			}
		}
		return validInput;
	}

	static List<Integer> oddNumbers(int l, int r) {
		List<Integer> oddNum = new ArrayList<>();
		for (int i = l; i <= r; i++) {

			// if the number is not divisible by 2 then it is odd
			if (i % 2 != 0) {
				oddNum.add(i);
				System.out.print(i + " ");
			}
		}
		return oddNum;
	}

}