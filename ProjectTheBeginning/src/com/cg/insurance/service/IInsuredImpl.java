package com.cg.insurance.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.insurance.bean.CreateAccount;
import com.cg.insurance.bean.DetailedReportBean;
import com.cg.insurance.bean.InsuranceFormBean;
import com.cg.insurance.bean.NewPolicySchemeBean;
import com.cg.insurance.bean.PolicyBean;
import com.cg.insurance.bean.PolicyDetailsBean;
import com.cg.insurance.bean.Question;
import com.cg.insurance.bean.ReportGeneration;
import com.cg.insurance.dao.IInsuredDao;
import com.cg.insurance.dao.InsuredDaoImpl;
import com.cg.quote.dao.CreateAccountDaoImpl;
import com.cg.quote.dao.ICreateAccountDao;

public class IInsuredImpl implements IInsured{

	IInsuredDao iInsuredDao = null;
	
	@Override
	public List<PolicyBean> viewAllPolicies() throws Exception {
		iInsuredDao = new InsuredDaoImpl();
		List<PolicyBean> list = new ArrayList<>();
		list = iInsuredDao.viewAllPolicies();
		return list;
	}
	
	@Override
	public List<PolicyBean> viewMyPolicies(String userName) throws Exception {
		iInsuredDao=new InsuredDaoImpl();
		List<PolicyBean> list1=new ArrayList<>();
		list1=iInsuredDao.viewMyPolicies(userName);
		return list1;
	}

	@Override
	public String newPolicy(InsuranceFormBean insuranceFormBean) throws Exception {
		iInsuredDao = new InsuredDaoImpl();
		String newPolicy = iInsuredDao.newPolicy(insuranceFormBean);
		return newPolicy;
	}

	@Override
	public List<Question> getQuestions(String businessSegment) throws SQLException, IOException {
		iInsuredDao = new InsuredDaoImpl();
		List<Question> list = new ArrayList<>();
		list = iInsuredDao.getQuestions(businessSegment);
		return list;
	}

	@Override
	public boolean setPremium(int premium) throws SQLException, IOException {
		boolean premiumSet=false;
		iInsuredDao = new InsuredDaoImpl();
		premiumSet = iInsuredDao.setPremium(premium);
		return premiumSet;
	}
	
	static IInsuredDao iInsuredDao=null;
	@Override
	public void createAccount(CreateAccount createBean) throws IOException {
		
		iInsuredDao=new InsuredDaoImpl();
		
		CreateAccount createBeanServ=createBean;
		
		iInsuredDao.createAccount(createBeanServ);
	}
	
	@Override
	public List<ReportGeneration> generateReport(String userName) throws IOException {
		iInsuredDao=new InsuredDaoImpl();
		List<ReportGeneration> li = new ArrayList<>();
		li = iInsuredDao.generateReport(userName);
		return li;
	}
	
	@Override
	public DetailedReportBean getDetailedReport(long policyNumber) throws IOException {
		DetailedReportBean detailedReportBean = new DetailedReportBean();
		createAccountDao=new CreateAccountDaoImpl();
		detailedReportBean = createAccountDao.getDetailedReport(policyNumber);
		return null;
	}
	public CreateAccount validateBean(CreateAccount createBean) {
		
		List<String> validationErrors = new ArrayList<String>();
		
		if(!(isValidName(createBean.getUsername())))
		{
			validationErrors.add("\n UserName Should Be In Alphabets And Minimum 3 Character Long \n");
		}
		
		if(!(isValidpassword(createBean.getPassword())))
		{
			validationErrors.add("\n Password Should be Minimum 3 Characters \n");
		}
		
	
		if(validationErrors.isEmpty())
		{
			return createBean;
		}
		else
		{
			return null;
		}
	}	
		private boolean isValidName(String username) {
		
			Pattern namePattern = Pattern.compile("^[A-Za-z]{3,}$");
			Matcher nameMatcher = namePattern.matcher(username);
			return nameMatcher.matches();
		}
		
		private boolean isValidpassword(String password) {
			
			Pattern namePattern = Pattern.compile("^[A-Za-z]{3,}$");
			Matcher nameMatcher = namePattern.matcher(password);
			return nameMatcher.matches();
		}

		@Override
		public List<ReportGeneration> generateReport(String userName) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DetailedReportBean getDetailedReport(long policyNumber) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void createNewScheme(NewPolicySchemeBean newPolicySchemeBean) {
			// TODO Auto-generated method stub
			
		}


}
