package com.example.demo.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class SqlBase {
    private static final Logger log = LoggerFactory.getLogger(SqlBase.class);
    private   Connection connection;
    private  Statement statement;
    private  PreparedStatement preparedStatement;
    private  ResultSet resultSet;
    private  String jdbc_deiver="com.mysql.jdbc.Driver";
    private  String db_url ="jdbc:mysql://192.168.188.134:3306";
    private   String db_username = "root";
    private  String db_passwd ="root";
//    private static List list;

    private  ResultSet getSqlBase() {
        try {
            Class.forName(jdbc_deiver);
            log.info("连接数据库中。。。。。");
              connection = DriverManager.getConnection(db_url, db_username, db_passwd);
            log.info("实例化Statement对象中。。。。。");
               statement = connection.createStatement();
            String sql = "SELECT * FROM test.user_info_test ";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                System.out.println(id + "ssss" + name + "s     s " + password);
            }
            resultSet.close();
            statement.close();
            connection.close();
            log.info("资源已经释放");
        }catch (SQLException S){
            log.error("处理JDBC错误");
        S.printStackTrace();
        } catch (Exception  e) {
            log.error("处理Class.forName连接失败");
            e.printStackTrace();
        }finally {
            try {
                if (statement!=null) {
                    statement.close();
                }
            }catch (SQLException E){
                log.info("statement资源已关闭");
            }
            try {
                if (connection!=null){
                    connection.close();
                }
            }catch (SQLException S){
                log.info("connection资源已关闭");
            }
        }
        return  resultSet;
    }


    public  List getList(String sql) {
        List list=new ArrayList();
        try {
            Class.forName(jdbc_deiver);
            log.info("执行getList方法中。。。连接数据库成功");
            connection = DriverManager.getConnection(db_url, db_username, db_passwd);
            log.info("执行getList方法中。。。实例化Statement对象成功");

            preparedStatement=connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            List list1=new ArrayList();
            ResultSetMetaData resultSetMetaData=preparedStatement.getMetaData();
            //获取列名
                for (int i=0;i<resultSetMetaData.getColumnCount();i++){
                list1.add(resultSetMetaData.getColumnName(i+1));
            }
//            System.out.println(list1);
            while (resultSet.next()) {
                JSONObject jsonObject=new JSONObject();
                for (int i =0;i<list1.size();i++){
                    jsonObject.put(list1.get(i).toString(),resultSet.getString(list1.get(i).toString()));
                }
//                System.out.println(jsonObject);
                list.add(jsonObject);
            }
//            System.out.println(list);
            resultSet.close();

            preparedStatement.close();
            connection.close();
            log.info("资源已经释放");
        }catch (SQLException S){
            log.error("处理JDBC错误");
            S.printStackTrace();
        } catch (Exception  e) {
            log.error("处理Class.forName连接失败");
            e.printStackTrace();
        }finally {
            try {
                if (preparedStatement!=null) {
                    preparedStatement.close();
                }
            }catch (SQLException E){
                log.info("statement资源已关闭");
            }
            try {
                if (connection!=null){
                    connection.close();
                }
            }catch (SQLException S){
                log.info("connection资源已关闭");
            }
        }
        return list;
    }

    public  Map getSqlLimitOne(String sql){
        Map map =new HashMap();
        try {
            Class.forName(jdbc_deiver);
            log.info("执行getSqlLimitOne方法中。。。连接数据库成功");
            connection = DriverManager.getConnection(db_url, db_username, db_passwd);
            log.info("执行getSqlLimitOne方法中。。。实例化Statement对象成功");
            preparedStatement=connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            List list1=new ArrayList();
            ResultSetMetaData resultSetMetaData=preparedStatement.getMetaData();
            //获取列名
            for (int i=0;i<resultSetMetaData.getColumnCount();i++){
                list1.add(resultSetMetaData.getColumnName(i+1));
            }
            while (resultSet.next()) {

                for (int i =0;i<list1.size();i++){
                    map.put(list1.get(i).toString(),resultSet.getString(list1.get(i).toString()));
                }
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            log.info("资源已经释放");
        }catch (SQLException S){
            log.error("处理JDBC错误");
            S.printStackTrace();
        } catch (Exception  e) {
            log.error("处理Class.forName连接失败");
            e.printStackTrace();
        }finally {
            try {
                if (preparedStatement!=null) {
                    preparedStatement.close();
                }
            }catch (SQLException E){
                log.info("statement资源已关闭");
            }
            try {
                if (connection!=null){
                    connection.close();
                }
            }catch (SQLException S){
                log.info("connection资源已关闭");
            }
        }
        return  map;
    }
    public  String getInsertData(String sql){
        try {
            Class.forName(jdbc_deiver);
            log.info("执行getInsertData方法中。。。。连接数据库成功");
            connection = DriverManager.getConnection(db_url, db_username, db_passwd);
            log.info("执行getInsertData方法中。。。。实例化Statement对象成功。。。。。");
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            log.info("INSERT 语句已执行完毕");
            preparedStatement.close();
            connection.close();
            log.info("释放资源完成");
        }catch (ClassNotFoundException E){
            log.error("ClassNotFoundException 异常");
            E.printStackTrace();
        }catch (SQLException ES){
            log.error("SQLException 异常");
            ES.printStackTrace();
        }finally {
            try {
                if (preparedStatement!=null) {
                    preparedStatement.close();
                }
            }catch (SQLException E){
                log.info("statement资源已关闭");
            }
            try {
                if (connection!=null){
                    connection.close();
                }
            }catch (SQLException S){
                log.info("connection资源已关闭");
            }}
        return null;
    }
    public static void main(String[] args) throws SQLException {
        SqlBase  sqlBase=new SqlBase();
        String sql = "SELECT * FROM test.user_info_test ";
        System.out.println(sqlBase.getList(sql));
        System.out.println(sqlBase.getList(sql).get(1).getClass().getName());
        String sql1 = "SELECT * FROM test.user_info_test limit 1";
//        String sql2 ="INSERT INTO test.user_info_test ( user_name, PASSWORD, enrolment_phone, bind_phone, create_time, update_time)VALUES( ?, ?,?, ?, ?, ?);";
        String sql2 ="INSERT INTO test.user_info_test ( user_name, PASSWORD, enrolment_phone, bind_phone, create_time, update_time)VALUES( '1233', '123456', 'enrolment_phone', 'bind_phone', NOW(), NOW());";
            System.out.println(sqlBase.getSqlLimitOne(sql1));
        System.out.println(sqlBase.getInsertData(sql2));
    }
}
