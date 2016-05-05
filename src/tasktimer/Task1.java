package tasktimer;

import static java.lang.System.out;

/**
 * Process all the words in a file using Scanner to read and parse input.
 * Display summary statistics and elapsed time.
 */
public class Task1 implements Runnable{
	public void run(){
        // perform the task
        int count = 0;
        long totalsize = 0;
        while(TaskTimer.in.hasNext()) {
            String word = TaskTimer.in.next();
            totalsize += word.length();
            count++;
        }
        double averageLength = ((double)totalsize)/(count>0 ? count : 1);
       
        out.printf("Average length of %,d words is %.2f\n", count, averageLength);

	}
	public String toString(){
		return "Starting task: read words using Scanner and a while loop";
	}
}
