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
		, Keliones("/keliones")
		, Pradža("/");
		
		private final String itemurl;
		
		Menu( String url ) {
			this.itemurl = url;
		}
		
		public String itemurl() {
			return this.itemurl;
		}
		
	}

	

