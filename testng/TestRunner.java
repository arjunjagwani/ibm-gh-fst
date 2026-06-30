package testRunner;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;

import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
  key = Constants.GLUE_PROPERTY_NAME, value = "stepDefinitions"
)
//@ConfigurationParameter(
//  key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@activity2"
//)
//@ConfigurationParameter(
//		  key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@activity3"
//)
//@ConfigurationParameter(
//		  key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@activity4"
//)

@ConfigurationParameter(
		  key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@activity6"
)
//@ConfigurationParameter(
//		key = Constants.PLUGIN_PROPERTY_NAME,
//		value = "pretty, html:test-output/Reports/HTML_Report.html, junit:test-output/Reports/XML_Report.xml, json:test-output/Reports/JSON_Report.json"
//	)
public class TestRunner {}