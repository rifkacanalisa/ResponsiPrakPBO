package view_pack;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class vPinjamBuku extends JFrame {
    JLabel lJudul = new JLabel("Peminjaman Buku");

    JLabel lId = new JLabel("ID Anggota");
    JLabel lNama = new JLabel("Nama");
    JLabel lBuku = new JLabel("Buku");

    public JTextField tfId = new JTextField();
    public JTextField tfNama = new JTextField();
    public JComboBox tfBuku = new JComboBox();
    public JTextField tfSearch = new JTextField("Pencarian (nama)");

    JLabel lJudulSelect = new JLabel("Data Terpilih");
    JLabel lJudulId = new JLabel("ID Anggota");
    JLabel lJudulNama = new JLabel("Nama");
    JLabel lJudulBuku = new JLabel("Buku");
    public JLabel lIdPilih = new JLabel("");
    public JLabel lNamaPilih = new JLabel("");
    public JLabel lBukuPilih = new JLabel("");

    public JButton btnPinjam = new JButton("Pinjam");
    public JButton btnEdit = new JButton("Edit");
    public JButton btnHapus = new JButton("Hapus");
    public JButton btnKembali = new JButton("Kembali");
    public JButton btnSearch = new JButton("Search");
    public JButton btnRefresh = new JButton("Refresh");

    public JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"No","ID Anggota","Nama Anggota","Judul Buku","Jenis Buku","Status"};

    JPanel panel = new JPanel();
    Border border = BorderFactory.createLineBorder(Color.BLACK,2);

    Font font = new Font("Serif",Font.BOLD, 20);
    public vPinjamBuku(){
        tableModel = new DefaultTableModel(namaKolom,0);
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(1);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(5);
        table.getColumnModel().getColumn(5).setPreferredWidth(3);
        scrollPane = new JScrollPane(table);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Perpustakaan Semakin Cerdas");
        setVisible(true);
        setLayout(null);
        setSize(950,500);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.CYAN);

        add(lJudul);
        lJudul.setFont(font);
        lJudul.setBounds(10,10,200,30);

        add(lId);
        lId.setBounds(10,50,100,20);
        add(tfId);
        tfId.setBounds(125,50,100,20);

        add(lNama);
        lNama.setBounds(10,75,100,20);
        add(tfNama);
        tfNama.setBounds(125,75,100,20);

        add(lBuku);
        lBuku.setBounds(10,100,100,20);
        add(tfBuku);
        tfBuku.setBounds(125,100,100,20);

        add(btnPinjam);
        btnPinjam.setBounds(50,150,100,20);

        add(panel);
        panel.setBounds(10,200,225,200);
        panel.setLayout(null);
        panel.setBorder(border);
        panel.setBackground(Color.cyan);
        panel.setVisible(true);

        panel.add(lJudulSelect);
        lJudulSelect.setFont(font);
        lJudulSelect.setBounds(50,10,150,30);
        panel.add(lJudulId);
        lJudulId.setBounds(10,50,100,20);
        panel.add(lIdPilih);
        lIdPilih.setBounds(125,50,100,20);
        panel.add(lJudulNama);
        lJudulNama.setBounds(10,75,100,20);
        panel.add(lNamaPilih);
        lNamaPilih.setBounds(125,75,100,20);
        panel.add(lJudulBuku);
        lJudulBuku.setBounds(10,100,100,20);
        panel.add(lBukuPilih);
        lBukuPilih.setBounds(125,100,100,20);
        panel.add(btnEdit);
        btnEdit.setBounds(25,150,80,20);
        panel.add(btnHapus);
        btnHapus.setBounds(125,150,80,20);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);

        add(tfSearch);
        tfSearch.setBounds(640,50,100,20);
        add(btnSearch);
        btnSearch.setBounds(750,50,80,20);
        add(btnRefresh);
        btnRefresh.setBounds(840,50,80,20);
        add(btnKembali);
        btnKembali.setBounds(820,390,100,20);

        add(scrollPane);
        scrollPane.setBounds(275, 75, 650, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }

    public String getID(){
        return tfId.getText();
    }
    public String getNama(){
        return tfNama.getText();
    }
    public String getBuku(){
        return (String) tfBuku.getSelectedItem();
    }
    public String getSearch(){
        return tfSearch.getText();
    }
}
