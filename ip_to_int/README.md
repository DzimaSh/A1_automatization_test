# IP Address Converter

This project provides a simple utility for converting between string representations of IPv4 addresses and 32-bit integer representations.

## Features

- Convert a string representation of an IPv4 address to a 32-bit integer.
- Convert a 32-bit integer to a string representation of an IPv4 address.
- Validate if a string is a valid IPv4 address.

## Usage

This project uses a `Makefile` for building and running the application. Here are the available commands:

- `make all`: Compiles the Java source files. This is the default command if you just run `make`.

- `make compile`: Compiles the Java source files and places the resulting class files in the `build` directory.

- `make run`: Runs the main class of the application. You can pass arguments to the application by setting the `ARGS` variable.
  > Options:
  > - `--help`: Display the help message.
  > - `-32toi`: Convert an int32 to an IP address.
  > - `-ito32`: Convert an IP address to an int32.

  > Arguments:
  > - After `-32toi`, provide one or more int32 values.
  > - After `-ito32`, provide one or more IP addresses.

  For example:
  ```bash
  make run ARGS="-ito32 127.0.0.1"
  ```  

- `make test`: Runs the test class of the application.

- `make clean`: Deletes the `build` directory.

Please note that you need to have `make`, `java`, and `javac` installed on your system to use these commands.

## Contributing

Contributions are welcome. Please submit a pull request or create an issue to discuss the changes you want to make.

## License

This project is licensed under the MIT License.
