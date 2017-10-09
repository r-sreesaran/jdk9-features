set JAVA_HOME=C:\Program Files\Java\jdk-9
echo %JAVA_HOME%
cd target
if exist jmods rmdir /S /Q jmods
if not exist jmods mkdir jmods
cd ..
#"C:\Program Files\Java\jdk-9\bin\java" --module-path "%JAVA_HOME%\jmods";target\jmods --list-modules
"C:\Program Files\Java\jdk-9\bin\jmod" create --module-version=1.0 --class-path target\classes  target\jmods\org.wildcraft.tooling.jmod