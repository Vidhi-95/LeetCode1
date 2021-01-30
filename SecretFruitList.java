public class SecretFruitList{

// DOES NOT PASS ALL TEST CASES

public static void main(String[] args) {
        System.out.println(matchSecretLists(Arrays.asList(
                Arrays.asList("apple", "apple")),
                Arrays.asList("apple", "apple")));
        System.out.println(matchSecretLists(Arrays.asList(
                Arrays.asList("anything")),
                Arrays.asList("apple", "apple", "apple", "banana")));
    }


public static boolean matchSecretLists(List<List<String>> secretFruitList, List<String> customerPurchasedList) {
//        Start at 0 index for both the code list and shopping cart.
        int cartIdx = 0, codeIdx = 0, totalCart = customerPurchasedList.size(), totalCodes = secretFruitList.size();
        while (cartIdx < totalCart && codeIdx < totalCodes) {
            String cur = customerPurchasedList.get(cartIdx);
//            If the first fruit of the secretFruitList is anything or if it matches the current fruit at the cart idx.
            if ((secretFruitList.get(codeIdx).get(0).equals("anything") || secretFruitList.get(codeIdx).get(0).equals(cur)) &&
                    hasOrder(customerPurchasedList, cartIdx, secretFruitList.get(codeIdx))) {
                cartIdx += secretFruitList.get(codeIdx++).size();
            } else {
                cartIdx++;
            }
        }
//        If the all the secretFruitList is present then return 1, else 0.
        return codeIdx == secretFruitList.size();
    }

    private static boolean hasOrder(List<String> customerPurchasedList, int idx, List<String> order) {
//        Loop through the secretFruitList to check if the fruits are in order.
        for (String s : order) {
            if (idx < customerPurchasedList.size() && (s.equals("anything") || customerPurchasedList.get(idx).equals(s))) {
                idx++;
            } else {
                return false;
            }
        }
        return true;
    }
}