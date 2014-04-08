/**
 * @FileName 	: NKGPResultConnector.java
 * @Project 	: TheFineDust
 * @Date 		: 2014. 4. 8.
 * @Author 		: NCri
 */
package thefinedust.googleplace.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import thefinedust.googleplace.NKGPResult;
import thefinedust.util.TFDUtil;

/**
 * @Class : NKGPResultConnector
 * @Date : 2014. 4. 8.
 * @Author : NCri
 */

// Result JSON Data Sample
// https://maps.googleapis.com/maps/api/place/textsearch/json?query=%EC%8B%9D%EB%8B%B9+%ED%99%8D%EB%8C%80&sensor=true&language=ko&key=AIzaSyCJQXicui49gzhAwbGWGmm3OJEpKPjUeJE
// https://maps.googleapis.com/maps/api/place/textsearch/json?query=키워드&sensor=true&language=ko&key=키
public class NKGPResultConnector extends NKGPConnector {
	private String _keyword = null;

	/**
	 * @param keyword
	 */
	public NKGPResultConnector(String keyword) {
		// Type이 없으면 json 형태로.
		_returnDataType = "json";
		_function = "textsearch";

		// 공백 처리해줘야됨.
		_keyword = TFDUtil.string2url(keyword);
	}
	
	public void connection() {
		try {
			// GooglePlace API 호출 주소를 초기화.
			_apiUrl = new URL(_BASE_URL + _function + "/" + _returnDataType
					+ "?query=" + _keyword + "&sensor=true&language=ko&key="
					+ _API_KEY);
			_urlConnection = _apiUrl.openConnection();
			_urlConnection.connect();

			// GooglePlace API Query에서 전달받은
			// JSON데이터를 맴버에 저장.
			_jsonData = new BufferedReader(new InputStreamReader(
					_urlConnection.getInputStream()));

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// TEST METHOD
	public void print() throws IOException {
		JSONParser jsonParser = new JSONParser();
		try {
			JSONObject jsonObject = (JSONObject) jsonParser.parse(_jsonData);
			JSONArray array = (JSONArray) jsonObject.get(_RESULT);
			Iterator i = array.iterator();
			while (i.hasNext()) {
				JSONObject obj = (JSONObject) i.next();
				System.out.println(obj);
				NKGPResult gp = new NKGPResult(obj);
				System.out.println(gp);
				gp.getGeometry();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		NKGPResultConnector gp = new NKGPResultConnector("홍대 식당");
		gp.connection();
		try {
			gp.print();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
