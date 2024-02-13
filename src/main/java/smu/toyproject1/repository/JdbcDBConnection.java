package smu.toyproject1.repository;

import org.springframework.stereotype.Component;
import smu.toyproject1.entity.CreditLoanProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDBConnection {
    public static Connection getConnection() {
        // 데이터베이스 연결 정보
        String url = "jdbc:mysql://[나의엔드포인트]:3306/[데이터베이스명]"; // 데이터베이스 URL
        String username = "[사용자명]"; // 사용자명
        String password = "[비밀번호]"; // 비밀번호

        Connection connection = null;

        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            connection = DriverManager.getConnection(url, username, password);

            // 연결 성공 시 추가 작업 수행

            System.out.println("데이터베이스 연결 성공!");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 오류입니다.");
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("데이터베이스 연결 해제 오류입니다.");
                e.printStackTrace();
            }
        }
    }

    public static List<CreditLoanProduct> retrieveDataFromTable(String tableName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CreditLoanProduct> creditLoans = new ArrayList<>();

        try {
            connection = getConnection();
            if (connection != null) {
                String sql = "SELECT * FROM " + tableName;
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String company = resultSet.getString("금융회사 명");
                    String productName = resultSet.getString("금융 상품명");
                    String method = resultSet.getString("가입 방법");
                    String loanType = resultSet.getString("대출종류명");
                    String cbCompany = resultSet.getString("CB 회사명");
                    String rateType = resultSet.getString("금리구분");
                    int averageRate = resultSet.getInt("평균 금리");

                    CreditLoanProduct creditLoan = new CreditLoanProduct(company, productName, method, loanType, cbCompany, rateType, averageRate);
                    creditLoans.add(creditLoan);
                }
            }
        } catch (SQLException e) {
            System.out.println("데이터 조회 오류입니다.");
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            closeConnection(connection);
        }
        return creditLoans;
    }
}
