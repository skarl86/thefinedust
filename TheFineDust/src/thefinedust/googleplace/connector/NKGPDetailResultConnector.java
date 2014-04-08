/**
 * @FileName 	: NKGPDetailResultConnector.java
 * @Project 	: TheFineDust
 * @Date 		: 2014. 4. 7.
 * @Author 		: NCri
 */
package thefinedust.googleplace.connector;

/**
 * @Class		: NKGPDetailResultConnector
 * @Date 		: 2014. 4. 7.
 * @Author 		: NCri
 */
// Result JSON Data Sample
// https://maps.googleapis.com/maps/api/place/details/json?reference=CoQBcQAAAHeJ66X181u0skwu3McrSbpXKjf6EpbB3V2ygeeQXJlJYW5fjYamwarkHnkyD7A8hZQpBTAxwzw8b4_ToSkoVs9K5mW0-a22Y9WIGc0BbeGAEAzXpTX559TXKKKykzC_4457nsVx3zKB1xh9H4H1-8YXHl_cawynv7_Q_ZTd8zg4EhCs5vvARFn6-zDXWtn3DQj6GhTB60go1hSsSxDw12l8bzgAF_KX5g&sensor=true&language=ko&key=AIzaSyCJQXicui49gzhAwbGWGmm3OJEpKPjUeJE

// 
// https://maps.googleapis.com/maps/api/place/details/json?reference=레퍼런스값&sensor=true&language=ko&key=키
// https://maps.googleapis.com/maps/api/place/textsearch/json?query=키워드&sensor=true&language=ko&key=키
// https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=레퍼런스&sensor=true&key=키
public class NKGPDetailResultConnector extends NKGPConnector{
	/**
	 * @param keyword
	 */
	public NKGPDetailResultConnector(String ref) {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see thefinedust.googleplace.connector.NKGPConnector#connection()
	 */
	@Override
	public void connection() {
		// TODO Auto-generated method stub
		
	}
}
