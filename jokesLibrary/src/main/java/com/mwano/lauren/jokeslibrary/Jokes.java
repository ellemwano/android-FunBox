package com.mwano.lauren.jokeslibrary;

import java.util.ArrayList;
import java.util.Random;

public class Jokes {

    private String mJoke;
    private Random mRandom;
    private ArrayList<String> jokesList = new ArrayList<>();

    // Constructor
    public Jokes(String joke){
    }

    public Jokes() {
    }

    public ArrayList<String> getJokesList() {
        jokesList.add("What is a prisoner's favourite punctuation mark?\n" +
                        "\n" +
                        "A period, because it marks the end of his sentence.");
        jokesList.add("Why don't programmers like nature?\n" +
                        "\n" +
                        "It has too many bugs.");
        jokesList.add("Why can't you trust stairs?\n" +
                        "\n" +
                        "Because they're always up to something.");
        jokesList.add("Why can't a bicycle stand on its own?\n" +
                        "\n" +
                        "Because it's two-tired.");
        jokesList.add("How do your throw a space party?\n" +
                        "\n" +
                        "You planet.");
        jokesList.add("Why did the energizer bunny go to jail?\n" +
                        "\n" +
                        "He was charged with battery.");
        jokesList.add("Why shouldn't you trust atoms?\n" +
                        "\n" +
                        "Because they make up everything.");
        jokesList.add("How do trees access the internet?\n" +
                        "\n" +
                        "They log on.");
        jokesList.add("What does the clock do when it's hungry?\n" +
                        "\n" +
                        "It goes back four seconds.");
        jokesList.add("What do dogs do after they finish obedience school?\n" +
                        "\n" +
                        "They get their masters.");
        return jokesList;
    }


    public String getJoke() {
        mRandom = new Random();
        int index = mRandom.nextInt(jokesList.size());
        mJoke = jokesList.get(index);
        return mJoke;
    }

    public void setJoke(String joke) {
        mJoke = joke;
    }

}
