package org.demo.birds.processor;

import org.demo.birds.entities.Bird;

import java.util.Scanner;

public interface IBirdCreator {
    /**
     * @param userInputReader объект Scanner который будет использоваться для чтения комманд.
     *
     * @return объект типа Bird
     */
    Bird createBird(Scanner userInputReader);
}
