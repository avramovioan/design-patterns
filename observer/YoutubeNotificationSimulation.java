package observer;

public class YoutubeNotificationSimulation {

	public static void main(String[] args) {
		
		Channel ch1 = new Channel("Danny Channel");
		Channel ch2 = new Channel("Bobby Channel");
		
		UserAccount ua1 = new UserAccount("John");
		UserAccount ua2 = new UserAccount("Josh");
		UserAccount ua3 = new UserAccount("Daniel");
		
		ch1.subscribe(ua1);
		ch1.subscribe(ua2);
		ch1.subscribe(ua3);
		
		
		ch2.subscribe(ua3);
		ch2.subscribe(ua2);
		
		ch1.addVideo("This is my brand new video!");
		System.out.println("------------------------------------------");
		ch2.addVideo("How to do design patterns");
		System.out.println("------------------------------------------");

		ch1.unsubscribe(ua1);

		ch1.addVideo("This is my second video!");

		
		
	}

}
