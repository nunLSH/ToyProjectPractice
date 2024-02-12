package smu.toyproject1.DBConnection;

import org.junit.jupiter.api.Test;
import smu.toyproject1.repository.JdbcDBConnection;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;

public class JdbcDBConnectionTest {
    @Test
    public void testRetrieveDataFromTable() {
        try {
            JdbcDBConnection.retrieveDataFromTable("신용대출");
        } catch (Exception e) {
            fail("Exception should not have been thrown.");
        }
    }
}
