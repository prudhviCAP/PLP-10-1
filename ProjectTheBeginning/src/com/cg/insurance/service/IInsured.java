package com.cg.insurance.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cg.insurance.bean.CreateAccount;
import com.cg.insurance.bean.DetailedReportBean;
import com.cg.insurance.bean.InsuranceFormBean;
import com.cg.insurance.bean.NewPolicySchemeBean;
import com.cg.insurance.bean.PolicyBean;
import com.cg.insurance.bean.PolicyDetailsBean;
import com.cg.insurance.bean.Question;
import com.cg.insurance.bean.ReportGeneration;

public interface IInsured {
	
	public List<PolicyBean> viewMyPolicies(String userName) throws Exception;
	public List<PolicyBean> viewAllPolicies() throws Exception;
	public String  newPolicy(InsuranceFormBean insuranceFormBean) throws Exception;
	public List<Question> getQuestions(String businessSegment) throws SQLException, IOException;
	public boolean setPremium(int premium) throws SQLException, IOException;
	public void createAccount(CreateAccount createBean) throws IOException;
	public List<ReportGeneration> generateReport(String userName) throws IOException;
	public DetailedReportBean getDetailedReport(long policyNumber);
	public void createNewScheme(NewPolicySchemeBean newPolicySchemeBean);

}
