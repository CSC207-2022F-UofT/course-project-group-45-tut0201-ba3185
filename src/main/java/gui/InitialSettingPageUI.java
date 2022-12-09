package gui;

import controller.SignupPageController;
import use_case_signin_signup.UserRequestModel;

import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static javax.swing.SpringLayout.*;

public class InitialSettingPageUI extends JPanel {

    public InitialSettingPageUI(MainFrameInterface frame, String username, String name, String password) {
        this.setSize(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT);
        JPanel parentPanel = new JPanel(new SpringLayout());
        parentPanel.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH,MainFrame.PAGE_HEIGHT));
        SpringLayout parentLayout = (SpringLayout) parentPanel.getLayout();

        // create Labels
        JLabel age = new JLabel("Age:");
        JLabel income = new JLabel("Income:");
        JLabel location = new JLabel("Location:");
        JLabel gender = new JLabel("Gender:");
        JLabel pet = new JLabel("Pet:");
        JLabel maritalStatus = new JLabel("Marital Status:");
        JLabel relationshipType = new JLabel("Relationship Type:");
        JLabel sexualOrientationType = new JLabel("Sexual Orentation:");
        JLabel interestAreaLabel = new JLabel("What are you interested in:");
        JLabel interestRank = new JLabel("Which of these are the most important to you:");
        ArrayList<Object> labels = new ArrayList<>(Arrays.asList(age,income,location,gender,pet,maritalStatus,
                relationshipType, sexualOrientationType, interestAreaLabel, interestRank));

        // create selectors
        String[] genders = {"male", "female", "others"};
        String[] martialStatus = {"single", "married", "divorced"};
        String[] relationshipTypes = {"friend", "one-night", "long-term","short-term"};
        String[] sexualOrientations = {"male", "female", "bisexual"};
        String[] booleanTypes = {"yes", "no"};
        String[] interestRanks = {"income", "age", "marital status", "interests", "relationship type", "pet"};
        String[] interestArea = {"sport", "art", "music", "game", "movie", "cooking", "reading"};
        JTextField ageTextField = new JTextField(10);
        JTextField incomeTextField = new JTextField(10);
        JTextField locationLocator = new JTextField(10);
        JComboBox<String> genderChooser = new JComboBox<>(genders);
        JComboBox<String> petTextField = new JComboBox<>(booleanTypes);
        JComboBox<String> martialStatusChooser = new JComboBox<>(martialStatus);
        JComboBox<String> relationshipChooser = new JComboBox<>(relationshipTypes);
        JComboBox<String> sexualOrientationChooser = new JComboBox<>(sexualOrientations);
        JComboBox<String> interestRankChooser = new JComboBox<>(interestRanks);
        JComboBox<String> interestAreaChooser = new JComboBox<>(interestArea);
        ArrayList<Object> selectors = new ArrayList<>(Arrays.asList(ageTextField,incomeTextField,locationLocator,
                genderChooser, petTextField,martialStatusChooser,relationshipChooser, sexualOrientationChooser,
                interestAreaChooser, interestRankChooser));

        // create and populate selector panel
        JPanel selectorPanel = new JPanel(new SpringLayout());
        selectorPanel.setPreferredSize(new Dimension((int) (MainFrame.PAGE_WIDTH/1.4), (int) (MainFrame.PAGE_HEIGHT/1.7)));
        SpringLayout selectorPanelLayout = (SpringLayout) selectorPanel.getLayout();

        for(Object obj : selectors) {
            selectorPanel.add((Component) obj);
        }
        for(Object obj : labels) {
            selectorPanel.add((Component) obj);
        }

        // Initially add the first component of field and label
        selectorPanelLayout.putConstraint(NORTH,age, 7, NORTH, selectorPanel);
        selectorPanelLayout.putConstraint(NORTH, ageTextField, 7, NORTH, selectorPanel);
        selectorPanelLayout.putConstraint(WEST, age , 0 , WEST, selectorPanel);
        selectorPanelLayout.putConstraint(EAST, ageTextField, 0 ,EAST, selectorPanel);
        for(int i = 1; i < labels.size(); i++) {
            selectorPanelLayout.putConstraint(WEST, (Component) labels.get(i), 0 , WEST, selectorPanel);
            selectorPanelLayout.putConstraint(EAST, (Component) selectors.get(i), 0, EAST, selectorPanel);
            selectorPanelLayout.putConstraint(NORTH, (Component) labels.get(i), 27, SOUTH,
                    (Component) labels.get(i-1));
            selectorPanelLayout.putConstraint(NORTH, (Component) selectors.get(i), 15, SOUTH,
                    (Component) selectors.get(i-1));
        }

        selectorPanelLayout.putConstraint(NORTH, interestRankChooser, 40, SOUTH, interestAreaChooser);

        // Create button and populate panel
        JPanel buttonPanel = new JPanel(new SpringLayout());
        SpringLayout buttonPanelLayout = (SpringLayout) buttonPanel.getLayout();
        buttonPanel.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, 100));

        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH/2, 45));
        buttonPanel.add(submitButton);

        // format buttonPanel
        buttonPanelLayout.putConstraint(HORIZONTAL_CENTER, submitButton, 0, HORIZONTAL_CENTER, buttonPanel);

        parentLayout.putConstraint(HORIZONTAL_CENTER, selectorPanel, 0, HORIZONTAL_CENTER, this);
        parentLayout.putConstraint(NORTH, selectorPanel, MainFrame.PAGE_HEIGHT/6, NORTH, this);
        parentLayout.putConstraint(SOUTH, buttonPanel, 0, SOUTH, this);
        parentPanel.add(selectorPanel);
        parentPanel.add(buttonPanel);

        submitButton.addActionListener( ae -> {
            String currentAge = ageTextField.getText();
            String currentIncome = incomeTextField.getText();
            String currentLocation = locationLocator.getText();
            String currentMaritalStatus = String.valueOf(martialStatusChooser.getSelectedItem());
            String currentGender = String.valueOf(genderChooser.getSelectedItem());
            String currentPet = String.valueOf(petTextField.getSelectedItem());
            String currentRelationshipType = String.valueOf(relationshipChooser.getSelectedItem());
            String sexualOrientation = String.valueOf(sexualOrientationChooser.getSelectedItem());
            String interestRankChosen = String.valueOf(interestRankChooser.getSelectedItem());
            String interestAreaChosen = String.valueOf(interestAreaChooser.getSelectedItem());

            if(!currentAge.equals("") && !currentIncome.equals("") && !currentLocation.equals("") &&
                    !currentPet.equals("")) {
                int convertedAge = Integer.parseInt(currentAge);
                int convertedIncome = Integer.parseInt(currentIncome);

                try {
                    String[] tmp = currentLocation.split(",");
                    if(tmp.length != 2) {
                        JOptionPane.showMessageDialog(null, "Please enter the location as: " +
                            "Longitude, Latitude");
                    }
                    ArrayList<Double> currentLocationSplit = new ArrayList<>();
                    currentLocationSplit.add(Double.valueOf(tmp[0]));
                    currentLocationSplit.add(Double.valueOf(tmp[1]));
                    UserRequestModel requestModel = new UserRequestModel();

                    List<String> interest = new ArrayList<>(Arrays.asList("income", "age", "marital status",
                            "interests", "relationship type", "pet"));
                    interest.remove(interestRankChosen);

                    List<String> interestR = new ArrayList<>();
                    interestR.add(interestAreaChosen);
                    interestR.addAll(interest);

                    requestModel.setInfo(username, name, password, convertedAge, convertedIncome, currentGender,
                            currentRelationshipType,currentMaritalStatus,currentPet, currentLocationSplit,
                            sexualOrientation, interestR, interestAreaChosen);
                    Boolean isUserRegistered = new SignupPageController().create(requestModel);

                    if (isUserRegistered) {
                        frame.switchToMain();
                        // move to main panel
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Something went wrong, try again later");
                    }
                }
                catch (IOException exception) {
                    throw new RuntimeException(exception);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Please fill in all fields before submitting");
            }

        });

        this.add(parentPanel);
    }
}
