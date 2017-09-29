import java.io.*;
import java.lang.*;
import java.util.*;
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
 
    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
 
    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
 
    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
 
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    static float nextFloat() throws IOException{
    	return Float.parseFloat(next());
    }
}

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
 class playlist implements Serializable{
	 List<Song>Songs=new ArrayList<Song>();
	 static final long serialVersionUID=48L;
	 int count;
	 String str;
	 playlist(){
		 
	 }
	
	
	public  void add(Song a)throws IOException{
		Songs.add(a);
		
		displaynumber();
	}
	public  void delete(String b)throws NoSuchSongException,IOException,ClassNotFoundException,OptionalDataException{
		
		
		while(Songs.iterator().next()!=null){
			if(!Songs.iterator().next().name.equals(b)){
				throw new NoSuchSongException("Song is not there");
			}else{
				Song tree=Songs.iterator().next();
				if(tree.name.equals(b)){
					Songs.remove(tree);
				}
			}
		}
		
		displaynumber();
		
		
		
	}
	public  void show()throws IOException,ClassNotFoundException{
		
		Song p=Songs.iterator().next();
			if(p==null){
				System.out.println("No Song Exist");
			}else{
				while(p!=null){
					
			System.out.println(p.name+p.Singer+p.duration);}
		}
		
		
	}
	public  void search(String son)throws IOException,ClassNotFoundException,NoSuchSongException{
		
		
		while(Songs.iterator().next()!=null){
			if(!Songs.iterator().next().name.equals(son)){
				str="Song is not here";
				throw new NoSuchSongException(str);
			}
			if(Songs.iterator().next().name.equals(son)){
				str=Songs.iterator().next().name+Songs.iterator().next().duration+Songs.iterator().next().Singer;
				System.out.println(str);
			}
		}
		
		
		
	}
	public int countnumber(){
		Song p=Songs.iterator().next();
		while(p!=null){
			count++;}
		return count;
	}
	public void displaynumber(){
		
		countnumber();	
		System.out.println(count);
	}
	
}

public class MusicApp {
	static playlist p =new playlist();
	public static void main(String[] args)throws IOException,NoSuchSongException,ClassNotFoundException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		Song Arena=new Song("Arena","Daft-Punk",93);
		Song  Suite=new Song(" Suite","Daft-Punk",1111);
		Song Hello=new Song("Hello","Adele",295);	
		p.Songs.add(Arena);
		p.Songs.add(Suite);
		p.Songs.add(Hello);
		
		serialise();
		//deserialise();
		String dirname="C:\\Users\\MOH BHARTI\\Desktop\\Git\\MusicApp\\Music\\Music\\src";
		File A=new File(dirname);
		boolean a=true;
		boolean b=true;
		try{
		while(b){
			System.out.println("Select a playlist");	
		BacktoMenu(A);
		int count=0;
		//playlist p=new playlist();
		String[] paths=A.list();
		
		for(String path: paths) {count++;}
		String w=Reader.next();
		for(int i=0;i<count;i++){
			if(w.equals(paths[i])){
				ObjectOutputStream out=null;
				try{
				out=new ObjectOutputStream(new FileOutputStream("out.txt"));
				out.writeObject(p);
					
				}finally{
					out.close();
				}
			}
		
		
		try{
		while(a){
		System.out.println("a. for Adding a song");
		System.out.println("b. for Deleting a song");
		System.out.println("c.for Searching a song");
		System.out.println("d.for Show all songs");
		System.out.println("e. for Back to menu option");
		System.out.println("f.Exit the option");
		String S=Reader.next();
		if(S.equals("a")){
			System.out.println("Enter a song Name");
			String w1=Reader.next();
			System.out.println("Enter the Singer's name");
			String q=Reader.next();
			System.out.println("Enetr the Song's duration");
			int B=Reader.nextInt();
			Song So=new Song(w1,q,B);
			p.add(So);
		}
		if(S.equals("b")){
			System.out.println("Enter a Song name");
			String u=Reader.next();
			p.delete(u);
			
		}
		if(S.equals("c")){
			System.out.println("Enter a song to be searched");
			String h=Reader.next();
			p.search(h);
		}
		if(S.equals("d")){
			p.show();
		}
		if(S.equals("e")){
			BacktoMenu(A);
		}
		if(S.equals("f")){
			a=false;
			b=false;
		}
	}
		}finally{
			a=false;
			
		}
		}}}finally{
			b=false;
		}
		
		
	
	}
		public static void BacktoMenu(File A){
			
			String[] paths = A.list();
			// List all the files and directory under �/tmp�
			for(String path: paths) {
			System.out.println(path);}
		}
		public static void serialise()throws IOException{
			ObjectOutputStream out=null;
			try{
				out=new ObjectOutputStream(new FileOutputStream("out.txt"));
				out.writeObject(p);
			}finally{
				out.close();
			}
			
			
		}
		public static void deserialise()throws IOException ,ClassNotFoundException{
			ObjectInputStream in=null;
			try{
				in=new ObjectInputStream(new FileInputStream("out.txt"));
				playlist p=(playlist)in.readObject();
			}finally{
				in.close();
			}
		}
}
