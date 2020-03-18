import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

public class Player extends JFrame {

    private JPanel panelRoot;
    private JButton previousButton;
    private JButton playButton;
    private JButton nextButton;
    private JTable tableSongs;
    private JButton btnBrowse;
    private JButton btnAddFolderButton;

    public Player() {

        add(panelRoot);
        setTitle("Awdio");
        setBounds(200, 200, 800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        btnBrowse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                browseFiles();
            }

        });

        btnAddFolderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addFilesFromFolder();
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tableSongs.getSelectedRow();

            }
        });
    }

    public void browseFiles() {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        int status = chooser.showOpenDialog(Player.this);

        if (status == JFileChooser.APPROVE_OPTION) {
            File[] files = chooser.getSelectedFiles();




            DefaultTableModel tableModel = new DefaultTableModel();

            tableModel.addColumn("Id");
            tableModel.addColumn("Name");
            tableModel.addColumn("Playing Time");

            int i=0;
            for (File file : files) {
                System.out.println("Name: " + file.getName());
                tableModel.addRow(new Object[]{++i, file.getName(), file.length()});
            }



            tableSongs.setModel(tableModel);








        } else {
            System.out.println("Cancelled");
        }
    }

    public void addFilesFromFolder() {

    }



}
