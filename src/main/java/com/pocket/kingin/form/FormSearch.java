package com.pocket.kingin.form;

import java.util.Objects;

import jakarta.validation.constraints.Size;

public class FormSearch {
	@Size(max = 36)
	private String q;

	public FormSearch() {}

	public FormSearch(@Size(max = 36) String q) {
		super();
		this.q = q;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	@Override
	public String toString() {
		return "FormSearch [q=" + q + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(q);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormSearch other = (FormSearch) obj;
		return Objects.equals(q, other.q);
	}
	
}
