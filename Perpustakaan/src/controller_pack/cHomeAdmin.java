package controller_pack;
import view_pack.*;
import Utama.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class cHomeAdmin {
    vHomeAdmin vHomeAdmin;
    Model model;

    public cHomeAdmin(vHomeAdmin vHomeAdmin, Model model,int id_user){
        this.vHomeAdmin = vHomeAdmin;
        this.model = model;

        String user[] = model.getUser(id_user);
        vHomeAdmin.lWelcome.setText("Selamat Datang, "+user[1]);

        vHomeAdmin.btnBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vDataBuku vDataBuku = new vDataBuku();
                    cDataBuku cDataBuku = new cDataBuku(vDataBuku,model);
                } catch (Exception e1){
                    System.out.println("Gagal button data buku admin!");
                }
            }
        });

        vHomeAdmin.lWelcome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    String user1[] = model.getUser(id_user);
                    int id_usernya = Integer.parseInt(user1[0]);
                    vProfil vProfil = new vProfil();
                    vProfil.tfUsername.setText(user1[1]);
                    vProfil.tfPassword.setText(user1[2]);

                    vProfil.btnSimpan.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                if(vProfil.getUsername().equals("") || vProfil.getPassword().equals("")){
                                    JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                                }
                                else{
                                    String username = vProfil.getUsername();
                                    String password = vProfil.getPassword();
                                    model.updateUser(id_usernya,username,password);
                                    vProfil.dispose();
                                }
                            } catch (Exception e1){
                                System.out.println("Gagal button simpan Profil");
                            }
                        }
                    });

                    vProfil.btnDelete.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                model.deleteUser(id_usernya);
                                vProfil.dispose();
                                vHomeAdmin.dispose();
                                MVC mvc = new MVC();
                            } catch (Exception e1){
                                System.out.println("Gagal button delete akun!");
                            }
                        }
                    });

                    vProfil.btnKembali.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                vProfil.dispose();
                            } catch (Exception e1){
                                System.out.println("Gagal button kembali Profil!");
                            }
                        }
                    });

                    vProfil.showPassword.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(vProfil.showPassword.isSelected()){
                                vProfil.tfPassword.setEchoChar((char)0);
                            }
                            else{
                                vProfil.tfPassword.setEchoChar('*');
                            }
                        }
                    });
                } catch (Exception e1){
                    System.out.println("Gagal menuju profil!");
                }
            }
        });

        vHomeAdmin.btnPinjam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vPeminjaman vPeminjaman = new vPeminjaman();
                    cPeminjaman cPeminjaman = new cPeminjaman(vPeminjaman,model);
                } catch (Exception e1){
                    System.out.println("Gagal button Peminjaman admin!");
                }
            }
        });

        vHomeAdmin.btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vHomeAdmin.dispose();
                    MVC mvc = new MVC();
                } catch (Exception e1){
                    System.out.println("Gagal button logout");
                }
            }
        });

        vHomeAdmin.btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vRegis vRegis = new vRegis();
                    vRegis.lJudul.setText("Rgistrasi Admin");

                    vRegis.btnRegis.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                if(vRegis.getUsername().equals("") || vRegis.getPassword().equals("")){
                                    JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                                }
                                else{
                                    String username = vRegis.getUsername();
                                    String password = vRegis.getPassword();
                                    String role = "admin";
                                    model.insertUser(username,password,role);
                                    vRegis.dispose();
                                }
                            } catch (Exception e1){
                                System.out.println("Gagal button registrasi Admin!");
                            }
                        }
                    });


                    vRegis.btnKembali.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                vRegis.dispose();
                            } catch (Exception e1){
                                System.out.println("Gagal button kembali tambah admin!");
                            }
                        }
                    });

                    vRegis.showPassword.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(vRegis.showPassword.isSelected()){
                                vRegis.tfPassword.setEchoChar((char)0);
                            }
                            else{
                                vRegis.tfPassword.setEchoChar('*');
                            }
                        }
                    });
                } catch (Exception e1){
                    System.out.println("Gagal button tambah admin!");
                }
            }
        });
    }
}
