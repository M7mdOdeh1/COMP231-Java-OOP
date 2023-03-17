package finalproject;

public class Album extends Media implements Comparable<Media> {
	
	protected String artist;
	protected String songs;
	
	public Album(String code, String title,int no_of_copies, String artist, String songs) {
		super(code, title, no_of_copies);
			
		this.artist = artist;
		this.songs = songs;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSongs() {
		return songs;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Album [code=" + code + ", title=" + title + ", no_of_copies=" + no_of_copies + ", artist=" + artist
				+ ", songs=" + songs + "]";
	}

	@Override
	public int compareTo(Media o) {
		return this.title.compareTo(o.getTitle());
	}
		

}
