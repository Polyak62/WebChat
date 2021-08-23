package ru.sbt.app;

import ru.sbt.app.entity.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageStore {
    private static volatile List<Message> messages = Collections.synchronizedList(new ArrayList<Message>());

    public static List<Message> getMessages (){
        return messages;
    }

    public static void addMessage(Message message){
        messages.add(message);
    }

}
