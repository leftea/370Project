/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import actions.SaveSceneFilmingDateAction;
import businessobjects.BaseBusinessObject;
import businessobjects.BusinessObjectListener;
import businessobjects.Scene;
import businessobjects.SceneFilmingDate;
import businessobjects.Script;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import database.Database;
import java.awt.event.WindowEvent;
/**
 *
 * @author iain
 */
public class EditSceneFilmingDate extends javax.swing.JFrame
        implements BusinessObjectListener
{

    /**
     * Creates new form EditSceneFilmingDate
     * @param script
     * @param filmingDate
     * @param database
     */
    public EditSceneFilmingDate(Script script, 
            SceneFilmingDate filmingDate, Database database)
    {
        if (script == null)
        {
            throw new RuntimeException("Cannot edit Scene Filming Dates for"
                    + "a null script");
        }        
        initComponents();
        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        
        this.script = script;
        this.database = database;
        originalFilmingDate = filmingDate;
        try{
        filmingDateToEdit = (SceneFilmingDate) filmingDate.clone();
        } catch(CloneNotSupportedException e)
        {
            throw new RuntimeException("Error creating Edit Scene Filming Date"
                    + " Panel: Clone not supported");
        }
        errorIcon.setVisible(!filmingDateToEdit.isValid());
        errorLabel.setVisible(!filmingDateToEdit.isValid());
        errorIcon.setToolTipText(filmingDateToEdit.errorMessage());
        filmingDateToEdit.addListener(this);
        //filmingDateToEdit.sceneShootingInterval().addListener(this);
        okayButton.setEnabled(false);
        scenesComboBox = new BusinessObjectComboBoxView<>(script.scenes());
        sceneLabel.setText(filmingDateToEdit.scene().getName());
        scenesComboBox.setSelectedItem(filmingDateToEdit.scene());
        
        startDateTimeSpinner.setValue(filmingDateToEdit.sceneShootingStart().getTime());
        endDateTimeSpinner.setValue(filmingDateToEdit.sceneShootingEnd().getTime());
        
        startDateTimeSpinner.addChangeListener(new ChangeListener()
        {
            
            @Override
            public void stateChanged(ChangeEvent e)
            {
                Date newValue = (Date) startDateTimeSpinner.getValue();
                GregorianCalendar newCalendarValue = new GregorianCalendar();
                newCalendarValue.setTime(newValue);
                
                filmingDateToEdit.sceneShootingInterval().setStart(newCalendarValue);
            }
            
        });
        
        endDateTimeSpinner.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                Date newValue = (Date) endDateTimeSpinner.getValue();
                GregorianCalendar newCalendarValue = new GregorianCalendar();
                newCalendarValue.setTime(newValue);
                
                filmingDateToEdit.sceneShootingInterval().setEnd(newCalendarValue);
            }
        });
    }
    
    @Override
    public void validStateAltered(boolean newState, BaseBusinessObject sender)
    {
        okayButton.setEnabled(newState);
        errorIcon.setVisible(!newState);
        errorLabel.setVisible(!newState);
        errorLabel.setText(null);
        if (!newState)
        {
            errorIcon.setToolTipText(sender.errorMessage());
        }
    }
    
    @Override
    public void changedStateAltered(boolean newState, BaseBusinessObject sender)
    {
        okayButton.setEnabled(newState);
    }

    public void save()
    {
        SaveSceneFilmingDateAction saveAction = new SaveSceneFilmingDateAction(
                database, filmingDateToEdit);
        
        saveAction.run();
        
        if(saveAction.wasSuccessful())
        {
            originalFilmingDate.merge(filmingDateToEdit);
            script.schedule().add(originalFilmingDate);
        }
        else
        {
            //Show error message
            JOptionPane.showMessageDialog(null, "Could not save scheduled "
                    + "filming date with message: " 
                    + saveAction.lastErrorMessage(),
                    "Error Loading System!", 0);
        }
    }
    
    private boolean confirmClose()
    {
        if (filmingDateToEdit.hasChanged())
        {
            if (filmingDateToEdit.isValid())
            {
                int confirm = JOptionPane.showOptionDialog(this,
                        "Changes have been made, do you wish to save?",
                        "Save Changes?",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, null, null);
                
                if (confirm == JOptionPane.YES_OPTION)
                {
                    save();
                    return true;
                } else if (confirm == JOptionPane.NO_OPTION)
                {
                    return true;
                }
            } else
            {
                int confirm = JOptionPane.showOptionDialog(
                        this,
                        "Changes have been made, but cannot be saved because "
                        + "they are not valid. Do you wish to return to editing",
                        "Return to editing?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null, null, null);
                
                if (confirm == JOptionPane.NO_OPTION)
                {
                    return true;
                }
            }
        } else
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bottomPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        okayButton = new javax.swing.JButton();
        errorIcon = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        topPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        startDateTimeLabel = new javax.swing.JLabel();
        endDateTimeLabel = new javax.swing.JLabel();
        sceneLabel = new javax.swing.JLabel();
        startDateTimeSpinner = new javax.swing.JSpinner();
        endDateTimeSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scene Filming Date");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okayButton.setText("Okay");
        okayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okayButtonActionPerformed(evt);
            }
        });

        errorIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Error.png"))); // NOI18N

        errorLabel.setText("Warning: Cannot Save");

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(errorIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addGap(52, 52, 52)
                .addComponent(okayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelButton)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelButton)
                            .addComponent(okayButton)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errorIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(5, 5, 5))
        );

        getContentPane().add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        titleLabel.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        titleLabel.setText("Create Scene Filming Date");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addContainerGap(238, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        startDateTimeLabel.setText("Start:");

        endDateTimeLabel.setText("End:");

        sceneLabel.setText("Scene");

        startDateTimeSpinner.setModel(new javax.swing.SpinnerDateModel());

        endDateTimeSpinner.setModel(new javax.swing.SpinnerDateModel());

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(startDateTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(endDateTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sceneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(194, 194, 194))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(startDateTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(endDateTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sceneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDateTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDateTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        if(confirmClose())
        {
            filmingDateToEdit.removeListener(this);
            //filmingDateToEdit.sceneShootingInterval().removeListener(this);
            this.setVisible(false);
        }
    }//GEN-LAST:event_formWindowClosing

    private void okayButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_okayButtonActionPerformed
    {//GEN-HEADEREND:event_okayButtonActionPerformed
        this.save();
        this.setVisible(false);
    }//GEN-LAST:event_okayButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(EditSceneFilmingDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(EditSceneFilmingDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(EditSceneFilmingDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(EditSceneFilmingDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                //new EditSceneFilmingDate().setVisible(true);
            }
        });
    }

    // Private Member Variables
    private BusinessObjectComboBoxView<Scene> scenesComboBox;
    private SceneFilmingDate originalFilmingDate;
    private SceneFilmingDate filmingDateToEdit;
    private Database database;
    private Script script;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel endDateTimeLabel;
    private javax.swing.JSpinner endDateTimeSpinner;
    private javax.swing.JLabel errorIcon;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton okayButton;
    private javax.swing.JLabel sceneLabel;
    private javax.swing.JLabel startDateTimeLabel;
    private javax.swing.JSpinner startDateTimeSpinner;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables

}
