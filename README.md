# Mars Rover Challenge by NEXT45

## Java Version
This project was compile using [java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
You can still use other versions to compile and run the code, but some things such as test coverage report might fail. In order to run all the command defined in the makefile without any errors, please use [java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).


## Running The Code

The program can be executed from the terminal. The command takes a number of flags as seen below.

```$java -cp bin RoverDriver -p <initial position> -s <surface dimensions> -c <commands>```

- -p flag for *initial position* of the rover in a format x y Direction i.e _1 2 E_.
- -s flag for the *surface dimensions* when the rover will be surveying in a format xDimension yDimension i.e _8 10_.
- -c flag for the string of commands that will be executed by the Rover in a format XXXXXXXXXXXX i.e _MMRLMRLLMRLMMM_.

_The order of this flags is not important - they can be passed in any order_

## Testing
There is a `make` command to run the tests, that is:

```$make test```

## Code Documentation
As seen in the `makefile`, I am using _Jacoco_ for documentation. I experianced issues when running jacoco with other versions of _Java_ except _Java 8_. Thus I recommend running this with Java 8 since I am almost certain that this wont fail. Anyhow, to get the code documentation, the make command is:

```$make doc```

After running this command successfully, you can open the `./doc/index.html` with your preferred choice of browser(hopefully this is not :) Internet Explorer)

I have removed the `doc` folder from the `.gitignore` in case this command fails and you are not ready to downgrade to Java 8.

## Code Coverage Report
The `make` command is:

```$make report```

To view the report after running this command successfully, open `./coveragereport/index.html` in your browser.

I am also using _Jacoco_ to get the code coverage for my tests. This means all the fairytales mentioned previously about _Java 8_ still apply here. So I have commited the Coverage report too.

## HAPPY CODING

