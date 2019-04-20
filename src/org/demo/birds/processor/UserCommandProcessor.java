package org.demo.birds.processor;

import org.demo.birds.entities.Bird;
import org.demo.birds.store.BirdStore;

import java.util.Scanner;

/**
 * Реализовать интерфейсы IBirdCreator, IUserCommandProcessor, IInfiniteLoopProcessor
 */
public class UserCommandProcessor implements IBirdCreator, IInfiniteLoopProcessor, IUserCommandProcessor {

    @Override
    public Bird createBird(Scanner userInputReader) {

        System.out.println("Please, enter bird name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Please, enter bird living area");
        String livingArea = scanner.nextLine();
        System.out.println("Please, enter bird size");
        double size = scanner.nextDouble();

        Bird bird = new Bird(name, livingArea, size);
        BirdStore.getInstance().addBird(bird);
        return bird;
    }

    /**
     * 1) В бесконечном цикле просим пользователя ввести комманду:
     * <p>
     * Please, enter command:
     * a - add new Bird
     * s - search bird by name
     * l - search bird by living area
     * exit - terminate application
     * 2) пользователь вводит комманду.
     */
    public void processInLoop() {
        boolean continueLoop = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please, enter command: ");
            System.out.println("   a - add new Bird");
            System.out.println("   s - search bird by name ");
            System.out.println("   l - search bird by living area");
            System.out.println("   exit - terminate application");
            String command = scanner.nextLine();

            if (command.equals("exit")) {
                continueLoop = false;
            } else {
                processUserCommand(command, scanner);
            }
        } while (continueLoop);
    }

    /**
     * Выполняет комманлу пользователя
     * <p>
     * 1) если введена комманда a:
     * - запрашиваем у пользователя Please, enter bird name
     * - читаем введенное значение
     * - запрашиваем у пользователя Please, enter bird living area
     * - читаем введенное значение
     * - запрашиваем у пользователя Please, enter bird size
     * - читаем введенное значение
     * - вызываем соответствующий метод BirdStore.
     * <p>
     * 2) если введена комманда s:
     * - запрашиваем у пользователя Please, enter bird name to search
     * - читаем введенное значение
     * - находим объект с такми именем BirdStore, печатаем Find bird : ....
     * <p>
     * 3) если введена комманда l:
     * - запрашиваем у пользователя Please, enter bird living area to search
     * - читаем введенное значение
     * - находим объекты с такми living area в BirdStore, печатаем Find bird : ....
     * <p>
     * 4) если комманда неизвестна - выводим Unknown command.
     *
     * @param command         команда которую ввел пользователь
     * @param userInputReader объект Scanner который будет использоватеься для чтения дополнительных параметров.
     */
    public void processUserCommand(String command, Scanner userInputReader) {
        if (command.equals("a")) {
            createBird(userInputReader);

        } else if (command.equals("s")) {
            System.out.println("Please, enter bird name to search");
            String birdName = userInputReader.nextLine();
            Bird bird =  BirdStore.getInstance().searchByName(birdName);
            if(bird == null){
                System.out.println("Bird not found");
            }else{
                System.out.println("Find bird: " + bird);
            }

        } else if (command.equals("l")) {
            System.out.println("Please, enter bird living area to search");
            String livingArea = userInputReader.nextLine();

            System.out.println("Find birds: ");
            for(Object name : BirdStore.getInstance().searchByLivingArea(livingArea)){
                System.out.println(name.toString());
            }

        } else {
            System.out.println("Unknown command");
        }
    }
}
