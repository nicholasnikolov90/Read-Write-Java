# Text Analysis report
Author: Nick Nikolov

## UML class diagram
```plantuml
@startuml

+class TextAnalysisGUI{
-inputArea: JTextArea
-display: JTextArea
-clear: JButton
-analyze: JButton
-textAnalyzer: TextAnalyzer
-text: String

+TextAnalysisGUI(title: String)
+actionPerformed(e: ActionEvent): void
+{static} main(args: String[]): void
}

+class TextAnalyzer{
-numOfSentences: int
-numOfWords: int

+TextAnalyzer(text: String)
+getNumOfSentences(): int
+getNumOfWords(): int
+toString(): String

}

interface ActionListener


TextAnalysisGUI ..|> ActionListener : realizes
TextAnalysisGUI --> TextAnalyzer: uses

@enduml


```

This screenshot shows the PlantUML diagram for the TextAnalysisGUI and TextAnalyzer classes

![Example screenshot](textAnalysisUML.png)

## Execution and Testing

This screenshot shows successful execution of the TextAnalysis program using the test.txt string

![Example screenshot](testOutput.png)

This screenshot shows successful execution of the TextAnalysis program using the feynman.txt string

![Example screenshot](feynmanOutput.png)