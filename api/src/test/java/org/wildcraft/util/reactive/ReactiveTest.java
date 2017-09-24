package org.wildcraft.util.reactive;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.SubmissionPublisher;

@Test
public class ReactiveTest {

    @Test
    public void testPublishAndSubscribe() {
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
