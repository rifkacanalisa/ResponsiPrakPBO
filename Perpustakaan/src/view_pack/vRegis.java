package view_pack;

import javax.swing.*;
import java.awt.*;

public class vRegis extends JFrame {
    public JLabel lJudul = new JLabel("Registrasi Anggota");
    JLabel lUsername = new JLabel("Username");
    JLabel lPassword = new JLabel("Password");

    public JTextField tfUsername = new JTextField();
    public JPasswordField tfPassword = new JPasswordField();
    public JCheckBox showPassword = new JCheckBox("Show Password");
    public JButton btnRegis = new JButton("Registrasi");
    public JButton btnKembali = new JButton("Kembali");

    JLabel lLogo = new JLabel();
    String path = new String("src/Gambar/profil.png");
    ImageIcon imageIcon = new ImageIcon(path);
    Image image = imageIcon.getImage();
    Image newImage = image.getScaledInstance(100,70,Image.SCALE_SMOOTH);
    ImageIcon logo = new ImageIcon(newImage);

    Font font = new Font("Serif",Font.BOLD, 20);

    public vRegis(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Perpustakaan Semakin Cerdas");
        setVisible(true);
        setLayout(null);
        setSize(350,300);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.CYAN);

        add(lLogo);
        lLogo.setBounds(100,40,100,70);
        lLogo.setIcon(logo);
        lLogo.setBackground(Color.cyan);

        add(lJudul);
        lJudul.setFont(font);
        lJudul.setBounds(75,10,300,30);

        add(lUsername);
        lUsername.setBounds(50,120,100,20);
        add(tfUsername);
        tfUsername.setBounds(155,120,100,20);

        add(lPassword);
        lPassword.setBounds(50,160,100,20);
        add(tfPassword);
        tfPassword.setBounds(155,160,100,20);
        tfPassword.setEchoChar('*');

        add(showPassword);
        showPassword.setBounds(150,190,150,20);
        showPassword.setBackground(Color.cyan);

        add(btnRegis);
        btnRegis.setBounds(50,225,100,20);
        getRootPane().setDefaultButton(btnRegis);

        add(btnKembali);
        btnKembali.setBounds(155,225,100,20);
    }

    public String getUsername(){
        return tfUsername.getText();
    }
    public String getPassword(){
        return String.valueOf(tfPassword.getPassword());
    }
}
