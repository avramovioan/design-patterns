package singleton;

import mediator.ChatRoom;
import mediator.MessageMediator;
import mediator.User;

public class ChatBot extends User{

	private static ChatBot instance;
	private String forbidden_word;
	
	private ChatBot(String name, ChatRoom chatToAttach, String forbidden_word) {
		super(name, chatToAttach);
		this.forbidden_word = forbidden_word;
	}
	
	public static ChatBot getInstance(ChatRoom chatToAttach, String forbidden_word) {
		
		if(instance == null)
			instance = new ChatBot("Message_Scanner_BOT", chatToAttach, forbidden_word);
		
		return instance;
	}
	
	public boolean scanMessage(String message) {
		String[] words = message.split(" ");
		
		for(String word : words) {
			
			if(word.contains(this.forbidden_word)) {
				
				int index = word.lastIndexOf(this.forbidden_word);
				int left_char = index - 1;
				int right_char = index + this.forbidden_word.length();
				char[] wordArr = word.toCharArray();
				if(left_char >= 0 && !Character.isLetter(wordArr[left_char])) {
					word = (String) word.subSequence(left_char+1, right_char);
				}
				if(right_char <= word.length()-1 && !Character.isLetter(wordArr[right_char])) {
					word = (String) word.subSequence(0, right_char);
				}
				//is it the word itself
				if(word.length() == this.forbidden_word.length()) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public void send(String message) {
		this.messageMediator.sendMessage(message, this);
	}

	@Override
	public void receive(String message, User message_sender) {
		if(scanMessage(message)) {
			this.messageMediator.setUserToBeRemoved(message_sender);
			send(message_sender.getName() + " was kicked from the chat room for using the fobidden word: [" + this.forbidden_word + "]");
		}
	}

	@Override
	public void receive(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return this.name;
	}
}
