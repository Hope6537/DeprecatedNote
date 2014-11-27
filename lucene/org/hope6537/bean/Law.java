package org.hope6537.bean;

import java.util.List;

public class Law {

	private String lawId;
	private String title;
	private String promulgationOrganId;
	private String promulgationDate;
	private String implementDate;
	private String activeTime;
	private String fileNo;
	private String issuedNo;
	private String subjectClass;
	private String issuedOrganId;
	private String formalFile;
	private String content;
	private List<String> promulgationOrganList;
	private List<String> issuedOrganList;

	public String getLawId() {
		return lawId;
	}

	public void setLawId(String lawId) {
		this.lawId = lawId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPromulgationDate() {
		return promulgationDate;
	}

	public void setPromulgationDate(String promulgationDate) {
		this.promulgationDate = promulgationDate;
	}

	public String getImplementDate() {
		return implementDate;
	}

	public void setImplementDate(String implementDate) {
		this.implementDate = implementDate;
	}

	public String getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}

	public String getFileNo() {
		return fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public String getIssuedNo() {
		return issuedNo;
	}

	public void setIssuedNo(String issuedNo) {
		this.issuedNo = issuedNo;
	}

	public String getSubjectClass() {
		return subjectClass;
	}

	public void setSubjectClass(String subjectClass) {
		this.subjectClass = subjectClass;
	}

	public String getFormalFile() {
		return formalFile;
	}

	public void setFormalFile(String formalFile) {
		this.formalFile = formalFile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getPromulgationOrganList() {
		return promulgationOrganList;
	}

	public void setPromulgationOrganList(List<String> promulgationOrganList) {
		this.promulgationOrganList = promulgationOrganList;
	}

	public List<String> getIssuedOrganList() {
		return issuedOrganList;
	}

	public void setIssuedOrganList(List<String> issuedOrganList) {
		this.issuedOrganList = issuedOrganList;
	}

	public String getPromulgationOrganId() {
		return promulgationOrganId;
	}

	public void setPromulgationOrganId(String promulgationOrganId) {
		this.promulgationOrganId = promulgationOrganId;
	}

	public String getIssuedOrganId() {
		return issuedOrganId;
	}

	public void setIssuedOrganId(String issuedOrganId) {
		this.issuedOrganId = issuedOrganId;
	}

	@Override
	public String toString() {
		return "Law [title=" + title + ", content=" + content + "]";
	}

}
