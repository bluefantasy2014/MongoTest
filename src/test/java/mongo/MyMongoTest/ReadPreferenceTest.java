package mongo.MyMongoTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ReadPreferenceTest extends TestCase {

	public void testReadPreferenceTest()
    {
		System.out.println("test is ReadPreferenceTest "); 
        assertTrue( true );
    }
	
	public static Test suite() {
		return new TestSuite(ReadPreferenceTest.class);
	}
}
