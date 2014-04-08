/**
 * 
 * @FileName 	: NKGooglePlaces.java
 * @Project 	: TheFineDust
 * @Date 		: 2014. 4. 7.
 * @Author 		: NCri
 */

package thefinedust.googleplace.connector;

import java.io.BufferedReader;

import thefinedust.TFDConnector;


/**
 * 
 * @Class : NKGooglePlaces
 * @Date : 2014. 4. 7.
 * @Author : NCri
 */
public abstract class NKGPConnector extends TFDConnector {
	protected static String _API_KEY = "AIzaSyCJQXicui49gzhAwbGWGmm3OJEpKPjUeJE";
	protected static String _BASE_URL = "https://maps.googleapis.com/maps/api/place/";
	protected static String _RESULT = "results";

	protected String _function = null;
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
