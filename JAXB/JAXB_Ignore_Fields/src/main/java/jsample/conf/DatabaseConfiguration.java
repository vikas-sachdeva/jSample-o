package jsample.conf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "databaseConfiguration")
public class DatabaseConfiguration {

	/**
	 * By Default, JAXB only unmarshal XML elements which are present in POJO
	 * Object. So, no specific action is required for ignoring fields.
	 */

	private String databaseServerAddress;

	/**
	 * For ignoring fields which are present in POJO object, use @XmlTransient
	 * annotation. It will impact marshalling and unmarshalling process both.
	 */
	@XmlTransient
	private String databasePassword;

	private DatabaseConfiguration() {

	}

	public String getDatabaseServerAddress() {
		return databaseServerAddress;
	}

	public String getDatabasePassword() {
		return databasePassword;
	}

	@Override
	public String toString() {
		return "DatabaseConfiguration [databaseServerAddress=" + databaseServerAddress + ", databasePassword="
				+ databasePassword + "]";
	}

}
