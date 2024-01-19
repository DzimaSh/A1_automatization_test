# Series Calculator

This project calculates the sum of the series

$$
u_n = \frac{1}{n!} \sum_{k=1}^{n} k!  
$$

using Java.

## Prerequisites

- Java Development Kit (JDK) 21+

## Files

- `Main.java`: This is the main class that runs the program. It parses the command-line arguments and calls the `calculateSeries` method in the `SeriesCalculator` class.
- `SeriesCalculator.java`: This class contains the `calculateSeries` method that calculates the sum of the series.

## Usage

You can run the program with the following command:

```bash
java Main <n> [precision]
```

> Arguments:
>
> -   `<n>`: The number of terms in the series. Must be greater than or equal to 2.
> -   `[precision]`: Optional. The precision for the division operation. Default is 6.

## Makefile

The provided Makefile has the following targets:

-   `all`: Compiles the Java files.
-   `compile`: Compiles the Java files and puts the class files in the `build/` directory.
-   `run`: Runs the `Main` class of the application. You can pass arguments to the application by setting the `ARGS` variable.

    For example:
    ```bash
    make run ARGS="14"
    ```
-   `test`: Runs the `MainTest` class.
-   `clean`: Removes the `build/` directory.

## License

This project is licensed under the terms of the MIT license.
