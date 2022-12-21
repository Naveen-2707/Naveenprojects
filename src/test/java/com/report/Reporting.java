package com.report;
	import java.io.File;
	import java.util.ArrayList;
	import java.util.List;

	import net.masterthought.cucumber.Configuration;
	import net.masterthought.cucumber.ReportBuilder;


	public class Reporting {
		
		public static void generateJVMReport(String jsonfile) {

			
	File file = new File("C:\\Users\\Naveen\\eclipse-workspace\\OMRBranchAdactinAutomation\\target");

			
			Configuration configure = new Configuration(file, "Adaction Hotel App Automation");
			
			
			configure.addClassifications("Browser", "Chrome");
			configure.addClassifications("Verison", "108");
			configure.addClassifications("OS", "WINDOWS - 11");
			configure.addClassifications("Sprint", "32");
			
			
			List<String> jsonfiles = new ArrayList<String>();
			
			
	jsonfiles.add(jsonfile);


	ReportBuilder builder = new ReportBuilder(jsonfiles, configure);

	builder.generateReports();


		}

	}






