package com.powernode;

import com.powernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class myTest {
    //测试mybatis执行sql语句
    @Test
    public void testSelectStudentbyID() throws IOException {
        //调用mybatis某个对象的方法，执行mapper文件中的sql语句
        //mybatis核心类，sqlsessionFactory
        //1\定义mybatis主配置文件的位置，读取
        String config = "mybatis.xml";
        //2、读取主配置文件，使用Resource类操作
        InputStream resourceAsStream = Resources.getResourceAsStream(config);

        //3、创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);


        //4、获取SqlSession对象(true 是自动提交事务)
        SqlSession session = sqlSessionFactory.openSession(true);

        //5、指定要执行sql的id
        //sqlid = namespace+'.'+select|update|insert标签的id的属性值
        String sqlid = "com.powernode.dao.StudentDao"+"."+"selectStudentByID";

        //6、通过SqlSession的方法，执行SQL
        //查询单条
        Student student = session.selectOne(sqlid,2);
        //查询所有学生fsd
        //List<Student> student = session.selectList(sqlid);

        System.out.println("使用mybatis查询一个学生："+student);
        /*for (int i = 0; i < student.size(); i++) {
            System.out.println(student.get(i));
        }*/


        session.close();
    }

    //insertStudent
    @Test
    public void testInsertStudent() throws IOException {
        //调用mybatis某个对象的方法，执行mapper文件中的sql语句
        //mybatis核心类，sqlsessionFactory
        //1\定义mybatis主配置文件的位置，读取
        String config = "mybatis.xml";
        //2、读取主配置文件，使用Resource类操作
        InputStream resourceAsStream = Resources.getResourceAsStream(config);

        //3、创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //4、获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        //5、指定要执行sql的id
        //sqlid = namespace+'.'+select|update|insert标签的id的属性值
        String sqlid = "com.powernode.dao.StudentDao"+"."+"insertStudent";

        //6、通过SqlSession的方法，执行SQL
        //查询单条
        Student student = new Student();
        student.setId(6);
        student.setName("DWX");
        student.setScore((float) 77.5);
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        student.setBirth(null);
        student.setAge(16);
        int rows =session.insert(sqlid,student);

        //查询所有学生fsd
        //List<Student> student = session.selectList(sqlid);

        System.out.println("添加了一个学生 rows = ："+rows);
        /*for (int i = 0; i < student.size(); i++) {
            System.out.println(student.get(i));
        }*/
        //数据库并不会提交成功，update ,insert ,delete需要更改事务提交
        //session.commit();

        session.close();
    }

    @Test
    public void testAutoInsertStudent() throws IOException {
        //调用mybatis某个对象的方法，执行mapper文件中的sql语句
        //mybatis核心类，sqlsessionFactory
        //1\定义mybatis主配置文件的位置，读取
        String config = "mybatis.xml";
        //2、读取主配置文件，使用Resource类操作
        InputStream resourceAsStream = Resources.getResourceAsStream(config);

        //3、创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //4、获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession(true);

        //5、指定要执行sql的id
        //sqlid = namespace+'.'+select|update|insert标签的id的属性值
        String sqlid = "com.powernode.dao.StudentDao"+"."+"insertStudent";

        //6、通过SqlSession的方法，执行SQL
        //查询单条
        Student student = new Student();
        student.setId(7);
        student.setName("DWX");
        student.setScore((float) 77.5);
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        student.setBirth(null);
        student.setAge(16);
        int rows =session.insert(sqlid,student);

        //查询所有学生fsd
        //List<Student> student = session.selectList(sqlid);

        System.out.println("添加了一个学生 rows = ："+rows);
        /*for (int i = 0; i < student.size(); i++) {
            System.out.println(student.get(i));
        }*/
        //数据库并不会提交成功，update ,insert ,delete需要更改事务提交
        //session.commit();

        session.close();
    }
}
