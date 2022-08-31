package be.digitalcity.tu.pluralSightCourses;

import java.sql.*;

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
            Thread.sleep(1000);
            simpleDeleteWithExecuteUpdate(conn);

            System.out.println("=============== PrepareStatement (?) ===================");
            insertMutlipleValues(conn);

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

    private static void simpleDeleteWithExecuteUpdate(Connection conn) throws SQLException {
//        String sql = "delete from venues where Id = 5";
        String sql = "delete from venues where Name = 'The House Next Door'";
        var stmt = conn.prepareStatement(sql);
//        int result = stmt.executeUpdate();
//        if(result > 0)
//            System.out.println("delete in the database");

        System.out.println("=============== execute ===================");
        boolean result = stmt.execute();
        if(!result) {
            int count = stmt.getUpdateCount();
            if(count  > 0)
                System.out.println("delete in the database: "+count+" elements");
            else
                System.out.println("No update");
        } else {
            System.out.println("Result was not a count");
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


}
