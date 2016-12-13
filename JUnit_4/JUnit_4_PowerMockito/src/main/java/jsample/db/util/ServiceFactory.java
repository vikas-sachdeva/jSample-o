package jsample.db.util;

import java.sql.Connection;

import jsample.dao.DaoService;
import jsample.dao.impl.AccountDaoService;
import jsample.dao.impl.CustomerAccountMappingDaoService;
import jsample.dao.impl.CustomerDaoService;

public class ServiceFactory {

	public static DaoService getAccountDaoService(Connection connection) {
		return new AccountDaoService(connection);
	}

	public static DaoService getCustomerDaoService(Connection connection) {
		return new CustomerDaoService(connection);
	}

	public static DaoService getCustomerAccountMappingDaoService(Connection connection) {
		return new CustomerAccountMappingDaoService(connection);
	}
}