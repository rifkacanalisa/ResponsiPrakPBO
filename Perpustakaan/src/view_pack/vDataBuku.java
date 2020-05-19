package view_pack;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class vDataBuku extends JFrame {
    JLabel lJudul = new JLabel("Data Buku");

    JLabel lBukuJudul = new JLabel("Judul");
    JLabel lJenis = new JLabel("Jenis");
    JLabel lJumlah = new JLabel("Jumlah");

    public JTextField tfJudul = new JTextField();
    public JTextField tfJenis = new JTextField();
    public JSpinner tfJumlah = new JSpinner(new SpinnerNumberModel(1,1,100,1));
    public JTextField tfSearch = new JTextField("Pencarian (judul)");

    JLabel lJudulSelect = new JLabel("Data Buku Terpilih");
    JLabel lJudulId = new JLabel("ID Buku");
    JLabel lJudulJudul = new JLabel("Judul");
    JLabel lJudulJenis = new JLabel("Jenis");
    JLabel lJudulJumlah = new JLabel("Jumlah");
    public JLabel lIdPilih = new JLabel("");
    public JLabel lJudulPilih = new JLabel("");
    public JLabel lJenisPilih = new JLabel("");
    public JLabel lJumlahPilih = new JLabel("");

    public JButton btnTambah = new JButton("Tambah");
    public JButton btnEdit = new JButton("Edit");
    public JButton btnHapus = new JButton("Hapus");
    public JButton btnKembali = new JButton("Kembali");
    public JButton btnSearch = new JButton("Search");
    public JButton btnRefresh = new JButton("Refresh");

    public JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"No", "ID Buku", "Judul Buku", "Jenis Buku", "Jumlah Buku"};

    JPanel panel = new JPanel();
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    Font font = new Font("Serif", Font.BOLD, 20);

    public vDataBuku() {
        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(1);
        table.getColumnModel().getColumn(1).setPreferredWidth(1);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(5);
        table.getColumnModel().getColumn(4).setPreferredWidth(5);
        scrollPane = new JScrollPane(table);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Perpustakaan Semakin Cerdas");
        setVisible(true);
        setLayout(null);
        setSize(950, 500);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.CYAN);

        add(lJudul);
        lJudul.setFont(font);
        lJudul.setBounds(10, 10, 200, 30);

        add(lBukuJudul);
        lBukuJudul.setBounds(10, 50, 100, 20);
        add(tfJudul);
        tfJudul.setBounds(125, 50, 100, 20);

        add(lJenis);
        lJenis.setBounds(10, 75, 100, 20);
        add(tfJenis);
        tfJenis.setBounds(125, 75, 100, 20);

        add(lJumlah);
        lJumlah.setBounds(10, 100, 100, 20);
        add(tfJumlah);
        tfJumlah.setBounds(125, 100, 100, 20);

        add(btnTambah);
        btnTambah.setBounds(50, 150, 100, 20);

        add(panel);
        panel.setBounds(10, 200, 225, 200);
        panel.setLayout(null);
        panel.setBorder(border);
        panel.setBackground(Color.cyan);
        panel.setVisible(true);

        panel.add(lJudulSelect);
        lJudulSelect.setFont(font);
        lJudulSelect.setBounds(25, 10, 200, 30);
        panel.add(lJudulId);
        lJudulId.setBounds(10, 50, 100, 20);
        panel.add(lIdPilih);
        lIdPilih.setBounds(125, 50, 100, 20);
        panel.add(lJudulJudul);
        lJudulJudul.setBounds(10, 75, 100, 20);
        panel.add(lJudulPilih);
        lJudulPilih.setBounds(125, 75, 100, 20);
        panel.add(lJudulJenis);
        lJudulJenis.setBounds(10, 100, 100, 20);
        panel.add(lJenisPilih);
        lJenisPilih.setBounds(125, 100, 100, 20);
        panel.add(lJudulJumlah);
        lJudulJumlah.setBounds(10, 125, 100, 20);
        panel.add(lJumlahPilih);
        lJumlahPilih.setBounds(125, 125, 100, 20);
        panel.add(btnEdit);
        btnEdit.setBounds(25, 160, 80, 20);
        panel.add(btnHapus);
        btnHapus.setBounds(125, 160, 80, 20);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);

        add(tfSearch);
        tfSearch.setBounds(640, 50, 100, 20);
        add(btnSearch);
        btnSearch.setBounds(750, 50, 80, 20);
        add(btnRefresh);
        btnRefresh.setBounds(840, 50, 80, 20);
        add(btnKembali);
        btnKembali.setBounds(820, 390, 100, 20);

        add(scrollPane);
        scrollPane.setBounds(275, 75, 650, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }

    public String getJudul() {
        return tfJudul.getText();
    }

    public String getJenis() {
        return tfJenis.getText();
    }

    public String getJumlah() {
        return String.valueOf(tfJumlah.getValue());
    }

    public String getSearch() {
        return tfSearch.getText();
    }

}