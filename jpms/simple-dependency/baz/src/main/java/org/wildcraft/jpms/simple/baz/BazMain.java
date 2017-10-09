package org.wildcraft.jpms.simple.baz;

public class BazMain {
    public static void main(String[] args) {
        BazService bazService = new BazService();
        System.out.println(bazService.baz());
    }
}
