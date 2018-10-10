package com.nissan;

import junit.framework.TestCase;

public class AddNumbersTest extends TestCase {
    @Test
    public void testAddNumbers() {
	AddNumbersServlet addNumbersServlet = new AddNumbersServlet();
	double result = addNumbersServlet.addNumbers(5, 10);
	assertEquals(15, result);
    }
}
