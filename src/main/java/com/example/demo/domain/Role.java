package com.example.demo.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;



import lombok.Data;


@Entity
@Table(name = "role")
@Data
public class Role implements GrantedAuthority,Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, max = 50)
	@Column(length = 50, nullable = false,unique = true)
	private String name;
	
	@Size(max = 100)
	@Column(length = 100)
	private String description;
	
	@NotNull
	@Column(nullable = false)
	private Boolean activated;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "role_permission",indexes = {
			@Index(columnList = "role_id, permission_id", 
					name = "uk_role_permission", unique = true)},
          joinColumns = { @JoinColumn(name = "role_id") },
          inverseJoinColumns = { @JoinColumn(name = "permission_id") })
    private Set<Permission> permissions;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return getName();
	}
	 
	
	 
}
