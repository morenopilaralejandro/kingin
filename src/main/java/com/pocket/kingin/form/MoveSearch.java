package com.pocket.kingin.form;

import java.util.Objects;

import com.pocket.kingin.domain.MoveCat;
import com.pocket.kingin.domain.Type;

import jakarta.validation.constraints.Size;

public class MoveSearch {
	@Size(max = 36)
	private String moveName;

	private Long type;

	private Long moveCat;
	
	private Type typeObj;

	private MoveCat moveCatObj;

	public MoveSearch() {}
	
	public MoveSearch(@Size(max = 36) String moveName, Long type, Long moveCat, Type typeObj, MoveCat moveCatObj) {
		super();
		this.moveName = moveName;
		this.type = type;
		this.moveCat = moveCat;
		this.typeObj = typeObj;
		this.moveCatObj = moveCatObj;
	}

	public String getMoveName() {
		return moveName;
	}

	public void setMoveName(String moveName) {
		this.moveName = moveName;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getMoveCat() {
		return moveCat;
	}

	public void setMoveCat(Long moveCat) {
		this.moveCat = moveCat;
	}

	public Type getTypeObj() {
		return typeObj;
	}

	public void setTypeObj(Type typeObj) {
		this.typeObj = typeObj;
	}

	public MoveCat getMoveCatObj() {
		return moveCatObj;
	}

	public void setMoveCatObj(MoveCat moveCatObj) {
		this.moveCatObj = moveCatObj;
	}

	@Override
	public String toString() {
		return "MoveSearch [moveName=" + moveName + ", type=" + type + ", moveCat=" + moveCat + ", typeObj=" + typeObj
				+ ", moveCatObj=" + moveCatObj + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(moveCat, moveCatObj, moveName, type, typeObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoveSearch other = (MoveSearch) obj;
		return Objects.equals(moveCat, other.moveCat) && Objects.equals(moveCatObj, other.moveCatObj)
				&& Objects.equals(moveName, other.moveName) && Objects.equals(type, other.type)
				&& Objects.equals(typeObj, other.typeObj);
	}
	
}
