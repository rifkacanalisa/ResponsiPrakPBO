package view_pack;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class vDaftarBuku extends JFrame {
    JLabel lJudul = new JLabel("Daftar Buku");

    public JTextField tfSearch = new JTextField("Pencarian (judul)");
    public JButton btnSearch = new JButton("Search");
    public JButton btnRefresh = new JButton("Refresh");
    public JButton btnKembali = new JButton("Kembali");

    public JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"No","Judul","Jenis","Jumlah Buku"};

    Font font = new Font("Serif",Font.BOLD, 20);
    public vDaftarBuku(){
        tableModel = new DefaultTableModel(namaKolom,0);
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(1);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(6);
        table.getColumnModel().getColumn(3).setPreferredWidth(1);
        scrollPane = new JScrollPane(table);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Perpustakaan Semakin Cerdas");
        setVisible(true);
        setLayout(null);
        setSize(600,500);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.CYAN);

        add(lJudul);
        lJudul.setBounds(10,10,200,20);
        lJudul.setFont(font);

        add(tfSearch);
        tfSearch.setBounds(300,30,100,20);
        add(btnSearch);
        btnSearch.setBounds(410,30,80,20);
        add(btnRefresh);
        btnRefresh.setBounds(500,30,80,20);
        add(btnKembali);
        btnKembali.setBounds(450,420,100,20);

        add(scrollPane);
        scrollPane.setBounds(10, 60, 550, 350);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }

    public String getSearch(){
        return tfSearch.getText();
    }
}
