package org.wildcraft.jpms.automodule.caz.impl;

import com.google.common.base.Splitter;
import org.wildcraft.jpms.automodule.caz.IStringUtil;

public class StringUtil implements IStringUtil {

    @Override
    public Iterable<String> split(String input) {
        return Splitter.on(',').trimResults().split(input);
    }

    private void describe() {
        System.out.println("This is a String Util Method!!!");
    }
}
