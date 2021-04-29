package mediator;

public interface MessageMediator {

	void addUser(User user);
	void sendMessage(String message, User message_sender);
	void setUserToBeRemoved(User user);
}
