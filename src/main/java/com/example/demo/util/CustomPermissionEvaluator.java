package com.example.demo.util;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Permission;
import com.example.demo.domain.Role;
import com.example.demo.repository.PermissionRepository;
import com.example.demo.repository.RoleRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator{
	
	@Autowired
	PermissionRepository permissionRepository;
	
	@Autowired
	RoleRepository roleRepository;
	

	@Override
    public boolean hasPermission(
      Authentication auth, Object targetDomainObject, Object permission) {
		log.info("permission" + permission.toString());
        if ((auth == null) || (targetDomainObject == null) || !(permission instanceof String)){
            return false;
        }
        String targetType = targetDomainObject.getClass().getSimpleName().toUpperCase();
        
        return hasPrivilege(auth,permission.toString().toLowerCase());
    }
 
    @Override
    public boolean hasPermission(
      Authentication auth, Serializable targetId, String targetType, Object permission) {
        if ((auth == null) || (targetType == null) || !(permission instanceof String)) {
            return false;
        }
        return hasPrivilege(auth,permission.toString().toUpperCase());
    }
    private boolean hasPrivilege(Authentication auth, String permission) {
        
    	Permission perm = permissionRepository.findByName(permission);
    	for (GrantedAuthority grantedAuth : auth.getAuthorities()) {
    		Role role = roleRepository.findByName(grantedAuth.getAuthority());
    		System.out.println(grantedAuth.getAuthority().toString());
    		System.out.println(permission);
                if (grantedAuth.getAuthority().contains(permission)) {
                    return true;
                }
        }
        return false;
    }
}
