package thefinedust.navermap;

import java.util.Map;

import thefinedust.TFDGeometry;
import thefinedust.TFDLocation;
import thefinedust.TFDPlace;

public class TYNMResult extends TFDPlace {
	public final static String LAST_BUILD_DATE = "last_build_date";
	public final static String LINK = "link";
	public final static String DESCRIPTION = "description";
	public final static String ADDRESS = "formatted_address";
	public final static String GEOMETRY = "geometry";
	public final static String NAME = "name";
	public final static String TYPES = "types";
	public final static String TEL = "telephone";

	protected Object _last_build_date = null;
	protected Object _link = null;
	protected Object _description = null;

	public TYNMResult(Map<Object, Object> obj) {
		_address = obj.get(TYNMResult.ADDRESS);
		_geometry = obj.get(TYNMResult.GEOMETRY);
		_name = obj.get(TYNMResult.NAME);
		_tel = obj.get(TYNMResult.TEL);
		_types = obj.get(TYNMResult.TYPES);
		_last_build_date = obj.get(TYNMResult.LAST_BUILD_DATE);
		_link = obj.get(TYNMResult.LINK);
		_description = obj.get(TYNMResult.DESCRIPTION);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer("ADDR : " + _address + "\n");
		buffer = buffer.append("GEO : " + _geometry + "\n");
		buffer = buffer.append("NAME : " + _name + "\n");
		buffer = buffer.append("TEL : " + _tel + "\n");
		buffer = buffer.append("LINK : " + _link + "\n");
		buffer = buffer.append("TYPE : " + _types + "\n");
		buffer = buffer.append("LAST_DAY : " + _last_build_date + "\n");
		buffer = buffer.append("DESCR : " + _description + "\n");
		return buffer.toString();
	}
	
	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getGeometry() {
		// TODO Auto-generated method stub
		TFDGeometry geo = new TFDGeometry();
		Map<Object, Object> map = (Map<Object, Object>)_geometry;
		map = (Map<Object, Object>)map.get("location");
		geo.location = new TFDLocation((Double)map.get("lng"), (Double)map.get("lat"));
		_geometry = geo;
		return _geometry;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTell() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getTypes() {
		// TODO Auto-generated method stub
		return null;
	}
}
