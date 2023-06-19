# Data Analysis report
Author: Nick Nikolov

## UML class diagram
```plantuml
@startuml

+Interface IBasicStats {
+{abstract} getMin(): double
+{abstract} getMax(): double
+{abstract} getSum(): double
+{abstract} getMean(): double
}

exception FileNotFoundException

+class DataFrame{
-headerNames: String[]
-data[][]: double
-numOfRows: int
-numOfCols: int

+DataFrame(fileName: String)
+getHeaderNames(): String[]
+getNumOfRows(): int
+getNumOfCols(): int
+toString(): String
+getColumnByIndex(i: int): DataSeries
}

+class DataAnalysisCLI{
-data: DataFrame
-cli: InteractiveCLI

+DataAnalysisCLI()
+run(): void
+{static} main(args: String[]): void
}

+class DataSeries{
-label: String
-data[]: double
-count: int

+DataSeries(l: String)
+add(n: double): void
+size(): int
+getMin(): double
+getMax(): double
+getSum(): double
+getMean(): double
+toString(): String
}

DataAnalysisCLI --> DataFrame: uses
DataAnalysisCLI --> DataSeries: uses
DataAnalysisCLI --> InteractiveCLI: uses
IBasicStats <|.. DataSeries: realizes
DataFrame --> FileNotFoundException: Throws
DataFrame --> DataSeries: Uses

@enduml
```
This screenshot shows the UML diagram for the DataAnalysis program

![Example screenshot](dataAnalysisUML.png)


## Execution and Testing
This screenshot shows successful execution of the Stats program using the test.csv with age as the input column

![Example screenshot](testJavaOutput.png)

This screenshot shows successful execution of the Stats program using the diabetes100.csv with age as the input column

![Example screenshot](diabetesJavaOutput.png)

## Verification of statistics
Verification of statistics is shown in diabetes100Confirmation.xls and testConfirmation.xls, screenshots shown below

This screenshot shows successful confirmation of the Test.csv dataset using excel

![Example screenshot](testExcelConfirmation.png)

This screenshot shows successful confirmation of the diabetes100.csv dataset using excel

![Example screenshot](diabetesExcelConfirmation.png)


# Reflection
DataAnalysis - I liked learning about how to manually do many of the python data analysis functions I've been using.

TextAnalysis - I liked learning more in depth about the GUI after editing some components. Interesting to format output to the user.
