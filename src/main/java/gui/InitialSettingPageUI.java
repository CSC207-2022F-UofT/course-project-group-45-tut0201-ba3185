package gui;

import controller.SignupPageController;
import use_case_signin_signup.UserRequestModel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static javax.swing.SpringLayout.*;

public class InitialSettingPageUI extends JPanel {
    public static final int PAGE_HEIGHT = 736;
    public static final int PAGE_WIDTH = 414;

    public InitialSettingPageUI(MainFrameInterface frame, String username, String name, String password) {
        this.setSize(PAGE_WIDTH, PAGE_HEIGHT);
        //this.setResizable(false);
        //this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel parentPanel = new JPanel(new SpringLayout());
        parentPanel.setPreferredSize(new Dimension(PAGE_WIDTH,PAGE_HEIGHT));
        SpringLayout parentLayout = (SpringLayout) parentPanel.getLayout();

        // create Labels
        JLabel age = new JLabel("Age:");
        JLabel income = new JLabel("Income:");
        JLabel location = new JLabel("Location:");
        JLabel gender = new JLabel("Gender:");
        JLabel pet = new JLabel("Pet:");
        JLabel maritalStatus = new JLabel("Marital Status:");
        JLabel relationshipType = new JLabel("Relationship Type:");
        ArrayList<Object> labels = new ArrayList<>(Arrays.asList(age,income,location,gender,pet,maritalStatus,
                relationshipType));

        // create selectors
        String[] genders = {"Male", "Female", "Others"};
        String[] martialStatus = {"Single", "Married", "Widowed", "Divorced"};
        String[] relationshipTypes = {"Straight", "Not Straight"};
        JTextField ageTextField = new JTextField(10);
        JTextField incomeTextField = new JTextField(10);
        JTextField locationLocator = new JTextField(10);
        JComboBox genderChooser = new JComboBox(genders);
        JTextField petTextField = new JTextField(10);
        JComboBox martialStatusChooser = new JComboBox(martialStatus);
        JComboBox relationshipChooser = new JComboBox(relationshipTypes);
        ArrayList<Object> selectors = new ArrayList<>(Arrays.asList(ageTextField,incomeTextField,locationLocator,
                genderChooser, petTextField,martialStatusChooser,relationshipChooser));

        // create and populate selector panel
        JPanel selectorPanel = new JPanel(new SpringLayout());
        selectorPanel.setPreferredSize(new Dimension((int) (PAGE_WIDTH/1.4), PAGE_HEIGHT/2));
        SpringLayout selectorPanelLayout = (SpringLayout) selectorPanel.getLayout();

        for(Object obj : selectors) {
            selectorPanel.add((Component) obj);
        }
        for(Object obj : labels) {
            selectorPanel.add((Component) obj);
        }

        // Initially add the first component of field and label
        selectorPanelLayout.putConstraint(NORTH,age, 7, NORTH, selectorPanel);
        selectorPanelLayout.putConstraint(NORTH, ageTextField, 10, NORTH, selectorPanel);
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

        // Create button and populate panel
        JPanel buttonPanel = new JPanel(new SpringLayout());
        SpringLayout buttonPanelLayout = (SpringLayout) buttonPanel.getLayout();
        buttonPanel.setPreferredSize(new Dimension(PAGE_WIDTH, 100));

        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(PAGE_WIDTH/2, 40));
        buttonPanel.add(submitButton);

        // format buttonPanel
        buttonPanelLayout.putConstraint(HORIZONTAL_CENTER, submitButton, 0, HORIZONTAL_CENTER, buttonPanel);

        parentLayout.putConstraint(HORIZONTAL_CENTER, selectorPanel, 0, HORIZONTAL_CENTER, this);
        parentLayout.putConstraint(NORTH, selectorPanel, PAGE_HEIGHT/4, NORTH, this);
        parentLayout.putConstraint(SOUTH, buttonPanel, 0, SOUTH, this);
        parentPanel.add(selectorPanel);
        parentPanel.add(buttonPanel);

        submitButton.addActionListener( ae -> {
            String currentAge = ageTextField.getText();
            String currentIncome = incomeTextField.getText();
            String currentLocation = locationLocator.getText();
            String currentMaritalStatus = String.valueOf(martialStatusChooser.getSelectedItem());
            String currentGender = String.valueOf(genderChooser.getSelectedItem());
            String currentPet = petTextField.getText();
            String currentRelationshipType = String.valueOf(relationshipChooser.getSelectedItem());

            if(!currentAge.equals("") && !currentIncome.equals("") && !currentLocation.equals("") &&
                    !currentPet.equals("")) {
                int convertedAge = Integer.parseInt(currentAge);
                int convertedIncome = Integer.parseInt(currentIncome);

                try {
                    String[] tmp = currentLocation.split(",");
                    ArrayList<Double> currentLocationSplit = new ArrayList<>();
                    currentLocationSplit.add(Double.valueOf(tmp[0]));
                    currentLocationSplit.add(Double.valueOf(tmp[1]));
                    UserRequestModel requestModel = new UserRequestModel();
                    requestModel.setInfo(username, name, password, convertedAge, convertedIncome, currentGender,
                            currentRelationshipType,currentMaritalStatus,currentPet, currentLocationSplit);
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
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
