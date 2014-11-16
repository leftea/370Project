package ui;

import businessobjects.Scene;
import businessobjects.SceneFilmingDate;
import businessobjects.Script;
import businessobjects.TimeInterval;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

/**
 * A class which represents the scene panel for display in the MainMenu
 */
public class SchedulePanel extends javax.swing.JPanel
{

    // Constructor
    /**
     * Creates new instance of a SchedulePanel
     */
    public SchedulePanel()
    {
        initComponents();
    }

    /**
     * Sets the script whose Schedule and Scenes will be displayed in the panel
     *
     * @param script::Script ~ The Script whose data will be displayed
     */
    public void setSript(Script script)
    {
        if (script == null)
        {
            throw new RuntimeException("Cannot add a null Script to a "
                    + "SchedulePanel");
        }
        this.script = script;
        sceneListView = new BusinessObjectListView<>(script.scenes());
        sceneListViewScrollPane.setViewportView(sceneListView);


        JPopupMenu sceneListViewPopupMenu = new JPopupMenu();
        JMenuItem scheduleSceneMenuItem = new JMenuItem("Schedule Scene...");

        sceneListView.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if (SwingUtilities.isRightMouseButton(e))
                {

                    int indexUnderPointer
                            = sceneListView.locationToIndex(e.getPoint());

                    if (!sceneListView.getCellBounds(indexUnderPointer,
                            indexUnderPointer).contains(e.getPoint()))
                    {
                        sceneListView.clearSelection();
                    } 
                    else
                    {

                        sceneListView.setSelectedIndex(indexUnderPointer);

                        sceneListViewPopupMenu.show(
                                sceneListView, e.getX(), e.getY());
                    }
                }
                super.mousePressed(e);
            }
        });
        scheduleSceneMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Scene selectedScene = sceneListView.getSelectedValue();
                SceneFilmingDate filmingDate =
                        script.schedule().scenesFilmingDate(selectedScene);
                
                if(filmingDate == null)
                {
                    
                    filmingDate = new SceneFilmingDate();
                    filmingDate.setScene(selectedScene);
                    GregorianCalendar start = new GregorianCalendar();
                    start.add(Calendar.DAY_OF_WEEK, 1);
                    start.set(Calendar.HOUR_OF_DAY, 9);
                    
                    GregorianCalendar end = new GregorianCalendar();
                    end.add(Calendar.DAY_OF_WEEK, 1);
                    end.set(Calendar.HOUR_OF_DAY, 11);
                    
                    filmingDate.setSceneShootingInterval(
                        new TimeInterval(start, end));
                }
                
                EditSceneFilmingDate editFilmingDate = new
                    EditSceneFilmingDate(script, filmingDate);
                editFilmingDate.setVisible(true);
            }
        });
        sceneListViewPopupMenu.add(scheduleSceneMenuItem);
        //sceneListView.setComponentPopupMenu(sceneListViewPopupMenu);

        sceneListViewPopupMenu.addPopupMenuListener(new PopupMenuListener()
        {
            public void popupMenuCanceled(PopupMenuEvent e)
            {
                //No action taken when menu is canceled
            }

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
            {
                //No action taken before menu becomes invisible
            }

            public void popupMenuWillBecomeVisible(PopupMenuEvent e)
            {
                Scene selectedScene = sceneListView.getSelectedValue();
                if (selectedScene == null)
                {
                    return;
                }

                scheduleSceneMenuItem.setText("Schedule "
                        + sceneListView.getSelectedValue().toString());
            }
        });
        calendarPanel.add(new ScheduleCalendar());
    }

    // Private Methods
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        sidePanel = new javax.swing.JPanel();
        sceneListViewScrollPane = new javax.swing.JScrollPane();
        sceneListViewLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        calendarPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        sceneListViewLabel.setText("Scenes");

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sceneListViewScrollPane)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addComponent(sceneListViewLabel)
                        .addGap(0, 88, Short.MAX_VALUE)))
                .addContainerGap())
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sceneListViewLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sceneListViewScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(sidePanel, java.awt.BorderLayout.LINE_START);

        calendarPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Private Member Variables
    private BusinessObjectListView<Scene> sceneListView;
    private Script script;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel calendarPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel sceneListViewLabel;
    private javax.swing.JScrollPane sceneListViewScrollPane;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}
