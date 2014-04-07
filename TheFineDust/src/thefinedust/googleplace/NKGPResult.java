/**
 * @FileName 	: NKGooglePlace.java
 * @Project 	: TheFineDust
 * @Date 		: 2014. 4. 7.
 * @Author 		: NCri
 */
package thefinedust.googleplace;

import java.util.Map;

import thefinedust.TFDGeometry;
import thefinedust.TFDLocation;
import thefinedust.TFDPlace;

/**
 * @Class : NKGooglePlace
 * @Date : 2014. 4. 7.
 * @Author : NCri
 */
public class NKGPResult extends TFDPlace {
	// GooglePlace API Query JSON KEY
	public final static String ADDRESS = "formatted_address";
	public final static String GEOMETRY = "geometry";
	public final static String ICON = "icon";
	public final static String ID = "id";
	public final static String NAME = "name";
	public final static String OPENING = "opening_hours";
	public final static String PHOTOS = "photos";
	public final static String REFERENCE = "REFERENCE";
	public final static String TYPES = "types";

	// JSON Parsing 데이터의 클래스가 명확하지 않기때문에
	// 먼저 최상위 클래스인 Object형으로 전달 받고
	// getter에서 자료에 맞는 클래스 타입으로
	// casting해줘서 전달하는 형태.
	protected Object _icon = null;
	protected Object _id = null;
	protected Object _open = null;
	protected Object _photos = null;
	protected Object _reference = null;

	public NKGPResult(Map<Object, Object> obj) {
		_address = obj.get(NKGPResult.ADDRESS);
		_geometry = obj.get(NKGPResult.GEOMETRY);
		_icon = obj.get(NKGPResult.ICON);
		_id = obj.get(NKGPResult.ID);
		_name = obj.get(NKGPResult.NAME);
		_open = obj.get(NKGPResult.OPENING);
		_photos = obj.get(NKGPResult.PHOTOS);
		_reference = obj.get(NKGPResult.REFERENCE);
		_types = obj.get(NKGPResult.TYPES);
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
		buffer = buffer.append("ICON : " + _icon + "\n");
		buffer = buffer.append("ID : " + _id + "\n");
		buffer = buffer.append("NAME : " + _name + "\n");
		buffer = buffer.append("OPEN : " + _open + "\n");
		buffer = buffer.append("PHOTOS : " + _photos + "\n");
		buffer = buffer.append("REFER : " + _reference + "\n");
		buffer = buffer.append("TYPE : " + _types + "\n");
		return buffer.toString();
	}

	/* (non-Javadoc)
	 * @see thefinedust.TFDPlace#getGeometry()
	 */
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

	/**
	 * @return the _icon
	 */
	public Object getIcon() {
		return _icon;
	}

	/**
	 * @return the _id
	 */
	public String getID() {
		return (String) _id;
	}

	/**
	 * @return the _open
	 */
	public boolean isOpen() {
		Map<Object, Object> map = (Map<Object, Object>)_open;		
		return ((Boolean)map.get("open_now")).booleanValue();
	}

	/**
	 * @return the _photos
	 */
	public Object getPhotos() {
		return _photos;
	}

	/**
	 * @return the _reference
	 */
	public Object getReference() {
		return _reference;
	}

}
