/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import businessobjects.BaseBusinessObject;
import businessobjects.BusinessObjectList;
import javax.swing.event.ListSelectionListener;

/**
 * Ui class representing a standard ListView for BusinessObjects with
 * customizable Edit, Add and Delete buttons.
 *
 * @author Iain Workman
 */
public class EditableBusinessObjectListView<T extends BaseBusinessObject>
        extends javax.swing.JPanel {

    /**
     * Creates new form EditableBusinessObjectListView
     * @param data::BusinessObjectList<T> ~ The BusinessObjectList to display
     */
    public EditableBusinessObjectListView(BusinessObjectList<T> data) {
        initComponents();
        businessObjectListView = new BusinessObjectListView<>(data);
        listViewScrollPane.setViewportView(businessObjectListView);
        
    }

    // Public Method
    
    /**
     * Adds a ListSelectionListener to the List, to be notified when the list
     * selection changes
     * @param listener::ListSelectionListener ~ The class to be notified when
     * the selection in the list is altered
     */
    public void addListSelectionListener(ListSelectionListener listener)
    {
        businessObjectListView.addListSelectionListener(listener);
    }
    
    /**
     * Returns the current selected object in the List
     * @return The current selected object in the list, or null if nothing is
     * selected.
     */
    public T getSelectedValue()
    {
        return businessObjectListView.getSelectedValue();
    }
    
    /**
     * Sets whether to allow editing of the items in the list
     * @param editEnabled 
     */
    public void setEditModeEnabled(boolean editEnabled) {
        this.editButton.setVisible(editEnabled);
        updateButtonPanelVisibility();
    }

    /**
     * Sets whether to allow adding items to the list
     * @param addEnabled 
     */
    public void setAddModeEnabled(boolean addEnabled) {
        this.addButton.setVisible(addEnabled);
        updateButtonPanelVisibility();
    }

    /**
     * Sets whether to allow deletion of items from the list
     * @param deleteEnabled 
     */
    public void setDeleteModeEnabled(boolean deleteEnabled) {
        this.deleteButton.setVisible(deleteEnabled);
        updateButtonPanelVisibility();
    }

    /**
     * Adds a listener which responds to the Add button being pressed.
     * @param listener::BusinessObjectListViewAddActionListener<T> ~ The listener
     * to notify when the add button has been clicked.
     */
    public void addAddActionListener(
            BusinessObjectListViewAddActionListener<T> listener)
    {
        addActionListener = listener;
    }
    
    /**
     * Adds a listener which responds to the Edit button being pressed.
     * @param listener::BusinessObjectListViewEditActionListener ~ The listener
     * to notify when the edit button is clicked.
     */
    public void addEditActionListener(
            BusinessObjectListViewEditActionListener listener)
    {
        editActionListener = listener;
    }
    
    /**
     * Adds a listener which responds to the Delete button being pressed.
     * @param listener::BusinessObjectListViewDeleteActionListener ~ The listener
     * to notify when the delete button is clicked.
     */
    public void addDeleteActionListener(
            BusinessObjectListViewDeleteActionListener listener)
    {
        deleteActionListener = listener;
    }
    
    // Private Methods
    /**
     * Updates whether to show the button panel containing the add, edit and
     * delete buttons. If non of these are enabled, then the button panel is not
     * shown.
     */
    private void updateButtonPanelVisibility() {
        
        boolean showButtonPanel = false;
        showButtonPanel |= editButton.isVisible();
        showButtonPanel |= addButton.isVisible();
        showButtonPanel |= deleteButton.isVisible();
        
        buttonPanel.setVisible(showButtonPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        listPanel = new javax.swing.JPanel();
        listViewScrollPane = new javax.swing.JScrollPane();

        setMaximumSize(new java.awt.Dimension(152, 2147483647));
        setLayout(new java.awt.BorderLayout());

        buttonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Add.png"))); // NOI18N
        addButton.setToolTipText("Add");
        addButton.setBorder(null);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(addButton);

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Edit.png"))); // NOI18N
        editButton.setToolTipText("Edit");
        editButton.setBorder(null);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(editButton);

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Close.png"))); // NOI18N
        deleteButton.setToolTipText("Delete");
        deleteButton.setBorder(null);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(deleteButton);

        add(buttonPanel, java.awt.BorderLayout.PAGE_END);

        listPanel.setLayout(new java.awt.BorderLayout());

        listViewScrollPane.setBorder(null);
        listPanel.add(listViewScrollPane, java.awt.BorderLayout.CENTER);

        add(listPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if(addActionListener == null)
            return;
        
        if(businessObjectListView.getDataList() == null)
            return;
        
        addActionListener.onAddActionPerformed(
                new BusinessObjectListViewAddEvent<T>(
                        businessObjectListView.getDataList()));
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if(editActionListener == null)
            return;
        
        if(businessObjectListView.getSelectedValue() == null)
            return;
        
        editActionListener.onEditActionPerformed(
                new BusinessObjectListViewEditEvent(
                        businessObjectListView.getSelectedValue()));
        
        
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(deleteActionListener == null)
            return;
        
        if(businessObjectListView.getSelectedValue() == null)
            return;
        
        if(businessObjectListView.getDataList() == null)
            return;
                
        deleteActionListener.onDeleteActionPerformed(
                new BusinessObjectListViewDeleteEvent<T>(
                    businessObjectListView.getDataList(),
                    businessObjectListView.getSelectedValue())
                    );
    }//GEN-LAST:event_deleteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JPanel listPanel;
    private javax.swing.JScrollPane listViewScrollPane;
    // End of variables declaration//GEN-END:variables
    private final BusinessObjectListView<T> businessObjectListView;
    private BusinessObjectListViewAddActionListener<T> addActionListener;
    private BusinessObjectListViewEditActionListener editActionListener;
    private BusinessObjectListViewDeleteActionListener<T> deleteActionListener;
}
