import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
                JFileChooser chooser = new JFileChooser();
                chooser.setMultiSelectionEnabled(true);
                int status = chooser.showOpenDialog(Player.this);

                if (status == JFileChooser.APPROVE_OPTION) {
                    File[] files = chooser.getSelectedFiles();
                    for (File file : files) {
                        System.out.println("Name: " + file.getName());
                    }

                    System.out.println(files.toString());

                    DefaultTableModel defaultTableModel = (DefaultTableModel) tableSongs.getModel();
                    defaultTableModel.setColumnIdentifiers(new String[]{ "Filenames"});

                    Object[] row = new Object[1];

                    for(int i=0;i<files.length; i++){
                        row[0] = files[i].getName();
                        defaultTableModel.addRow(row);
                    }

                    System.out.println("working");
                } else {
                    System.out.println("Cancelled");
                }
            }

        });

        btnAddFolderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tableSongs.getSelectedRow();

            }
        });
    }

}
