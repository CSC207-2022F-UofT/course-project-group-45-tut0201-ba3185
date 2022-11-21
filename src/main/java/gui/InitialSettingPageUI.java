package gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

import static javax.swing.SpringLayout.*;

public class InitialSettingPageUI extends JFrame {
    public static final int PAGE_HEIGHT = 736;
    public static final int PAGE_WIDTH = 414;

    public InitialSettingPageUI() {
        this.setSize(PAGE_WIDTH, PAGE_HEIGHT);
        this.setResizable(false);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
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
        JLabel relationshipType = new JLabel("Relationship Type");
        ArrayList<Object> labels = new ArrayList<>(Arrays.asList(age,income,location,gender,maritalStatus,
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
        selectorPanel.setPreferredSize(new Dimension((int) (PAGE_WIDTH/2), PAGE_HEIGHT/2));
        SpringLayout selectorPanelLayout = (SpringLayout) selectorPanel.getLayout();

        for(Object obj : selectors) {
            selectorPanel.add((Component) obj);
        }
        for(Object obj : labels) {
            selectorPanel.add((Component) obj);
        }

        // Format label to West wall of Panel
        for(Object obj : labels) {
            selectorPanelLayout.putConstraint(WEST, (Component) obj, 0 , WEST, selectorPanel);
        }

        // Format selectors to East wall of panel
        for(Object obj : selectors) {
            selectorPanelLayout.putConstraint(EAST, (Component) obj, 0, EAST, selectorPanel);
        }

        // Format distances between labels
        selectorPanelLayout.putConstraint(NORTH,age, 7, NORTH, selectorPanel);
        for(int i = 1; i < labels.size(); i++) {
            selectorPanelLayout.putConstraint(NORTH, (Component) labels.get(i), 15, NORTH,
                    (Component) labels.get(i-1));
        }

        // Format distances between selectors
        selectorPanelLayout.putConstraint(NORTH, ageTextField, 10, NORTH, selectorPanel);
        for(int i = 1; )
    }
}
