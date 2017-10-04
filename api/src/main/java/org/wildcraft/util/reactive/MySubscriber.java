package org.wildcraft.util.reactive;

import java.util.concurrent.Flow;

public class MySubscriber<T> implements Flow.Subscriber<T> {

    private Flow.Subscription subscription;

	@Override
	public void onSubscribe(Flow.Subscription subscription) {
		this.subscription = subscription;
		System.out.println("onSubscribe");
		subscription.request(1);
	}

	@Override  
	public void onNext(T item) {  
	    System.out.println("Got : " + (String)item);  
	    subscription.request(1); //a value of  Long.MAX_VALUE may be considered as effectively unbounded  
	}  
	  
	@Override  
	public void onError(Throwable t) {  
	    t.printStackTrace();  
	}  
	  
	@Override  
	public void onComplete() {  
	    System.out.println("Done");  
	} 
}