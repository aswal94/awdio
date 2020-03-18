import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

public class Player extends JFrame {

    private JPanel panelRoot;
    private JButton previousButton;
    private JButton playButton;
    private JButton nextButton;
    private JButton btnBrowse;
    private JButton btnAddFolderButton;
    private JTable table1;

    ArrayList<Song> songsList = new ArrayList<>();


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


            for (File file : files) {
                System.out.println("Name: " + file.getName());
                Song song = new Song();
                song.setName(file.getName());
                song.setPlayingTime(file.length());
                songsList.add(song);
                //tableModel.addRow(new Object[]{++i, song.getName(), song.getPlayingTime()});
            }
            int i = 0;
            for (Song s : songsList) {
                tableModel.addRow(new Object[]{++i, s.getName(), s.getPlayingTime()});
            }


            table1.setModel(tableModel);

            table1.setDefaultEditor(Object.class, null);

            table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent listSelectionEvent) {
                    System.out.println(table1.getValueAt(table1.getSelectedRow(), 0).toString());
                    int x = Integer.parseInt(table1.getValueAt(table1.getSelectedRow(), 0).toString());
                    System.out.println("x: " + x);

                    System.out.println(songsList.get(x-1).getPlayingTime());
                }
            });


        } else {
            System.out.println("Cancelled");
        }
    }

    public void addFilesFromFolder() {

    }


}
