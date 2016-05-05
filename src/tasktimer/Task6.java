package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/** 
 * Append all the words from the dictionary to a StringBuilder.
 * Compare how long this takes to appending to String.
 */
public class Task6 implements Runnable{
	public void run(){
		BufferedReader br = null;
        try {
            br = new BufferedReader( new InputStreamReader(Dictionary.getWordsAsStream()) );
        } catch (Exception ex) {
            out.println("Could not open dictionary: "+ex.getMessage() );
            return;
        }
        StringBuilder result = new StringBuilder();
        String word = null;
        int count = 0;
        try {
            while( (word=br.readLine()) != null  && count < TaskTimer.MAXCOUNT) {
                result.append(word);
                count++;
            }
        } catch(IOException ioe) { System.out.println( ioe.getMessage() ); }
        System.out.printf("Done appending %d words to StringBuilder.\n", count);
	}
	public String toString(){
		return "Starting task: append "+TaskTimer.MAXCOUNT+" words to a StringBuilder";
	}
}
