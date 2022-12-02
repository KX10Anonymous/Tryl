/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.database;

import java.sql.Statement;
import main.core.utility.UserUtility;
import main.user.User;

/**
 *
 * @author J-ANONIMO
 */
public class UserController {

    private String email;
    private Integer id;
    private String phone;
    private User user;
    private Statement statement;

    /**
     *
     * @param id
     * @param statement
     */
    public UserController(Integer id, Statement statement) {
        this.id = id;
        this.statement = statement;
    }

    /**
     *
     * @param email
     * @param statement
     */
    public UserController(String email, Statement statement) {
        this.email = email;
    }

    /**
     *
     * @param statement
     * @param phone
     */
    public UserController(Statement statement, String phone) {
        this.statement = statement;
        this.phone = phone;
    }

    /**
     * Returns user read based on id
     *
     * @return
     */
    public User getUser() {
        if (user == null) {
            if (id != null) {
                //Query selects based on the ID
                String query = "select * where ID ='" + id + "'";
                
                //Validate email address length
            } else if (UserUtility.isEmailValid(email) && email != null) {
                //Select query based on user email since it is unique
                String query = "select * where email='" + email + "'";
                
                //Validate phone
            }else if(UserUtility.isPhoneValid(phone) && phone != null){
                //Select query based on user phone since it's untique
                String query = "select * where phone='" + phone + "'";
            }
            return user;
        } else {
            return user;
        }

    }
}
