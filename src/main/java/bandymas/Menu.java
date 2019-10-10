/**
 * 
 */
package bandymas;

/**
 * @author User
 *
 */
public enum Menu {

		Klientai("/klientai")
		, Patiekalai("/patiekalai")
		, Pradžia("/");
		
		private final String itemurl;
		
		Menu( String url ) {
			this.itemurl = url;
		}
		
		public String itemurl() {
			return this.itemurl;
		}
		
	}

	

