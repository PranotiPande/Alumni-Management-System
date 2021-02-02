/**
 * 
 */
package com.app.custom_excs;

/**
 * @author user
 *
 */
public class StudentNotFoundException extends RuntimeException {
public StudentNotFoundException(String mesg) {
	super(mesg);
}
}
