package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
		@NamedQuery(name = "ScriptEntity.findAll", query = "SELECT s FROM ScriptEntity s"),
		@NamedQuery(name = "ScriptEntity.findByName", query = "SELECT s FROM ScriptEntity s WHERE s.scriptName like :scriptName") })
public class ScriptEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "ScriptEntity.findAll";
	public static final String FIND_BY_NAME = "ScriptEntity.findByName";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Long id;

	@OneToMany(mappedBy = "script", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<InterviewEntity> intList = new ArrayList<>();

	@Column(nullable = true, unique = true)
	private String scriptName;

	@Column(nullable = true, length = 100)
	private String question1;

	@Column(nullable = true, length = 100)
	private String question2;

	@Column(nullable = true, length = 100)
	private String question3;

	@Column(nullable = true, length = 100)
	private String question4;

	@Column(nullable = true, length = 100)
	private String question5;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getQuestion4() {
		return question4;
	}

	public void setQuestion4(String question4) {
		this.question4 = question4;
	}

	public String getQuestion5() {
		return question5;
	}

	public void setQuestion5(String question5) {
		this.question5 = question5;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScriptEntity other = (ScriptEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.scriptName;
	}

}
