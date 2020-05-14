package movie;

import java.util.ArrayList;
import java.lang.*;
public class movie {

	//private fileds
	private String name;
	private int year;
	private String category;
	private int current_votes;
	private String director;    //I added
	
	//constructor
	
	public movie(String name, int year, String category, int current_votes) {
	
		this.name = name;
		this.year = year;
		this.category = category;
		this.current_votes = current_votes;
	}
	//methods
	public void add_vote() {
		current_votes++;
	}
	
	public void remove_vote() {
		current_votes--;
	}
	
	public String getName() {   //I added
        return name;
    }

    public void setName(String name) { //I added
        this.name = name;
    }

    public String getDirector() {  //I added
        return director;
    }

    public void setDirector(String director) { //I added
        this.director = director;
    } 
    
    
    
	public void toString(String movie) {
		
		
		ArrayList <String> arrayOfDetails=new ArrayList <String>();
				
		arrayOfDetails.add("Name: "+ name);
		arrayOfDetails.add("Category: "+ category);
		//array.add(director);
		arrayOfDetails.add("Year: "+ Integer.toString(year));
		arrayOfDetails.add("Votes: "+Integer.toString(current_votes));
		for (int i=0;i<arrayOfDetails.size();i++) {
			System.out.println(arrayOfDetails.get(i));
		}
	}
}
