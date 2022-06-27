package persistance;

import model.Zaposleni;
import persistance.Konekcija;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZaposleniCRUD {
    public static boolean unosZaposlenog(Zaposleni zaposleni) {
        try {
            Connection conn = Konekcija.uspostaviKonekciju();
            String query = "insert into zaposleni (ime, adresa, broj_godina, visina_dohotka) values (?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, zaposleni.getIme());
            st.setString(2, zaposleni.getAdresa());
            st.setInt(3, zaposleni.getBroj_godina());
            st.setDouble(4, zaposleni.getVisina_dohotka());
            st.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean brisanjeZaposlenog(int id) {
        try {
            Connection conn = Konekcija.uspostaviKonekciju();
            String query = "delete from zaposleni where zaposleni_id=?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            st.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Greska brisanje");
            return false;
        }
    }

    public static List<Zaposleni> prikazSvihZaposlenih() {
        List<Zaposleni> listaZaposlenih = new ArrayList<>();
        try {
            Connection conn = Konekcija.uspostaviKonekciju();
            Statement st = conn.createStatement();
            String query = "select * from zaposleni";
            st.executeQuery(query);
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                Zaposleni zaposleni1 = new Zaposleni(rs.getInt("zaposleni_id"), rs.getString("ime"),
                        rs.getString("adresa"), rs.getInt("broj_godina"), rs.getDouble("visina_dohotka"));
                listaZaposlenih.add(zaposleni1);
            }

            for (Zaposleni z : listaZaposlenih) {
                System.out.println(z);
            }

            return listaZaposlenih;


        } catch (SQLException e) {
            System.out.println("Greska");
        }
        return listaZaposlenih;
    }

    public static boolean izmenaZaposlenog(Zaposleni zaposleni) {

        try {
        Connection conn = Konekcija.uspostaviKonekciju();
        String query = "update zaposleni set ime=?, adresa=?, broj_godina=?, visina_dohotka=? where zaposleni_id=?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, zaposleni.getIme());
        st.setString(2, zaposleni.getAdresa());
        st.setInt(3, zaposleni.getBroj_godina());
        st.setDouble(4, zaposleni.getVisina_dohotka());
        st.setInt(5, zaposleni.getZaposleni_id());
        st.execute();
        return true;
        }
        catch (SQLException e) {
            System.out.println("Greska izmena");
            return false;
        }
    }

    public static List<Zaposleni> prikazPoImenu(String zaposleni) {
        List<Zaposleni> listaZaposlenih = new ArrayList<>();
        try {
            Connection conn = Konekcija.uspostaviKonekciju();
            String query = "select * from zaposleni where ime=?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, zaposleni);
            st.execute();
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                Zaposleni zaposleni1 = new Zaposleni(rs.getInt("zaposleni_id"), rs.getString("ime"),
                        rs.getString("adresa"), rs.getInt("broj_godina"), rs.getDouble("visina_dohotka"));
                listaZaposlenih.add(zaposleni1);
            }
            if (listaZaposlenih.isEmpty()) {
                System.out.println("Nema zaposlenog sa tim imenom");
            } else {
                for (Zaposleni zap : listaZaposlenih) {
                    System.out.println(zap);
                }
            }
        } catch (SQLException e) {
            System.out.println("Greska prikaz po imenu");
        }
        return listaZaposlenih;
    }

    public static Zaposleni pretragaPoId(int id) {
        Zaposleni zaposleni1 = new Zaposleni();
        try {
            Connection conn = Konekcija.uspostaviKonekciju();
            String query = "select * from zaposleni where zaposleni_id=?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            st.execute();
            ResultSet rs = st.getResultSet();
            if (rs.next()) {
                zaposleni1 = new Zaposleni(rs.getInt("zaposleni_id"), rs.getString("ime"),
                        rs.getString("adresa"), rs.getInt("broj_godina"), rs.getDouble("visina_dohotka"));
            }
        } catch (SQLException e) {
            System.out.println("Greska pretragaPoId");
        }
        return zaposleni1;

    }
}
