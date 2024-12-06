/**
   Description: This program creates a class calleed GreatestAlbums and it uses ArrayList to store the specific details of 
                albums like rank, year, album name, and artist name. It provides methods like topAlbums,numberOfTopAlbum,
                and topInDecade to diplay the top albums, numbrs of top album by a particular artist , and list of top albums
                in a decade respectively.
  
*/


import java.io.File;
import java.io.IOException;
import java.util.*;
/*
 * The GreatestAlbums class represents a collection of ablbums from a file
 * It allows retreiving album details like year, artist's name, and album title
 * It shows the top album of album list
 * It shows the top albums of a partticular decade
 */

public class GreatestAlbums{
   private String filename;
   private List<Album> albumList = new ArrayList<>();
   
   /*
    * It constructs a GreatestAlbum object and collect albums from specific file
    * constructor takes filename as input and process the file through each line
    * each line must have rank, year, titile,and artist seperated by comma
    * an album objects is created and added to the albumList
    * @param filename is the name of file that contains the album data
    * throws IOException if there is issue with opeing and reading file.
    */
   public GreatestAlbums(String filename){
   this.filename = filename;
   try{
      Scanner scan = new Scanner(new File(this.filename));
      while (scan.hasNextLine()){
         String eachLine = scan.nextLine();
          try (Scanner in = new Scanner(eachLine)) {
              in.useDelimiter(",");
              String rank = in.next();
              String year = in.next();
              String title = in.next();
              String artist = in.next();
              Album album = new Album(year, title, artist);
              albumList.add(album);
            }
         }
         scan.close();
      } 
      
   catch(IOException e){
         e.getMessage();
      } 
      
   }
   
   /*
    * Returns a string containing the top n albums from the albumList
    * the methods retrives the informationof n top albums based on their rank
    * @param n the number of top albums from list to display
    * if number of list is smaller than n than it returns all the album otherwise it only return upto n albums
    * @return a well formatted stirng containing rank, year, album name, and artist name
    */
   public String topAlbums(int n){
      String album_Info = "";
      if (n <= albumList.size()){
         for (int i = 0; i < n; i++){
            Album album = albumList.get(i);
            album_Info += "Rank: " + (i+1) + " Year: " + album.getYear() + " Title: " + album.getName() + " Artist: " + album.getArtist() + ".\n";
          }
         return album_Info;
      } 
      else{
         for (int i = 0; i < albumList.size(); i++){
            Album album = albumList.get(i);
            album_Info += "Rank: " + (i+1) + " Year: " + album.getYear() + " Title: " + album.getName() + " Artist: " + album.getArtist() + ".\n";
         }
         return album_Info;
      }
   } 
   
   /*
    *  Retunrs the number of top albumms from particular artist
    * this method checks total number of album by a given arist regardless of case(lopwer ase, or upper case)
    * @param artist the name of artist 
    * @return the count of albums by that particular artist
    */
   public int numberOfTopAlbums(String artist){
      int count = 0;
      for (int i = 0; i < albumList.size(); i++){
         Album album = albumList.get(i);
         if (album.getArtist().equalsIgnoreCase(artist)){
            count ++;
         }
         
      }
      return count;
   }
   
   /*
    * Returns the top albums within a particular decade
    * this method filters albums from the albumList that were released in that particular decade
    * @param decade the Starting year of the decade
    * @retrun a string containig well formatted details of the album
    * @return the count fo the albums within that decade
    */
   public String topInDecade(int decade){
   int count = 0;
   String album_Info = "";
     for (int i = 0; i < albumList.size(); i++){
     Album album = albumList.get(i);
         if ((album.getYear() >= decade) && (album.getYear() <= decade +9)){
            count++;
            album_Info += "Rank: " + (i+1) + " Year: " + album.getYear() + " Title: " + album.getName() + " Artist: " + album.getArtist() + ".\n";
         }
      }
      return count +" albums\n" + album_Info;
   }
}