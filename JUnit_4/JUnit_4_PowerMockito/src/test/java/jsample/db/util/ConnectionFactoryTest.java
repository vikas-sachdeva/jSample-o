package jsample.db.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

/**
 * This test class is neither using Mockito nor PowerMockito. It's a simple
 * JUnit test class.
 * 
 */
public class ConnectionFactoryTest {

	@Test
	public void testGetConnection1() throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		Assert.assertNotNull(connection);
	}

	@Test
	public void testGetConnection2() throws ClassNotFoundException, SQLException {
		Connection connection1 = ConnectionFactory.getConnection();
		Connection connection2 = ConnectionFactory.getConnection();
		Assert.assertNotEquals(connection1, connection2);
	}
}