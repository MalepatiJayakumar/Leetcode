package com.audit.entity;

import java.util.Date;

import com.audit.listener.AuditEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditEntityListener.class)
@Getter
@Setter
public abstract class AuditedEntity {
	
	private String createUser;
	private String updateUser;
	private Date createdDate;
	private Date updatedDate;

	private Object previousState;
	
}