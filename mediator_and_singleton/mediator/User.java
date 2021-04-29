package mediator;

public abstract class User {
	
	protected MessageMediator messageMediator;
	protected String name;
	
	public User (String name, MessageMediator messageMediator) {
		this.name = name;
		this.messageMediator = messageMediator;
	}
	
	public abstract void send(String message);
	public abstract void receive(String message, User message_sender);
	public abstract void receive(String message);
	public abstract String getName();

}
