package org.demo.birds.store;

import org.demo.birds.entities.Bird;

import java.util.*;

public class BirdStore extends AbstractBirdStore {
    private Map<String, Bird> birdNames = new LinkedHashMap<>();
    private Map<String, ArrayList> birdAreas = new LinkedHashMap<>();

    private static final BirdStore INSTANCE = new BirdStore();

    public static BirdStore getInstance() {
        return INSTANCE;
    }

    private BirdStore() {
    }

    @Override
    public void addBird(Bird b) {
        ArrayList<Bird> birds;
        System.out.println(b.getName());
        if (!(birdNames.containsKey(b.getName()))) {
            birdNames.put(b.getName(), b);
            if (!(birdAreas.containsKey(b.getLivingArea()))) {
                birds = new ArrayList<>();
            } else {
                birds = birdAreas.get(b.getLivingArea());
            }
            birds.add(b);
            birdAreas.put(b.getLivingArea(), birds);
        } else {
            System.out.println("Bird With name " + b.getName() + " already exists");
        }
    }

    @Override
    public Bird searchByName(String nameToSearch) {
        if (birdNames.containsKey(nameToSearch)) {
            return birdNames.get(nameToSearch);
        }
        return null;
    }

    @Override
    public List searchByLivingArea(String livingAreaToFind) {
        if (birdAreas.containsKey(livingAreaToFind)) {
            return birdAreas.get(livingAreaToFind);
        }
        return null;
    }
}
