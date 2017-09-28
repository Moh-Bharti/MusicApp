import java.io.*;
import java.lang.*;
import java.util.*;


class NoSuchSongException extends Exception{
	static final long serialVersionUID=4L;
	String str;
	NoSuchSongException(String st){
		super(st);
	}
}
class Song implements Serializable{
	String name;
	String Singer;
	int duration;
	static final long serialVersionUID=4L;
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
	public static void delete(String b)throws NoSuchSongException,IOException,ClassNotFoundException,OptionalDataException{
		List<Song>Songs=new ArrayList<Song>();
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("Input.txt"));
		
		try{
			while(true){
				
				Songs.add((Song)in.readObject());
				}
			
		}catch(OptionalDataException e ){
			if(!e.eof){
				throw e;
			}
		}finally{
			in.close();
		}
		
		while(Songs.iterator().next()!=null){
			if(Songs.iterator().next().name.equals(b)==false){
				throw new NoSuchSongException("Song is not there");
			}
		}
		while(Songs.iterator().next()!=null){
			Song tree=Songs.iterator().next();
			if(tree.name.equals(b)){
				Songs.remove(tree);
			}
		}
		while(Songs.iterator().next()!=null){
			Song musix=Songs.iterator().next();
			ObjectOutputStream out=null;
			try{
				out=new ObjectOutputStream(new FileOutputStream("Output.txt"));
				out.writeObject(musix);
			}finally{
			out.close();}
		}
		
	}
	public static void dispaly()throws IOException,ClassNotFoundException{
		List<Song>Songs=new ArrayList<Song>();
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("Input.txt"));
		try{
			while(true){
				Song h=(Song)in.readObject();
				Songs.add(h);
				
			}
		}catch(OptionalDataException e){
			if(!e.eof){
				throw e;
			}
		}finally{
			in.close();
		}
		while(Songs.iterator().next()!=null){
			Song p=Songs.iterator().next();
			System.out.println(p.name+p.Singer+p.duration);
		}
		
		
	}
	
	
	
	
}
