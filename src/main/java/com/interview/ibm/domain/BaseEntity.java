/**
 * 
 */
package com.interview.ibm.domain;

import java.time.OffsetDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;


@MappedSuperclass
@Audited
public class BaseEntity {

	@Transient
	private int firstResult;

	@Transient
	private int maxResults;

	@Transient
	private String sortField;

	@Transient
	private String sortOrder;

	@Column(columnDefinition = "char(36)")
	@Type(type = "uuid-char")
	private UUID remoteUserId;

	@Column
	private String remoteAddres;

	@Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private OffsetDateTime dateCreated;

	@Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private OffsetDateTime lastUpdated;

	@Transient
	private OffsetDateTime lastUpdateDateStart;

	@Transient
	private OffsetDateTime lastUpdateDateEnd;

	@Transient
	private OffsetDateTime filterDateStart;

	@Transient
	private OffsetDateTime filterDateEnd;

	@PrePersist
	public void prePersist() {
		dateCreated = OffsetDateTime.now();
		lastUpdated = dateCreated;
	}

	@PreUpdate
	public void preUpdate() {
		lastUpdated = OffsetDateTime.now();
	}

	public int getFirstResult() {
		return this.firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getMaxResults() {
		return this.maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public String getSortField() {
		return this.sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public OffsetDateTime getLastUpdateDateStart() {
		return lastUpdateDateStart;
	}

	public void setLastUpdateDateStart(OffsetDateTime lastUpdateDateStart) {
		this.lastUpdateDateStart = lastUpdateDateStart;
	}

	public OffsetDateTime getLastUpdateDateEnd() {
		return lastUpdateDateEnd;
	}

	public void setLastUpdateDateEnd(OffsetDateTime lastUpdateDateEnd) {
		this.lastUpdateDateEnd = lastUpdateDateEnd;
	}

	public UUID getRemoteUserId() {
		return this.remoteUserId;
	}

	public void setRemoteUserId(UUID remoteUserId) {
		this.remoteUserId = remoteUserId;
	}

	public String getRemoteAddres() {
		return this.remoteAddres;
	}

	public void setRemoteAddres(String remoteAddres) {
		this.remoteAddres = remoteAddres;
	}

	public OffsetDateTime getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(OffsetDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public OffsetDateTime getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(OffsetDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public OffsetDateTime getFilterDateStart() {
		return filterDateStart;
	}

	public void setFilterDateStart(OffsetDateTime filterDateStart) {
		this.filterDateStart = filterDateStart;
	}

	public OffsetDateTime getFilterDateEnd() {
		return filterDateEnd;
	}

	public void setFilterDateEnd(OffsetDateTime filterDateEnd) {
		this.filterDateEnd = filterDateEnd;
	}

}
