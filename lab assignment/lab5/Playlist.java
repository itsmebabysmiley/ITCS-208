// Name: Nopparat Pengsuk
// ID: 6288103

import java.util.ArrayList;



public class Playlist {

	private String name;
	private int duration;
	private ArrayList<Song> songs = new ArrayList<Song>();
	
	
	public Playlist(String name) {
		this.name = name;
	}

	
	public void addSong(Song aSong) {
		// Your code goes here
		songs.add(aSong);
		
	}
	
	public void addSongAtIndex(Song aSong, int index) {
		// Your code goes here
		if(index > songs.size()){
			System.out.println("Error : Couldn't add song at index "+index);
			
		}else songs.add(index, aSong);
		
	}
	
	public boolean removeSongByIndex(int index) {
		// Your code goes here
		if(index>songs.size()){
			System.out.println("Error : The index is invalid");
			return false;
		}
		songs.remove(index);
		return true;
	}	
	public boolean removeSongByTitle(String title) {
		int x = -1 ;
		// Your code goes here
		
		for (int i = 0; i < songs.size(); i++) {
			if(songs.get(i).getTitle()==title){
				x = i;
			}
		}
		if(x!=-1) songs.remove(x);
		else{
			System.out.println("Error : The title is not found");
			return false;
		}
		return true; 
	}
	
	public void moveUp(int current) {
		songs.add(current-1, songs.get(current));
		songs.remove(current+1);
		

		// Your code goes here
	}	
	
	public void moveDown(int current) {
		// Your code goes here
		 songs.add(current+2, songs.get(current));
		 songs.remove(current);
	}	
	
	public double getPlaylistDuration() {
		// Your code goes here
		double result = 0;
		for (int i = 0; i < songs.size(); i++) {
			result += songs.get(i).getDuration();
		}
		double x = result - (int)result;
		if(x>=0.60){
			result ++;
			result -= 0.60;
		}

		return result;
	}
	public void showPlaylist() {
		// Your code goes here
		System.out.println(name);
		for (int i = 0; i < songs.size(); i++){
			System.out.println("["+i+"] "+songs.get(i));
		}
		System.out.println("Total duration is "+String.format("%.2f", getPlaylistDuration())+" seconds");
		
		
		
		

	}
}



