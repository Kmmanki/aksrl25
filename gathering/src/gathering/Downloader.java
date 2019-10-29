package gathering;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class Downloader {
	String userAgent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36";
	public  void download(String path) throws Exception{
		
		URL url = new URL(path);
		HttpURLConnection myURLConnection = (HttpURLConnection)url.openConnection();
		
		myURLConnection.setRequestProperty
		("User-Agent:", userAgent);
		myURLConnection.setDoInput(true);
		myURLConnection.setDoOutput(true);
		
		int idx = path.lastIndexOf('/');
		String fname = path.substring(idx+1);
		InputStream in = myURLConnection.getInputStream();
		File file = new File("C:\\zzz");
		FileUtils.copyInputStreamToFile(in, file);
	}

}
