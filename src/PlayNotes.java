/*Brent Vaalburg
CSCI430
Java Notes Player with Linux Piping support
Dependencies : Java 8, Jfugue (included)
 */

import org.jfugue.player.Player;
import java.io.RandomAccessFile;

public class PlayNotes {

    public static void main(String[] args){

        try {
            RandomAccessFile pipe = new RandomAccessFile(
                    //path to named pipe made with Linux mkfifo command
                    //cd to directory where you would like to keep the named pipe then run
                    //mkfifo <pipename>
                    "/home/bvaalb/notesPipe", "rw");

            // Read pipe
            String pipeInput = pipe.readLine();

            // Close pipe
            pipe.close();

            //create new player object for playing notes

            System.out.println(pipeInput);

        }
        //catch all exception and print to console
        catch (Exception e){

            System.out.println(e);

        }


    }
}





