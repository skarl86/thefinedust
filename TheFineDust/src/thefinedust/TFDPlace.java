package thefinedust;

/**
 * 
 * @Class		: TFDPlace
 * @Date 		: 2014. 4. 7.
 * @Author 		: NCri
 */
abstract public class TFDPlace {
	protected Object _address = null;
	protected Object _geometry = null;
	protected Object _name = null;
	protected Object _tell = null;
	protected Object _types = null;
	
	abstract public String getAddress();
	abstract public Object getGeometry();
	abstract public String getName();
	abstract public String getTell();
	abstract public Object getTypes();
	
	
}