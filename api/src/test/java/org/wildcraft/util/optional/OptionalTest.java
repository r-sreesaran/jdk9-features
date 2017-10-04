package org.wildcraft.util.optional;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Test
public class OptionalTest {

    @Test
    public void testOptionalWithoutStream() {
        List<Person> people = Arrays.asList(new Person("Ram", "chennai"));
        List<String> residentialAddresses = people.stream().map(person -> person.getResidentialAddress())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        Assert.assertEquals(residentialAddresses.size(), 0);
    }

    @Test
    public void testOptionalStream() {
        List<Person> people = Arrays.asList(new Person("Ram", "chennai"));
        List<String> residentialAddresses = people.stream().map(person -> person.getResidentialAddress())
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
        Assert.assertEquals(residentialAddresses.size(), 0);
    }

    @Test
    public void testOptionalWithoutOr() {
        List<Person> people = Arrays.asList(new Person("Ram", "chennai"));
        List<String> residentialAddresses = people.stream()
                .map(person -> {
                    if (person.getResidentialAddress().isPresent()) {
                        return person.getResidentialAddress().get();
                    } else {
                        return person.getPermanentAddress();
                    }
                })
                .collect(Collectors.toList());
        Assert.assertEquals(residentialAddresses.size(), 1);
    }

    @Test
    public void testOptionalOr() {
        List<Person> people = Arrays.asList(new Person("Ram", "chennai"));
        List<String> residentialAddresses = people.stream()
                .map(person ->
                        person.getResidentialAddress()
                                .or(() -> Optional.of(person.getPermanentAddress()))
                ).map(Optional::get)
                .collect(Collectors.toList());
        Assert.assertEquals(residentialAddresses.size(), 1);
    }

    @Test
    public void testOptionalWithoutIfPresentOrElse() {
        Person person = new Person("Ram", "chennai");
        Optional<String> residentialAddress = person.getResidentialAddress();
        if (residentialAddress.isPresent()) {
            System.out.println(residentialAddress.get());
        } else {
            System.out.println("No Residential Address found!!!");
        }
    }

    @Test
    public void testOptionalIfPresentOrElse() {
        Person person = new Person("Ram", "chennai");
        person.getResidentialAddress().ifPresentOrElse(residentialAddress -> System.out.println(residentialAddress),
                () -> System.out.println("No Residential Address found!!!"));
    }
}
