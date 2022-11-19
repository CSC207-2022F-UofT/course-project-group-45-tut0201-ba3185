package use_case_message;

import entity.ChatHistory;

import java.util.ArrayList;

public class MessageResponseModel {
   ChatHistory chatHistory;

    public MessageResponseModel(ChatHistory chatHistory){
        this.chatHistory = chatHistory;
    }
    public ChatHistory getChatHistory() {
        return chatHistory;
    }
}
