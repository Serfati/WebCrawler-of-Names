<<<<<<< HEAD
import java.io.IOException;
import java.util.LinkedList;
=======
>>>>>>> c6eeedc... 25.11
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

<<<<<<< HEAD
=======
import java.io.IOException;
import java.util.LinkedList;

>>>>>>> c6eeedc... 25.11
class ReadNames {
    private LinkedList<String> namesBuffer;
    LinkedList<String> getNamesBuffer() {
        return  namesBuffer;
    }
    ReadNames() {
        namesBuffer = new LinkedList<>();
        try {
            readNamesFromUrl();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    private void readNamesFromUrl() throws IOException {
<<<<<<< HEAD
        for(int i = 1; i <= 14; i++) {
=======
        for(int i = 1; i <= 2; i++) {
>>>>>>> c6eeedc... 25.11
            Document document;
            final String url = "https://www.behindthename.com/names/usage/english/";
            document = Jsoup.connect(url+i).get();
            Elements urlNames = document.select("[class=listname]");
<<<<<<< HEAD
            for(Element element : urlNames)
                    namesBuffer.add(element.getElementsByTag("a").text());
=======
            for(Element element : urlNames) {
                String res = element.getElementsByTag("a").text().toLowerCase();
                res = (Character.toString(res.charAt(0))).toUpperCase()+res.substring(1);
                namesBuffer.add(res);
            }
>>>>>>> c6eeedc... 25.11
        }
    }
}


