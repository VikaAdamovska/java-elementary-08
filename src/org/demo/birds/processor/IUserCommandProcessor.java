package org.demo.birds.processor;

import java.util.Scanner;

public interface IUserCommandProcessor {
    /**
     * @param command команда которую ввел пользователь
     * @param userInputReader объект Scanner который будет использоватеься для чтения дополнительных параметров.
     */
    void processUserCommand(String command, Scanner userInputReader);
}
