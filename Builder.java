/*
    Scenario: When creating object, there are many attributes to be set at the time the object is instantiated.
              Also, for immutable objects, we cannot use setter() to configure attributes.
              
    Definition: The builder pattern is a creational pattern in which parameters are passed to a builder object, 
               often through method chaining, and an object is generated with a final build call. 
               
               It is often used with immutable objects, since immutable objects do not have setter methods and 
               must be created with all of their parameters set, although it can be used with mutable objects as well.
    
    Benefits:
        Encapsulates the way a complex object is constructed.
        Allows objects to be constructed in a multistep and varying process (as opposed to one step factories).
        Work for immutable class
*/

public class Builder{

}
