package com.demo.nasdaq.app.demoStocks.Model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Data<B> {

	private long id;

	private String name;

	private String start_date;

	private String description;

	private List<B> data;

	private String database_code;

	public Data() {
		super();
	}

	public Data(long id, String name, String start_date, String description, List<B> data,
			String database_code) {
		super();
		this.id = id;
		this.name = name;
		this.start_date = start_date;
		this.description = description;
		this.data = data;
		this.database_code = database_code;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<B> getData() {
		return data;
	}

	public void setData(List<B> data) {
		this.data = data;
	}

	public String getDatabase_code() {
		return database_code;
	}

	public void setDatabase_code(String database_code) {
		this.database_code = database_code;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, database_code, description, id, name, start_date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data<?> other = (Data<?>) obj;
		return Objects.equals(data, other.data) && Objects.equals(database_code, other.database_code)
				&& Objects.equals(description, other.description) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(start_date, other.start_date);
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", name=" + name + ", start_date=" + start_date + ", description=" + description
				+ ", data=" + data + ", database_code=" + database_code + "]";
	}

	
	
	
}
