import org.jfugue.player.Player;
import java.io.RandomAccessFile;

public class PlayNotes {

    public static void main(String[] args){


        try {
            RandomAccessFile pipe = new RandomAccessFile(
                    "\\\\.\\pipe\\notes_request_pipe", "rw");

            String notesRequest = "Request Notes";

            // Send request to the pipe
            pipe.write(notesRequest.getBytes());

            // Read response from pipe
            String response = pipe.readLine();

            if ( response != null) {

                //create new player object for playing notes

                Player player = new Player();

                //pass in piped notes and durations to the player object
                player.play(response);

                break;

            }
        }
        //catch all exception and print to console
        catch (Exception e){

            System.out.println("Exception Occured!");

        }


    }
}
