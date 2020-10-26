/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vipclients;

import static vipclients.VIPClients.ps;

/**
 *
 * @author Esther
 */
public class Song {
    public String track;
    public Song next;


    //constructor of Song
    public Song(String track) {
        this.track = track;      
        next = null;
        
    }
    
    //displays the artist and their info
    public void displaySong() throws Exception{
        ps.println(track);
    }
    
    class playlistQueue{
    
    //private Song first; //link to the first element
    private Song[] queueArray;
    private int queueSize; // will track size of queue
    private int front, rear, songsInQueue = 0;
    
    //constructor, sets first to null
    public void playlistQueue(){
    //rear= null;
    queueSize = 100;
    }
    
    //returns true if list is empty
    //public boolean isEmpty(){
        //return (front == null);
        
    //}
    //adds a node to the linked list
    public void addSong(String track){
        if (songsInQueue +1 <= queueSize){        
            Song newQueue = new Song(track); // creates new link
            queueArray[rear] = newQueue;
            rear++;
            songsInQueue ++;
        //newQueue.next = first; //changes the new link's next reference
        //first = newLink; // references the new link
        //queueSize++; //adds to count size of link
        } else{
            ps.println("The queue is full.");
        }
    }
    
    //deletes first link
    public void listenToSong(){
        if (songsInQueue > 0){
            ps.println(peek());
            queueArray [front] = null;
            front++;
        } else{
            ps.println("Queue empty.");
        }
        
    }
    
    public Song peek(){
        return queueArray[front];
    }
       
}
}
