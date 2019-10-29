package gathering;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex1 {
	public static void main(String[] args) throws Exception{
		String path =
				"https://image-comic.pstatic.net/webtoon/183559/453/20191004160044_e2c7c88acc66ed5981d9a2eee436b6c7_IMAG01_3.jpg";
		Document doc = (Document) Jsoup.connect(path).get();
		Elements elses = doc.select(".col_inner .thumb a img");
		
		
		Iterator<Element> li =elses.iterator(); 
		
		while(li.hasNext()) {
			Element target = li.next();
			
			String title = target.attr("title");
			String src = target.attr("src");
			Downloader downloader = new Downloader();
			downloader.download(path);
			
			System.out.println("tilte: "+title);
			System.out.println("src: "+src);
			System.out.println("------------------------------");
			
			
		}
	}
}
