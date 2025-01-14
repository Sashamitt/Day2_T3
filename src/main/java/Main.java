import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var scan = new Scanner(System.in);
        var animalCount = readInt(scan); // обработать ошибку
        if (animalCount <= 0) {
            return;
        }
        scan.nextLine();
        var animalList = new ArrayList<Animal>();
        processAnimal(scan, animalCount, animalList);

        animalList.stream().filter(herb -> herb instanceof Herbivore)
                .forEach(a -> System.out.println(a.toString()));

        animalList.stream().filter(herb -> herb instanceof Omnivore)
                .forEach(a -> System.out.println(a.toString()));
    }

    private static void processAnimal(Scanner scan, int animalCount, ArrayList<Animal> animalList) {
        for (int i = 0; i < animalCount; i++) {
            var animalType = scan.nextLine();
            var animal = setAnimalInfo(animalType, scan);
            if (animal != null) animalList.add(animal);
        }
    }

    public static Animal setAnimalInfo(String type, Scanner scan) {
        if (type.equals("dog") || type.equals("cat") || type.equals("guinea") || type.equals("hamster")) {
            var name = scan.nextLine();
            var age = readInt(scan);
            scan.nextLine();
            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                return null;
            }
            return createNewAnimal(type, name, age);
        } else {
            System.out.println("Incorrect input. Unsupported pet type");
            return null;
        }
    }

    public static Animal createNewAnimal(String type, String name, int age) {
        return switch (type) {
            case "dog" -> new Dog(name, age);
            case "cat" -> new Cat(name, age);
            case "guinea" -> new GuineaPig(name, age);
            case "hamster" -> new Hamster(name, age);
            default -> null;
        };
    }

    public static int readInt(Scanner in) {
        while (true) {
            try {
                return in.nextInt();
            } catch (Exception ex) {
                System.out.println("Incorrect input. Age <= 0");
                in.next();
            }
        }
    }
}