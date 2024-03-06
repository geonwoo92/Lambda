package crawler;

import common.AbstractRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CrawlerRepository extends AbstractRepository {
    private static CrawlerRepository instance = new CrawlerRepository();
    private Map<String, ?> map;

    private CrawlerRepository() {
        map = new HashMap<>();
    }

    public static CrawlerRepository getInstance() {
        return instance;
    }

    @Override
    public Map<String, ?> save(Map<String, ?> paramMap) throws IOException {
        Document doc = Jsoup.connect("https://music.bugs.co.kr/chart").timeout(10 * 1000).get();
        Elements elems = doc.select("table.byChart");
        Iterator<Element> title = elems.select("p.title").iterator();
        Iterator<Element> artist = elems.select("p.artist").iterator();
        Iterator<Element> rank = elems.select("strong").iterator();

        Map<String, Iterator<Element>> localMap = new HashMap<>();
        localMap.put("title", title);
        localMap.put("artist", artist);
        localMap.put("rank", rank);


        Document doc2 = Jsoup.connect("https://www.melon.com/chart/index.htm").timeout(10*1000).get();
        Elements elems2 = doc2.select("tbody");
        Iterator<Element> title2 = elems2.select("div.ellipsis.rank01 > span").iterator();
        Iterator<Element> artist2 = elems2.select("div.ellipsis.rank02 span").iterator();
        Iterator<Element> rank2 = elems2.select("td span.rank").iterator();
        localMap.put("title2", title2);
        localMap.put("artist2", artist2);
        localMap.put("rank2", rank2);

        map = localMap;
        return map;


    }
}