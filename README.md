# Group 45 - Dating App

The dating app allows the user to discover their potential dating target through
our three discovery methods(preference, search, and location), 
chat functions, and an ice-breaking game.
The dating app also allows browsing other users' profile page,
and it provides the block function if the user hates someone as well.

## Summary of features in the project
* User can create an account, log in, and log out
* User can fill in a simple questionnaire to provides their personal information that they feel comfortable to share with
* Use can use discovery to explore other users
  * _By preference_ is to look for others that share a similar perspective on the importance of characteristics
  * _By search_ asks user to fill the specific range of characteristics that he/she is looking for
  * _By location_ is to look for others that are close to the user's location
* User can use chat function to communicate with other users, and the chat history is displayed in the chat window
* User can play the two lies and a truth game with other users
* User can block other users from their profile page

## Instruction on how to use the dating app for each feature
1. By running the Main file, a window will pop up that asks to fill in account information(if new user)
2. New user will also be asked to fill in personal information, after filling in, click the _submit_ button
3. User with existed account can just log in 
4. To use discovery feature:
   * click the discovery button(the magnifier icon) on the navigation panel at the bottom,
   and it will bring you to the page of discovery with three buttons indicating different discovery methods
   *  after clicking one of the method button, a yellow panel will pop up 15 buttons with other users' name on it
   * click the button with username allows you to browse the user's info
   * the user info page also comes with chat button and block button
5. To use chat feature
6. To use two truths and a lie feature
7. To use block feature


/////////////////////////////Template below//////////////////////////

**If your team has trouble with any of these steps, please ask on Piazza. For example, with how GitHub Classroom works, your team *may* not have permissions to do some of the first few steps, in which case we'll post alternative instructions as needed.**

## Workflow Documents

* Github Workflow: Please refer to the workflow that was introduced in the first lab. You should follow this when working on your code. The following document provides additional details too.

* [Project Planning and Development Guide](project_plan_dev.md): This document helps you to understand how to create and maintain a project plan for your class project. **This document helps you to complete the Implementation Plan Milestone.**

## Gradle Project
Import this project into your Intellij editor. It should automatically recognise this as a gradle repository.
The starter code was built using SDK version 11.0.1. Ensure that you are using this version for this project. (You can, of course, change the SDK version as per your requirement if your team has all agreed to use a different version)

You have been provided with two starter files for demonstration: HelloWorld and HelloWorldTest.

You will find HelloWorld in `src/main/java/tutorial` directory. Right click on the HelloWorld file and click on `Run HelloWorld.main()`.
This should run the program and print on your console.

You will find HelloWorldTest in `src/test/java/tutorial` directory. Right click on the HelloWorldTest file and click on `Run HelloWorldTest`.
All tests should pass. Your team can remove this sample of how testing works once you start adding your project code to the repo.

Moving forward, we expect you to maintain this project structure. You *should* use Gradle as the build environment, but it is fine if your team prefers to use something else -- just remove the gradle files and push your preferred project setup. Assuming you stick with Gradle, your source code should go into `src/main/java` (you can keep creating more subdirectories as per your project requirement). Every source class can auto-generate a test file for you. For example, open HelloWorld.java file and click on the `HelloWorld` variable as shown in the image below. You should see an option `Generate` and on clicking this your should see an option `Test`. Clicking on this will generate a JUnit test file for `HelloWorld` class. This was used to generate the `HelloWorldTest`.

![image](https://user-images.githubusercontent.com/5333020/196066655-d3c97bf4-fdbd-46b0-b6ae-aeb8dbcf351d.png)

You can create another simple class and try generating a test for this class.
