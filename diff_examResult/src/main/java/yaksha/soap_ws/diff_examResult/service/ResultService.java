package yaksha.soap_ws.diff_examResult.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import yaksha.soap_ws.diff_examResult.bean.StudentResult;
@Component
public class ResultService {
	public enum TaskStatus{SUCCESS,FAILURE};
	private static Map<Integer,StudentResult> studMap=new HashMap<Integer,StudentResult>();
	static
	{
		studMap.put(10,new StudentResult(10,"John"));
		studMap.put(11,new StudentResult(11,"Mary"));
		studMap.put(12,new StudentResult(12,"Anna"));
		studMap.put(13,new StudentResult(13,"Tom"));
		studMap.put(14,new StudentResult(14,"Harry"));
		studMap.put(15,new StudentResult(15,"Sarah"));
		studMap.put(16,new StudentResult(16,"Luke"));
		studMap.put(17,new StudentResult(17,"Gregg"));
		studMap.put(18,new StudentResult(18,"Cathy"));
		studMap.put(19,new StudentResult(19,"Daisy"));
		studMap.put(20,new StudentResult(20,"Mike"));
	}
	
	public StudentResult findByRoll(int id)
	{
		return studMap.get(id);
	}
	public StudentResult calculateResult(StudentResult student)
	{
		int total=student.getEng()+student.getLang()+student.getMath()+student.getScience()+student.getSocialScience();
		double avg=((double)total/(double)500)*(double)100;
		student.setTotal(total);
		String grade="";
		if(avg>=80)
		  grade="Excellent";
		else if(avg>=60)
			grade="Good";
		else if(avg>=40)
			grade="Pass";
		else 
			grade="Fail";
		student.setGrade(grade);
		return student;
	}
	public TaskStatus deleteStudent(int roll)
	{
		if(studMap.containsKey(roll))
		{
			studMap.remove(roll);
			return TaskStatus.SUCCESS;
		}
		else
			return TaskStatus.FAILURE;
	}
	public TaskStatus addStudent(StudentResult student)
	{
		if(studMap.containsKey(student.getRoll()))
		{
			return TaskStatus.FAILURE;
		}
		else
		{
		  studMap.put(student.getRoll(),student);	
				return TaskStatus.SUCCESS;
		}
	}
}
