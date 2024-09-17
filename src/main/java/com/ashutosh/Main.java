package com.ashutosh;

import com.ashutosh.bean.Tutor;
import com.ashutosh.bean.User;
import com.ashutosh.business.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the app");

        Tutor tutor =new Tutor();


        System.out.println("Enter you email: ");
        tutor.setEmailId(scanner.next());

        System.out.println("Enter your password: ");

        tutor.setPassword(scanner.next());

        System.out.println("Enter your user name: ");
        tutor.setUserName(scanner.next());

        System.out.println("Enter your phone Number: ");
        tutor.setPhoneNumber(scanner.next());

        tutor.setRole(User.Role.Tutor);

        System.out.println("Enter your aadhar Number: ");
        tutor.setAadharCardNumber(scanner.next());

        System.out.println("Enter your image url: ");
        tutor.setImageURL(scanner.next());


    }
}
