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
            if (name.contains(arg)) result++;
        System.out.println(result);
    }

    /*  -------- 2nd method ------- */
    void countAllStrings(int length) {
        HashMap<String, Integer> result = getSubstrings(length);
        for (Map.Entry<String,Integer> entry:
                Objects.requireNonNull(result).entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue().toString());
        }
    }

    /*  -------- 3rd method ------- */
    void countMaxString(int length) {

    }

    /*  -------- 4th method ------- */
    void allIncludesString(String arg) {
        String toCheck = arg.toLowerCase();
        for (String name : this.names) {
            if (toCheck.contains(name.toLowerCase()))
                System.out.println(name.toLowerCase());
        }
    }
    /*  -------- 5th method ------- */
    void generateName() {

    }

    private boolean isValidName(String name) {
        String validPattern = "[a-zA-Z -]+";
        return name.matches(validPattern);
    }

    private HashMap<String, Integer> getSubstrings(int length) { //TODO
    return null;
    }
}
