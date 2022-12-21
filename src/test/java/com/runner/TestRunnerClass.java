package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@CucumberOptions(tags=(""),
				features="src\\test\\resources\\Features",
				glue="com.stepdefinition",
				snippets=SnippetType.CAMELCASE,
				plugin= {"pretty","json:target\\output.json"},
				dryRun=false,
				monochrome=true
				)
@RunWith(Cucumber.class)
public class TestRunnerClass extends BaseClass{
	
	@AfterClass
	
	public static void afterClass() throws IOException{
		Reporting.generateJVMReport(getProjectPath()+getPropertyFileValue("jsonpath"));
	}
	
	
	
	








	

}
