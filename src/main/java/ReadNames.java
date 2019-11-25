import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;

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
        for(int i = 1; i <= 14; i++) {
            Document document;
            final String url = "https://www.behindthename.com/names/usage/english/";
            document = Jsoup.connect(url+i).get();
            Elements urlNames = document.select("[class=listname]");
            for(Element element : urlNames) {
                String res = element.getElementsByTag("a").text().toLowerCase();
                res = (Character.toString(res.charAt(0))).toUpperCase()+res.substring(1);
                namesBuffer.add(res);
            }
        }
    }
}


