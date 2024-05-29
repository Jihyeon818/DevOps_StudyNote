package kr.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.bit.entity.Student;

@Mapper
public interface StudentMapper {

	public List<Student> getAllStudents(); 
	
	public List<Student> search(String name);
	
	public Student studentFind(int num);
	
	public void studentInsert(Student student);
	
	public void studentUpdate(Student StudentVo);
	
	public void studentDelete(int num);
}
