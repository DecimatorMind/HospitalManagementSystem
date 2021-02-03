![](https://img.shields.io/badge/Language-Java-red)
![](https://img.shields.io/badge/Database-MySQL-blue)
![](https://img.shields.io/badge/UIFrameword-Swing-orange)

# HospitalManagementSystem
A Database management system, which makes it easy to control the database of the hospital.
This project was made as a semester project that used the SQL language commands through an application.
The main motive of this application is to show the connectivity of the Java Application to MySQL database.

This application controls the database using the MySQL commands that run in the swing project made in java.
I have used the Java SQL Connector in order to connect the database to the application.
The modules of Doctor login and patient login are not completed yet.

# How to run

To run the application, just open the project in any of the Java IDE, add the configurations to run the project.
Select Main.java as the main file in order to run the project.
The AdminLogin page appears, where the admin can login to open the Admin actions.
The login and password can be found in the database that is connected to the project.
The data can be added to the database very easily using any MySQL editor.

# Project Modules

The project consists of varioud modules.
The first module is the one where the admin logs in the application.
Currently the application does not contain any constraint on the input password or username.
But they can be easily added to the code.


Once the user logs in to the application.
They can see various buttons that segues them into modules that modify or update the database.
Admin can add or modify data about the doctor.
Admin can add or modify data about the patients.
Admin can see the doctor timings, and see the patient log in the form of a table.

The DoctorLogins and PatientLogins just input the text. They are not checked with any database. They are yet to be completed.
The new modules like the doctorLogin is the one where the doctor can change the their timings and can see the patients that are assigned to them.


# File Directory

    ├── README.md
    ├── bin
    │   ├── AdminPortal$1.class
    │   ├── AdminPortal$2.class
    │   ├── AdminPortal$3.class
    │   ├── AdminPortal$4.class
    │   ├── AdminPortal$5.class
    │   ├── AdminPortal$6.class
    │   ├── AdminPortal$7.class
    │   ├── AdminPortal$8.class
    │   ├── AdminPortal$9.class
    │   ├── AdminPortal.class
    │   ├── DeleteAppointment$1.class
    │   ├── DeleteAppointment$2.class
    │   ├── DeleteAppointment$3.class
    │   ├── DeleteAppointment.class
    │   ├── DeleteDoctor$1.class
    │   ├── DeleteDoctor$2.class
    │   ├── DeleteDoctor$3.class
    │   ├── DeleteDoctor.class
    │   ├── DoctorLogin$1.class
    │   ├── DoctorLogin$2.class
    │   ├── DoctorLogin$3.class
    │   ├── DoctorLogin.class
    │   ├── DoctorView$1.class
    │   ├── DoctorView.class
    │   ├── Doctor_Timings$1.class
    │   ├── Doctor_Timings$2.class
    │   ├── Doctor_Timings.class
    │   ├── Main$1.class
    │   ├── Main$2.class
    │   ├── Main$3.class
    │   ├── Main$4.class
    │   ├── Main.class
    │   ├── PatientLogin$1.class
    │   ├── PatientLogin$2.class
    │   ├── PatientLogin$3.class
    │   ├── PatientLogin$4.class
    │   ├── PatientLogin.class
    │   ├── PatientView$1.class
    │   ├── PatientView.class
    │   ├── Register$1.class
    │   ├── Register.class
    │   ├── UpdateApp$1.class
    │   ├── UpdateApp$2.class
    │   ├── UpdateApp$3.class
    │   ├── UpdateApp.class
    │   ├── UpdateDoctor$1.class
    │   ├── UpdateDoctor$2.class
    │   ├── UpdateDoctor$3.class
    │   ├── UpdateDoctor.class
    │   ├── ViewApp$1.class
    │   ├── ViewApp$2.class
    │   ├── ViewApp.class
    │   ├── ViewPAt$1.class
    │   ├── ViewPAt$2.class
    │   └── ViewPAt.class
    └── src
        ├── AdminPortal.java
        ├── DeleteAppointment.java
        ├── DeleteDoctor.java
        ├── DoctorLogin.java
        ├── DoctorView.java
        ├── Doctor_Timings.java
        ├── Main.java
        ├── PatientLogin.java
        ├── PatientView.java
        ├── Register.java
        ├── UpdateApp.java
        ├── UpdateDoctor.java
        ├── ViewApp.java
        └── ViewPAt.java

