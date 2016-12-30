package jsample;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import jsample.xml.Parser;

public class App {

	public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException, XPathExpressionException {
			Parser parser = new Parser();		
			parser.init();
			parser.printFirstnameOfAllEmployees();
			parser.printEmployeeDetailsWithId(2222);
			parser.printEmailAddressOfEmployeeWithId(3333);
			parser.printFirstnameOfAllAdminEmployees();
			parser.printFirstnameOfAllEmployeesOlderThan(40);
			parser.printFirstnameOfFirstTwoEmployees();
			parser.printFirstnameOfLastEmployee();

	}
}