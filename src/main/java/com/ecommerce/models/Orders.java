package com.ecommerce.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name = "orders_A")
public class Orders {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="customerID")
	@JsonBackReference
	@ApiModelProperty(notes = "Details Related to the customer associated to the particular order",name="customer",hidden=true,value="0")
	private Customer customer;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Auto Generated Order Id",name="orderID",hidden=true,required=true,value="0")
	private Integer orderID;
	
	@ApiModelProperty(notes = "Order details",name="orderDetail",required=true,value="Sample")
	private String orderDetail;
	
	@ApiModelProperty(notes = "Order Amount",name="orderAmount",required=true,value="100")
	private Double orderAmount;
	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@ApiModelProperty(notes = "Ordered Date",name="orderDate",required=true,value="2000-10-10")
	private Date orderDate;
}
