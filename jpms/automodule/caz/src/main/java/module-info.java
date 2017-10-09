module org.wildcraft.jpms.automodule.caz {
    exports org.wildcraft.jpms.automodule.caz;
    exports org.wildcraft.jpms.automodule.caz.impl; // comment this and try making test module work without any change in test but with java tool switches.
    requires guava;
}