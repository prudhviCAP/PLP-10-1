package com.cg.insurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.cg.insurance.bean.InsuranceFormBean;
import com.cg.insurance.bean.PolicyBean;
import com.cg.insurance.bean.PolicyDetailsBean;
import com.cg.insurance.bean.Question;
import com.cg.insurance.util.DBConnection;

public class InsuredDaoImpl implements IInsuredDao {
	
	@Override
	public List<PolicyBean> viewAllPolicies() throws Exception {
		
		Connection con = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = con.prepareStatement("select * from policy");
			resultSet = preparedStatement.executeQuery();
			List<PolicyBean> list = new ArrayList<>();
			while(resultSet.next()) {
				PolicyBean policyBean = new PolicyBean();
				policyBean.setPolicyNumber(resultSet.getLong(1));
				policyBean.setPolicyPremium(resultSet.getInt(2));
				policyBean.setAccountNumber(resultSet.getDouble(3));
				list.add(policyBean);
			}
			return list;
		}catch(Exception e) {
			System.err.println(e.getMessage());
			
		}
		
		return null;
	}


	@Override
	public List<PolicyBean> viewMyPolicies(String userName) throws Exception {
		
		Connection con1=DBConnection.getConnection();
		PreparedStatement preparedStatement1=null;
		ResultSet resultSet1=null;
		try {
			preparedStatement1=con1.prepareStatement("select policynumber,policypremimum,b.accountnumber from account a,policy b where a.username=? and a.accountnumber=b.accountnumber");
			preparedStatement1.setString(1, userName);
			resultSet1=preparedStatement1.executeQuery();
			List<PolicyBean> list1 = new ArrayList<>();
			
			while(resultSet1.next()) {
				PolicyBean policyBean=new PolicyBean();
				policyBean.setPolicyNumber(resultSet1.getLong(1));
				policyBean.setPolicyPremium(resultSet1.getInt(2));
				policyBean.setAccountNumber(resultSet1.getDouble(3));
				list1.add(policyBean);
			}
			return list1;
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			
		}
		
		return null;
	}

	
	@Override
	public String newPolicy(InsuranceFormBean insuranceFormBean) throws Exception {
		Connection con=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		{
			try {
		
			preparedStatement = con.prepareStatement("insert into account values(account_number_seq1.nextval,?,?,?,?,?,?,?,0)");
			preparedStatement.setString(1, insuranceFormBean.getInsuredName());
			preparedStatement.setString(2, insuranceFormBean.getInsuredStreet());
			preparedStatement.setString(3, insuranceFormBean.getInsuredCity());
			preparedStatement.setString(4, insuranceFormBean.getInsuredState());
			preparedStatement.setInt(5, insuranceFormBean.getInsuredZip());
			preparedStatement.setString(6, insuranceFormBean.getBusinessSegment());
			preparedStatement.setString(7, insuranceFormBean.getUserName());
			preparedStatement.executeUpdate();
			return "inserted";
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return null;
	}


	@Override
	public List<Question> getQuestions(String businessSegment) throws SQLException, IOException {
		Connection con=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			System.out.println("in");
			preparedStatement = con.prepareStatement("select pol_ques_id,a.bus_seg_id,pol_ques_desc,pol_ques_ans1,pol_ques_ans1_weightage,pol_ques_ans2,pol_ques_ans2_weightage,pol_ques_ans3,pol_ques_ans3_weightage from policyquestion a,businesssegment b where bus_seg_name=? and a.bus_seg_id=b.bus_seg_id");
			preparedStatement.setString(1, businessSegment);
			resultSet = preparedStatement.executeQuery();
			List<Question> list = new ArrayList<>();
			Iterator<Question> itr = list.iterator();
			System.out.println("in1");
			while(resultSet.next()) {
				Question question = new Question();
				question.setPolicyQuestionId(resultSet.getInt(1));
				question.setBusinessSegmentId(resultSet.getInt(2));
				question.setQuestion(resultSet.getString(3));
				question.setAnswer1(resultSet.getString(4));
				question.setWeightage1(resultSet.getInt(5));
				question.setAnswer2(resultSet.getString(6));
				question.setWeightage2(resultSet.getInt(7));
				question.setAnswer3(resultSet.getString(8));
				question.setWeightage3(resultSet.getInt(9));
				list.add(question);
			}
			System.out.println("in2");
			return list;
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return null;
	}


	@Override
	public boolean setPremium(int premium) throws SQLException, IOException {
		Connection con=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
		
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

}
