package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Json05 {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		Language message = getLanguage("Stepover Toehold With Facelock");
		if (message != null) {
			System.out.println(message.documents[0].detectedLanguage.iso6391Name);
		}
	}

	static Language getLanguage(String s) throws IOException, URISyntaxException, InterruptedException {
		Gson gson = new Gson();

		String url = "https://r04jk3a17-text.cognitiveservices.azure.com/" + "text/analytics/v3.0/languages";
		Map<String, String> map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key", "a08fa165dec6423881c9cfbfb1e14c5b");

		Docs doc = new Docs();
		doc.id = "1";
		doc.text = s;

		Source src = new Source();
		src.documents = new Docs[1];
		src.documents[0] = doc;

		String jsonData = new Gson().toJson(src);
		//InetSocketAddress proxy = new InetSocketAddress("172.17.0.2", 80);

		JsonReader reader = WebApiConnector.postJsonReader(url,map, jsonData);
		Language message = null;
		if (reader != null) {
			message = gson.fromJson(reader, Language.class);
			reader.close();
		}
		return message;
	}

}

class Language {
	Documents[] documents;
	String[] errors;
	String modelVersion;
}

class Documents {
	DetectedLanguage detectedLanguage;
}

class DetectedLanguage {
	String name;
	String iso6391Name;
}

class Source {
	Docs[] documents;
}

class Docs {
	String id;
	String text;
}
