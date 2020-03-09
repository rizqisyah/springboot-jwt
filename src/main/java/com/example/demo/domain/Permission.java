package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "permission")
@Data
public class Permission implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -3077063452903507914L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name",length = 100,unique = true)
	private String name;
	
	@Column(name = "description", length = 100, unique = true)
	private String description;
	
	@Column(name = "category", length = 100)
	private String category;
	
}
