package com.ekart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ekart.model.Login;
import com.ekart.model.User;

public class UserDaoImpl implements UserDao{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	public void register(User user) 
	{
	    String sql = "insert into users_table (user_name,password,email_id,contact) values(?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { user.getUserName(), user.getPassword(), user.getMailID(),
	    user.getContactNumber() });
	}
	public User validateUser(Login login) 
	{
		System.out.println("I am inside validate User of daoImpl");
		List<User> users = new ArrayList<User>();
	    String sqlEmail = "select * from users_table where email_id='" + login.getUserName() + "' and password='" + login.getPassword() + "'";
	    List<User> usersEmail = jdbcTemplate.query(sqlEmail, new UserMapper());
	    if(usersEmail.size()==0)
	    {
	    	String sqlContactNum = "select * from users_table where contact='" + login.getUserName() + "' and password='" + login.getPassword() + "'";
		    List<User> usersContactNum = jdbcTemplate.query(sqlContactNum, new UserMapper());	
		    users = usersContactNum;
		    if(usersContactNum.size()!=0)
		    {
		    	System.out.println("saket1  "+usersEmail.get(1));
		    }
	    }
	    else
	    {
	    	users = usersEmail;
	    	System.out.println("saket2  "+usersEmail.get(0).getContactNumber());
	    }
	    System.out.println("users  = "+users );
	    
	    System.out.println("usersEmail  = "+usersEmail );
	    
	    return users.size() > 0 ? users.get(0) : null;
	}
}



	  class UserMapper implements RowMapper<User> {
	  public User mapRow(ResultSet rs, int arg1) throws SQLException {
	    User user = new User();
	    user.setUserId(rs.getInt("user_id"));
	    user.setUserName(rs.getString("user_name"));
	    user.setPassword(rs.getString("password"));
	    user.setMailID(rs.getString("email_id"));
	    user.setContactNumber(rs.getString("contact"));
	    return user;
	  }
	}