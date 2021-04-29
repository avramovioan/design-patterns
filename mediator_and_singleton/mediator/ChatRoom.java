package mediator;

import java.util.ArrayList;
import java.util.Iterator;

import singleton.ChatBot;

public class ChatRoom implements MessageMediator {
	
	private ArrayList<User> chatUsers;
	private boolean botAdded = false;
	public User userToBeRemoved;
	private int depth = 0;
	
	public ChatRoom() {
		this.chatUsers = new ArrayList<>();
	}

	@Override
	public void addUser(User user) {
		this.chatUsers.add(user);

	}
	
	@Override
	public void setUserToBeRemoved(User user) {
		this.userToBeRemoved = user;
	}

	@Override
	public void sendMessage(String message, User message_sender) {
		depth ++;
		for(User u : chatUsers) {
			if (message_sender.equals(u)) {
				continue;
			}
			u.receive(message, message_sender);
		}
		if(this.userToBeRemoved != null) {
			this.removeUser(this.userToBeRemoved);
		} 
		
		//Check if someone wants to summon the bot
		botSummoner(message);
		depth--;
	}
	public void removeUser(User user) {
		if(depth == 1) {
			this.chatUsers.remove(user);
			this.userToBeRemoved = null;
		}
	}
	
	public void sendMessage(String message) {
		for(User u : chatUsers) {
			u.receive(message);
		}
		
	}
	private void botSummoner(String message) {
		if(message.equals("!addBot") && !this.botAdded) {
			addUser(ChatBot.getInstance(this, "cat"));
			this.botAdded=true;
			sendMessage(">>> A Message_Scanner_BOT has been added <<<");
		}
	}
}
