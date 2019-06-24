package model;

public class TestModel 
{
	int testId;
	String testName;
	int testNum;
	String testCate;
	String testDate;
	
	public TestModel() {}
	
	public TestModel(int testId, String testName, int testNum, String testCate, String testDate) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.testNum = testNum;
		this.testCate = testCate;
		this.testDate = testDate;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getTestNum() {
		return testNum;
	}

	public void setTestNum(int testNum) {
		this.testNum = testNum;
	}

	public String getTestCate() {
		return testCate;
	}

	public void setTestCate(String testCate) {
		this.testCate = testCate;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	@Override
	public String toString() {
		return "TestModel [testId=" + testId + ", testName=" + testName + ", testNum=" + testNum + ", testCate="
				+ testCate + ", testDate=" + testDate + "]";
	}
	
	
}
