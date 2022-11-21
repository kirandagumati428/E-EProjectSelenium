package Academy;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resouces.Base;

public class listeners implements ITestListener{
Base b=new Base();
    public void onStart(ITestContext arg) {
        
        }
            //This  belongs to ITestListners will execute After starting of test set/batch
            public void onFinish(ITestContext arg) {
        }
            //This  belongs to ITestListners will execute Before the main  test start  i.e. @Test
            public void onTestStart(ITestResult argo) {
        }
            //This  belongs to ITestListners will execute when a test is skipped 
            public void onTestSkipped(ITestResult arg) {
        }
            //This  belongs to ITestListners will execute when a test is success 
        public void onTestSuccess(ITestResult arg) {
        }
        //This  belongs to ITestListners will execute when a test is failure
        public void onTestFailure(ITestResult result) {
            try {
                b.getScreenshot(result.getName());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //This  belongs to ITestListners will execute when a test is skipped 
        public void onTestFailedButWithinSuccessPercentage(ITestResult arg) {
        }
    
}
