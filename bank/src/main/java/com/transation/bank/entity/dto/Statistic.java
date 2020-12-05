package com.transation.bank.entity.dto;

public class Statistic {

	private Long count;
	private Double sum, avg, min, max;

	public Statistic(Long count, Double sum, Double avg, Double min, Double max) {
		super();
		this.count = count;
		this.sum = sum == null ? 0 : sum;
		this.avg = avg == null ? 0 : avg;
		this.min = min == null ? 0 : min;
		this.max = max == null ? 0 : max;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public Double getAvg() {
		return avg;
	}

	public void setAvg(Double avg) {
		this.avg = avg;
	}

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}

}
