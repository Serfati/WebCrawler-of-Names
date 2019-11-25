import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

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

    /*  -------- 3rd method ------- */
    void countMaxString(int length) {//TODO
        HashMap<String, Integer> result = getSubstrings(length);

    }

    /*  -------- 4th method ------- */
    void allIncludesString(String arg) {
        String toCheck = arg.toLowerCase();
        for (String name : this.names) {
            if (toCheck.contains(name.toLowerCase()))
                System.out.println(name.toLowerCase());
        }
    }

    /*  -------- 5th method `BONUS` ------- */
    void generateName() {//TODO
    }

    private HashMap<String, Integer> getSubstrings(int length) { //TODO
    return null;
    }
}
