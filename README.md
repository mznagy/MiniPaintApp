# Paint Application Phase Two (Updated)
This project is the second phase of the Paint application that was initiated in Lab 7. This updated version includes new features for reshaping, resizing, and drag-and-drop functionality for shapes.

## Features
In this phase, the application is extended to include the following features:

Users can select any shape not only through the combo box but also by clicking on it using the mouse. When a shape is selected, the combo box index is updated to match the index of the selected object.
Users can move any shape using the mouse from any point to any point.
Updated: Users can now drag and drop shapes within the application.
Updated: Users can now resize shapes within the application.
New: Users can now reshape the shapes within the application.
## Implementation
To accomplish the above requirements, the following tasks need to be carried out:

Modify the part of your code that is responsible for the shapes’ classes to implement the design depicted in the provided figure.
Place these classes and interfaces in one package named shapes. The differences are the Movable interface and Triangle class. The Movable interface specifies the necessary methods for implementing the movement feature of your application.
Regarding the application windows, make a window for each shape that accepts its data. Instead of writing a long description for each window, you can download the provided Jar file and your application should contain the same windows and provide the same functionality. The navigation between the windows should be handled in the same way as Lab 6. Using JOptionPane.showInputDialog to prompt the user for input the shapes’ data is not acceptable anymore and there will be a significant loss of mark if you use this technique instead of adding windows.
## Future Phases
Future phases may include additional features and improvements to the application.
