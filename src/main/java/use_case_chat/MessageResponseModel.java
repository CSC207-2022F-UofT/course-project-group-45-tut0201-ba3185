package use_case_chat;

import entity.ChatHistory;

import java.time.format.DateTimeFormatter;

public class MessageResponseModel {
   ChatHistory chatHistory;

    public MessageResponseModel(ChatHistory chatHistory){
        this.chatHistory = chatHistory;

    }
    public ChatHistory getChatHistory() {
        return chatHistory;
    }
}
