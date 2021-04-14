package observer;

import java.util.ArrayList;

public class Channel implements Observable {

	private ArrayList<Observer> subscribers;
	private ArrayList<String> videos;
	private String name;
	private String notification;
	
	public Channel(String name) {
		this.name = name;
		this.subscribers = new ArrayList<>();
		this.videos = new ArrayList<>();
	}
	
	@Override
	public void subscribe(Observer observer) {
		this.subscribers.add(observer);

	}

	@Override
	public void unsubscribe(Observer observer) {
		this.subscribers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer obs : this.subscribers) {
			obs.update(this.getUpdate());
		}
	}

	@Override
	public String getUpdate() {
		return this.notification;
	}
	
	public void setNotification(String video_title) {
		this.notification = this.getName()+ " uploaded a new Video: " + video_title;
	}

	public String getName() {
		return name;
	}	
	
	public void addVideo(String video_title) {
		this.videos.add(video_title);
		this.setNotification(video_title);
		notifyObservers();
		
	}

}
