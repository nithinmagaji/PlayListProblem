package com.testvagrant;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

/**
 * @author nithin.k
 *
 */
public class PlayList {

	@Test
	public void testvagrantCodingTest() {
		// Creating a scanner instance for user inputs
		Scanner scan = new Scanner(System.in);
		// User inputs size of the playlist
		System.out.println("Enter Playlist Size  -> ");
		int numOfSongsInPlaylist = scan.nextInt();
		// User inputs unique songs for the playlist
		String[] arrayOfTheSongs = new String[numOfSongsInPlaylist];
		int songListCounter = 0;
		while (songListCounter <= arrayOfTheSongs.length - 1) {
			System.out.println("Enter Song " + songListCounter + " -> ");
			String temp = scan.next();
			while (Arrays.toString(arrayOfTheSongs).contains(temp)) {
				System.out.println(
						"Song is already on the list Please Enter a different Song " + songListCounter + " -> ");
				temp = scan.next();
			}
			arrayOfTheSongs[songListCounter] = temp;
			songListCounter++;
		}
		// Playlist is converted to a Linked list
		List<String> listOfTheSongs = new LinkedList<String>(Arrays.asList(arrayOfTheSongs));
		System.out.println("Songs Present in the Playlist -> " + listOfTheSongs.toString());

		// User inputs
		System.out.println("Enter the Song -> ");
		String newSong = scan.next();
		if (listOfTheSongs.contains(newSong)) {
			listOfTheSongs.remove(newSong);
			listOfTheSongs.add(newSong);
		} else {
			listOfTheSongs.remove(0);
			listOfTheSongs.add(newSong);
		}
		System.out.println("Songs Present in the Playlist -> " + listOfTheSongs.toString());
		scan.close();

		// Tests are conducted below to check if the latest song played is stored in the
		// last position of the playlist
		assertTrue(listOfTheSongs.contains(newSong), "Playlist doesnt contain the New Song");
		assertEquals(listOfTheSongs.indexOf(newSong), listOfTheSongs.size() - 1,
				"Playlist doesnt contain the New Song in the expected position");
	}
}