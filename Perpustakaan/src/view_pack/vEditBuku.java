package view_pack;

import javax.swing.*;
import java.awt.*;

public class vEditBuku extends JFrame {
    JLabel lJudul = new JLabel("Edit Data Buku");

    JLabel lBukuJudul = new JLabel("Judul");
    JLabel lJenis = new JLabel("Jenis");
    JLabel lJumlah = new JLabel("Jumlah");

    public JTextField tfJudul = new JTextField();
    public JTextField tfJenis = new JTextField();
    public JSpinner tfJumlah = new JSpinner(new SpinnerNumberModel(1,1,100,1));

    public JButton btnSimpan = new JButton("Simpan");
    public JButton btnKembali = new JButton("Kembali");
    Font font = new Font("Serif", Font.BOLD, 20);

    public vEditBuku(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Perpustakaan Semakin Cerdas");
        setVisible(true);
        setLayout(null);
        setSize(400, 300);
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

        add(btnSimpan);
        btnSimpan.setBounds(10, 150, 100, 20);
        add(btnKembali);
        btnKembali.setBounds(120, 150, 100, 20);

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
}
