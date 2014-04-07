/**
 * 
 * @FileName 	: NKGooglePlaces.java
 * @Project 	: TheFineDust
 * @Date 		: 2014. 4. 7.
 * @Author 		: NCri
 */

package thefinedust.googleplace.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import thefinedust.googleplace.NKGPResult;
import thefinedust.util.TFDUtil;

/**
 * 
 * @Class		: NKGooglePlaces
 * @Date 		: 2014. 4. 7.
 * @Author 		: NCri
 */
public class NKGPConnector {
	private static String _API_KEY = "AIzaSyCJQXicui49gzhAwbGWGmm3OJEpKPjUeJE";
	
	private static String _NEXT_PAGE_TOKEN = 	"next_page_token";
	private static String _RESULT = 			"results";
	
	private URL _apiUrl = null;
	private URLConnection _urlConnection = null;
	private BufferedReader _jsonData = null;
	private String _returnDataType = null;

	public NKGPConnector(String keyword) {
		this(keyword, null);
	}

	/**
	 * 
	 * @param keyword
	 * @param type
	 */
	public NKGPConnector(String keyword, String type) {		
		// Type이 없으면 json 형태로.
		_returnDataType = type == null ? "json" : type;
		
		// 공백 처리해줘야됨.
		keyword = TFDUtil.string2url(keyword);

		try {
			// GooglePlace API 호출 주소를 초기화.
			_apiUrl = new URL(
					"https://maps.googleapis.com/maps/api/place/textsearch/"
							+ _returnDataType + "?query=" + keyword
							+ "&sensor=true&language=ko&key=" + _API_KEY);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @Method Name	: connection
	 * @date   		: 2014. 4. 7. 
	 * @author   	: NCri
	 * @Method desc :
	 */
	public void connection() {
		try {
			_urlConnection = _apiUrl.openConnection();
			_urlConnection.connect();

			// GooglePlace API Query에서 전달받은
			// JSON데이터를 맴버에 저장.
			_jsonData = new BufferedReader(new InputStreamReader(
					_urlConnection.getInputStream()));

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
			while(i.hasNext()){
				JSONObject obj = (JSONObject)i.next();
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
		NKGPConnector gp = new NKGPConnector("홍대 식당");
		gp.connection();
		try {
			gp.print();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
