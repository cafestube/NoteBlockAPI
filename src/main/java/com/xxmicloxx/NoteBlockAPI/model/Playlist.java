package com.xxmicloxx.NoteBlockAPI.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Playlist {

	ArrayList<Song> songs = new ArrayList<>();
	
	public Playlist(Song ...songs){
		this.songs.addAll(Arrays.asList(songs));
	}
	
	/**
	 * Add array of {@link Song} to playlist
	 * @param songs
	 */
	public void add(Song ...songs){
		this.songs.addAll(Arrays.asList(songs));
	}
	
	/**
	 * Removes songs from playlist
	 * @param songs
	 * @throws IllegalArgumentException when you try to remove all {@link Song} from {@link Playlist}
	 */
	public void remove(Song ...songs){
		ArrayList<Song> songsTemp = new ArrayList<>();
		songsTemp.addAll(this.songs);
		songsTemp.removeAll(Arrays.asList(songs));
		if (songsTemp.size() > 0){
			this.songs = songsTemp;
		} else {
			throw new IllegalArgumentException("Cannot remove all songs from playlist");
		}
	}
	
	/**
	 * Get {@link Song} in playlist at specified index
	 * @param songNumber - song index
	 * @return
	 */
	public Song get(int songNumber){
		return songs.get(songNumber);
	}
	
	/**
	 * Get number of {@link Song} in playlist
	 * @return
	 */
	public int getCount(){
		return songs.size();
	}
	
	/**
	 * Check whether {@link Song} is not last in playlist
	 * @param songNumber
	 * @return true if there is another {@link Song} after specified index
	 */
	public boolean hasNext(int songNumber){
		return songs.size() > (songNumber + 1);
	}
	
	/**
	 * Check whether {@link Song} with specified index exists in playlist
	 * @param songNumber
	 * @return
	 */
	public boolean exist(int songNumber){
		return songs.size() > songNumber;
	}
}