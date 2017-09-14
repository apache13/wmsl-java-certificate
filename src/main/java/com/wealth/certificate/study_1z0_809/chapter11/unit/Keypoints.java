package com.wealth.certificate.study_1z0_809.chapter11.unit;

/**
 * 
 * Key Points
 * 
 * - A method reference is the shorthand syntax to a lambda expression that executes just one method.
 * - The syntax of a lambda expression is:
 * 	> ObjectOrClassName :: methodName
 * - In a method reference, you place the object (or class) that contains the method before the :: operator and the name of the method after it without arguments.
 * - There are four types of method references:
 * 	> A method reference to a static method
 * 	> A method reference to an instance method of an object of a particular type
 * 	> A method reference to an instance method of an existing object
 * 	> A method reference to a constructor
 * - For static methods, we have a lambda expression like the following:
 * 	> (args) -> Class.staticMethod(args)
 * - That can be turned into the following method reference:
 * 	> Class::staticMethod
 * - For instance methods of objects of a particular type, we have a lambda expression like the following:
 * 	> (obj, args) -> obj.instanceMethod(args)
 * - Where an instance of an object is passed as an argument and one of its methods is executed with some optional(s) parameter(s).
 * - And that can be turned into the following method reference:
 * 	> ObjectType::instanceMethod
 * - For instance methods of existing objects, we have a lambda expression like the following:
 * 	> (args) -> obj.instanceMethod(args)
 * - That can be turned into the following method reference:
 * 	> obj::instanceMethod
 * - For creating objects (calling a constructor), we have a lambda expression like the following:
 * 	> (args) -> new ClassName(args)
 * - That can be turned into the following method reference:
 * 	> ClassName::new
 *
 */

/** [Conclusion] -------------------------------------------------------------------------------------- **/
