package Steps;

import Data.Dates;
import Format.FormatChange;
import Pages.RegistrationPage;
import io.qameta.allure.Step;

import Connection.DbConnection;


import java.sql.*;


public class SQLSteps {
    Dates dates =new Dates();
    FormatChange formatChange = new FormatChange();
    RegistrationPage registrationPage = new RegistrationPage();


    @Step("inserting step")
    public SQLSteps inserting(){
        try {
            Connection connection = DbConnection.getConnection();

            String sql = "INSERT INTO users (firstName, lastName, phone, email, dateOfBirth, password) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, dates.firstname);
                preparedStatement.setString(2, dates.lastname);
                preparedStatement.setString(3, dates.phonenumber);
                preparedStatement.setString(4, dates.mail);
                preparedStatement.setDate(5, Date.valueOf(dates.birthDate));
                preparedStatement.setString(6, dates.password);

                preparedStatement.executeUpdate();
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("selecting step")
    public SQLSteps selecting() throws SQLException {
        Connection connection = DbConnection.getConnection();
        String sql = "SELECT TOP 1 * FROM users ORDER BY id DESC";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                java.sql.Date dateOfBirth = resultSet.getDate("dateOfBirth");
                String password = resultSet.getString("password");

                dates.namelist.add(firstName);
                dates.lastNameLIst.add(lastName);
                dates.phoneList.add(phone);
                dates.emailList.add(email);
                dates.birthDateList.add(formatChange.dataFormatChanger(String.valueOf(dateOfBirth)));
                dates.passwordList.add(password);


            } else {
                System.out.println("No data found.");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return this;

    }

    @Step("deletingRow")
    public SQLSteps deletingLastAddedRow() {
        try {
            Connection connection = DbConnection.getConnection();

            String deleteSql = "DELETE FROM users WHERE id = (SELECT MAX(id) FROM users)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
                int rowsDeleted = preparedStatement.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Last added row has been deleted.");
                } else {
                    System.out.println("No rows were deleted (last added row not found).");
                }
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this;
    }

    @Step("sendingName")
    public SQLSteps sendName(){
        registrationPage.firstName.setValue(dates.namelist.get(0));
        return this;

    }

    @Step("sendingLastName")
    public SQLSteps sendLastName(){
        registrationPage.lastName.setValue(dates.lastNameLIst.get(0));
        return this;

    }


    @Step("sendingPhoneNumber")
    public SQLSteps sendPhoneNumber(){
        registrationPage.phone.setValue(dates.phoneList.get(0));
        return this;

    }

    @Step("sendingEmail")
    public SQLSteps sendEmail(){
        registrationPage.Email.setValue(dates.emailList.get(0));
        return this;

    }

    @Step("SendingBirthDate")
    public SQLSteps sendBirthDate(){
        registrationPage.birthDate.setValue(dates.birthDateList.get(0));
        return this;

    }

    @Step("sendingPassword")
    public SQLSteps sendPassword(){
        registrationPage.password.setValue((dates.passwordList.get(0)));
        return this;

    }

    @Step("ConfirmPassword step")
    public SQLSteps confirmPassword(){
        registrationPage.confirmPassword.setValue(dates.passwordList.get(0));
        return this;
    }

}




