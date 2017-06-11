package jsample.visitor;

import jsample.visitor.impl.Car;
import jsample.visitor.impl.Train;

/**
 * 
 * Visitor patter is one of the behavioral pattern.
 * 
 * Visitor pattern is used when some operation needs to be performed on similar
 * kind of objects. With the help of visitor pattern, operational logic can be
 * move from the objects to another class.
 * 
 * The benefit of this pattern is that if the logic of operation changes, then
 * change is only required in visitor implementation rather than doing it in all
 * the item classes.
 * 
 * Another benefit is that adding a new item or removing existing item to the
 * system is easy, it will require change only in visitor interface and in
 * visitor implementation. Other item classes will not be affected.
 * 
 * Visitor pattern should be used when -
 * 
 * All the items classes are defined and known.
 * 
 * Operations on items classes are not well-defined or not known in advance.
 * 
 * Operation on each item requires different logic or algorithm.
 * 
 * Operation needs to be performed on specific properties of group of objects
 * having same parent and run-time type testing (instanceof check) needs to be
 * avoided. This is usually the case of hierarchy of disparate objects having
 * different properties.
 * 
 */

public interface Visitor {

	public int visit(Car car);

	public int visit(Train train);

}
