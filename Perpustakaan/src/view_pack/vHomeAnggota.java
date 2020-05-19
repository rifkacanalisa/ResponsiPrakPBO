package view_pack;

import javax.swing.*;
import java.awt.*;

public class vHomeAnggota extends JFrame {
    public JLabel lWelcome = new JLabel();

    public JButton btnLogout = new JButton("Logout");
    public JButton btnPinjam = new JButton("Peminjaman Buku");
    public JButton btnBuku = new JButton("Daftar Buku");

    JLabel lLogo = new JLabel();
    String path = new String("src/Gambar/book2.png");
    ImageIcon imageIcon = new ImageIcon(path);
    Image image = imageIcon.getImage();
    Image newImage = image.getScaledInstance(200,250,Image.SCALE_SMOOTH);
    ImageIcon logo = new ImageIcon(newImage);

    public vHomeAnggota(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Perpustakaan Semakin Cerdas");
        setVisible(true);
        setLayout(null);
        setSize(450,350);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.CYAN);

        add(lLogo);
        lLogo.setBounds(220,50,200,250);
        lLogo.setIcon(logo);
        lLogo.setBackground(Color.cyan);

        add(lWelcome);
        lWelcome.setBounds(10,10,200,20);
        lWelcome.setToolTipText("Click username update profil");
        add(btnLogout);
        btnLogout.setBounds(300,10,100,20);
        add(btnBuku);
        btnBuku.setBounds(25,100,150,20);
        add(btnPinjam);
        btnPinjam.setBounds(25,150,150,20);
    }
}
