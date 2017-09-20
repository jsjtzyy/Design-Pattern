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
import java.util.*

// Animal is a immutable class  with keyword final
public final class Animal {
    private final String species;
    private final int age;
    private final List<String> favoriteFoods;
    public Animal(String species, int age, List<String> favoriteFoods) { 
        this.species = species;
        this.age = age;
        if(favoriteFoods == null) {
            throw new RuntimeException("favoriteFoods is required"); 
        }
        this.favoriteFoods = new ArrayList<String>(favoriteFoods); }
    public String getSpecies() {       // only has get methods, no set methods, because class is immutable
        return species;
    }
    public int getAge() { 
        return age;
    }
    public int getFavoriteFoodsCount() { 
        return favoriteFoods.size();
    }
    public String getFavoriteFood(int index) { 
        return favoriteFoods.get(index);
    } 
}

// Design AnimalBuilder class based on Builder Pattern
public class AnimalBuilder {   // setter methods can be owned by AnimalBuilder
    private String species;
    private int age;
    private List<String> favoriteFoods;
    public AnimalBuilder setAge(int age) { 
        this.age = age;
        return this;               // for chaining use
    }
    public AnimalBuilder setSpecies(String species) {  
        this.species = species;
        return this;               // "return this" is used for chaining set attributes. see example below
    }
    public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods) { 
        this.favoriteFoods = favoriteFoods;
        return this;              // for chaining use
    }
    public Animal build() {       // build method is used for instantiate object finally
        return new Animal(species,age,favoriteFoods);
    }
}

// application example
public class Builder{
    public static void main(String[] args){
        /* Approach 1 */
        AnimalBuilder duckBuilder = new AnimalBuilder();      // new a AnimalBuilder
        duckBuilder.setAge(4).setFavoriteFoods(Arrays.asList("grass","fish")).setSpecies("duck");  // use chaining set method
        Animal duck = duckBuilder.build();                   // finally instantiate Animal object with above settings
        
        /* Approach 2 */
        // we can also append the build() method to the chaining! 
        Animal flamingo = new AnimalBuilder() .setFavoriteFoods(Arrays.asList("algae","insects")) .setSpecies("flamingo").build();
    }
}
