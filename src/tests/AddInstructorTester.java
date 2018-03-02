package tests;

import controller.ClassroomHelper;
import controller.InstructorHelper;
import model.Instructor;

public class AddInstructorTester {

	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		InstructorHelper	classhelp	=	new	InstructorHelper();
		Instructor	Alex	=	new	Instructor( "Alex", "Eaton", "alex_instructor@gmail.com");
		classhelp.insertInstructor(Alex);
		*/
		
		public	static	void	main(String[]	args)	{
			//	TODO	Auto-generated	method	stub
			InstructorHelper	classhelp	=	new	InstructorHelper();
			Instructor	CompSciLab	=	classhelp.searchForInstructorById(1);
			classhelp.deleteInstructor(CompSciLab);
	}

}
