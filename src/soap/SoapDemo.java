package soap;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCaseRunner;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.support.SoapUIException;
import org.apache.xmlbeans.XmlException;
import org.junit.Assert;

import java.io.IOException;

public class SoapDemo {

    public static void main(String[] args) throws XmlException, IOException, SoapUIException {

        WsdlProject project = new WsdlProject("file:///C:/Users/amolu/Documents/Employee-feb-23-soapui-project.xml");

        WsdlTestSuite testSuite = project.getTestSuiteByName("TestSuite");

      //  WsdlTestCase testcase = testSuite.getTestCaseByName("AddEmployeeGroovyTest");
        WsdlTestCase testcase = testSuite.getTestCaseByName("E2E");

        TestRunner runner = testcase.run(new PropertiesMap(), false);

        Assert.assertEquals( "one of the step is failed", TestRunner.Status.FINISHED , runner.getStatus());
    }
}
