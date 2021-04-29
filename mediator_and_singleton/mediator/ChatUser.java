package mediator;

public class ChatUser extends User {

	public ChatUser(String name, MessageMediator messageMediator) {
		super(name, messageMediator);
		messageMediator.addUser(this);
	}

	
	@Override
	public void send(String message) {
		try {
			System.out.println(this.name + " sends: " + message);
			this.messageMediator.sendMessage(message, this);
		}catch(Exception e){
			System.out.println("Message couldn't be sent!");
            System.out.println(e);  
		}
		System.out.println("everyone got the message");
		
	}

	@Override
	public void receive(String message, User message_sender) {
		System.out.println(this.name + " received from " + message_sender.name + ":" + message);

	}

	@Override
	public void receive(String message) {
		System.out.println(this.name + " received:" + message);
	}


	@Override
	public String getName() {
		return this.name;
	}

}
