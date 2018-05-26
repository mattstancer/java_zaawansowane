package com.company;

import com.mysql.jdbc.ConnectionFeatureNotAvailableException;
import com.mysql.jdbc.jdbc2.optional.JDBC4MysqlPooledConnection;
//import org.
import java.sql.*;
import java.math.*;
import java.util.*;
public class EmployeesDb {
    private String host="jdbc:mysql://localhost:3306/employees";
    private String user = "root";

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getDbPass() {
        return dbPass;
    }
public Connection conn;
    private String dbPass = "";
    public EmployeesDb(String host, String user, String dbPass){

        if(host!="") {
            this.host=host;
        }
        if(user!="") {
            this.user=user;
        }
        if(dbPass!="") {
            this.dbPass=dbPass;
        }

    }
//    private JDBC4MysqlPooledConnection dbcp;
//    public Connection pooledConnection(){
//
//         try{
//             dbcp.getConnection();
//         }
//catch (ConnectionFeatureNotAvailableException e){
//
//}
  //  }
    public void Connect(){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            this.conn=DriverManager.getConnection(this.host, this.user, this.dbPass);
            this.conn.setAutoCommit(false);
            System.out.println("Connected");
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Błąd połączenia z bazą danych");
        }
    }
    public void AddEmployee(){

    }
    public void Add()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Dodaj Pracownika");
        System.out.println("[D]yrektor/[H]handlowiec:");
        char wybor = (char)input.next().charAt(0);

        if(wybor =='D')
        {
            Directors person = new Directors("0", "0", new BigDecimal(0), 0, 0, new BigDecimal(0),0,new BigDecimal(0));
            person.DodajPracownika();

            person.Wyswietl();

            try {
                PreparedStatement prepareInsertDyrektor = conn.prepareStatement("INSERT INTO employees  (pesel, firstname, surname, payment, costsLimit, supplement, phone, stanowisko, businessCard) VALUES (?, ?, ?, ?, ?, ?, ?,?,?)" );
                prepareInsertDyrektor.setInt(1, person.getPesel());
                prepareInsertDyrektor.setString(2, person.getImie());
                prepareInsertDyrektor.setString(3, person.getNazwisko());
                prepareInsertDyrektor.setBigDecimal(4, person.getPayment());
                prepareInsertDyrektor.setBigDecimal(5, person.getCostsLimit());
                prepareInsertDyrektor.setBigDecimal(6, person.getSupplement());
                prepareInsertDyrektor.setInt(7, person.getPhonenumber());
                prepareInsertDyrektor.setString(8, person.getType());
                prepareInsertDyrektor.setInt(9, person.getBusinessCard());
                prepareInsertDyrektor.executeUpdate();
                conn.commit();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }

        if(wybor == 'H')
        {
            Traders person = new Traders("0", "0", new BigDecimal(0), 0, 0, new BigDecimal(0),new BigDecimal(0));
            person.DodajPracownika();

            try {
                PreparedStatement prepareInsertHandlowiec = this.conn.prepareStatement( "INSERT INTO employees (pesel, firstname, surname, payment,  percentageValue, percentageLimitValue, phone, stanowisko ) VALUES (?, ?,?, ?, ?, ?, ?, ?)" );
                prepareInsertHandlowiec.setInt(1, person.getPesel());
                prepareInsertHandlowiec.setString(2, person.getImie());
                prepareInsertHandlowiec.setString(3, person.getNazwisko());
                prepareInsertHandlowiec.setBigDecimal(4, person.getPayment());
                prepareInsertHandlowiec.setString(8, person.getType());
                prepareInsertHandlowiec.setInt(7, person.getPhonenumber());
                prepareInsertHandlowiec.setBigDecimal(6, person.getPercentageValue());
                prepareInsertHandlowiec.setBigDecimal(5, person.getPercentageLimitValue());
                prepareInsertHandlowiec.executeUpdate();
                this.conn.commit();


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public  void Delete(){

        Scanner line = new Scanner(System.in);
        ArrayList<Employees> lista_pracownikow = null;
        Statement stmt = null;
        try{
            lista_pracownikow = new ArrayList();

            stmt = this.conn.createStatement();
            String sql;
            sql = "SELECT * from employees";

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){

                Integer id = Integer.valueOf(rs.getInt("pesel"));
                String imie = rs.getString("firstname");
                String nazwisko = rs.getString("surname");
                BigDecimal wynagrodzenie = rs.getBigDecimal("payment");
                String stanowisko = rs.getString("stanowisko");
                Integer telefon = rs.getInt("phone");
                BigDecimal prowizja = rs.getBigDecimal("percentageValue");
                BigDecimal limit_prowizji = rs.getBigDecimal("percentageLimitValue");
                BigDecimal dodatek_sluzbowy = rs.getBigDecimal("supplement");
                Integer karta_sluzbowa = rs.getInt("businessCard");
                BigDecimal limit_kosztow = rs.getBigDecimal("costsLimit");

                if(stanowisko.equals("Dyrektor")) {
                    Directors dyrektor = new Directors(imie, nazwisko, wynagrodzenie, id, telefon, dodatek_sluzbowy,karta_sluzbowa,limit_kosztow);



                    System.out.println(dyrektor.toString());

                    lista_pracownikow.add(dyrektor);
                }else {
                    Traders handlowiec = new Traders(imie, nazwisko, wynagrodzenie, id, telefon, prowizja,limit_prowizji);
                    lista_pracownikow.add(handlowiec);
                }
            }
            rs.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

        Iterator it = lista_pracownikow.iterator();
        String op;
        int index = 0;
        while(it.hasNext()){

            lista_pracownikow.get(index).Wyswietl();
            System.out.println("[Enter]\tDalej");
            System.out.println("[D]\tUsuń");
            System.out.println("[Q]\tPorzuć");

            op = line.nextLine();
            if(op.equals("")){
                it.next();
                index++;
            }
            if(op.equals("D")) {
                String sql;
                Integer pesel =lista_pracownikow.get(index).getPesel();
                sql = "DELETE FROM employees WHERE pesel =?";
                lista_pracownikow.remove(index);
                //System.out.println(sql);
                try {
                    PreparedStatement prpstm=this.conn.prepareStatement(sql);
                    prpstm.setInt(1,pesel);
                    prpstm.executeUpdate();
                    this.conn.commit();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(op.equals("Q") || op.equals("q")) return;
        }
    }

    public  ArrayList<Employees> employersList(){

        Scanner line = new Scanner(System.in);
        ArrayList<Employees> lista_pracownikow = null;
        Statement stmt = null;
        try{
            lista_pracownikow = new ArrayList();

            stmt = conn.createStatement();
            String sql = "SELECT * from employees";

            ResultSet rs = stmt.executeQuery(sql);
            try{conn.commit();}
            catch(SQLException e){
                conn.rollback();
            }

            while(rs.next()){

                Integer id = Integer.valueOf(rs.getInt("pesel"));
                String imie = rs.getString("firstname");
                String nazwisko = rs.getString("surname");
                BigDecimal wynagrodzenie = rs.getBigDecimal("payment");
                String stanowisko = rs.getString("stanowisko");
                Integer telefon = rs.getInt("phone");
                BigDecimal prowizja = rs.getBigDecimal("percentageValue");
                BigDecimal limit_prowizji = rs.getBigDecimal("percentageLimitValue");
                BigDecimal dodatek_sluzbowy = rs.getBigDecimal("supplement");
                Integer karta_sluzbowa = rs.getInt("businessCard");
                BigDecimal limit_kosztow = rs.getBigDecimal("costsLimit");



                if(stanowisko.equals("Dyrektor")) {
                    Directors dyrektor = new Directors(imie, nazwisko, wynagrodzenie, id, telefon, dodatek_sluzbowy,karta_sluzbowa,limit_kosztow);



                    System.out.println(dyrektor.toString());

                    lista_pracownikow.add(dyrektor);
                }else {
                    Traders handlowiec = new Traders(imie, nazwisko, wynagrodzenie, id, telefon, prowizja,limit_prowizji);
                    lista_pracownikow.add(handlowiec);
                    System.out.println(handlowiec.toString());
                }
            }
            rs.close();
            stmt.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
        }
    return lista_pracownikow;
    }

    public  void showList(){

        Scanner line = new Scanner(System.in);
        ArrayList<Employees> lista_pracownikow = null;
        Statement stmt = null;
        try{
            lista_pracownikow = new ArrayList();

            stmt = this.conn.createStatement();
            String sql = "SELECT * from employees";

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){

                Integer pesel = rs.getInt("pesel");
                String imie = rs.getString("firstname");
                String nazwisko = rs.getString("surname");
                BigDecimal wynagrodzenie = rs.getBigDecimal("payment");
                String stanowisko = rs.getString("stanowisko");
                Integer telefon = rs.getInt("phone");
                BigDecimal prowizja = rs.getBigDecimal("percentageValue");
                BigDecimal limit_prowizji = rs.getBigDecimal("percentageLimitValue");
                BigDecimal dodatek_sluzbowy = rs.getBigDecimal("supplement");
                Integer karta_sluzbowa = rs.getInt("businessCard");
                BigDecimal limit_kosztow = rs.getBigDecimal("costsLimit");
                System.out.println(stanowisko);


                if(stanowisko.equals("Dyrektor")) {
                    Directors dyrektor = new Directors(imie, nazwisko, wynagrodzenie, pesel, telefon, dodatek_sluzbowy,karta_sluzbowa,limit_kosztow);



                    System.out.println(dyrektor.toString());

                    lista_pracownikow.add(dyrektor);
                }else {
                    Traders handlowiec = new Traders(imie, nazwisko, wynagrodzenie, pesel, telefon, prowizja,limit_prowizji);
                    lista_pracownikow.add(handlowiec);
                }
            }
            rs.close();
            stmt.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
        }

        Iterator it = lista_pracownikow.iterator();
        String op;
        int index = 0;
        while(it.hasNext()){

            lista_pracownikow.get(index++).Wyswietl();
            System.out.println("[Enter]\tDalej");
            System.out.println("[Q]\tWyjście");

            op = line.nextLine();
            if(op.equals("")) it.next();
            if(op.equals("Q") || op.equals("q")) return;
        }
    }

    public boolean CheckEmployee() {

        String sql = String.format("select count(*) as ilosc from employees where pesel=?");

        try {
            PreparedStatement employeeToDb = this.conn.prepareStatement(sql);
            employeeToDb.setInt(1, new Integer(6666));
//            employeeToDb.execute();

            ResultSet rs = employeeToDb.executeQuery();
            this.conn.commit();
            while (rs.next()) {
                System.out.println(rs.getInt("ilosc"));
                if (rs.getInt("ilosc") <= 0) {

                    return true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
return true;

    }


}
