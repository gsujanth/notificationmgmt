package com.rabbitmq.notifications.notificationmgmt.Model;

public class Message {
    private String userId;
    private String userEmail;
    private String userPhone;
    private String userFirstName;
    private String userLastName;
    private String userPassword;

    public Message withUserId (final String Id) {
        setUserId(userId);
        return this;
    }

    public Message withEmail (final String emailId) {
        setUserEmail(emailId);
        return this;
    }

    public Message withPhone (final String phone) {
        setUserPhone(phone);
        return this;
    }

    public Message withFirstName (final String firstName) {
        setUserFirstName(firstName);
        return this;
    }

    public Message withLastName (final String lastName) {
        setUserFirstName(lastName);
        return this;
    }

    public Message withPassword (final String password) {
        setUserFirstName(password);
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "Message{" +
                "userId='" + userId + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
