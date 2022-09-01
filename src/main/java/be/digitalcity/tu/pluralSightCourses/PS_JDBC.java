package be.digitalcity.tu.pluralSightCourses;

import java.sql.*;
import java.time.LocalDate;

public class PS_JDBC {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/loboticket";
        String userName = "root";
        String password = "";
//        String url = "jdbc:postgresql://localhost:5432/loboticket";
//        String userName = "postgres";
//        String password = "1234";

        try(Connection conn = DriverManager.getConnection(url, userName, password)) {

            System.out.println("===============prepareStatement=================");

            PreparedStatement stmt = conn.prepareStatement("select * from  Acts");
            var results = stmt.executeQuery();
            while(results.next()) {
                System.out.println(results.getString("Name"));
            }

            System.out.println("=============== executeQuery ===================");

            String sql = "select name, capacity from venues";

            var stmt2 = conn.prepareStatement(sql);
            ResultSet rs = stmt2.executeQuery();

            while(rs.next()) {
                System.out.print(rs.getString("Name")+" : "+rs.getInt("Capacity")+"\n");
            }

            System.out.println("=============== executeUpdate ===================");

//            simpleInsertWithExecuteUpdate(conn);
//            Thread.sleep(1000);
//            simpleUpdateWithExecuteUpdate(conn);

            System.out.println("=============== execute ===================");

            Thread.sleep(1000);
            simpleDeleteWithExecute(conn);

            System.out.println("=============== PrepareStatement (?) ===================");
            insertMutlipleValues(conn);


            System.out.println("=============== GetObject ===================");
            useGetObject(conn);

            System.out.println("=============== insert Null ===================");
            insertAct(conn,"hello",null);

            System.out.println("=============== CallableStatement ===================");
            simpleCallableStatement(conn);
            System.out.println("-----------------------");
            callableStatement(
                    conn,
                    LocalDate.of(2022,11,5)
                    ,LocalDate.of(2022,11,8)
            );

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void simpleInsertWithExecuteUpdate(Connection conn) throws SQLException {
        String sql = "insert into venues (name, capacity) values ('The House Next Door', 20 )";
        var stmt = conn.prepareStatement(sql);
        int result = stmt.executeUpdate();
        if(result > 0)
            System.out.println("insert in the database");

    }

    private static void simpleUpdateWithExecuteUpdate(Connection conn) throws SQLException {
        String sql = "update venues set Capacity = 30 where Name = 'The House Next Door'";
        var stmt = conn.prepareStatement(sql);
        int result = stmt.executeUpdate();
        if(result > 0)
            System.out.println("update in the database");

    }

    private static void simpleDeleteWithExecute(Connection conn) throws SQLException {

        String sql = "delete from venues where Name = 'The House Next Door'";
        var stmt = conn.prepareStatement(sql);
        boolean result = stmt.execute();

        if(!result) {
            int count = stmt.getUpdateCount();
            if(count  > 0)
                System.out.println("delete in the database: "+count+" elements");
            else
                System.out.println("No update");
        } else {
            System.out.println("Result was not a count"); // ???
        }
    }

    private static void insertMutlipleValues(Connection conn) throws SQLException {
        String sql = "insert into venues (name, capacity) values (?, ?)";
        var stmt = conn.prepareStatement(sql);
        stmt.setString(1, "Empire State Park");
        stmt.setInt(2, 3000);
        int result = stmt.executeUpdate();
        if(result > 0)
            System.out.println("Update the database");
        stmt.setString(1, "London Hyde Park");
        result = stmt.executeUpdate();
        if(result > 0)
            System.out.println("Update the database");
    }

    private static void useGetObject(Connection conn) throws SQLException {
        String sql = "select capacity, name from venues where name like ?";
        var stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%the%");
        ResultSet rs = stmt.executeQuery();
        String name = "";
        int capacity = 0;
        while(rs.next()) {
            Object nameValue = rs.getObject("name");
            Object capacityValue = rs.getObject("capacity");

            if(capacityValue instanceof Integer) capacity = (int)capacityValue;
            if(nameValue instanceof String) name = (String)nameValue;
            System.out.println(name + " has capacity " + capacity);

            System.out.println("---- meme resultats -----");
            System.out.println(nameValue + " has capacity " + capacityValue);
            System.out.println("---------------------------");
        }
    }

    private static void insertAct(Connection conn, String name, String recordLabel) throws SQLException{

        var sql = "insert into Acts (name, recordlabel) values(?, ?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.println("------- update db avec une valeur null --------");

            ps.setString(1, name);
            if(recordLabel != null)
                ps.setString(2, recordLabel);
            else
                ps.setNull(2, Types.CHAR);
            ps.executeUpdate();

            System.out.println("------- meme result--------");

            ps.setString(1,"hello2");
            ps.setString(2,recordLabel);
            // apparament fonctionne meme avec setString et sans devoir verifier

            ps.executeUpdate();
        }
    }

    private static void simpleCallableStatement(Connection conn) throws SQLException{
        try (CallableStatement cs = conn.prepareCall("{call GetActs2}")){ // Accolade pas necessaire ...?
            ResultSet rs = cs.executeQuery();
            while(rs.next()) {
                System.out.print(rs.getString(2)+" : "+rs.getString(3)+"\n");
            }
        }
    }

    private static void callableStatement(Connection conn, LocalDate startDate, LocalDate endDate) throws SQLException{
        try (CallableStatement cs = conn.prepareCall("call GigReport(?,?)")){

//            cs.setDate("startdate", Date.valueOf(startDate));
            // "int" ou "string" peuvent être utiliser ici
            cs.setDate(1, Date.valueOf(startDate));

            cs.setDate("enddate", Date.valueOf(endDate));

            ResultSet rs = cs.executeQuery();

            while(rs.next()) {
                System.out.printf("date: %s, act: %s, ticketssold: %s \n",rs.getDate(1),rs.getString(2),rs.getInt(5));
            }
        }
    }

}
