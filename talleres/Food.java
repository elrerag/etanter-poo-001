package talleres;
import java.util.ArrayList;

interface IFood {
    String getName();
    int getCalories();
    double getPrice();
}

abstract class AbstractFood implements IFood {
    String name;
    double price;
    int calories;

    protected AbstractFood(String name, int calories, double price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public int getCalories(){
        return this.calories;
    }

    public double getPrice(){
        return this.price;
    }

}

abstract class Ingredient extends AbstractFood {

    protected Ingredient(String name, int calories, double price) {
        super(name, calories, price);
    }}

abstract class Pizza extends AbstractFood {
    ArrayList<IFood> ingredients;

    Pizza(String name, int calories, double price) {
        super(name, calories, price);
        ingredients = new ArrayList<>();
    }

    @Override
    public String getName() {
        String newName = "";
        for(IFood ingredient : ingredients) {
            newName += " " + ingredient.getName();
        }

        return this.name + " " + newName;
    }

    public void addIngredient(IFood ingredient) {
        this.ingredients.add(ingredient);
    }

    public int getCalories() {
        int newCalories = 0;
        for(IFood ingredient : ingredients) {
            newCalories += ingredient.getCalories();
        }
        return this.calories + newCalories;
    }

    public double getPrice() {
        double newPrice = 0;
        for(IFood ingredient : ingredients) {
            newPrice += ingredient.getPrice();
        }
        return this.calories + newPrice;
    }

}

class PizzaStore {
    IFood orderSimplePizza() {
        IFood thinDough = new ThinDough("name", 1000, 10.0);
        ((ThinDough) thinDough).addIngredient(new Cheese("cheese", 1000, 2.0));
        return new ThinDough("ThinDough", 1000, 10);
    }
}

class ThickDough extends Pizza {

    protected ThickDough(String name, int calories, double price) {
        super(name, calories, price);
    }
}
class ThinDough extends Pizza {

    protected ThinDough(String name, int calories, double price) {
        super(name, calories, price);
    }}

class BBQSauce extends Ingredient {
    BBQSauce(String name, int calories, double price) {
        super(name, calories, price);
    }
}
class  Cheese extends Ingredient {
    Cheese(String name, int calories, double price) {
        super(name, calories, price);
    }
}
class  Pepperoni extends Ingredient {
    Pepperoni(String name, int calories, double price) {
        super(name, calories, price);
    }
}
class  Tomato extends Ingredient {
    Tomato(String name, int calories, double price) {
        super(name, calories, price);
    }
}



public class Food {

    public static void main(String[] args) {
        IFood bbqSauce = new BBQSauce("bbq sauce", 194, 1.0);
        IFood cheese = new BBQSauce("cheese", 299, 3.0);
        IFood pepperoni = new BBQSauce("bbq sauce", 495, 5.0);
        IFood tomato = new BBQSauce("bbq sauce", 15, 2.0);

        IFood thickDough = new ThickDough("thick dough", 100, 5.0);
        IFood thinDough = new ThinDough("thin dough", 50, 3.0);
    }
}

