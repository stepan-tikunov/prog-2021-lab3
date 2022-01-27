#!/bin/bash

cd "$(dirname "$0")" ;

rm $(find bin -name "*.class") 2>/dev/null ;
mkdir bin 2>/dev/null ;
javac -encoding "UTF-8" -s src -d bin -cp $(cat .classpath) $(find src -name "*.java") &&
cd bin && jar cfm app.jar ../MANIFEST.mf $(find . -name "*.class") &&
echo "Compiled successfully, app.jar and *.class files are stored in bin/ directory." ;
