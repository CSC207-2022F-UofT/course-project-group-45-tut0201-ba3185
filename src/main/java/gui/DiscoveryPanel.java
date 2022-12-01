package gui;
import controller.BlockListController;
import entity.User;
import use_case_blocklist.BlockListManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiscoveryPanel extends JPanel {
    public DiscoveryPanel() {
        this.setLayout(new FlowLayout());
        this.setBackground(Color.pink);
        this.add(new TextField("This is the discovery page."));


        Button btnP = new Button("add");
        btnP.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                BlockListManager blockListManager = new BlockListManager();
                User buser = new User("cam2", "cam2", "123");
                BlockListController controller = new BlockListController(blockListManager);
                if (blockListManager.checkBlockList(buser)) {
                    controller.removeBlockList(buser);
                    btnP.setLabel("add");
                }else {
                    controller.addBlockList(buser);
                    btnP.setLabel("added");
                }


            }
        });
        this.add(btnP);
    }
}
