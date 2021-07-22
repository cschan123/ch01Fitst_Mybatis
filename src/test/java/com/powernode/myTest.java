package com.powernode;

import com.powernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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

        //4、获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        //5、指定要执行sql的id
        //sqlid = namespace+'.'+select|update|insert标签的id的属性值
        String sqlid = "com.powernode.dao.StudentDao"+"."+"selectStudentList";

        //6、通过SqlSession的方法，执行SQL
        //查询单条
        //Student student = session.selectOne(sqlid,2);
        //查询所有学生fsd
        List<Student> student = session.selectList(sqlid);

        //System.out.println("使用mybatis查询一个学生："+student);
        for (int i = 0; i < student.size(); i++) {
            System.out.println(student.get(i));
        }


        session.close();
    }

}
