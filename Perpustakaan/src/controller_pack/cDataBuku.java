package controller_pack;
import view_pack.*;
import Utama.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class cDataBuku {
    vDataBuku vDataBuku;
    Model model;
    int baris;
    String dataEdit;

    public cDataBuku(vDataBuku vDataBuku, Model model){
        this.vDataBuku = vDataBuku;
        this.model = model;

        if(model.getBanyakBuku()!=0){
            updateData();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data Buku Tidak Ada");
        }

        vDataBuku.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baris = vDataBuku.table.getSelectedRow();
                dataEdit = vDataBuku.table.getValueAt(baris,0).toString();
                if(dataEdit!=null){
                    vDataBuku.lIdPilih.setText(vDataBuku.table.getValueAt(baris,1).toString());
                    vDataBuku.lJudulPilih.setText(vDataBuku.table.getValueAt(baris,2).toString());
                    vDataBuku.lJenisPilih.setText(vDataBuku.table.getValueAt(baris,3).toString());
                    vDataBuku.lJumlahPilih.setText(vDataBuku.table.getValueAt(baris,4).toString());
                    vDataBuku.btnEdit.setEnabled(true);
                    vDataBuku.btnHapus.setEnabled(true);
                }
            }
        });

        vDataBuku.tfSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vDataBuku.tfSearch.setText("");
            }
        });

        vDataBuku.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(vDataBuku.getJenis().equals("") || vDataBuku.getJudul().equals("") || vDataBuku.getJumlah().equals("")){
                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                    }
                    else{
                        String jenis = vDataBuku.getJenis();
                        String judul = vDataBuku.getJudul();
                        int jumlah = Integer.parseInt(vDataBuku.getJumlah());
                        model.insertBuku(judul,jenis,jumlah);
                        updateData();
                        vDataBuku.tfJudul.setText("");
                        vDataBuku.tfJenis.setText("");
                        vDataBuku.tfJumlah.setValue(1);
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button tambah buku admin");
                }
            }
        });

        vDataBuku.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id_buku = Integer.parseInt(vDataBuku.table.getValueAt(baris,1).toString());
                    String judulA = vDataBuku.table.getValueAt(baris,2).toString();
                    String jenisA = vDataBuku.table.getValueAt(baris,3).toString();
                    int jumlahA = Integer.parseInt(vDataBuku.table.getValueAt(baris,4).toString());
                    vDataBuku.dispose();

                    vEditBuku vEditBuku = new vEditBuku();
                    vEditBuku.tfJudul.setText(judulA);
                    vEditBuku.tfJenis.setText(jenisA);
                    vEditBuku.tfJumlah.setValue(jumlahA);
                    vEditBuku.btnSimpan.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                if(vEditBuku.getJenis().equals("") || vEditBuku.getJudul().equals("") || vEditBuku.getJumlah().equals("")){
                                    JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                                }
                                else{
                                    String jenis = vEditBuku.getJenis();
                                    String judul = vEditBuku.getJudul();
                                    int jumlah = Integer.parseInt(vEditBuku.getJumlah());
                                    model.updateBuku(id_buku,judul,jenis,jumlah);
                                    updateData();
                                    vEditBuku.dispose();
                                    vDataBuku vDataBuku1 = new vDataBuku();
                                    cDataBuku cDataBuku = new cDataBuku(vDataBuku1,model);
                                }
                            } catch (Exception e1){
                                System.out.println("Gagal button simpan Edit buku");
                            }
                        }
                    });

                    vEditBuku.btnKembali.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                vEditBuku.dispose();
                                vDataBuku vDataBuku1 = new vDataBuku();
                                cDataBuku cDataBuku = new cDataBuku(vDataBuku1,model);
                            } catch (Exception e1){
                                System.out.println("Gagal button kembali edit buku!");
                            }
                        }
                    });

                } catch (Exception e1){
                    System.out.println("Gagal button edit buku admin");
                }
            }
        });

        vDataBuku.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id_buku = Integer.parseInt(vDataBuku.table.getValueAt(baris,1).toString());
                    model.deleteBuku(id_buku);
                    updateData();
                } catch (Exception e1){
                    System.out.println("Gagal button hapus buku admin!");
                }
            }
        });

        vDataBuku.btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String cari = vDataBuku.getSearch();
                    String hasilCari[][] = model.searchBuku("admin",cari);
                    vDataBuku.table.setModel((new JTable(hasilCari,vDataBuku.namaKolom)).getModel());
                    vDataBuku.tfSearch.setText("Pencarian (judul)");
                } catch (Exception e1){
                    System.out.println("Gagal button cari buku!");
                }
            }
        });

        vDataBuku.btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    updateData();
                    vDataBuku.tfSearch.setText("Pencarian (judul)");
                } catch (Exception e1){
                    System.out.println("Gagal button refresh Buku!");
                }
            }
        });

        vDataBuku.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vDataBuku.dispose();
                } catch (Exception e1){
                    System.out.println("Gagal button kembali");
                }
            }
        });
    }
    public void updateData(){
        String buku[][] = model.getBuku("admin");
        vDataBuku.table.setModel((new JTable(buku,vDataBuku.namaKolom)).getModel());
    }
}
