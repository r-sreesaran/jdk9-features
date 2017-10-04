set JAVA_HOME=C:\Program Files\Java\jdk-9
echo %JAVA_HOME%
cd target
if exist jmods rmdir /S /Q jmods
if not exist jmods mkdir jmods
cd ..
"C:\Program Files\Java\jdk-9\bin\java" --module-path "%JAVA_HOME%\jmods";target\original-1.0-SNAPSHOT.jar --list-modules
"C:\Program Files\Java\jdk-9\bin\jmod" create --class-path target\classes target\jmods\org.wildcraft.tooling.jmod