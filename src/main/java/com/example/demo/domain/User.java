package com.example.demo.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;


@Entity
@DynamicUpdate(value = true)
@Table(name="users")
@Data
public class User implements UserDetails{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 745920849672318551L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;
    
	@NotNull
	@Column(nullable = false)
	private Boolean enabled;
    
    @Column(name = "account_locked")
	private boolean accountNonLocked;

	@Column(name = "account_expired")
	private boolean accountNonExpired;

	@Column(name = "credentials_expired")
	private boolean credentialsNonExpired;
    
	
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(name="role_user",joinColumns = {
    		@JoinColumn(name = "user_id",referencedColumnName = "id")},inverseJoinColumns = {
    			@JoinColumn(name = "role_id",referencedColumnName = "id")	
    		})
    private Set<Role> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

	@PrePersist
	public void prePersist(){
		//    this.enabled = false;
		this.accountNonExpired = false;
		this.accountNonLocked = false;
		this.credentialsNonExpired = false;
	}
	
}
