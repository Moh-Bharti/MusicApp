import java.io.*;
import java.lang.*;
import java.util.*;



class Song implements Serializable{
	String name;
	String Singer;
	int duration;
	Song(String name,String Singer,int duration){
		this.name=name;
		this.Singer=Singer;
		this.duration=duration;
	}
}
public class playlist {

	public static void main(String[] args){
		
		
		
		
		
		
		
		
	}
	
	public static void add(Song a)throws IOException{
		ObjectOutputStream out=null;
		try{
			out=new ObjectOutputStream(new FileOutputStream("Output.txt"));
			out.writeObject(a);
		}finally{
		out.close();}
		
		
	}
	public static void delete(Song b)throws IOException,ClassNotFoundException{
		List<Song>Songs=new ArrayList<Song>();
	}
	public static void dispaly()throws IOException,ClassNotFoundException{
		List<Song>Songs=new ArrayList<Song>();
		
	}
	
	
	
	
}
