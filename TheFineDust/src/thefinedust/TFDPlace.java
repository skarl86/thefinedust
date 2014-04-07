package thefinedust;

import java.util.ArrayList;

/**
 * 
 * @Class		: TFDPlace
 * @Date 		: 2014. 4. 7.
 * @Author 		: NCri
 */
public class TFDPlace {
	protected Object _address = null;
	protected Object _geometry = null;
	protected Object _name = null;
	protected Object _tell = null;
	protected Object _types = null;
	/**
	 * @return the _address
	 */
	public String getAddress() {
		return (String)_address;
	}
	/**
	 * @return the _geometry
	 */
	public Object getGeometry() {
		return _geometry;
	}
	/**
	 * @return the _name
	 */
	public String getName() {
		return (String)_name;
	}
	/**
	 * @return the _tell
	 */
	public String getTell() {
		return (String)_tell;
	}
	/**
	 * @return the _types
	 */
	public Object getTypes() {
		return _types;
	}
	
	
}