import java.util.Scanner;

class CAR {
    String car_manufacturer;
    String Model;
    String Transmission_variant;
    String Fuel_type;
    String Color;
    String Location;

    CAR(String car_manufacturer, String Model, String Transmission_variant, String Fuel_type, String Color, String Location) {
        this.car_manufacturer = car_manufacturer;
        this.Model = Model;
        this.Transmission_variant = Transmission_variant;
        this.Fuel_type = Fuel_type;
        this.Color = Color;
        this.Location = Location;
    }

    void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Manufacturer: " + car_manufacturer);
        System.out.println("Model: " + Model);
        System.out.println("Transmission: " + Transmission_variant);
        System.out.println("Fuel Type: " + Fuel_type);
        System.out.println("Color: " + Color);
        System.out.println("Location: " + Location);
    }
}

public class CarManufacturer {

    CAR createCar(String car_manufacturer, String Model, String Transmission_variant, String Fuel_type, String Color, String Location) {
        return new CAR(car_manufacturer, Model, Transmission_variant, Fuel_type, Color, Location);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarManufacturer mainObj = new CarManufacturer();

        String[] manufacturers = {"Mahindra", "Tata", "Maruti"};
        String[][] models = {
                {"Scorpio", "Thar", "Scorpio N", "XUV 700"},
                {"Nexon", "Harrier", "Punch", "Safari"},
                {"Swift", "Baleno", "WagonR", "Dzire"}
        };
        String[] transmissions = {"Manual", "Automatic"};
        String[] fuelTypes = {"Diesel", "Petrol", "CNG"};
        String[] colors = {"Silver", "Blue", "Yellow"};
        String[] locations = {"Delhi", "Bangalore", "Hyderabad", "Chennai"};

        System.out.println("Select:-Car Manufacturer \n 1.Mahindra \n 2.Tata \n 3.Maruti ");
        int option1 = sc.nextInt();
        if (option1 < 1 || option1 > 3) {
            System.out.println("Invalid Manufacturer Option!");
            return;
        }
        String selectedManufacturer = manufacturers[option1 - 1];

        System.out.println("Model (for " + selectedManufacturer + "):");
        for (int i = 0; i < models[option1 - 1].length; i++) {
            System.out.println((i + 1) + ". " + models[option1 - 1][i]);
        }
        int option2 = sc.nextInt();
        if (option2 < 1 || option2 > models[option1 - 1].length) {
            System.out.println("Invalid Model Option!");
            return;
        }
        String selectedModel = models[option1 - 1][option2 - 1];

        System.out.println("Transmission Variant: \n1.Manual \n2.Automatic ");
        int option3 = sc.nextInt();
        if (option3 < 1 || option3 > 2) {
            System.out.println("Invalid Transmission Option!");
            return;
        }
        String selectedTransmission = transmissions[option3 - 1];

        System.out.println("Fuel Type: \n1.Diesel \n2.Petrol \n3.CNG ");
        int option4 = sc.nextInt();
        if (option4 < 1 || option4 > 3) {
            System.out.println("Invalid Fuel Type Option!");
            return;
        }
        String selectedFuel = fuelTypes[option4 - 1];

        System.out.println("Color \n1.Silver \n2.Blue \n3.Yellow ");
        int option5 = sc.nextInt();
        if (option5 < 1 || option5 > 3) {
            System.out.println("Invalid Color Option!");
            return;
        }
        String selectedColor = colors[option5 - 1];

        System.out.println("Location: \n1.Delhi \n2.Bangalore \n3.Hyderabad \n4.Chennai ");
        int option6 = sc.nextInt();
        if (option6 < 1 || option6 > 4) {
            System.out.println("Invalid Location Option!");
            return;
        }
        String selectedLocation = locations[option6 - 1];

        CAR userCar = mainObj.createCar(selectedManufacturer, selectedModel, selectedTransmission, selectedFuel, selectedColor, selectedLocation);
        userCar.displayDetails();
    }
}
