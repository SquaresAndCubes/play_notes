/*Brent Vaalburg
CSCI430
Week 3 Homework
Java Notes Player with Linux Piping support
Dependencies : Java 8, Jfugue (included in /jars folder), Linux (mkfifo command used to make named pipe)

**********Instructions***************
* 1. Create a <pipe_name> in the path of your choice in a Linux environment @ the terminal using mkfifo <pipe_name>
* 2. In this code set the RandomAccessFile 'pipe' variable on line #39 to your created <pipe_name>
* 3. Run this program
*
* Now you have 2 options to pass Notes Into PlayNotes
*
* 1. Use the terminal and type 'echo <notes_string> > <pipe_name>
* 2. Use the other program I created called 'SendNotes' run it and follow the instructions.
*
* Piped input formatting for <notes_string> is as follows:
* Notes/Tones are represented by their respected letter designations.
* For Example A B C D E , you will be delimiting them with spaces.
* To set the duration of the Tone/Note, you add a 'q' for each quarter note time. For example Aqqq for 3/4 time of note A.
* Full input example below (a typical scale with all half time notes):
* Cqq Dqq Eqq Fqq Gqq Aqq Bqq Cqq
*
* ***********************************
 */

//import dependencies
import org.jfugue.player.Player;
import java.io.RandomAccessFile;
import java.util.Random;

public class PlayNotes {

    public static void main(String[] args){

        //create new player object for playing notes
        Player player = new Player();
        RandomAccessFile pipe;

        try {

            pipe = new RandomAccessFile(
                    //path to <pipe_name> made with Linux mkfifo command
                    "/home/sqaresandcubes/notesPipe", "r");

            //while loops keeps accepting piped input
            while(true) {
                // Read pipe set to pipeInput string variable
                String pipeInput = pipe.readLine();


                if (pipeInput != null) {

                    //print pipeInput to console
                    System.out.println("Playing Sequence: " + pipeInput);

                    //execute the play function of the player object
                    //and pass pipeInput into it
                    player.play(pipeInput);
                }
            }


        }

        //catch all exceptions and print to console
        catch (Exception e){

            e.printStackTrace();

        }


    }
}





