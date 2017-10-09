package org.wildcraft.jpms.automodule.caz.impl;

import org.wildcraft.jpms.automodule.caz.IStringUtil;

public class StringUtilMain {
    public static void main(String[] args) {
        IStringUtil stringUtil = IStringUtil.getInstance();
        System.out.println(stringUtil.split("a, b, c"));
    }
}
