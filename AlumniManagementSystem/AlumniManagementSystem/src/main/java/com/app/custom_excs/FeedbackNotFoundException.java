/**
 * 
 */
package com.app.custom_excs;

/**
 * @author user
 *
 */
public class FeedbackNotFoundException extends RuntimeException {
public FeedbackNotFoundException(String mesg) {
	super(mesg);
}
}
