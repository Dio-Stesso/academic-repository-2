## Patterns:

- **Singleton pattern**:
This pattern is used to ensure that only one instance of the `Library` class is created. 
This is important because there should only be one library in the system. 
The `Library` class uses a private constructor and a static `getInstance()` method to implement the Singleton pattern. 
This pattern solves the problem of controlling the number of instances of a class that can be created.<br/>
One advantage of using this pattern in this context is that it ensures that there is only one library in the system. 
This can make it easier to manage the state of the library and prevent inconsistencies.<br/>
One disadvantage of using this pattern is that it can introduce global state into the system. 
This can make it more difficult to test and maintain the code.
<br/><br/>
- **Factory Method pattern**:
This pattern is used to create different types of Book objects. 
The `BookFactory` class provides a `createBook()` method that takes a String parameter specifying the type of book to create and returns a new instance of either the `Novel` or `Textbook` class. 
This pattern solves the problem of creating objects without specifying their concrete classes.<br/>
One advantage of using this pattern in this context is that it allows new types of books to be added to the system without changing the existing code. 
This can make it easier to extend and maintain the system.<br/>
One disadvantage of using this pattern is that it can introduce complexity into the system. 
The factory class must be carefully designed to ensure that it correctly creates objects of the appropriate type.
  <br/><br/>
- **Observer pattern**:
This pattern is used to notify users when a new book is added to the library. 
The Library class extends the `Observable` class and uses the `addObserver()` method to register observers. 
The User class implements the `Observer` interface and overrides the `update()` method to receive notifications when a new book is added to the library. 
This pattern solves the problem of notifying multiple objects when a change occurs.<br/>
One advantage of using this pattern in this context is that it allows multiple users to be notified of changes in the library without tightly coupling the `Library` and `User` classes. 
This can make it easier to add new types of users or change how notifications are handled without changing the existing code.<br/>
One disadvantage of using this pattern is that it can introduce complexity into the system. The observer classes must be carefully designed to ensure that they correctly receive and handle notifications.
  <br/><br/>
- **Strategy pattern**:
This pattern is used to allow different search strategies to be used to find books in the library. 
The `SearchStrategy` interface defines a common method for searching for books and the `TitleSearchStrategy` class provides a specific implementation of this method that searches for books by title and `TypeSearchStrategy` class for searching by type. 
The `Library` class uses a reference to a `SearchStrategy` object to perform searches, allowing the search strategy to be changed at runtime. 
This pattern solves the problem of defining a family of algorithms and making them interchangeable.<br/>
One advantage of using this pattern in this context is that it allows new search strategies to be added to the system without changing the existing code. 
This can make it easier to extend and maintain the system.<br/>
One disadvantage of using this pattern is that it can introduce complexity into the system. 
The strategy classes must be carefully designed to ensure that they correctly implement the search algorithm.
  <br/><br/>
- **Template Method pattern**:
This pattern is used to generate different types of reports for the library. 
The `Report` class defines a template method called `generate()` that calls three other methods: `printHeader()`, `printBody()`, and `printFooter()`. 
These methods are declared as abstract in the `Report` class and must be implemented by subclasses. 
The `OverdueReport` class extends the Report class and provides specific implementations of these methods to generate an overdue report. 
This pattern solves the problem of defining the skeleton of an algorithm and allowing subclasses to provide specific implementations of certain steps.<br/>
One advantage of using this pattern in this context is that it allows new types of reports to be added to the system without changing the existing code. 
This can make it easier to extend and maintain the system.<br/>
One disadvantage of using this pattern is that it can introduce complexity into the system. 
The report classes must be carefully designed to ensure that they correctly implement the steps of the report generation algorithm.
  <br/><br/>
- **Composite pattern**:
This pattern is used to represent a hierarchy of library items. 
The `LibraryItem` class defines an abstract `display()` method that must be implemented by subclasses. 
The `Book` class extends the `LibraryItem` class and provides a specific implementation of the `display()` method that prints the title of the book. 
The `LibrarySection` class also extends the LibraryItem class and contains a collection of LibraryItem objects. 
The `display()` method in this class iterates over the collection of items and calls their `display()` methods.
This pattern solves the problem of representing a hierarchy of library items and treating individual items and collections of items uniformly. 
By using the `Composite` pattern, it is easy to add new types of library items or organize items into sections without changing the existing code.<br/>
One advantage of using this pattern in this context is that it allows for flexibility in representing the structure of the library. 
New types of library items can be added or existing items can be organized into sections without requiring changes to the existing code. 
This can make it easier to maintain and extend the system.<br/>
One disadvantage of using this pattern is that it can introduce complexity into the system. 
The hierarchy of library items must be carefully designed to ensure that it accurately represents the structure of the library. 
Additionally, care must be taken when implementing operations on the hierarchy to ensure that they behave correctly for both individual items and collections of items.
