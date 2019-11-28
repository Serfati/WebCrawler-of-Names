package main.java;
import java.util.*;
import java.util.stream.Collectors;

class Parser {

    private LinkedList<String> names;

    Parser(LinkedList<String> namesBuffer) {
        this.names = namesBuffer;
    }

    /*  -------- 1st method ------- */
    void countSpecificString(String arg) {
        int result = 0;
        for (String name : this.names)
            if (name.toLowerCase().contains(arg.toLowerCase())) result++;
        System.out.println(result);
    }

    /*  -------- 2nd method ------- */
    void countAllStrings(int length) {
        HashMap<String, Integer> result = getSubstrings(length); // ** ONLY need to implement getSubstrings(length) method
        for(Map.Entry<String, Integer> entry : Objects.requireNonNull(result).entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue().toString());
        }
    }

    private static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
        return map.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    /*  -------- 4th method ------- */
    void allIncludesString(String arg) {
        String toCheck = arg.toLowerCase();
        for(String name : this.names) {
            if (toCheck.contains(name.toLowerCase()))
                System.out.println(name.toLowerCase());
        }
    }

    /*  -------- 5th method `BONUS` ------- */
    void generateName() {//TODO
    }

    /*  -------- 3rd method ------- */
    void countMaxString(int length) {//TODO
        int maxValue = 0;
        HashMap<String, Integer> result = getSubstrings(length);
        for(Map.Entry<String, Integer> entry : Objects.requireNonNull(result).entrySet())
            maxValue = Math.max(maxValue, entry.getValue());
        System.out.println(getKeysByValue(result, maxValue)+":"+maxValue);
    }

    private HashMap<String, Integer> getSubstrings(int length) {
        HashMap<String, Integer> result = new HashMap<>();
        LinkedList<String> subStringsForName;
        for(String name : names) {
            name = name.toLowerCase();
            subStringsForName = subStrings(name, length);
            for(String subName : subStringsForName) {
                Integer curr = result.getOrDefault(subName, 0);
                result.put(subName, curr+1);
            }
        }
        return result;
    }

    private LinkedList<String> subStrings(String str, int length) {
        String res;
        LinkedList<String> ss = new LinkedList<>();
        for(int i = 0; i < str.length(); i++)
            for(int j = i+1; j <= str.length(); j++) {
                res = str.substring(i, j);
                if (res.length() == length)
                    ss.add(res);
            }
        return ss;
    }
}
