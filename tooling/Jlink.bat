CALL Jmod.bat
set JAVA_HOME=C:\Program Files\Java\jdk-9
echo %JAVA_HOME%
cd target
if exist executable rmdir /S /Q executable
cd ..

"C:\Program Files\Java\jdk-9\bin\java" --module-path "%JAVA_HOME%\jmods";target\jmods --list-modules
"C:\Program Files\Java\jdk-9\bin\jlink" --module-path "%JAVA_HOME%\jmods";target\jmods --add-modules org.wildcraft.tooling --output target/executable

cd target/executable/bin
java --list-modules
