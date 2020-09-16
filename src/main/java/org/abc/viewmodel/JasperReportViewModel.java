package org.abc.viewmodel;


import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

import org.abc.domain.ReportType;
import org.abc.utils.ReportConfig;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.ListModelList;

public class JasperReportViewModel {

	ReportType reportType = null;
	private ReportConfig reportConfig = null;
	
	private ListModelList<ReportType> reportTypesModel = new ListModelList<ReportType>(
			Arrays.asList(
					new ReportType("PDF", "pdf"), 
					new ReportType("HTML", "html"), 
					new ReportType("Word (RTF)", "rtf"), 
					new ReportType("Excel", "xls"), 
					new ReportType("Excel (JXL)", "jxl"), 
					new ReportType("CSV", "csv"), 
					new ReportType("OpenOffice (ODT)", "odt")));

	@WireVariable
	private Iframe iframeZ;
	@Command("showImg")
	public void showImg() throws FileNotFoundException {
		File file = new File("/images/banner.jpg");
		InputStream mediais = new FileInputStream(file);
		AMedia media = new AMedia("SalesOrder.jpg", "jpg", "application/img", mediais);
		iframeZ.setContent(media);
	}
	
	@Command("showPdf")
	public void showPdf() throws FileNotFoundException {
		File file = new File("C:\\Users\\Usuario\\Downloads\\1_5073455175239206569.pdf");
		InputStream mediais = new FileInputStream(file);
		System.out.println(mediais.toString());
		AMedia media = new AMedia("SalesOrder.pdf", "pdf", "application/pdf", mediais);
		System.out.println("____"+media.getName());
		iframeZ.setContent(media);
	}
	@Command("showReport")
	@NotifyChange("reportConfig")
	public void showReport() {
		reportConfig = new ReportConfig();
		reportConfig.setType(reportType);
//		reportConfig.setDataSource(new CustomDataSource());
//		
//		ByteArrayOutputStream bytesOutputStream = new ByteArrayOutputStream();
//		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(bytesOutputStream);
//
//		JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
//		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, bufferedOutputStream);
//		exporter.exportReport();
//
//		InputStream mediais = new ByteArrayInputStream(bytesOutputStream.toByteArray());
//		bytesOutputStream.close();
//
//		AMedia amedia = new AMedia("SalesOrder" + salesOrder.getId() + ".pdf", "pdf", "application/pdf", mediais);
//
//		iframeReport.setContent(amedia);
	}
	
	public ListModelList<ReportType> getReportTypesModel() {
		return reportTypesModel;
	}

	public ReportConfig getReportConfig() {
		return reportConfig;
	}
	
	public ReportType getReportType() {
		return reportType;
	}

	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}
}
