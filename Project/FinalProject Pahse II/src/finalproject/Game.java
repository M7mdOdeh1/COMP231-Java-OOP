package finalproject;

public class Game extends Media implements Comparable<Media> {

	protected double weight;
	
	public Game(String code, String title, int no_of_copies, double weight) {
		super(code, title, no_of_copies);
		
		this.weight = weight;
		
	}

	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}


	@Override
	public String toString() {
		return "Game [code=" + code + ", title=" + title + ", no_of_copies=" + no_of_copies + ", weight=" + weight
				+ "]";
	}


	@Override
	public int compareTo(Media o) {
		return this.title.compareTo(o.getTitle());
	}
	
	
	
	
}
