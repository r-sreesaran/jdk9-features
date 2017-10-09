package org.wildcraft.jpms.simple.baz;

import org.wildcraft.jpms.simple.aaz.AazService;

public class BazService {

    public String baz() {
        AazService aazService = new AazService();
        return aazService.aaz();
    }
}
