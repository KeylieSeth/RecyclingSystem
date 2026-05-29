# Recycling system
Menu-driven console application that provides recycling guidance for products and reusable materials. Developed as a final project for the Object-Oriented Design course.

The purpose of this system is mainly to manage products, their varoius materials, their environmental impact and guidance for recycling. The systems product management creates products along with name, category, materials, and estimated lifespan for the product and its material.
Material management defines the varoius materials which the products are made of, name of it, environmental impact value and recycling category for the material.

The system provides a total calculation for the environmental impact of a product, based on the material it is made of. Then provides guidance, based on the product and material, on how to recycle single- and mixed-material products.

## Features
-Products
-Materials - Material Types
-Environmental impact
-Single materials
-Mixed materials (composites)

-Manage products
-Calculate environmental impact
-Provide Recycling guidance
-Demonstrate clear architecture
-Identify Products
-Categorize Products
-Store Information
-Receive Input

## Architecture
Presentation/  
	MainMenu  
	MaterialMenu  
	ProductMenu  
	RecyclingMenu  
	ReportFormatter  

Application/  
	ProductService  
	MaterialService  
	RecyclingGuidanceService  
	SimpleSumStrategy  
	WeightedByLifespanStrategy  
	Report  

Domain /  
	ImpactCalculationStrategy  
	ProductRepository  
	Product  
	Material  
	RecyclingCategory  

Infrastructure /  
	InMemoryProductRepository  

### Presentation
In our Presentation layer, we have divided responsibilities for displaying and handling user interactions between four menus. The main menu contains the loop for running the program and displaying the different category menus. The material menu is responsible for adding and deleting materials from the system, while the product menu handles product interactions. The recycling menu is responsible for providing recycling guidance for products within the system and for changing recycling instructions for products.

### Application
The application layer will have all of our services, such as ProductService, MaterialService, RecyclingGuideService,         SimpleSumStrategy and WeightedByLifespanStrategy. This layer calls into the domain to exacute business, gives instructions   but does   not do the work itself. ProductService receives an ImpactCalculationStrategy via its constructor,                 SimpleSumStrategy and WeightedByLifespanStrategy implements our ImpactCalculationStrategy interface and provides the         actual calculations for the products. The RecyclingGuidanceService will provide guidance for recycling, it takes a product   and provides information of what material/s the product is made of and how to recycle it properly. ProductService creates,   removes and changes products and MaterialService defines the various materials.

### Domain
The domain layer is the heart of the program. We have our Product class, storing all of the products and Material storing    the different materials. We have our ImpactCalculationStrategy interface, which is an interface because we want to be able   to possibly add more ways of calculating impact. Here is also where we have our RecyclingCategory class because this class   will divide all the materials into different recycling sections. We have a ProductRepository interface that provides a       contract on how to load and save files.

### Infrastructure
For the infrastructure, we have our InMemoryProductRepository (instantiated in Main) that implements where to save/store file.

## Design Patterns
### Strategy Pattern
Our implementation of Strategy Pattern allows us to calculate different ways of the enviromental impact of a product.
In our program the ImpactCalculationStrategy is an interface, placed in the domain layer. This defines a common contract for the different impact calculations.
The actual implementations are placed in the application layer, which in our case is the SimpleSumStrategy and WeightedByLifespanStrategy.

## Contributions
### Albin
- Designed the product menu
- Implemented application layer product service
- Constructed domain layer product class
- Implemented FileHandler for project persistence

### Kim
- Designed the recycling menu
- Implemented application layer recycling guidance service
- Constructed domain layer category class for materials
- Worked with repository and in-memory data storage

### Aleksander
- Designed the material menu
- Implemented application layer material service
- Constructed domain layer material class
- Worked with impact calculation strategy for enviromental analysis

### Keylie
- Designed the menu navigation flow and UI
- Designed and implemented the report feature
- Worked with integration between products and materials
- Refactored handling of duplicates and entity selection logic

## How to Build/Run
### Prerequisites
Before running the project, make sure the following are installed:
Java JDK 21
Git
To verify Java installation:
java --version

## Clone the Repository
Clone the project and navigate into the project folder:
git clone https://github.com/KeylieSeth/FinalProjectOOD.git
cd FinalProjectOOD

## Run the Application
Run the project using the Gradle:
Windows (PowerShell):
.\gradlew run
macOS / Linux:
./gradlew run

## Build the Project
To compile and build the project:
./gradlew build
On Windows:
.\gradlew build

## Clean the Project
To remove generated build files:
./gradlew clean
On Windows:
.\gradlew clean

## Running Tests
Run automated tests with:
./gradlew test
On Windows:
.\gradlew test

## Saving and Loading Files
The application supports saving and loading text/serialized data files.
Example file names:
report.txt
save.ser
save.ser - stores serialized application data such as products and materials.
report.txt - stores generated reports in a readable text format.
Saved files are generated inside the app/ folder during runtime.
