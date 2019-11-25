import java.io.IOException;
import java.util.LinkedList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
            for(Element element : urlNames)
                    namesBuffer.add(element.getElementsByTag("a").text());
        }
    }
}


