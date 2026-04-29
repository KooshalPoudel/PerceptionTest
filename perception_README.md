# Perception Test

A Java Swing program that quizzes the user with a picture-based perception test featuring random animals and actions. Built as a CSCI 281 project to practice arrays, methods, loops, and Swing dialogs with images.

## Features

- Three test modes: guess the **animal**, guess the **action**, or guess **both**
- Five rounds per session, with the option to keep playing or quit afterward
- Score tracking for animals, actions, and combined accuracy
- Image-based feedback for correct and incorrect guesses

## Requirements

- JDK 11 or newer
- The `images/` folder must be present (contains all the PNG assets used by the dialogs)

## Running the Program

From the project root directory:

```
javac -d . src\PerceptionTest.java
java PerceptionTest
```

Or open the project in NetBeans and click Run.

## How It Works

The user picks one of three test types. The program then randomly picks an animal (Cow, Dog, Monkey, Cat, or Donkey), an action (Eating, Sleeping, Walking, Drinking, or Dancing), or both, and asks the user to guess. After every 5 rounds, the user sees their score and can choose to quit or play another 5 rounds.

## Author

Kushal Poudel
