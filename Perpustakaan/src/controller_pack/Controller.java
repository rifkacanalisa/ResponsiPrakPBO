package controller_pack;
import Utama.*;
import view_pack.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    vLogin vLogin;
    Model model;

    public Controller(vLogin vLogin, Model model){
        this.vLogin = vLogin;
        this.model = model;

        vLogin.showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vLogin.showPassword.isSelected()){
                    vLogin.tfPassword.setEchoChar((char)0);
                }
                else{
                    vLogin.tfPassword.setEchoChar('*');
                }
            }
        });

        vLogin.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(vLogin.getUsername().equals("") || vLogin.getPassword().equals("")){
                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                    }
                    else{
                        String username = vLogin.getUsername();
                        String password = vLogin.getPassword();
                        String login[] = model.login(username,password);
                        if(login[0].equals("true")){
                            int id_user = Integer.parseInt(login[1]);
                            String user[] = model.getUser(id_user);
                            vLogin.dispose();
                            if(user[3].equals("anggota")){
                                vHomeAnggota vHomeAnggota = new vHomeAnggota();
                                cHomeUser cHomeUser = new cHomeUser(vHomeAnggota,model,id_user);
                            }
                            else{
                                vHomeAdmin vHomeAdmin = new vHomeAdmin();
                                cHomeAdmin cHomeAdmin = new cHomeAdmin(vHomeAdmin,model, id_user);
                            }
                        }
                    }
                } catch (Exception e1){
                    vLogin.tfPassword.setText("");
                    System.out.println("Gagal button login");
                }
            }
        });

        vLogin.btnRegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vLogin.dispose();
                    vRegis vRegis = new vRegis();

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
                                    String role = "anggota";
                                    model.insertUser(username,password,role);
                                    vRegis.dispose();
                                    MVC mvc = new MVC();
                                }
                            } catch (Exception e1){
                                System.out.println("Gagal button registrasi!");
                            }
                        }
                    });

                    vRegis.btnKembali.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                vRegis.dispose();
                                MVC mvc = new MVC();
                            } catch (Exception e1){
                                System.out.println("Gagal button kembali registrasi!");
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
                    System.out.println("Gagal button register!");
                }
            }
        });

    }
}
