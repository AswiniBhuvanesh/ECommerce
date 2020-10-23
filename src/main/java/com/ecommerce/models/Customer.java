package com.ecommerce.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain=true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_A")
public class Customer implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Auto Generated Customer ID",name="customerID",readOnly=true,value="0")
    private int customerID;
    
    @Column(nullable = true, name = "customerName")	
    @ApiModelProperty(notes = "Customer Name",name="customerName",required=true,value="Test Customer")
    private String customerName="Test Swag Exam";
    
    @Column(nullable = true, name = "customerAge")
    @ApiModelProperty(notes = "Customer Age",name="customerID",required=true,value="0")
    private Integer customerAge;
    
    @Column(nullable = true, name = "customerAddress")
    @ApiModelProperty(notes = "Customer Address",name="customerID",required=false,value="Singapore")
    private String customerAddress;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonManagedReference
    @ApiModelProperty(notes = "Details Related to the order associated to the particular customer",hidden=true,name="customerID",required=false,value="Singapore")
	private Set<Orders> orders;
    
	

}