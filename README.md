Genshin Impact Artifact Crit Calculator
This is a simple Java application that calculates the chance of getting above a certain critical hit rate value on a 5-star artifact in Genshin Impact. The calculator takes into account the starting critical hit rate, starting critical hit damage, artifact level, and the desired critical hit value.

# Genshin Impact Artifact Crit Calculator

Welcome to the Genshin Impact Artifact Crit Calculator! This calculator is designed to help you estimate the chance of obtaining a desired crit value on a 5-star artifact in Genshin Impact.


Version: Java 11


Testing Framework: JUnit



Follow the prompts to enter the required information:


Starting crit rate


Starting crit damage


Artifact level


Desired crit value


The application will calculate and display the chance of getting above the desired crit value based on the provided information.



Components
ArtifactModel.java
This class represents the data and logic for the artifact calculations.

ArtifactView.java
This class handles user input and output, providing prompts and displaying results.

ArtifactController.java
This class acts as an intermediary between the model and the view. It calculates upgrade counts, required coefficients, and coordinates the interactions between the model and the view.

Use Cases:
Calculate Chance with Starting Crit Rate and Damage:

User enters the starting crit rate as 25% and starting crit damage as 50%.
User inputs the artifact level as 12 and desired crit value as 80%.
The program calculates the required upgrades, required coefficient, and chance of getting above 80% crit value.
The program displays the calculated chance.

Calculate Chance with Starting Crit Rate Only:

User enters the starting crit rate as 30% and leaves the starting crit damage as 0%.
User inputs the artifact level as 16 and desired crit value as 70%.
The program calculates the required upgrades, required coefficient, and chance of getting above 70% crit value.
The program displays the calculated chance.

Calculate Chance with Starting Crit Damage Only:

User enters the starting crit damage as 75% and leaves the starting crit rate as 0%.
User inputs the artifact level as 8 and desired crit value as 60%.
The program calculates the required upgrades, required coefficient, and chance of getting above 60% crit value.
The program displays the calculated chance.

Calculate Chance with Zero Starting Crit Value:

User enters the starting crit rate as 0% and starting crit damage as 0%.
User inputs the artifact level as 4 and desired crit value as 40%.
The program calculates the required upgrades, required coefficient, and chance of getting above 40% crit value.
The program displays the calculated chance.

Calculate Chance with Starting Level at Maximum:

User enters the starting crit rate as 20% and starting crit damage as 40%.
User inputs the artifact level as 20 and desired crit value as 90%.
The program calculates the required upgrades, required coefficient, and chance of getting above 90% crit value.
The program displays the calculated chance.

Calculate Chance with Desired Crit Value Already Achieved:

User enters the starting crit rate as 10% and starting crit damage as 60%.
User inputs the artifact level as 10 and desired crit value as 60%.
The program detects that the desired crit value is already achieved with the starting crit value.
The program displays a message indicating a 100% chance.


User Stories:

Artifact Optimizer:

As a Genshin Impact player, I want to optimize my artifact's crit stats to achieve a desired critical hit value.
I want to input my artifact's starting crit rate, starting crit damage, level, and the crit value I desire.
The calculator should provide me with the chance of achieving the desired crit value after considering the possible upgrades.

Planning Artifact Upgrades:

As a player looking to enhance my artifact, I want to know the number of upgrades required to reach a specific crit value.
I should be able to input the starting crit rate, starting crit damage, and desired crit value.
The program should calculate the required number of upgrades to achieve the desired crit value.

Decision Making for Artifacts:

As a player deciding which artifact to invest in, I want to compare different artifacts based on their current crit stats and upgrade potential.
I need to input the starting crit rate, starting crit damage, level, and the crit value I'm aiming for.
The calculator should provide me with the chance of reaching the crit value for each artifact, helping me make an informed decision.

Stat Analysis for Build Optimization:

As a player creating an optimal character build, I want to analyze how different starting crit stats impact the chances of reaching a specific crit value.
I should be able to vary the starting crit rate, starting crit damage, and desired crit value.
The calculator should display how different combinations of starting stats affect the chances of achieving the desired crit value.

Validating Stat Investments:

As a cautious player, I want to validate whether investing in artifact upgrades is worth it for achieving my desired crit value.
I need to input the starting crit rate, starting crit damage, and desired crit value.
The calculator should show the probability of reaching the desired crit value based on the upgrades, helping me decide if it's worth the investment.

New Artifact Assessment:

As a player considering a new artifact, I want to determine its potential for crit value improvements before investing in it.
I should input the desired crit value, artifact's level, and the current starting crit stats.
The program should calculate the number of upgrades required and the probability of reaching the desired crit value.


Design Patterns:

Model-View-Controller (MVC) Pattern:

The program is structured using the MVC pattern to separate concerns between data (Model), user interface (View), and control logic (Controller). This promotes modularization and maintainability.

Strategy Pattern:

The program utilizes different strategies (methods) for calculating the chance of achieving the desired crit value based on the input. Depending on the input (starting crit rate, starting crit damage), different calculation methods (strategies) are used to determine the chance.

Builder Pattern (Implicit):

In the ArtifactModel class, the createCombinationList1 and createCombinationList2 methods recursively build a list of combinations for permutations of crit values. This recursive construction resembles the Builder pattern's step-by-step construction process.

Template Method Pattern (Partial):

Although not implemented as a full-fledged design pattern, the structure of the methods in ArtifactModel (calculateChance0, calculateChance1, calculateChance2) follows a template-like pattern. Each method follows a similar sequence of steps but with variations based on the calculation logic.

Strategy and Factory Method Pattern (Console Input):

The program interacts with the user to receive input using the ArtifactView class. While not a full-fledged factory, the view class can be seen as providing methods that act as factory methods for creating different types of user inputs (starting crit rate, starting crit damage, etc.).


Code Smells:


Long Methods:

Some methods in ArtifactModel and ArtifactController are quite long. Breaking them down into smaller, more focused methods could improve readability and maintainability.

Magic Numbers and Strings:

There are some hardcoded numbers and strings in the code, such as the 7.77 coefficient value and the 16 for the combinations. Consider defining these as constants with meaningful names to improve code readability. (FIXED IN A LATER PROMPT)

Deep Recursion:

The recursive methods createCombinationList1 and createCombinationList2 in ArtifactModel might become problematic for large upgradeCount values, leading to stack overflow errors. Consider using an iterative approach or optimizing the recursion.

Conditional Complexity:

The multiple if-else conditions in ArtifactController to select the calculation strategy based on different cases can become hard to manage as the program grows. This might be a sign that different calculation methods should be implemented using a more systematic approach, such as the Strategy pattern.

Lack of Validation and Error Handling:

The program assumes valid user inputs. Adding proper validation and error handling mechanisms for inputs like level, crit rates, and crit damage could improve the robustness of the program.

Lack of Comments:

While you've added comments to the code, some parts could benefit from additional comments to explain the purpose of complex logic or the intention behind specific calculations.

Single Responsibility Principle Violation:

Some methods in ArtifactModel and ArtifactController handle multiple concerns. Splitting them into methods that have a single responsibility could improve code organization.

Inconsistent Naming:

The method naming across the classes is not consistently camelCase. Consistent naming conventions make the code more readable and maintainable. (FIXED IN A LATER PROMPT)


Clean Architecture Violations:

Dependency Direction:

The code does show a separation between the Model, View, and Controller layers, which is in line with Clean Architecture's concentric circles. However, there is still a direct dependency between the Controller and Model, which could be further abstracted for better decoupling.

Use Case Interactors:

Clean Architecture promotes the use of Use Cases or Interactors as the central business logic layer. In the provided code, the artifact calculation logic within the ArtifactController could be extracted into separate use case classes to enforce this separation more rigorously.

Framework Dependencies:

Clean Architecture suggests isolating the core business logic from external frameworks and libraries. The provided code includes Scanner and System.in in the ArtifactView class, which couples the application to the Java I/O system. Consider abstracting this interaction to make the core logic independent of specific I/O mechanisms.

Unclear Dependency Inversion:

Clean Architecture emphasizes Dependency Inversion, where high-level modules should not depend on low-level modules. It appears that the ArtifactController directly depends on both ArtifactModel and ArtifactView. To improve this, you could introduce interfaces or abstract classes to define boundaries between layers and invert the dependencies.

Lack of Entities or Domain Models:

Clean Architecture typically includes an Entities or Domain Models layer, representing the core business logic. This layer encapsulates the application's business rules and entities. In the provided code, the core business logic is distributed between the ArtifactModel and ArtifactController. Consider introducing an entities layer to encapsulate the critical business rules.

Unclear Data Flow:

Clean Architecture emphasizes clear data flow, with data being passed through layers explicitly. The current code has some data flow happening within methods of ArtifactModel and ArtifactController. Consider ensuring a clear and controlled flow of data between layers, possibly using parameter objects or data structures.


Notes
The code provided is a simplified version for educational purposes and may not perfectly reflect the actual mechanics of the game.

