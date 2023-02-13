package com.example.demo.com;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Model implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false) /// if we create it , we can't never be update on it

    private Long id ;
    private  String name;

    private String email;
    private String title ;
    private String phoneNumber;
    private String imageUrl;
    @Column(nullable = false,updatable = false)
    private String employeeCode;
    public  Model() {}


    public Model(String name , String email , String title , String phoneNumber , String imageUrl , String employeeCode)
    {
        this.name=name;
        this.id=id;
        this.email=email;
        this.title=title;
        this.phoneNumber=phoneNumber;
        this.imageUrl=imageUrl;
        this.employeeCode=employeeCode;

    }

    public long getID(){
        return  id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getName (){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){
    return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getTitle(){
        return  title;
    }

   public void setTitle(String title){
        this.title=title;

   }

   public  String getPhoneNumber(){
        return  phoneNumber;
   }
   public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
   }
   public String getImageUrl(){
        return  imageUrl;
   }
   public void setImageUrl(String imageUrl){
        this.imageUrl=imageUrl;
   }

   public  String getEmployeeCode(){
        return employeeCode;
   }
   public void setEmployeeCode(String employeeCode){
        this.employeeCode=employeeCode;
   }

   @Override
    public  String toString(){
        return "Employee("+"name="+'\''+name+"id="+id+"jobtitle"+'\''+title;
   }
}