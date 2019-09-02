package com.mistbank.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mistbank.dao.impl.MistbankDaoImpl;
import com.mistbank.exceptions.BusinessException;
import com.mistbank.model.SavingAccounts;
import com.mistbank.service.SHA256Demo;

public class MistbankMain {

	private static final Logger log = Logger.getLogger(MistbankMain.class);

	public static void main(String[] args) throws BusinessException {

		Scanner scanner = new Scanner(System.in);

		log.info("              Welcome to MistBank V1.0              ");
		log.info("====================================================");
		int ch = 0;

		do {
			log.info("Your Banking Options");
			log.info("1] Login");
			log.info("2] Register");
			log.info("3] EXIT");
			log.info("Above are you choices(1-3) ");

			try {
				ch = Integer.parseInt(scanner.nextLine());
				// Login
				switch (ch) {
				case 1:
				log.info("Please enter your Login details");
				log.info("Username: ");
				String username = scanner.nextLine();
				log.info("Password: ");
				String password = scanner.nextLine();
				if(username != null && password !=null) {
					int logout = 0;
					do {
						log.info("You have logged in successfully!");
						log.info("Enter to see the details");
						log.info("1] Savings");
						log.info("2] Checkings");
						log.info("3] Logout");
						int acct = 0;
						switch(acct) {
						case 1:
							break;
						case 2:
							break;
						case 3:
							break;
						default:
							break;
						}
						
					}while(logout!=3);
				}
					log.info("Under Construction");
					break;

				//////////// Register
				case 2:
					int register = 0;
					do {
					log.info("Thank you for chosing MistBank");
					log.info("Which account do you want to create: ");
					log.info("1] Savings");
					log.info("2] Checking");
					log.info("3] Back");
					
					

						try {

							register = Integer.parseInt(scanner.nextLine());
							switch (register) {
							case 1:
								SavingAccounts userdetails = new SavingAccounts();
								// savings account creation
								log.info("Enter Username: ");
								String username = scanner.nextLine();
								log.info("Enter Password: ");
								String userpassword = scanner.nextLine();
								String password = new SHA256Demo().sha256(userpassword);
								log.info("Enter Firstname: ");
								String firstname = scanner.nextLine();
								log.info("Enter Lastname: ");
								String lastname = scanner.nextLine();
								log.info("Enter Date of Birth: ");
								String dob = scanner.nextLine();
								SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

								log.info("Enter SSN: ");
								long ssn = Long.parseLong(scanner.nextLine());
								log.info("Enter Phone number: ");
								long phonenumber = Long.parseLong(scanner.nextLine());
								/////////////////////////////////////////////////

								try {
									userdetails = new SavingAccounts(username, password, firstname, lastname,
											sdf.parse(dob), ssn, phonenumber);

								} catch (ParseException e) {
									log.info("Invalid date Entered");
								}

								MistbankDaoImpl dao = new MistbankDaoImpl();
								userdetails = dao.useraccountcreatesavings(userdetails);
							
									if (userdetails.getSerialnum() != 0) {
										log.info("Account registered successfully with following details");
										log.info(userdetails);
									}
									
								break;
							case 2:
								log.info("Under Construction");
								break;
							case 3:
								log.info("Under Construction");
								break;
							default:
								log.info("Please select proper selection");
								break;
							}
						} catch (NumberFormatException e) {
							log.info("Choices should be number(1-3) Only"+e);
							
						}
						
						
					} while (register != 3);

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
