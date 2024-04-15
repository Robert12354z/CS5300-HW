package Homework6.MementoMediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatServer {
    private Map<String, User> users;
    private Map<String, ChatHistory> chatHistories;
    private ArrayList<String> blockedUsers;

    public ChatServer(){
        this.users = new HashMap<>();
        this.chatHistories = new HashMap<>();
    }

    public void addUser(User user){
        this.users.put(user.getName(), user);
    }

    public void removeUser(User user){
        this.users.remove(user.getName());
    }

    public void sendMessage(String sender, Message message){
        for (String receiver : message.getReceivers()){
            if (users.containsKey(receiver)) {
                if(receiver != sender && !blockedUsers.contains(receiver)){
                users.get(receiver).receiveMessage(message);
             }
                else{
                 System.out.println("Message not sent to " + receiver + " because they are blocked by " + sender);
                }
            }else {
                System.out.println("Message not sent to " + receiver + " because they do not exist in the user list.");
            }
            
        }
    }

    public void blockUser(String userName){
        if (users.containsKey(userName)){
            this.blockedUsers.add(userName);
        }
    }

   

}
