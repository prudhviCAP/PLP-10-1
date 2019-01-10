package com.cg.insurance.pl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.cg.insurance.bean.CreateAccount;
import com.cg.insurance.bean.DetailedReportBean;
import com.cg.insurance.bean.InsuranceFormBean;
import com.cg.insurance.bean.NewPolicySchemeBean;
import com.cg.insurance.bean.PolicyBean;
import com.cg.insurance.bean.PolicyDetailsBean;
import com.cg.insurance.bean.Question;
import com.cg.insurance.bean.ReportGeneration;
import com.cg.insurance.service.IInsured;
import com.cg.insurance.service.IInsuredImpl;

public class InsuranceMain {

	
	static Scanner scanner = null;
	static CreateAccount createBean = null;
	public static void main(String[] args) throws Exception {
		
		
		boolean role=true;
		while(role) {                                                                
			System.out.println("*---*---*----*---*---*---*---*-");
			System.out.println("---*-Welcome to Home page--*---");
			System.out.println("*---*---*----*---*---*---*---*-");
			System.out.println("   1. Insured User             ");
			System.out.println("   2. Insurance Agent          ");
			System.out.println("   3. UnderWriter or Admin     ");
			System.out.println("                               ");
			System.out.println("--*---*-Choose your role--*----");
			
			scanner = new Scanner(System.in);
			int option;
			System.out.println(" choose your role...");
			option = scanner.nextInt();
			
			while(true) {
				switch(option) {
				case 1:
					System.out.println("--*---*---*---*---*---*---*--*---");
					System.out.println("     Welcome Insured User        ");
					System.out.println("*---*---*----*---*---*---*---*---");
					System.out.println("  1. Search schemes              ");
					System.out.println("  2. View existing Schemes       ");
					System.out.println("  3. Request for Scheme          ");
					System.out.println("  4. Exit                        ");
					System.out.println("                                 ");
					System.out.println("--*---*-Choose your option--*----");
					boolean opt = true;
					while(opt) {
						int option1=0;
						System.out.println(" ");
						option1 = scanner.nextInt();
						switch(option1) {
							case 1:
								IInsured  iInsured  = new IInsuredImpl();
								List<PolicyBean> al = new ArrayList<>();
								al = iInsured.viewAllPolicies();
								Iterator<PolicyBean> itr1 = al.iterator();
								while(itr1.hasNext()) {
									System.out.println(itr1.next());
								}
								break;
								
							case 2:
								try {
								IInsured  iInsured1 = new IInsuredImpl();
								List<PolicyBean> al1 = new ArrayList<>();
								System.out.println(" enter username to view your schemes");
								String userName = scanner.next();
								al1 = iInsured1.viewMyPolicies(userName);
								Iterator<PolicyBean> itr2 = al1.iterator();
								while(itr2.hasNext()) {
									System.out.println(itr2.next());
								}
								}
								catch(Exception e)
								{
									e.getStackTrace();
								}
								
								break;
								
							case 3:
								iInsured = new IInsuredImpl();
								System.out.println(" enter details and get scheme");
								InsuranceFormBean insuranceFormBean = new InsuranceFormBean();
								System.out.println(" enter details to get new policy  ");
							//	insuranceFormBean = populateFrom();
								String insuredName;
								System.out.println(" enter your insured name ");
								insuredName = scanner.next();
								insuranceFormBean.setInsuredName(insuredName);
								
								String insuredStreet;
								System.out.println(" enter your street ");
								insuredStreet = scanner.next();
								insuranceFormBean.setInsuredStreet(insuredStreet);
								
								String insuredCity;
								System.out.println(" enter your city ");
								insuredCity = scanner.next();
								insuranceFormBean.setInsuredCity(insuredCity);
								
								String insuredState;
								System.out.println(" enter your state name ");
								insuredState = scanner.next();
								insuranceFormBean.setInsuredState(insuredState);
								
								int insuredZip;
								System.out.println(" enter your zip code ");
								insuredZip = scanner.nextInt();
								insuranceFormBean.setInsuredZip(insuredZip);
								
								String businessSegment;
								System.out.println(" enter business segment from health,life,property");
								businessSegment = scanner.next();
								insuranceFormBean.setBusinessSegment(businessSegment);
								
								List<Question> list = new ArrayList<>();	
								list = iInsured.getQuestions(businessSegment);
								Iterator<Question> itr = list.iterator();
								System.out.println("main1");
								if(list.isEmpty()) {
									System.out.println("success");
								}
								else {
									boolean iterator=true;
								while(iterator){
									Question question = new Question();
									question = itr.next();
									System.out.println("select "+question.getQuestion());
									System.out.println(" select option 1 / 2 / 3 ");
									System.out.println(" select from "+question.getAnswer1()+","+question.getAnswer2()+","+question.getAnswer3());
									int answer;
									int premium=10000;
									answer = scanner.nextInt();
									switch(answer) {
									case 1:
										boolean premiumSet=false;
								//		premium += question.getWeightage1();
										System.out.println("success");
										/*premiumSet = iInsured.setPremium(premium);
										if(premiumSet) {
											System.out.println("successfully policy created");
										}
										else {
											System.out.println(" unsuccessful policy creation");
										}*/
										iterator = false;
										break;
									case 2:
										premium += question.getWeightage2();
										iInsured.setPremium(premium);
										System.out.println("success");
										iterator = false;
										break;
									case 3:
										premium += question.getWeightage3();
										iInsured.setPremium(premium);
										System.out.println("success");
										iterator = false;
										break;
									default:
										System.out.println(" this is not accepted here...");
										break;
									}
								}
									System.out.println(" enter user name");
									String userName = scanner.next();
									insuranceFormBean.setUserName(userName);
									
									iInsured = new IInsuredImpl();
									String newPolicy;
									newPolicy = iInsured.newPolicy(insuranceFormBean);
									System.out.println(newPolicy);
								}
								
						       break;
							case 4:
								System.exit(0);
							default:
								System.out.println("enter valid option.....");
								break;
						}
						opt=false;
					}
					break;
					
				case 2:
					
					System.out.println("--*---*---*---*---*---*---");
					System.out.println("  Welcome Insurance Agent ");
					System.out.println("--*---*---*---*---*--*---*");
					System.out.println("  1. Create Account as requested ");
					System.out.println("  2. View Customer Details(corresponding) ");
					System.out.println("  3. Exit                        ");
					System.out.println("                                 ");
					System.out.println("--*---*-Choose your option--*----");
					
					int option2=0;
					System.out.println(" enter option    ");
					option2 = scanner.nextInt();
					boolean opt2 = true;
					
					
					while(opt2) {
						switch(option2) {
							case 1:
								System.out.println(" take details from user and create account   ");
								break;
							case 2:
								System.out.println(" get details of particular agent             ");
								break;
							case 3:
								System.exit(0);
							default:
								System.out.println("..oops ...wrong option........");
								break;
						}
						opt2 = false;
					}
					break;
					
				case 3:
					createBean = new CreateAccount();
					IInsured iInsured = new IInsuredImpl();
					IInsuredImpl iInsuredImpl = new IInsuredImpl();
					System.out.println("--*---*---*---*---*---*---*---*--");
					System.out.println("        Welcome Admin            ");
					System.out.println("                                 ");
					System.out.println("*---*---*----*---*---*---*---*---");
					System.out.println("  1. Create user/agent/admin account ");
					System.out.println("  2. Search schemes              ");
					System.out.println("  3. View existing Schemes       ");
					System.out.println("  4. Request for Scheme          ");
					System.out.println("  5. Create Account as requested ");
					System.out.println("  6. View Customer Details(corresponding) ");
					System.out.println("  7. Create new scheme            ");
					System.out.println("  8. Generate Report             ");
					System.out.println("  9. Exit                        ");
					System.out.println("                                 ");
					System.out.println("--*---*-Choose your option--*----");
					
					int option3 = 0;
					System.out.println(" enter option from above menu    ");
					option3 = scanner.nextInt();
					boolean opt3 = true;
					
					while(opt3) {
						switch(option3) {
							case 1:
								
								while(createBean==null)
								{
									createBean=new CreateAccount();
									String userName = null;
									System.out.println("Enter Username ");
									userName = scanner.next();
									createBean.setUsername(userName);
									String password;
									System.out.println("Enter Password ");		
									password = scanner.next();
									createBean.setPassword(password);
									CreateAccount.role roleCode;
									System.out.println("Enter Role Code ");
									roleCode = role.valueOf(scanner.next());
									createBean.setRole_code(roleCode);	
									iInsuredImpl.validateBean(createBean);
									iInsured.createAccount(createBean);
								}	
							break;
							case 2:
								System.out.println(" show schemes ");
								break;
							case 3:
								System.out.println(" view schemes of user");
								break;
							case 4:
								System.out.println(" enter details and get scheme");
								break;
							case 5:
								System.out.println(" take details from user and create account   ");
								break;
							case 6:
								System.out.println(" get details of particulat agent             ");
								break;     
							case 7:
								System.out.println("Welcome Admin");
								System.out.println("New Scheme Creation Page");
								NewPolicySchemeBean newPolicySchemeBean=new NewPolicySchemeBean();
								System.out.println("Enter New Policy Business Segment ID");
								newPolicySchemeBean.setBus_seg_id(scanner.nextInt());
								System.out.println("Enter New Policy Business Segment Name");
								newPolicySchemeBean.setBus_seg_name(scanner.next());
								System.out.println("Enter New Policy Question ID");
								newPolicySchemeBean.setPol_ques_id(scanner.nextInt());
								System.out.println("Enter New Question ");
								newPolicySchemeBean.setPol_ques_desc(scanner.next());
								System.out.println("Enter Answer-1 For Entered Question:");
								newPolicySchemeBean.setPol_ques_ans1(scanner.next());
								System.out.println("Enter Weightage for Answer-1 :");
								newPolicySchemeBean.setPol_ques_ans1_weightage(scanner.nextInt());
								System.out.println("Enter Answer-2 For Entered Question:");
								newPolicySchemeBean.setPol_ques_ans2(scanner.next());
								System.out.println("Enter Weightage for Answer-2 :");
								newPolicySchemeBean.setPol_ques_ans2_weightage(scanner.nextInt());
								System.out.println("Enter Answer-3 For Entered Question:");
								newPolicySchemeBean.setPol_ques_ans3(scanner.next());
								System.out.println("Enter Weightage for Answer-3 :");
								newPolicySchemeBean.setPol_ques_ans3_weightage(scanner.nextInt());
					
								iInsured = new IInsuredImpl();
								iInsured.createNewScheme(newPolicySchemeBean);
								System.out.println("New Policy Scheme Created Successfully");
								break;
							case 8:
								iInsured = new IInsuredImpl();
								System.out.println("Enter Username ");
								String userName = scanner.next();
								List<ReportGeneration> li = new ArrayList<>();
								li =  iInsured.generateReport(userName);
								Iterator<ReportGeneration> itr = li.iterator();
								while(itr.hasNext()) {
									System.out.println(itr.next());
								}
								
								System.out.println("        ");
								System.out.println(" 1. get detailed policy view ");
								System.out.println(" 2. exit  ");
								System.out.println("             ");
								System.out.println("select option ");
								int view=0;
								switch(view) {
								case 1:
									DetailedReportBean detailedReportBean = new DetailedReportBean();
									System.out.println(" enter policy number to get detailed report ");
									long policyNumber = scanner.nextLong();
									detailedReportBean = iInsured.getDetailedReport(policyNumber);
									System.out.println(detailedReportBean);
									break;
								case 2:
									System.exit(0);
								default:
									System.out.println("invalid option ");
									break;
								}
								break;
							case 9:System.out.println("exit");
						    	System.exit(0);
							default:
								System.out.println(" enter valid option ");
								break;
						}
						opt3=false;
					}
					break;
				case 4:
					System.exit(0);
				default:System.out.println("enter valid option    ");
				   break;
				}
			}
		}
		role = false;
	}
}
