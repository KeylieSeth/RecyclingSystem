# FinalProjectOOD
Menu-driven console application that provides recycling guidance for products and reusable materials. Developed as a final project for the Object-Oriented Design course.

The purpose of this system is mainly to manage products, their varoius materials, their environmental impact and guidance for recycling. The systems product management creates products along with name, category, materials, and estimated lifespan for the product and its material.
Material management defines the varoius materials which the products are made of, name of it, environmental impact value and recycling category for the material.

The system provides a total calculation for the environmental impact of a product, based on the material it is made of. Then provides guidance, based on the product and material, on how to recycle single- and mixed-material products.


# Team organization / Task list
Functional implementation (programming and implementation)
Non functional implementation
Design and logic 
Documentation 
Planning
Testing and error handling
Planning and analysing
Project Review
ReadMe - Albin, Kim
Skeleton - Alex, Keylie
UML - Kim, ALex
Packages - Albin, Keylie


# Domain Concept
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

# Package description
In our Presantation layer, we will have both the Menu class and the Main class, since they will be in charge of user         interaction, such as displaying information to the user and Main will be "running" the entire system, getting information    from all the various classes. This layer contains no logic of its own.

The application layer will have all of our services, such as ProductService, MaterialService, RecyclingGuideService,         SimpleSumStrategy and WeightedByLifespanStrategy. This layer calls into the domain to exacute business, gives instructions   but does   not do the work itself. ProductService receives an ImpactCalculationStrategy via its constructor,                 SimpleSumStrategy and WeightedByLifespanStrategy implements our ImpactCalculationStrategy interface and provides the         actual calculations for the products. The RecyclingGuidanceService will provide guidance for recycling, it takes a product   and provides information of what material/s the product is made of and how to recycle it properly. ProductService creates,   removes and changes products and MaterialService defines the various materials.

The domain layer is the heart of the program. We have our Product class, storing all of the products and Material storing    the different materials. We have our ImpactCalculationStrategy interface, which is an interface because we want to be able   to possibly add more ways of calculating impact. Here is also where we have our RecyclingCategory class because this class   will divide all the materials into different recycling sections. We have a ProductRepository interface that provides a       contract on how to load and save files.

For the infrastructure, we have our InMemoryProductRepository (instantiated in Main) that implements where to save/store file.

Presentation/
	Main,
	Menu

Application/
	ProductService,
	MaterialService,
	RecyclingGuidanceService,
	SimpleSumStrategy,
	WeightedByLifespanStrategy

Domain /
	ImpactCalculationStrategy,
	ProductRepository,
	Product,
	Material,
	RecyclingCategory

Infrastructure /
	InMemoryProductRepository
