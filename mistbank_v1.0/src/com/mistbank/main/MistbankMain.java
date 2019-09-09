package com.mistbank.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mistbank.dao.impl.MistbankDaoImpl;
import com.mistbank.exceptions.BusinessException;
import com.mistbank.model.CheckingAccounts;
import com.mistbank.model.MistUser;
import com.mistbank.model.Transactions;
import com.mistbank.service.SHA256Demo;
import com.mistbank.service.impl.MistbankServiceImpl;

public class MistbankMain {

	private static final Logger log = Logger.getLogger(MistbankMain.class);

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		long acctnumber = 0;
		double checkbalance = 0;
		
		log.info("====================================================");
		log.info("==========    Welcome to MistBank V1.0    ==========");
		log.info("====================================================\n");
		
		int ch = 0;

		do {
			log.info("------------------------------------------------");
			log.info("Your Banking Options");
			log.info("------------------------------------------------");
			log.info("1] Login");
			log.info("2] Register");
			log.info("3] EXIT");
			log.info("Above are you choices(1-3) ");

			try {
				ch = Integer.parseInt(scanner.nextLine());
				// Login
				switch (ch) {

				/// Check User Login
				case 1:
					MistUser loginconf = new MistUser();
					

					log.info("Please enter your Login details");
					log.info("Username: ");
					String usernamelogin = scanner.nextLine();
					// String usernamelogin = scanner.nextLine();
					log.info("Password: ");
					String passwordlogin = scanner.nextLine();
					String passwordlog = new SHA256Demo().sha256(passwordlogin);
					loginconf.setUsername(usernamelogin);
					loginconf.setPassword(passwordlog);

					MistbankServiceImpl service = new MistbankServiceImpl();

					try {
						// User Login Validated
						loginconf = service.userauth(loginconf);

						// log.info("-----------------------------------------------------------");
						int acct = 0;
						
						try {
							acctnumber = service.getAccountID(loginconf.getUsername());
							checkbalance = service.getCheckingAvailableBalance(loginconf.getUsername());
						} catch (Exception e) {

						}
						log.info("----------------------------------------------");
						log.info("You have logged in successfully!");
						log.info("Here are your updated details");
						log.info("----------------------------------------------");
						/// Checking Transaction
						int check = 0;
						do {

							try {
								//System.out.println("Test 2 "+checkacct.getCheckingavailablebalance());
								//System.out.println(checkbalance);

								Transactions tran = new Transactions();
								log.info("=====================================================================================");
								log.info("Account number " + acctnumber + " Available balance is = $"
										+ checkbalance);
								log.info(
										"======================================================================================");
								log.info("Transaction Options");
								log.info("--------------------");
								log.info("1] Deposit Money");
								log.info("2] Withdraw Money");
								log.info("3] Transfer Money");
								log.info("4] Back");
								log.info("5] Logout");
								check = Integer.parseInt(scanner.nextLine());
								// Transaction is happening here
								switch (check) {

								// Depositing Money here
								case 1:
									log.info("Total Available balance is $"
											+ checkbalance);
									// IF Deposit money
									log.info("Enter the deposit amount = $");
									double depoamt = Double.parseDouble(scanner.nextLine());

									log.info("Depositing... $" + depoamt);
									tran = new Transactions(depoamt);
									tran.setUsername(loginconf.getUsername());
									MistbankDaoImpl dao2 = new MistbankDaoImpl();

									tran = dao2.checkingtrans(tran);
									tran.setCheckingavailablebalance(depoamt);
									if (tran.getTransactionId() != 0) {
										log.info("Deposited $" + depoamt + " Successfully!");
										checkbalance = service.getCheckingAvailableBalance(loginconf.getUsername());
										log.info("Available balance: $"
												+ checkbalance);
										

									}

									break;
									// Withdraw
								case 2:
									
									Transactions tran1 = new Transactions();

									log.info("Total Available balance is $"
											+ checkbalance);
									tran1.setUsername(loginconf.getUsername());
									// IF Deposit money
									log.info("Enter the Withdraw amount = $");
									double withdrawammount = Double.parseDouble(scanner.nextLine());
									log.info("Withdraw... $" + withdrawammount);
									
									tran1.setWithdraw(withdrawammount);

									MistbankServiceImpl service1 = new MistbankServiceImpl();
									tran1 = service1.checkingtrans(tran1);

									if (tran1.getTransactionId() != 0) {
										log.info("Withdrawn $" + withdrawammount + " Successfully!");
										checkbalance = service.getCheckingAvailableBalance(loginconf.getUsername());
										log.info("Available balance: $"
												+ checkbalance);
									}
									break;
								case 3:
									log.info("Under Construction");
									break;
								case 4:
									check = 4;
									break;
								default:
									log.info("Please enter options(1-5) only.");
									break;
								}
							} catch (BusinessException e) {
								log.info(e.getMessage());
								log.info("Invalid amount entered");
							}

						} while (check != 4);
					} catch (BusinessException e) {
						log.info("Please Enter number choices from above only");
					}

					break;

				//////////// Register
				case 2:
					int register = 0;
					do {
						log.info("Thank you for chosing MistBank");
						log.info("1] Create Account");
						log.info("2] Back");

						try {
							

							register = Integer.parseInt(scanner.nextLine());
							switch (register) 
							{
							
							///////////////////////////////////////////////////////////////////////
							// checking registration
							case 1:
								log.info("========== REGISTRATION PAGE ==========");
								log.info("To registre have following details ready. "
										+ "\n(Username, Password, Firstname, Lastname, Date of Birth, SSN(for Security), and Phone number");
								
								CheckingAccounts userdetails1 = new CheckingAccounts();
								// savings account creation
								log.info("Enter Username: ");
								String username1 = scanner.nextLine();
								log.info("Enter Password: ");
								String userpassword1 = scanner.nextLine();
								String password1 = new SHA256Demo().sha256(userpassword1);
								log.info("Enter Firstname: ");
								String firstname1 = scanner.nextLine();
								log.info("Enter Lastname: ");
								String lastname1 = scanner.nextLine();
								log.info("Enter Date of Birth(MM-DD-YYYY): ");
								String dob1;
								SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
								sdf1.setLenient(false);
								Date date =new Date();
								do {
									while(!(dob1 = scanner.nextLine()).matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")&&sdf1.isLenient()) {
										log.info("Invalid date format entered. Please retry with MM-DD-YYYY ");
									}
									
									
									try {
										
										date = sdf1.parse(dob1);
										
									} catch (ParseException e2) {
										date=null;
										log.info("Invalid date format entered. Please retry with MM-DD-YYYY ");
									}
									
								}while(date == null);
								
								
								
								
								

								log.info("Enter SSN (9 digits only): ");
								long ssn1;
								
		                        while (!("" + (ssn1 = Long.parseLong(scanner.nextLine()))).matches("[0-9]{9}")) {
		                            log.info(
		                                    "SSN should be 9 digits ONLY.");
		                        }
								
								log.info("Enter Phone number (XXXXXXXXXX) : ");
								long phonenumber1;
								while (!("" + (phonenumber1 = Long.parseLong(scanner.nextLine()))).matches("[0-9]{10}")) {
		                            log.info("Wrong Phone number format, please Retry with (XXXXXXXXXX) format:");
		                        }
								/////////////////////////////////////////////////
								try {
								userdetails1 = new CheckingAccounts(username1, password1, firstname1, lastname1,
										date, ssn1, phonenumber1);
								} catch(Exception e) {
									log.info("Account not created");
								}
								MistbankDaoImpl dao = new MistbankDaoImpl();
								try {
									
									userdetails1 = dao.useraccountcreatechecking(userdetails1);
								} catch (BusinessException e) {
									log.info("Registration unsuccessful Username already exits");
								}

								if (userdetails1.getSerialnum() != 0) {
									log.info("Account registered successfully with following details");
									log.info(userdetails1);
								}else {
									log.info("Registraion Unsuccessful. Please contact the bank respresetative");
								}
								log.info("Under Construction");
								break;
							case 2:
								ch = 2;
								break;
							default:
								log.info("Please select proper selection");
								break;
							}
						} catch (NumberFormatException e) {

							log.info("Choices should be number(1-3) Only");

						}

					} while (register != 2);

					break;
				case 3:
					log.info("Thank you for your visit.");
					break;
				default:
					log.info("Please Select appropriate Banking option.");
					break;
				}
			} catch (NumberFormatException e) {
				log.info("Choices should be number(1-3) ONLY");

			}

		} while (ch != 3);

		scanner.close();

	}

}
