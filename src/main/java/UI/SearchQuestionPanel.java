package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchQuestionPanel extends JPanel implements SearchQuestionPanelInterface{
    private ArrayList<ActionListener> actionListeners;

    private SearchAskerViewModel viewModel;

    public SearchQuestionPanel(){this.actionListeners = new ArrayList<>();}


    public void update(int width, int height, SearchAskerViewModel viewModel) {

        this.setBackground(Color.PINK);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBounds(0, 0, width,height);

        JLabel questionTitle = new JLabel();
        questionTitle.setBounds(20, 20, 160, 20);
        questionTitle.setText(viewModel.getIncomeQuestion());
        this.add(questionTitle);

        TextField textFieldLow = new TextField();
        textFieldLow.setBounds(40, 80, 50, 20);
        //textFieldLow.setBackground(Color.cyan);
        this.add(textFieldLow);

        JLabel connect = new JLabel();
        connect.setText("to");
        connect.setBounds(93, 80, 10, 10);
        this.add(connect);

        TextField textFieldHigh = new TextField();
        textFieldHigh.setBounds(120, 80, 50, 20);
        this.add(textFieldHigh);


        // question 2

        JLabel questionTitle2 = new JLabel();
        questionTitle2.setBounds(40, 70, 160, 20);
        questionTitle2.setText(viewModel.getAgeQuestion());
        this.add(questionTitle2);

        TextField textField2Low = new TextField();
        textField2Low.setBounds(20, 95, 50, 20);
        this.add(textField2Low);

        JLabel connectM = new JLabel();
        connectM.setText("to");
        connectM.setBounds(73, 95, 10, 10);
        this.add(connectM);

        TextField textField2High = new TextField();
        textField2High.setBounds(85, 95, 50, 20);
        this.add(textField2High);
        JLabel marriageQuestion = new JLabel(viewModel.getMarriageQuestion());
        marriageQuestion.setBounds(10, 10, 100, 20);
        this.add(marriageQuestion);

        String marriageOption[] = viewModel.getMarriageOption();
        JComboBox marriageComboBox = new JComboBox(marriageOption);
        marriageComboBox.setBounds(20,30,20, 40);
        this.add(marriageComboBox);

        JLabel hobbyQuestion = new JLabel(viewModel.getHobbyQuestion());
        hobbyQuestion.setBounds(10, 70, 100, 20);
        this.add(hobbyQuestion);
        String sportOption[] = viewModel.getHobbyOption();
        JComboBox sportComboBox = new JComboBox(sportOption);
        sportComboBox.setBounds(20,80,20, 40);
        this.add(sportComboBox);


        JLabel relationshipQuestion = new JLabel(viewModel.getRelationshipQuestion());
        relationshipQuestion.setBounds(10, 130, 100, 20);
        this.add(relationshipQuestion);
        String relationshipOption[] = viewModel.getRelationshipOption();
        JComboBox relationshipComboBox = new JComboBox(relationshipOption);
        relationshipComboBox.setBounds(20,155,20, 40);
        this.add(relationshipComboBox);

        JLabel petOptionQuestion = new JLabel(viewModel.getPetQuestion());
        petOptionQuestion.setBounds(10, 200, 100, 20);
        this.add(petOptionQuestion);
        String petOption[] = viewModel.getPetOption();
        JComboBox petOptionComboBox = new JComboBox(petOption);
        petOptionComboBox.setBounds(20,230,20, 40);
        this.add(petOptionComboBox);


        Button submitButton = new Button(70, height, 20,
                20, "submit");
        submitButton.setActionCommand("submit");
        submitButton.addActionListener(e -> {
            for(ActionListener listener: actionListeners){
                listener.actionPerformed(e);
            }
        });
        this.add(submitButton);

    }
    public void addActionListener(ActionListener a){
        if(!actionListeners.contains(a))
            actionListeners.add(a);
    }

}
