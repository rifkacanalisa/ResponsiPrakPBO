package Utama;

import javax.swing.*;
import java.sql.*;

public class Model {
    static final String driver = "com.mysql.jdbc.Driver";
    static final String dbURL = "jdbc:mysql://localhost/dbperpustakaan";
    static final String user = "root";
    static final String pass = "";
    Connection connection;
    Statement statement;

    public Model(){
        try{
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(dbURL,user,pass);
            System.out.println("Koneksi Berhasil!!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Gagal Koneksi Database!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Driver Tidak Ditemukan!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public String[] login(String username, String password){
        try{
            String data[] = new String[2];
            String query = "select * from `user` where username='"+username+"' and password='"+password+"'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                data[0] = "true";
                data[1] = String.valueOf(resultSet.getInt("id_user"));
                return data;
            }
            else{
                JOptionPane.showMessageDialog(null,"Gagal Login!", "Hasil",
                        JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Gagal Login Model!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String[] getUser(int id_user){
        try{
            String[] data = new String[4];
            String query = "select * from `user` where id_user='"+id_user+"'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                data[0] = String.valueOf(resultSet.getInt("id_user"));
                data[1] = resultSet.getString("username");
                data[2] = resultSet.getString("password");
                data[3] = resultSet.getString("role");
            }
            return data;
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Gagal mengambil data user!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void insertUser(String username, String password, String role){
        try{
            String query = "INSERT INTO `user` VALUES (NULL,'"+username+"','"+password+"','"+role+"')";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Registrasi Berhasil!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Registrasi Gagal!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateUser(int id_user,String username, String password){
        try{
            String query = "update `user` set username='"+username+"',password='"+password+"' where id_user='"+id_user+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Update Profil Berhasil!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Update Profil Gagal!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteUser(int id_user){
        try{
            String query = "delete from `user` where id_user='"+id_user+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Delete User Berhasil!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Delete User Gagal!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getBanyakBuku(){
        try{
            int jumlahBuku = 0;
            String query = "select * from `buku`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jumlahBuku++;
            }
            return jumlahBuku;
        } catch (SQLException sqlException){
            System.out.println("Gagal model mengambil banyak Buku!");
            return 0;
        }
    }

    public String[][] getBuku(String role){
        try{
            int jumlahBuku = 0;
            if(role.equals("admin")){
                String[][] buku = new String[getBanyakBuku()][5];
                String query = "select * from `buku`";
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    buku[jumlahBuku][0] = String.valueOf(jumlahBuku+1);
                    buku[jumlahBuku][1] = String.valueOf(resultSet.getInt("id_buku"));
                    buku[jumlahBuku][2] = resultSet.getString("judul");
                    buku[jumlahBuku][3] = resultSet.getString("jenis");
                    buku[jumlahBuku][4] = String.valueOf(resultSet.getInt("jumlah_buku"));
                    jumlahBuku++;
                }
                return buku;
            }
            else{
                String[][] buku = new String[getBanyakBuku()][4];
                String query = "select judul,jenis,jumlah_buku from `buku`";
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    buku[jumlahBuku][0] = String.valueOf(jumlahBuku+1);
                    buku[jumlahBuku][1] = resultSet.getString("judul");
                    buku[jumlahBuku][2] = resultSet.getString("jenis");
                    buku[jumlahBuku][3] = String.valueOf(resultSet.getInt("jumlah_buku"));
                    jumlahBuku++;
                }
                return buku;
            }
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Gagal mengambil data buku!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void insertBuku(String judul, String jenis, int jumlah){
        try{
            String query = "INSERT INTO `buku` VALUES (NULL,'"+judul+"','"+jenis+"','"+jumlah+"')";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Penambahan Buku Berhasil!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Penambahan Buku Gagal!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateBuku(int id_buku,String judul, String jenis,int jumlah){
        try{
            String query = "update `buku` set judul='"+judul+"', jenis='"+jenis+"', jumlah_buku='"+jumlah+"' where id_buku='"+id_buku+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Update Buku Berhasil!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Update Buku Gagal!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteBuku(int id_buku){
        try{
            String query = "delete from `buku` where id_buku='"+id_buku+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Delete Buku Berhasil!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Delete Buku Gagal!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public String[][] searchBuku(String role,String cari){
        try{
            int jumlahBuku = 0;
            if(role.equals("admin")){
                String[][] buku = new String[getBanyakBuku()][5];
                String query = "select * from `buku` where judul like '%"+cari+"' or judul like '%"+cari+"%' or judul like '"+cari+"%'";
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    buku[jumlahBuku][0] = String.valueOf(jumlahBuku+1);
                    buku[jumlahBuku][1] = String.valueOf(resultSet.getInt("id_buku"));
                    buku[jumlahBuku][2] = resultSet.getString("judul");
                    buku[jumlahBuku][3] = resultSet.getString("jenis");
                    buku[jumlahBuku][4] = String.valueOf(resultSet.getInt("jumlah_buku"));
                    jumlahBuku++;
                }
                return buku;
            }
            else{
                String[][] buku = new String[getBanyakBuku()][4];
                String query = "select judul,jenis,jumlah_buku from `buku` where judul like '%"+cari+"' or judul like '%"+cari+"%' or judul like '"+cari+"%'";
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    buku[jumlahBuku][0] = String.valueOf(jumlahBuku+1);
                    buku[jumlahBuku][1] = resultSet.getString("judul");
                    buku[jumlahBuku][2] = resultSet.getString("jenis");
                    buku[jumlahBuku][3] = String.valueOf(resultSet.getInt("jumlah_buku"));
                    jumlahBuku++;
                }
                return buku;
            }
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Gagal mengambil data pencarian buku!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public int getBanyakPinjam(){
        try{
            int jumlahPeminjaman = 0;
            String query = "select * from `peminjaman`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jumlahPeminjaman++;
            }
            return jumlahPeminjaman;
        } catch (SQLException sqlException){
            System.out.println("Gagal model mengambil banyak Buku!");
            return 0;
        }
    }

    public String[][] getPeminjaman(String role){
        try{
            int jumlahPeminjaman = 0;
            if(role.equals("admin")){
                String[][] peminjaman = new String[getBanyakPinjam()][6];
                String query = "select id_peminjaman,id_anggota,nama_anggota,judul,status from `peminjaman` p inner join `buku` b on p.id_buku = b.id_buku";
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    peminjaman[jumlahPeminjaman][0] = String.valueOf(jumlahPeminjaman+1);
                    peminjaman[jumlahPeminjaman][1] = String.valueOf(resultSet.getInt("id_peminjaman"));
                    peminjaman[jumlahPeminjaman][2] = resultSet.getString("id_anggota");
                    peminjaman[jumlahPeminjaman][3] = resultSet.getString("nama_anggota");
                    peminjaman[jumlahPeminjaman][4] = resultSet.getString("judul");
                    peminjaman[jumlahPeminjaman][5] = resultSet.getString("status");
                    jumlahPeminjaman++;
                }
                return peminjaman;
            }
            else{
                String[][] peminjaman = new String[getBanyakPinjam()][6];
                String query = "select id_anggota,nama_anggota,judul,jenis,status from `peminjaman` p inner join `buku` b on p.id_buku = b.id_buku";
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    peminjaman[jumlahPeminjaman][0] = String.valueOf(jumlahPeminjaman+1);
                    peminjaman[jumlahPeminjaman][1] = resultSet.getString("id_anggota");
                    peminjaman[jumlahPeminjaman][2] = resultSet.getString("nama_anggota");
                    peminjaman[jumlahPeminjaman][3] = resultSet.getString("judul");
                    peminjaman[jumlahPeminjaman][4] = resultSet.getString("jenis");
                    peminjaman[jumlahPeminjaman][5] = resultSet.getString("status");
                    jumlahPeminjaman++;
                }
                return peminjaman;
            }
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Gagal mengambil data peminjaman!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void insertPeminjaman(String id_anggota, String nama, int id_buku){
        try{
            String query = "INSERT INTO `peminjaman` VALUES (NULL,'"+id_anggota+"','"+nama+"','"+id_buku+"','meminjam')";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Peminjaman Berhasil!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Peminjaman Gagal!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePeminjamanUser(String id_anggota, String nama, int id_buku_lama, int id_buku_baru){
        try{
            String query = "update `peminjaman` set nama_anggota='"+nama+"',id_buku='"+id_buku_baru+"'" +
                    " where id_anggota='"+id_anggota+"' and id_buku='"+id_buku_lama+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Update Peminjaman Berhasil!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Update Peminjaman Gagal!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePeminjamanAdmin(int id_pinjam){
        try{
            String query = "update `peminjaman` set status='kembali' where id_peminjaman='"+id_pinjam+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Update Peminjaman Berhasil!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Update Peminjaman Gagal!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deletePeminjaman(String id_anggota, int buku){
        try{
            String query = "delete from `peminjaman` where id_anggota='"+id_anggota+"' and id_buku='"+buku+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Delete Peminjaman Berhasil!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Delete Peminjaman Gagal!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deletePeminjamanAdmin(int id_peminjaman){
        try{
            String query = "delete from `peminjaman` where id_peminjaman='"+id_peminjaman+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Delete Peminjaman Berhasil!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Delete Peminjaman Gagal!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public String[][] searchPeminjaman(String role,String cari){
        try{
            int jumlahPeminjaman = 0;
            if(role.equals("admin")){
                String[][] peminjaman = new String[getBanyakPinjam()][6];
                String query = "select id_peminjaman,id_anggota,nama_anggota,judul,status from `peminjaman` p inner join `buku` b " +
                        "on p.id_buku = b.id_buku where nama_anggota like '%"+cari+"' or nama_anggota like '%"+cari+"%' or nama_anggota like '"+cari+"%'";
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    peminjaman[jumlahPeminjaman][0] = String.valueOf(jumlahPeminjaman+1);
                    peminjaman[jumlahPeminjaman][1] = String.valueOf(resultSet.getInt("id_peminjaman"));
                    peminjaman[jumlahPeminjaman][2] = resultSet.getString("id_anggota");
                    peminjaman[jumlahPeminjaman][3] = resultSet.getString("nama_anggota");
                    peminjaman[jumlahPeminjaman][4] = resultSet.getString("judul");
                    peminjaman[jumlahPeminjaman][5] = resultSet.getString("status");
                    jumlahPeminjaman++;
                }
                return peminjaman;
            }
            else{
                String[][] peminjaman = new String[getBanyakPinjam()][6];
                String query = "select id_anggota,nama_anggota,judul,jenis,status from `peminjaman` p inner join `buku` b " +
                        "on p.id_buku = b.id_buku where nama_anggota like '%"+cari+"' or nama_anggota like '%"+cari+"%' or nama_anggota like '"+cari+"%'";
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    peminjaman[jumlahPeminjaman][0] = String.valueOf(jumlahPeminjaman+1);
                    peminjaman[jumlahPeminjaman][1] = resultSet.getString("id_anggota");
                    peminjaman[jumlahPeminjaman][2] = resultSet.getString("nama_anggota");
                    peminjaman[jumlahPeminjaman][3] = resultSet.getString("judul");
                    peminjaman[jumlahPeminjaman][4] = resultSet.getString("jenis");
                    peminjaman[jumlahPeminjaman][5] = resultSet.getString("status");
                    jumlahPeminjaman++;
                }
                return peminjaman;
            }
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Gagal mengambil data pencarian peminjam!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
