import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
import java.io.*;
public class MusicAppTestArena {
	
	
	
	
	
	@Test(timeout=5000)
	public void test() throws IOException,ClassNotFoundException,NoSuchSongException{
		playlist pop=new playlist();
		pop.add(new Song("Dil se", "A.r.Rehman", 405));
		pop.add(new Song("Nirmohiya","Amit Trivedi",331));
		int n=(pop.countnumber());
		assertEquals(1,n);
		pop.delete("Arena");
		n=pop.countnumber();
		assertEquals(2,n);
		pop.search("Arena");
		assertEquals("Song is not here",pop.str);
		fail("Not yet implemented");
	}

}
