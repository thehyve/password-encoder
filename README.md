# password-encoder
Simple password encoder tool based on Spring Security.

### Build and run
```bash
mvn package
java -jar target/password-encoder-0.1.jar ${passwd}
```

### Install in home directory
```bash
cp target/password-encoder-0.1.jar ~/bin/password-encoder.jar
```

Create a file `~/bin/password-encoder` with contents:
```bash
#!/bin/bash

here=$(realpath $(dirname "${0}"))
jar="${here}/password-encoder.jar"

# Check if the jar present
if [ ! -e "${jar}" ]; then
    echo "Cannot find jar: ${jar}"
    exit 1
fi

# Choose the location of the java binary
prefix=
if [ ! "x${JAVA_HOME}" == "x" ]; then
    prefix="${JAVA_HOME}/bin/"
fi

# Run the jar
${prefix}java -jar "${jar}" $@
```

Then:
```bash
chmod +x ~/bin/password-encoder
```

If your `~/bin` directory is not in your path, add these lines to `~/.profile`:
```bash
if [ -d "$HOME/bin" ] ; then
    PATH="$HOME/bin:$PATH"
fi
```

Usage:
```bash
password-encoder ${passwd}
```
