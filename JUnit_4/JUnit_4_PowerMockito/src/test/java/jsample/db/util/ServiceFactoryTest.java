package jsample.db.util;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import jsample.dao.DaoService;
import jsample.dao.impl.AccountDaoService;
import jsample.dao.impl.CustomerAccountMappingDaoService;
import jsample.dao.impl.CustomerDaoService;

public class ServiceFactoryTest {

	private Connection connection;

	/**
	 * Mock Connection class using Mockito.
	 */
	@Before
	public void setUp() {
		connection = Mockito.mock(Connection.class);
	}

	@Test
	public void getAccountDaoServiceTest1() {
		DaoService daoService = ServiceFactory.getAccountDaoService(connection);
		Assert.assertTrue(daoService instanceof AccountDaoService);
	}

	@Test
	public void getAccountDaoServiceTest2() {
		DaoService daoService1 = ServiceFactory.getAccountDaoService(connection);
		DaoService daoService2 = ServiceFactory.getAccountDaoService(connection);
		Assert.assertNotEquals(daoService1, daoService2);
	}

	@Test
	public void getCustomerDaoServiceTest1() {
		DaoService daoService = ServiceFactory.getCustomerDaoService(connection);
		Assert.assertTrue(daoService instanceof CustomerDaoService);
	}

	@Test
	public void getCustomerDaoServiceTest2() {
		DaoService daoService1 = ServiceFactory.getCustomerDaoService(connection);
		DaoService daoService2 = ServiceFactory.getCustomerDaoService(connection);
		Assert.assertNotEquals(daoService1, daoService2);
	}

	@Test
	public void getCustomerAccountMappingDaoServiceTest1() {
		DaoService daoService = ServiceFactory.getCustomerAccountMappingDaoService(connection);
		Assert.assertTrue(daoService instanceof CustomerAccountMappingDaoService);
	}

	@Test
	public void getCustomerAccountMappingDaoServiceTest2() {
		DaoService daoService1 = ServiceFactory.getCustomerAccountMappingDaoService(connection);
		DaoService daoService2 = ServiceFactory.getCustomerAccountMappingDaoService(connection);
		Assert.assertNotEquals(daoService1, daoService2);
	}
}