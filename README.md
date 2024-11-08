# DSL MyCSV
*Project M1/M2 SIF - DSL*
*Mathieu Poirier and June Rousseau*

## MyCSV
My CSV is a Domain-Specific for CSV manipulation. This repository provides:
- xtext grammar of MyCsv
- an interpreter
- a compiler to python
- a compiler to bash

Specification of the project can be found at the following URL:

https://github.com/FAMILIAR-project/HackOurLanguages-SIF/blob/master/slides/project20.pdf

Specification of the MyCsv language, and how to use it, is available at report/MyCsv\_User\_Manual.pdf

## Import the project
- Clone this git repository
- Import the project DSL-MyCSV in Eclipse-IDE with `Import > Projects from Git (with smart import) > Existing local repository`
- Uncheck the box DSL-MyCsv

If necessary:
- Create directory `xtend-gen` in `org.xtext.myCsv.ide` and `org.xtext.myCsv.ui`
- Create directory `src` in `org.xtext.myCsv.ui.tests`

## How to use MyCsv
### Compile the project
In Eclipse IDE:
- Right click on `org.xtext.myCsv.tests > Export ... > Java/Runnable Jar`
- Set "Launch Configuration" to `MyCsvMain - org.xtext.myCsv.tests`
- Choose your export destination

### Use it
From the command line:

Bash compiler: `java -jar $nameJar compile-bash /path/to/input.mycsv /path/to/output.sh`

Python compiler:   `java -jar $nameJar compile-python /path/to/input.mycsv /path/to/output.py`

Interpreter: `java -jar $nameJar interpret /path/to/input.mycsv`

## Test MyCsv
This project provides a set of MyCsv programs in the directory `org.xtext.myCsv.tests/examples/tests`. The directory `org.xtext.myCsv.tests/examples/csvFiles` is used to get CSV input for theses tests. These are used to benchmark implementations. 

### Python Compiler
In Eclipse-IDE:
Execute `org.xtext.myCsv.tests/src/org.xtext.tests/MyCsvCompilerPythonTest.xtend` as a Test JUnit
Python scripts are generated in `org.xtext.myCsv.tests/examples-gen/python`

### Bash Compiler
In Eclipse-IDE:
Execute `org.xtext.myCsv.tests/src/org.xtext.tests/MyCsvCompilerBashTest.xtend` as a Test JUnit
Bash scripts are generated in `org.xtext.myCsv.tests/examples-gen/bash`

### Interpreter
In Eclipse-IDE:
Execute `org.xtext.myCsv.tests/src/org.xtext.tests/MyCsvCompilerInterpreterTest.xtend` as a Test JUnit

### Benchmarks
In Eclipse-IDE:
Execute `org.xtext.myCsv.tests/src/org.xtext.tests/MyCsvCompilerBenchmarkTest.xtend` as a Test JUnit
All data are generated as CSV file, available in  `org.xtext.myCsv.tests/examples-gen/benchmark`
