package com.tcarroll10.leetCode.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = OutputTo.Builder.class)
public class OutputTo {

	private String msg;
	private Integer rslt;
	private Boolean valid;

	private OutputTo(Builder builder) {
		this.msg = builder.msg;
		this.rslt = builder.rslt;
		this.valid = builder.valid;
	}

	/**
	 * Creates builder to build {@link OutputTo}.
	 * 
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Creates a builder to build {@link OutputTo} and initialize it with the given
	 * object.
	 * 
	 * @param outputTo to initialize the builder with
	 * @return created builder
	 */
	public static Builder builder(OutputTo outputTo) {
		return new Builder(outputTo);
	}

	/**
	 * Builder to build {@link OutputTo}.
	 */
	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
	public static final class Builder {
		private String msg;
		private Integer rslt;
		private Boolean valid;

		private Builder() {
		}

		private Builder(OutputTo outputTo) {
			this.msg = outputTo.msg;
			this.rslt = outputTo.rslt;
			this.valid = outputTo.valid;
		}

		public Builder msg(String msg) {
			this.msg = msg;
			return this;
		}

		public Builder rslt(Integer rslt) {
			this.rslt = rslt;
			return this;
		}

		public Builder valid(Boolean valid) {
			this.valid = valid;
			return this;
		}

		public OutputTo build() {
			return new OutputTo(this);
		}
	}

	public String getMsg() {
		return msg;
	}

	public Integer getRslt() {
		return rslt;
	}

	public Boolean getValid() {
		return valid;
	}

	@Override
	public String toString() {
		return "OutputTo [msg=" + msg + ", rslt=" + rslt + ", valid=" + valid + "]";
	}

}
