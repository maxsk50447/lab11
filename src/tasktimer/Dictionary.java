package tasktimer;

import java.io.*;

public class Dictionary {
	private static String DICTIONARY = "wordlist.txt";
	public static InputStream getWordsAsStream(){
		InputStream instream = Dictionary.class.getClassLoader().getResourceAsStream(DICTIONARY);
		return instream;
	}
}
