# TextCalculation

[![CircleCI](https://circleci.com/gh/binhonglee/TextCalculation.svg?style=svg)](https://circleci.com/gh/binhonglee/TextCalculation) [![Build Status](https://travis-ci.org/binhonglee/TextCalculation.svg?branch=master)](https://travis-ci.org/binhonglee/TextCalculation)

Basically, it will take in text instructions for calculation. The calculator with alphabets if you would.

## Compatibility
- Should supports all device with JDK installed.
- Exclude any additional word (like "and") in the input file.
- Only works for integers. Floats are currently unsupported.
- Supports negative numbers.
- Calculations are done from left to right. BODMAS and PEMDAS are not implemented.
- THERE IS NO ERROR HANDLING FOR THE PROGRAM. INVALID INPUT WILL LEAD TO PROGRAM TERMINATION. (or inaccurate results)

## Instructions
You will need JDK installed in your computer. There is no fancy UI in this but rather just a command line tool.

1. Open up "input" file (or create a new empty file)
2. Put in the instructions you want to calculate. For example ```two plus five```
3. Type ```javac TextCalculation.java``` into command line when in this folder (wherever you put it).
4. Type ```java TextCalculation input``` (replace input with the file you want to use as an input file).
5. There you have it! The answer is in the command line!

## Input file
- Refer to the example for formatting
- Wordings for each operation
  - '+' - "plus"
  - '-' - "minus"
  - '\*' - "times" or "multiply"
  - '/' - "over" or "divide"
- It only supports up to "nine thousand nine hundred ninety nine". The use of any number larger than that may cause unexpected error resulting in inaccurate result

##### Note : This is something really basic and random that I came up with when I was stuck at the airport for a long layover. Do not expect this to be a fully functional program.
