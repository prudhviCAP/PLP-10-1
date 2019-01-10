package com.cg.insurance.bean;

public class Question {
	private int policyQuestionId;
	private int businessSegmentId;
	private String question;
	private String answer1;
	private int weightage1;
	private String answer2;
	private int weightage2;
	private String answer3;
	private int weightage3;
	
	public int getPolicyQuestionId() {
		return policyQuestionId;
	}
	public void setPolicyQuestionId(int policyQuestionId) {
		this.policyQuestionId = policyQuestionId;
	}
	public int getBusinessSegmentId() {
		return businessSegmentId;
	}
	public void setBusinessSegmentId(int businessSegmentId) {
		this.businessSegmentId = businessSegmentId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public int getWeightage1() {
		return weightage1;
	}
	public void setWeightage1(int weightage1) {
		this.weightage1 = weightage1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public int getWeightage2() {
		return weightage2;
	}
	public void setWeightage2(int weightage2) {
		this.weightage2 = weightage2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public int getWeightage3() {
		return weightage3;
	}
	public void setWeightage3(int weightage3) {
		this.weightage3 = weightage3;
	}
	
	@Override
	public String toString() {
		return "Question [policyQuestionId=" + policyQuestionId + ", businessSegmentId=" + businessSegmentId
				+ ", question=" + question + ", answer1=" + answer1 + ", weightage1=" + weightage1 + ", answer2="
				+ answer2 + ", weightage2=" + weightage2 + ", answer3=" + answer3 + ", weightage3=" + weightage3 + "]";
	}
	
	
}
