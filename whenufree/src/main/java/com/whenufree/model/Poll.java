package com.whenufree.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

import java.util.Set;
import java.util.HashSet;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.whenufree.model.FriendGroup;

@Entity
@Table(name = "poll")
public class Poll{
    private Long pollId;
    private String description;

    private Set<PollOption> options;

    public Poll(){
	this.options = new HashSet<>();
    }
    
    /**
     * Gets the value of pollId
     *
     * @return the value of pollId
     */
    @Id
    @GenericGenerator(name = "pollautoinc", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
		      parameters = {
			  @Parameter(name = "sequence_name", value = "pollautoinc"),
			  @Parameter(name = "optimizer", value = "hilo"),
			  @Parameter(name = "initial_value", value = "1"),
			  @Parameter(name = "increment_size", value = "1") }
    )
    @GeneratedValue(generator = "pollautoinc")
    @Column(name = "pollid")
    public Long getPollId() {
	return this.pollId;
    }

    /**
     * Sets the value of pollId
     *
     * @param argPollId Value to assign to this.pollId
     */
    public void setPollId(final Long argPollId) {
	this.pollId = argPollId;
    }

    /**
     * Gets the value of description
     *
     * @return the value of description
     */
    @Column(name = "description", nullable = true)
    public String getDescription() {
	return this.description;
    }

    /**
     * Sets the value of description
     *
     * @param argDescription Value to assign to this.description
     */
    public void setDescription(String argDescription) {
	this.description = argDescription;
    }

    @OneToMany(mappedBy = "poll", fetch = FetchType.LAZY)
    public Set<PollOption> getOptions(){
	return this.options;
    }

    public void setOptions(Set<PollOption> options){
	this.options = options;
    }

    

}
