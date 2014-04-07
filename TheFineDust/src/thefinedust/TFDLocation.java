package thefinedust;
/**
 * 
 * @Class		: TFDLocation
 * @Date 		: 2014. 4. 7.
 * @Author 		: NCri
 */
public class TFDLocation {
	public double _latitude;
	public double _longitude;
	
	public TFDLocation(){}
	
	public TFDLocation(String lat, String lng){
		Double dLat = Double.valueOf(lat);
		Double dLng = Double.valueOf(lng);
		
		_latitude = dLat.doubleValue();
		_longitude = dLng.doubleValue();
	}
	public TFDLocation(Double lat, Double lng){
		_latitude = lat.doubleValue();
		_longitude = lng.doubleValue();
	}
	public TFDLocation(double lat, double lng){
		_latitude = lat;
		_longitude = lng;
	}
}
