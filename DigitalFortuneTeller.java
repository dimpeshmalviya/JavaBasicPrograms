import java.util.*;

public class DigitalFortuneTeller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] fortunes = {
            "You will achieve something great today 🌟",
            "An unexpected message will make you smile 📩",
            "Focus brings success. Stay consistent 💪",
            "A small risk may bring big rewards 🎯",
            "Happiness finds you when you help others 🤝"
        };

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        int index = Math.abs(name.hashCode()) % fortunes.length;
        System.out.println("\n🔮 Fortune for " + name + ": " + fortunes[index]);
        sc.close();
    }
}
