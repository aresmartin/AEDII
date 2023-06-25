set -e
SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
cd $1

javac -cp "$SCRIPT_DIR/jar/aed2.jar" $2.java
java -cp  "$SCRIPT_DIR/jar/aed2.jar":. $2

#colocarme en el sitio en el que estaba antes del anterior cd (en este caso = cd ..)
cd -
