package yaksha.soap_ws.diff_examResult.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import edu.yaksha.examapp.AddStudentRequest;
import edu.yaksha.examapp.AddStudentResponse;
import edu.yaksha.examapp.DeleteStudentRequest;
import edu.yaksha.examapp.DeleteStudentResponse;
import edu.yaksha.examapp.Result;
import edu.yaksha.examapp.ShowResultRequest;
import edu.yaksha.examapp.ShowResultResponse;
import edu.yaksha.examapp.Status;
import yaksha.soap_ws.diff_examResult.bean.StudentResult;
import yaksha.soap_ws.diff_examResult.service.ResultService;
import yaksha.soap_ws.diff_examResult.service.ResultService.TaskStatus;
import yaksha.soap_ws.diff_examResult.service.StudentNotFoundException;


@Endpoint
public class StudentResultEndpoint {
    @Autowired
    ResultService service;
	@PayloadRoot(namespace = "http://yaksha.edu/examapp", localPart = "ShowResultRequest")
	@ResponsePayload
	public ShowResultResponse processResultRequest(@RequestPayload ShowResultRequest request)
	{
		StudentResult student=service.findByRoll(request.getRoll());
		if(student==null)
			throw new StudentNotFoundException("Student not exists");
		
		 student.setEng(request.getEng());
		 student.setLang(request.getLang());
		 student.setMath(request.getMath());
		 student.setScience(request.getScience());
		 student.setSocialScience(request.getSocialScience());
		 StudentResult stud=service.calculateResult(student);
		 Result result=new Result();
		 result.setRoll(student.getRoll());
		 result.setName(student.getName());
		 result.setEng(student.getEng());
		 result.setLang(student.getLang());
		 result.setMath(student.getMath());
		 result.setScience(student.getScience());
		 result.setSocialScience(student.getSocialScience());
		 result.setTotal(student.getTotal());
		 result.setGrade(student.getGrade());
		  ShowResultResponse response=new ShowResultResponse();		
			response.setStudentResult(result);
		return response;
	}
	@PayloadRoot(namespace = "http://yaksha.edu/examapp", localPart = "DeleteStudentRequest")
	@ResponsePayload
	public DeleteStudentResponse processDeleteStudentRequest(@RequestPayload DeleteStudentRequest request)
	{
		TaskStatus status=service.deleteStudent(request.getRoll());
		DeleteStudentResponse response=new DeleteStudentResponse();
		
		response.setStatus(mapStatus(status));
		return response;
	}
	@PayloadRoot(namespace = "http://yaksha.edu/examapp", localPart = "AddStudentRequest")
	@ResponsePayload
	public AddStudentResponse processAddStudentRequest(@RequestPayload AddStudentRequest request)
	{
		StudentResult student=new StudentResult(request.getRoll(),request.getName());
		TaskStatus status=service.addStudent(student);
		AddStudentResponse response=new AddStudentResponse();
		
		response.setStatus(mapStatus(status));
		return response;
	}
	
	
	private Status mapStatus(TaskStatus status)
	{
		Status stat=null;
		if(status==TaskStatus.SUCCESS)
			stat=Status.SUCCESS;
		else if(status==TaskStatus.FAILURE)
			stat=Status.FAILURE;
		return stat;
	}
	
}
