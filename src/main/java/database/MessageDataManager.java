package database;

import use_case_message.MessageManagers;

import java.io.*;

public class MessageDataManager implements serInterface {
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
        File f = new File(messagePath);
        if (!f.exists()){
            return new MessageManagers();
        }
        try {
            ObjectInputStream input = new ObjectInputStream(
                    new FileInputStream(messagePath));
            MessageManagers messageManagers = (use_case_message.MessageManagers) input.readObject();
            input.close();
            return messageManagers;
        }
        catch (IOException ioe){
            // This will run when no chat happened before since there will be no such file before running.
            System.err.println("Error opening file.");
        }
        catch (ClassNotFoundException cnfe){
            System.err.println("Object read is not a MessageManagers");
        }
        return null;
    }
}
