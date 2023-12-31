package ru.taldring.model;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Origin {
	private String origin;

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Origin origin1)) return false;
		return Objects.equals(origin, origin1.origin);
	}

	@Override
	public int hashCode() {
		return Objects.hash(origin);
	}
}
