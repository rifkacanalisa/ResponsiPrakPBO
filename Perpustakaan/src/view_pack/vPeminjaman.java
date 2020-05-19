package view_pack;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class vPeminjaman extends JFrame {
    JLabel lJudul = new JLabel("Data Peminjaman");

    JLabel lJudulSelect = new JLabel("Peminjaman Terpilih");
    JLabel lId = new JLabel("ID Peminjaman");
    JLabel lIdAnggota = new JLabel("ID Anggota");
    JLabel lNama = new JLabel("Nama Anggota");
    JLabel lJudulBuku = new JLabel("Judul Buku");
    JLabel lJudulStatus = new JLabel("Status");
    public JLabel lIdPilih = new JLabel("");
    public JLabel lIdAnggotaPilih = new JLabel("");
    public JLabel lNamaPilih = new JLabel("");
    public JLabel lJudulPilih = new JLabel("");
    public JLabel lStatusPilih = new JLabel("");
    public JTextField tfSearch = new JTextField("Pencarian (nama)");

    public JButton btnEdit = new JButton("Pengembalian");
    public JButton btnHapus = new JButton("Hapus");
    public JButton btnKembali = new JButton("Kembali");
    public JButton btnSearch = new JButton("Search");
    public JButton btnRefresh = new JButton("Refresh");

    public JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"No","ID Peminjaman", "ID Anggota", "Nama Anggota", "Judul Buku", "Status"};

    JPanel panel = new JPanel();
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    Font font = new Font("Serif", Font.BOLD, 20);

    public vPeminjaman(){
        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(1);
        table.getColumnModel().getColumn(1).setPreferredWidth(1);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(5);
        table.getColumnModel().getColumn(4).setPreferredWidth(5);
        table.getColumnModel().getColumn(5).setPreferredWidth(3);
        scrollPane = new JScrollPane(table);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Perpustakaan Semakin Cerdas");
        setVisible(true);
        setLayout(null);
        setSize(950, 425);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.CYAN);

        add(lJudul);
        lJudul.setFont(font);
        lJudul.setBounds(10, 10, 200, 30);

        add(panel);
        panel.setBounds(680, 50, 250, 250);
        panel.setLayout(null);
        panel.setBorder(border);
        panel.setBackground(Color.cyan);
        panel.setVisible(true);

        panel.add(lJudulSelect);
        lJudulSelect.setFont(font);
        lJudulSelect.setBounds(25, 10, 200, 30);
        panel.add(lId);
        lId.setBounds(10, 50, 100, 20);
        panel.add(lIdPilih);
        lIdPilih.setBounds(125, 50, 100, 20);
        panel.add(lIdAnggota);
        lIdAnggota.setBounds(10, 75, 100, 20);
        panel.add(lIdAnggotaPilih);
        lIdAnggotaPilih.setBounds(125, 75, 100, 20);
        panel.add(lNama);
        lNama.setBounds(10, 100, 100, 20);
        panel.add(lNamaPilih);
        lNamaPilih.setBounds(125, 100, 100, 20);
        panel.add(lJudulBuku);
        lJudulBuku.setBounds(10, 125, 100, 20);
        panel.add(lJudulPilih);
        lJudulPilih.setBounds(125, 125, 100, 20);
        panel.add(lJudulStatus);
        lJudulStatus.setBounds(10, 150, 100, 20);
        panel.add(lStatusPilih);
        lStatusPilih.setBounds(125, 150, 100, 20);
        panel.add(btnEdit);
        btnEdit.setBounds(10, 200, 125, 20);
        panel.add(btnHapus);
        btnHapus.setBounds(150, 200, 80, 20);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);

        add(tfSearch);
        tfSearch.setBounds(10, 50, 100, 20);
        add(btnSearch);
        btnSearch.setBounds(125, 50, 80, 20);
        add(btnRefresh);
        btnRefresh.setBounds(550, 50, 80, 20);
        add(btnKembali);
        btnKembali.setBounds(820, 340, 100, 20);

        add(scrollPane);
        scrollPane.setBounds(10, 75, 650, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }

    public String getSearch() {
        return tfSearch.getText();
    }
}
