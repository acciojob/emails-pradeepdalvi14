package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        if(newPassword.length()<=7){
            //System.out.println("Password should contain at least 8 characters");
            return;
        }
        String currPassword = this.getPassword();

        if(oldPassword.equals(currPassword)){


            boolean isLowercasel = false;
            boolean isUpperCasel = false;
            boolean isDigitp = false;
            boolean specialChar = false;

            for(char c:newPassword.toCharArray()){
                if(Character.isUpperCase(c)){
                    isUpperCasel = true;
                }else if(Character.isLowerCase(c)){
                    isLowercasel = true;
                } else if (Character.isDigit(c)) {
                    isDigitp=true;
                } else if (!Character.isLetterOrDigit(c)) {
                    specialChar = true;
                }
            }
            if(isDigitp && isUpperCasel && isLowercasel && specialChar){
                this.password = newPassword;
                //System.out.println("password has been updated successfully ");
            }
//            else{
//                if(!isDigitp){
//                    System.out.println("new password should contain atleast one digit");
//                }
//                if(!isUpperCasel){
//                    System.out.println("new password should contain atleast one capital letter");
//                }
//                if(!isLowercasel){
//                    System.out.println("new password should contain atleast one small letter");
//                }
//                return;
//            }

        }
//        else{
//            System.out.println("Old password didnt matched. ");
//        }
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
}
