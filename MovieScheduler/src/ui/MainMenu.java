package ui;

import businessobjects.Equipment;
import businessobjects.Scene;
import businessobjects.Volunteer;
import database.JdbcDatabase;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import moviescheduler.MovieSchedulerController;

/**
 *
 * @author Iain Workman, Ryan La Forge, John Mason, Matthew Galbraith
 */
public class MainMenu extends javax.swing.JFrame {

    private final MovieSchedulerController controller;

    /**
     *
     * @param theScript the script currently in use by the system.
     * @param database
     * @throws SQLException
     */
    public MainMenu(MovieSchedulerController controller) {
        initComponents();
        this.controller = controller;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setMaximumSize(new Dimension(1000, 600));
        this.setMinimumSize(new Dimension(1000, 600));

        //   theScript.addVolunteer(new Volunteer("kyle", "west", "raeagaeg", "phonenumber"));
        volunteerComboBox.removeAllItems();
        for (Volunteer volunteerToAdd: controller.getVolunteers())
        {
            volunteerComboBox.addItem(volunteerToAdd);
        }
        
        for (Scene sceneToAdd: controller.getScenes())
        {
            sceneComboBox.addItem(sceneToAdd);
        }
        
        for(Equipment equipmentToAdd: controller.getEquipment())
        {
            equipmentComboBox.addItem(equipmentToAdd);
        }
        
        SchedulePanel schedulePanel = new SchedulePanel();
        schedulePanel.setSript(controller.getScript());
        schedulePanel.setDatabase(controller.getDatabase());
        scheduleTabPanel.add(schedulePanel, BorderLayout.CENTER);

       // ResourcePanel resourcePanel = new ResourcePanel(controller.getScript(), controller.getDatabase());
        //resourceTabPanel.add(resourcePanel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        mainPanel = new javax.swing.JPanel();
        mainTab = new javax.swing.JTabbedPane();
        scriptTabPanel = new javax.swing.JPanel();
        scriptContentPanel = new javax.swing.JPanel();
        volunteerSectionLabel = new javax.swing.JLabel();
        addVolunteerButton = new javax.swing.JButton();
        editVolunteerButton = new javax.swing.JButton();
        removeVolunteerButton = new javax.swing.JButton();
        volunteerComboBox = new javax.swing.JComboBox();
        equipmentSectionLabel = new javax.swing.JLabel();
        equipmentComboBox = new javax.swing.JComboBox();
        addEquipmentButton = new javax.swing.JButton();
        editEquipmentButton = new javax.swing.JButton();
        removeEquipmentButton = new javax.swing.JButton();
        sceneComboBox = new javax.swing.JComboBox();
        addSceneButton = new javax.swing.JButton();
        editSceneButton = new javax.swing.JButton();
        removeSceneButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        toString = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        toDescriptiveString = new javax.swing.JTextArea();
        scheduleTabPanel = new javax.swing.JPanel();
        resourceTabPanel = new javax.swing.JPanel();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movie Scheduler");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        mainPanel.setBorder(new javax.swing.border.MatteBorder(null));

        volunteerSectionLabel.setText("Volunteer");

        addVolunteerButton.setText("add");
        addVolunteerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVolunteerButtonActionPerformed(evt);
            }
        });

        editVolunteerButton.setText("edit");
        editVolunteerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editVolunteerButtonActionPerformed(evt);
            }
        });

        removeVolunteerButton.setText("remove");
        removeVolunteerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeVolunteerButtonActionPerformed(evt);
            }
        });

        volunteerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        volunteerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volunteerComboBoxActionPerformed(evt);
            }
        });

        equipmentSectionLabel.setText("Equipment");

        equipmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        equipmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipmentComboBoxActionPerformed(evt);
            }
        });

        addEquipmentButton.setText("add");
        addEquipmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEquipmentButtonActionPerformed(evt);
            }
        });

        editEquipmentButton.setText("edit");
        editEquipmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEquipmentButtonActionPerformed(evt);
            }
        });

        removeEquipmentButton.setText("remove");
        removeEquipmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEquipmentButtonActionPerformed(evt);
            }
        });

        sceneComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        sceneComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sceneComboBoxActionPerformed(evt);
            }
        });

        addSceneButton.setText("add");
        addSceneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSceneButtonActionPerformed(evt);
            }
        });

        editSceneButton.setText("edit");
        editSceneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSceneButtonActionPerformed(evt);
            }
        });

        removeSceneButton.setText("remove");
        removeSceneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSceneButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Scenes");

        toString.setText("jTextField1");

        toDescriptiveString.setColumns(20);
        toDescriptiveString.setRows(5);
        jScrollPane1.setViewportView(toDescriptiveString);

        javax.swing.GroupLayout scriptContentPanelLayout = new javax.swing.GroupLayout(scriptContentPanel);
        scriptContentPanel.setLayout(scriptContentPanelLayout);
        scriptContentPanelLayout.setHorizontalGroup(
            scriptContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriptContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scriptContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scriptContentPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(volunteerSectionLabel))
                    .addGroup(scriptContentPanelLayout.createSequentialGroup()
                        .addGroup(scriptContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(volunteerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sceneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(scriptContentPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(scriptContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(equipmentSectionLabel)
                                    .addComponent(jLabel3)))
                            .addComponent(equipmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(scriptContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addEquipmentButton)
                            .addGroup(scriptContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(addSceneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editSceneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeVolunteerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(editVolunteerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addVolunteerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeEquipmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(editEquipmentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeSceneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(120, 120, 120)
                        .addGroup(scriptContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toString, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        scriptContentPanelLayout.setVerticalGroup(
            scriptContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriptContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(volunteerSectionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scriptContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volunteerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addVolunteerButton)
                    .addComponent(toString, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scriptContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scriptContentPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(scriptContentPanelLayout.createSequentialGroup()
                        .addGroup(scriptContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(scriptContentPanelLayout.createSequentialGroup()
                                .addComponent(editVolunteerButton)
                                .addGap(6, 6, 6)
                                .addComponent(removeVolunteerButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addEquipmentButton))
                            .addGroup(scriptContentPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(equipmentSectionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(equipmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editEquipmentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeEquipmentButton)
                        .addGap(38, 38, 38)))
                .addGroup(scriptContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addSceneButton)
                    .addComponent(sceneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editSceneButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeSceneButton)
                .addGap(112, 112, 112))
        );

        javax.swing.GroupLayout scriptTabPanelLayout = new javax.swing.GroupLayout(scriptTabPanel);
        scriptTabPanel.setLayout(scriptTabPanelLayout);
        scriptTabPanelLayout.setHorizontalGroup(
            scriptTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriptTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scriptContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        scriptTabPanelLayout.setVerticalGroup(
            scriptTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scriptTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scriptContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTab.addTab("Script", scriptTabPanel);

        scheduleTabPanel.setLayout(new java.awt.BorderLayout());
        mainTab.addTab("Schedule", scheduleTabPanel);

        resourceTabPanel.setLayout(new java.awt.BorderLayout());
        mainTab.addTab("Resources", resourceTabPanel);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTab)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTab)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(925, 574));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void removeSceneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSceneButtonActionPerformed
        controller.deleteBusinessObject((Scene) sceneComboBox.getSelectedItem());
    }//GEN-LAST:event_removeSceneButtonActionPerformed

    private void editSceneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSceneButtonActionPerformed
        controller.displaySceneMenu((Scene) sceneComboBox.getSelectedItem());
    }//GEN-LAST:event_editSceneButtonActionPerformed

    private void addSceneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSceneButtonActionPerformed
        controller.displaySceneMenu(null);
    }//GEN-LAST:event_addSceneButtonActionPerformed

    private void sceneComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sceneComboBoxActionPerformed
        if (sceneComboBox.getSelectedItem() != null && (sceneComboBox.getSelectedItem() instanceof Scene)) 
        {
            Scene selectedScene = (Scene) sceneComboBox.getSelectedItem();
            toString.setText(selectedScene.toString());
            toDescriptiveString.setText(selectedScene.toDescriptiveString());
        }
    }//GEN-LAST:event_sceneComboBoxActionPerformed

    private void addEquipmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEquipmentButtonActionPerformed
        controller.displayEquipmentMenu(null);
    }//GEN-LAST:event_addEquipmentButtonActionPerformed

    private void volunteerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volunteerComboBoxActionPerformed

        if (volunteerComboBox.getSelectedItem() != null && (volunteerComboBox.getSelectedItem() instanceof Volunteer)) {
            toString.setText(((Volunteer) volunteerComboBox.getSelectedItem()).toString());
            toDescriptiveString.setText(((Volunteer) volunteerComboBox.getSelectedItem()).toDescriptiveString());
        }

    }//GEN-LAST:event_volunteerComboBoxActionPerformed

    private void addVolunteerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVolunteerButtonActionPerformed
        controller.displayVolunteerMenu(null);
    }//GEN-LAST:event_addVolunteerButtonActionPerformed

    private void equipmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipmentComboBoxActionPerformed

        if (equipmentComboBox.getSelectedItem() != null && (equipmentComboBox.getSelectedItem() instanceof Equipment)) {
            toString.setText(((Equipment) equipmentComboBox.getSelectedItem()).toString());
            toDescriptiveString.setText(((Equipment) equipmentComboBox.getSelectedItem()).toDescriptiveString());
        }
    }//GEN-LAST:event_equipmentComboBoxActionPerformed

    private void removeVolunteerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeVolunteerButtonActionPerformed
        controller.deleteBusinessObject((Volunteer) volunteerComboBox.getSelectedItem());
        if (false)
        {
            
        }    }//GEN-LAST:event_removeVolunteerButtonActionPerformed

    private void removeEquipmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEquipmentButtonActionPerformed
        controller.deleteBusinessObject((Equipment) equipmentComboBox.getSelectedItem());
        if (false)
        {
            
        }    }//GEN-LAST:event_removeEquipmentButtonActionPerformed

    private void editVolunteerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editVolunteerButtonActionPerformed
        controller.displayVolunteerMenu((Volunteer) volunteerComboBox.getSelectedItem());
            }//GEN-LAST:event_editVolunteerButtonActionPerformed

    private void editEquipmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEquipmentButtonActionPerformed
        controller.displayEquipmentMenu((Equipment) equipmentComboBox.getSelectedItem());
    }//GEN-LAST:event_editEquipmentButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Could not load database driver with "
                            + "message: " + ex.toString());
                    return;
                }

                JdbcDatabase testDatabase = null;
                try {
                    testDatabase = new JdbcDatabase(
                            "jdbc:postgresql://edjo.usask.ca/cmpt370_group06",
                            "cmpt370_group06",
                            "Raptorjesusisawesome55775");
                } catch (SQLException ex) {
                    System.out.println("Failed to connection to db with message: "
                            + ex.getMessage());
                    return;
                }


                JOptionPane.showMessageDialog(null, "Could not load main"
                        + " menu.");

            }
        });
    }

    // Private Member Variables
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEquipmentButton;
    private javax.swing.JButton addSceneButton;
    private javax.swing.JButton addVolunteerButton;
    private javax.swing.JButton editEquipmentButton;
    private javax.swing.JButton editSceneButton;
    private javax.swing.JButton editVolunteerButton;
    private javax.swing.JComboBox equipmentComboBox;
    private javax.swing.JLabel equipmentSectionLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JButton removeEquipmentButton;
    private javax.swing.JButton removeSceneButton;
    private javax.swing.JButton removeVolunteerButton;
    private javax.swing.JPanel resourceTabPanel;
    private javax.swing.JComboBox sceneComboBox;
    private javax.swing.JPanel scheduleTabPanel;
    private javax.swing.JPanel scriptContentPanel;
    private javax.swing.JPanel scriptTabPanel;
    private javax.swing.JTextArea toDescriptiveString;
    private javax.swing.JTextField toString;
    private javax.swing.JComboBox volunteerComboBox;
    private javax.swing.JLabel volunteerSectionLabel;
    // End of variables declaration//GEN-END:variables
}
