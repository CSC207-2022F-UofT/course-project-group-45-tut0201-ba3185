package database;

import use_case.message.MessageManagers;

public interface serInterface {
    MessageManagers readMM();
    void writeMM(MessageManagers messageManagers);
}
