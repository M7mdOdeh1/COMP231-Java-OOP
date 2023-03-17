package finalproject;

public abstract class Media {
	
	protected String code;
	protected String title;
	protected int no_of_copies;


	public Media(String code, String title, int no_of_copies) {
		this.code = code;
		this.title = title;
		
		if(no_of_copies < 0)     //throw an error if number of copies is negative
			throw new IllegalArgumentException("number of copies cannot be negative");
		else
			this.no_of_copies = no_of_copies;
		
	}

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getNo_of_copies() {
		return no_of_copies;
	}


	public void setNo_of_copies(int no_of_copies) {
		this.no_of_copies = no_of_copies;
	}
	
	public boolean equals(Object obj) {
		return this.title== ((Media)obj).getTitle();
	}
	
	public abstract String toString();

	
	

	


}