package org.wildcraft.util.optional;

import java.util.Optional;
import java.util.stream.Stream;

public class Person {

    private final String name;

    private final String permanentAddress;

    private Optional<String> residentialAddress;

    public Person(String name, String permanentAddress) {
        this.name = name;
        this.permanentAddress = permanentAddress;
        this.residentialAddress = Optional.empty();
    }

    public Optional<String> getResidentialAddress() {
        return residentialAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = Optional.of(residentialAddress);
    }

    public Stream<String> getResidentialAddressStream() {
        return getResidentialAddress().stream(); //Lazy
    }
}
