package com.sanpang.structure.bridge;

import java.sql.SQLException;

public class APP {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/sample_db?user=root&password=your_password";
//        Connection con = DriverManager.getConnection(url);

        ApiStatInfo apiStatInfo = new ApiStatInfo();
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);

    }
}
