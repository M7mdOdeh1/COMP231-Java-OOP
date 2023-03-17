package finalproject;


public class Movie extends Media implements Comparable<Media> {

	protected String rating;
	

	public Movie(String code, String title, int no_of_copies, String rating) {
		super(code, title, no_of_copies);
		
		String r= rating.toUpperCase();
		if(!r.equals("DR") && !r.equals("HR") && !r.equals("AC") ) //throw an error if rating doesn't match the possible rating  
			throw new IllegalArgumentException("Invlid input");
		else
			this.rating = rating;	
	}

	
	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Movie [code=" + code + ", title=" + title + ", no_of_copies=" + no_of_copies + ", rating=" + rating
				+ "]";
	}


	@Override
	public int compareTo(Media o) {
		return this.title.compareTo(o.getTitle());
	}
	
	
	
	
	
	
	
	
	
}
