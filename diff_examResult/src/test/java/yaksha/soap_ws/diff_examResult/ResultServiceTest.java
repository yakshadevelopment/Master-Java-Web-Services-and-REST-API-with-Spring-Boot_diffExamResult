package yaksha.soap_ws.diff_examResult;

import static org.junit.Assert.*;
import org.junit.Test;
import yaksha.soap_ws.diff_examResult.bean.StudentResult;
import yaksha.soap_ws.diff_examResult.service.ResultService;
import static yaksha.soap_ws.diff_examResult.TestUtils.*;

public class ResultServiceTest {

	@Test
	public void testCalculateResult() throws Exception
	{
		StudentResult student=new StudentResult(30,85,75,95,90,80);
		StudentResult result=new ResultService().calculateResult(student);
		String grade=result.getGrade();
		yakshaAssert(currentTest(),(grade.equals("Excellent")?"true":"false"),businessTestFile);
		
	}
	
	@Test
    public void testExceptionConditon() throws Exception{
	 yakshaAssert(currentTest(),true,boundaryTestFile);
      }

	@Test
	public void testBoundaryCondition() throws Exception {
	  yakshaAssert(currentTest(),true,exceptionTestFile);
   }
}
