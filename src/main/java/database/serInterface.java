package database;

import use_case_message.MessageManagers;

public interface serInterface {
    MessageManagers readMM();
    void writeMM(MessageManagers messageManagers);
}
