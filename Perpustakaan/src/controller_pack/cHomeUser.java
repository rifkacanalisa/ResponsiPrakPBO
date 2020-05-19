package controller_pack;
import view_pack.*;
import Utama.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class cHomeUser {
    vHomeAnggota vHomeAnggota;
    Model model;

    public cHomeUser(vHomeAnggota vHomeAnggota, Model model, int id_user){
        this.vHomeAnggota = vHomeAnggota;
        this.model = model;

        String user[] = model.getUser(id_user);
        vHomeAnggota.lWelcome.setText("Selamat Datang, "+user[1]);

        vHomeAnggota.lWelcome.addMouseListener(new MouseAdapter() {
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
                                vHomeAnggota.dispose();
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

        vHomeAnggota.btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vHomeAnggota.dispose();
                    MVC mvc = new MVC();
                } catch (Exception e1){
                    System.out.println("Gagal button logout");
                }
            }
        });

        vHomeAnggota.btnPinjam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vPinjamBuku vPinjamBuku = new vPinjamBuku();
                    cPinjamBuku cPinjamBuku = new cPinjamBuku(vPinjamBuku,model);
                } catch (Exception e1){
                    System.out.println("Gagal button pinjam User!");
                }
            }
        });

        vHomeAnggota.btnBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vDaftarBuku vDaftarBuku = new vDaftarBuku();
                    String buku[][] = model.getBuku("anggota");
                    vDaftarBuku.table.setModel((new JTable(buku,vDaftarBuku.namaKolom)).getModel());

                    vDaftarBuku.btnSearch.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                String cari = vDaftarBuku.getSearch();
                                String carikan[][] = model.searchBuku("user",cari);
                                vDaftarBuku.table.setModel((new JTable(carikan,vDaftarBuku.namaKolom)).getModel());
                                vDaftarBuku.tfSearch.setText("Pencarian (judul)");
                            } catch (Exception e1){
                                System.out.println("Gagal button search daftar buku user!");
                            }
                        }
                    });

                    vDaftarBuku.btnRefresh.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                String buku[][] = model.getBuku("anggota");
                                vDaftarBuku.table.setModel((new JTable(buku,vDaftarBuku.namaKolom)).getModel());
                                vDaftarBuku.tfSearch.setText("Pencarian (judul)");
                            } catch (Exception e1){
                                System.out.println("Gagal button refresh daftar buku user");
                            }
                        }
                    });

                    vDaftarBuku.btnKembali.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                vDaftarBuku.dispose();
                            } catch (Exception e1){
                                System.out.println("Gagal button kembali Daftar buku User!");
                            }
                        }
                    });

                    vDaftarBuku.tfSearch.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            vDaftarBuku.tfSearch.setText("");
                        }
                    });
                } catch (Exception e1){
                    System.out.println("Gagal button buku user!");
                }
            }
        });
    }

    public void updateBuku(){
    }
}
