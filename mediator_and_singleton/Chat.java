import mediator;
import singleton;

public class Chat {

	public static void main(String[] args) {

		ChatRoom chat = new ChatRoom();
		
		ChatUser chu1 = new ChatUser("Georgi", chat);
		ChatUser chu2 = new ChatUser("Petur", chat);
		ChatUser chu3 = new ChatUser("Katq", chat);
		ChatUser chu4 = new ChatUser("Desi", chat);
		
		chu1.send("Hey guys!");
		System.out.println("-----------------------------------------------");
		chu3.send("!addBot");
		System.out.println("-----------------------------------------------");
		chu4.send("What does this BOT do?");
		System.out.println("-----------------------------------------------");
		chu3.send("It kicks you for writing \"cat\"!");
		System.out.println("-----------------------------------------------");
		chu4.send("She said cat and got removed?");
		System.out.println("-----------------------------------------------");

		ChatUser chu5 = new ChatUser("Ivan", chat);
		ChatUser chu6 = new ChatUser("Alex", chat);
		
		chu6.send("Hey whats up?");
		System.out.println("-----------------------------------------------");
		chu5.send("Do not say cat!");
		System.out.println("-----------------------------------------------");
	}
}
