1. Requirements
===============
Java 1.7
Maven 3 (required to build and run unit tests)

2. Running
===============
The compiled jar is located at "/target/sudoku-1.0.jar". Run the program using:

	java -jar sudoku-1.0.jar ${solutionFilePath}

The program will print any errors and one of three result values: BAD_INPUT, INVALID, or VALID

BAD_INPUT
	The solution file could not be read or the input was malformed.
	Types of bad input include:
		- length of side is not the square of an integer
		- number of columns is not equal to the number of rows
		- a cell contains a non-integer value
		- a cell contains a value less than 1 or greater than the side length

INVALID
	A row, column, or square was invalid (missing/duplicate values). 
	The offending row, column, or square number will be printed 
	(squares are numbered starting with 1 at the top-left and increasing left-to-right, then top-to-bottom).
	
VALID
	A valid solution.

3. Tests
===============
The test SudokuValidatorTest will test the program against all txt files under the following directories
	- src/test/resources/bad_input		- all files should return BAD_INPUT
	- src/test/resources/invalid		- all files should return INVALID
	- src/test/resources/valid			- all files should return VALID

Run the tests using

	mvn test

4. Building
===============
You can build the jar yourself using

	mvn install
