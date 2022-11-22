package gui.discovery_part;
import Discovery.DiscoveryController.FinderController;
import javax.swing.*;
import java.awt.*;

public class DiscoveryPanel extends JPanel {

    //private PreferencePanel preferencePanel;//the panel to display users after preference discovery
    public DiscoveryPanel() {
        this.setLayout(null);
        this.setLayout(new FlowLayout());
        this.setBackground(Color.pink);
        this.add(new TextField("This is the discovery page."));

        PreferencePanel preferencePanel = new PreferencePanel();//the panel to display info
        preferencePanel.addActionListener(e -> {
            preferencePanel.add(new UserInfoPanel());
            preferencePanel.revalidate();
        });


        OptionPanel optionPanel = new OptionPanel();
        optionPanel.addActionListener(e -> {
            //TODO: to fetch with other two types of discovery
            switch (e.getActionCommand()) {
                case "preference":
                    FinderController controller = new FinderController(1,preferencePanel);
                    controller.optionControl();
                    this.add(preferencePanel);
                    break;
            }
            this.revalidate();
        });
        this.add(optionPanel);
    }
}
