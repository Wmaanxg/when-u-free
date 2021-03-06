package com.whenufree.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Created by Desmond George 11/20/2017
 */
@Entity
@Table(name = "groupfreetime")
public class GroupFreeTime {

	private Long groupFreeTimeId;
	/**
	 * Gets the GroupFreeTime Id.
	 *
	 * @return the value of groupFreeTimeId
	 */
	@Id
	@GenericGenerator(name = "groupfreetimeautoinc", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
		@Parameter(name = "sequence_name", value = "groupfreetimeautoinc"),
		@Parameter(name = "optimizer", value = "hilo"),
		@Parameter(name = "initial_value", value = "1"),
		@Parameter(name = "increment_size", value = "1") }
		)
	@GeneratedValue(generator = "groupfreetimeautoinc")
	@Column(name= "groupfreetimeid")
	public Long getGroupFreeTimeId() {
		return groupFreeTimeId;
	}

	/**
	 * Sets the GroupFreeTime Id.
	 *
	 * @param groupFreeTimeId The new groupFreeTimeId value
	 */
	public void setGroupFreeTimeId(Long groupFreeTimeId) {
		this.groupFreeTimeId = groupFreeTimeId;
	}

	private Integer numUsers;
	/**
	 * Gets the number of users available at this particular free time.
	 *
	 * @return the value of numUsers
	 */
	@Column(name= "numusers", nullable = false)
	public Integer getNumUsers() {
		return numUsers;
	}
	/**
	 * Sets the number of available users.
	 *
	 * @param numUsers the new value of available users
	 */
	public void setNumUsers(Integer numUsers) {
		this.numUsers = numUsers;
	}

	private TimeSlot timeSlot;
	/**
	 * Get the timeSlotId column. This Column contains a foreign key associated with the TimeSlot table.
	 *
	 * @return the value of timeSlot
	 */
	// Associative table so we add the primary keys of
	@ManyToOne
	@JoinColumn(name= "timeslotid", referencedColumnName= "timeslotid", nullable = false)
	public TimeSlot getTimeslot() {
		return timeSlot;
	}
	/**
	 * Adds a new time slot to the list of available slots to use when determining potential free time.
	 *
	 * @param timeSlot the new time slot value we are adding to the group free time.
	 */
	public void setTimeslot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}

	private FriendGroup friendGroup;
	/**
	 * Get the friendGroupId column. This Column contains a foregin key associated with the FriendGroup table.
	 *
	 * @return the value of friendGroup
	 */
	@ManyToOne
	@JoinColumn(name= "friendgroupid", referencedColumnName= "friendgroupid", nullable = false)
	public FriendGroup getFriendGroup() {
		return friendGroup;
	}
	/**
	 * Set the friendGroup that we are using.
	 *
	 * @param friendGroup the value of the new friendGroup
	 */
	public void setFriendGroup(FriendGroup friendGroup) {
		this.friendGroup = friendGroup;
	}

	public GroupFreeTime() { }

	@Override
	public String toString() {
		return "groupFreeTime { " +
			"groupFreeTimeId: " + groupFreeTimeId +
			"numUsers: " + numUsers +
			"timeSlotId: " + timeSlot +
			"friendGroupId: " + friendGroup +
			'}';
	}
}
