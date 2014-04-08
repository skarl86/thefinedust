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
 * @Class : NKGooglePlaces
 * @Date : 2014. 4. 7.
 * @Author : NCri
 */
public abstract class NKGPConnector {
	protected static String _API_KEY = "AIzaSyCJQXicui49gzhAwbGWGmm3OJEpKPjUeJE";
	protected static String _BASE_URL = "https://maps.googleapis.com/maps/api/place/";
	protected static String _RESULT = "results";

	protected String _function = null;
	protected URL _apiUrl = null;
	
	protected URLConnection _urlConnection = null;
	protected BufferedReader _jsonData = null;
	protected String _returnDataType = null;
	
	/**
	 * @method Name	: connection
	 * @date   		: 2014. 4. 8. 
	 * @author   	: NCri
	 * @description :
	 */
	public abstract void connection();
	
}
