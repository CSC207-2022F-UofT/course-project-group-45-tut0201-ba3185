package gui.discovery;

import controller.SearchController;
import use_case_discovery.SearchQuestionInterface;
import use_case_discovery.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SearchQuestionPanel extends JPanel implements SearchQuestionInterface {

    public static final int PAGE_WIDTH = 414;
    public static final int PAGE_HEIGHT = 736;
    public static List<Integer> answerList = new ArrayList<>();


    public void update(SearchAskResponseModel sResponseModel) {

        this.setBackground(Color.PINK);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBounds(0, 0, PAGE_WIDTH * 9 /10,PAGE_HEIGHT * 9 /10);

        JLabel incomeQuestionLabel = new JLabel();
        incomeQuestionLabel.setBounds(20, 20, 160, 20);
        incomeQuestionLabel.setText(sResponseModel.getIncomeQuestion());
        this.add(incomeQuestionLabel);

        TextField incomeLowTextField = new TextField();
        incomeLowTextField.setBounds(40, 80, 50, 20);
        this.add(incomeLowTextField);

        JLabel connect = new JLabel();
        connect.setText("to");
        connect.setBounds(93, 80, 10, 10);
        this.add(connect);

        TextField incomeHighTextField = new TextField();
        incomeHighTextField.setBounds(120, 80, 50, 20);
        this.add(incomeHighTextField);


        // question 2

        JLabel ageQuestionLabel = new JLabel();
        ageQuestionLabel.setBounds(40, 70, 160, 20);
        ageQuestionLabel.setText(sResponseModel.getAgeQuestion());
        this.add(ageQuestionLabel);

        TextField ageLowTextField = new TextField();
        ageLowTextField.setBounds(20, 95, 50, 20);
        this.add(ageLowTextField);

        JLabel connectM = new JLabel();
        connectM.setText("to");
        connectM.setBounds(73, 95, 10, 10);
        this.add(connectM);

        TextField ageHighTextField = new TextField();
        ageHighTextField.setBounds(85, 95, 50, 20);
        this.add(ageHighTextField);

        JLabel marriageQuestion = new JLabel(sResponseModel.getMarriageQuestion());
        marriageQuestion.setBounds(10, 10, 100, 20);
        this.add(marriageQuestion);

        String[] marriageOption = sResponseModel.getMarriageOption();
        JComboBox<String> marriageComboBox = new JComboBox<>(marriageOption);
        marriageComboBox.setBounds(20,30,20, 40);
        this.add(marriageComboBox);

        JLabel hobbyQuestion = new JLabel(sResponseModel.getHobbyQuestion());
        hobbyQuestion.setBounds(10, 70, 100, 20);
        this.add(hobbyQuestion);

        String[] hobbyOption = sResponseModel.getHobbyOption();
        JComboBox<String> hobbyComboBox = new JComboBox<>(hobbyOption);
        hobbyComboBox.setBounds(20,80,20, 40);
        this.add(hobbyComboBox);


        JLabel relationshipQuestion = new JLabel(sResponseModel.getRelationshipQuestion());
        relationshipQuestion.setBounds(10, 130, 100, 20);
        this.add(relationshipQuestion);
        String[] relationshipOption = sResponseModel.getRelationshipOption();
        JComboBox<String> relationshipComboBox = new JComboBox<>(relationshipOption);
        relationshipComboBox.setBounds(20,155,20, 40);
        this.add(relationshipComboBox);

        JLabel petOptionQuestion = new JLabel(sResponseModel.getPetQuestion());
        petOptionQuestion.setBounds(10, 200, 100, 20);
        this.add(petOptionQuestion);

        String[] petOption = sResponseModel.getPetOption();
        JComboBox<String> petOptionComboBox = new JComboBox<>(petOption);
        petOptionComboBox.setBounds(20,230,20, 40);
        this.add(petOptionComboBox);


        JButton submitButton = new JButton();
        submitButton.setText("submit");
        submitButton.setBounds(70,PAGE_HEIGHT * 9 /10, 20, 20);
        submitButton.setActionCommand("submit");

        submitButton.addActionListener(e -> {
            answerList = new ArrayList<>();

            if(! incomeLowTextField.getText().equals("") && ! incomeHighTextField.getText().equals("") &&
                    ! ageLowTextField.getText().equals("") && ! ageHighTextField.getText().equals("")) {
                int incomeLow = Integer.parseInt(incomeLowTextField.getText());
                int incomeHigh = Integer.parseInt((incomeHighTextField.getText()));
                int ageLow = Integer.parseInt(ageLowTextField.getText());
                int ageHigh = Integer.parseInt((ageHighTextField.getText()));
                answerList.add(incomeLow);

                answerList.add(incomeHigh);

                answerList.add(ageLow);

                answerList.add(ageHigh);
                int marriageOp = marriageComboBox.getSelectedIndex();
                answerList.add(marriageOp);
                int hobbyOp = hobbyComboBox.getSelectedIndex();
                answerList.add(hobbyOp);
                int relationshipOp = relationshipComboBox.getSelectedIndex();
                answerList.add(relationshipOp);
                int petOp = petOptionComboBox.getSelectedIndex();
                answerList.add(petOp);

                this.removeAll();

                UsersBtnPanel usersBtnPanel = new UsersBtnPanel();
                SearchInputBoundary searchInteractor = new SearchInteractor(usersBtnPanel);
                SearchController controller = new SearchController(answerList, searchInteractor);
                controller.generateRecommendation();
                this.add(usersBtnPanel);
                this.revalidate();
                this.setVisible(true);
            }
            else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields before submitting");
        }
            this.add(this);



        });
        this.add(submitButton);

    }

}
