package controller_pack;
import view_pack.*;
import Utama.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class cPeminjaman {
    vPeminjaman vPeminjaman;
    Model model;
    int baris;
    String dataEdit;

    public cPeminjaman(vPeminjaman vPeminjaman, Model model){
        this.vPeminjaman = vPeminjaman;
        this.model = model;

        if(model.getBanyakPinjam()!=0){
            updateData();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data Peminjaman Tidak Ada");
        }

        vPeminjaman.tfSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vPeminjaman.tfSearch.setText("");
            }
        });

        vPeminjaman.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baris = vPeminjaman.table.getSelectedRow();
                dataEdit = vPeminjaman.table.getValueAt(baris,0).toString();
                if(dataEdit!=null){
                    vPeminjaman.lIdPilih.setText(vPeminjaman.table.getValueAt(baris,1).toString());
                    vPeminjaman.lIdAnggotaPilih.setText(vPeminjaman.table.getValueAt(baris,2).toString());
                    vPeminjaman.lNamaPilih.setText(vPeminjaman.table.getValueAt(baris,3).toString());
                    vPeminjaman.lJudulPilih.setText(vPeminjaman.table.getValueAt(baris,4).toString());
                    vPeminjaman.lStatusPilih.setText(vPeminjaman.table.getValueAt(baris,5).toString());
                    if(vPeminjaman.table.getValueAt(baris,5).toString().equals("meminjam")){
                        vPeminjaman.btnEdit.setEnabled(true);
                        vPeminjaman.btnHapus.setEnabled(false);
                    }
                    else {
                        vPeminjaman.btnEdit.setEnabled(false);
                        vPeminjaman.btnHapus.setEnabled(true);
                    }

                }
            }
        });

        vPeminjaman.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(dataEdit!=null){
                        int pinjam = Integer.parseInt(vPeminjaman.table.getValueAt(baris,1).toString());
                        model.updatePeminjamanAdmin(pinjam);
                        updateData();
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button mengembalikan admin");
                }
            }
        });

        vPeminjaman.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id_pinjam = Integer.parseInt(vPeminjaman.table.getValueAt(baris,1).toString());
                    model.deletePeminjamanAdmin(id_pinjam);
                    updateData();
                } catch (Exception e1){
                    System.out.println("Gagal button hapus peminjaman admin!");
                }
            }
        });

        vPeminjaman.btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String cari = vPeminjaman.getSearch();
                    String hasilCari[][] = model.searchPeminjaman("admin",cari);
                    vPeminjaman.table.setModel((new JTable(hasilCari,vPeminjaman.namaKolom)).getModel());
                    vPeminjaman.tfSearch.setText("Pencarian (nama)");
                } catch (Exception e1){
                    System.out.println("Gagal button cari peminjaman!");
                }
            }
        });

        vPeminjaman.btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    updateData();
                    vPeminjaman.tfSearch.setText("Pencarian (nama)");
                } catch (Exception e1){
                    System.out.println("Gagal button refresh peminjaman!");
                }
            }
        });

        vPeminjaman.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vPeminjaman.dispose();
                } catch (Exception e1){
                    System.out.println("Gagal button kembali");
                }
            }
        });

    }

    public void updateData(){
        String peminjaman[][] = model.getPeminjaman("admin");
        vPeminjaman.table.setModel((new JTable(peminjaman,vPeminjaman.namaKolom)).getModel());

    }
}
