import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int bestAttempts = Integer.MAX_VALUE;
        int totalAttempts = 0;
        int gamesPlayed = 0;
        System.out.println("Привет! Я загадал число от 1 до 100. Попробуй угадать!");
        while (true) {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            System.out.println("Новая игра!");
            while (true) {
                System.out.print("Твоя догадка: ");
                int guess = scanner.nextInt();
                attempts++;
                totalAttempts++;
                if (guess == secretNumber) {
                    System.out.println("Бро! Красава! Ты угадал число " + secretNumber + " за " + attempts + " попыток.");
                    if (attempts < bestAttempts) {
                        bestAttempts = attempts;
                    }
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Я сам в шоке, но, загаданное число больше, брат");
                } else {
                    System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
                }
            }
            System.out.print("Бро, продолжаем игру? (yes/no/RESULT): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("no")) {
                break;
            } else if (choice.equalsIgnoreCase("RESULT")) {
                System.out.println("Результаты игры:");
                System.out.println("Всего попыток: " + totalAttempts);
                if (gamesPlayed > 0) {
                    System.out.println("Сыгранных игр: " + gamesPlayed);
                    System.out.println("Лучшие попытки: " + bestAttempts);
                } else {
                    System.out.println("Бро, ни одна игра не была сыграна полностью.");
                }
            }
            gamesPlayed++;
        }
        scanner.close();
    }
}