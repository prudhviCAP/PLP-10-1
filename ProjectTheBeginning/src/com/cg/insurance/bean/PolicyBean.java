package com.cg.insurance.bean;

public class PolicyBean {

		private long policyNumber;
		private int policyPremium;
		private double accountNumber;
		
		public long getPolicyNumber() {
			return policyNumber;
		}
		public void setPolicyNumber(long policyNumber) {
			this.policyNumber = policyNumber;
		}
		public int getPolicyPremium() {
			return policyPremium;
		}
		public void setPolicyPremium(int policyPremium) {
			this.policyPremium = policyPremium;
		}
		public double getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(double accountNumber) {
			this.accountNumber = accountNumber;
		}
		@Override
		public String toString() {
			return "PolicyBean [policyNumber=" + policyNumber + ", policyPremium=" + policyPremium + ", accountNumber="
					+ accountNumber + "]";
		}
		
		
		
}
