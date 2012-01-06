@echo off
del web\CPR.jar
copy images\*.* classes\
cd classes
jar cvf ..\web\CPR.jar *.gif *.jpg com\*.*
cd ..
