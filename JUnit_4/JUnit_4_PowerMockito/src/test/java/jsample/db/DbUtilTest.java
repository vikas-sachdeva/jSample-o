package jsample.db;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.h2.tools.DeleteDbFiles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import jsample.dao.impl.AccountDaoService;
import jsample.dao.impl.CustomerAccountMappingDaoService;
import jsample.dao.impl.CustomerDaoService;
import jsample.db.util.ConnectionFactory;
import jsample.db.util.ServiceFactory;
import jsample.model.Account;
import jsample.model.Customer;
import jsample.model.CustomerAccountMapping;

/**
 * This class is using Mockito as well as PowerMockito.
 *
 */
/**
 * Following line is required for running test case which uses PowerMockito -
 * 
 */
@RunWith(PowerMockRunner.class)
/**
 * Following line is used in combination with above line. Through this line,
 * classes which will be mocked by PowerMockito are specified.
 *
 */
@PrepareForTest({ ServiceFactory.class, ConnectionFactory.class, DeleteDbFiles.class })
public class DbUtilTest {

	private CustomerDaoService customerDaoService;

	private AccountDaoService accountDaoService;

	private CustomerAccountMappingDaoService customerAccountMappingDaoService;

	@Before
	public void setUp() throws Exception {
		/**
		 * Following line is required for mocking
		 * ConnectionFactory.getConnection() static method.
		 */
		PowerMockito.mockStatic(ConnectionFactory.class);
		/**
		 * Mock Connection object using Mockito.
		 */
		Connection connection = Mockito.mock(Connection.class);
		/**
		 * Mock ConnectionFactory.getConnection() static method.
		 */
		PowerMockito.when(ConnectionFactory.getConnection()).thenReturn(connection);
		/**
		 * Mock CustomerDaoService class object.
		 */
		customerDaoService = Mockito.mock(CustomerDaoService.class);
		Mockito.when(customerDaoService.getData()).thenReturn(getCustomerTableTestData());

		accountDaoService = Mockito.mock(AccountDaoService.class);
		Mockito.when(accountDaoService.getData()).thenReturn(getAccountTableTestData());

		customerAccountMappingDaoService = Mockito.mock(CustomerAccountMappingDaoService.class);
		Mockito.when(customerAccountMappingDaoService.getData()).thenReturn(getCustomerAccountMappingTableTestData());
		/**
		 * Following line is required for mocking various static methods of
		 * ServiceFactory class.
		 */
		PowerMockito.mockStatic(ServiceFactory.class);

		PowerMockito.when(ServiceFactory.getCustomerDaoService(connection)).thenReturn(customerDaoService);
		PowerMockito.when(ServiceFactory.getAccountDaoService(connection)).thenReturn(accountDaoService);
		PowerMockito.when(ServiceFactory.getCustomerAccountMappingDaoService(connection))
				.thenReturn(customerAccountMappingDaoService);
		/**
		 * Mock DeleteDbFiles class whose method is called in createTables
		 * method of DbUtil class.
		 */
		PowerMockito.mockStatic(DeleteDbFiles.class);

	}

	@Test
	public void printTablesDataTest1() throws Exception {
		DbUtil.printTablesData();
	}

	@Test
	public void printTablesDataTest2() throws Exception {
		Mockito.when(customerDaoService.getData()).thenReturn(new ArrayList<Object>());
		Mockito.when(accountDaoService.getData()).thenReturn(new ArrayList<Object>());
		Mockito.when(customerAccountMappingDaoService.getData()).thenReturn(new ArrayList<Object>());
		DbUtil.printTablesData();
	}

	@Test
	public void InsertTablesDataTest() throws Exception {
		DbUtil.InsertTablesData(getCustomer(), getAccount());
	}

	@Test
	public void createTablesTest() throws Exception {
		DbUtil.createTables();
	}

	private List<Object> getCustomerTableTestData() {
		List<Object> customerList = new ArrayList<>();
		customerList.add(getCustomer());
		return customerList;
	}

	private List<Object> getAccountTableTestData() {
		List<Object> accountList = new ArrayList<>();
		accountList.add(getAccount());
		return accountList;
	}

	private List<Object> getCustomerAccountMappingTableTestData() {
		List<Object> customerAccountMappingList = new ArrayList<>();
		customerAccountMappingList.add(getCustomerAccountMapping());
		return customerAccountMappingList;
	}

	private Customer getCustomer() {
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.set(1882, 11, 2);
		Customer customer = new Customer("23FEFE829MF", "Bob", "Male", dateOfBirth.getTime(), "Student", "New York",
				"9174944476", "445 Fifth Avenue, Suite 32D, New York, N.Y. 10016");
		return customer;
	}

	private Account getAccount() {
		Account account = new Account("000011111111", "Recurring Deposit", 1210101L);
		return account;
	}

	private CustomerAccountMapping getCustomerAccountMapping() {
		CustomerAccountMapping customerAccountMapping = new CustomerAccountMapping(101, "23FEFE829MF", "000011111111");
		return customerAccountMapping;
	}
}