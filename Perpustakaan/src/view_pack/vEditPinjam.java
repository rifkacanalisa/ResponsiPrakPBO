package view_pack;

import javax.swing.*;
import java.awt.*;

public class vEditPinjam extends JFrame {
    JLabel lJudul = new JLabel("Edit Peminjaman");

    JLabel lId = new JLabel("ID Anggota");
    JLabel lNama = new JLabel("Nama");
    JLabel lBuku = new JLabel("Buku");

    public JTextField tfId = new JTextField();
    public JTextField tfNama = new JTextField();
    public JComboBox tfBuku = new JComboBox();

    public JButton btnSimpan = new JButton("Simpan");
    public JButton btnKembali = new JButton("Kembali");
    Font font = new Font("Serif",Font.BOLD, 20);
    public vEditPinjam(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Perpustakaan Semakin Cerdas");
        setVisible(true);
        setLayout(null);
        setSize(350,250);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.CYAN);

        add(lJudul);
        lJudul.setFont(font);
        lJudul.setBounds(10,10,200,30);

        add(lId);
        lId.setBounds(10,50,100,20);
        add(tfId);
        tfId.setBounds(150,50,100,20);
        tfId.setEditable(false);

        add(lNama);
        lNama.setBounds(10,75,100,20);
        add(tfNama);
        tfNama.setBounds(150,75,100,20);

        add(lBuku);
        lBuku.setBounds(10,100,100,20);
        add(tfBuku);
        tfBuku.setBounds(150,100,100,20);

        add(btnSimpan);
        btnSimpan.setBounds(45,150,80,20);
        add(btnKembali);
        btnKembali.setBounds(150,150,100,20);
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
}
