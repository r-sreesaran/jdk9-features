package org.wildcraft.jpms.automodule.caz;


import org.wildcraft.jpms.automodule.caz.impl.StringUtil;

public interface IStringUtil {
    Iterable<String> split(String input);

    static IStringUtil getInstance() {
        return new StringUtil();
    }
}
