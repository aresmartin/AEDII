set -e
cd $1

javac -cp ../jar/aed2.jar $2.java
java -cp ../jar/aed2.jar:. $2

#colocarme en el sitio en el que estaba antes del anterior cd (en este caso = cd ..)
cd -