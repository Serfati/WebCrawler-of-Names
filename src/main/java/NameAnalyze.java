import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.exit;

public class NameAnalyze {

    public static void main(String[] args) throws Exception {
        ReadNames rn = new ReadNames();
        Parser parser = new Parser(rn.getNamesBuffer());
        if (rn.getNamesBuffer().size() <= 0)
            exit(1);
        switch(args[0]) {
            case "CountSpecificString":
                parser.countSpecificString(args[1]);
                break;
            case "CountAllStrings":
                parser.countAllStrings(Integer.parseInt(args[1]));
                break;
            case "CountMaxString":
                parser.countMaxString(Integer.parseInt(args[1]));
                break;
            case "AllIncludesString":
                parser.allIncludesString(args[1]);
                break;
            case "GenerateName":
                parser.generateName();
                break;
            default:
                throw new Exception("Invalid Usage");
        }
    }

    /**
     * WebCrawler - scan site's source code to obtain a list of first names
     * Source URL: https://www.behindthename.com/names/usage/english
     */
    static class ReadNames {
        private LinkedList<String> namesBuffer;

        /**
         * c'tor
         */
        ReadNames() {
            namesBuffer = new LinkedList<>();
            try {
                readNamesFromUrl();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        LinkedList<String> getNamesBuffer() {
            return namesBuffer;
        }

        /**
         * Reads all names source code to obtain a list of first names
         *
         * @throws IOException - Jsoup use
         */
        private void readNamesFromUrl() throws IOException {
            for(int i = 1; i <= 14; i++) {
                Document document;
                final String url = "https://www.behindthename.com/names/usage/english/";
                document = Jsoup.connect(url+i).get();
                Elements urlNames = document.select("[class=listname]");
                for(Element element : urlNames) {
                    String res = element.getElementsByTag("a").text().toLowerCase();
                    res = (Character.toString(res.charAt(0))).toUpperCase()+res.substring(1);
                    res = res.replaceAll("[(0-9)]", "").trim();
                    if (!namesBuffer.contains(res) && res.matches("[a-zA-Z ]+"))
                        namesBuffer.add(res);
                }
            }
        }
    }

    /**
     * The parser of first names
     */
    static class Parser {

        private LinkedList<String> names;

        /**
         * ctor
         *
         * @param namesBuffer - LinkedList of names
         */
        Parser(LinkedList<String> namesBuffer) {
            this.names = namesBuffer;
        }

        /**
         * get Keys By Value
         * The idea is to iterate over this entry-set
         * and return the key for which the value matches the supplied value:
         *
         * @param map   - Map interface of Java Collections
         * @param value - value
         * @param <K>   - key type
         * @param <V>   - value type
         * @return - Stream the key for which the value matches the supplied value
         */
        private static <K, V> Set<K> getKeysByValue(Map<K, V> map, V value) {
            return map.entrySet()
                    .stream()
                    .filter(entry -> Objects.equals(entry.getValue(), value))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toSet());
        }

        /**
         * Command 1 - counts the occurrences of a particular string in a list strings
         * (without repetitions in the same string and with a reference to capital letters
         *
         * @param arg string which was chosen for the scan
         */
        void countSpecificString(String arg) {
            int result = (int) this.names.stream().filter(name -> name.contains(arg)).count();
            System.out.println(result);
        }

        /**
         * Command 2 - counts all strings in a chosen size of @length the names list
         *
         * @param length - chosen size
         */
        void countAllStrings(int length) {
            HashMap<String, Integer> result = getSubstrings(length, true);
            for(Map.Entry<String, Integer> entry : Objects.requireNonNull(result).entrySet()) {
                System.out.println(entry.getKey()+":"+entry.getValue().toString());
            }
        }

        /**
         * Command 3 - returns the n-size string that appears most frequently in all names
         * without reference to capital letters
         *
         * @param length chosen size for substrings
         */
        void countMaxString(int length) {
            int maxValue = 0;
            HashMap<String, Integer> result = getSubstrings(length, false);
            for(Map.Entry<String, Integer> entry : Objects.requireNonNull(result).entrySet())
                maxValue = Math.max(maxValue, entry.getValue());
            System.out.println(getKeysByValue(result, maxValue)+":"+maxValue);
        }

        /**
         * Command 4 -
         * prints all names which are included in the input string without reference to capital letters
         *
         * @param arg input string to check
         */
        void allIncludesString(String arg) {
            String toCheck = arg.toLowerCase();
            this.names.stream().filter(name -> toCheck.contains(name.toLowerCase())).map(String::toLowerCase).forEach(System.out::println);
        }

        /**
         * Command 5 -
         */
        private void generateName() {
            System.out.println(":(");
        }

        /**
         * counts all substring in the chosen size in a current string
         *
         * @param length        chosen size
         * @param caseSensitive two cases option
         */
        private HashMap<String, Integer> getSubstrings(int length, boolean caseSensitive) {
            HashMap<String, Integer> result = new HashMap<>();
            LinkedList<String> subStringsForName;
            for(String name : names) {
                if (!caseSensitive)
                    name = name.toLowerCase();
                subStringsForName = subStrings(name, length);
                for(String subName : subStringsForName) {
                    Integer curr = result.getOrDefault(subName, 0);
                    result.put(subName, curr+1);
                }
            }
            return result;
        }

        /**
         * subStrings
         *
         * @param str    - to check
         * @param length - of substring to gen
         * @return - LL of substring in len of @length
         */
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
}