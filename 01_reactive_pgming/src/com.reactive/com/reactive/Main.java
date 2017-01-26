package com.reactive;

import java.util.concurrent.SubmissionPublisher;
import java.util.*;
import com.reactive.subscriber.MySubscriber;

/**
 * Created by NAS on 26-01-2017.
 */
public class Main  {

    public static void main(String[] args) {
        
        //Create Publisher
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        MySubscriber<String> subscriber1 = new MySubscriber<>();
        MySubscriber<String> subscriber2 = new MySubscriber<>();

        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);

        System.out.println("Publishing Items...");
        publisher.submit("2");
        
        String[] items = {"1","2","x","x","3"};

        Arrays.asList(items).stream().forEach(i->{System.out.println(i+" is submitted"); publisher.submit(i);});
         publisher.close();
    }

}
