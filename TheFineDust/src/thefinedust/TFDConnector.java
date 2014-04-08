/**
 * @FileName 	: TFDConnector.java
 * @Project 	: TheFineDust
 * @Date 		: 2014. 4. 8.
 * @Author 		: NCri
 */
package thefinedust;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Class : TFDConnector
 * @Date : 2014. 4. 8.
 * @Author : NCri
 */
public class TFDConnector {
	
	protected URL _url = null;
	protected URLConnection _urlConnection = null;

	protected void _connection(String url) {
		try {
			// GooglePlace API 호출 주소를 초기화.
			_url = new URL(url);
			_urlConnection = _url.openConnection();
			_urlConnection.connect();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
