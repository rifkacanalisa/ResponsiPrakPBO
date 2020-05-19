package controller_pack;
import Utama.*;
import view_pack.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class cPinjamBuku {
    vPinjamBuku vPinjamBuku;
    Model model;
    int baris;
    String dataEdit;

    public cPinjamBuku(vPinjamBuku vPinjamBuku, Model model){
        this.vPinjamBuku = vPinjamBuku;
        this.model = model;

        if(model.getBanyakPinjam()!=0){
            updateData();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data Peminjaman Tidak Ada");
        }

        if (model.getBanyakBuku()!=0){
            int banyakBuku = model.getBanyakBuku();
            for(int i=0; i<banyakBuku; i++){
                String buku[][] = model.getBuku("anggota");
                vPinjamBuku.tfBuku.addItem(buku[i][1]);
            }
        }

        vPinjamBuku.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baris = vPinjamBuku.table.getSelectedRow();
                dataEdit = vPinjamBuku.table.getValueAt(baris,0).toString();
                if(dataEdit!=null){
                    vPinjamBuku.lIdPilih.setText(vPinjamBuku.table.getValueAt(baris,1).toString());
                    vPinjamBuku.lNamaPilih.setText(vPinjamBuku.table.getValueAt(baris,2).toString());
                    vPinjamBuku.lBukuPilih.setText(vPinjamBuku.table.getValueAt(baris,3).toString());
                    vPinjamBuku.btnEdit.setEnabled(true);
                    vPinjamBuku.btnHapus.setEnabled(true);
                }
            }
        });

        vPinjamBuku.tfSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vPinjamBuku.tfSearch.setText("");
            }
        });

        vPinjamBuku.btnPinjam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(vPinjamBuku.getNama().equals("") || vPinjamBuku.getBuku().equals("") || vPinjamBuku.getID().equals("")){
                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                    }
                    else{
                        String id_anggota = vPinjamBuku.getID();
                        String nama = vPinjamBuku.getNama();
                        String judul = vPinjamBuku.getBuku();
                        String cariBuku[][] = model.searchBuku("admin",judul);
                        int id_buku = Integer.parseInt(cariBuku[0][1]);
                        model.insertPeminjaman(id_anggota,nama,id_buku);
                        updateData();
                        vPinjamBuku.tfId.setText("");
                        vPinjamBuku.tfNama.setText("");
                        vPinjamBuku.tfBuku.setSelectedItem(judul);
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button pinjam buku");
                }
            }
        });

        vPinjamBuku.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(dataEdit!=null){
                        String id_anggota = vPinjamBuku.table.getValueAt(baris,1).toString();
                        String nama = vPinjamBuku.table.getValueAt(baris,2).toString();
                        String judul = vPinjamBuku.table.getValueAt(baris,3).toString();
                        String dataBuku[][] = model.searchBuku("admin",judul);
                        int id_buku_lama = Integer.parseInt(dataBuku[0][1]);
                        vPinjamBuku.dispose();
                        vEditPinjam vEditPinjam = new vEditPinjam();

                        int banyakBuku = model.getBanyakBuku();
                        String buku[][] = model.getBuku("anggota");
                        for(int i=0; i<banyakBuku; i++){
                            vEditPinjam.tfBuku.addItem(buku[i][1]);
                        }
                        vEditPinjam.tfId.setText(id_anggota);
                        vEditPinjam.tfNama.setText(nama);
                        for(int i=0; i<banyakBuku; i++){
                            if(buku[i][1].equals(judul)){
                                vEditPinjam.tfBuku.setSelectedItem(buku[i][1]);
                            }
                        }

                        vEditPinjam.btnSimpan.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    if(vEditPinjam.getNama().equals("") || vEditPinjam.getBuku().equals("") || vEditPinjam.getID().equals("")){
                                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                                    }
                                    else{
                                        String id_anggotaE = vEditPinjam.getID();
                                        String namaE = vEditPinjam.getNama();
                                        String judulE = vEditPinjam.getBuku();
                                        String cariBukuE[][] = model.searchBuku("admin",judulE);
                                        int id_bukuE = Integer.parseInt(cariBukuE[0][1]);
                                        model.updatePeminjamanUser(id_anggotaE,namaE,id_buku_lama,id_bukuE);
                                        updateData();
                                        vEditPinjam.dispose();
                                        vPinjamBuku vPinjamBuku1 = new vPinjamBuku();
                                        cPinjamBuku cPinjamBuku = new cPinjamBuku(vPinjamBuku1,model);
                                    }
                                } catch (Exception e1){
                                    System.out.println("Gagal button simpan edit peminjaman");
                                }
                            }
                        });

                        vEditPinjam.btnKembali.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    vEditPinjam.dispose();
                                    vPinjamBuku vPinjamBuku1 = new vPinjamBuku();
                                    cPinjamBuku cPinjamBuku = new cPinjamBuku(vPinjamBuku1,model);
                                } catch (Exception e1){
                                    System.out.println("Gagal button kembali edit peminjaman!");
                                }
                            }
                        });
                    }
                }catch (Exception e1){
                    System.out.println("Gagal button edit peminjaman!");
                }
            }
        });

        vPinjamBuku.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String id_anggota = vPinjamBuku.table.getValueAt(baris,1).toString();
                    String judul = vPinjamBuku.table.getValueAt(baris,3).toString();
                    String cariBuku[][] = model.searchBuku("admin",judul);
                    int id_buku = Integer.parseInt(cariBuku[0][1]);
                    model.deletePeminjaman(id_anggota,id_buku);
                    updateData();
                    vPinjamBuku.btnHapus.setEnabled(false);
                    vPinjamBuku.btnEdit.setEnabled(false);
                } catch (Exception e1){
                    System.out.println("Gagal button hapus pinjam buku");
                }
            }
        });

        vPinjamBuku.btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String cari = vPinjamBuku.getSearch();
                    String hasilCari[][] = model.searchPeminjaman("anggota",cari);
                    vPinjamBuku.table.setModel((new JTable(hasilCari,vPinjamBuku.namaKolom)).getModel());
                    vPinjamBuku.tfSearch.setText("Pencarian (nama)");
                } catch (Exception e1){
                    System.out.println("Gagal button cari pinjam buku!");
                }
            }
        });

        vPinjamBuku.btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    updateData();
                    vPinjamBuku.tfSearch.setText("Pencarian (nama)");
                } catch (Exception e1){
                    System.out.println("Gagal button refresh Pinjam Buku!");
                }
            }
        });

        vPinjamBuku.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vPinjamBuku.dispose();
                } catch (Exception e1){
                    System.out.println("Gagal button kembali");
                }
            }
        });
    }

    public void updateData(){
        String pinjam[][] = model.getPeminjaman("anggota");
        vPinjamBuku.table.setModel((new JTable(pinjam,vPinjamBuku.namaKolom)).getModel());
    }
}
