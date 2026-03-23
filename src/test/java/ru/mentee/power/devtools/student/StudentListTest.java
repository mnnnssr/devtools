package ru.mentee.power.devtools.student;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StudentListTest {

  @Test
  void shouldAddStudentWhenStudentIsNotNull() {
    List<Student> list = new ArrayList<>();
    StudentList studentList = new StudentList(list);

    Student student = new Student("Laura", "Saratov");

    studentList.addStudent(student);

    assertThat(studentList.getStudentList()).hasSize(1);
    assertThat(studentList.getStudentList()).contains(student);
  }

  @Test
  void shouldNotAddStudentWhenStudentIsNull() {
    List<Student> list = new ArrayList<>();
    StudentList studentList = new StudentList(list);

    studentList.addStudent(null);

    assertThat(studentList.getStudentList()).isEmpty();
  }

  @Test
  void shouldReturnCopyOfList() {
    List<Student> list = new ArrayList<>();
    StudentList studentList = new StudentList(list);

    studentList.addStudent(new Student("Laura", "Saratov"));

    List<Student> result = studentList.getStudentList();

    result.clear();

    // оригинальный список не должен измениться
    assertThat(studentList.getStudentList()).hasSize(1);
  }
}