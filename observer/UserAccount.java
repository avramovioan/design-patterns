package observer;

import java.util.ArrayList;

public class UserAccount implements Observer {
	
	private String accountName;
	private ArrayList<Observable> subscribedTo;

	public UserAccount(String name) {
		this.accountName = name;
		this.subscribedTo = new ArrayList<Observable>();
	}

	@Override
	public void setSubscribtion(Observable subscribtion) {
		this.subscribedTo.add(subscribtion);

	}

	public String getAccountName() {
		return accountName;
	}

	@Override
	public void update(String notificaiton) {
		System.out.println(this.accountName + " Received a notificaiton: " + notificaiton);
		
	}

}
