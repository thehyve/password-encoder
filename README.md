# password-encoder
Simple password encoder tool based on Spring Security.

### Build and run
```bash
mvn package
java -jar target/password-encoder-0.1.jar <passwd>
```

### Install in home directory
```bash
cp target/password-encoder-0.1.jar ~/bin/password-encoder.jar
chmod +x ~/bin/password-encoder.jar
```
If your `~/bin` directory is not in your path, add these lines to `~/.profile`:
```bash
if [ -d "$HOME/bin" ] ; then
    PATH="$HOME/bin:$PATH"
fi
```
Usage:
```bash
password-encoder.jar <passwd>
```
