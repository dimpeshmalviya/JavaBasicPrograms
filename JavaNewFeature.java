public class NewJavaFeaturesDemo {

    // Record - a concise way to define immutable data carriers
    record Vehicle(String model, String type, double price) {}

    public static void main(String[] args) {
        // Example of Text Blocks (introduced in Java 13)
        String welcomeMessage = """
                ================================
                Welcome to the Vehicle Info System
                ================================
                """;
        System.out.println(welcomeMessage);

        // Creating an instance of Vehicle using a Record
        Vehicle car = new Vehicle("Tesla Model 3", "Electric", 49999.99);

        // Displaying vehicle details
        printVehicleInfo(car);

        // Pattern Matching for instanceof (introduced in Java 16)
        Object obj = car;
        if (obj instanceof Vehicle vehicle) {
            // No need to cast obj to Vehicle, it's done automatically
            System.out.println("\nUsing Pattern Matching for instanceof:");
            System.out.printf("This is a %s (%s) priced at $%.2f\n", vehicle.model(), vehicle.type(), vehicle.price());
        } else {
            System.out.println("The object is not a Vehicle");
        }
    }

    // Method to print Vehicle details using the new "record" feature
    public static void printVehicleInfo(Vehicle vehicle) {
        System.out.println("Vehicle Information:");
        System.out.printf("Model: %s\nType: %s\nPrice: $%.2f\n", vehicle.model(), vehicle.type(), vehicle.price());
    }
}
