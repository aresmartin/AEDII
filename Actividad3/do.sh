set -e
SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )

javac -cp "$SCRIPT_DIR/jar/\*" $2.java
java -cp  "$SCRIPT_DIR/jar/\*":. $2

#colocarme en el sitio en el que estaba antes del anterior cd (en este caso = cd ..)
