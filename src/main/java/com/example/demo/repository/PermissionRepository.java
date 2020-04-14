package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{

	Permission findByName (String permessionName);
}
