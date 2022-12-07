package database;

import use_case_message.MessageManagers;

import java.io.*;

public class MessageDataManager {
    /**
     * csvManager is the database interactor that reads and writes to MessageManagers.ser
     */
    private static final String messagePath = "src/main/java/database/MessageManagers.ser";

    /**
     * This method write modified MessageManagers to the file
     *
     * @param messageManagers, the MessageManagers to be stored in the file
     */
    public void writeMM(MessageManagers messageManagers){
        try {
            ObjectOutputStream output = new ObjectOutputStream(
                    new FileOutputStream(messagePath));
            output.writeObject(messageManagers);
            output.close();
        }
        catch (IOException ioe){
            System.err.println("Error saving to file.");
        }
    }

    /**
     * reads the current MessageManagers from the MessageManagers.ser data file
     * @return the MessageManagers stored in the file
     */
    public MessageManagers readMM(){
        try {
            ObjectInputStream input = new ObjectInputStream(
                    new FileInputStream(messagePath));
            MessageManagers messageManagers = (use_case_message.MessageManagers) input.readObject();
            input.close();
            return messageManagers;
        }
        catch (IOException ioe){
            // This will run at the first time of running the program since there's no such file before running.
            System.err.println("Error opening file.");
        }
        catch (ClassNotFoundException cnfe){
            System.err.println("Object read is not a MessageManagers");
        }
        return null;
    }
}
