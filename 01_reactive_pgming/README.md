Compilation:

jdk9-features/01_reactive_pgming > javac -d . src/module-info.java $(find . -name "*.java")


Run:

jdk9-features/01_reactive_pgming > java --module-path . -m com.reactive/com.reactive.Main