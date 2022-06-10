package com.interview.ibm.model;


import java.time.OffsetDateTime;
import java.util.UUID;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDTO {
	
	 	private UUID remoteUserId;		
	
	    private String remoteAddres;  
	   
	    private OffsetDateTime dateCreated;
	   
	    private OffsetDateTime lastUpdated;

		public UUID getRemoteUserId() {
			return remoteUserId;
		}

		public void setRemoteUserId(UUID remoteUserId) {
			this.remoteUserId = remoteUserId;
		}

		public String getRemoteAddres() {
			return remoteAddres;
		}

		public void setRemoteAddres(String remoteAddres) {
			this.remoteAddres = remoteAddres;
		}

		public OffsetDateTime getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(OffsetDateTime dateCreated) {
			this.dateCreated = dateCreated;
		}

		public OffsetDateTime getLastUpdated() {
			return lastUpdated;
		}

		public void setLastUpdated(OffsetDateTime lastUpdated) {
			this.lastUpdated = lastUpdated;
		}


	    
	    

}
