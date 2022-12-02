/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.core.controllers;

import main.entities.Users;
import main.user.User;

/**
 *
 * @author J-ANONIMO
 */
public class UsersController {

    private Users users;
    private User user;

    public UsersController() {

    }

    /**
     *Instantiate user object from Users entity object
     * @param users
     */
    public UsersController(Users users) {
        user = new User(users.getId(), users.getSurname(), users.getFirstName(), users.getPhone(), users.getEmail());
        this.users = users;
    }
    
    /**
     * 
     * @param user 
     */
    public UsersController(User user){
        //Perform this operation if ID exists for the User object
        if(user.getId() > 0){
            users.setId(user.getId());
        }
        
        users.setSurname(user.getSurname());
        users.setFirstname(user.getFirstname());
        users.setPhone(user.getPhone());
        users.setEmail(user.getEmail());
     
        this.user = user;
    }
    
    /**
     * Saves the user to database.
     * @param user
     * @param passwordHash
     * @return 
     */
    public User createUser(User user, String passwordHash){
        UsersController controller = new UsersController(user);
        //Change the pure object to entity
        Users entity = controller.getUsers();
        
        //Set the password hash
        entity.setPasswordHash(passwordHash);
        /**
         * TODO Add code to save entity to database
         */
        return user;
    }
    
    /**
     * Deletes the user record container.
     * @param user
     * @return 
     */
    public boolean deleteUser(User user){
        UsersController controller = new UsersController(user);
        //Retrieve the Users entity from the controller instance
        Users entity = controller.getUsers();
        /**
         * TODO Add code to delete entity from database
         */
        
        return false;
    }
    
    /**
     * Updates user record in database
     * @param user
     * @return 
     */
    public User updateUser(User user){
        UsersController controller = new UsersController(user);
        //Retrieve users entity from the controller
        Users entity = controller.getUsers();
        /**
         * TODO Add code to update entity to database
         */
        return user;
    }

    /**
     * Read the user from container using ID
     * @param id
     * @return 
     */
    public User readUserById(Integer id){
        Users entity = new Users(id);
        
        /**
         * TODO Add code to read entity by ID from database
         */
        return new User();
    }
    
    /**
     * Reads user by email from container.
     * @param email
     * @return 
     */
    public User readUserByEmail(String email){
        /**
         * TODO Add code to read entity by email from database
         */
        return new User();
    }
    
    /**
     * Reads user by phone from database.
     * @param phone
     * @return 
     */
    public User readUserByPhone(String phone){
        /**
         * TODO Add code to read entity by phone from database
         */
        return new User();
    }
    
    /**
     * @return the users
     */
    public Users getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Users users) {
        this.users = users;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
}
